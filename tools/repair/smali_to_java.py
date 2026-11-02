#!/usr/bin/env python3
"""Translate one Dalvik method from a smali file into plain Java source.

Three methods of GameGuardian 101.4 defeat every Java decompiler, so they used
to be shipped as a smali overlay.  This module turns such a method into
ordinary Java source code:

  * every Dalvik instruction becomes one Java statement,
  * the register file becomes a small state object,
  * the control flow becomes a switch over the instruction index,
  * the exception handlers become one catch block plus a handler table.

The translation is mechanical, therefore the result behaves exactly like the
original dex code.  Nothing is guessed: the register types come from the
opcode of the instruction that writes a register, and the only place where a
type has to be looked at (the comparison instructions) is resolved with a
small data flow analysis over the control flow graph.

    python3 tools/repair/smali_to_java.py <smali file> <method signature>
"""

import os
import re
import sys


PRIM = {'V': 'void', 'Z': 'boolean', 'B': 'byte', 'C': 'char', 'S': 'short',
        'I': 'int', 'J': 'long', 'F': 'float', 'D': 'double'}


ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC_ROOT = os.path.join(ROOT, 'app', 'src', 'main', 'java')

_KNOWN = None


def known_classes():
    """The fully qualified names of the classes of the java tree."""
    global _KNOWN
    if _KNOWN is None:
        _KNOWN = set()
        for dirpath, _dirs, files in os.walk(SRC_ROOT):
            pkg = os.path.relpath(dirpath, SRC_ROOT).replace(os.sep, '.')
            if pkg == '.':
                pkg = ''
            for name in files:
                if name.endswith('.java'):
                    _KNOWN.add((pkg + '.' if pkg else '') + name[:-5])
    return _KNOWN


def class_name(desc):
    """Class descriptor ('Landroid/ext/n$a;') -> java source name."""
    name = desc[1:-1].replace('/', '.')
    if '$' in name and name not in known_classes():
        # a nested class of the platform (SharedPreferences$Editor): the
        # java source spells the inner class with a dot.  The classes of the
        # reconstruction keep the '$' - they are top level classes with a
        # '$' in their name.
        head, _sep, tail = name.rpartition('$')
        return head + '.' + tail
    return name


def jtype(desc):
    """Dalvik type descriptor -> Java source type."""
    if desc[0] == '[':
        return jtype(desc[1:]) + '[]'
    if desc[0] == 'L':
        return class_name(desc)
    return PRIM[desc]


def newarray_java(desc, size):
    """The java expression that allocates an array of the given type."""
    dims = 0
    while desc[dims] == '[':
        dims += 1
    base = jtype(desc[dims:])
    return 'new %s[%s]%s' % (base, size, '[]' * (dims - 1))


def split_args(text):
    """Split an operand list on commas, ignoring commas in () and ""."""
    out = []
    depth = 0
    cur = []
    i = 0
    n = len(text)
    while i < n:
        c = text[i]
        if c == '"':
            j = i + 1
            while j < n:
                if text[j] == '\\':
                    j += 2
                    continue
                if text[j] == '"':
                    break
                j += 1
            cur.append(text[i:j + 1])
            i = j + 1
            continue
        if c == '(':
            depth += 1
        elif c == ')':
            depth -= 1
        elif c == '{':
            depth += 1
        elif c == '}':
            depth -= 1
        elif c == ',' and depth == 0:
            out.append(''.join(cur).strip())
            cur = []
            i += 1
            continue
        cur.append(c)
        i += 1
    tail = ''.join(cur).strip()
    if tail:
        out.append(tail)
    return out


ESCAPES = {'n': '\n', 't': '\t', 'r': '\r', 'b': '\b', 'f': '\f',
           '"': '"', "'": "'", '\\': '\\', '0': '\0'}


def decode_string(lit):
    """Decode a smali string literal (quotes included) into a python str."""
    body = lit[1:-1]
    out = []
    i = 0
    while i < len(body):
        c = body[i]
        if c != '\\':
            out.append(c)
            i += 1
            continue
        i += 1
        e = body[i]
        if e == 'u':
            out.append(chr(int(body[i + 1:i + 5], 16)))
            i += 5
        elif e == 'x':
            j = i + 1
            h = ''
            while j < len(body) and len(h) < 2 and body[j] in '0123456789abcdefABCDEF':
                h += body[j]
                j += 1
            out.append(chr(int(h, 16)))
            i = j
        elif e in '01234567':
            j = i
            o = ''
            while j < len(body) and len(o) < 3 and body[j] in '01234567':
                o += body[j]
                j += 1
            out.append(chr(int(o, 8)))
            i = j
        else:
            out.append(ESCAPES.get(e, e))
            i += 1
    return ''.join(out)


def java_string(s):
    """Encode a python str as a java string literal."""
    out = ['"']
    for ch in s:
        o = ord(ch)
        if ch == '"':
            out.append('\\"')
        elif ch == '\\':
            out.append('\\\\')
        elif ch == '\n':
            out.append('\\n')
        elif ch == '\r':
            out.append('\\r')
        elif ch == '\t':
            out.append('\\t')
        elif ch == '\b':
            out.append('\\b')
        elif ch == '\f':
            out.append('\\f')
        elif o < 0x20 or o > 0x7e:
            out.append('\\u%04x' % o)
        else:
            out.append(ch)
    out.append('"')
    return ''.join(out)


def split_desc(text):
    """Split a concatenation of type descriptors into a list."""
    out = []
    i = 0
    while i < len(text):
        j = i
        while text[j] == '[':
            j += 1
        if text[j] == 'L':
            k = text.index(';', j)
            out.append(text[i:k + 1])
            i = k + 1
        else:
            out.append(text[i:j + 1])
            i = j + 1
    return out


def strip_comment(text):
    """Remove a trailing smali comment from an instruction line."""
    i = 0
    in_str = False
    while i < len(text):
        c = text[i]
        if in_str:
            if c == '\\':
                i += 2
                continue
            if c == '"':
                in_str = False
            i += 1
            continue
        if c == '"':
            in_str = True
            i += 1
            continue
        if c == '#':
            nxt = text[i + 1:i + 2]
            if nxt and (nxt.isdigit() or nxt in '+-'):
                i += 1
                continue
            return text[:i]
        i += 1
    return text


METHOD_REF_RE = re.compile(r'^(L[^;]+;)->([^\s(]+)\((.*)\)(.*)$')
FIELD_REF_RE = re.compile(r'^(L[^;]+;)->([^:]+):(.*)$')


def method_ref(text):
    m = METHOD_REF_RE.match(text)
    if not m:
        raise ValueError('bad method reference: ' + text)
    owner, name, params, ret = m.groups()
    return class_name(owner), name, split_desc(params), ret


def field_ref(text):
    m = FIELD_REF_RE.match(text)
    if not m:
        raise ValueError('bad field reference: ' + text)
    owner, name, ftype = m.groups()
    return class_name(owner), name, ftype


def invoke_ret(m, i):
    """The return type of the invoke at instruction i ('V' if unknown).

    ``move-result`` picks the value up from the result of the previous
    invoke, so the translator needs the signature of that call to know
    whether the result is an int, a float, a long, a double or a reference.
    """
    if i < 0 or i >= len(m.insns):
        return 'V'
    op, args = m.insns[i]
    if not op.startswith('invoke'):
        return 'V'
    try:
        return method_ref(args[-1])[3]
    except ValueError:
        return 'V'


# register kinds, four bits per register in the data flow state
K_INT = 1
K_LONG = 2
K_REF = 4
K_CONT = 8
K_DOUBLE = 16

# dalwik numeric conversions.  floats are carried in the double slot of the
# register file: a float value is always exactly representable as a double,
# so the only difference is the rounding that double-to-float performs.
CONV_OPS = {
    'int-to-long', 'long-to-int', 'int-to-char', 'int-to-byte',
    'int-to-short', 'long-to-double', 'int-to-double', 'double-to-int',
    'double-to-long', 'int-to-float', 'long-to-float', 'double-to-float',
    'float-to-double', 'float-to-int',
}


