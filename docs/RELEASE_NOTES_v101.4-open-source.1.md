# GameGuardian 101.4 - open source reconstruction, fix release 1

Clean-room **Java reconstruction of GameGuardian 101.4**
(`catch_.me_.if_.you_.can_`, versionCode `16155`).

This release fixes the three defects that were still visible in the published
`v101.4-open-source` APK:

* every value of a value search was rendered as `0`,
* the disassembly (the opcode column) of the memory list was wrong,
* the preferences that the app copies during its self install were shifted
  by one entry, so every copied value ended up under the name of its
  predecessor.

| | |
|---|---|
| asset | `GameGuardian-101.4-open.apk` |
| sha256 | `9f66496415c9804495cd696158007f5f574cb6d8775e32b6a46dbea88036a4ca` |
| size | 17 896 103 bytes |
| dex sha256 | `03e56cf565da42d60a9833e7aceabc35931667cbadd2329583eab36ecd163dd1` |
| dex md5 | `43ed75b6e7337b99f044c01ec54d5fb8` |
| tag | `v101.4-open-source.1` |
| repository | `sdars/GameGuardian-Open-Source` - independent repository, not a fork |
| based on | `v101.4-open-source` |

## 1. Why every search result was `0`

The mask of the value types is built once, in the static initialiser of
`android.ext.i0`:

```java
for (int i = 0; i < 3; i++) {
    long j = (1 << ((1 << i) * 8)) - 1;   // 8, 16 and 32 bit
    ...
}
```

Java masks the distance of an **int** shift to five bits, so `1 << 32` is
`1` and not `0x100000000`; the dword mask became `0` and every dword value
was masked to zero before it was rendered.  The original dex builds the same
constant with a **long** shift:

```
build/verify/orig9063_smali/android/ext/i0.smali, <clinit>
    const-wide/16 v4, 0x1
    shl-long v6, v4, v3        <-- 64 bit shift, 1L << 32 == 0x100000000
    sub-long/2addr v6, v4
```

The reconstruction had been decompiled with the shift type lost, and the same
error was repeated in 16 places.  All of them are fixed now:

| file | what it builds |
|---|---|
| `android/ext/i0.java` | the type masks (byte / word / dword) |
| `android/ext/n1.java` | the reversed hex of a value, the mask of the value column |
| `android/ext/c.java` | the mask of the value formats of the memory list |
| `android/ext/i2.java` | the sign bit of an unsigned search |
| `android/ext/t1.java` | the sign extension of a 64 bit search value |
| `android/ext/m.java` | the field mask of the ARM64 decoder |
| `android/ext/p1.java`, `OffsetCalculator.java`, `MainService.java`, `ConfigListAdapter.java`, `ConfigListAdapter$g.java` | the bit masks of the settings |
| `luaj/a.java`, `luaj/lib/StringLib.java`, `luaj/lib/StringLib$pack.java` | the bit masks of the Lua runtime |

`android.ext.m` (the ARM64 decoder) had the same defect in the other
direction: `(-1) >>> (64 - (i6 + 1))` was an **int** shift, which masked the
distance to five bits and gave a 32 bit field the mask `0xffffffff` instead
of `0xffffffff00000000`.  The original uses `ushr-long`.

### The disassembly was broken by the same mask

`android.ext.n1` feeds the value it has read into the disassembler:

```java
java.lang.StringBuilder sbG = android.ext.m.g(iArrD, j, (int) j2, new java.lang.StringBuilder());
```

With the mask broken, `j` was always `0`, so every row of the memory list was
disassembled as the word `0x00000000` - `ANDEQ R0, R0, R0;` for ARM and
`MOVS R0, R0;` for Thumb.  That is the "the opcodes are all wrong" of the
previous release; it is a consequence of the same root cause and it is gone
with it.

## 2. Why the copied preferences were shifted

`gg_b.b.g()` reads the preferences of the package that the app replaces.  The
reconstruction had the arguments of the `put()` in the wrong order:

```java
map.put(strArr[0], k(xmlPullParser, strArr, b_a));   // wrong
```

Java evaluates the arguments from left to right, so `strArr[0]` was read
**before** `k()` had filled it with the name of the element that was just
parsed.  Every entry of the copy therefore carried the value of its
predecessor.  The original dex parses the value first and reads the name
afterwards:

```
build/verify/orig9063_smali/b/b.smali, method g(...)
    invoke-static {p0, p2, p3}, Lb/b;->k(...)   <-- the value
    move-result-object v1
    const/4 v2, 0x0
    aget-object v2, p2, v2                     <-- then the name
    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(...)
```

The fix is the same order as the original:

```java
java.lang.Object obj = k(xmlPullParser, strArr, b_a);
map.put(strArr[0], obj);
```

The effect of the bug on the device was visible in the preferences of the
self installed package - the history of the searches and the value formats of
the memory list were the values of their neighbours:

```
<string name="history-0">999</string>            (the value of history-1)
<string name="memory-editor-format">BAAAIA</string> (a string, not an int)
<int name="history-size" value="1" />            (the value of h-6)
```

## 3. The verification on the device

MI 8, Android 10, APatch, target `com.gg.abitest` (pid 2418, a **32 bit**
process), the same script for both applications (`tools/search_flow.py`):

```
original 101.4 (com.utnciuwv.ldcsra)      this build (com.saweyhfbpyrcxakywsq)
E9C04A40   999   D   Ca                   E9C04A40   999   D   Ca
(1)                                         (1)
```

The daemon log of both runs:

```
sendSearchNumber: 999; 0 x0 as 20000004 in 0-ffffffffffffffff, 0
searchNumber: 999; 0, 20000004 0-ffffffffffffffff
::searchDone: 1, 1 0
```

Before the fix the same run showed `00000000 | 00000000 | D | Ca`.

The 32 bit process is listed as `[2418] GG32Probe [112 MB]` - **without** the
`[x64]` tag, exactly like the original, because `android.ext.z1$d.l()` only
appends the tag for a 64 bit process.

## 4. The tool that found the shift type

`tools/verify/shift_methods.py` compares the shift instructions of every
method of the reconstruction with the shifts of the original dex, method by
method and in the order in which they appear:

```
python3 tools/verify/shift_methods.py build/verify/rel_apk_smali4 build/verify/orig9063_smali --pkg-map com/utnciuwv/ldcsra=catch_/me_/if_/you_/can_ --rename-orig
```

After the fix the only remaining differences are the methods that were
rewritten as state machines (`android.ext.m.g`, `android.ext.m.l`,
`luaj.LuaClosure.Y2`, `luaj.LuaTable.*`) and a handful of methods where the
order of two independent shifts differs - the result is the same.

`tools/verify/smali_semdiff.py` no longer folds `if-eqz` and `if-nez` into
one opcode any more: the polarity of a branch is part of the behaviour and
an inverted branch is exactly the kind of defect the comparison has to see.

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

