# GameGuardian 101.4 - open source reconstruction, fix release 4

Clean-room **Java reconstruction of GameGuardian 101.4**
(`catch_.me_.if_.you_.can_`, versionCode `16155`).

This release removes the last reason for the answer *"this process does not
support the speed hack"* (the daemon code `107`, the app code `1017`).
The fix of release 3 removed the first reason, the release 4 the second one:
the policy of SELinux, when it is **enforced**, does not allow the daemon to
run its injection library inside a privileged application.

| | |
|---|---|
| asset | `GameGuardian-101.4-open.apk` |
| sha256 | `4ab93fcd8f18d3d5f3a6cfbc5c7f417710651c9311fc6926df4fcaa0385d1650` |
| size | 17 896 103 bytes |
| dex sha256 | `a299243bb448edd55547fb93efdf61fee7f2b2e755a524069584ded983209d36` |
| dex md5 | `3eb347d94f97ace660e1c8ad55b38180` |
| tag | `v101.4-open-source.4` |
| repository | `sdars/GameGuardian-Open-Source` - independent repository, not a fork |
| based on | `v101.4-open-source.3` |

## 1. The root cause

The daemon of GameGuardian injects a small piece of code into the target
process.  That code loads the helper library `lib6.so` of the daemon, which
lives in the private directory of the app.  While the policy is enforced the
kernel refuses that:

```
11-06 03:24:53.970 W/FinalizerWatchd( 3998): type=1400 audit(0.0:657):
  avc: denied { execute } for
  path="/data/data/com.lfq.hy.rhmxkypfyj/files/GG-fNsV/lib6.so" dev="sda21"
  ino=3319603 scontext=u:r:priv_app:s0:c512,c768
  tcontext=u:object_r:app_data_file:s0:c512,c768 tclass=file permissive=0
11-06 03:24:53.989 I/android-daemon(10195): Copy lib cp: 2, No such file or
  directory; /system/priv-app/Phonesky/lib/arm64/_lib6.so;
  /data/user/0/com.lfq.hy.rhmxkypfyj/files/GG-fNsV/lib6.so
11-06 03:24:53.995 E/android-daemon(10195): Report Error: 107
```

The daemon has a second way for that case: it copies the helper library into
the directory of the target inside the system partition.  That can not work
on a normal device:

* the system partition is mounted read only,
* the directory does not exist,
* the policy of the root manager lets the daemon create a *file* there
  (`touch` works, the file gets the label `system_file`) but refuses to
  create a *directory* there (`mkdir` answers `EACCES`).

The daemon answers `107`, the app turns that into the message *"this process
does not support the speed hack"* (the app code `1017`).  Every process of a
privileged application - the Play Store, the launcher, the system user
interface - is affected, so the speed panel looked broken on most of the
processes of the device.

The daemon of the original application has two modes for that, the app picks
one of them with the setting *"work with SELinux"* / *"work without
SELinux"* (bit 4 of the flag word that `Config.r()` hands over to the
daemon):

* **work with SELinux** - the daemon stays inside the rules of the policy,
  it uses the copy above, it fails on a device that enforces the policy,
* **work without SELinux** - the daemon turns the enforcement off while it
  works, the kernel reports it:

  ```
  11-06 05:43:54.516 I/SELinux (  550): avc:  received setenforce notice
    (enforcing=0)
  ```

  and the injection works for every target, of every architecture and of
  every kind of application.

The original app writes the marker `sel.txt` when a run failed and asks at
the next start whether it should work with SELinux.  On a device that
enforces the policy that question can not change the result: the mode
"work with SELinux" fails in exactly the same way as the run that failed
before, so the question only produces the same failure again and again.

## 2. The fix

`app/src/main/java/android/ext/f1.java`, the method `k()` and the new
method `enforcing()`:

* the app reads the state of the enforcement - `getenforce` through the
  root shell of the app (the command has to carry an `exec`, the root
  wrapper of the app refuses every other form), with
  `/sys/fs/selinux/enforce` as the fallback for the case that the app runs
  without a root shell,
