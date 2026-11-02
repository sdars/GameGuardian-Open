# GameGuardian 101.4 - open source reconstruction

This repository is a clean-room **Java reconstruction of GameGuardian 101.4**
(`catch_.me_.if_.you_.can_`, versionCode `16155`).  Every class of the original
APK is present as Java source - including the four methods that defeat every
Java decompiler - the project compiles with Gradle and nothing else, and the
resulting APK installs and runs.

| | |
|---|---|
| Reconstructed from | `GameGuardian-101.4.apk`, sha256 `774b84ccbdb0a53c9a1b26b4238826d4b647d8d4a14c95a4177926c191e12bd8` |
| Package / version | `catch_.me_.if_.you_.can_` / `101.4` (versionCode `16155`) |
| Java sources | 1139 files, 488 944 lines |
| Smali in the build | none - `app/src/main/java` is the only input |
| Release APK | `release/GameGuardian-101.4-open.apk` (sha256 `7dc76618aef82f59431e56b03b8e9c399acd50554847e2dcedee8023db814375`) |

---

## Layout

```
app/src/main/java/          Java reconstruction of every class of the APK
  android/ext/              802 files - the application itself (obfuscated)
  catch_/me_/if_/you_/can_/ the manifest activities / R class
  gg_a .. gg_g/             the seven obfuscated helper packages (originally a..g)
  lasm/                     the Lua assembler used by the script engine
  luaj/                     the Lua runtime (luaj) with GG specific changes
app/src/main/res/           resources decoded from the original APK
app/src/main/AndroidManifest.xml
tools/repair/               the decompilation / repair pipeline
tools/verify/               the behavioural differential tests
tools/build_release.sh      end to end build (gradle -> zipalign -> apksigner)
docs/REVERSE_ENGINEERING.md how the reconstruction was produced and verified
```

## Building

Requirements: JDK 17+ (21 is fine), the Android SDK with
`platforms/android-34` and `build-tools/34.0.0`.

```bash
export ANDROID_HOME=/path/to/android-sdk      # or: export GG_SDK=/path/to/android-sdk
./gradlew :app:assembleRelease                 # -> app/build/outputs/apk/release/app-release.apk
```

The signed release APK (the v1 signature files keep the alias name `CERT`, the
repack code of `android.ext.b1` looks for them by name):

```bash
bash tools/build_release.sh                    # -> release/GameGuardian-101.4-open.apk
```

Signing keys (all optional, they only change the signature of the result):

| variable | default |
|---|---|
| `GG_KEYSTORE_PASSWORD` | `gameguardian` |
| `GG_KEY_ALIAS` | `CERT` |
| `GG_KEY_PASSWORD` | `gameguardian` |

The build needs no network access and no smali assembler: the whole APK is
compiled from `app/src/main/java`.

## The four methods no decompiler could rebuild

Four methods of GameGuardian 101.4 defeat **every** Java decompiler tried
(jadx 1.5.6, Procyon 0.6.0, CFR 0.152, Vineflower 1.10):

| method | original dex | solution |
|---|---|---|
| `android.ext.f1$a.run()` | ~180 smali lines | rewritten by hand in Java |
| `android.ext.m.e(n,int[],long,String,int)` | 47 918 smali lines | mechanical smali to java translation |
| `android.ext.n$a.a(n,long,String,int)` | 3 013 smali lines | mechanical smali to java translation |
| `luaj.LuaClosure.Y2(LuaValue[],Varargs,boolean)` | 6 223 smali lines | mechanical smali to java translation |

The three large ones are plain Java now.  `tools/repair/smali_to_java.py`
translates the dex code into a Java state machine - every dalvik instruction
becomes one java statement, the register file lives in a state object and the
control flow is a `switch` over the instruction index.  The translation does
not try to reconstruct the control flow, so it is mechanical and reviewable;
the same translator regenerates whole classes (`tools/repair/regen_class.py`).

## Verification

```bash
python3 tools/repair/verify_pure_source.py build/release/classes.dex
#   -> the build contains no smali, the three methods are java state machines

bash tools/verify/overlay_diff/run_overlay_diff.sh
#   -> 620 input vectors, original dex against the pure source, identical stdout

bash tools/verify/luaj_diff/run_diff.sh
#   -> 12 lua scripts, original dex against the pure source, identical stdout

python3 tools/repair/scan_new_instance.py
#   -> the methods of the original dex that move the reference of a
#      "new-instance" before the constructor call and read it afterwards

python3 tools/repair/fix_exception_wrappers.py --check
#   -> the call sites that would change the runtime type of a failure
```

The two differential tests compare the reconstruction with the original dex:
the same harness is compiled once and executed twice - once against the
dex2jar dump of the original APK, once against `build/app_classes` of the
reconstruction.  Both runs see the same inputs and their output has to be
byte identical.  They need the original APK, which is not part of this
repository.

On device (MI 8, Android 10, arm64-v8a, root):

* the APK installs, `MainActivity` starts without a single exception,
* the *install mode* dialog of the original app is shown,
* the app installs itself under a randomised package name and keeps running
  there,
* the daemon starts and the handshake succeeds:
  `Daemon: .../files/GG-Q51u/lib5.so`, `DI: 8 4 <pid>`,
  `InOut: x64: true; QE_ALIGN: 4; <pid>`,
* the process list of the floating panel shows every process with its
  architecture and memory usage (`[10161] Trebuchet [x64] [165 MB]`),
* a target process can be selected and attached to and its memory map is
  read back (`used: ProcessInfo [cmdline=mark.via, name=Via, pid=20819, ...]`,
  `TE get: 1:1100 2:1100 ...`),
* `logcat` shows no `FATAL EXCEPTION`, no `UnsupportedOperationException` and
  no exception of the application service at all.

## Legal

GameGuardian is a commercial product of GameGuardian Ltd.  This repository
contains a reconstruction produced by static analysis of the APK for
educational and interoperability purposes; the original binary is **not**
included.  The authors of GameGuardian Ltd. own the original code.
