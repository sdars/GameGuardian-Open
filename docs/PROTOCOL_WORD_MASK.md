# The word mask of the command stream

The search of the panel found nothing, the speed panel changed nothing and the
freeze killed the target after a while.  All three symptoms have one cause:
the 32 bit words of the command stream that the app sends to its daemon were
masked with `0xf`, and the daemon reads them unmasked.

All numbers below were measured on the device (MI 8 / Android 10 / LineageOS
17.1, APatch root, SELinux permissive) with the build of this repository
installed and with the real daemon of the app.  The scripts that reproduce the
runs are `tools/freeze_flow.py`, `tools/speed_e2e.py`, `tools/speed_rate.py`,
`tools/clockdump.py`, `tools/speed_matrix.py` and `tools/eorscan.py`.

## 1. Where the words are written

`app/src/main/java/android/ext/InOut.java` is the serializer of the command
stream of the app:

| method | what it writes |
|---|---|
| `s(byte)` | one raw byte |
| `t(byte[], int)` | raw bytes |
| `u(int)` | one 32 bit word: `this.f179f.putInt(0, i ^ byteOrderMask)` |
| `v(long)` | a 64 bit value - in the 32 bit mode (`InOut.m == false`) as two words of `u()` |
| `w(long)` | a raw 64 bit value (little endian) |

`byteOrderMask` is a `static volatile int`.  Its value in the original dex is
`0xf`:

```
.field public static volatile byteOrderMask:I = 0xf
```

(`tmp/analysis/2026-11-01/apktool_src/smali/android/ext/InOut.smali:16`).
The dex carries the value in its static values, and **nothing in the app ever
writes the field** - there is not a single `sput` for `byteOrderMask` in the
whole dex (`grep -c 'sput.*byteOrderMask'` on the disassembly of the original
gives `0`).  The field therefore keeps `0xf` for the whole life of the app.

## 2. The daemon does not unmask the words

Two independent facts:

* the app reads the **answers** of the daemon without a mask -
  `app/src/main/java/android/ext/w.java`, method `f()`:
  `return this.f1287a.getInt();` (the buffer is little endian),
* the daemon reads the **questions** of the app without a mask - a scan of the
  whole code part of the daemon (`tools/eorscan.py app/src/main/res/raw/ydw5
  0x0 0x3e0c60`) finds 1390 `eor` instructions and not one of them unmasks a
  32 bit word with `0xf`.  The only `eor` that carries `#0xf` is a NEON lane
  mask of a vector operation:

  ```
  0000cb74  eor      z8.d, z8.d, #0xf00fffffffffffff
  ```

The protocol of the daemon is a raw protocol.  A mask of `0xf` on the request
side corrupts every 32 bit word that the app sends.

## 3. What the mask does to the commands

| opcode | field | the app sends | on the wire (`^ 0xf`) | consequence |
|---|---|---|---|---|
| 34 - search | the searched value | 777 | 774 | the daemon searches for 774, the list stays empty |
| 34 - search | the length of the search text | 9 | 6 | the daemon reads the wrong number of bytes |
| 35 - speed | the flags | 16 | 31 | bit 0 and bit 4 of the flags change |
| 35 - speed | the factor `num` / `den` | 6 / 5 | 9 / 10 | the target runs at 0.9x instead of 1.2x |
| 36 - freeze | the number of values | 12 | 3 | the daemon reads three values, the rest of the stream is read as the next command |
| 36 - freeze | the address of the value | 0x1300cfcc | 0x1300cfd3 | the daemon writes the value into the wrong place |

The two entries of the last two rows are the crash of the freeze: the count of
the values is wrong, so the daemon and the app lose the synchronisation of the
stream, and the daemon writes values that the app never asked for into the
memory of the target.

## 4. The fix

One line of one file - `app/src/main/java/android/ext/InOut.java`:

```java
public static volatile int byteOrderMask = 0;
```

Nothing else of the app and nothing of the daemon is touched.  The daemon
binaries of this release are bit for bit the ones of release 4
(`md5sum app/src/main/res/raw/ydw*`: `615681e53ae55bf48b2b7409a0bd0c14` for
`ydw5`, the other five unchanged).

## 5. The measurements after the fix

### 5.1 The search finds the value again

`tools/freeze_flow.py` on the test bed (`com.gg.freezeprobe`, the value 777 in
the heap of the process):

```
the search is done / found_count is ' (2)'
result 13009860 type D
result 1300CFCC type D
1 of 2 results carry the canary -> the address of the test bed is 1300CFCC
```

Before the fix the same run ended with an empty list.

### 5.2 The speed factor reaches the target and works

The daemon writes the factor into the clock object of the injected library
inside the target (`lib6.so`, the table of the clocks is at `lib6+0x25f80`,
the object holds the factor at `+0x08`/`+0x0c`, the virtual time at `+0x28`,
the real time at `+0x20`).  `tools/clockdump.py 4215` reads it out of the
memory of the Play Store:

```
slot  1 obj=0x718d47b478 flag=1 index= 20 num=6 den=5 base=9924.924 acc=0 last=9645.766
slot  6 obj=0x718d47b4c8 flag=1 index= 24 num=6 den=5 base=9217.884 acc=4 last=9057.586
```

`num=6`, `den=5` is the factor 1.2 that the panel asked for.

`tools/speed_rate.py 4215 30` measures the effect while the target is drawn
(the swipes of the run keep the target busy):

```
wall 38.7 s
slot  1 num=6/5 flag=1  virtual +36.103 s  real +30.086 s  factor 1.2000  acc +0
```

The clock that the target reads advances 36.103 s while the real clock of the
device advances 30.086 s in the same interval: the target runs at **1.2000x**,
exactly the factor 6/5 that the panel set.  The hook of the injected library
is not only present, it is used.

### 5.3 The target does not die any more

`tools/speed_e2e.py com.coquypt 4215 300` - the speed hack on the Play Store
for five minutes, the target is checked every ten seconds:

```
t=  23.3  acc=4  clocks=[(1, 20, 6, 5, 0), (6, 24, 6, 5, 4)]  alive=True
t= 145.4  acc=4  clocks=[(1, 20, 6, 5, 2), (6, 24, 6, 5, 4)]  alive=True
t= 293.9  acc=4  clocks=[(1, 20, 6, 5, 0), (6, 24, 6, 5, 4)]  alive=True
```

`alive=True` in every sample, the factor stays 6/5 during the whole run and
the device wrote no new tombstone.

### 5.4 The freeze keeps the target alive

`tools/freeze_flow.py` - the freeze of the value of the test bed, two minutes
of it:

```
alive=18356 freeze=710 canary=0 ... status ticks=26600 freezes=709 corrupt=0
```

720 freeze events, the canary behind the frozen word stayed intact
(`canary=0` is the value of the canary, `corrupt=0` is the counter of the
test bed for a broken write), and the target process was alive during the
whole run.  The tombstone of the device during the run belongs to
`com.dianjiqi`, an unrelated application of the device that crashes on its
own.

## 6. What was not changed

* No mock, no local stand in, no fallback: every number above was produced by
  the daemon of the app on the device against the real processes of the
  device.
* The daemon of the original application was not modified - the binaries of
  this repository are the ones of release 4.
* SELinux was not changed: the device was in the state `Permissive` before
  and after the run (`getenforce`), the device was not rebooted
  (`/proc/uptime` only grew), see `docs/ENVIRONMENT_IMPACT.md`.
