#!/usr/bin/env python3
"""Split java methods that do not fit into the 64k bytecode limit of a class file.

The ARM disassembler of android.ext.m is a single method with more than fifty
thousand lines of code.  The class file format limits the code of one method
to 65535 bytes, so the method has to be cut into pieces.

The cut does not change the logic:

  * every local of the method becomes a field of a small state class,
  * a "return" inside the method stores its value in the state, marks the
    state as finished and leaves the method - the caller stops as soon as
    the state says so,
  * nested blocks are moved into methods of their own.  The call site keeps
    the condition and stops when the moved block returned,
  * a big switch is cut into groups of cases, every group gets a method of
    its own and the switch is replaced by a dispatch over the case values.

The result is source compatible with the original method, the generated
bytecode is identical apart from the field accesses.

    python3 tools/repair/split_large_method.py android/ext/m.java g [target]
"""
import os
import re
import sys
import threading

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import java_lexer as JL  # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

STATE = 'ggst'
STATE_CLASS = 'GgState'
PRIMITIVES = set('int long short byte char boolean float double'.split())

DECL_RE = re.compile(
    r'^(?:final\s+)?([A-Za-z_$][\w.$]*(?:<[^>]*>)?(?:\[\])*)\s+'
    r'([A-Za-z_$][\w$]*)\s*(?:=(.*))?$', re.S)

LOOP_HEADERS = ('for', 'while', 'do')
BREAK_HEADERS = ('for', 'while', 'do', 'switch')


class Ctx(object):
    """The source file with a scanner for blocks and statements."""

    def __init__(self, text):
        self.text = text
        self.masked = JL.code_mask(text)
        self.dm = JL.depth_map(text)
        self.blocks = {}
        self.parents = {}
        stack = []
        for i, c in enumerate(self.masked):
            if c == '{':
                stack.append(i)
            elif c == '}':
                o = stack.pop()
                self.blocks[o] = i
                self.parents[o] = stack[-1] if stack else None
        self.block_list = sorted(self.blocks.keys())

    # -- small helpers ----------------------------------------------------
    def ws(self, i, end=None):
        m = self.masked
        if end is None:
            end = len(m)
        while i < end and m[i] in ' \t\r\n':
            i += 1
        return i

    def rws(self, i):
        m = self.masked
        while i >= 0 and m[i] in ' \t\r\n':
            i -= 1
        return i

    def paren(self, i):
        """i points at '(' - return the offset of the matching ')'"""
        m = self.masked
        d = 0
        while i < len(m):
            if m[i] == '(':
                d += 1
            elif m[i] == ')':
                d -= 1
                if d == 0:
                    return i
            i += 1
        return -1

    def word_at(self, i):
        m = self.masked
        j = i
        while j < len(m) and (m[j].isalnum() or m[j] in '_$'):
            j += 1
        return m[i:j], j

    def header(self, open_off):
        """The keyword that introduces the block that starts at open_off."""
        m = self.masked
        j = self.rws(open_off - 1)
        if j < 0:
            return None
        if m[j] == ')':
            k = j
            d = 0
            while k >= 0:
                if m[k] == ')':
                    d += 1
                elif m[k] == '(':
                    d -= 1
                    if d == 0:
                        break
                k -= 1
            k = self.rws(k - 1)
            e = k + 1
            while k >= 0 and (m[k].isalnum() or m[k] in '_$'):
                k -= 1
            return m[k + 1:e]
        if m[j].isalnum() or m[j] in '_$':
            e = j + 1
            while j >= 0 and (m[j].isalnum() or m[j] in '_$'):
                j -= 1
            return m[j + 1:e]
        return None

    def enclosing(self, off):
        """The innermost block that contains off."""
        best = None
        for o in self.block_list:
            if o > off:
                break
            if self.blocks[o] >= off:
                best = o
        return best

    def ancestors(self, off):
        """All blocks that contain off, innermost first."""
        out = []
        b = self.enclosing(off)
        while b is not None:
            out.append(b)
            b = self.parents.get(b)
        return out

    # -- statements -------------------------------------------------------
    def semi(self, i, end):
        """The offset behind the ';' of the statement that starts at i."""
        m = self.masked
        d = 0
        while i < end:
            c = m[i]
            if c in '([{':
                d += 1
            elif c in ')]}':
                d -= 1
            elif c == ';' and d == 0:
                return i + 1
            i += 1
        return end

    def stmt_end(self, i, end):
        """The offset behind the statement that starts at i."""
        m = self.masked
        c = m[i]
        if c == '{':
            return self.blocks[i] + 1
        if c == ';':
            return i + 1
        w, j = self.word_at(i)
        if w == 'if':
            j = self.ws(j, end)
            j = self.paren(j) + 1
            j = self.ws(j, end)
            j = self.stmt_end(j, end)
            k = self.ws(j, end)
            if m[k:k + 4] == 'else':
                k = self.ws(k + 4, end)
                j = self.stmt_end(k, end)
            return j
        if w in ('for', 'while'):
            j = self.ws(j, end)
            j = self.paren(j) + 1
            j = self.ws(j, end)
            return self.stmt_end(j, end)
        if w == 'do':
            j = self.ws(j, end)
            j = self.stmt_end(j, end)
            return self.semi(self.ws(j, end), end)
        if w == 'switch':
            j = self.ws(j, end)
            j = self.paren(j) + 1
            j = self.ws(j, end)
            return self.blocks[j] + 1
        if w == 'synchronized':
            j = self.ws(j, end)
            j = self.paren(j) + 1
            j = self.ws(j, end)
            return self.stmt_end(j, end)
        return self.semi(i, end)

    def stmts(self, start, end):
        """Split [start,end) into a list of (start, end) statement ranges."""
        res = []
        i = start
        while True:
            i = self.ws(i, end)
            if i >= end:
                break
            e = self.stmt_end(i, end)
            if e <= i:
                e = i + 1
            res.append((i, e))
            i = e
        return res


