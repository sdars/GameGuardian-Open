#!/usr/bin/env python3
"""Use the nested class names of the generated R class.

jadx writes the resource references with the binary name of the inner
classes ("catch_.me_.if_.you_.can_.R$string").  The R class that the
android plugin generates declares them as nested classes, and for a nested
class javac only accepts the source name ("R.string").  This script rewrites
the references and rebuilds the stubs that the compile check uses.

jadx also renames a few resource fields when the original name cannot be
used as a java identifier.  The names are taken from the resource table of
the original apk, the mapping is kept in r_renames.json.
"""
import json
import os
import re
import shutil
import subprocess
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')
STUBS = os.path.join(ROOT, 'tools', 'stubs', 'java')
PKG = 'catch_.me_.if_.you_.can_'
MAPFILE = os.path.join(ROOT, 'tools', 'repair', 'r_renames.json')
RE = re.compile(re.escape(PKG) + r'\.R\$([A-Za-z0-9_]+)')

FIELD_RE = re.compile(r'public static final int ([A-Za-z0-9_]+) = (-?[0-9]+);')


def apk_resource_names(apk):
    """Map (type, id) to the resource name of the original apk."""
    aapt2 = os.path.join(ROOT, 'tmp', 'tools', 'android-sdk', 'build-tools',
                         '34.0.0', 'aapt2')
    if not os.path.exists(aapt2):
        aapt2 = shutil.which('aapt2')
    if not aapt2:
        raise SystemExit('aapt2 not found')
    out = subprocess.run([aapt2, 'dump', 'resources', apk],
                         stdout=subprocess.PIPE, stderr=subprocess.DEVNULL)
    names = {}
    for line in out.stdout.decode('utf-8', 'replace').split(chr(10)):
        m = re.match(r'\s*resource 0x([0-9a-f]+) (\w+)/(.+)\s*$', line)
        if m:
            names[(m.group(2), int(m.group(1), 16))] = m.group(3)
    return names


def collect_stub_fields():
    """The resource fields of the stub, read from the git history."""
    fields = {}
    src_dir = os.path.join(STUBS, *PKG.split('.'))
    names = []
    if os.path.isdir(src_dir):
        names = [n for n in sorted(os.listdir(src_dir))
                 if n.startswith('R$') and n.endswith('.java')]
    for name in names:
        kind = name[2:-5]
        body = open(os.path.join(src_dir, name), encoding='utf-8').read()
        for m in FIELD_RE.finditer(body):
            fields.setdefault(kind, {})[m.group(1)] = int(m.group(2))
    if not fields:
        # the stub was already rebuilt, take the fields from the history
        out = subprocess.run(['git', 'show', 'HEAD:tools/stubs/java/'
                              + '/'.join(PKG.split('.')) + '/R$string.java'],
                             cwd=ROOT, stdout=subprocess.PIPE,
                             stderr=subprocess.DEVNULL)
        for kind in ('string', 'drawable', 'id', 'layout', 'color', 'mipmap',
                     'raw', 'style', 'xml', 'dimen', 'attr'):
            out = subprocess.run(['git', 'show', 'HEAD:tools/stubs/java/'
                                  + '/'.join(PKG.split('.')) + '/R$' + kind + '.java'],
                                 cwd=ROOT, stdout=subprocess.PIPE,
                                 stderr=subprocess.DEVNULL)
            body = out.stdout.decode('utf-8', 'replace')
            for m in FIELD_RE.finditer(body):
                fields.setdefault(kind, {})[m.group(1)] = int(m.group(2))
    return fields


def rewrite_refs(renames):
    """renames: {kind: {old: new}}"""
    hits = 0
    for base, dirs, files in os.walk(SRC):
        for name in files:
            if not name.endswith('.java'):
                continue
            p = os.path.join(base, name)
            txt = open(p, encoding='utf-8').read()
            new = txt
            for kind, mapping in renames.items():
                for old, repl in mapping.items():
                    new = new.replace('%s.R.%s.' % (PKG, kind) + old,
                                      '%s.R.%s.' % (PKG, kind) + repl)
            if new != txt:
                open(p, 'w', encoding='utf-8').write(new)
                hits += 1
    return hits


def build_stubs(fields):
    """Rebuild the compile stubs as one R class with nested classes."""
    src_dir = os.path.join(STUBS, *PKG.split('.'))
    shutil.rmtree(src_dir, ignore_errors=True)
    os.makedirs(src_dir, exist_ok=True)
    out = []
    out.append('package %s;' % PKG)
    out.append('')
    out.append('/* Compile time stub of the resource class that the android')
    out.append('   plugin generates.  The identifiers are the ones of the')
    out.append('   original apk, the values are only used to compile. */')
    out.append('public final class R {')
    out.append('')
    out.append('    private R() {')
    out.append('    }')
    for kind in sorted(fields):
        out.append('')
        out.append('    public static final class %s {' % kind)
        for fname in sorted(fields[kind]):
            out.append('        public static final int %s = %d;' % (fname, fields[kind][fname]))
        out.append('    }')
    out.append('}')
    with open(os.path.join(src_dir, 'R.java'), 'w', encoding='utf-8') as fh:
        fh.write(chr(10).join(out) + chr(10))


def main():
    fields = collect_stub_fields()
    renames = {}
    if len(sys.argv) > 1:
        names = apk_resource_names(sys.argv[1])
        for kind, flist in fields.items():
            for fname, value in flist.items():
                real = names.get((kind, value))
                if real and real != fname:
                    renames.setdefault(kind, {})[fname] = real
        with open(MAPFILE, 'w', encoding='utf-8') as fh:
            json.dump(renames, fh, indent=2, sort_keys=True)
        print('renamed fields: %r' % renames)
    elif os.path.exists(MAPFILE):
        with open(MAPFILE, encoding='utf-8') as fh:
            renames = json.load(fh)
    else:
        renames = {}

    hits = 0
    for base, dirs, files in os.walk(SRC):
        for name in files:
            if not name.endswith('.java'):
                continue
            p = os.path.join(base, name)
            txt = open(p, encoding='utf-8').read()
            new, n = RE.subn(PKG + r'.R.\1', txt)
            if n:
                open(p, 'w', encoding='utf-8').write(new)
                hits += n
    print('rewrote %d resource references' % hits)
    if renames:
        print('renamed %d files' % rewrite_refs(renames))
    for kind, mapping in renames.items():
        if kind in fields:
            for old, repl in mapping.items():
                if old in fields[kind]:
                    fields[kind][repl] = fields[kind].pop(old)
    build_stubs(fields)
    print('stub rebuilt with %d resource classes' % len(fields))


if __name__ == '__main__':
    main()
