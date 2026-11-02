#!/usr/bin/env python3
import re


GEN_MARK = 'Translated from the original dex code into plain java.'


def drop_generated(lines, prefix):
    """Remove members that a previous run of the generator produced.

    The mechanically translated code comes with helpers named
    ``<prefix>_run``, ``<prefix>_cN``, ``<prefix>State`` ...  Re-running the
    generator must not leave the previous copies behind, so they are
    stripped before the fresh block is spliced in.
    """
    pat = re.compile(r'\b' + re.escape(prefix) + r'(?:_[\w$]*|State)\b')
    out = []
    i = 0
    n = len(lines)
    while i < n:
        line = lines[i]
        # the banner comment of a previously generated method
        if line.startswith('    /* ---') and line.rstrip().endswith('*'):
            j = i
            block = []
            while j < n:
                block.append(lines[j])
                if '*/' in lines[j]:
                    break
                j += 1
            if any(GEN_MARK in b for b in block):
                i = j + 1
                continue
        if (line.startswith('    ') and not line.startswith('     ')
                and pat.search(line)
                and ('(' in line or 'class ' in line or '=' in line)):
            depth = 0
            started = False
            while i < n:
                depth += lines[i].count('{') - lines[i].count('}')
                if '{' in lines[i]:
                    started = True
                i += 1
                if started and depth == 0:
                    break
            if i < n and not lines[i].strip():
                i += 1
            # the annotations of the removed member go with it
            while out and out[-1].strip().startswith('@'):
                out.pop()
            if out and not out[-1].strip():
                out.pop()
            continue
        out.append(line)
        i += 1
    return out