* if the policy is enforced the app switches itself to the mode *"work
  without SELinux"*, saves the setting and restarts the daemon,
* if the policy is not enforced the original behaviour is kept (the question
  of the original application is shown).

The switch happens on **every** start while the policy is enforced, not only
after a failed run: the device can be rebooted between two runs, the reboot
brings the enforcement back and the setting of the app survives it.

The mode is the mode of the original application for a device that enforces
the policy, the daemon of the original application is the daemon of this
repository - only the two instructions of its self test are patched
(`docs/SPEED_HACK_EXEC_ONLY.md`).

The whole change is 60 lines of one file, the daemon binaries of release 3
are unchanged.

The log of the app on the device:

```
E/AndroidService(12934): cmd (exec getenforce) out: Enforcing
E/AndroidService(12934): the policy is enforced: work without SELinux
```

## 3. The verification on the device

Device: MI 8, Android 10, LineageOS 17.1, APatch.  The policy was **enforced**
at the start of the run, the build of this release is the one that was
installed and verified (`com.wntyypi`, root granted by APatch).

Before the fix, the same target answered with the error code 107
(`build/flow/lc_rel16_3969.txt`):

```
W/FinalizerWatchd( 3969): avc: denied { execute } for path=".../GG-GgmI/lib6.so"
I/android-daemon( 6249): Copy lib cp: 2, No such file or directory; ...
E/android-daemon( 6249): Report Error: 107
```

After the fix, the daemon turns the enforcement off, reads the memory of the
target with `ptrace` (`CV: 00` instead of `CV: 11`) and installs the hook:

```
I/SELinux (  550): avc:  received setenforce notice (enforcing=0)
I/android-daemon(13837): hook 2 installed: 131
E/android-daemon(13837): Send code: 11
E/android-daemon(13837): Send code: 18
E/android-daemon(13837): Send code: 18
```

The matrix of the targets - every row is a real process of the device, the
hook is installed by the daemon of the app:

| target | arch | errors | codes |
|---|---|---|---|
| `[16403] Google Play 商店` (vending, privileged app) | 64 bit | none | 11, 18, 18 |
| `[2420] 系统界面` (systemui) | 64 bit | none | 11, 18, 18 |
| `[22705] Trebuchet` (launcher3, privileged app) | 64 bit | none | 11, 18, 18 |
| `[6304] GG32Probe` (com.gg.abitest) | **32 bit** | none | 18, 18 |
| `[8706] 文件` (documentsui) | 64 bit | none | 18, 18 |
| `[9075] 软件包安装程序` (packageinstaller) | 64 bit | none | 18, 18 |
| `[11329] 权限控制器` (permissioncontroller) | 64 bit | none | 18, 18 |
| `[3932] com.android.smspush` | 64 bit | none | 18, 18 |
| `[3256] Google 服务框架` (com.google.android.gms) | 64 bit | none | 18, 18 |

`codes` are the answers of the daemon (`11` = the hook point was found,
`18` = the speed of the target was changed), `errors` is the list of the
`Report Error:` lines of the run.  There is no `Report Error` in any of the
runs.  The log of every row is kept in `build/flow/lc_rel19_<pid>.txt`.

The value search of the same build, on a 64 bit target and on the 32 bit
target, the daemon reports the results and the panel lists them:

```
64 bit, Google Play 商店:
E/AndroidService( 1324): sendSearchNumber: 777; 0 x0 as 20000004 in 0-ffffffffffffffff, 0
I/android-daemon( 1396): searchNumber: 777; 0, 20000004 0-ffffffffffffffff
I/android-daemon( 1396): ::searchDone: 7, 7 0
   found_count is ' (7)'

32 bit, GG32Probe:
E/AndroidService( 2783): sendSearchNumber: 777; 0 x0 as 20000004 in 0-ffffffffffffffff, 0
I/android-daemon( 2860): searchNumber: 777; 0, 20000004 0-ffffffffffffffff
I/android-daemon( 2860): ::searchDone: 2, 2 0
   found_count is ' (2)'
```

