Clean-room **Java reconstruction of GameGuardian 101.4**
(`catch_.me_.if_.you_.can_`, versionCode `16155`).

Every class of the original APK is present as Java source - including the
four methods that defeat every Java decompiler.  The project compiles with
Gradle and nothing else: there is **no smali in the build**, no baksmali, no
smali assembler.  `app/src/main/java` is the only input of the APK.

| | |
|---|---|
| asset | `GameGuardian-101.4-open.apk` |
| sha256 | `c5ebee128241f47861d6a81edc43529895b8bd9ce396aa9582722e1581cf0e00` |
| size | 17 896 103 bytes |
| java sources | 1139 files, 488 944 lines |
| certificate | CN=GameGuardian, v1 signature alias `CERT` |
| tag | `v101.4-open-pure` |

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
