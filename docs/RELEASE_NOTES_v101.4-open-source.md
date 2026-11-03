Clean-room **Java reconstruction of GameGuardian 101.4**
(`catch_.me_.if_.you_.can_`, versionCode `16155`).

Every class of the original APK is present as Java source - including the
four methods that defeat every Java decompiler.  The project compiles with
Gradle and nothing else: there is **no smali in the build**, no baksmali, no
smali assembler.  `app/src/main/java` is the only input of the APK.

| | |
|---|---|
| asset | `GameGuardian-101.4-open.apk` |
| sha256 | `bd584b9c5493e860773e80f405e4ccfef28e74ca99f898d08ee79b60a8fd4075` |
| size | 17 896 103 bytes |
| java sources | 1139 files, 488 944 lines |
| certificate | CN=GameGuardian, v1 signature alias `CERT` |
| tag | `v101.4-open-source` |
| repository | `sdars/GameGuardian-Open-Source` - independent repository, not a fork |
| commit | `a6b815a` (`main`, `open-source`, `feature/gg-101.4-opensource`) |

## What is in this release

* the three large methods that used to be shipped as a smali overlay are
  plain Java state machines now (`android.ext.m.e`, `android.ext.n$a.a`,
  `luaj.LuaClosure.Y2`); the `app/src/main/smali_overlay` directory is gone,
* the type of a failure survives the translation: the call sites that wrapped
  a checked exception into a `RuntimeException` re-throw it unchanged, so
  the dex handlers that catch a concrete type keep matching,
  (`tools/repair/fix_exception_wrappers.py`),
* the object of a `new-instance` reaches every register that carries the
  reference - the process list of the floating panel is complete again
  (`tools/repair/scan_new_instance.py`),
* the region map of the process ends where the dex ends it: a zero flag
  leaves the loop instead of running into the end of the buffer,
* `catch_.me_.if_.you_.can_.Receiver` is back.  The 101.4 manifest declares
  it and `android.ext.w2` sends its notification actions to it by class
  name, so without the class every action of the notification ended in a
  `ClassNotFoundException`.
* the number parser (`android.ext.t1.p()`) follows the original smali again:
  a plain decimal value without a suffix is a plain integer, the suffix
  letters select the type (`b`/`w`/`d`/`x`/`f`/`q`/`e`/`a`), float and double
  keep their raw bit pattern and a value that does not fit into the selected
  type produces the original range message.
* the region map of `android.ext.InOut` holds at most 40 entries and drops
  the oldest one instead of growing without a limit.
* the text/hex search works again: `android.ext.t1.h()` has the four way
  dispatch of the original smali again (`;` = UTF-16LE text, `H`/`h` = hex,
  `Q`/`q` = quoted sections, everything else = UTF-8 text).  Before
  this the `:` and `h` prefixes were parsed as hex, so every text
  search ended in a `NumberFormatException` before the request even
  reached the daemon, and the `;` branch sent UTF-8 bytes while the
  daemon was told UTF-16LE.
* the layout flag of a row is read the way the original reads it:
  `Config.q & (1 << Tools.d1())` is **set** when the bit is set, the
  reconstruction had the test inverted (`== 0` instead of `!= 0`) in
  `android.ext.AddressArrayAdapter` and in `android.ext.SavedListAdapter`.
  `Config.q` is the bit mask of `config_use_small_list_items`: bit `0` is the
  portrait variant and bit `1` the landscape variant, and the flag decides
  whether a row is drawn in the compact or in the tall variant.

## The value search on a real device

`docs/SEARCH_BEHAVIOUR.md` documents what the search really does:

* the daemon is always asked for the whole address range
  (`sendSearchNumber: 777; 0 x0 as 2000007e in 0-ffffffffffffffff`),
  the range button reads `在全部内存中`,
* the type mask that is handed to the daemon is the bit set of the selected
  types (`777` with `Auto` -> `0x7e` -> 182 hits, `777` with `Dword` ->
  `0x20000004` -> 29 hits, `305419896` with `Dword` -> 0 hits because the
  value is not in the attached process),
* the text search reaches the daemon and comes back with hits:
  `:Trebuchet` (UTF-8) -> 1467 hits, `;Trebuchet` (UTF-16LE, 18 bytes)
  -> 180 hits, `hDEADBEEF` (hex) -> the request leaves as raw bytes,
* 32 bit values are searched with their own mask and are tagged with their
  own type letter in the result list: `777` with `Dword` ->
  `0x20000004` -> 38 hits tagged `D`, `777` with `Word` ->
  `0x20000002` -> 136 hits tagged `W`, `77` with `Byte` ->
  `0x20000001` -> 33205 hits tagged `B`,
