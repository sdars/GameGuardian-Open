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

The two applications were opened side by side on the same device with the
same search dialog on the screen and compared pixel by pixel
(`tools/diff_region.py`, screenshots `build/new_orig_dlg.png` and
`build/new_ours_dlg.png`):

```
region                                original vs. this build
the value field 195,212-580,271      identical
the label "value" 44,217-95,266     identical
the "=" spinner 95,194-191,290      identical
the whole dialog 32,107-688,1229     1.03 % different,
                                     difference bbox (32,107)-(428,196)
```

The only pixels that differ are the first two characters of the title of the
dialog - the antialiasing of the headline, not the input field:
`build/cmp_orig_title.png` against `build/cmp_ours_title.png`.

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

## 6. "The rows of the result list are too close together"

The row height of the result list is fixed by the layout of the panel, not by
the adapter.  The original 101.4 and the release build were measured with the
same search (`999`, type `Dword`) on the same device; the `address` text view
of every row of the result list:

```
original 101.4              release build (before the fix)   release build (now)
row 1  address top  333     row 1  address top  317         row 1  address top  333
row 2  address top  431     row 2  address top  383         row 2  address top  431
row 3  address top  529     row 3  address top  449         row 3  address top  529
row 4  address top  627     row 4  address top  515         row 4  address top  627
row 5  address top  725     row 5  address top  581         row 5  address top  725
row 6  address top  823     row 6  address top  647         row 6  address top  823
row 7  address top  921     row 7  address top  713         row 7  address top  921
                          -> 98 px per row            -> 66 px per row   -> 98 px per row
```

The dumps are `build/logs/o_now.xml` (original), `build/logs/our_search_page.xml`
(the reconstruction before the fix) and `build/search_new/rs2.xml` (the
release build that is published now).  The type and the area column sit on
the same place as in the original:

```
original                        release build
type letter  D  [594,510][624,548]   D  [594,510][624,548]
area letter  Ca [579,548][624,586]   Ca [579,548][624,586]
```

The reason for the 66 px was a bit of the row that was read inverted in the
reconstruction: the layout flag of the row.  `Config.q` is the bit mask of the setting
`config_use_small_list_items` (`Config.java:1694`): bit `0` is the portrait
variant, bit `1` the landscape variant, bit `2`/`3` the same for the saved
list and bit `4`/`5` for the config list.  `Tools.d1()` returns `1` when the
device is in landscape (`Tools.U1()` reads `configuration.orientation == 2`),
so `Config.q & (1 << Tools.d1())` is the portrait/landscape bit of the
result row and it decides whether the row is drawn in the compact or in the
tall variant (`d3Var2.o.setOrientation(...)` and the height of the row
`d3Var2.f661a.getLayoutParams().height = z2 ? -2 : Tools.H()`).
The original smali
(`build/puresrc/original/android/ext/AddressArrayAdapter.smali`, lines 172-186)
computes

```
sget v0, Landroid/ext/Config;->q:I
invoke-static {}, Landroid/ext/Tools;->d1()I
shl-int v1, 0x1, v1
and-int/2addr v0, v1
if-eqz v0, :cond_1a     # -> v2 = 0
                        # -> v2 = 1
```

so the flag is set when the bit **is** set.  The reconstruction had
`== 0` and is now `!= 0` in `android.ext.AddressArrayAdapter` and in
`android.ext.SavedListAdapter` (`Config.q & (1 << (Tools.d1() + 2))`).  The
compiled dex of the published apk carries the same instruction sequence as
the original smali (`build/apkcheck/smali/android/ext/AddressArrayAdapter.smali`,
lines 178-196):

```
sget v0, Landroid/ext/Config;->q:I
invoke-static {}, Landroid/ext/Tools;->d1()I
const/4 v2, 0x1
shl-int v1, v2, v1
and-int/2addr v0, v1
if-eqz v0, :cond_1b
const/4 v0, 0x1
goto :goto_1c
:cond_1b
const/4 v0, 0x0
```

## 7. "The speedhack does not work"

It does, and it behaves exactly like the original.  Both applications were
driven through the same script against the same target
(`com.gg.abitest`, pid 2424, 32 bit) on the same device; the script is

```lua
print("SPEED_BEFORE " .. tostring(gg.getSpeed()))
local r = gg.setSpeed(2)
print("SETSPEED_RET " .. tostring(r))
print("SPEED_AFTER " .. tostring(gg.getSpeed()))
```

and the script file is the one the app itself computes
(`/storage/emulated/0/Notes/<package of the attached process>.lua`,
`android.ext.v1.a()`).

| | original 101.4 (`com.utnciuwv.ldcsra`) | this build (`com.fqqvbgr`) |
|---|---|---|
| daemon config | `Sended config: 2147483647 110000010000000011 1111...1111 33000 262207 ...` | identical |
| daemon hook | `hook 2 installed: 132`, `Send code: 11`, `Send code: 18` | `elf_hook_sections32 Find 0/1`, `find all`, `Send code: 18` |
| `gg.setSpeed(2)` | `SETSPEED_RET true` | `SETSPEED_RET true` |
| `gg.getSpeed()` | `SPEED_AFTER 2.0` | `SPEED_AFTER 2.0` |

