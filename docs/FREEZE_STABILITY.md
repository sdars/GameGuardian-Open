# The freeze of the panel and the stability of the target process

Every number below was measured on the device (MI 8 / Android 10 / LineageOS
17.1, APatch root, SELinux permissive) with the published build of this
repository installed, with the real daemon of the app
(`lib5.so`, md5 `615681e53ae55bf48b2b7409a0bd0c14` - the same file as
`app/src/main/res/raw/ydw5` of this tree) and with a real target process
(`com.gg.freezeprobe`, the test bed of `tools/freeze_probe`).
The scripts that reproduce the runs are `tools/freeze_flow.py`,
`tools/make_freeze_probe_apk.sh` and `tools/ggq.sh`.

## 1. The report

"Freezing a value seems to make the target application crash after a
while."

The freeze of the panel was never touched by the releases 3 and 4 - those
only changed the *read* path of the daemon (see
`docs/SPEED_HACK_EXEC_ONLY.md`) - so the question is what the daemon does
when the lock of a saved value is pressed and whether that can kill the
target.

## 2. What the daemon does when it freezes

The write of a value is done by one function, `ydw5+0x3dd04c`:

```
003dd08c  adrp   x8, #0x3f4000
003dd090  ldrb   w8, [x8, #0xb70]      ; the flag at ydw5+0x3f4b70
003dd094  cbz    w8, #0x3dd0c0         ; 0 -> the ptrace branch
003dd098  adrp   x8, #0x3ea000
003dd09c  ldr    w8, [x8, #0x740]      ; the pid of the attached process
003dd0a0  cmp    w8, w23              ; the pid of the target
003dd0a4  b.ne   #0x3dd0c0            ; another process -> the ptrace branch
003dd0ac  ldrb   w8, [x8, #0xb68]
003dd0b0  cbz    w8, #0x3dd13c        ; 0 -> process_vm_writev
...
003dd13c  ...                        ; process_vm_writev (syscall 0x10f)
003dd260  ...                        ; the ptrace branch: PTRACE_POKEDATA
```

The flags live in the bss of the daemon and are set by its self test.  The
values of the running daemon were read out of `/proc/<daemon>/mem` (the
load base of the data segment was `0x5d0dd1c010`):

| flag | value | meaning |
|---|---|---|
| `ydw5+0x3f4b65` | `0x00` | bit 3 is clear, the daemon uses the ptrace syscall |
| `ydw5+0x3f4b68` | `0x00` | |
| `ydw5+0x3f4b6c` | `0x00` | the read path uses `PTRACE_PEEKDATA` (the patch of release 3) |
| `ydw5+0x3f4b70` | `0xd4` | |
| `ydw5+0x3f4b74` | `0x00` | |
| `ydw5+0x3ea740` | `32764` | the pid of the attached process |

With those values the freeze of the attached process takes the
`process_vm_writev` branch: the daemon writes into the memory of the target
without attaching to it, so the target is never stopped.

The width of the write is the width of the type of the frozen value.  A
write that is shorter than eight bytes is done as a read - modify - write of
the aligned word (`ydw5+0x3dd1c8` copies the bytes of the value into the
word that was peeked), so the bytes behind the value stay untouched.

The interval of the freeze is a setting of the app
(`config_freeze_interval`, 33000 microseconds by default, see
`app/src/main/java/android/ext/Config.java`).

## 3. The measurements

The test bed keeps four words in the heap of the process:

| word | content |
|---|---|
| 0 | the value that is searched and frozen |
| 1 | the canary `0xA1A2A3A4` |
| 2 | the canary `0xB1B2B3B4` |
| 3 | a counter that changes every tick |

The search of the panel finds two copies of the value: the static field of
the class and the live array.  The live one is the copy whose counter
changes - `tools/freeze_flow.py` picks it that way, so the freeze is set on
the array of the process and not on a copy that the garbage collector left
behind.

The result of the run:

* the daemon wrote the frozen dword back into the target: 22 of 27 samples
  of the memory of the target held the frozen value, the other 5 held the
  poison that the test bed writes every 100 ms,
* both canary words behind the value stayed intact - the daemon writes four
  bytes for a dword and does not touch the rest of the word,
* `TracerPid` of the target was `0` in 51 of 51 samples over 20 seconds
  of the freeze: the daemon does not attach to the target, the target is
  never stopped and can not run into an ANR because of the freeze,
* the freeze types that read the value ("may increase", "may decrease",
  "in a range") read it the same way and also leave `TracerPid` at `0`,
* the target process stayed alive during the whole run.

## 4. What the search skips

The daemon of the panel does not search the spaces of the runtime that the
garbage collector does not move - the strings `dalvik-main`,
`dalvik-free`, `dalvik-large`, `dalvik-alloc` and `dalvik` are in the
binary of the daemon (`ydw5+0x4f06`, `0xab1e`, `0xb682`, `0xbf04`,
`0x8d23`).  A value in a direct byte buffer of the process lives in
`[anon:dalvik-non moving space]` and is therefore *not* found by the
search, while the same value in the heap of the process is found.  The test
bed keeps the value in the heap for that reason.

## 5. The state of the question

The freeze of the panel writes with the right width, without attaching to
the target and without an ANR.  The crash that was reported has not been
reproduced with these measurements - the remaining suspect is a freeze on
an address that the target does not use any more: the garbage collector
moves the array, the daemon keeps writing the frozen value into the old
address and the target writes something else there.  `tools/freeze_probe`
has a mode (`churn`) that moves the array on purpose to reproduce that
case.

The crash had a second cause, which was found after the release 4 and which
explains it without the moving array: the command stream of the app was
masked, so the daemon did not receive the number of the values and the
addresses that the panel had selected.  See section 6 and
`docs/PROTOCOL_WORD_MASK.md`.

## 6. The crash of the freeze: the word mask of the command stream

The freeze of the panel sends the command 36 to the daemon:

```java
// app/src/main/java/android/ext/f0$f0.java
inOut.q(this.f850b, (byte) 36, (android.ext.InOut.n + 4) * i2);
inOut.u(i2);                       // the number of the values
while (i < i3) {
    inOut.u(this.f849a[i]);         // the address of the value
    inOut.v(this.f851c[i]);         // the value
    i++;
}
```

`InOut.u()` writes the word masked with `byteOrderMask`, the field carries
the value `0xf` of the original dex and nothing in the app ever writes it
(`docs/PROTOCOL_WORD_MASK.md`).  With the mask of `0xf` the daemon received

* the number of the values `12` as `3` - it read three values out of the
  stream, took the rest of the bytes for the next command and wrote the
  values of the app into the wrong places of the target,
* the address of the value `0x1300cfcc` as `0x1300cfd3` - the daemon wrote
  the frozen value seven bytes behind the place the panel had selected.

Both corrupt the memory of the target: the first one writes the values into
the heap of the target at addresses that belong to other objects, the second
one overwrites a part of an object that the target uses.  A process that is
written into like that dies - sometimes right away, sometimes after a while,
when the corrupted object is used.

After the fix (`byteOrderMask = 0`) the run of `tools/freeze_flow.py`
against the test bed of the tool shows neither of them:

```
alive=18356 freeze=710 canary=0 ... status ticks=26600 freezes=709 corrupt=0
```

* the daemon wrote the frozen value back into the target 10 times out of 12
  samples of its memory,
* the canary behind the frozen word stayed intact (`canary=0`), the test bed
  counted no broken write (`corrupt=0`),
* the target process was alive during the whole run (720 freeze events in two
  minutes),
* the device wrote no tombstone of the target during the run.