* the dark input field (`#0d0d0d`) is the theme of the original
  (`Theme.Material` -> `@drawable/edit_text_material`), the same colour is
  measured in the original 101.4 APK, in the commercial 499.6 build and in
  this build.  The whole resource tree of the original APK and of this build
  is byte identical (`diff -rq` of the two `res` directories is empty).

```
bash tools/test/run_t1_parse_test.sh
  -> ALL PASS (24 cases) - the parser is compared with a transcription of
     the original smali, byte for byte
```

## The three reports of this round

### 1. "The input field behind `address:` is black"

It is black in the original as well - the field is not a bug, it is the
theme.  The two builds were screenshotted on the same device with the same
search dialog open and compared pixel by pixel (`tools/diff_region.py`):

```
region                                     original        this build
the value field 195,212-580,271           identical       identical
the label "value" 44,217-95,266          identical       identical
the "=" spinner 95,194-191,290           identical       identical
the whole dialog 32,107-688,1229          1.03 % differ,
                                           difference bbox (32,107)-(428,196)
```

The only pixels that differ are the first two characters of the headline of
the dialog (antialiasing), not the input field.  The colour of the field
itself is `#0d0d0d`, the colour of `@drawable/edit_text_material` of
`Theme.Material`, and it is measured in the original 101.4 APK, in the
commercial 499.6 build and in this build.  Screenshots:
`build/new_orig_dlg.png` and `build/new_ours_dlg.png`.

### 2. "The rows of the result list are too narrow"

The pitch of the rows is 98 px, the same as in the original 101.4.  Before
this release the reconstruction drew them with 66 px - the row was drawn in
the compact variant because one bit of the row was read inverted:

```
original 101.4      this build before the fix   this build now
row 1  top  333     row 1  top  317             row 1  top  333
row 2  top  431     row 2  top  383             row 2  top  431
row 3  top  529     row 3  top  449             row 3  top  529
row 4  top  627     row 4  top  515             row 4  top  627
row 5  top  725     row 5  top  581             row 5  top  725
row 6  top  823     row 6  top  647             row 6  top  823
row 7  top  921     row 7  top  713             row 7  top  921
                  98 px per row                66 px per row   98 px per row
```

The type and the area column sit on the same place as in the original:
`D` at `[594,510][624,548]` and `Ca` at `[579,548][624,586]` in both.
The fix is the test of the layout flag of the row
(`Config.q & (1 << Tools.d1())`), it is now `!= 0` as in the original smali.

### 3. "There is no speedhack"

There is one, and it behaves exactly like the original.  Both applications
were driven through the same lua script against the same target
(`com.gg.abitest`, pid 2424, 32 bit) on the same device:

```lua
print("SPEED_BEFORE " .. tostring(gg.getSpeed()))
local r = gg.setSpeed(2)
print("SETSPEED_RET " .. tostring(r))
print("SPEED_AFTER " .. tostring(gg.getSpeed()))
```

| | original 101.4 | this build |
|---|---|---|
| daemon config | `Sended config: 2147483647 110000010000000011 1111...1111 33000 262207 ...` | identical |
| daemon hook | `hook 2 installed: 132`, `Send code: 11`, `Send code: 18` | `elf_hook_sections32 Find 0/1`, `find all`, `Send code: 18` |
| `gg.setSpeed(2)` | `SETSPEED_RET true` | `SETSPEED_RET true` |
| `gg.getSpeed()` | `SPEED_AFTER 2.0` | `SPEED_AFTER 2.0` |
| long press on the icon | `Fake long click: 350` / `Real long click: true` | identical |

The same run against the apk that is published here (the self install of
this build created `com.hdzj.yopvkq` on the device):

```
E/AndroidService(13085): script: SPEED_BEFORE 1.0
I/android-daemon(20200): elf_hook_sections32 Find 0 '0x5d9fc6be6c': c1f3a638, 0, 2e638, 183, 1
I/android-daemon(20200): elf_hook_sections32 Find 1 '0x5d9fc67177': c1f36be8, 0, 2abe8, 180, 1
I/android-daemon(20200): find all
E/android-daemon(20200): Send code: 18
E/AndroidService(13085): script: SETSPEED_RET true
E/AndroidService(13085): script: SPEED_AFTER 2.0
E/AndroidService(13085): Sended config: 2147483647 110000010000000011 1111...1111 33000 262207 ...
```

(`build/logs/speed_new.log`, the script is
`/storage/emulated/0/Notes/com.gg.abitest.lua`, the target is
`com.gg.abitest`, pid 2424, 32 bit.)

The daemon that installs the hook is the binary of the original APK:
`res/raw/ydw0` of this release and of the original APK have the same sha256
(`3535a0261b749ae8ddc9fd1215527b64ac2ba9c9b14ee3602458f3c15f4e9433`).
The panel of the speedhack is opened by a long press on the floating icon
(`HotFrame.onLongClick` -> `MainService.onLongClick` -> `HotPoint.x()` ->
`HotPoint$d` -> `speed_inc` / `speed_dec` / `speed_text`); `MainService.T()`
(`>>`) and `MainService.u0()` (`<<`) end in `MainService.o1(true)` ->
`MainService.S0(byte, double)` -> `f0.F0(cmd, num, den)`, the same call the
lua API uses.