The same run on the published apk (the package that the self install of this
build created on the device, `com.hdzj.yopvkq`, apk sha256
`bd584b9c5493e860773e80f405e4ccfef28e74ca99f898d08ee79b60a8fd4075`):

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

The daemon is the binary of the original APK: `res/raw/ydw0` of the release
APK and of the original APK have the same sha256
(`3535a0261b749ae8ddc9fd1215527b64ac2ba9c9b14ee3602458f3c15f4e9433`), so the
speed hook itself is the original code.

The **panel** of the speedhack is opened by a long press on the floating
icon (`HotFrame.onLongClick` -> `MainService.onLongClick` ->
`HotPoint.x()` -> `HotPoint$d` -> `speed_inc` / `speed_dec` / `speed_text`).
Both applications log the same two lines for the same injected gesture
(`input swipe 48 104 48 104 1500` on the icon):

```
Fake long click: 350        # 750 - ViewConfiguration.getLongPressTimeout()
Real long click: true
```

and both open the speed panel window afterwards.  `MainService.T()` (`>>`,
speed up) and `MainService.u0()` (`<<`, speed down) are wired to the two
buttons of the panel and end in `MainService.o1(true)` ->
`MainService.S0(byte, double)` -> `f0.F0(cmd, num, den)`, the same call the
lua API uses.

Note that the gesture has to hit the icon itself: the floating icon is a
96 x 96 px window at the top left of the screen, the panel of the app (the
window with the tabs) covers the same area while it is open, and a long
press on the panel is a long press on the panel, not on the icon.

### The two buttons of the panel answered with `{107}`

The lua path of the section above works, but the two buttons of the speed
panel of the floating icon answered with `{107}` - *"此进程不支持变速"* - on
every target, while the original answers the same gesture on the same target
on the same device.  The daemon is not the reason: the binary of the daemon
is the one of the original APK (same sha256).  The reason is that the
reconstruction did not unpack the **hook payload**.

The daemon of the app is not one file.  `android.ext.e0.d(char)` unpacks a
set of helper libraries next to the daemon, and the daemon copies the hook
payload out of that directory into the target before it patches it.  The set
belongs to the architecture of the daemon that the device uses:

| daemon | arch | helpers |
|---|---|---|
| `lib5.so` | 105 (arm64) | `lib5`, `lib08`, `lib6`, `libg`, `libl`, **`lib9`**, **`libh`**, **`libn`** |
| `lib7.so` / `lib8.so` | 104 | `lib7` / `lib8`, **`lib9`**, **`libh`**, **`libn`** |
| `liba.so` / `libb.so` | 103 | `liba` / `libb`, `libd`, `libi`, `libo` |
| `lib0.so` / `lib1.so` | 101 | `lib0` / `lib1`, `lib3`, `libe`, `libj` |
| `lib2.so` | 102 | `lib2`, `lib01`, `lib4`, `libf`, `libk`, `lib3`, `libe`, `libj` |

In the original dex the block of the 64 bit arm daemon falls through into the
block of `'7'`/`'8'`, so that the three libraries of the hook are unpacked as
well:

```
build/verify/orig9063_smali/android/ext/e0.smali, method d(C)V
    :cond_52                          <-- c2 == '5'
    const-string p1, "08"
    ... invoke-static {p1}, Landroid/ext/e0;->b(C)V   <-- b('l')
    :cond_68                          <-- c2 == '7' or '8', reached by fall through
    const/16 p1, 0x39                 <-- b('9')
    const/16 p1, 0x68                 <-- b('h')
    sput-char p1, Landroid/ext/e0;->e:C
    const/16 p1, 0x6e                 <-- b('n')
```

The decompiler that the pure source tree was written from lost that fall
through, so the reconstruction unpacked `lib5.so`, `lib08.so`, `lib6.so`,
`libg.so` and `libl.so` - and never `lib9.so`, `libh.so` and `libn.so`.  The
daemon then failed to copy its hook payload into the target and answered
with the error code 107, which `MainService` turns into `speedhack_fail`:

```
E/android-daemon: lib chmod '/data/user/0/com.saweyhfbpyrcxakywsq/files/GG-Lazz/lib9.so' -1 2: No such file or directory
I/android-daemon: Copy lib cp: 2, No such file or directory; /data/app/com.gg.abitest-.../lib/arm/_lib9.so; /data/user/0/com.saweyhfbpyrcxakywsq/files/GG-Lazz/lib9.so
I/android-daemon: elf_hook_sections32 Find 0 '0x55a6bc4bfa': 0, 0, 0, 137, 1
E/android-daemon: Report Error: 107
```

