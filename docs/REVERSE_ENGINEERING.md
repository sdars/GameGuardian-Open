# Reverse engineering notes - GameGuardian 101.4

Everything below was produced from the single artefact

```
GameGuardian-101.4.apk
sha256  774b84ccbdb0a53c9a1b26b4238826d4b647d8d4a14c95a4177926c191e12bd8
size    17 175 191 bytes
```

No network service, no server side component and no obfuscation of the dex
format itself - the APK is a plain `classes.dex` plus resources.

---

## 1. Tool chain

| tool | version | used for |
|---|---|---|
| jadx | 1.5.6 | primary Java decompilation |
| Procyon | 0.6.0 | second opinion, confirmed the four failures |
| CFR | 0.152 | third opinion |
| Vineflower | 1.10 | fourth opinion |
| apktool | 2.9.3 | resource + smali decoding |
| baksmali / smali | 2.5.2 | dex <-> smali |
| dex2jar (dex-tools) | v2.4 | class file view of the dex |
| d8 / apksigner / zipalign | build-tools 34.0.0 | packaging |

All four Java decompilers fail on the *same* four methods, which is the
central problem of this reconstruction.

---

## 2. From dex to compiling Java

### 2.1 Package and class renaming

The obfuscator emitted seven helper packages `a` .. `g` in which **every class
is named after its package** (`a.a`, `a.b`, ... `g.g`).  In Java such a
package can never be referenced unambiguously, because the simple name `a` is
both a package and a class.  `tools/repair/rename_packages.py` renames them to
`gg_a` .. `gg_g`; the change is purely cosmetic and is undone automatically
when the smali overlay is written (see section 4).

jadx additionally renames every member whose name collides with a class of the
same package (`m.a` -> `m.f1062a`, `LuaValue.f` -> `LuaValue.f1676f`, ...).
689 classes and 1 826 members are affected.  The mapping is extracted from the
`JADX INFO: renamed from:` comments by
`tools/repair/extract_member_renames.py` into
`tools/repair/member_renames.json` and is the second half of the overlay
rewrite.

### 2.2 The 64 KB method limit

`android.ext.m.g(int[],long,int,StringBuilder)` is the ARM32 disassembler of
GameGuardian.  jadx decompiles it into a single Java method of 5.4 MB
(lines 1266 - 56 247 of that file, 58 908 lines in total, 3 542 `case`
labels) - far beyond the 64 655 byte limit of a JVM method, so `javac`
rejects it with `error: code too large`.  The split version in the tree is
61 490 lines long and holds 582 generated methods.

`tools/repair/split_large_method.py` rewrites such methods automatically:

* every local variable becomes a field of a generated `GgState` holder,
* a `return x` becomes `ggst.ret = x; ggst.stop = true; return;`,
* a huge `switch` is cut into groups of cases; each group becomes its own
  method and the call site becomes
  `if (expr >= lo && expr <= hi) { ggSwN(ggst); if (ggst.stop) return; }`,
* the `default:` branch is extracted into `ggDefN` so that it also works when
  it sits in the middle of the case list,
* nested blocks (`build_chain`, `plan_stmt`, `plan_part`, `plan_loop`,
  `plan_switch`) are extracted with their control flow intact.

Two independent splits (target 60 000 and 20 000 bytes) were compared against
each other with `tools/test/DisasmDiff.java`; 3 000 random inputs produced
**0 differences** in return value and in the produced disassembly text.

### 2.3 Everything else

The remaining ~1 100 classes were made to compile by the javac driven repair
loop in `tools/repair/run_chain.sh` and `tools/repair/pipeline.sh`:

* `fix_refs.py` - unresolved type and member references,
* `fix_catch_vars.py` - catch parameter declarations,
* `fix_checked_exceptions.py` - checked exceptions the decompiler dropped,
* `fix_definite_assignment.py`, `fix_flow.py`, `fix_never_thrown.py` -
  definite assignment and unreachable code,
* `fix_private_access.py` - private members that inner classes read,
* `fix_r_refs.py` - the `R` class: AGP generates `R$string` as a **nested**
  class, jadx emits the binary name `R$string`, which `javac` cannot resolve.
  2 159 references are rewritten and the resource names are mapped back to
  their real names with `aapt2 dump resources` (`tools/repair/r_renames.json`).

Result: `javac rc=0 errors=0` over the whole tree, and
`./gradlew :app:assembleRelease` succeeds.

---

## 3. The four methods no decompiler could rebuild