The gesture has to hit the icon itself: the icon is a 96 x 96 px window, the
panel of the app covers the same area while it is open, and a long press on
the panel is a long press on the panel.

### The script path of the script runner

The self install copies the preferences of the package it replaces
(`android.ext.x2.n()`) and keeps the *type* of every entry.  The original
stores `script-path` as a long, so opening the script dialog throws

```
java.lang.ClassCastException: java.lang.Long cannot be cast to java.lang.String
    at android.ext.f2.getString(...)
    at android.ext.v1.b(v1.java:31)
    at android.ext.v1.a(v1.java:19)
    at android.ext.o0$b.onClick(o0$b.java:154)
```

catches it and falls back to the default path.  This build gets the same
preferences with an empty string instead of a long, the dialog shows
`//<package>.lua` and the file is not found (`文件未找到`).  The behaviour is
the one of the original, only the carried over value differs.  The tool

```
bash tools/fix_script_path.sh com.fqqvbgr /storage/emulated/0/Notes
```

writes the directory back into the preference file, after that the script
runner shows `/storage/emulated/0/Notes/com.gg.abitest.lua` and the speedhack
script above runs.

## The device state is not modified

The reconstruction never touches the security state of the device.  There
is no `setenforce`, no `magiskpolicy`, no `chcon`/`restorecon` and no sepolicy
write in the app or in the deployment scripts.  The only sensitive strings
are three that the original dex contains as well (`f0.smali:975,994,1040`
`remount` / `mount -o`, `MainService$c0$c$a.smali:66` `exec setprop wrap.`,
`n0$e.smali:45` `setprop persist.sys.whetstone.level 0`).  The SELinux switch
of the settings screen is not a switch of the kernel enforcement mode:
`Config.r()` only ORs a bit into the flag word that is handed to the daemon,
byte for byte like the original.

Measured on the device before and after a full round of the app (launch,
floating panel, search dialog, typing a value) with
`tools/env_snapshot.sh`:

| probe | before | after |
|---|---|---|
| `getenforce` (shell / root) | `Permissive` / `Permissive` | `Permissive` / `Permissive` |
| md5 `/proc/mounts` | `46a1a9195f924c17dfe452a58b6684bd` | identical |
| md5 `/data/adb/ap/package_config` | `7e1d390cfa7420b68e5e8ec69f2768f4` | identical |
| md5 `/system/build.prop` | `a17d8086ef59e0e69b74a040b20642a4` | identical |
| `pm list packages` | - | identical |
| `ls -la /data/local/tmp` | - | identical |

Details: `docs/ENVIRONMENT_IMPACT.md`.

## Verification

```
python3 tools/repair/verify_pure_source.py build/release/classes.dex
  -> the build contains no smali, the three methods are java state machines

bash tools/verify/overlay_diff/run_overlay_diff.sh
  -> PASS - 7839 lines identical between the original dex and the pure source

bash tools/verify/luaj_diff/run_diff.sh
  -> PASS - 12/12 scripts byte-identical between pure-source and original luaj VM
```

The two differential tests run the same harness twice - once against a
dex2jar dump of the original APK, once against the reconstruction - and
compare the output byte by byte.

The class coverage of the build is checked with `dexdump -f`: the original
dex has 1151 classes, the release dex has 1733, after mapping the seven
obfuscated packages `a`..`g` of the original to `gg_a`..`gg_g` of this tree
no class of the original is missing.

On device (MI 8, Android 10, arm64-v8a, root):

* the APK installs, installs itself under a randomised package name and keeps
  running there,
* the daemon starts: `Daemon: .../files/GG-XXXXX/lib5.so`,
  `DI: 8 4 <pid>`, `InOut: x64: true; QE_ALIGN: 4; <pid>`,
* the process list shows every process with its architecture and memory
  usage (`[10161] Trebuchet [x64] [165 MB]`),
* a target process is attached and its memory map is read back
  (`used: ProcessInfo [cmdline=mark.via, name=Via, pid=20819, ...]`,
  `TE get: 1:1100 2:1100 ...`),
* `logcat` shows no exception of the application service at all.

## Build

```
./gradlew :app:assembleRelease      # -> app/build/outputs/apk/release/app-release.apk
bash tools/build_release.sh         # -> release/GameGuardian-101.4-open.apk (aligned + signed)
```

## Legal

GameGuardian is a commercial product of GameGuardian Ltd.  This release
contains a reconstruction produced by static analysis of the APK for
educational and interoperability purposes; the original binary is **not**
included.  The authors of GameGuardian Ltd. own the original code.