# --------------------------------------------------------------- switches

class SwitchCase(object):
    """One "case X:" or "default:" label of a switch."""

    def __init__(self, label, start, end):
        self.label = label
        self.start = start
        self.end = end


def next_label(ctx, i, bc):
    """The offset of the next case/default label at the level of a switch body."""
    while True:
        i = ctx.ws(i, bc)
        if i >= bc or ctx.masked[i] == '}':
            return bc
        w, j = ctx.word_at(i)
        if w in ('case', 'default'):
            return i
        e = ctx.stmt_end(i, bc)
        if e <= i:
            e = i + 1
        i = e


def parse_switch(ctx, s, e):
    """Returns (expression, [SwitchCase], body_open, body_close)."""
    m = ctx.masked
    w, j = ctx.word_at(s)
    j = ctx.ws(j, e)
    pclose = ctx.paren(j)
    expr = ctx.text[j + 1:pclose]
    bo = ctx.ws(pclose + 1, e)
    bc = ctx.blocks[bo]
    cases = []
    i = ctx.ws(bo + 1, bc)
    while i < bc:
        w2, j2 = ctx.word_at(i)
        if w2 == 'case':
            k = m.find(':', j2)
            label = m[j2:k].strip()
            bstart = ctx.ws(k + 1, bc)
            bend = next_label(ctx, bstart, bc)
            cases.append(SwitchCase(label, bstart, bend))
            i = bend
        elif w2 == 'default':
            k = m.find(':', j2)
            bstart = ctx.ws(k + 1, bc)
            bend = next_label(ctx, bstart, bc)
            cases.append(SwitchCase('default', bstart, bend))
            i = bend
        else:
            break
    return expr, cases, bo, bc


def case_exits(ctx, case):
    """True when the body of the case ends with break/return/throw."""
    body = ctx.text[case.start:case.end].strip()
    if not body:
        return False
    for kw in ('break;', 'return', 'throw'):
        if body.endswith(kw) or body.endswith(kw + ';'):
            return True
    return False