def kind_of_type(desc):
    if desc in ('I', 'Z', 'B', 'C', 'S'):
        return K_INT
    if desc == 'F':
        return K_DOUBLE
    if desc == 'J':
        return K_LONG
    if desc == 'D':
        return K_DOUBLE
    return K_REF


NO_THROW = set('''
nop move move/from16 move/16 move-wide move-wide/from16 move-wide/16
move-object move-object/from16 move-object/16 move-result move-result-wide
move-result-object const const/4 const/16 const/high16 const-wide
const-wide/16 const-wide/32 const-string cmp-long neg-int neg-long not-int
not-long int-to-long long-to-int int-to-char int-to-byte int-to-short
long-to-double int-to-double double-to-int double-to-long int-to-float
long-to-float double-to-float float-to-double float-to-int
instance-of packed-switch sparse-switch add-int add-int/2addr add-int/lit8
sub-int sub-int/2addr sub-int/lit8 mul-int mul-int/2addr mul-int/lit8
and-int and-int/2addr and-int/lit8 and-int/lit16 or-int or-int/2addr
or-int/lit8 xor-int xor-int/2addr xor-int/lit8 shl-int shl-int/2addr
shl-int/lit8 shr-int shr-int/2addr shr-int/lit8 ushr-int ushr-int/2addr
ushr-int/lit8 add-long add-long/2addr sub-long sub-long/2addr mul-long
and-long and-long/2addr or-long or-long/2addr xor-long xor-long/2addr
shl-long shl-long/2addr shr-long shr-long/2addr ushr-long ushr-long/2addr
rsub-int/lit8 add-double add-double/2addr sub-double sub-double/2addr
mul-double mul-double/2addr div-double div-double/2addr rem-double
rem-double/2addr neg-double
'''.split())


class Method(object):
    """The parsed content of one smali method."""

    def __init__(self):
        self.header = ''
        self.class_type = 'Ljava/lang/Object;'
        self.name = ''
        self.desc = ''
        self.access = ''
        self.nlocals = 0
        self.insns = []
        self.labels = {}
        self.catches = []
        self.switches = {}
        self.arrays = {}
        self.params = []
        self.param_regs = []
        self.nregs = 0


CATCH_RE = re.compile(r'^\.catch\s+(\S+)\s+\{(:\S+)\s+\.\.\s+(:\S+)\}\s+(:\S+)$')
CATCHALL_RE = re.compile(r'^\.catchall\s+\{(:\S+)\s+\.\.\s+(:\S+)\}\s+(:\S+)$')


def parse(path, signature):
    """Parse the method with the given name+descriptor out of a smali file."""
    with open(path, encoding='utf-8', errors='replace') as fh:
        lines = fh.read().split('\n')

    start = -1
    for i, line in enumerate(lines):
        s = line.strip()
        if not s.startswith('.method'):
            continue
        parts = s.split()
        if parts[-1] == signature:
            start = i
            break
    if start < 0:
        raise SystemExit('method %s not found in %s' % (signature, path))

    m = Method()
    m.header = lines[start].strip()
    rest = m.header[len('.method'):].strip()
    bits = rest.split()
    sig = bits[-1]
    m.access = ' '.join(bits[:-1])
    m.name = sig[:sig.index('(')]
    m.desc = sig[sig.index('('):]
    m.params = split_desc(m.desc[1:m.desc.index(')')])
    if 'static' not in m.access:
        for line in lines[:start]:
            s = line.strip()
            if s.startswith('.class '):
                mm = re.search(r'(L[^;]+;)', s)
                if mm:
                    m.class_type = mm.group(1)
                break
        m.params = [m.class_type] + m.params

    body = []
    i = start + 1
    while i < len(lines):
        s = lines[i].strip()
        if s.startswith('.end method'):
            break
        body.append(lines[i])
        i += 1

    idx = 0
    k = 0
    last_label = None
    while k < len(body):
        s = body[k].strip()
        if not s:
            k += 1
            continue
        if s.startswith('.locals'):
            m.nlocals = int(s.split()[1])
        elif s.startswith('.registers'):
            m.nlocals = int(s.split()[1]) - len(m.params)
        elif s.startswith('.catchall'):
            mm = CATCHALL_RE.match(s)
            if mm:
                m.catches.append((None, mm.group(1), mm.group(2), mm.group(3)))
        elif s.startswith('.catch'):
            mm = CATCH_RE.match(s)
            if mm:
                m.catches.append((mm.group(1), mm.group(2), mm.group(3), mm.group(4)))
        elif s.startswith(':'):
            last_label = s[1:].strip()
            m.labels[last_label] = idx
        elif s.startswith('.packed-switch') or s.startswith('.sparse-switch'):
            kind = 'packed' if s.startswith('.packed-switch') else 'sparse'
            entries = []
            if kind == 'packed':
                # baksmali renders a packed payload as
                #   .packed-switch <first_key>
                #       :label_a
                #       :label_b
                #   .end packed-switch
                # i.e. one bare label per entry, the key being first_key + index.
                mm = re.match(r'^\.packed-switch\s+(-?0x[0-9a-fA-F]+|-?\d+)\s*$', s)
                first_key = int(mm.group(1), 0) if mm else None
                k += 1
                n = 0
                while k < len(body):
                    ds = body[k].strip()
                    if not ds.startswith(':'):
                        break
                    key = (first_key + n) if first_key is not None else n
                    entries.append((key, ds[1:]))
                    n += 1
                    k += 1
            else:
                k += 1
                while k < len(body):
                    ds = body[k].strip()
                    mm = re.match(r'^(-?0x[0-9a-fA-F]+|-?\d+)\s*->\s*(:\S+)$', ds)
                    if not mm:
                        break
                    entries.append((int(mm.group(1), 0), mm.group(2)[1:]))
                    k += 1
            if last_label is not None:
                m.switches[last_label] = (kind, entries)
            continue
        elif s.startswith('.array-data'):
            width = int(s.split()[1])
            values = []
            k += 1
            while k < len(body):
                ds = body[k].strip()
                mm = re.match(r'^(-?0x[0-9a-fA-F]+|-?\d+)([tsp])?$', ds)
                if not mm:
                    break
                values.append(int(mm.group(1), 0))
                k += 1
            if last_label is not None:
                m.arrays[last_label] = (width, values)
            continue
        elif s.startswith('.'):
            pass
        else:
            head = strip_comment(s).split(None, 1)
            op = head[0]
            args = split_args(head[1]) if len(head) > 1 else []
            m.insns.append((op, args))
            idx += 1
        k += 1

    # resolve the parameter registers: they sit above the locals
    reg = m.nlocals
    for ptype in m.params:
        m.param_regs.append(reg)
        reg += 2 if ptype in ('J', 'D') else 1
    m.nregs = reg
    return m


def regnum(tok, m):
    """Resolve a register operand (v3 or p1) to a register number."""
    if tok[0] == 'v':
        return int(tok[1:])
    # baksmali numbers the parameters by register slot, so a long parameter
    # covers two of them (p1 and p2 for the first long argument).
    return m.nlocals + int(tok[1:])


def reglist(tok, m):
    """Resolve the register list of an invoke instruction."""
    body = tok.strip()
    if body.startswith('{') and body.endswith('}'):
        body = body[1:-1].strip()
    if '..' in body:
        lo, hi = body.split('..')
        a = regnum(lo.strip(), m)
        b = regnum(hi.strip(), m)
        return list(range(a, b + 1))
    if not body:
        return []
    return [regnum(x.strip(), m) for x in body.split(',')]


def arg_regs(regs, ptypes):
    """Map the parameters of an invoke to their registers.

    The dex instruction format 35c gives a wide argument two register slots,
    so the register list of an invoke is longer than its parameter list.
    """
    out = []
    i = 0
    for pt in ptypes:
        if i >= len(regs):
            break
        out.append(regs[i])
        i += 2 if pt in ('J', 'D') else 1
    return out