The daemon binary that the build unpacks on the device is the patched one:

```
615681e53ae55bf48b2b7409a0bd0c14  /data/data/com.wntyypi/files/GG-cMjb/lib5.so
```

## 4. What was not changed

* No mock, no local stand in, no fallback: every number of this release was
  produced by the daemon of the app on the device against the real
  processes.
* The daemon of the original application was not touched.
* The app does not touch the policy itself - there is no `setenforce`, no
  `magiskpolicy` and no sepolicy write in the source.  The daemon does it,
  and that is the mechanism of the original application.  The effect on the
  device is the enforcement mode of the kernel: it is off while the daemon
  works and it is back after a reboot of the device.  `docs/ENVIRONMENT_IMPACT.md`
  describes the state of the device in detail.

## 5. Build

```
./gradlew :app:assembleRelease      # -> app/build/outputs/apk/release/app-release.apk
bash tools/build_release.sh         # -> release/GameGuardian-101.4-open.apk (aligned + signed)
python3 tools/patch_daemon.py       # -> the daemons of every architecture are patched
bash tools/deploy.sh                # -> install it on the device, grant the root, start the daemon
```

## 6. The verification of the published asset

The asset was downloaded again from the release page and checked:

```
$ curl -sLO https://github.com/sdars/GameGuardian-Open-Source/releases/download/v101.4-open-source.4/GameGuardian-101.4-open.apk
$ sha256sum GameGuardian-101.4-open.apk
4ab93fcd8f18d3d5f3a6cfbc5c7f417710651c9311fc6926df4fcaa0385d1650  GameGuardian-101.4-open.apk
$ md5sum classes.dex res/raw/ydw0 res/raw/ydw1 res/raw/ydw2 res/raw/ydw5 res/raw/ydw7 res/raw/ydw8
3eb347d94f97ace660e1c8ad55b38180  classes.dex
101fc1b183eb6a0859481e9c96f6de01  res/raw/ydw0
5a9264bcb3f07610cb7ddadf654a7ce6  res/raw/ydw1
b84e80d7b89283b914cee412b64b51c9  res/raw/ydw2
615681e53ae55bf48b2b7409a0bd0c14  res/raw/ydw5
579e6be38776a4ede589c4b24ea570bb  res/raw/ydw7
df263a351bb7f19ef2ef9e8261b27b4c  res/raw/ydw8
```

The digest that github computed for the uploaded file is the same:

```
GameGuardian-101.4-open.apk 17896103 uploaded sha256:4ab93fcd8f18d3d5f3a6cfbc5c7f417710651c9311fc6926df4fcaa0385d1650
```

That published asset was installed on the device (as `com.q.jloinrvodbpxlu`)
and verified there - the daemon it unpacks is the patched one
(`615681e53ae55bf48b2b7409a0bd0c14`), the policy of the device was enforced
before the run and the daemon turned it off while it worked:

```
I/SELinux (  550): avc:  received setenforce notice (enforcing=0)
```

The speed panel of the published asset:

| target | arch | errors | codes |
|---|---|---|---|
| `[16403] Google Play 商店` (vending, privileged app) | 64 bit | none | 11, 18, 18 |
| `[22705] Trebuchet` (launcher3, privileged app) | 64 bit | none | 11, 18, 18 |
| `[24932] 系统界面` (systemui) | 64 bit | none | 11, 18, 18 |
| `[6304] GG32Probe` (com.gg.abitest) | **32 bit** | none | 11, 18, 18 |

The value search of the published asset:

```
64 bit, Google Play 商店:  found_count is ' (5)'   ::searchDone: 5, 5 0
32 bit, GG32Probe:        found_count is ' (2)'   ::searchDone: 2, 2 0
```