`app/src/main/java/android/ext/e0.java` follows the original again; the
directory of the app is now identical to the one of the original, file by
file (only the name of the directory is random):

```
original 101.4 (com.utnciuwv.ldcsra, GG-mikB)   this build (com.lpj, GG-kPwZ)
lib01.so   24476   lib02.so   10408   lib05.so   10312   lib08.so   24892
lib5.so  4075552   lib6.so   147552   lib9.so   143960   libg.so    10872
libh.so     8208   libl.so    11608   libn.so     8672   sh.jar      2294
version.gg    11
```

and the same gesture on the same target gives the same daemon trace (the
searched name of the section is mixed with a random key per run, the
addresses are not):

```
original 101.4                                  this build
elf_hook_sections32 Find 0 '0x5ae5c94e6c':      elf_hook_sections32 Find 0 '0x6290506e6c':
    bed70638, 0, 2e638, 183, 1                      bed70638, 0, 2e638, 183, 1
elf_hook_sections32 Find 1 '0x5ae5c90177':      elf_hook_sections32 Find 1 '0x6290502177':
    bed6cbe8, 0, 2abe8, 180, 1                      bed6cbe8, 0, 2abe8, 180, 1
find all                                         find all
_reader: bed70638, _config: bed6cbe8             _reader: bed70638, _config: bed6cbe8
Send code: 18                                    Send code: 18
>>                                               >>
Send code: 18                                    Send code: 18
```

No `Report Error` is written in the whole log of the run any more.

`tools/speed_panel_ab.py <package> <tag> <pid>` drives that gesture and prints
the log of the app and of the daemon, `tools/speed_panel_readback.py` does the
same and renders the text view of the speed (`speed_text` of
`res/layout/hot_point_view.xml`) out of the screenshot before and after the
button.

The panel of the reconstruction is pixel identical to the panel of the
original - the screenshots of the expanded panel were compared pixel by pixel,
before and after the fast forward button was pressed:

```
panel pixels before ours vs original: 0/31488 differ (0.000%)
panel pixels after  ours vs original: 0/31488 differ (0.000%)
```

## 8. The script path of the script runner

The path of the script runner is built from two preferences
(`android.ext.v1`):

* `script-path` - the directory that holds the scripts, default
  `<external storage>/Notes`,
* `<package of the attached process>-script` - the full path of the script
  of that package, default `<script-path>/<package>.lua`.

Both preferences are filled by the **self install**: the app copies the
preferences of the package it replaces (`android.ext.x2.n()`), and that copy
keeps the *type* of every entry.  An entry that was stored as a long in the
old package stays a long, so the original throws

```
java.lang.ClassCastException: java.lang.Long cannot be cast to java.lang.String
    at android.ext.f2.getString(...)
    at android.ext.v1.b(v1.java:31)
    at android.ext.v1.a(v1.java:19)
    at android.ext.o0$b.onClick(o0$b.java:154)
```

when the script dialog is opened, catches it and falls back to the default
path.  This build gets the same preferences, only with an empty string
instead of a long, so the dialog shows `//<package>.lua` and the file is not
found (`文件未找到`).  The behaviour is the one of the original, the value is
only carried over from a package that was installed before.

`tools/fix_script_path.sh <package> [dir]` writes the directory back into
the preference file:

```
$ bash tools/fix_script_path.sh com.fqqvbgr /storage/emulated/0/Notes
script-path -> /storage/emulated/0/Notes
    <string name="script-path">/storage/emulated/0/Notes</string>
```

After that the script runner shows
`/storage/emulated/0/Notes/com.gg.abitest.lua` and the speedhack script
above runs.

## 9. The keypad of the search dialog

The value search dialog does not use the keyboard of the system, the app
draws its own (`android.ext.InternalKeyboard`, the view `kbd_frame` of
`res/layout/keyboard.xml`).  It is a window of its own, so the soft keyboard
of the IME never appears and `adb shell input text` has nothing to type
into: the value has to be entered with the on screen keypad.

The keypad that is drawn shows

```
1 2 3 [back] [CE]
4 5 6 [back] [CE]
1 2 3 [sign]
0 . , [sign] [done]
```

but the touch is resolved by the internal IME of the app, whose keypad is
`res/xml/keyboard.xml` and has seven columns per row
(`1 2 3 4 5 : [back]` / `6 7 8 9 0 ; fx`).  The key that is pressed is
therefore not the key that is drawn - the fourth and the fifth key of the
drawn row insert `4` and `5` instead of the backspace and `CE`.  Measured on
the release build (the value of the field is read back from the ui hierarchy
after every tap):

```
tap 78,684 -> 1        tap 356,684 -> 4        tap 356,780 -> 9
tap 170,684 -> 2       tap 450,684 -> 5        tap 450,780 -> 0
tap 263,684 -> 3       tap 543,684 -> :        tap 263,780 -> 8
```

`tools/run_search_999.sh` uses that mapping, it searches `999` with the type
`Dword` and dumps the result list.