def parse_int(tok):
    """Parse an integer literal of a dalvik instruction."""
    t = tok.strip()
    if t.startswith('#'):
        t = t[1:]
    if t[-1:] in ('L', 'l'):
        t = t[:-1]
    neg = t.startswith('-')
    if neg:
        t = t[1:]
    if t.lower().startswith('0x'):
        v = int(t, 16)
    else:
        v = int(t, 10)
    return -v if neg else v


def fmt_int(v, bits=32):
    if v < 0:
        return hex(v & ((1 << bits) - 1))
    return str(v)


def fmt_long(v):
    if v < 0:
        return hex(v & 0xffffffffffffffff) + 'L'
    return str(v) + 'L'


def dest_kind(op):
    """The kind of the register an opcode writes, or None if it writes none."""
    if op in ('cmp-long', 'cmpl-double', 'cmpg-double'):
        return K_INT
    if op in ('int-to-long', 'double-to-long'):
        return K_LONG
    if op in ('long-to-int', 'int-to-char', 'int-to-byte', 'int-to-short',
              'double-to-int', 'float-to-int'):
        return K_INT
    if op in ('long-to-double', 'int-to-double', 'int-to-float',
              'long-to-float', 'double-to-float', 'float-to-double'):
        return K_DOUBLE
    if op.startswith(('add-', 'sub-', 'rsub-', 'mul-', 'div-', 'rem-', 'and-',
                      'or-', 'xor-', 'shl-', 'shr-', 'ushr-', 'neg-', 'not-')):
        if 'double' in op:
            return K_DOUBLE
        return K_LONG if 'long' in op else K_INT
    return None


def defs_of(op, args, m):
    """The registers an instruction writes, as a list of (register, kind)."""
    out = []

    def one(reg, kind):
        out.append((reg, kind))
        if kind == K_LONG:
            out.append((reg + 1, K_CONT))

    if op in ('move', 'move/from16', 'move/16'):
        one(regnum(args[0], m), K_INT)
    elif op in ('move-wide', 'move-wide/from16', 'move-wide/16'):
        one(regnum(args[0], m), K_LONG)
    elif op in ('move-object', 'move-object/from16', 'move-object/16'):
        one(regnum(args[0], m), K_REF)
    elif op == 'move-result':
        one(regnum(args[0], m), K_INT)
    elif op == 'move-result-wide':
        one(regnum(args[0], m), K_LONG)
    elif op == 'move-result-object':
        one(regnum(args[0], m), K_REF)
    elif op == 'move-exception':
        one(regnum(args[0], m), K_REF)
    elif op == 'const-string' or op == 'const-string/jumbo':
        one(regnum(args[0], m), K_REF)
    elif op == 'const-class':
        one(regnum(args[0], m), K_REF)
    elif op.startswith('const-wide'):
        one(regnum(args[0], m), K_LONG)
    elif op.startswith('const'):
        one(regnum(args[0], m), K_INT)
    elif op in ('new-instance', 'new-array', 'check-cast'):
        one(regnum(args[0], m), K_REF)
    elif op in ('instance-of', 'array-length', 'cmp-long', 'cmpl-double',
                'cmpg-double'):
        one(regnum(args[0], m), K_INT)
    elif op.startswith('aget'):
        one(regnum(args[0], m), K_LONG if op == 'aget-wide' else
            (K_REF if op == 'aget-object' else K_INT))
    elif op.startswith('aput'):
        pass
    elif op.startswith('iget'):
        _, _, ftype = field_ref(args[2])
        one(regnum(args[0], m), kind_of_type(ftype))
    elif op.startswith('iput'):
        pass
    elif op.startswith('sget'):
        _, _, ftype = field_ref(args[1])
        one(regnum(args[0], m), kind_of_type(ftype))
    elif op.startswith('sput'):
        pass
    else:
        k = dest_kind(op)
        if k is not None:
            one(regnum(args[0], m), k)
    return out


class Analyzer(object):
    """A tiny data flow analysis that resolves the type of every register."""

    def __init__(self, m):
        self.m = m
        self.succ = []
        self.states = []
        self.ambiguous = []
        self._build()

    def label_index(self, name):
        return self.m.labels[name.lstrip(':')]

    def _build(self):
        m = self.m
        n = len(m.insns)
        succ = [[] for _ in range(n)]
        for i, (op, args) in enumerate(m.insns):
            if op.startswith('goto'):
                succ[i].append(self.label_index(args[-1]))
            elif op.startswith('if-'):
                succ[i].append(self.label_index(args[-1]))
                if i + 1 < n:
                    succ[i].append(i + 1)
            elif op in ('return', 'return-wide', 'return-object', 'return-void', 'throw'):
                pass
            elif i + 1 < n:
                succ[i].append(i + 1)
        for (_ctype, start, end, handler) in m.catches:
            si = m.labels[start.lstrip(':')]
            ei = m.labels[end.lstrip(':')]
            hi = m.labels[handler.lstrip(':')]
            for i in range(si, min(ei, n)):
                succ[i].append(hi)
        self.succ = succ
        self._flow()

    def _flow(self):
        m = self.m
        n = len(m.insns)
        states = [0] * n
        # published early so that kind_at() works while the fixpoint runs
        self.states = states
        seed = 0
        for pi, ptype in enumerate(m.params):
            r = m.param_regs[pi]
            k = kind_of_type(ptype)
            seed |= k << (5 * r)
            if k == K_LONG:
                seed |= K_CONT << (5 * (r + 1))
        if n:
            states[0] = seed
        work = list(range(n - 1, -1, -1))
        queued = [True] * n
        while work:
            i = work.pop()
            queued[i] = False
            out = states[i]
            for (r, k) in self._defs(i):
                out &= ~(31 << (5 * r))
                out |= k << (5 * r)
            for j in self.succ[i]:
                new = states[j] | out
                if new != states[j]:
                    states[j] = new
                    if not queued[j]:
                        queued[j] = True
                        work.append(j)
        self.states = states

    def kind_at(self, i, reg):
        return (self.states[i] >> (5 * reg)) & 31

    def nearest_kind(self, i, reg):
        """The kind of the definition of reg that precedes instruction i.

        The data flow state merges every path, so a register that is an
        int on one path and a reference on another ends up with both kinds.
        The definition that comes last before the use is the one that
        decides how the value is compared.
        """
        for j in range(i - 1, -1, -1):
            for (r, k) in self._defs(j):
                if r == reg:
                    return K_LONG if k == K_CONT else k
        return 0

    def effective_kind(self, i, reg):
        k = self.kind_at(i, reg)
        if not (k & K_INT) or not (k & K_REF):
            return k
        nk = self.nearest_kind(i, reg)
        return nk if nk else k

    def wide_kind(self, i):
        """K_DOUBLE or K_LONG for the wide value written by instruction i."""
        m = self.m
        op, args = m.insns[i]
        if op in ('move-wide', 'move-wide/from16', 'move-wide/16'):
            src = regnum(args[1], m)
            if self.kind_at(i, src) & K_DOUBLE:
                return K_DOUBLE
            return K_LONG
        if op == 'move-result-wide':
            if i > 0:
                pop, pargs = m.insns[i - 1]
                if pop.startswith('invoke'):
                    try:
                        ret = method_ref(pargs[-1])[3]
                    except ValueError:
                        ret = 'J'
                    return K_DOUBLE if ret == 'D' else K_LONG
            return K_LONG
        # a plain wide value: the data flow state of the register tells
        # whether it holds a long or a double
        reg = regnum(args[0], m)
        k = self.kind_at(i, reg)
        if k & K_DOUBLE:
            return K_DOUBLE
        if k & K_LONG:
            return K_LONG
        if i > 0:
            pop, pargs = m.insns[i - 1]
            if pop.startswith('invoke'):
                try:
                    ret = method_ref(pargs[-1])[3]
                except ValueError:
                    ret = 'J'
                if ret == 'D':
                    return K_DOUBLE
        return K_LONG

    def _defs(self, i):
        """The registers instruction i writes, with the wide kind resolved."""
        op, args = self.m.insns[i]
        if op in ('move-wide', 'move-wide/from16', 'move-wide/16',
                  'move-result-wide'):
            r = regnum(args[0], self.m)
            kind = self.wide_kind(i)
            return [(r, kind), (r + 1, K_CONT)]
        if op == 'move-result':
            # a float result is a 32 bit value, but it is not an int: it
            # lives in the double slot of the register file
            r = regnum(args[0], self.m)
            ret = invoke_ret(self.m, i - 1)
            return [(r, K_DOUBLE if ret == 'F' else K_INT)]
        return defs_of(op, args, self.m)

    def cmp_kind(self, i, ra, rb):
        ka = self.effective_kind(i, ra)
        kb = self.effective_kind(i, rb)
        ref = bool(ka & K_REF) or bool(kb & K_REF)
        lng = bool(ka & K_LONG) or bool(kb & K_LONG)
        if ref and lng:
            self.ambiguous.append((i, ra, rb, ka, kb))
        if not ka:
            ka = kb
        if not kb:
            kb = ka
        if not ka:
            return K_INT
        if ka == kb:
            return ka
        if lng and (ka & K_LONG) and (kb & K_LONG):
            return K_LONG
        if (ka & K_INT) and (kb & K_INT):
            return K_INT
        if (ka & K_REF) and (kb & K_REF):
            return K_REF
        return K_INT


