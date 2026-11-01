#!/usr/bin/env python3
"""Repair the try/catch wrappers that were inserted around checked exceptions.

Two problems are fixed here:

* a wrapped *local declaration* kept its scope inside the try block, so the
  variable was no longer visible afterwards -> the declaration is split into
  "Type name;" plus an assignment inside the try;
* the catch parameters were all called "e", which collides with an existing
  local of the same method -> they get unique names.
"""
import os
import re
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')

WRAP = re.compile(
    r'try \{\n(?P<stmt>.*?)\n(?P<ind>[ \t]*)\} catch \(java\.lang\.RuntimeException (?P<e1>\w+)\) \{\n'
    r'[ \t]*throw (?P=e1);\n[ \t]*\} catch \(java\.lang\.Throwable (?P<e2>\w+)\) \{\n'
    r'[ \t]*throw new java\.lang\.RuntimeException\((?P=e2)\);\n[ \t]*\}',
    re.S)

DECL = re.compile(r'^(?P<head>[A-Za-z_$][\w.$]*(?:<[^=;]*>)?(?:\[\])*)\s+'
                  r'(?P<name>[A-Za-z_$][\w$]*)\s*=\s*(?P<init>.+)$', re.S)

CTRL = re.compile(r'^\s*(if|for|while|switch|do|try|synchronized)\b')


def top_level_comma(s):
    depth = 0
    for c in s:
        if c in '([{':
            depth += 1
        elif c in ')]}':
            depth -= 1
        elif c == ',' and depth == 0:
            return True
    return False


def indent_of(text, pos):
    j = pos
    while j > 0 and text[j - 1] in ' \t':
        j -= 1
    if j == 0 or text[j - 1] == '\n':
        return text[j:pos]
    return ''


def main():
    fixed = 0
    renamed = 0
    for root, _dirs, files in os.walk(SRC):
        for fn in files:
            if not fn.endswith('.java'):
                continue
            p = os.path.join(root, fn)
            text = open(p, encoding='utf-8').read()
            out = text
            pending = []
            for m in list(WRAP.finditer(text)):
                stmt = m.group('stmt')
                ind = m.group('ind')
                lead = re.match(r'[ \t]*\n[ \t]*', stmt)
                if lead:
                    stmt = stmt[lead.end():]
                dm = DECL.match(stmt)
                repl = m.group(0)
                if dm and not CTRL.match(stmt) and not top_level_comma(dm.group('init')) \
                        and 'final' not in dm.group('head'):
                    body_ind = indent_of(out, m.start('stmt') + (lead.end() if lead else 0))
                    repl = ('%s %s;\n%stry {\n%s%s = %s;\n%s} catch (java.lang.RuntimeException ggEx) {\n'
                            '%s    throw ggEx;\n%s} catch (java.lang.Throwable ggEx2) {\n'
                            '%s    throw new java.lang.RuntimeException(ggEx2);\n%s}'
                            % (dm.group('head'), dm.group('name'), body_ind, body_ind,
                               dm.group('name'), dm.group('init').strip(), body_ind,
                               body_ind, body_ind, body_ind, body_ind))
                    fixed += 1
                e1 = m.group('e1')
                e2 = m.group('e2')
                if e1 != 'ggEx':
                    repl = repl.replace('catch (java.lang.RuntimeException %s)' % e1,
                                        'catch (java.lang.RuntimeException ggEx)')
                    repl = repl.replace('throw %s;' % e1, 'throw ggEx;')
                if e2 != 'ggEx2':
                    repl = repl.replace('catch (java.lang.Throwable %s)' % e2,
                                        'catch (java.lang.Throwable ggEx2)')
                    repl = repl.replace('new java.lang.RuntimeException(%s);' % e2,
                                        'new java.lang.RuntimeException(ggEx2);')
                pending.append((m.start(), m.end(), repl))
                renamed += 1
            for s, e, repl in sorted(pending, reverse=True):
                out = out[:s] + repl + out[e:]
            if out != text:
                open(p, 'w', encoding='utf-8').write(out)
    print('wrappers fixed:', fixed, ' wrappers renamed:', renamed)
    return 0


if __name__ == '__main__':
    sys.exit(main())
