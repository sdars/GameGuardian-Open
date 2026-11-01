#!/usr/bin/env python3
"""The remaining hand repairs, each one driven by a javac diagnostic.

Group 1 (generic, error driven)
  * raw collections in a for-each  ->  cast the iterable to
    Collection<Element> so the loop variable keeps its type
  * "x != 0" where x is an object   ->  "x != null"

Group 2 (explicit, one patch per site)
  everything else - see the comments in front of each patch.
"""
import os
import re

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')
ERRLOG = os.environ.get('GG_ERRLOG', '/tmp/ggjc_err.log')

# ---------------------------------------------------------------- explicit
PATCHES = [
    # --- top level types may not be "protected" ---------------------------
    ('luaj/lib/IoLib$File.java',
     'protected abstract class IoLib$File extends luaj.LuaValue {',
     'public abstract class IoLib$File extends luaj.LuaValue {'),
    ('luaj/lib/LibFunction$a.java',
     'protected interface LibFunction$a {',
     'interface LibFunction$a {'),
    ('luaj/lib/MathLib$BinaryOp.java',
     'protected abstract class MathLib$BinaryOp extends luaj.lib.TwoArgFunction {',
     'abstract class MathLib$BinaryOp extends luaj.lib.TwoArgFunction {'),
    ('luaj/lib/MathLib$UnaryOp.java',
     'protected abstract class MathLib$UnaryOp extends luaj.lib.OneArgFunction {',
     'abstract class MathLib$UnaryOp extends luaj.lib.OneArgFunction {'),

    # --- the file abstraction really does throw IOException ---------------
    ('luaj/lib/IoLib$File.java',
     'public abstract void S2();',
     'public abstract void S2() throws java.io.IOException;'),
    ('luaj/lib/IoLib$File.java',
     'public abstract void U2();',
     'public abstract void U2() throws java.io.IOException;'),
    ('luaj/lib/IoLib$File.java',
     'public abstract int X2();',
     'public abstract int X2() throws java.io.IOException;'),
    ('luaj/lib/IoLib$File.java',
     'public abstract int Y2();',
     'public abstract int Y2() throws java.io.IOException;'),
    ('luaj/lib/IoLib$File.java',
     'public abstract int Z2(byte[] bArr, int i, int i2);',
     'public abstract int Z2(byte[] bArr, int i, int i2) throws java.io.IOException;'),
    ('luaj/lib/IoLib$File.java',
     'public abstract int a3();',
     'public abstract int a3() throws java.io.IOException;'),
    ('luaj/lib/IoLib$File.java',
     'public abstract int b3(java.lang.String str, int i);',
     'public abstract int b3(java.lang.String str, int i) throws java.io.IOException;'),
    ('luaj/lib/IoLib$File.java',
     'public abstract void c3(java.lang.String str, int i);',
     'public abstract void c3(java.lang.String str, int i) throws java.io.IOException;'),
    ('luaj/lib/IoLib$File.java',
     'public abstract void d3(luaj.LuaString luaString);',
     'public abstract void d3(luaj.LuaString luaString) throws java.io.IOException;'),

    # --- checked exceptions that the base class does not declare ---------
    ('luaj/lib/PackageLib$require.java',
     'public luaj.LuaValue call(luaj.LuaValue luaValue) throws java.lang.Exception {',
     'public luaj.LuaValue call(luaj.LuaValue luaValue) {'),
    ('luaj/lib/PackageLib$require.java',
     """                    dVar.i = sb.toString();
                }
                throw e2;""",
     """                    dVar.i = sb.toString();
                    throw dVar;
                }
                throw new java.lang.RuntimeException(e2);"""),

    # --- Runnable / UncaughtExceptionHandler do not throw ------------------
    ('android/ext/f0$d0$a.java',
     'public void run() throws java.lang.Throwable {',
     'public void run() {'),
    ('android/ext/n0.java',
     'public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) throws java.lang.InterruptedException {',
     'public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {'),

    # --- the framework classes are reached through the class, not a local --
    ('android/ext/Tools.java',
     'k = r.n.getPackageManager();',
     'k = android.ext.r.n.getPackageManager();'),
    ('android/ext/Tools.java',
     'k = r.n.getApplication().getPackageManager();',
     'k = android.ext.r.n.getApplication().getPackageManager();'),
    ('android/ext/Tools.java',
     'k = r.n.getApplicationContext().getPackageManager();',
     'k = android.ext.r.n.getApplicationContext().getPackageManager();'),
    ('android/ext/Tools.java',
     'windowToken = r.n.getWindow().getAttributes().token;',
     'windowToken = android.ext.r.n.getWindow().getAttributes().token;'),
    ('android/ext/Tools.java',
     'windowToken = r.n.getWindow().getDecorView().getRootView().getWindowToken();',
     'windowToken = android.ext.r.n.getWindow().getDecorView().getRootView().getWindowToken();'),
    ('android/ext/b1.java',
     'r.n.startActivityForResult(intent, 4);',
     'android.ext.r.n.startActivityForResult(intent, 4);'),
    ('android/ext/b1.java',
     'android.content.Intent intent = r.n.getIntent();',
     'android.content.Intent intent = android.ext.r.n.getIntent();'),

    # --- protected members of a JDK stream are reached through "this" ------
    ('android/lang/UNIXProcess$f.java',
     '((java.io.BufferedInputStream) this).in',
     'this.in'),
    ('android/lang/UNIXProcess$f.java',
     '((java.io.BufferedInputStream) this).buf',
     'this.buf'),
    ('android/lang/UNIXProcess$g.java',
     '((java.io.BufferedOutputStream) this).out',
     'this.out'),
    ('luaj/Globals$c.java',
     '((java.io.PushbackInputStream) this).buf',
     'this.buf'),
    ('luaj/Globals$c.java',
     '((java.io.PushbackInputStream) this).pos',
     'this.pos'),
    ('luaj/Globals$c.java',
     '((java.io.PushbackInputStream) this).in',
     'this.in'),
    ('luaj/lib/BaseLib$b.java',
     '((java.io.BufferedInputStream) this).in',
     'this.in'),

    # --- null checks instead of "!= 0" ------------------------------------
    ('android/ext/Script$prompt.java',
     'if (textView != 0 && (luaValue = (luaj.LuaValue) textView.getTag()) != null) {',
     'if (textView != null && (luaValue = (luaj.LuaValue) textView.getTag()) != null) {'),
    ('android/ext/Tools.java',
     'if (r3 != 0) {',
     'if (r3 != null) {'),
    ('android/ext/Tools.java',
     'r3 = r1;',
     'r3 = null;'),

    # --- jadx lost the type of the generic base class ---------------------
    ('android/ext/ArrayAdapter.java',
     'super(context, i, i2, objArr);',
     'super(context, i, i2, (T[]) objArr);'),

    # --- the comparison needs the narrowed type ---------------------------
    ('luaj/LuaClosure.java',
     'luaj.d d_a = th instanceof luaj.d ? th : new luaj.d$a(th);',
     'luaj.d d_a = th instanceof luaj.d ? (luaj.d) th : new luaj.d$a(th);'),

    # --- a local shadowed a field of the same name ------------------------
    ('android/ext/q0$b.java',
     'i = id == 2131034381 ? 536870912 : 0;',
     'int ggSpinnerFlag = id == 2131034381 ? 536870912 : 0;'),
    ('android/ext/q0$b.java',
     'systemSpinner.setSelected(this.t.getInt(android.ext.b2.b(id), i));',
     'systemSpinner.setSelected(this.t.getInt(android.ext.b2.b(id), ggSpinnerFlag));'),
    ('android/ext/q0$b.java',
     'g2Var.g(android.ext.b2.b(id), systemSpinner.getSelected(), i);',
     'g2Var.g(android.ext.b2.b(id), systemSpinner.getSelected(), ggSpinnerFlag);'),

    # --- jadx invented an assignment to a final field ----------------------
    ('android/ext/f0.java',
     '        z = (false ? 1 : 0);\n',
     ''),
    ('android/ext/Script$multiChoice.java',
     '            z = (false ? 1 : 0);\n',
     ''),

    # --- jadx dropped the type argument of the generic base type ---------
    ('android/ext/ConfigListAdapter$q.java',
     'class ConfigListAdapter$q implements java.util.Comparator {',
     'class ConfigListAdapter$q implements java.util.Comparator<java.lang.String> {'),
    ('android/ext/PathSelector$a.java',
     'class PathSelector$a implements java.util.Comparator {',
     'class PathSelector$a implements java.util.Comparator<android.ext.PathSelector$d> {'),
    ('android/ext/PathSelector$b.java',
     'class PathSelector$b implements java.util.Comparator {',
     'class PathSelector$b implements java.util.Comparator<android.ext.PathSelector$d> {'),
    ('android/ext/f0$m0.java',
     'class f0$m0 implements java.lang.Comparable {',
     'class f0$m0 implements java.lang.Comparable<android.ext.f0$m0> {'),
    ('android/ext/m$a.java',
     'class m$a implements java.lang.Comparable {',
     'class m$a implements java.lang.Comparable<android.ext.m$a> {'),
    ('android/ext/t1$a$a.java',
     'class t1$a$a implements java.util.Comparator {',
     'class t1$a$a implements java.util.Comparator<java.lang.String> {'),
    ('android/ext/z1$d.java',
     'public class z1$d implements java.lang.Comparable {',
     'public class z1$d implements java.lang.Comparable<android.ext.z1$d> {'),
    ('android/lang/ProcessEnvironment$b.java',
     'class ProcessEnvironment$b implements java.util.Map.Entry {',
     'class ProcessEnvironment$b implements java.util.Map.Entry<java.lang.String, java.lang.String> {'),
    ('android/lang/ProcessEnvironment$c$b.java',
     'class ProcessEnvironment$c$b implements java.util.Map.Entry {',
     'class ProcessEnvironment$c$b implements java.util.Map.Entry<android.lang.ProcessEnvironment$h, android.lang.ProcessEnvironment$g> {'),
    ('android/lang/ProcessEnvironment$g.java',
     'class ProcessEnvironment$g extends android.lang.ProcessEnvironment$a implements java.lang.Comparable {',
     'class ProcessEnvironment$g extends android.lang.ProcessEnvironment$a implements java.lang.Comparable<android.lang.ProcessEnvironment$g> {'),
    ('android/lang/ProcessEnvironment$h.java',
     'class ProcessEnvironment$h extends android.lang.ProcessEnvironment$a implements java.lang.Comparable {',
     'class ProcessEnvironment$h extends android.lang.ProcessEnvironment$a implements java.lang.Comparable<android.lang.ProcessEnvironment$h> {'),
    ('android/lang/ProcessEnvironment$d.java',
     'class ProcessEnvironment$d extends java.util.AbstractMap {',
     'class ProcessEnvironment$d extends java.util.AbstractMap<java.lang.String, java.lang.String> {'),
]