| method | why it fails |
|---|---|
| `android.ext.f1$a.run()V` | jadx hits a `ConcurrentModificationException` in its `ConstructorVisitor` while inserting a phi |
| `android.ext.m.e(Landroid/ext/n;[IJLjava/lang/String;I)I` | 47 918 smali lines, one giant `tableswitch` - the control flow reconstruction gives up |
| `android.ext.n$a.a(Landroid/ext/n;JLjava/lang/String;I)I` | 3 013 smali lines, same shape (it is the ARM64 decoder that `m.e` calls into) |
| `luaj.LuaClosure.Y2([Lluaj/LuaValue;Lluaj/Varargs;Z)Lluaj/Varargs;` | 6 223 smali lines, jadx even reports `JadxOverflowException: updates count limit reached with updateSeq = 48941` |

### 3.1 `f1$a.run()` - hand written

The method was reconstructed instruction by instruction from
`tmp/analysis/2026-11-01/apktool_src/smali/android/ext/f1$a.smali`
(`tools/repair/fix_undecompiled.py`).  The subtle part is the boolean that
decides whether the 64 bit helper is installed:

```smali
if-eqz v2, :cond_1          # z == false            -> false
sget-boolean v5, Config->vSpaceReal
if-eqz v5, :cond_0          # vSpaceReal == false    -> true
sget-boolean v5, Config->D
if-eqz v5, :cond_1          # D == false             -> false
```

which is `z && (!Config.vSpaceReal || Config.D)`.  The compiled result is
compared instruction by instruction with the original dex - the branch
sequence, the field writes and the call order are identical.

### 3.2 The three large ones - smali overlay

Instead of transliterating 57 000 lines of smali into Java (which no
decompiler manages and which would be unverifiable), the **original dex
bytecode** is kept and patched into the compiled dex:

1. `tools/build_release.sh` builds the Java sources into `classes.dex`,
2. `baksmali` disassembles that dex back into smali,
3. `tools/repair/overlay_smali.py apply` replaces the three method bodies with
   the fragments in `app/src/main/smali_overlay/`,
4. `smali` assembles the patched tree into the final `classes.dex`,
5. the dex is put back into the APK, aligned and signed.

The fragments are the original smali with exactly two rewrites applied
(`tools/repair/overlay_smali.py`):

* `L a/...;` -> `L gg_a/...;` (the package rename of section 2.1),
* `Landroid/ext/m;->a:J` -> `Landroid/ext/m;->f1062a:J` (the member rename of
  section 2.1).

---

## 4. How the result is verified

### 4.1 The overlay links

`tools/repair/verify_overlay.py` parses the produced dex directly (no
external tool) and checks every class and every member the overlay touches
against the classes that were compiled from Java:

```
dex classes      : 1154
member references: 27
OK - every class and member referenced by the overlay exists
```

### 4.2 The overlay is the original implementation

`tools/repair/verify_overlay_fidelity.py` disassembles the original dex and
the release dex and compares the three method bodies instruction by
instruction:

```
IDENTICAL  android/ext/m.smali          e(Landroid/ext/n;[IJLjava/lang/String;I)I  (47917 lines)
IDENTICAL  android/ext/n$a.smali        a(Landroid/ext/n;JLjava/lang/String;I)I  (3012 lines)
IDENTICAL  luaj/LuaClosure.smali        Y2([Lluaj/LuaValue;Lluaj/Varargs;Z)Lluaj/Varargs;  (6222 lines)
```

### 4.3 On device

Device `123.57.254.92:51213`, MI 8, Android 10, arm64-v8a, root available.

* `adb install -r release/GameGuardian-101.4-open.apk` -> `Success`
* `am start -n catch_.me_.if_.you_.can_/.MainActivity` -> `Displayed ... +177ms`
* `logcat`: no `FATAL EXCEPTION`, no `UnsupportedOperationException`;
* the reconstructed `f1$a.run()` shows up in the stack trace of the original
  call site (`at android.ext.f1$a.run(f1$a.java:117)`) and reaches
  `Install64: true`, i.e. the original branch is taken,
* the *install mode* dialog of the original app is displayed.

---

## 5. Known limitations

* The reconstruction is signed with a project key, not with the key of Game
  Guardian Ltd., so it cannot be installed over the original APK without
  uninstalling it first.
* `tools/lib/` contains smali/baksmali and their dependencies (Apache-2.0).
* The three overlay methods are smali, not Java - they are the only part of
  the project that is not a Java reconstruction.