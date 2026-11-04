# GameGuardian 101.4 - open source reconstruction, fix release 2

Clean-room **Java reconstruction of GameGuardian 101.4**
(`catch_.me_.if_.you_.can_`, versionCode `16155`).

This release fixes the speed hack of the floating panel.  The two buttons of
the panel answered with `{107}` - *"此进程不支持变速"* ("this process does
not support the speed hack") - on every target, while the original 101.4
answers the same gesture on the same target on the same device.

| | |
|---|---|
| asset | `GameGuardian-101.4-open.apk` |
| sha256 | `1cd54d353e2327359b56b4c057e819b6eb0b8c612be558283b48039d1ff9de46` |
| size | 17 896 103 bytes |
| dex sha256 | `5e803d5e945b118c9bed8eafac46440bfc8c158681913f227f58bf398ae78819` |
| dex md5 | `01a772b9275364546084145543229232` |
| tag | `v101.4-open-source.2` |
| repository | `sdars/GameGuardian-Open-Source` - independent repository, not a fork |
| based on | `v101.4-open-source.1` |

## 1. The root cause: three helper libraries were never unpacked

The daemon of GameGuardian is not one file.  The app unpacks a **set** of
helper libraries next to the daemon and the daemon copies the hook payload
out of that directory into the target before it patches it.  The set depends
on the architecture of the daemon that the device uses:

| daemon | arch | helpers that have to be unpacked |
|---|---|---|
| `lib5.so` | 105 (arm64) | `lib5`, `lib08`, `lib6`, `libg`, `libl`, **`lib9`**, **`libh`**, **`libn`** |
| `lib7.so` / `lib8.so` | 104 | `lib7` / `lib8`, **`lib9`**, **`libh`**, **`libn`** |
| `liba.so` / `libb.so` | 103 | `liba` / `libb`, `libd`, `libi`, `libo` |
| `lib0.so` / `lib1.so` | 101 | `lib0` / `lib1`, `lib3`, `libe`, `libj` |
| `lib2.so` | 102 | `lib2`, `lib01`, `lib4`, `libf`, `libk`, `lib3`, `libe`, `libj` |

The unpacking is done by `android.ext.e0.d(char)`.  In the original dex the
block of the 64 bit arm daemon falls through into the block of `'7'`/`'8'`,
so that the three libraries of the hook are unpacked as well:

```
build/verify/orig9063_smali/android/ext/e0.smali, method d(C)V
    :cond_52                          <-- c2 == '5'
    const-string p1, "08"
    ... invoke-static {p1}, Landroid/ext/e0;->b(C)V   <-- b('l')
    :cond_68                          <-- c2 == '7' or '8', reached by fall through
    const/16 p1, 0x39                 <-- b('9')
    const/16 p1, 0x68                 <-- b('h')
    sput-char p1, Landroid/ext/e0;->e:C
    const/16 p1, 0x6e                 <-- b('n')
```

The decompiler that the pure source tree was written from lost that fall
through: the reconstruction stopped after `b('l')` and unpacked
`lib5.so`, `lib08.so`, `lib6.so`, `libg.so` and `libl.so` - but never
`lib9.so`, `libh.so` and `libn.so`.  The daemon then failed to copy its hook
payload into the target and answered with the error code 107, which
`MainService` turns into `speedhack_fail`:

```
E/android-daemon: lib chmod '/data/user/0/<package>/files/GG-xxxx/lib9.so' -1 2: No such file or directory
I/android-daemon: Copy lib cp: 2, No such file or directory; /data/app/com.gg.abitest-.../lib/arm/_lib9.so; /data/user/0/<package>/files/GG-xxxx/lib9.so
I/android-daemon: elf_hook_sections32 Find 0 '0x55a6bc4bfa': 0, 0, 0, 137, 1
E/android-daemon: Report Error: 107
```

`app/src/main/java/android/ext/e0.java` now follows the original again - the
`'5'` branch continues with `b('9')`, `b('h')`, `e = 'h'`, `b('n')`, the
`'2'` branch keeps its own fall through into `b('3')`, `b('e')`, `e = 'e'`,
`b('j')`, and every other branch is unchanged.

## 2. The verification on the device

MI 8, Android 10, APatch, target `com.gg.abitest` (pid 2418, a **32 bit**
process), the same gesture for both applications
(`tools/speed_panel_ab.py`, long press on the floating icon, then the fast
forward button at 270,104):

The directory of the app is now identical to the one of the original, file
by file (only the name of the directory is random):

```
original 101.4 (com.utnciuwv.ldcsra, GG-mikB)   this build (com.lpj, GG-kPwZ)
lib01.so   24476   lib02.so   10408   lib05.so   10312   lib08.so   24892
lib5.so  4075552   lib6.so   147552   lib9.so   143960   libg.so    10872
libh.so     8208   libl.so    11608   libn.so     8672   sh.jar      2294
version.gg    11
```

The daemon log of the two runs (the searched name of the section is mixed
with a random key per run, the addresses are not):

```
original 101.4                                  this build
elf_hook_sections32 Find 0 '0x5ae5c94e6c':      elf_hook_sections32 Find 0 '0x6290506e6c':
    bed70638, 0, 2e638, 183, 1                      bed70638, 0, 2e638, 183, 1
elf_hook_sections32 Find 1 '0x5ae5c90177':      elf_hook_sections32 Find 1 '0x6290502177':
    bed6cbe8, 0, 2abe8, 180, 1                      bed6cbe8, 0, 2abe8, 180, 1
find all                                         find all
_reader: bed70638, _config: bed6cbe8             _reader: bed70638, _config: bed6cbe8
Send code: 18                                    Send code: 18
>>                                               >>
Send code: 18                                    Send code: 18
```

The hook is installed at the same addresses in the same target process, the
speed command is delivered and **no** `Report Error` is written in the whole
log of the run (before the fix: `Report Error: 107`).

The panel itself is pixel identical to the panel of the original - the
screenshots of the expanded panel were compared pixel by pixel, before and
after the fast forward button was pressed:

```
panel pixels before ours vs original: 0/31488 differ (0.000%)
panel pixels after  ours vs original: 0/31488 differ (0.000%)
```

(`tools/speed_panel_readback.py`, the region of the expanded panel,
`(0, 56) - (328, 152)`.)

## 3. The tool that drives the panel

```
python3 tools/speed_panel_ab.py <package> <tag> <pid>
```

attaches the package to the target, hides the main panel, finds the floating
icon in the `APPLICATION_OVERLAY` windows, opens the speed panel with a long
press, presses the fast forward button and prints the screen and the log of
the app and of the daemon.  `tools/speed_panel_readback.py` does the same and
additionally renders the text view of the speed from the screenshot, before
and after the button.

## 4. The published asset on the device

The asset of the release was downloaded again, installed on the device and
driven through the same gesture - the app installs itself under a randomised
package name, so the package of the run was `com.fifunrftosjpvh`:

```
$ curl -sL -o gg_release_v2.apk https://github.com/sdars/GameGuardian-Open-Source/releases/download/v101.4-open-source.2/GameGuardian-101.4-open.apk
$ sha256sum gg_release_v2.apk
1cd54d353e2327359b56b4c057e819b6eb0b8c612be558283b48039d1ff9de46  gg_release_v2.apk

$ adb shell su -c 'ls -l /data/user/0/com.fifunrftosjpvh/files/GG-LzTW/'
lib01.so   24476   lib02.so   10408   lib05.so   10312   lib08.so   24892
lib5.so  4075552   lib6.so   147552   lib9.so   143960   libg.so    10872
libh.so     8208   libl.so    11608   libn.so     8672   sh.jar      2294
version.gg    11

E/AndroidService( 2480): >>
E/android-daemon( 5359): Send code: 18
```

No `Report Error` in the log of the run.

The value search of the published asset returns the same rows as the
original - `F5104A40`, `F51A8160`, `F5201EC8`, each of them `999`, `D`,
`Ca` - and the memory list shows the real disassembly (`0D;`, `0.0F;`,
`PS`):

```
sendSearchNumber: 999; 0 x0 as 20000004 in 0-ffffffffffffffff, 0
searchNumber: 999; 0, 20000004 0-ffffffffffffffff
::searchDone: 5, 5 0
```

The number of hits changes between two runs, because the heap of the target
process changes while it runs - the original itself found `4` hits in one
run and `3` in the next one, the reconstruction found `5`; the three rows
above are in every run.

## 5. Build

```
./gradlew :app:assembleRelease      # -> app/build/outputs/apk/release/app-release.apk
bash tools/build_release.sh         # -> release/GameGuardian-101.4-open.apk (aligned + signed)
bash tools/deploy.sh                # -> install it on the device, grant the root, start the daemon
```

## Legal

GameGuardian is a commercial product of GameGuardian Ltd.  This release
contains a reconstruction produced by static analysis of the APK for
educational and interoperability purposes; the original binary is **not**
included.  The authors of GameGuardian Ltd. own the original code.
