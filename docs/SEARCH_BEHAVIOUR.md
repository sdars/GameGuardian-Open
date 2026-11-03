# How the value search behaves (measured on a real device)

All numbers below were produced on a MI8 / Android 10 / APatch device with the
reconstruction installed and the `Trebuchet [x64]` process attached, and were
read back from the daemon log (`adb logcat | grep -a android-daemon`) and from
the pixels of the screen.  The scripts that reproduce them are
`tools/verify_search.sh`, `tools/verify_search_types.sh` and
`tools/probe_type.sh`.

## 0. The text search was broken and is fixed now

The reconstruction of `android.ext.t1.h(CharSequence)` had the wrong
dispatch.  The original smali
(`build/puresrc/original/android/ext/t1.smali`, method
`h(Ljava/lang/CharSequence;)[B`, lines 1007-1336) has four branches:

| first character | meaning | original smali |
|---|---|---|
| `;` | text, UTF-16LE | `:cond_d2` -> `:goto_d3` with `v2 = 1` |
| `H` / `h` | hex bytes | `:cond_c5` -> `a([B, String)` |
| `Q` / `q` | quoted sections | `:cond_33` |
| anything else (e.g. `:`) | text, UTF-8 | `:goto_d3` with `v2 = 0` |

The faulty version sent `:` and `h` into the quoted branch, where the text
between the quotes is parsed as hex, so every text search died with

```java.lang.NumberFormatException: For input string: "Tr"
    at java.lang.Integer.parseInt(Integer.java:615)
    at android.ext.t1.a(t1.java:116)
    at android.ext.t1.h(t1.java:301)
    at android.ext.i2.o(i2.java:112)
```

and the `;` branch used UTF-8 instead of UTF-16LE, so the daemon was told
"UTF-16LE" but got UTF-8 bytes and found nothing.

`app/src/main/java/android/ext/t1.java` now has the four way dispatch and the
helper `t1_text(CharSequence, boolean, boolean)`.  The JVM harness
`tools/test/run_t1_parse_test.sh` compares the result with a transcription of
the original smali, byte for byte:

```
OK   ":Trebuchet"                 got=547265627563686574 want=547265627563686574
OK   ";Trebuchet"                 got=540072006500620075006300680065007400 want=540072006500620075006300680065007400
OK   "Hdeadbeef"                  got=DEADBEEF want=DEADBEEF
OK   "Q'utf8'"utf16""             got=7574663875007400660031003600 want=7574663875007400660031003600
ALL PASS (24 cases)
```

On the device the same searches now reach the daemon and come back with
hits:

```
searchText: [9] = 54 'T' 54 75 'u' 75  in 0-ffffffffffffffff, 0
searchText: 'Trebuchet' 9 1 0-ffffffffffffffff
::searchDone: 1467, 1467 0            # ":Trebuchet", text UTF-8

searchText: [18] = "Trebuchet" in 0-ffffffffffffffff, 0
searchText: 'T' 18 2 0-ffffffffffffffff
::searchDone: 180, 180 0              # ";Trebuchet", text UTF-16LE (18 bytes)

searchText: [13] = DE ... in 0-ffffffffffffffff, 0
::searchDone: 0, 0 0                  # "hDEADBEEF ...", hex
```

## 1. "Why do most values not search?"

The search itself is not restricted.  The daemon is always asked for the full
address range:

```
sendSearchNumber: 777; 0 x0 as 2000007e in 0-ffffffffffffffff, 0
searchNumber: 777; 0, 2000007e 0-ffffffffffffffff
::searchDone: 182, 182 0
```

and the dialog shows the range button `在全部内存中` ("in all memory") and the
full value range of every type (`D: Dword (-2,147,483,648 - 4,294,967,295)`).

A search returns nothing for one of these reasons, all of them visible on the
device (the first one, the broken text dispatch, is fixed - see section 0):

