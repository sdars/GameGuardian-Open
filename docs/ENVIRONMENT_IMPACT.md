# What the reconstruction changes on the device

Short answer: **it does not change SELinux, the mount table, the APatch
superuser list or /system.**  The only device state this project ever
changed is the root grant for its own package (the same mechanism the
original GameGuardian needs) and the files the app and the daemon unpack
into `/data/local/tmp`, which is the original behaviour.

## 1. Code audit

`grep -rniE "setenforce|setprop|chcon|magiskpolicy|sepolicy|restorecon|mount -o|remount" app/src/main/java tools/*.sh`

There is **no** `setenforce`, no `magiskpolicy`, no `chcon`/`restorecon` and no
sepolicy write anywhere in the app or in the deployment scripts.  The only
hits are three strings that the original dex contains as well:

| our source | original dex | what it does |
|---|---|---|
| `f0.java:275-276` `",remount"` / `"remount," + str19` | `f0.smali:975,994` | remounts a partition rw so that the daemon binary can be placed on it |
| `f0.java:288` `"mount -o "` | `f0.smali:1040` | same code path |
| `MainService$c0$c$a.java:18` `"exec setprop wrap."` | `MainService$c0$c$a.smali:66` | the android wrap.sh debug property |
| `n0$e.java:16` `"exec setprop persist.sys.whetstone.level 0"` | `n0$e.smali:45` | disables the whetstone crash counter |

The SELinux switch of the settings screen is **not** a switch of the
kernel enforcement mode.  `Config.r()` only ORs a bit into the flag word
that is handed to the daemon:

    if (((Config$p) eVar.get(R.id.selinux)).f42d == 1) { i2 |= 4; }

which is byte for byte the original `Config.r()` (`Config.smali`, the
`selinux` string is at line 419).  The bit tells the injected code that it
may run under a enforcing policy; the app itself never touches the policy.

## 2. Runtime A/B on the device

The app was driven through a real round on the test device (launch, open
the floating panel, open the search dialog, type 999) and the state was
sampled before and after with `tools/env_snapshot.sh`:

    bash tools/env_snapshot.sh before
    #   ... launch the app and drive it ...
    bash tools/env_snapshot.sh after
    bash tools/env_snapshot.sh --diff before after

| probe | before | after |
|---|---|---|
| `getenforce` (shell / root) | `Permissive` / `Permissive` | `Permissive` / `Permissive` |
| md5 `/proc/mounts` | `46a1a9195f924c17dfe452a58b6684bd` | `46a1a9195f924c17dfe452a58b6684bd` |
| md5 `/data/adb/ap/package_config` | `7e1d390cfa7420b68e5e8ec69f2768f4` | `7e1d390cfa7420b68e5e8ec69f2768f4` |
| md5 `/system/build.prop` | `a17d8086ef59e0e69b74a040b20642a4` | `a17d8086ef59e0e69b74a040b20642a4` |
| `pm list packages` | identical | identical |
| `ls -la /data/local/tmp` | identical | identical |

Raw logs: `build/logs/snap_before.log`, `build/logs/snap_after2.log`,
`build/logs/tmp_before.txt`, `build/logs/tmp_after.txt`.

## 3. Why the device is permissive

That is the state of the device, not something the app did:

* APatch is the root solution of this device.  Every entry of its
  superuser list carries `sctx=u:r:magisk:s0`, and `adb shell` already
  runs in the magisk domain (`/proc/self/attr/current` = `u:r:magisk:s0`).
* `/data/adb/ap/bin` ships `magiskpolicy` and `resetprop`.  They are part of
  APatch, this project never executes them.
* `/proc/cmdline` shows the stock kernel command line
  (`androidboot.veritymode=enforcing`, `dm="system none ro,0 1 android-verity ..."`),
  the app does not patch the boot image.

## 4. Device state that this project did change

1. **The root grant of the package** - `/data/adb/ap/package_config` got an
   entry for the package of the release (the self install gives it a random
   name and a new uid on every install, the entry of the run of the fix
   release 3 was `com.lfq.hy.rhmxkypfyj,0,1,10315,0,u:r:magisk:s0`; the
   original package `com.utnciuwv.ldcsra` is on the same list).
   `tools/grant_root.sh` writes that entry and keeps the uid in sync after
   every reinstall; it leaves a `package_config.bak-*` copy next to it.
2. **Debug leftovers in `/data/local/tmp`** - the probes of this project
   (`abi_scan.sh`, `class32.sh`, `class_of*.sh`, `daemon_*.sh`, `fds.sh`,
   `gg_uid.sh`, `gglog.sh`, `lsapp.sh`, `prefs_watch.sh`, `probe*.sh`,
   `scan_all.sh`, `t.dex`, `tm*.dex`, the `*.MF` files, `ADBKeyboard.apk`,
   `gg-orig.apk`, `fr.apk`, `lib05.so`, `lib5.so`).
3. **Installed packages** - the release package (installed as
   `com.lfq.hy.rhmxkypfyj` by the self install) and the probe packages
   `com.gg.abitest`, `com.gg.abi64`, `com.gg.uidprobe`.

The files `server`, `server.sh`, `script_execution.log`, `ydw00` .. `ydw08`
and `ggt/`, `ggt3/` in `/data/local/tmp` are **not** debug leftovers:
they are unpacked by the daemon at runtime, exactly like the original does.

The 33 `res/raw` entries of the release APK were byte identical to the
original ones (`sha256` of every `ydw*` matched) until the fix release 3.
Since then the six daemons of the app carry the patch of
`docs/SPEED_HACK_EXEC_ONLY.md` - two instructions each, so that the daemon
reads the memory of the target with `ptrace` instead of
`process_vm_readv`.  The other 27 entries are still byte identical to the
original ones.  The patch is a change of the *copy* of the daemon in this
repository; the daemon of the original application is not touched.
