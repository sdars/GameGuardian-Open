# GameGuardian 101.4 - open source reconstruction, fix release 5

Clean-room **Java reconstruction of GameGuardian 101.4**
(`catch_.me_.if_.you_.can_`, versionCode `16155`).

This release removes the reason for the three symptoms that the release 4
still had:

* the value search of the panel found nothing (the list was empty),
* the speed hack of the panel changed nothing (the app did not even show the
  error any more),
* the freeze of the panel killed the target process after a while.

All three had one cause: the 32 bit words of the command stream between the
app and its daemon were masked with `0xf`, and the daemon reads them
unmasked.

| | |
|---|---|
| asset | `GameGuardian-101.4-open.apk` |
| sha256 | `49e05361f38c3af15f7d9af277c10292f1f6bc87e05633347424d69350f42885` |
| size | 17 896 103 bytes |
| dex sha256 | `6928120df9b2aac06a545d907927371953a2d07a4e6086d992a1c029f6a17d16` |
| dex md5 | `7b7c606d43cb745f9f80e93d69b36bd1` |
| tag | `v101.4-open-source.5` |
| repository | `sdars/GameGuardian-Open-Source` - independent repository, not a fork |
| based on | `v101.4-open-source.4` |

## 1. The root cause

`app/src/main/java/android/ext/InOut.java` is the serializer of the command
stream of the app.  It writes the 32 bit words of the commands masked:

```java
public void u(int i) {
    this.f179f.putInt(0, i ^ byteOrderMask);
    t(this.f178e, 4);
}
```

`byteOrderMask` is a `static volatile int` whose value in the original dex is
`0xf`:

```
.field public static volatile byteOrderMask:I = 0xf
```

Nothing in the app writes that field - the whole dex has not a single `sput`
for it - so the mask was `0xf` during every run of the app.

The daemon does not unmask the words:

* the app reads the answers of the daemon without a mask
  (`app/src/main/java/android/ext/w.java`: `this.f1287a.getInt()`),
* the daemon reads the questions of the app without a mask - a scan of the
  whole code part of the daemon (`tools/eorscan.py`) finds 1390 `eor`
  instructions and not one of them unmasks a 32 bit word with `0xf`.

So every 32 bit word of every command arrived corrupted:

| command | the app sends | the daemon received | effect |
|---|---|---|---|
| 34 - search | the value 777 | 774 | the search found nothing |
| 35 - speed | the factor 6/5 | 9/10 | the target kept the speed 1.0 |
| 36 - freeze | the number of the values 12 | 3 | the stream lost its synchronisation |
| 36 - freeze | the address 0x1300cfcc | 0x1300cfd3 | the daemon wrote into the wrong place |

The crash of the freeze is the third row: the daemon read three values out of
the stream, took the rest of the bytes for the next command and wrote the
values of the app into the heap of the target at addresses that belong to
other objects.

## 2. The fix

One line of one file - `app/src/main/java/android/ext/InOut.java`:

```java
public static volatile int byteOrderMask = 0;
```

The daemon binaries are bit for bit the ones of the release 4
(`md5sum app/src/main/res/raw/ydw*` - `615681e53ae55bf48b2b7409a0bd0c14` for
`ydw5`, the other five unchanged), nothing else of the app is changed.

The full analysis is in `docs/PROTOCOL_WORD_MASK.md`.

## 3. The verification on the device

Device: MI 8, Android 10, LineageOS 17.1, APatch root, SELinux permissive
before and after the run, no reboot of the device.

### 3.1 The search finds the values again

`tools/freeze_flow.py` against the test bed of the repository
(`com.gg.freezeprobe`, the value 777 in the heap of the process):

```
the search is done / found_count is ' (2)'
result 13009860 type D
result 1300CFCC type D
1 of 2 results carry the canary -> the address of the test bed is 1300CFCC
```

Before the fix the same run ended with an empty list.

### 3.2 The speed hack works and the target stays alive

The factor is written into the clock object of the injected library inside
the target (`lib6.so`, the table of the clocks at `lib6+0x25f80`, the factor
at `+0x08`/`+0x0c`, the virtual time at `+0x28`, the real time at `+0x20`):