def apply_patches():
    n = 0
    for rel, old, new in PATCHES:
        path = os.path.join(SRC, rel)
        if not os.path.exists(path):
            print('MISSING', rel)
            continue
        text = open(path, encoding='utf-8').read()
        text, hits = replace_guarded(text, old, new)
        if not hits:
            print('NOT FOUND in %s: %r' % (rel, old[:70]))
            continue
        open(path, 'w', encoding='utf-8').write(text)
        n += 1
    print('explicit patches applied:', n)


def replace_guarded(text, old, new):
    """Replace every occurrence of "old" that is not part of a longer name.

    The guard keeps the patch idempotent: once "r.n.foo()" has become
    "android.ext.r.n.foo()" the inner "r.n.foo()" is preceded by a dot and
    is left alone, so re-running the script cannot prefix it again.
    """
    out = []
    pos = 0
    hits = 0
    while True:
        i = text.find(old, pos)
        if i < 0:
            break
        prev = text[i - 1] if i > 0 else ' '
        if prev.isalnum() or prev in '_$.':
            out.append(text[pos:i + len(old)])
            pos = i + len(old)
            continue
        out.append(text[pos:i])
        out.append(new)
        pos = i + len(old)
        hits += 1
    out.append(text[pos:])
    return ''.join(out), hits


