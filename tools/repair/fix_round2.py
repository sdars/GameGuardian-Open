#!/usr/bin/env python3
"""Second repair round for the flattened GameGuardian source tree.

Handles the structural artefacts jadx leaves behind when it flattens a dex
into one Java file per class:

  * references to the obfuscated packages a..g (renamed to gg_a..gg_g),
  * inner classes that touch private members of their outer class,
  * locals whose declaration jadx dropped (catch variables, casts),
  * raw Comparator/Comparable implementations (bridge methods were merged),
  * 'throws' clauses that the original dex does not allow,
  * 'protected'/'private' on top level classes,
  * android.R.style.Theme_* constants.
"""
import os, re, sys, collections

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')
ERRLOG = '/tmp/ggjc_err.log'
PKG_RENAME = {'a': 'gg_a', 'b': 'gg_b', 'c': 'gg_c', 'd': 'gg_d',
              'e': 'gg_e', 'f': 'gg_f', 'g': 'gg_g'}


def read(p):
    return open(p, encoding='utf-8').read().split('\n')


def write(p, lines):
    open(p, 'w', encoding='utf-8').write('\n'.join(lines))


def parse_errors():
    errs = []
    lines = open(ERRLOG, encoding='utf-8', errors='replace').read().split('\n')
    i = 0
    while i < len(lines):
        m = re.match(r'^(?P<file>/?[^:]+\.java):(?P<line>\d+): error: (?P<msg>.*)$', lines[i])
        if not m:
            i += 1
            continue
        e = dict(file=m.group('file'), line=int(m.group('line')), msg=m.group('msg'), col=None,
                 symbol=None, loc=None, src='', extra=[])
        if i + 2 < len(lines) and lines[i + 1].strip() and '^' in lines[i + 2]:
            e['src'] = lines[i + 1]
            e['col'] = lines[i + 2].index('^') + 1
        j = i + 3
        while j < len(lines) and not re.match(r'^[^:]+\.java:\d+: error:', lines[j]):
            ms = re.match(r'\s*symbol:\s+(.*)$', lines[j])
            ml = re.match(r'\s*location:\s+(.*)$', lines[j])
            if ms: e['symbol'] = ms.group(1).strip()
            if ml: e['loc'] = ml.group(1).strip()
            if lines[j].strip() and not lines[j].startswith(' ' * 8):
                e['extra'].append(lines[j].strip())
            elif lines[j].strip() and not ms and not ml:
                e['extra'].append(lines[j].strip())
            j += 1
        errs.append(e)
        i = j
    return errs


METHOD_RE = re.compile(r'^\s*(?:(?:public|private|protected|static|final|synchronized|native|abstract|default)\s+)*(?:[\w.$<>\[\],?\s]+?)\s+(\w+)\s*\([^;]*$')


def method_key(lines, idx):
    """Identify the method a line belongs to (used to de-duplicate declarations)."""
    for k in range(idx, -1, -1):
        m = METHOD_RE.match(lines[k])
        if m:
            return (k, m.group(1))
    return (0, '?')


def find_class_file(name):
    for dirpath, _d, names in os.walk(SRC):
        if name + '.java' in names:
            return os.path.join(dirpath, name + '.java')
    return None


