#!/usr/bin/env python3
"""Third repair round: synthetic marker classes, visibility and catch-parameter clashes."""
import os, re, subprocess, collections

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')
SMALI = os.path.join(ROOT, 'tmp', 'analysis', '2026-11-01', 'apktool_src', 'smali')
ERRLOG = '/tmp/ggjc_err.log'


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
                 symbol=None, loc=None, src='')
        if i + 2 < len(lines) and lines[i + 1].strip() and '^' in lines[i + 2]:
            e['src'] = lines[i + 1]
            e['col'] = lines[i + 2].index('^') + 1
        j = i + 3
        while j < len(lines) and not re.match(r'^[^:]+\.java:\d+: error:', lines[j]):
            ms = re.match(r'\s*symbol:\s+(.*)$', lines[j])
            ml = re.match(r'\s*location:\s+(.*)$', lines[j])
            if ms: e['symbol'] = ms.group(1).strip()
            if ml: e['loc'] = ml.group(1).strip()
            j += 1
        errs.append(e)
        i = j
    return errs


def find_class_file(name, pkg=None):
    for dirpath, _d, names in os.walk(SRC):
        if name + '.java' in names:
            return os.path.join(dirpath, name + '.java')
    return None


def gen_marker_classes():
    """dex stores 'abstract synthetic' marker classes for the synthetic
    constructors; recreate them so the generated code compiles."""
    made = 0
    for dirpath, _d, names in os.walk(SMALI):
        rel = os.path.relpath(dirpath, SMALI)
        pkg = '' if rel == '.' else rel.replace(os.sep, '.')
        for n in names:
            if not n.endswith('.smali'):
                continue
            p = os.path.join(dirpath, n)
            head = open(p, encoding='utf-8', errors='replace').read(400)
            if not head.startswith('.class abstract synthetic'):
                continue
            cls = n[:-6]
            out = os.path.join(SRC, pkg.replace('.', os.sep), cls + '.java')
            if os.path.exists(out):
                continue
            os.makedirs(os.path.dirname(out), exist_ok=True)
            with open(out, 'w', encoding='utf-8') as fh:
                fh.write('package %s;\n\n' % pkg)
                fh.write('/* synthetic marker class: dex keeps an empty "abstract synthetic"\n')
                fh.write('   class for the synthetic constructors that hand the enclosing\n')
                fh.write('   instance over.  Recreated here so the sources compile. */\n')
                fh.write('abstract class %s {\n}\n' % cls)
            made += 1
    return made


def fix_double_rename():
    """'gg_x' + 'g_y' -> 'gg_y' (a package name renamed twice)."""
    n = 0
    pat = re.compile(r'gg_([a-g])g_([a-g])')
    for dirpath, _d, names in os.walk(SRC):
        for name in names:
            if not name.endswith('.java'):
                continue
            p = os.path.join(dirpath, name)
            s = open(p, encoding='utf-8').read()
            s2 = pat.sub(lambda m: 'gg_' + m.group(2), s)
            if s2 != s:
                open(p, 'w', encoding='utf-8').write(s2)
                n += 1
    return n


def main():
    print('marker classes created:', gen_marker_classes())
    print('double renames fixed in files:', fix_double_rename())

    errs = parse_errors()
    stats = collections.Counter()

    # --- make a class public when another package needs it ---------------------
    for e in errs:
        m = re.match(r'^(\S+) is not public in (\S+); cannot be accessed from outside package$', e['msg'])
        if not m:
            continue
        cls = m.group(1)
        f = find_class_file(cls)
        if not f:
            continue
        lines = read(f)
        for i, l in enumerate(lines):
            if re.match(r'^\s*(public\s+)?(abstract\s+)?(final\s+)?class\s+' + re.escape(cls) + r'\b', l) \
                    and not l.strip().startswith('public'):
                lines[i] = re.sub(r'^(\s*)((?:abstract\s+|final\s+)*)(class\s+)', r'\1public \2\3', l, count=1)
                stats['made_public'] += 1
                break
        write(f, lines)

    # --- catch parameter clashes with a declared local -------------------------
    for e in errs:
        m = re.match(r'^variable (\w+) is already defined in method ', e['msg'])
        if not m:
            continue
        var = m.group(1)
        path = e['file'] if os.path.isabs(e['file']) else os.path.join(SRC, e['file'])
        if not path.startswith(SRC) or not os.path.exists(path):
            continue
        lines = read(path)
        changed = False
        for i, l in enumerate(lines):
            cm = re.search(r'catch\s*\(([\w.$]+)\s+' + re.escape(var) + r'\)', l)
            if not cm:
                continue
            newname = var + '_c'
            lines[i] = l[:cm.start()] + cm.group(0).replace(re.escape(var) + ')', re.escape(newname) + ')') + l[cm.end():]
            # rename the uses inside the catch block
            depth = 0
            for k in range(i, len(lines)):
                depth += lines[k].count('{') - lines[k].count('}')
                if k > i and depth <= 0:
                    break
                body = re.sub(r'(?<![\w$.])' + re.escape(var) + r'(?![\w$])', newname, lines[k])
                if body != lines[k]:
                    lines[k] = body
                    changed = True
            stats['catch_param_renamed'] += 1
            break
        if changed:
            write(path, lines)

    for k, v in stats.most_common():
        print('  %s: %d' % (k, v))
    print('done')


if __name__ == '__main__':
    main()