FOREACH_RE = re.compile(
    r'for\s*\(\s*(?P<type>[A-Za-z_$][\w.$]*)\s+(?P<var>[A-Za-z_$][\w$]*)\s*:\s*'
    r'(?P<expr>[^;]*?)\s*\)\s*\{')


def fix_foreach():
    """Cast the iterable of a raw for-each to Collection<Element>."""
    if not os.path.exists(ERRLOG):
        return
    targets = set()
    lines = open(ERRLOG, encoding='utf-8', errors='replace').read().split('\n')
    for i, line in enumerate(lines):
        if ': error: incompatible types: Object cannot be converted to' not in line:
            continue
        m = re.match(r'^(?P<f>[^:]+\.java):(?P<l>\d+): error:', line)
        if m and i + 1 < len(lines):
            targets.add((m.group('f'), int(m.group('l'))))
    by_file = {}
    for f, l in targets:
        by_file.setdefault(f, set()).add(l)
    n = 0
    for f, linenos in by_file.items():
        path = f if os.path.isabs(f) else os.path.join(SRC, f)
        if not os.path.exists(path):
            continue
        text = open(path, encoding='utf-8').read()
        lines = text.split('\n')
        for ln in linenos:
            idx = ln - 1
            if idx >= len(lines):
                continue
            m = FOREACH_RE.search(lines[idx])
            if not m:
                continue
            typ = m.group('type')
            expr = m.group('expr')
            lines[idx] = (lines[idx][:m.start('expr')] +
                          '(java.util.Collection<%s>) %s' % (typ, expr) +
                          lines[idx][m.end('expr'):])
            n += 1
        open(path, 'w', encoding='utf-8').write('\n'.join(lines))
    print('for-each loops retyped:', n)


def main():
    apply_patches()
    fix_foreach()


if __name__ == '__main__':
    main()
