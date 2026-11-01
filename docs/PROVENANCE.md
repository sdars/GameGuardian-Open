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
| sha256 | see the release page |
| signing certificate | CN=GameGuardian Open Source, O=Sandbox, C=CN |
| certificate SHA-256 | `3336112b85f6af3b12ee7b24b118473f74169c247d28f2cbdc1ee47f578f5ebb` |
| package / version | `catch_.me_.if_.you_.can_` / `101.4` (versionCode `16155`) |

## Checksums of the intermediate steps

```
original apk           774b84ccbdb0a53c9a1b26b4238826d4b647d8d4a14c95a4177926c191e12bd8
gradle app-release.apk see git history of the build step
final release apk      published as release asset
```

The two scripts below re-derive the guarantee that the released APK contains
the original implementation of the three methods that no decompiler could
rebuild:

```bash
python3 tools/repair/verify_overlay.py build/release/classes.dex
python3 tools/repair/verify_overlay_fidelity.py build/release/classes.dex
```