# ---------------------------------------------------------------- builder

class Builder(object):
    """Collects the methods that are created while a method is split."""

    def __init__(self, target):
        self.target = target
        self.methods = []
        self.n = 0

    def new_name(self, prefix='ggPart'):
        self.n += 1
        return '%s%d' % (prefix, self.n)

    def add(self, body, prefix='ggPart'):
        name = self.new_name(prefix)
        self.methods.append((name, body))
        return name

    def add_stmt(self, ctx, s, e, target):
        body = plan_stmt(ctx, s, e, target, self)
        return self.add(body)


def chain_text(names, indent='            ', ret='return;'):
    out = []
    for n in names:
        out.append('%s%s(%s);' % (indent, n, STATE))
        out.append('%sif (%s.stop) %s' % (indent, STATE, ret))
    return '\n'.join(out)


def build_chain(ctx, start, end, target, builder):
    """Cut [start,end) into methods.  The names have to be called in order."""
    stmts = ctx.stmts(start, end)
    groups = []
    cur = []
    cur_size = 0
    for (s, e) in stmts:
        st = ctx.text[s:e]
        if len(st) > target:
            if cur:
                groups.append(('text', ''.join(cur)))
                cur = []
                cur_size = 0
            groups.append(('stmt', s, e))
        else:
            cur.append(st)
            cur_size += len(st)
            if cur_size >= target:
                groups.append(('text', ''.join(cur)))
                cur = []
                cur_size = 0
    if cur:
        groups.append(('text', ''.join(cur)))
    names = []
    for group in groups:
        if group[0] == 'text':
            names.append(builder.add(group[1]))
        else:
            names.append(builder.add_stmt(ctx, group[1], group[2], target))
    return names


def plan_part(ctx, s, e, target, builder):
    """Inline text for one statement that may be too big."""
    txt = ctx.text[s:e]
    if len(txt) <= target:
        return txt
    if ctx.masked[s] == '{':
        names = build_chain(ctx, s + 1, e - 1, target, builder)
        return '{\n%s\n            }' % chain_text(names)
    return plan_stmt(ctx, s, e, target, builder)


def plan_stmt(ctx, s, e, target, builder):
    """Inline text for a statement that does not fit into a method."""
    m = ctx.masked
    w, j = ctx.word_at(s)
    if w == 'if':
        j = ctx.ws(j, e)
        pclose = ctx.paren(j)
        cond = ctx.text[j + 1:pclose]
        then_s = ctx.ws(pclose + 1, e)
        then_e = ctx.stmt_end(then_s, e)
        out = 'if (%s) %s' % (cond, plan_part(ctx, then_s, then_e, target, builder))
        k = ctx.ws(then_e, e)
        if m[k:k + 4] == 'else':
            k = ctx.ws(k + 4, e)
            else_e = ctx.stmt_end(k, e)
            out += ' else %s' % plan_part(ctx, k, else_e, target, builder)
        return out
    if w == 'switch':
        return plan_switch(ctx, s, e, target, builder)
    if w in ('for', 'while', 'do'):
        return plan_loop(ctx, s, e, target, builder)
    raise SystemExit('cannot split statement: ' + ctx.text[s:s + 120])


def plan_loop(ctx, s, e, target, builder):
    """A loop body that is too big is moved into a method of its own."""
    m = ctx.masked
    w, j = ctx.word_at(s)
    if w == 'do':
        body_s = ctx.ws(j, e)
        body_e = ctx.stmt_end(body_s, e)
        head = 'do '
        tail = ctx.text[ctx.ws(body_e, e):e]
    else:
        j = ctx.ws(j, e)
        pclose = ctx.paren(j)
        head = w + ' ' + ctx.text[j:pclose + 1]
        body_s = ctx.ws(pclose + 1, e)
        body_e = ctx.stmt_end(body_s, e)
        tail = ''
    if ctx.masked[body_s] != '{':
        return ctx.text[s:e]
    names = build_chain(ctx, body_s + 1, body_e - 1, target, builder)
    body = '{\n%s\n            }' % chain_text(names)
    return head + ' ' + body + tail


