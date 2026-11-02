#!/usr/bin/env python3
"""Keep the runtime type of a failure when it crosses a java call site.

The dex format has no checked exceptions: a handler matches the runtime
type of the failure, no matter what the java signatures declare.  The
reconstruction of the *java* sources has to satisfy javac, which does know
about checked exceptions, so tools/repair/fix_checked_exceptions.py wraps
every call of a method that declares one:

    try {
        ...
    } catch (java.lang.RuntimeException e) {
        throw e;
    } catch (java.lang.Throwable e) {
        throw new java.lang.RuntimeException(e);
    }

That wrapper compiles, but it changes the *runtime* type of the failure:
a java.io.IOException leaves the method as a java.lang.RuntimeException.
Every dex handler that catches the original type stops matching, and the
failure ends up in a catch-all handler instead of the handler the original
code had.  The reconstruction of GameGuardian showed exactly that on the
device: android.ext.z1 asks for the application info of a process that is
not a package ("com.google.android.gms.persistent"), the dex handler of
android.ext.Tools.Y catches the PackageManager.NameNotFoundException and
skips the process - with the wrapper the failure arrived as a
RuntimeException, escaped the handler and killed the process list:

    java.lang.RuntimeException: android.content.pm.PackageManager$NameNotFoundException:
    com.google.android.gms.persistent

The fix keeps the failure type intact: the catch-all handler re-throws the
failure with its original type (the "sneaky throw" idiom), which is what
the dex runtime does.  javac does not see a checked exception there, so the
dex handlers that catch a concrete type keep their
"if (GgNoop.never) throw new <type>()" guard (tools/repair/
fix_never_thrown.py) and stay reachable.

The wrapper is a machine artefact: it appears in none of the decompilations
of the original apk (jadx, jadx 1.5.6 and cfr), so every occurrence of it
in the reconstruction can be replaced.

    tools/repair/fix_exception_wrappers.py [--check]
"""
import os
import re
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')

PATTERN = re.compile(
    r'catch\s*\(\s*java\.lang\.RuntimeException\s+(?P<v1>\w+)\s*\)\s*\{\s*'
    r'throw\s+(?P=v1)\s*;\s*\}\s*'
    r'catch\s*\(\s*java\.lang\.Throwable\s+(?P<v2>\w+)\s*\)\s*\{\s*'
    r'throw\s+new\s+java\.lang\.RuntimeException\s*\(\s*(?P=v2)\s*\)\s*;\s*\}')


def indent_of(text, pos):
    line = text.rfind('\n', 0, pos) + 1
    i = line
    while i < len(text) and text[i] in ' \t':
        i += 1
    return text[line:i]


def replacement(match, text):
    ind = indent_of(text, match.start())
    var = match.group('v2')
    return ('catch (java.lang.Throwable %s) {\n'
            '%s    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(%s);\n'
            '%s}' % (var, ind, var, ind))


def main():
    check = '--check' in sys.argv[1:]
    total = 0
    files = 0
    for dirpath, _dirs, names in os.walk(SRC):
        for name in sorted(names):
            if not name.endswith('.java'):
                continue
            path = os.path.join(dirpath, name)
            with open(path, encoding='utf-8') as fh:
                text = fh.read()
            hits = PATTERN.findall(text)
            if not hits:
                continue
            files += 1
            total += len(hits)
            if check:
                print('%s: %d wrapper(s)' % (os.path.relpath(path, ROOT), len(hits)))
                continue
            new = PATTERN.sub(lambda m: replacement(m, text), text)
            with open(path, 'w', encoding='utf-8') as fh:
                fh.write(new)
            print('%s: %d wrapper(s) replaced' % (os.path.relpath(path, ROOT), len(hits)))
    print('==> %d wrapper(s) in %d file(s)%s' % (total, files, ' (check mode)' if check else ''))
    return 0


if __name__ == '__main__':
    sys.exit(main())