| reason | evidence |
|---|---|
| the value is not in the **attached** process | `777` -> 182 hits, `305419896` -> 0 hits in the same process, same type |
| the value does not fit the selected type | `777` with `B: Byte` -> error dialog `数值 '777' 超出允许范围： [-128; 255].`, thrown by `android.ext.t1.p()` and caught by `android.ext.i2` |
| the process that holds the value is not the attached one | the panel always names the target, e.g. `[8966] Trebuchet [x64]` |
| the value is only present as a wider type | `5000000000` with `A: Auto` uses the mask `0x70` (Float, Qword, Double) because the value does not fit into 32 bits - that is arithmetic, not a bug |

The **commercial 499.6 build** (`com.uyileqmdfw`) fails much earlier: its
`android.ext.t1.p()` routes the "plain decimal, no suffix" branch into the
strict suffix ladder, so every value with three or more digits ends in
`throw t1.j(...)` ("invalid value").  The clean 101.4 original - and this
reconstruction - parse such a value as a plain integer, which is why
`12345`, `777` and `305419896` all reach the daemon here.

## 2. "Why is the input field black?"

The value field is filled with `#0d0d0d`.  That colour comes from the
platform, not from the application:

```
FixTheme (parent=@android:style/Theme.Material)
  -> Theme.Material.editTextBackground = @drawable/edit_text_material
  -> Widget.Material.EditText -> Widget.EditText.background = ?attr/editTextBackground
```

`android.fix.EditText` does not set a background of its own, `keyboard.xml` is
byte identical to the original and the `FixTheme` resource of the original
APK, of the 499.6 build and of this build is identical:

```
resource 0x7f0a0002 style/FixTheme
  () (style) size=4 parent=0x01030224
    0x0101004d=48.000000dp
    0x01010098=#ffffffff
    0x010102cd=false
    0x01010306=#ffffffff
```

Measured pixels of the same dialog on the same device:

| widget | original 101.4 theme | this build |
|---|---|---|
| value field | `#0d0d0d` | `#0d0d0d` |
| type button | `#5a595b` | `#5a595b` |
| dialog background | `#424242` | `#424242` |

The whole resource tree of the original APK and of this build is identical,
so nothing can have changed there:

```
$ diff -rq tmp/analysis/2026-11-01/apktool_src/res app/src/main/res
(no output)
```

Measured again on the release build of 2026-11-03 (the value field of the
search dialog, `:Trebuchet`, screen 720x1280):

```
value field background   #0d0d0d     (3896 of 4096 sampled pixels)
dialog background        #424242
```

The dark field is the original design.  A lighter field is a one line style
change (`res/values/styles.xml`, `FixTheme`), it is not a reconstruction
fault.

## 3. "Is 32 bit really searched?"

Yes.  The type list of the dialog offers every width:

```
A: Auto (-1.8e+308 - 1.8e+308) (慢)     D: Dword (-2,147,483,648 - 4,294,967,295)
F: Float (-3.4e+38 - 3.4e+38)             E: Double (-1.8e+308 - 1.8e+308)
W: Word (-32,768 - 65,535)                B: Byte (-128 - 255)
Q: Qword (-9,223,372,036,854,775,808 - 18,446,744,073,709,551,615)
X: Xor (-2,147,483,648 - 4,294,967,295)  文本 UTF-8 / UTF-16LE / HEX / ARM
```

The mask that is handed to the daemon is the bit set of the chosen types
(`android.ext.c`: Byte 1, Word 2, Dword 4, Xor 8, Float 16, Qword 32,
Double 64):

```
searchNumber: 777;          0, 2000007e   # Auto  = Word|Dword|Xor|Float|Qword|Double -> 182 hits
searchNumber: 777;          0, 20000004   # Dword (32 bit only)                      ->  29 hits
searchNumber: 305419896;    0, 20000004   # Dword only, value absent                 ->   0 hits
searchNumber: 5000000000;   0, 20000070   # Auto, value does not fit into 32 bit      -> Float|Qword|Double
```

Repeated on the release build of 2026-11-03 with
`tools/verify_search_types.sh`:

```
searchNumber: 777;   0, 2000007e   # A: Auto   (Word|Dword|Xor|Float|Qword|Double) -> 257 hits
searchNumber: 777;   0, 20000004   # D: Dword  (32 bit only)                      ->  38 hits
searchNumber: 777;   0, 20000002   # W: Word   (16 bit only)                      -> 136 hits
searchNumber: 77;    0, 20000001   # B: Byte   (8 bit only)                       -> 33205 hits
```