def plan_switch(ctx, s, e, target, builder):
    """Split a big switch into groups of cases."""
    expr, cases, bo, bc = parse_switch(ctx, s, e)
    groups = []
    cur = []
    cur_size = 0
    default = None
    for c in cases:
        if c.label == 'default':
            default = c
        cur.append(c)
        cur_size += len(ctx.text[c.start:c.end])
        if case_exits(ctx, c) and cur_size >= target:
            groups.append(cur)
            cur = []
            cur_size = 0
    if cur:
        groups.append(cur)
    defname = None
    if default is not None:
        # the default body leaves the switch, so its "break" has to become a
        # "return" - the switch of the group does not contain it any more
        parts = []
        for (ss, se) in ctx.stmts(default.start, default.end):
            txt = ctx.text[ss:se]
            if txt.strip() == 'break;':
                txt = 'return;'
            parts.append(txt)
        defname = builder.add(''.join(parts), 'ggDef')
    out = []
    for gi, grp in enumerate(groups):
        parts = []
        for c in grp:
            if c is default:
                parts.append('default: %s(%s); break;' % (defname, STATE))
            else:
                parts.append('case %s:%s' % (c.label, ctx.text[c.start:c.end]))
        body = 'switch (%s) {\n%s\n                }' % (expr, '\n'.join(parts))
        name = builder.add(body, 'ggSw')
        vals = [int(c.label) for c in grp if c.label != 'default']
        if vals:
            vals.sort()
            if vals == list(range(vals[0], vals[0] + len(vals))):
                cond = '(%s >= %d && %s <= %d)' % (expr, vals[0], expr, vals[-1])
            else:
                cond = '(' + ' || '.join('%s == %d' % (expr, v) for v in vals) + ')'
        else:
            cond = 'false'
        out.append((cond, name))
    lines = []
    for i, (cond, name) in enumerate(out):
        lines.append('%sif (%s) {' % ('            ' if i == 0 else '            else ', cond))
        lines.append('                %s(%s);' % (name, STATE))
        lines.append('                if (%s.stop) return;' % STATE)
        lines.append('            }')
    if defname is not None:
        lines.append('            else {')
        lines.append('                %s(%s);' % (defname, STATE))
        lines.append('                if (%s.stop) return;' % STATE)
        lines.append('            }')
    return '\n'.join(lines)


# ------------------------------------------------------- local promotion

class Decl(object):
    def __init__(self, name, typ, start, end, init, in_for):
        self.name = name
        self.typ = typ
        self.start = start
        self.end = end
        self.init = init
        self.in_for = in_for


def split_semis(ctx, start, end):
    """Split a for header at the semicolons on the top level."""
    parts = []
    depth = 0
    i = start
    ps = start
    while i < end:
        c = ctx.masked[i]
        if c in '([':
            depth += 1
        elif c in ')]':
            depth -= 1
        elif c == ';' and depth == 0:
            parts.append((ps, i))
            ps = i + 1
        i += 1
    parts.append((ps, end))
    return parts


def try_decl(ctx, s, e, decls, in_for):
    mtxt = ctx.masked[s:e]
    if mtxt.endswith(';'):
        mtxt = mtxt[:-1]
        e -= 1
    else:
        mtxt = mtxt.rstrip()
    m = DECL_RE.match(mtxt.strip())
    if not m:
        return False
    typ = m.group(1)
    name = m.group(2)
    simple = typ.split('<')[0].split('.')[-1].strip('[]')
    if simple not in PRIMITIVES and '.' not in typ and not simple[:1].isupper():
        return False
    init = None
    if m.group(3) is not None:
        init = ctx.text[s:e][mtxt.strip().index('=') + 1:].strip()
        if ',' in init and _top_comma(init):
            raise SystemExit('multi declarator not supported: ' + ctx.text[s:e][:120])
    decls.append(Decl(name, typ, s, e, init, in_for))
    return True


