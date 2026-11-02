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
`gg_a` .. `gg_g`; the change is purely cosmetic.

jadx additionally renames every member whose name collides with a class of the
same package (`m.a` -> `m.f1062a`, `LuaValue.f` -> `LuaValue.f1676f`, ...).
689 classes and 1 826 members are affected.  The mapping is extracted from the
`JADX INFO: renamed from:` comments by
`tools/repair/extract_member_renames.py` into
`tools/repair/member_renames.json`; the smali to java translator applies the
same mapping to the dex code it translates, so both sides speak the same
names.

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

### 3.2 The three large ones - mechanical translation

Transliterating 57 000 lines of smali into readable Java is not possible -
that is exactly what the four decompilers failed at.  The reconstruction
therefore keeps the *shape* of the dex code instead of its control flow:

1. `tools/repair/smali_to_java.py` parses the smali of the original dex and
   emits a Java state machine.  Every dalvik instruction becomes one java
   statement, the register file lives in a state object (`mEState`,
   `naAState`, `lcY2State`) and the control flow is a `switch` over the
   instruction index:

   ```java
   private static int mE_run(mEState st) {
       while (true) {
           boolean done;
           int pc = st.pc;
           if (pc < 1200) {
               done = mE_c0(st);
           } else if (pc < 2400) {
               done = mE_c1(st);
           } ... else {
               done = mE_c31(st);
           }
           if (done) {
               return st.resultI;
           }
       }
   }
   ```

   The chunks exist because of the 64 KB method limit of the JVM; each of them
   is a straight line of translated instructions.

2. `tools/repair/regen_class.py` applies the same translation to whole
   classes.  It is used for the classes whose jadx output was structurally
   broken (`android.ext.n$c`, `n$e`, `n$g`, `gg_e.c`, `lasm.LasmBase`).

3. `tools/repair/fix_method.py` splices a single translated method into an
   existing java file when only that one method is broken.

The translator had to be taught a few dex details:

| dex construct | translation |
|---|---|
| `int`/`long`/`float`/`double` registers | four typed fields per register (`v0i`, `v0j`, `v0f`, `v0d`) - the dex type is taken from the instruction |
| `invoke-super` | direct call to the super method of the current class |
| `monitor-enter` / `monitor-exit` | `synchronized` block on the state object |
| `filled-new-array` | `new T[] { ... }` |
| `const-string` / `const-class` | string pool / class literal |
| `check-cast` | `(T) obj` |
| `packed-switch` / `sparse-switch` | `switch` over the key |
| identity of a class (`==` on a class literal) | the class literal is compared by reference, so the translation keeps one static field per class literal |

The result is checked against the original dex in section 4.

---

## 4. How the result is verified

### 4.1 The build is pure java source

`tools/repair/verify_pure_source.py` checks that the release dex was built
from java only and that the three methods are the java state machines:

```
OK        no smali in app/src and none in app/build.gradle

method         entry        original      release state machine
m.smali        entry           25242           11          111489
n$a.smali      entry            1637           10            8824
LuaClosure.smali entry           3292           10           15284

OK        no undecompiled stub left in the release dex
```

### 4.2 The two large methods behave like the original

`tools/verify/overlay_diff/run_overlay_diff.sh` compiles one harness and runs
it twice - once against the dex2jar dump of the original APK, once against
the compiled reconstruction.  Both runs see the same 620 input vectors (fixed
vectors plus a seeded random sweep) and the output has to be byte identical:

```
RESULT: PASS - 7839 lines identical between the original dex and the pure source
```

The vectors cover `android.ext.m.e` (the ARM64 disassembler) and
`android.ext.n$a.a` (the ARM64 decoder).

### 4.3 The Lua VM behaves like the original

`tools/verify/luaj_diff/run_diff.sh` does the same for the whole Lua runtime:
twelve lua scripts (tables, closures, coroutines, the compiler, the standard
library) are executed on both classpaths and compared byte for byte.

```
RESULT: PASS - 12/12 scripts byte-identical between pure-source and original luaj VM
```

`luaj.LuaClosure.Y2` - the third of the three large methods - is the entry
point of that runtime, so it is covered by this test as well.

### 4.4 The decompiler bugs that were fixed by hand

jadx does not only fail on the four big methods, it also produces wrong code
in a few smaller ones.  Each of them was found by comparing the java source
with the smali of the original dex and fixed in the same way:

| class | defect | repair |
|---|---|---|
| `android.ext.n$d.i(String)` | the mismatch exit of the inner loop was dropped - the method never returned | loop rewritten from the smali (`tools/repair/fix_method.py`) |
| `android.ext.m.l(int,int,int)` | 73 `if (iLowestOneBit == iHighestOneBit) { }` blocks - the `break` of every branch was dropped | the `break` was added in all 73 branches |
| `luaj.LuaValue.J0` | the second `l1()` check was dropped, so the comparison result was wrong | `compareFailed` branch restored |
| `android.ext.PathSelector$a.compare` | `iA = -1` and the trailing `if (z) { iA = -1; }` were dropped | restored |
| `android.ext.t1.d(String)` | the whole branch structure was wrong | rewritten from the smali |
| `android.ext.RegionList.h(w)` | the `Bad name length` branch was not guarded - the exception was thrown on *every* entry, and the `IOException` handler did not leave the loop | the branch was put back into its `if`, the handler leaves the loop |
| `android.ext.RegionList.h(w)` | the exit of the loop was lost as well: the dex leaves the loop when the flags of a region are zero (the end of the map of the process), the java code kept reading and ran into the end of the buffer (`BufferUnderflowException`) | the zero flags leave the loop |