The result list tags every row with the type it was found as (`D` = Dword,
`W` = Word, `B` = Byte, `Q` = Qword), for the 32 bit run above:

```
12D840B8   0   D   Jh
12D840D4   0   D   Jh
12D85CD8   0   D   Jh
```

The **address** column is 64 bit because the attached process is a 64 bit
process - an address is a position in the memory of the target and has
nothing to do with the width of the searched value.

The Auto run of 2026-11-03 lists the mixed widths side by side:

```
12D5D94C   776.66662597656   F   Jh
13005994   776.66662597656   F   Jh
1303E7D0   0                 D   Jh
1303E7D0   777               W   Jh
```

## 4. Class coverage of the build

The dex of the original APK and the dex of the release build were compared
class by class (`dexdump -f`), after mapping the seven obfuscated packages
`a`..`g` of the original to `gg_a`..`gg_g` of this tree:

```
original classes : 1151
release classes  : 1733
missing          : 0
```

The one class that was missing before this build was
`catch_.me_.if_.you_.can_.Receiver` - the manifest declares it and
`android.ext.w2` builds the notification intents with
`setClassName(pkg, pkg + ".Receiver")`, so every tap on a notification
action ended in a `ClassNotFoundException`.  It is back as
`app/src/main/java/catch_/me_/if_/you_/can_/Receiver.java`.

## 5. "Why does the process list only show [x64] entries?"

`[x64]` is a label, not a filter.  It is printed by `android.ext.z1$d.l()`
whenever the daemon reported the target as a 64 bit process, and a 32 bit
process is shown *without* that tag.  Measured on the device with a
purpose built pair of probe apps that differ in nothing but the ABI of the
packaged library:

| probe | packaged ABI | process exe | ELF class | row in the list |
|---|---|---|---|---|
| `com.gg.abitest` | `armeabi-v7a` | `/system/bin/app_process32` | `ELFCLASS32` | `[2424] GG32Probe [105 MB]` |
| `com.gg.abi64`  | none (pure Java) | `/system/bin/app_process64` | `ELFCLASS64` | `[3363] GG32Probe [x64] [118 MB]` |

The daemon does send the 32 bit process, the reconstruction keeps it.  With
the instrumentation in `tools/debug_pldbg.patch` applied the loop in
`android.ext.z1` logs

```
PLDBG raw pid=2424 uid=10228 x64=0 a=101804 b=0 c=0 cmd=com.gg.abitest
PLDBG add pid=0 x64=0 pkg=com.gg.abitest label=GG32Probe
```

which is the entry that ends up in the dialog as `[2424] GG32Probe`.

Two things make the list look 64 bit only on this phone:

* the list contains **app processes only**.  The source of the list is
  `ActivityManager.getRunningAppProcesses()` plus the process table of the
  daemon; the original smali does exactly the same
  (`build/puresrc/original/android/ext/z1.smali`, line 1167 and 1259, and
  the `w.f()` / `w.e()` reads in the loop at 1246-1259).  The 22 32 bit
  processes of this device are all native system services without a package
  (`mediaserver`, `cameraserver`, `drmserver`, `omx@1.0-service`,
  `audio@2.0-service`, `wfdhdcphalservice`, `wfdvndservice`,
  `wifidisplayhalservice`, 13 `usap32` helpers, `webview_zygote`), so they
  never appear in the list - not in the original either.
* of the 184 installed packages only one is 32 bit
  (`com.android.webview`, `primaryCpuAbi=armeabi-v7a`); 31 are
  `arm64-v8a` and the remaining 152 carry no native code at all and are
  therefore started by the 64 bit zygote.  Every app row is `[x64]` for
  that reason alone.

Note when reading the list with `uiautomator`: a fling swipe of 700 px skips
rows, so a coarse capture of the dialog looks like it is missing entries.
Scrolling one row at a time shows all 27 rows of that list.