def _top_comma(text):
    depth = 0
    for c in text:
        if c in '([{':
            depth += 1
        elif c in ')]}':
            depth -= 1
        elif c == ',' and depth == 0:
            return True
    return False


def collect(ctx, start, end, decls, rets):
    for (s, e) in ctx.stmts(start, end):
        collect_stmt(ctx, s, e, decls, rets)


def collect_stmt(ctx, s, e, decls, rets):
    m = ctx.masked
    if m[s] == '{':
        collect(ctx, s + 1, e - 1, decls, rets)
        return
    w, j = ctx.word_at(s)
    if w == 'switch':
        expr, cases, bo, bc = parse_switch(ctx, s, e)
        for c in cases:
            collect(ctx, c.start, c.end, decls, rets)
        return
    if w == 'if':
        j = ctx.ws(j, e)
        pclose = ctx.paren(j)
        ts = ctx.ws(pclose + 1, e)
        te = ctx.stmt_end(ts, e)
        collect_stmt(ctx, ts, te, decls, rets)
        k = ctx.ws(te, e)
        if m[k:k + 4] == 'else':
            k = ctx.ws(k + 4, e)
            ee = ctx.stmt_end(k, e)
            collect_stmt(ctx, k, ee, decls, rets)
        return
    if w == 'for':
        j = ctx.ws(j, e)
        pclose = ctx.paren(j)
        for (ps, pe) in split_semis(ctx, j + 1, pclose):
            try_decl(ctx, ps, pe, decls, True)
        ts = ctx.ws(pclose + 1, e)
        te = ctx.stmt_end(ts, e)
        collect_stmt(ctx, ts, te, decls, rets)
        return
    if w == 'while':
        j = ctx.ws(j, e)
        pclose = ctx.paren(j)
        ts = ctx.ws(pclose + 1, e)
        te = ctx.stmt_end(ts, e)
        collect_stmt(ctx, ts, te, decls, rets)
        return
    if w == 'do':
        ts = ctx.ws(j, e)
        te = ctx.stmt_end(ts, e)
        collect_stmt(ctx, ts, te, decls, rets)
        return
    if w == 'return':
        rets.append((s, e))
        return
    try_decl(ctx, s, e, decls, False)


def promote(ctx, src, decls, rets, names, params, body_start, body_end):
    """Move every local into the state class and rewrite the returns."""
    edits = []
    for d in decls:
        if d.init is None:
            new = ''
        else:
            new = '%s.%s = %s' % (STATE, d.name, d.init)
            if not d.in_for:
                new += ';'
        edits.append((d.start, d.end, new))
    for (s, e) in rets:
        txt = ctx.text[s:e]
        expr = txt[txt.index('return') + 6:].strip().rstrip(';').strip()
        if expr:
            new = '%s.ret = %s;\n%s.stop = true;\nreturn;' % (STATE, expr, STATE)
        else:
            new = '%s.stop = true;\nreturn;' % STATE
        edits.append((s, e, new))
    edits.sort(key=lambda t: t[0])
    out = []
    pos = body_start
    for (s, e, new) in edits:
        out.append(src[pos:s])
        out.append(new)
        pos = e
    out.append(src[pos:body_end])
    body = ''.join(out)
    pat = re.compile(r'(?<![\w$.])(' + '|'.join(re.escape(n) for n in names) + r')(?![\w$(])')
    body = pat.sub(lambda mo: STATE + '.' + mo.group(1), body)
    return src[:body_start] + body + src[body_end:]


# ------------------------------------------------------------------- main

def find_method(ctx, name):
    lines = ctx.text.split(chr(10))
    offs = JL.line_offsets(ctx.text)
    mods = ('public', 'private', 'protected', 'static', 'final', 'abstract',
            'native', 'synchronized', 'strictfp')
    for i, l in enumerate(lines):
        st = l.strip()
        if not st or st.startswith('//') or st.startswith('*'):
            continue
        first = st.split()[0] if st.split() else ''
        if first not in mods:
            continue
        m = re.search(r'(?<![\w.$])' + re.escape(name) + r'\s*\(', l)
        if not m:
            continue
        bo = ctx.text.index('{', offs[i])
        bc = ctx.blocks[bo]
        return offs[i], bo, bc
    raise SystemExit('method not found: ' + name)


