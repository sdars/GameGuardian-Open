# GameGuardian 101.4 - open source reconstruction, fix release 3

Clean-room **Java reconstruction of GameGuardian 101.4**
(`catch_.me_.if_.you_.can_`, versionCode `16155`).

This release fixes the speed hack and the value search on the processes whose
code pages the linker maps as execute only.  Before the fix the daemon
answered with `{107}` - *"this process does not support the speed hack"* -
on every process of an application with `targetSdk >= 29` on Android 10 and
newer, and the value search of such a process found nothing.

| | |
|---|---|
| asset | `GameGuardian-101.4-open.apk` |
| sha256 | `89a6785f3e1f6656f749558ffe94184832b90bd027b270eb525b885e487af0d5` |
| size | 17 896 103 bytes |
| dex sha256 | `5e803d5e945b118c9bed8eafac46440bfc8c158681913f227f58bf398ae78819` |
| dex md5 | `01a772b9275364546084145543229232` |
| tag | `v101.4-open-source.3` |
| repository | `sdars/GameGuardian-Open-Source` - independent repository, not a fork |
| based on | `v101.4-open-source.2` |

## 1. The root cause

Since Android 10 the linker maps the system libraries of an application with
`targetSdk >= 29` as `--xp` (execute only).  `process_vm_readv` can not read
such a page - it fails with `EFAULT` - and the daemon of GameGuardian reads
the code page of the hook point that way:

```
I/android-daemon: VM_FAIL 2: -1 72fe125000, 16, 14, Bad address
E/android-daemon: Call point backup read failed at 72fe125000
E/android-daemon: Report Error: 107
```

The daemon contains a second implementation of the same read, a
`PTRACE_PEEKDATA` loop that works on execute only pages, but which of the two
is used is decided by one byte in the bss of the daemon.  That byte is set by
the self test of the daemon, and the self test reads back a marker that the
daemon has written into *its own* stack - so the test always succeeds and the
daemon always ends up with the `process_vm_readv` implementation, even when
the target uses execute only mappings.

The full analysis, the disassembly of the daemon and the patch sites of every
architecture are in `docs/SPEED_HACK_EXEC_ONLY.md`.

## 2. The fix

`tools/patch_daemon.py` changes the two instructions of the self test that
set the byte, so that the daemon keeps the `PTRACE_PEEKDATA` implementation:

| daemon | arch | site 1 | site 2 |
|---|---|---|---|
| `ydw5` | arm64 | `0x3d90e0` | `0x3d9100` |
| `ydw7` | arm 32 bit | `0x486bfc` | `0x486c28` |
| `ydw8` | arm 32 bit | `0x4863c8` | `0x4863f4` |
| `ydw2` | x86 64 bit | `0x47c2c8` | `0x47c2e2` |
| `ydw0` | x86 32 bit | `0x4a4805` | `0x4a481b` |
| `ydw1` | x86 32 bit | `0x4a4725` | `0x4a473b` |

The patch is applied to the copies of the daemon in this repository
(`app/src/main/res/raw` and `build/ydw/res/raw`), the script is idempotent
and it refuses to touch a file that does not carry the expected instruction.
The dex of the app is unchanged - the fix is in the daemon binary that the
app unpacks, so the dex hash is the one of release 2.

## 3. The verification on the device

The speed panel of the build with the patched daemon, on the process of the
system user interface (`[26145] systemui`, arm64, `targetSdk 29`):

```
I/android-daemon: hook 2 installed: 131
E/android-daemon: Send code: 11
```

No `VM_FAIL` and no `Report Error` in the log of the run; the same target
answered with `Report Error: 107` before the patch.  The matrix of the
targets reports `errors=none` for the Play Store, the 32 bit test process,
the launcher, the settings and the system user interface, with 88 hook
points found in the process of the Play Store and 82 in the process of the
system user interface.

The value search of the same build still works, the daemon is attached to the
target and can read it with `ptrace`:

```
E/AndroidService: sendSearchNumber: 777; 0 x0 as 20000004 in 0-ffffffffffffffff, 0
I/android-daemon: searchNumber: 777; 0, 20000004 0-ffffffffffffffff
I/android-daemon: ::searchDone: 5, 5 0
```

## 4. What was not changed

* No mock, no local stand in, no fallback: every number of this release was
  produced by the daemon of the app on the device against the real
  processes.
* SELinux was not changed: the device stayed in the state it was in
  (`getenforce` -> `Permissive`).
* The daemon of the original application was not touched.
