# GameGuardian 101.4 - open source reconstruction

This repository is a clean-room **Java reconstruction of GameGuardian 101.4**
(`catch_.me_.if_.you_.can_`, versionCode `16155`).  Every class of the original
APK is present as readable Java source, the project compiles with Gradle, and
the resulting APK installs and runs.

| | |
|---|---|
| Reconstructed from | `GameGuardian-101.4.apk`, sha256 `774b84ccbdb0a53c9a1b26b4238826d4b647d8d4a14c95a4177926c191e12bd8` |
| Package / version | `catch_.me_.if_.you_.can_` / `101.4` (versionCode `16155`) |
| Java sources | 1139 files, 173 106 lines |
| smali overlay | 3 methods, 57 154 lines (see below) |
| Release APK | `release/GameGuardian-101.4-open.apk` |

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
app/src/main/smali_overlay/ the three methods no Java decompiler could rebuild
app/src/main/AndroidManifest.xml
tools/repair/               the decompilation / repair pipeline
tools/lib/                  smali + baksmali 2.5.2 and their dependencies
tools/build_release.sh      end to end build (javac -> d8 -> smali overlay -> apk)
docs/REVERSE_ENGINEERING.md how the reconstruction was produced and verified
```

## Building

Requirements: JDK 17+ (21 is fine), the Android SDK with
`platforms/android-34` and `build-tools/34.0.0`.

```bash
export ANDROID_HOME=/path/to/android-sdk      # or: export GG_SDK=/path/to/android-sdk
./gradlew :app:assembleRelease                 # -> app/build/outputs/apk/release/app-release.apk
```

The full release build additionally re-inserts the smali overlay and signs the
APK:

```bash
bash tools/build_release.sh                    # -> release/GameGuardian-101.4-open.apk
```

Signing keys (all optional, they only change the signature of the result):

| variable | default |
|---|---|
| `GG_KEYSTORE_PASSWORD` | `gameguardian` |
| `GG_KEY_ALIAS` | `gameguardian` |
| `GG_KEY_PASSWORD` | `gameguardian` |

`tools/lib/` already contains `smali-2.5.2.jar`, `baksmali-2.5.2.jar` and their
dependencies (Apache-2.0, <https://github.com/JesusFreke/smali>), so the build
works without network access.

## Why there is a smali overlay

Four methods of GameGuardian 101.4 defeat **every** Java decompiler tried
(jadx 1.5.6, Procyon 0.6.0, CFR 0.152, Vineflower 1.10):

| method | size | solution |
|---|---|---|
| `android.ext.f1$a.run()` | ~180 smali lines | rewritten by hand in Java |
| `android.ext.m.e(n,int[],long,String,int)` | 47 918 smali lines | original bytecode kept verbatim |
| `android.ext.n$a.a(n,long,String,int)` | 3 013 smali lines | original bytecode kept verbatim |
| `luaj.LuaClosure.Y2(LuaValue[],Varargs,boolean)` | 6 223 smali lines | original bytecode kept verbatim |

The three large ones are shipped as smali in `app/src/main/smali_overlay/` and
patched into the compiled dex by `tools/build_release.sh`.  The overlay is the
**original dex bytecode**, only the two documented renames of the Java tree are
applied to it (see `docs/REVERSE_ENGINEERING.md`).

## Verification

```bash
python3 tools/repair/verify_overlay.py build/release/classes.dex
#   -> every class and member referenced by the overlay exists in the dex

python3 tools/repair/verify_overlay_fidelity.py build/release/classes.dex
#   -> the three overlaid methods are instruction identical to the original APK
```

On device (MI 8, Android 10, arm64-v8a, root):

* the APK installs and `MainActivity` starts without a single exception,
* the *install mode* dialog of the original app is shown,
* the reconstructed `f1$a.run()` executes the original branch sequence
  (`Install64: true` -> `f1.M()`),
* `logcat` shows no `FATAL EXCEPTION` and no `UnsupportedOperationException`.

## Legal

GameGuardian is a commercial product of GameGuardian Ltd.  This repository
contains a reconstruction produced by static analysis of the APK for
educational and interoperability purposes; the original binary is **not**
included.  The authors of GameGuardian Ltd. own the original code.