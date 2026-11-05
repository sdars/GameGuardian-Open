# The speed hack and the policy of SELinux

## 1. What happens while the policy is enforced

Since Android 10 the linker maps the system libraries of an application with
targetSdk >= 29 as "--xp" (execute only).  The daemon of GameGuardian reads
the code page of the hook point with process_vm_readv, which fails with
EFAULT on such a page - that is the first failure, it is fixed by the patch
of docs/SPEED_HACK_EXEC_ONLY.md.

The second failure appears while the policy of the device is *enforced*.
The daemon injects a small piece of code into the target and that code has
to load the helper library of the daemon (lib6.so).  The library lives in the
private directory of the app, and the policy does not allow a privileged
application to execute a file of that directory:

    W/FinalizerWatchd( 3998): avc: denied { execute } for
      path="/data/data/com.lfq.hy.rhmxkypfyj/files/GG-fNsV/lib6.so"
      scontext=u:r:priv_app:s0:c512,c768
      tcontext=u:object_r:app_data_file:s0:c512,c768 tclass=file permissive=0

For that case the daemon has a fallback: it copies the helper library into
the directory of the target inside the system partition

    I/android-daemon: Libs path: /system/priv-app/Phonesky/lib/arm64
    I/android-daemon: Copy lib cp: 2, No such file or directory;
      /system/priv-app/Phonesky/lib/arm64/_lib6.so;
      /data/user/0/com.lfq.hy.rhmxkypfyj/files/GG-fNsV/lib6.so
    E/android-daemon: Report Error: 107

The copy can not work on a normal device:

* the system partition is mounted read only
  ("/dev/block/.../system / ext4 ro,seclabel,relatime"),
* the directory does not exist, and the policy of the root manager does not
  allow the daemon to create a directory in the system partition: the root
  manager may create a *file* there (touch works, the file gets the label
  system_file), a *directory* is refused with EACCES.

The daemon answers that with the error 107, which the app shows as
"this process does not support the speed hack".

## 2. The mode that works on such a device

The daemon has two modes, the app picks one of them with the setting
"work with SELinux" / "work without SELinux" (the bit 4 of the flag word
that Config.r() hands over to the daemon):

* "work with SELinux" - the daemon stays inside the rules of the policy and
  uses the copy above.  It works only when the system partition can be
  written and the directory of the target can be created.
* "work without SELinux" - the daemon turns the enforcement off while it
  runs, the kernel reports it:

      I/SELinux (  550): avc:  received setenforce notice (enforcing=0)

  and the injection works for every target, of every architecture and of
  every kind of application (privileged or not).

The second mode is the mode of the original application for a device that
enforces the policy - the daemon of the original application is the daemon
of this repository, only the two instructions of its self test are patched
(docs/SPEED_HACK_EXEC_ONLY.md).

## 3. What the reconstruction does

The original application writes a marker (sel.txt) when a run failed and
asks the user at the next start whether it should work with SELinux.  On a
device that enforces the policy the answer can not change the result: the
mode "work with SELinux" fails in exactly the same way as the run that
failed before, so the question only produces the same failure again and
again.

The fix release 4 changes that (android/ext/f1.java, the method k()):

* the app reads the state of the enforcement ("exec getenforce" through the
  root shell of the app, with /sys/fs/selinux/enforce as the fallback - the
  app itself is not allowed to read that file, the root shell is), the root
  wrapper of the app only accepts a command that carries an "exec" or an
  "exit",
* if the policy is enforced the app switches itself to the mode
  "work without SELinux", saves the setting and restarts the daemon,
* if the policy is not enforced the original behaviour is kept (the
  question of the original application is shown).

The switch is done on **every** start while the policy is enforced, not
only after a failed run.  A reboot of the device brings the enforcement back
and the setting of the app survives the reboot, so the app has to look at
the state of the policy again at every start.

The log of the app on the device:

    E/AndroidService(12934): cmd (exec getenforce) out: Enforcing
    E/AndroidService(12934): the policy is enforced: work without SELinux

The daemon then turns the enforcement off while it works:

    I/SELinux (  550): avc:  received setenforce notice (enforcing=0)
    I/android-daemon(13837): hook 2 installed: 131
    E/android-daemon(13837): Send code: 11

The app itself still does not touch the policy - the daemon does, and it is
the mechanism of the original application.  The effect on the device is the
enforcement mode of the kernel: it is off while the daemon runs and it is
back after a reboot of the device.