def parse_params(ctx, sig_start, sig_end):
    m = re.search(r'\(([^)]*)\)', ctx.text[sig_start:sig_end])
    if not m:
        return []
    out = []
    for part in m.group(1).split(','):
        part = part.strip()
        if not part:
            continue
        mm = re.match(r'([\w.$]+(?:<[^>]*>)?(?:\[\])*)\s+([A-Za-z_$][\w$]*)', part)
        if mm:
            out.append((mm.group(1), mm.group(2)))
    return out


def main():
    rel = sys.argv[1]
    name = sys.argv[2]
    target = int(sys.argv[3]) if len(sys.argv) > 3 else 60000
    path = os.path.join(ROOT, 'app', 'src', 'main', 'java', rel)
    src = open(path, encoding='utf-8').read()
    ctx = Ctx(src)
    mstart, bo, bc = find_method(ctx, name)
    params = parse_params(ctx, mstart, bo)
    decls = []
    rets = []
    collect(ctx, bo + 1, bc, decls, rets)
    seen = {}
    for d in decls:
        if d.name in seen:
            raise SystemExit('duplicate local: ' + d.name)
        seen[d.name] = d
    for t, n in params:
        if n in seen:
            raise SystemExit('parameter shadows a local: ' + n)
        seen[n] = Decl(n, t, -1, -1, None, False)
    for reserved in ('ret', 'stop'):
        if reserved in seen:
            raise SystemExit('reserved name used as local: ' + reserved)
    names = sorted(seen.keys(), key=len, reverse=True)
    print('locals: %d, returns: %d' % (len(names), len(rets)))
    src2 = promote(ctx, src, decls, rets, names, params, bo + 1, bc)
    ctx2 = Ctx(src2)
    mstart2, bo2, bc2 = find_method(ctx2, name)
    builder = Builder(target)
    names2 = build_chain(ctx2, bo2 + 1, bc2, target, builder)
    print('methods created: %d' % len(builder.methods))
    out = []
    out.append('    /** state of one run of the disassembler */')
    out.append('    private static final class %s {' % STATE_CLASS)
    for t, n in params:
        out.append('        %s %s;' % (t, n))
    for d in decls:
        out.append('        %s %s;' % (d.typ, d.name))
    out.append('        java.lang.StringBuilder ret;')
    out.append('        boolean stop;')
    out.append('    }')
    out.append('')
    sig = ctx2.text[mstart2:ctx2.text.index('{', mstart2) + 1]
    out.append(sig)
    out.append('        %s %s = new %s();' % (STATE_CLASS, STATE, STATE_CLASS))
    for t, n in params:
        out.append('        %s.%s = %s;' % (STATE, n, n))
    out.append(chain_text(names2, indent='        ', ret='return %s.ret;' % STATE))
    out.append('        return %s.ret;' % STATE)
    out.append('    }')
    out.append('')
    for mname, body in builder.methods:
        out.append('    private static void %s(%s %s) {' % (mname, STATE_CLASS, STATE))
        out.append(body)
        out.append('    }')
        out.append('')
    new_text = '\n'.join(out)
    res = src2[:mstart2] + new_text + src2[bc2 + 1:]
    open(path, 'w', encoding='utf-8').write(res)
    print('written %s' % path)


def run():
    main()


if __name__ == '__main__':
    sys.setrecursionlimit(400000)
    try:
        threading.stack_size(1024 * 1024 * 1024)
    except (ValueError, RuntimeError):
        try:
            threading.stack_size(256 * 1024 * 1024)
        except (ValueError, RuntimeError):
            pass
    t = threading.Thread(target=run)
    t.start()
    t.join()
