# The speed hack and the value search on execute only pages

All numbers below were measured on a MI8 / Android 10 (SDK 29) / LineageOS 17.1
device with the reconstruction installed, and were read back from the log of
the daemon (`adb logcat -d | grep -a android-daemon`) and from the pixels of
the screen.  The scripts that reproduce them are `tools/speed_matrix.py`,
`tools/search_verify.py` and `tools/patch_daemon.py`.

## 1. The symptom

The floating panel of the app answered every speed hack request with
`{107}` - *"this process does not support the speed hack"* - on the processes
of the system, while the value search of the same build returned nothing.

The daemon of the app says why:

```
I/android-daemon: VM_FAIL 2: -1 72fe125000, 16, 14, Bad address
E/android-daemon: Call point backup read failed at 72fe125000
E/android-daemon: Report Error: 107
```

`72fe125000` is a code page of the target process, `16` is the length of the
read and `Bad address` is `EFAULT` of `process_vm_readv`.

## 2. The root cause

Since Android 10 the linker maps the system libraries of an application with
`targetSdk >= 29` as `--xp` (execute only):

```
72ecabd000 r-xp  /system/lib64/libcompiler_rt.so
72ecb76000 r-xp  /system/lib64/eglSubDriverAndroid.so
72ecb94000 r-xp  /system/lib64/libGLESv1_CM_adreno.so
```

`process_vm_readv` can not read such a page - it fails with `EFAULT` - and
the daemon of GameGuardian reads the code page of the hook point that way.
The hook is therefore never installed and the daemon reports the error code
107, which the app turns into "this process does not support the speed hack".
The value search reads the same way, so it finds nothing either.

The daemon already contains a second implementation of the same read: it
peeks the memory word by word with `PTRACE_PEEKDATA`, and that one works on
execute only pages.  Which one is used is decided by one byte in the bss of
the daemon:

```
ydw5+0x3dccc0  ldrb  w8, [x8, #0xb6c]      ; the byte at ydw5+0x3f4b6c
ydw5+0x3dccc4  cbz   w8, #0x3dcd08         ; 0 -> ptrace, 1 -> process_vm_readv
ydw5+0x3dcd7c  mov   w0, #2                ; PTRACE_PEEKDATA
ydw5+0x3dcd8c  bl    ptrace
```

The byte is set by the self test of the daemon (`ydw5+0x3d8fb4`): the daemon
writes the marker `0xbaad` into its own stack, reads it back with
`process_vm_readv` and, if that works, sets the byte to 1:

```
ydw5+0x3d8fd4  mov   w9, #0xbaad           ; the marker
ydw5+0x3d9010  mov   w0, #0x10f            ; __NR_process_vm_writev
ydw5+0x3d9068  mov   w0, #0x10e            ; __NR_process_vm_readv
ydw5+0x3d90e0  mov   w10, #1              ; <-- the byte is set to 1
ydw5+0x3d90e8  strb  w10, [x8]
ydw5+0x3d9100  mov   w10, #1              ; <-- and here
ydw5+0x3d9104  strb  w10, [x9]
```

The test always succeeds - the daemon tests *itself*, never the target - so
the daemon always ends up with the `process_vm_readv` implementation, even
when the target process uses execute only mappings.  The daemon therefore
reports "this process does not support the speed hack" for exactly those
processes whose code pages the linker mapped as `--xp`.

## 3. The fix

`tools/patch_daemon.py` changes the two instructions that set the byte so
that the daemon keeps the `PTRACE_PEEKDATA` implementation.  The self test
still runs, but the bytes stay 0 and the daemon reads every page of the
target with `ptrace`, which works on execute only pages as well.

The daemon of every architecture carries the same self test, so the patch
was applied to all of them:

| daemon | arch | site 1 | site 2 | instruction |
|---|---|---|---|---|
| `ydw5` | arm64 | `0x3d90e0` | `0x3d9100` | `mov w10, #1` -> `mov w10, #0` |
| `ydw7` | arm 32 bit | `0x486bfc` | `0x486c28` | `mov r0/r1, #1` -> `mov r0/r1, #0` |
| `ydw8` | arm 32 bit | `0x4863c8` | `0x4863f4` | `mov r0/r1, #1` -> `mov r0/r1, #0` |
| `ydw2` | x86 64 bit | `0x47c2c8` | `0x47c2e2` | `mov byte ptr [rax], 1` -> `... , 0` |
| `ydw0` | x86 32 bit | `0x4a4805` | `0x4a481b` | `mov byte ptr [eax], 1` -> `... , 0` |
| `ydw1` | x86 32 bit | `0x4a4725` | `0x4a473b` | `mov byte ptr [eax], 1` -> `... , 0` |

The script is idempotent and refuses to touch a file that does not carry the
expected instruction:

```
$ python3 tools/patch_daemon.py --check
/root/gameguardian/app/src/main/res/raw/ydw0: patched
/root/gameguardian/app/src/main/res/raw/ydw1: patched
/root/gameguardian/app/src/main/res/raw/ydw2: patched
/root/gameguardian/app/src/main/res/raw/ydw5: patched
/root/gameguardian/app/src/main/res/raw/ydw7: patched
/root/gameguardian/app/src/main/res/raw/ydw8: patched
```

## 4. The evidence

The speed panel of the build with the patched daemon, on the process of the
system user interface (`[26145] systemui`, arm64, `targetSdk 29`):

```
I/android-daemon: hook 2 installed: 131
E/android-daemon: Send code: 11
```

No `VM_FAIL` and no `Report Error` in the log of the run - the same target
answered with `Report Error: 107` before the patch.  The matrix of the
targets (`tools/speed_matrix.py com.n.sowvcdkhh fix1 6314,26063,26453,27042,26145`)
reports `errors=none` for every one of them, with 88 hook points found in the
process of the Play Store and 82 in the process of the system user interface.

The value search still works with the patched daemon - the daemon is attached
to the target, so `PTRACE_PEEKDATA` can read it:

```
E/AndroidService: sendSearchNumber: 777; 0 x0 as 20000004 in 0-ffffffffffffffff, 0
I/android-daemon: searchNumber: 777; 0, 20000004 0-ffffffffffffffff
I/android-daemon: ::searchDone: 5, 5 0
```

The result list of the app shows the same five addresses, each with the
value 777 and the type `D`:

```
138268FC   777   D
72F6ABF030 777   D
7306C053D0 777   D
738B5C6C68 777   D
```

## 5. What was not changed

* No mock, no local stand in, no fallback: every number above was produced
  by the daemon of the app on the device against the real processes.
* The daemon of the original application was not modified: the patch is
  applied to the copy of the daemon inside this repository.
* SELinux was not changed: the device stayed in the state it was in
  (`getenforce` -> `Permissive`, see `docs/ENVIRONMENT_IMPACT.md`).
* The app itself was not changed for the speed hack; the fix is in the
  daemon binary that the app unpacks.