```
$ python3 tools/clockdump.py 4215
slot  1 obj=0x718d47b478 flag=1 index= 20 num=6 den=5 base=9924.924 acc=0 last=9645.766
slot  6 obj=0x718d47b4c8 flag=1 index= 24 num=6 den=5 base=9217.884 acc=4 last=9057.586
```

The effect, measured in the target while it is drawn:

```
$ python3 tools/speed_rate.py 4215 30
wall 38.7 s
slot  1 num=6/5 flag=1  virtual +36.103 s  real +30.086 s  factor 1.2000
```

The clock of the target advances 36.103 s while the real clock of the device
advances 30.086 s in the same interval: **the target runs at 1.2x**, the
factor that the panel set.

Five minutes of the speed hack on the same target
(`tools/speed_e2e.py com.coquypt 4215 300`):

```
t=  23.3  acc=4  clocks=[(1, 20, 6, 5, 0), (6, 24, 6, 5, 4)]  alive=True
t= 145.4  acc=4  clocks=[(1, 20, 6, 5, 2), (6, 24, 6, 5, 4)]  alive=True
t= 293.9  acc=4  clocks=[(1, 20, 6, 5, 0), (6, 24, 6, 5, 4)]  alive=True
```

`alive=True` in every sample, the factor stays 6/5 during the whole run and
the device wrote no new tombstone.

### 3.3 The freeze does not kill the target any more

Two minutes of the freeze of the value of the test bed
(`tools/freeze_flow.py`):

```
alive=18356 freeze=710 canary=0 ... status ticks=26600 freezes=709 corrupt=0
```

* 720 freeze events, the target process was alive during the whole run,
* the daemon wrote the frozen value back into the target 10 times out of 12
  samples of its memory,
* the canary behind the frozen word stayed intact (`canary=0`) and the test
  bed counted no broken write (`corrupt=0`),
* the device wrote no tombstone of the target during the run (the tombstone
  of the device belongs to `com.dianjiqi`, an unrelated application that
  crashes on its own).

## 4. What was not changed

* No mock, no local stand in, no fallback: every number of this release was
  produced by the daemon of the app on the device against the real processes
  of the device.
* The daemon of the original application was not touched - the binaries of
  this repository are the ones of the release 4.
* SELinux was not changed: the device was `Permissive` before and after the
  run, the device was not rebooted (`/proc/uptime` only grew).  See
  `docs/ENVIRONMENT_IMPACT.md`.

## 5. Build

```
./gradlew :app:assembleRelease      # -> app/build/outputs/apk/release/app-release.apk
bash tools/build_release.sh         # -> release/GameGuardian-101.4-open.apk (aligned + signed)
python3 tools/patch_daemon.py       # -> the daemons of every architecture are patched
bash tools/deploy_noreboot.sh       # -> install it on the device without a reboot
```

## 6. The verification of the published asset

The asset was downloaded again from the release page and checked:

```
$ curl -sLO https://github.com/sdars/GameGuardian-Open-Source/releases/download/v101.4-open-source.5/GameGuardian-101.4-open.apk
$ sha256sum GameGuardian-101.4-open.apk
49e05361f38c3af15f7d9af277c10292f1f6bc87e05633347424d69350f42885  GameGuardian-101.4-open.apk
$ md5sum classes.dex res/raw/ydw0 res/raw/ydw1 res/raw/ydw2 res/raw/ydw5 res/raw/ydw7 res/raw/ydw8
7b7c606d43cb745f9f80e93d69b36bd1  classes.dex
101fc1b183eb6a0859481e9c96f6de01  res/raw/ydw0
5a9264bcb3f07610cb7ddadf654a7ce6  res/raw/ydw1
b84e80d7b89283b914cee412b64b51c9  res/raw/ydw2
615681e53ae55bf48b2b7409a0bd0c14  res/raw/ydw5
579e6be38776a4ede589c4b24ea570bb  res/raw/ydw7
df263a351bb7f19ef2ef9e8261b27b4c  res/raw/ydw8
```
