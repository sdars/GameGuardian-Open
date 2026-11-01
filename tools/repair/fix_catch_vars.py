#!/usr/bin/env python3
"""Rebuild jadx's shared catch-variable model into valid Java.

In the original dex every catch handler of a method stores the exception in
the *same* register.  jadx models that register as a Java variable named after
the first handler ("th", "e", ...) and renames the later handler parameters
to th2/th3/e2/e3/... .  To keep the shared register visible it then emits
"th = th2;" inside the later handlers - but the Java variable "th" only
exists inside the scope of the *first* handler, so the decompiled code does
not compile ("cannot find symbol: variable th").

This script restores the register model:

  * a handler parameter whose name collides with the shared register is renamed
    (th -> th_c) together with its uses,
  * the shared register becomes a method level local
    ("java.lang.Throwable th = null;").

The result keeps the original semantics: the shared local holds the exception
of the handler that ran last, exactly like the dex register did.
"""
import os
import re

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')

CATCH_RE = re.compile(r'catch\s*\(([^)]*)\)\s*\{')
IDENT = re.compile(r'[A-Za-z_$][\w$]*')
CLASS_RE = re.compile(r'(?:^|[^\w$])(?:class|interface|enum)\s+[\w$]+[^;{}]*$')
NEW_RE = re.compile(r'new\s+[\w.$<>,\s]+\([^;{}]*\)\s*$')
# "Type name;" / "Type name = ..." at the start of a line.  Java keywords that
# start a statement ("throw e;") must not be mistaken for a type.
KEYWORDS = ('throw', 'return', 'new', 'case', 'break', 'continue', 'else', 'do',
            'while', 'for', 'if', 'switch', 'catch', 'finally', 'try', 'assert',
            'synchronized', 'instanceof', 'default', 'goto', 'this', 'super')
LOCAL_RE = re.compile(
    r'(?m)^[ \t]*(?!(?:' + '|'.join(KEYWORDS) + r')\b)'
    r'(?:[\w.$]+(?:<[^<>;=]*>)?(?:\[\])?\s+)+([A-Za-z_$][\w$]*)\s*[;=]')
MARK = '/* gg-shared-throwable */ '
INSERTED_RE = re.compile(
    r'(?m)^[ \t]*/\* gg-shared-throwable \*/ java\.lang\.Throwable '
    r'([A-Za-z_$][\w$]*) = null;$')


def mask(text):
    """Blank out comments and literals so brace matching stays reliable."""
    out = list(text)
    i, n = 0, len(text)
    while i < n:
        c = text[i]
        if c == '/' and i + 1 < n and text[i + 1] == '/':
            j = text.find('\n', i)
            j = n if j < 0 else j
            for k in range(i, j):
                out[k] = ' '
            i = j
        elif c == '/' and i + 1 < n and text[i + 1] == '*':
            j = text.find('*/', i + 2)
            j = n if j < 0 else j + 2
            for k in range(i, j):
                if out[k] != '\n':
                    out[k] = ' '
            i = j
        elif c == '"':
            j = i + 1
            while j < n:
                if text[j] == '\\':
                    j += 2
                    continue
                if text[j] == '"':
                    j += 1
                    break
                j += 1
            for k in range(i, min(j, n)):
                if out[k] != '\n':
                    out[k] = ' '
            i = j
        elif c == "'":
            j = i + 1
            while j < n:
                if text[j] == '\\':
                    j += 2
                    continue
                if text[j] == "'":
                    j += 1
                    break
                j += 1
            for k in range(i, min(j, n)):
                if out[k] != '\n':
                    out[k] = ' '
            i = j
        else:
            i += 1
    return ''.join(out)


def build_tree(masked):
    """Return the list of brace blocks with parent links."""
    stack, nodes = [], []
    for i, c in enumerate(masked):
        if c == '{':
            node = {'open': i, 'close': None, 'parent': stack[-1] if stack else None}
            nodes.append(node)
            stack.append(node)
        elif c == '}':
            if stack:
                node = stack.pop()
                node['close'] = i
    return nodes


def is_class_body(masked, node):
    head = masked[max(0, node['open'] - 300):node['open']]
    return bool(CLASS_RE.search(head) or NEW_RE.search(head))


def method_of(nodes, node):
    """Nearest ancestor block that is a method (or initializer) body."""
    cur = node
    while cur is not None:
        parent = cur['parent']
        if parent is None:
            return cur
        if is_class_body(masked_global, parent):
            return cur
        cur = parent
    return node