INT_BIN = {'add': '+', 'sub': '-', 'mul': '*', 'div': '/', 'rem': '%',
           'and': '&', 'or': '|', 'xor': '^', 'shl': '<<', 'shr': '>>',
           'ushr': '>>>'}


class Generator(object):
    """Turns a parsed method into java source code."""

    def __init__(self, m, prefix, java_params, java_ret, is_static, chunk_size=2000):
        self.m = m
        self.an = Analyzer(m)
        self.prefix = prefix
        self.java_params = java_params
        self.java_ret = java_ret
        self.is_static = is_static
        self.chunk_size = chunk_size
        self.fields = {}
        self.new_instance = self._find_inits()
        self.init_groups = self._find_init_groups()
        # ``invoke-super`` calls a method of the super class.  java only
        # offers ``super.foo()`` inside an instance method, so the generated
        # state machine has to be an instance method as well.
        self.has_super = any(op.startswith('invoke-super')
                              for op, _args in m.insns)
        # ``monitor-enter``/``monitor-exit`` implement a java synchronized
        # block.  The state machine can not hold a java monitor across the
        # instructions of the block, so the monitor is emulated with a
        # reentrant lock that is shared per monitor object.
        self.has_monitor = any(op in ('monitor-enter', 'monitor-exit')
                               for op, _args in m.insns)

    # ------------------------------------------------------------ helpers

    def R(self, reg, kind):
        self.fields.setdefault(reg, set()).add(kind)
        return 'st.v%d%s' % (reg, {K_INT: 'i', K_LONG: 'j', K_REF: 'o',
                                   K_DOUBLE: 'd'}[kind])

    def float_expr(self, reg, i=None):
        """The java expression for a register used as a 32 bit float.

        A float is carried in the double slot of the register file: every
        float is exactly representable as a double, so the only difference
        between the two is the rounding that ``double-to-float`` performs.
        """
        if i is not None:
            k = self.an.kind_at(i, reg)
            if k & K_DOUBLE:
                return '(float) ' + self.R(reg, K_DOUBLE)
            if k & K_LONG:
                # the low 32 bits of a long register hold the float
                return '(float) java.lang.Float.intBitsToFloat((int) %s)' % (
                    self.R(reg, K_LONG))
        return self.R(reg, K_INT)

    def setreg(self, reg, kind, expr):
        """Write a register and invalidate the other type views of it.

        A dalvik register holds exactly one value, but the java translation
        keeps one int/long/object slot per register so that the arithmetic
        stays unboxed.  A write therefore has to clear the slots of the other
        kinds: otherwise a register that was written as int would still hand
        out a stale object.  The original dex relies on that: ``const/4 v6, 0``
        is passed to a method that expects a String, and dalvik turns the int
        zero into a null reference.
        """
        out = ['%s = %s;' % (self.R(reg, kind), expr)]
        # a dalvik register holds 64 raw bits: a long and a double share the
        # same slot and only differ in the way the bits are read.  the java
        # translation keeps a long slot and a double slot per register, so
        # every write to one of them has to update the other one as well.
        if kind == K_LONG:
            out.append('%s = java.lang.Double.longBitsToDouble(%s);' % (
                self.R(reg, K_DOUBLE), self.R(reg, K_LONG)))
        elif kind == K_DOUBLE:
            out.append('%s = java.lang.Double.doubleToRawLongBits(%s);' % (
                self.R(reg, K_LONG), self.R(reg, K_DOUBLE)))
        for other, zero in ((K_INT, '0'), (K_LONG, '0L'), (K_REF, 'null'),
                            (K_DOUBLE, '0.0')):
            if other == kind:
                continue
            if kind in (K_LONG, K_DOUBLE) and other in (K_LONG, K_DOUBLE):
                # the long slot and the double slot are two views of the
                # same 64 bits, they are kept in sync above
                continue
            out.append('%s = %s;' % (self.R(reg, other), zero))
        return out

    def _find_inits(self):
        """Map every new-instance to the <init> call that constructs it."""
        res = {}
        insns = self.m.insns
        for i, (op, args) in enumerate(insns):
            if op != 'new-instance':
                continue
            reg = regnum(args[0], self.m)
            j = i + 1
            while j < len(insns):
                op2, args2 = insns[j]
                if op2.startswith('invoke-direct') and '<init>' in args2[-1]:
                    regs = reglist(args2[0], self.m)
                    if regs and regs[0] == reg:
                        res[i] = j
                        break
                for (r, _k) in defs_of(op2, args2, self.m):
                    if r == reg:
                        j = -1
                        break
                if j < 0:
                    break
                j += 1
        return res

    def _find_init_groups(self):
        """The registers that hold the object a constructor call builds.

        ``new-instance v2`` puts a fresh object into v2.  The dex code may
        move that reference into another register before the constructor is
        called on it::

            new-instance v2, Landroid/ext/z1$d;
            move-object v14, v2
            invoke-direct {v14 .. v21}, Landroid/ext/z1$d;-><init>(...)V

        The java translation builds the object at the position of the
        constructor call, so every register that carries the reference has
        to receive the object as well - the dex code uses the register of the
        new-instance after the constructor call (it puts the object into a
        list, or throws it).  A register that is left behind keeps the null
        of the new-instance and the reconstruction would add a null to a
        list where the original dex adds the object.
        """
        pending = {}
        members = {}
        res = {}
        for i, (op, args) in enumerate(self.m.insns):
            if op == 'new-instance':
                reg = regnum(args[0], self.m)
                pending[reg] = reg
                members.setdefault(reg, [reg])
                continue
            if op in ('move-object', 'move-object/from16', 'move-object/16'):
                dst = regnum(args[0], self.m)
                src = regnum(args[1], self.m)
                if src in pending:
                    group = pending[src]
                    pending[dst] = group
                    if dst not in members[group]:
                        members[group].append(dst)
                else:
                    pending.pop(dst, None)
                continue
            if op.startswith('invoke-direct') and '<init>' in args[-1]:
                regs = reglist(args[0], self.m)
                if regs:
                    group = pending.get(regs[0])
                    if group is not None:
                        res[i] = members[group]
                        for r in members[group]:
                            pending.pop(r, None)
                continue
            for (r, _k) in defs_of(op, args, self.m):
                pending.pop(r, None)
        return res

    def label(self, name):
        return self.m.labels[name.lstrip(':')]

    # --------------------------------------------------------- statements

    def stmt(self, i):
        """The java statements for instruction i (without the pc marker)."""
        m = self.m
        op, args = m.insns[i]
        out = []

        if op in ('move', 'move/from16', 'move/16'):
            out.extend(self.setreg(regnum(args[0], m), K_INT,
                                   self.R(regnum(args[1], m), K_INT)))
        elif op in ('move-wide', 'move-wide/from16', 'move-wide/16'):
            kind = self.an.wide_kind(i)
            out.extend(self.setreg(regnum(args[0], m), kind,
                                   self.R(regnum(args[1], m), kind)))
        elif op in ('move-object', 'move-object/from16', 'move-object/16'):
            out.extend(self.setreg(regnum(args[0], m), K_REF,
                                   self.R(regnum(args[1], m), K_REF)))
        elif op == 'move-result':
            kind = K_DOUBLE if invoke_ret(m, i - 1) == 'F' else K_INT
            out.extend(self.setreg(regnum(args[0], m), kind,
                                   'st.tmpD' if kind == K_DOUBLE else 'st.tmpI'))
        elif op == 'move-result-wide':
            kind = self.an.wide_kind(i)
            out.extend(self.setreg(regnum(args[0], m), kind,
                                   'st.tmpD' if kind == K_DOUBLE else 'st.tmpJ'))
        elif op == 'move-result-object':
            out.extend(self.setreg(regnum(args[0], m), K_REF, 'st.tmpO'))
        elif op == 'move-exception':
            out.extend(self.setreg(regnum(args[0], m), K_REF, 'st.ex'))
        elif op == 'nop':
            pass
        elif op == 'monitor-enter':
            out.append('st.mon = %s_monitor((java.lang.Object) %s);' % (
                self.prefix, self.R(regnum(args[0], m), K_REF)))
            out.append('st.mon.lock();')
        elif op == 'monitor-exit':
            out.append('if (st.mon != null) {')
            out.append('    st.mon.unlock();')
            out.append('    st.mon = null;')
            out.append('}')
        elif op.startswith('filled-new-array'):
            regs = reglist(args[0], m)
            atype = args[1]
            comp = atype[1:]
            jt = jtype(comp)
            elems = [self.arg_expr(r, comp, i) for r in regs]
            # the array is the result of the instruction, the caller picks
            # it up with move-result
            out.append('st.tmpO = new %s[] {%s};' % (jt, ', '.join(elems)))
            out.append('st.tmpI = 0;')
            out.append('st.tmpJ = 0L;')
        elif op == 'const-string' or op == 'const-string/jumbo':
            out.extend(self.setreg(regnum(args[0], m), K_REF,
                                   java_string(decode_string(args[1]))))
        elif op == 'const-class':
            out.extend(self.setreg(regnum(args[0], m), K_REF,
                                   '%s.class' % jtype(args[1])))
        elif op.startswith('const-wide'):
            bits = 64
            if op == 'const-wide/16':
                bits = 16
            elif op == 'const-wide/32':
                bits = 32
            out.extend(self.setreg(regnum(args[0], m), K_LONG,
                                   fmt_long(parse_int(args[1]))))
        elif op.startswith('const'):
            out.extend(self.setreg(regnum(args[0], m), K_INT,
                                   fmt_int(parse_int(args[1]))))
        elif op == 'new-instance':
            out.extend(self.setreg(regnum(args[0], m), K_REF, 'null'))
        elif op == 'new-array':
            out.extend(self.setreg(regnum(args[0], m), K_REF,
                                   newarray_java(args[2],
                                                 self.R(regnum(args[1], m), K_INT))))
        elif op == 'check-cast':
            out.extend(self.setreg(regnum(args[0], m), K_REF,
                                   '(%s) %s' % (jtype(args[1]),
                                                self.R(regnum(args[0], m), K_REF))))
        elif op == 'instance-of':
            out.extend(self.setreg(regnum(args[0], m), K_INT,
                                   '(%s instanceof %s) ? 1 : 0' % (
                                       self.R(regnum(args[1], m), K_REF),
                                       jtype(args[2]))))
        elif op == 'array-length':
            out.extend(self.setreg(regnum(args[0], m), K_INT,
                                   'java.lang.reflect.Array.getLength(%s)' %
                                   self.R(regnum(args[1], m), K_REF)))
        elif op.startswith('aget'):
            kind = K_LONG if op == 'aget-wide' else (K_REF if op == 'aget-object' else K_INT)
            elem = {'aget-wide': 'long', 'aget-object': 'java.lang.Object',
                    'aget-boolean': 'boolean', 'aget-byte': 'byte',
                    'aget-char': 'char', 'aget-short': 'short'}.get(op, 'int')
            expr = '((%s[]) %s)[%s]' % (elem, self.R(regnum(args[1], m), K_REF),
                                        self.R(regnum(args[2], m), K_INT))
            if op == 'aget-boolean':
                expr = '(%s ? 1 : 0)' % expr
            out.extend(self.setreg(regnum(args[0], m), kind, expr))
        elif op.startswith('aput'):
            elem = {'aput-wide': 'long', 'aput-object': 'java.lang.Object',
                    'aput-boolean': 'boolean', 'aput-byte': 'byte',
                    'aput-char': 'char', 'aput-short': 'short'}.get(op, 'int')
            value = self.R(regnum(args[0], m), K_INT)
            if op == 'aput-boolean':
                value = '(%s != 0)' % value
            elif op == 'aput-byte':
                value = '(byte) %s' % value
            elif op == 'aput-char':
                value = '(char) %s' % value
            elif op == 'aput-short':
                value = '(short) %s' % value
            elif op == 'aput-wide':
                value = self.R(regnum(args[0], m), K_LONG)
            elif op == 'aput-object':
                value = self.R(regnum(args[0], m), K_REF)
            out.append('((%s[]) %s)[%s] = %s;' % (
                elem, self.R(regnum(args[1], m), K_REF),
                self.R(regnum(args[2], m), K_INT), value))
        elif op.startswith('iget'):
            owner, name, ftype = field_ref(args[2])
            expr = '((%s) %s).%s' % (owner, self.R(regnum(args[1], m), K_REF), name)
            if ftype == 'Z':
                expr = '(%s ? 1 : 0)' % expr
            out.extend(self.setreg(regnum(args[0], m), kind_of_type(ftype), expr))
        elif op.startswith('iput'):
            owner, name, ftype = field_ref(args[2])
            value = self.value_expr(regnum(args[0], m), ftype, i)
            out.append('((%s) %s).%s = %s;' % (owner, self.R(regnum(args[1], m), K_REF),
                                                name, value))
        elif op.startswith('sget'):
            owner, name, ftype = field_ref(args[1])
            expr = '%s.%s' % (owner, name)
            if ftype == 'Z':
                expr = '(%s ? 1 : 0)' % expr
            out.extend(self.setreg(regnum(args[0], m), kind_of_type(ftype), expr))
        elif op.startswith('sput'):
            owner, name, ftype = field_ref(args[1])
            value = self.value_expr(regnum(args[0], m), ftype, i)
            out.append('%s.%s = %s;' % (owner, name, value))
        elif op == 'throw':
            out.append('throw (java.lang.Throwable) %s;' %
                       self.R(regnum(args[0], m), K_REF))
        elif op.startswith('invoke-'):
            out.extend(self.invoke(i))
        elif op == 'packed-switch' or op == 'sparse-switch':
            out.extend(self.switch_stmt(i))
        elif op.startswith('goto'):
            out.append('st.pc = %d;' % self.label(args[0]))
            out.append('continue;')
        elif op.startswith('if-'):
            out.extend(self.branch(i))
        elif op.startswith('return'):
            if op == 'return-void':
                out.append('return true;')
            else:
                if op == 'return-wide':
                    kind = self.an.wide_kind(i)
                else:
                    kind = K_REF if op == 'return-object' else K_INT
                suffix = {K_INT: 'I', K_LONG: 'J', K_REF: 'O',
                          K_DOUBLE: 'D'}[kind]
                out.append('st.result%s = %s;' % (
                    suffix, self.R(regnum(args[0], m), kind)))
                for other, zero in (('I', '0'), ('J', '0L'), ('O', 'null'),
                                    ('D', '0.0')):
                    if other == suffix:
                        continue
                    out.append('st.result%s = %s;' % (other, zero))
                out.append('return true;')
        elif op == 'fill-array-data':
            raise SystemExit('fill-array-data is not supported')
        elif dest_kind(op) is not None:
            out.extend(self.arith(i))
        else:
            raise SystemExit('unsupported opcode: ' + op)
        return out

    def conv(self, i):
        """Translate a dalwik numeric conversion opcode."""
        m = self.m
        op, args = m.insns[i]
        dst = regnum(args[0], m)
        src = regnum(args[1], m)
        if op == 'int-to-long':
            return self.setreg(dst, K_LONG, self.R(src, K_INT))
        if op == 'long-to-int':
            return self.setreg(dst, K_INT, '(int) ' + self.R(src, K_LONG))
        if op == 'long-to-double':
            return self.setreg(dst, K_DOUBLE, '(double) ' + self.R(src, K_LONG))
        if op == 'int-to-double':
            return self.setreg(dst, K_DOUBLE, '(double) ' + self.R(src, K_INT))
        if op == 'double-to-int':
            return self.setreg(dst, K_INT, '(int) ' + self.R(src, K_DOUBLE))
        if op == 'double-to-long':
            return self.setreg(dst, K_LONG, '(long) ' + self.R(src, K_DOUBLE))
        if op == 'int-to-float':
            return self.setreg(dst, K_DOUBLE, '(float) ' + self.R(src, K_INT))
        if op == 'long-to-float':
            return self.setreg(dst, K_DOUBLE, '(float) ' + self.R(src, K_LONG))
        if op == 'double-to-float':
            return self.setreg(dst, K_DOUBLE, '(float) ' + self.R(src, K_DOUBLE))
        if op == 'float-to-double':
            return self.setreg(dst, K_DOUBLE, self.R(src, K_DOUBLE))
        if op == 'float-to-int':
            return self.setreg(dst, K_INT, '(int) ' + self.R(src, K_DOUBLE))
        if op in ('int-to-char', 'int-to-byte', 'int-to-short'):
            cast = {'int-to-char': 'char', 'int-to-byte': 'byte',
                    'int-to-short': 'short'}[op]
            return self.setreg(dst, K_INT, '(%s) %s' % (cast,
                                                  self.R(src, K_INT)))
        raise SystemExit('unsupported conversion: ' + op)

    def arith(self, i):
        m = self.m
        op, args = m.insns[i]
        if op == 'cmp-long':
            return self.setreg(regnum(args[0], m), K_INT,
                               'Long.compare(%s, %s)' % (
                                   self.R(regnum(args[1], m), K_LONG),
                                   self.R(regnum(args[2], m), K_LONG)))
        if op in ('cmpl-double', 'cmpg-double'):
            a = self.R(regnum(args[1], m), K_DOUBLE)
            b = self.R(regnum(args[2], m), K_DOUBLE)
            nan = '1' if op == 'cmpg-double' else '-1'
            expr = ('(Double.isNaN(%s) || Double.isNaN(%s) ? %s : '
                    '(%s < %s ? -1 : (%s == %s ? 0 : 1)))') % (
                        a, b, nan, a, b, a, b)
            return self.setreg(regnum(args[0], m), K_INT, expr)
        if op in CONV_OPS:
            return self.conv(i)
        base = op.split('/')[0]
        wide = 'long' in base
        dbl = 'double' in base
        kind = K_DOUBLE if dbl else (K_LONG if wide else K_INT)
        name = base.split('-')[0]
        dst = self.R(regnum(args[0], m), kind)
        if name in ('neg', 'not'):
            src = self.R(regnum(args[1], m), kind)
            expr = ('-' if name == 'neg' else '~') + src
            return self.setreg(regnum(args[0], m), kind, expr)
        if name == 'rsub':
            src = self.R(regnum(args[1], m), kind)
            expr = '%s - %s' % (fmt_int(parse_int(args[2])), src)
            return self.setreg(regnum(args[0], m), kind, expr)
        if name not in INT_BIN:
            raise SystemExit('unsupported arithmetic opcode: ' + op)
        sym = INT_BIN[name]
        if op.endswith('/2addr'):
            src = self.R(regnum(args[1], m), kind)
            expr = '%s %s %s' % (dst, sym, src)
        elif '/lit' in op:
            src = self.R(regnum(args[1], m), kind)
            expr = '%s %s %s' % (src, sym, fmt_long(parse_int(args[2])) if wide
                                 else fmt_int(parse_int(args[2])))
        elif name in ('shl', 'shr', 'ushr'):
            src = self.R(regnum(args[1], m), kind)
            shift = self.R(regnum(args[2], m), K_INT)
            expr = '%s %s %s' % (src, sym, shift)
        else:
            src = self.R(regnum(args[1], m), kind)
            other = self.R(regnum(args[2], m), kind)
            expr = '%s %s %s' % (src, sym, other)
        return self.setreg(regnum(args[0], m), kind, expr)

    def invoke(self, i):
        m = self.m
        op, args = m.insns[i]
        owner, name, ptypes, ret = method_ref(args[-1])
        regs = reglist(args[0], m)
        if op.startswith('invoke-super'):
            if self.is_static:
                raise SystemExit('invoke-super in a static method')
            aregs = arg_regs(regs[1:], ptypes)
            call_args = [self.arg_expr(aregs[k], ptypes[k], i)
                         for k in range(len(ptypes))]
            expr = 'super.%s(%s)' % (name, ', '.join(call_args))
        elif op.startswith('invoke-static'):
            aregs = arg_regs(regs, ptypes)
            call_args = [self.arg_expr(aregs[k], ptypes[k], i)
                         for k in range(len(ptypes))]
            expr = '%s.%s(%s)' % (owner, name, ', '.join(call_args))
        elif name == '<init>':
            aregs = arg_regs(regs[1:], ptypes)
            call_args = [self.arg_expr(aregs[k], ptypes[k], i)
                         for k in range(len(ptypes))]
            expr = 'new %s(%s)' % (owner, ', '.join(call_args))
            group = self.init_groups.get(i)
            if group:
                # the register of the new-instance carries the object as
                # well - the dex code uses it after the constructor call
                out = []
                for reg in group:
                    out.extend(self.setreg(reg, K_REF, expr))
                return out
            return self.setreg(regs[0], K_REF, expr)
        else:
            aregs = arg_regs(regs[1:], ptypes)
            call_args = [self.arg_expr(aregs[k], ptypes[k], i)
                         for k in range(len(ptypes))]
            recv = '((%s) %s)' % (owner, self.R(regs[0], K_REF))
            expr = '%s.%s(%s)' % (recv, name, ', '.join(call_args))
        if ret == 'V':
            return ['%s;' % expr]
        if ret == 'F':
            return ['st.tmpD = %s;' % expr, 'st.tmpI = 0;', 'st.tmpJ = 0L;',
                    'st.tmpO = null;']
        if ret == 'I':
            return ['st.tmpI = %s;' % expr, 'st.tmpJ = 0L;', 'st.tmpO = null;']
        if ret == 'Z':
            return ['st.tmpI = (%s) ? 1 : 0;' % expr, 'st.tmpJ = 0L;',
                    'st.tmpO = null;']
        if ret in ('B', 'C', 'S'):
            return ['st.tmpI = (int) %s;' % expr, 'st.tmpJ = 0L;',
                    'st.tmpO = null;']
        if ret == 'D':
            return ['st.tmpD = %s;' % expr, 'st.tmpI = 0;', 'st.tmpJ = 0L;',
                    'st.tmpO = null;']
        if ret == 'J':
            return ['st.tmpJ = %s;' % expr, 'st.tmpI = 0;', 'st.tmpO = null;']
        return ['st.tmpO = %s;' % expr, 'st.tmpI = 0;', 'st.tmpJ = 0L;']

    def arg_expr(self, reg, ptype, i=0):
        if ptype == 'F':
            return self.float_expr(reg, i)
        if ptype == 'I':
            return self.R(reg, K_INT)
        if ptype == 'Z':
            return '(%s != 0)' % self.R(reg, K_INT)
        if ptype == 'B':
            return '(byte) %s' % self.R(reg, K_INT)
        if ptype == 'C':
            return '(char) %s' % self.R(reg, K_INT)
        if ptype == 'S':
            return '(short) %s' % self.R(reg, K_INT)
        if ptype == 'D':
            if self.an.kind_at(i, reg) & K_DOUBLE:
                return self.R(reg, K_DOUBLE)
            # a long register used as a double is a reinterpretation of the
            # 64 bits, not a numeric conversion
            return 'java.lang.Double.longBitsToDouble(%s)' % self.R(reg, K_LONG)
        if ptype == 'J':
            return self.R(reg, K_LONG)
        jt = jtype(ptype)
        expr = self.R(reg, K_REF)
        if jt != 'java.lang.Object':
            expr = '(%s) %s' % (jt, expr)
        return expr

    def value_expr(self, reg, vtype, i=None):
        """The java expression for a register used as a value of the given type."""
        if vtype == 'F':
            return self.float_expr(reg, i)
        if vtype == 'I':
            return self.R(reg, K_INT)
        if vtype == 'Z':
            return '(%s != 0)' % self.R(reg, K_INT)
        if vtype == 'B':
            return '(byte) %s' % self.R(reg, K_INT)
        if vtype == 'C':
            return '(char) %s' % self.R(reg, K_INT)
        if vtype == 'S':
            return '(short) %s' % self.R(reg, K_INT)
        if vtype == 'J':
            return self.R(reg, K_LONG)
        if vtype == 'D':
            return self.R(reg, K_DOUBLE)
        jt = jtype(vtype)
        expr = self.R(reg, K_REF)
        if jt != 'java.lang.Object':
            expr = '(%s) %s' % (jt, expr)
        return expr

    def switch_stmt(self, i):
        m = self.m
        op, args = m.insns[i]
        kind, entries = m.switches[args[1].lstrip(':')]
        reg = self.R(regnum(args[0], m), K_INT)
        out = ['switch (%s) {' % reg]
        for (key, target) in entries:
            out.append('    case %d: st.pc = %d; continue;' % (key, self.label(target)))
        out.append('    default: st.pc = %d; continue;' % (i + 1))
        out.append('}')
        return out

    def branch(self, i):
        m = self.m
        op, args = m.insns[i]
        target = self.label(args[-1])
        if op in ('if-eqz', 'if-nez', 'if-ltz', 'if-gez', 'if-gtz', 'if-lez'):
            ra = regnum(args[0], m)
            kind = self.an.kind_at(i, ra)
            cond = None
            if op in ('if-ltz', 'if-gez', 'if-gtz', 'if-lez'):
                # these opcodes only exist for 64 bit values
                if kind & K_LONG:
                    reg = self.R(ra, K_LONG)
                    cmp = {'if-ltz': '< 0L', 'if-gez': '>= 0L',
                           'if-gtz': '> 0L', 'if-lez': '<= 0L'}[op]
                else:
                    reg = self.R(ra, K_INT)
                    cmp = {'if-ltz': '< 0', 'if-gez': '>= 0',
                           'if-gtz': '> 0', 'if-lez': '<= 0'}[op]
                cond = '%s %s' % (reg, cmp)
            elif kind & K_REF and kind & K_INT:
                # the register holds an int on one path and a reference on
                # another one: the test is "zero or null"
                ireg = self.R(ra, K_INT)
                oreg = self.R(ra, K_REF)
                if op == 'if-eqz':
                    cond = '(%s == null && %s == 0)' % (oreg, ireg)
                else:
                    cond = '(%s != null || %s != 0)' % (oreg, ireg)
            elif kind & K_REF:
                # a reference register is tested against null
                reg = self.R(ra, K_REF)
                cmp = '== null' if op == 'if-eqz' else '!= null'
                cond = '%s %s' % (reg, cmp)
            elif kind & K_LONG and not kind & K_INT:
                reg = self.R(ra, K_LONG)
                cmp = {'if-eqz': '== 0L', 'if-nez': '!= 0L'}[op]
                cond = '%s %s' % (reg, cmp)
            else:
                reg = self.R(ra, K_INT)
                cmp = {'if-eqz': '== 0', 'if-nez': '!= 0'}[op]
                cond = '%s %s' % (reg, cmp)
            return ['if (%s) {' % cond,
                    '    st.pc = %d;' % target,
                    '    continue;',
                    '}']
        ra = regnum(args[0], m)
        rb = regnum(args[1], m)
        kind = self.an.cmp_kind(i, ra, rb)
        sym = {'if-eq': '==', 'if-ne': '!=', 'if-lt': '<', 'if-ge': '>=',
               'if-gt': '>', 'if-le': '<='}[op]
        return ['if (%s %s %s) {' % (self.R(ra, kind), sym, self.R(rb, kind)),
                '    st.pc = %d;' % target,
                '    continue;',
                '}']

    # ------------------------------------------------------------- output

    def result_suffix(self):
        ret = self.m.desc[self.m.desc.rindex(')') + 1:]
        if ret == 'V':
            return None
        if ret in ('I', 'Z', 'B', 'C', 'S', 'F'):
            return 'I'
        if ret == 'J':
            return 'J'
        if ret == 'D':
            return 'D'
        return 'O'

    def chunk_body(self, index, lo, hi):
        m = self.m
        p = self.prefix
        static = '' if (self.has_super and not self.is_static) else 'static '
        out = []
        out.append('    private %sboolean %s_c%d(%sState st) {' % (static, p, index, p))
        out.append('        try {')
        out.append('            while (true) {')
        out.append('                switch (st.pc) {')
        for i in range(lo, hi):
            op = m.insns[i][0]
            out.append('                    case %d:' % i)
            if op not in NO_THROW or i == hi - 1:
                out.append('                        st.pc = %d;' % i)
            for line in self.stmt(i):
                out.append('                        ' + line)
            if i == hi - 1 and op not in ('goto', 'goto/16', 'goto/32',
                                         'return', 'return-wide', 'return-object',
                                         'return-void', 'throw'):
                out.append('                        st.pc = %d;' % hi)
                out.append('                        return false;')
        out.append('                    default:')
        out.append('                        return false;')
        out.append('                }')
        out.append('            }')
        out.append('        } catch (java.lang.Throwable t) {')
        out.append('            int h = %s_handler(st.pc, t);' % p)
        out.append('            if (h < 0) {')
        out.append('                %s_rethrow(t);' % p)
        out.append('            }')
        out.append('            st.ex = t;')
        out.append('            st.pc = h;')
        out.append('            return false;')
        out.append('        }')
        out.append('    }')
        return out

    def dispatcher(self, chunks):
        p = self.prefix
        static = '' if (self.has_super and not self.is_static) else 'static '
        out = []
        out.append('    private %s%s %s_run(%sState st) {' % (static, self.java_ret, p, p))
        out.append('        while (true) {')
        out.append('            boolean done;')
        out.append('            int pc = st.pc;')
        for index, (lo, hi) in enumerate(chunks):
            out.append('            %sif (pc < %d) {' % ('else ' if index else '', hi))
            out.append('                done = %s_c%d(st);' % (p, index))
            out.append('            }')
        out.append('            else {')
        out.append('                done = %s_c%d(st);' % (p, len(chunks) - 1))
        out.append('            }')
        out.append('            if (done) {')
        suffix = self.result_suffix()
        if suffix is None:
            out.append('                return;')
        elif suffix == 'O':
            out.append('                return (%s) st.resultO;' % self.java_ret)
        elif suffix == 'D':
            out.append('                return st.resultD;')
        elif self.java_ret == 'boolean':
            out.append('                return st.resultI != 0;')
        elif self.java_ret in ('char', 'byte', 'short'):
            out.append('                return (%s) st.resultI;' % self.java_ret)
        else:
            out.append('                return st.result%s;' % suffix)
        out.append('            }')
        out.append('        }')
        out.append('    }')
        return out

    def state_class(self):
        p = self.prefix
        out = []
        out.append('    private static final class %sState {' % p)
        out.append('        int pc;')
        out.append('        int resultI;')
        out.append('        long resultJ;')
        out.append('        double resultD;')
        out.append('        java.lang.Object resultO;')
        out.append('        int tmpI;')
        out.append('        long tmpJ;')
        out.append('        double tmpD;')
        out.append('        java.lang.Object tmpO;')
        out.append('        java.lang.Throwable ex;')
        if self.has_monitor:
            out.append('        java.util.concurrent.locks.ReentrantLock mon;')
        for reg in sorted(self.fields):
            for kind in sorted(self.fields[reg]):
                if kind == K_INT:
                    out.append('        int v%di;' % reg)
                elif kind == K_LONG:
                    out.append('        long v%dj;' % reg)
                elif kind == K_DOUBLE:
                    out.append('        double v%dd;' % reg)
                else:
                    out.append('        java.lang.Object v%do;' % reg)
        out.append('    }')
        return out

    def handler_table(self):
        p = self.prefix
        ctypes = []
        entries = []
        for (ctype, start, end, handler) in self.m.catches:
            si = self.m.labels[start.lstrip(':')]
            ei = self.m.labels[end.lstrip(':')]
            hi = self.m.labels[handler.lstrip(':')]
            if ctype is None:
                ti = -1
            else:
                jt = jtype(ctype)
                if jt not in ctypes:
                    ctypes.append(jt)
                ti = ctypes.index(jt)
            entries.append((si, ei, hi, ti))
        out = []
        out.append('    private static final Class<?>[] %s_ctypes = {' % p)
        if ctypes:
            out.append('        ' + ', '.join('%s.class' % c for c in ctypes))
        out.append('    };')
        out.append('    private static final int[] %s_handlers = {' % p)
        vals = []
        for (si, ei, hi, ti) in entries:
            vals.extend([str(si), str(ei), str(hi), str(ti)])
        out.append('        ' + ', '.join(vals))
        out.append('    };')
        out.append('    private static int %s_handler(int pc, java.lang.Throwable t) {' % p)
        out.append('        for (int i = 0; i < %s_handlers.length; i += 4) {' % p)
        out.append('            if (pc < %s_handlers[i] || pc >= %s_handlers[i + 1]) {' % (p, p))
        out.append('                continue;')
        out.append('            }')
        out.append('            int ti = %s_handlers[i + 3];' % p)
        out.append('            if (ti < 0 || %s_ctypes[ti].isInstance(t)) {' % p)
        out.append('                return %s_handlers[i + 2];' % p)
        out.append('            }')
        out.append('        }')
        out.append('        return -1;')
        out.append('    }')
        return out

    def monitor_helper(self):
        """The helper that emulates a java monitor for the state machine."""
        p = self.prefix
        out = []
        out.append('    private static final java.util.concurrent.ConcurrentHashMap<Object, java.util.concurrent.locks.ReentrantLock> %s_monitors = new java.util.concurrent.ConcurrentHashMap<Object, java.util.concurrent.locks.ReentrantLock>();' % p)
        out.append('    private static java.util.concurrent.locks.ReentrantLock %s_monitor(java.lang.Object o) {' % p)
        out.append('        java.util.concurrent.locks.ReentrantLock l = %s_monitors.get(o);' % p)
        out.append('        if (l == null) {')
        out.append('            l = new java.util.concurrent.locks.ReentrantLock();')
        out.append('            java.util.concurrent.locks.ReentrantLock prev = %s_monitors.putIfAbsent(o, l);' % p)
        out.append('            if (prev != null) {')
        out.append('                l = prev;')
        out.append('            }')
        out.append('        }')
        out.append('        return l;')
        out.append('    }')
        return out

    def wrapper(self, java_sig):
        m = self.m
        p = self.prefix
        out = []
        out.append('    %s {' % java_sig)
        out.append('        %sState st = new %sState();' % (p, p))
        if not self.is_static:
            out.append('        %s = this;' % self.R(m.param_regs[0], K_REF))
        for j, (_jt, jn) in enumerate(self.java_params):
            pi = j if self.is_static else j + 1
            reg = m.param_regs[pi]
            ptype = m.params[pi]
            kind = kind_of_type(ptype)
            suffix = {K_INT: 'i', K_LONG: 'j', K_REF: 'o', K_DOUBLE: 'd'}[kind]
            value = jn
            if ptype == 'Z':
                value = '(%s ? 1 : 0)' % jn
            elif ptype in ('B', 'C', 'S'):
                value = '(int) %s' % jn
            out.append('        %s = %s;' % (self.R(reg, kind), value))
        if self.java_ret == 'void':
            out.append('        %s_run(st);' % p)
        else:
            out.append('        return %s_run(st);' % p)
        out.append('    }')
        return out

    def generate(self, java_sig, java_params):
        self.java_params = java_params
        prefix, _name, _params = parse_java_sig(java_sig)
        self.java_ret = prefix.split()[-1]
        m = self.m
        n = len(m.insns)
        chunks = []
        lo = 0
        while lo < n:
            hi = min(lo + self.chunk_size, n)
            chunks.append((lo, hi))
            lo = hi
        bodies = []
        for index, (lo, hi) in enumerate(chunks):
            bodies.append(self.chunk_body(index, lo, hi))
        lines = []
        lines.append('    /* ------------------------------------------------------------- *')
        lines.append('     *  %s' % m.header)
        lines.append('     *')
        lines.append('     *  Translated from the original dex code into plain java.')
        lines.append('     *  Every dalvik instruction becomes one java statement, the')
        lines.append('     *  register file lives in the state object below and the')
        lines.append('     *  control flow is a switch over the instruction index.')
        lines.append('     * ------------------------------------------------------------- */')
        lines.extend(self.wrapper(java_sig))
        lines.append('')
        lines.append('    @SuppressWarnings("unchecked")')
        lines.append('    private static <T extends Throwable> void %s_rethrow(java.lang.Throwable t) throws T {' % self.prefix)
        lines.append('        throw (T) t;')
        lines.append('    }')
        lines.append('')
        lines.extend(self.state_class())
        lines.append('')
        if self.has_monitor:
            lines.extend(self.monitor_helper())
            lines.append('')
        lines.extend(self.dispatcher(chunks))
        lines.append('')
        for body in bodies:
            lines.extend(body)
            lines.append('')
        lines.extend(self.handler_table())
        return lines


def parse_java_sig(sig):
    # split a java method signature into modifiers, name and parameters
    i = sig.index('(')
    # the parameter list ends at the first ')' - a trailing throws clause
    # may contain more parentheses
    j = sig.index(')', i)
    head = sig[:i].strip()
    mm = re.match(r'^(.*?)([A-Za-z_$][\w$]*)$', head)
    prefix = mm.group(1).strip()
    name = mm.group(2)
    params = []
    for part in split_args(sig[i + 1:j]):
        part = part.strip()
        if not part:
            continue
        mm2 = re.match(r'^(.*?)([A-Za-z_$][\w$]*)$', part)
        params.append((mm2.group(1).strip(), mm2.group(2)))
    return prefix, name, params


def main(argv):
    if len(argv) < 3:
        print(__doc__)
        return 1
    m = parse(argv[1], argv[2])
    gen = Generator(m, 'x', [], 'int', 'static' in m.access)
    java_sig = argv[3] if len(argv) > 3 else 'int x()'
    _prefix, _name, params = parse_java_sig(java_sig)
    for line in gen.generate(java_sig, params):
        print(line)
    return 0


if __name__ == '__main__':
    sys.exit(main(sys.argv))