`tools/repair/scan_loop_catch.py` reports every catch clause that sits inside
a loop body without a break/return/throw - that is the fingerprint of the
`RegionList.h` defect - and `tools/repair/smali_handlers.py` prints the
exception handlers of a smali method together with its loop back edges, so
that both sides can be compared.

### 4.5 The exception type of a failure must survive the translation

The dex format has no checked exceptions: a handler matches the runtime type
of the failure, no matter what the java signatures declare.  javac does know
checked exceptions, so the java reconstruction has to declare them, and every
call of such a method needs a handler.  The repair pipeline wrapped those
call sites into

```java
try {
    ...
} catch (java.lang.RuntimeException e) {
    throw e;
} catch (java.lang.Throwable e) {
    throw new java.lang.RuntimeException(e);
}
```

which compiles - but it changes the *runtime* type of the failure: a
`java.io.IOException` leaves the method as a `java.lang.RuntimeException`.
Every dex handler that catches the original type stops matching and the
failure ends up in a catch-all handler instead of the handler the original
code had.

The reconstruction showed that on the device.  `android.ext.z1` asks for the
application info of every running process; a process may belong to a service
that is not a package (`com.google.android.gms.persistent`), and the dex
handler of `android.ext.Tools.Y` catches the
`PackageManager.NameNotFoundException` and skips that entry.  With the
wrapper the failure arrived as a `RuntimeException`, escaped the handler and
killed the process list:

```
java.lang.RuntimeException: android.content.pm.PackageManager$NameNotFoundException:
    com.google.android.gms.persistent
    at android.ext.Tools.Y(Tools.java:1989)
    at android.ext.z1.h(z1.java:130)
```

The wrapper is a machine artefact - it appears in none of the decompilations
of the original apk (jadx 1.5.6, jadx 1.4.7 and CFR 0.152), so every one of
the 118 occurrences in the reconstruction could be replaced by a rethrow
that keeps the type of the failure (the "sneaky throw" idiom, see
`android.ext.GgNoop.rethrow`):

```java
} catch (java.lang.Throwable e) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(e);
}
```

`tools/repair/fix_exception_wrappers.py` performs the replacement and
`tools/repair/fix_exception_wrappers.py --check` reports the remaining ones.

### 4.6 The object of a "new-instance" has to reach every register

The dex code allocates an object with `new-instance` and calls the
constructor with `invoke-direct`.  The register that holds the new object is
not necessarily the register the constructor is called on - the code moves
the reference first:

```
new-instance v2, Landroid/ext/z1$d;
...
move-object v14, v2
invoke-direct {v14 .. v21}, Landroid/ext/z1$d;-><init>(...)V
...
invoke-interface {v8, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z
```

The java translation of `tools/repair/smali_to_java.py` builds the object at
the position of the constructor call, so the register of the `new-instance`
kept the `null` of the allocation and the reconstruction added a *null* to
the list where the original dex adds the object.  The process list of the
floating panel died with it:

```
java.lang.NullPointerException: Attempt to write to field 'long android.ext.z1$d.k'
on a null object reference
    at android.ext.z1.s(z1.java:1268)
```

The translation now hands the object to every register that carries the
reference:

```java
st.v2o = new android.ext.z1$d((android.ext.z1$c) st.v15o, st.v16i, ...);
st.v14o = st.v2o;
```

`tools/repair/scan_new_instance.py` reports every method of the original dex
that moves the reference of a `new-instance` before the constructor call and
reads the register afterwards.  Four of the methods of the reconstruction
used the pattern (`android.ext.Tools.A0`, `android.ext.Tools.Z`,
`android.ext.z1.n` and `gg_e.c.b`) and were regenerated.  `gg_e.c.b` threw
the object it had just built (`throw v1`); with the old translation it threw
*null* instead of the `lasm.c` exception of the original dex.

### 4.7 On device

Device `123.57.254.92:51213`, MI 8, Android 10, arm64-v8a, root available.

* `adb install -r release/GameGuardian-101.4-open.apk` -> `Success`
* `am start -n catch_.me_.if_.you_.can_/.MainActivity` -> `Displayed ... +162ms`
* the *install mode* dialog of the original app is displayed,
* the app installs itself under a randomised package name (`com.XXXXXXXXXXXX`),
  the superuser list of APatch is updated for the new uid and the daemon
  starts: `Daemon: /data/user/0/<pkg>/files/GG-Q51u/lib5.so`,
  `DI: 8 4 <pid>`, `InOut: x64: true; QE_ALIGN: 4; <pid>`,
* the process list of the floating panel shows the real processes with their
  architecture and memory usage (`[2507] 系统界面 [x64] [223 MB]`),
* a target process can be selected and attached to, the map of the process is
  read back: `used: ProcessInfo [cmdline=mark.via, name=Via, pid=20819, ...]`,
  `TE get: 1:1100 2:1100 ...`, `RE get: 1:1100 2:1100 ...`,
* `logcat`: no `FATAL EXCEPTION`, no `UnsupportedOperationException`, no
  `Bad cmdline length`, no `Bad name length`, no
  `PackageManager$NameNotFoundException` and no `BufferUnderflowException`.

---

## 5. Known limitations

* The reconstruction is signed with a project key, not with the key of Game
  Guardian Ltd., so it cannot be installed over the original APK without
  uninstalling it first.
* The three large methods are state machines, not hand written Java.  They
  behave exactly like the original (section 4.2 and 4.3), but they are not
  readable code.
* `tools/lib/` contains smali/baksmali and their dependencies (Apache-2.0).
  They are only used by the repair pipeline and by the verification tools -
  the build itself does not need them.
