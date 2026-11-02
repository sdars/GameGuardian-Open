# How the value search behaves (measured on a real device)

All numbers below were produced on a MI8 / Android 10 / APatch device with the
reconstruction installed and the `Trebuchet [x64]` process attached, and were
read back from the daemon log (`adb logcat | grep -a android-daemon`) and from
the pixels of the screen.  The scripts that reproduce them are
`tools/verify_search.sh` and `tools/probe_type.sh`.

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

A search returns nothing for one of four reasons, all of them visible on the
device:

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