def process(path):
    global masked_global
    text = open(path, encoding='utf-8').read()
    masked_global = mask(text)
    masked = masked_global
    # The declaration this script inserts must not be mistaken for a local
    # jadx declared - blank it out before the locals are collected.
    _blanked = list(masked)
    for _m in INSERTED_RE.finditer(text):
        for _k in range(_m.start(), _m.end()):
            if _blanked[_k] != '\n':
                _blanked[_k] = ' '
    masked_no_ins = ''.join(_blanked)
    nodes = build_tree(masked)
    by_open = {nd['open']: nd for nd in nodes}

    # ---- undo an earlier insertion that duplicated an existing local ----
    # The declaration this script adds is written without indentation, which
    # makes it easy to recognise.  When the method already declares the same
    # name the declaration is redundant and java reports
    # "variable th is already defined" - drop the inserted one.
    drop_lines = set()
    for m in INSERTED_RE.finditer(text):
        name = m.group(1)
        # find the innermost block that contains this line
        pos = m.start()
        owner = None
        for nd in nodes:
            if nd['open'] < pos < nd['close']:
                if owner is None or nd['open'] > owner['open']:
                    owner = nd
        if owner is None:
            continue
        mbody = masked_no_ins[owner['open']:owner['close']]
        if name in set(LOCAL_RE.findall(mbody)):
            drop_lines.add(text.count('\n', 0, m.start()))
    if drop_lines:
        kept = [l for i, l in enumerate(text.split('\n')) if i not in drop_lines]
        text = '\n'.join(kept)
        open(path, 'w', encoding='utf-8').write(text)
        masked = mask(text)
        _blanked = list(masked)
        for _m in INSERTED_RE.finditer(text):
            for _k in range(_m.start(), _m.end()):
                if _blanked[_k] != '\n':
                    _blanked[_k] = ' '
        masked_no_ins = ''.join(_blanked)
        nodes = build_tree(masked)
        by_open = {nd['open']: nd for nd in nodes}
        masked_global = masked
    clauses = []
    for m in CATCH_RE.finditer(masked):
        ids = IDENT.findall(m.group(1))
        if not ids:
            continue
        brace = masked.rfind('{', 0, m.end())
        node = by_open.get(brace)
        if node is None or node['close'] is None:
            continue
        name = ids[-1]
        decl_pos = m.start(1) + m.group(1).rfind(name)
        clauses.append({'name': name, 'open': node['open'], 'close': node['close'],
                        'node': node, 'decl': decl_pos})
    if not clauses:
        return 0

    groups = {}
    for c in clauses:
        mnode = method_of(nodes, c['node'])
        groups.setdefault(mnode['open'], (mnode, []))[1].append(c)

    ops = []
    for _key, (method, cs) in groups.items():
        mbody = masked_no_ins[method['open']:method['close']]
        mbody_full = masked[method['open']:method['close']]
        # locals jadx already declared in the method body: a catch parameter
        # may not shadow one of them and a second declaration of the shared
        # register would be a "variable already defined" error.
        declared = set(LOCAL_RE.findall(mbody))
        shared = set()
        for c in cs:
            body = masked[c['open']:c['close']]
            for m2 in re.finditer(r'([A-Za-z_$][\w$]*)\s*=\s*([A-Za-z_$][\w$]*)\s*;', body):
                lhs, rhs = m2.group(1), m2.group(2)
                if lhs != rhs and rhs == c['name']:
                    shared.add(lhs)
        collide = {c['name'] for c in cs} & declared
        if not shared and not collide:
            continue
        used = set()
        rename = {}
        for c in cs:
            if c['name'] in shared or c['name'] in collide:
                new = c['name'] + '_c'
                k = 2
                while new in used:
                    new = '%s_c%d' % (c['name'], k)
                    k += 1
                used.add(new)
                rename[c['open']] = new
                ops.append((c['decl'], len(c['name']), new))
        for c in cs:
            if c['open'] not in rename:
                continue
            new = rename[c['open']]
            body = masked[c['open']:c['close']]
            for m2 in IDENT.finditer(body):
                if m2.group(0) != c['name']:
                    continue
                s = c['open'] + m2.start()
                e = c['open'] + m2.end()
                after = masked[e:e + 40]
                if re.match(r'\s*=[^=]', after):
                    continue      # left hand side: keep the shared register
                ops.append((s, e - s, new))
        # declare the shared register(s) at the top of the method body
        body_start = method['open'] + 1
        nl = text.find('\n', body_start)
        if nl < 0:
            continue
        indent = re.match(r'[ \t]*', text[body_start:nl]).group(0)
        decl = ''
        for x in sorted(shared):
            if x in declared:
                continue
            if re.search(r'java\.lang\.Throwable\s+' + re.escape(x) + r'\s*=', mbody_full):
                continue
            decl += '%s%sjava.lang.Throwable %s = null;\n' % (indent, MARK, x)
        if decl:
            ops.append((nl + 1, 0, decl))

    if not ops:
        return 0
    out = text
    for pos, ln, rep in sorted(ops, key=lambda t: (-t[0], -t[1])):
        if ln and out[pos:pos + ln] != text[pos:pos + ln]:
            continue
        out = out[:pos] + rep + out[pos + ln:]
    if out != text:
        open(path, 'w', encoding='utf-8').write(out)
        return 1
    return 0


def main():
    n = 0
    for dirpath, _dirs, names in os.walk(SRC):
        for nm in names:
            if nm.endswith('.java'):
                p = os.path.join(dirpath, nm)
                try:
                    n += process(p)
                except Exception as exc:
                    print('skip', os.path.relpath(p, ROOT), exc)
    print('files changed:', n)


if __name__ == '__main__':
    main()