def main():
    errs = parse_errors()
    stats = collections.Counter()
    edits = collections.defaultdict(list)      # path -> [(line, col, old, new)]
    inserts = collections.defaultdict(list)    # path -> [(line, text)]
    decls = collections.defaultdict(list)      # path -> [(try_line, var, type)]

    for e in errs:
        msg = e['msg']
        path = e['file'] if os.path.isabs(e['file']) else os.path.join(SRC, e['file'])
        if not path.startswith(SRC) or not os.path.exists(path):
            continue

        # --- 1) references to the renamed packages -------------------------------
        m = re.match(r'^package (\w+) does not exist$', msg)
        if m and m.group(1) in PKG_RENAME:
            old = m.group(1)
            lines = read(path)
            s = lines[e['line'] - 1]
            col = (e['col'] or 1) - 1
            idx = col if 0 <= col < len(s) and s[col] == old else -1
            if idx < 0:                      # fall back: the segment right before a dot
                for mm2 in re.finditer(r'(?<![\w$.])' + old + r'(?=\.)', s):
                    idx = mm2.start()
                    break
            if idx >= 0:
                edits[path].append((e['line'], idx, idx + len(old), PKG_RENAME[old]))
                stats['pkg_rename'] += 1
            continue

        # --- 2) private members of the outer class --------------------------------
        m = re.match(r'^(?:\S+ )?(\S+) has private access in (\S+)$', msg)
        if m:
            member, owner = m.group(1), m.group(2)
            member = member.split('(')[0]
            owner_file = find_class_file(owner)
            if owner_file:
                lines = read(owner_file)
                pat_field = re.compile(r'^(\s*)(private\s+)(.*\b' + re.escape(member) + r'\b.*)$')
                pat_meth = re.compile(r'^(\s*)(private\s+)(.*\b' + re.escape(member) + r'\s*\(.*)$')
                for i, l in enumerate(lines):
                    mm = pat_meth.match(l) or pat_field.match(l)
                    if mm:
                        lines[i] = mm.group(1) + mm.group(3)
                        edits[owner_file].append((i + 1, 0, 0, ''))   # marker: rewrite whole line
                        edits[owner_file][-1] = ('LINE', i + 1, lines[i], None)
                        stats['private_relaxed'] += 1
                        break
                write(owner_file, lines)
            continue

        # --- 3) locals whose declaration jadx dropped -----------------------------
        if msg == 'cannot find symbol' and (e['symbol'] or '').startswith('variable '):
            var = e['symbol'].split(' ', 1)[1]
            lines = read(path)
            src_line = lines[e['line'] - 1]
            mm = re.match(r'^(\s*)' + re.escape(var) + r'\s*=\s*(.+);\s*$', src_line)
            if not mm:
                continue
            rhs = mm.group(2)
            vtype = None
            cm = re.match(r'^\(([\w.$]+)\)\s', rhs)
            if cm:
                vtype = cm.group(1)
            else:
                rm = re.match(r'^(\w+)$', rhs.strip())
                if rm:
                    # find the enclosing catch clause and use its type
                    depth = 0
                    for k in range(e['line'] - 2, -1, -1):
                        l = lines[k]
                        if '}' in l:
                            depth += l.count('}')
                        if '{' in l:
                            depth -= l.count('{')
                        cm = re.search(r'catch\s*\(([\w.$]+)\s+' + re.escape(rm.group(1)) + r'\)', l)
                        if cm:
                            vtype = cm.group(1)
                            break
                        if depth < 0:
                            break
            if vtype is None:
                vtype = 'java.lang.Throwable'
            # locate the enclosing try statement
            depth = 0
            try_line = None
            for k in range(e['line'] - 2, -1, -1):
                l = lines[k]
                if '}' in l:
                    depth += l.count('}')
                if '{' in l:
                    depth -= l.count('{')
                if re.search(r'\btry\s*\{', l) and depth <= 0:
                    try_line = k
                    break
                if depth < 0:
                    break
            anchor = try_line if try_line is not None else e['line'] - 1
            indent = re.match(r'^(\s*)', lines[anchor]).group(1)
            decls[path].append((anchor, var, vtype, indent, method_key(lines, e['line'] - 1)))
            stats['var_decl'] += 1
            continue

        # --- 4) raw Comparator / Comparable ---------------------------------------
        if 'does not override abstract method' in msg and (' in Comparator' in msg or ' in Comparable' in msg):
            lines = read(path)
            head = lines[e['line'] - 1]
            m2 = re.search(r'implements\s+(java\.util\.(?:Comparator|Comparable))\b', head)
            if m2:
                iface = m2.group(1)
                arg = None
                for l in lines[e['line']:]:
                    if iface.endswith('Comparator'):
                        cm = re.search(r'\bcompare\s*\(\s*([\w.$]+)\s+\w+\s*,', l)
                    else:
                        cm = re.search(r'\bcompareTo\s*\(\s*([\w.$]+)\s+\w+\s*\)', l)
                    if cm:
                        arg = cm.group(1)
                        break
                if arg:
                    new = head.replace(m2.group(0), m2.group(0) + '<' + arg + '>')
                    edits[path].append(('LINE', e['line'], new, None))
                    stats['generic_iface'] += 1
            continue

        # --- 5) throws clause the dex does not allow ------------------------------
        if 'cannot implement' in msg and 'overridden method does not throw' in ' '.join(e['extra']):
            lines = read(path)
            head = lines[e['line'] - 1]
            new = re.sub(r'\s+throws\s+[\w.$]+(?:\s*,\s*[\w.$]+)*', '', head, count=1)
            if new != head:
                edits[path].append(('LINE', e['line'], new, None))
                stats['throws_removed'] += 1
            continue

        # --- 6) protected/private on a top level class ----------------------------
        if msg == 'modifier protected not allowed here' or msg == 'modifier private not allowed here':
            lines = read(path)
            head = lines[e['line'] - 1]
            new = re.sub(r'^(\s*)(protected|private)\s+', r'\1', head, count=1)
            if new != head:
                edits[path].append(('LINE', e['line'], new, None))
                stats['modifier_dropped'] += 1
            continue

        # --- 7) android.R.style.Theme_* ------------------------------------------
        if msg == 'int cannot be dereferenced' and 'android.R.style.Theme.' in e['src']:
            new = e['src'].replace('android.R.style.Theme.', 'android.R.style.Theme_')
            edits[path].append(('LINE', e['line'], new, None))
            stats['r_theme'] += 1
            continue

    # apply edits
    for path, es in edits.items():
        lines = read(path)
        for item in es:
            if item[0] == 'LINE':
                lines[item[1] - 1] = item[2]
            else:
                ln, st, en, new = item
                s = lines[ln - 1]
                if s[st:en] == old if False else True:
                    lines[ln - 1] = s[:st] + new + s[en:]
        write(path, lines)

    # apply declarations (one per try/variable)
    for path, ds in decls.items():
        lines = read(path)
        seen = set()
        for try_line, var, vtype, indent, mkey in sorted(ds, key=lambda t: -t[0]):
            key = (mkey, var)
            if key in seen:
                continue
            seen.add(key)
            lines.insert(try_line, '%s%s %s = null;' % (indent, vtype, var))
        write(path, lines)

    for k, v in stats.most_common():
        print('  %s: %d' % (k, v))
    print('done')


if __name__ == '__main__':
    main()
