# Provenance

## Input artefact

| | |
|---|---|
| file | `GameGuardian-101.4.apk` |
| sha256 | `774b84ccbdb0a53c9a1b26b4238826d4b647d8d4a14c95a4177926c191e12bd8` |
| size | 17 175 191 bytes |
| package | `catch_.me_.if_.you_.can_` |
| versionName / versionCode | `101.4` / `16155` |
| minSdk / targetSdk | 21 / 24 |
| dex | one `classes.dex`, 1 459 456 bytes |
| smali classes | 1 151 |

The APK itself is **not** part of this repository.

## Tool chain

| tool | version |
|---|---|
| jadx | 1.5.6 |
| Procyon | 0.6.0 |
| CFR | 0.152 |
| Vineflower | 1.10 |
| apktool | 2.9.3 |
| baksmali / smali | 2.5.2 |
| dex-tools (dex2jar) | v2.4 |
| Android build-tools | 34.0.0 |
| Android platform | android-34 |
| OpenJDK | 21.0.12 |

## Produced artefact

| | |
|---|---|
| file | `GameGuardian-101.4-open.apk` |
| sha256 | `9b7f4d3894939144c2c3477939372154417d603dcf52d8b84ff98fd3632ded1c` |
| size | 17 896 103 bytes |
| signing certificate | CN=GameGuardian |
| certificate SHA-256 | `ac5f2382db5845fcab78fd775faea3653c09e18b80e4244ffddd323d1c4aa374` |
| v1 signature alias | `CERT` (the name the repack code of `android.ext.b1` looks for) |
| package / version | `catch_.me_.if_.you_.can_` / `101.4` (versionCode `16155`) |

The whole APK is compiled from `app/src/main/java` - there is no smali in
the build.

## Checksums of the intermediate steps

```
original apk           774b84ccbdb0a53c9a1b26b4238826d4b647d8d4a14c95a4177926c191e12bd8
gradle app-release.apk see git history of the build step
final release apk      9b7f4d3894939144c2c3477939372154417d603dcf52d8b84ff98fd3632ded1c
```

The scripts below re-derive the guarantee that the released APK is the pure
java reconstruction of the original and that it behaves like it:

```bash
python3 tools/repair/verify_pure_source.py build/release/classes.dex
bash tools/verify/overlay_diff/run_overlay_diff.sh
bash tools/verify/luaj_diff/run_diff.sh
```

The two differential tests need the original APK (they compare the
reconstruction with a dex2jar dump of it); the APK is not part of this
repository.
