# GameGuardian root 授权记录（APatch）

日期：2026-11-02
设备：`123.57.254.92:51213`（MI 8 / Android 10 / arm64-v8a）
Root 方案：APatch（`/system/bin/su` 为 APatch 提供的 su，版本 11224）
应用：`catch_.me_.if_.you_.can_`（每次安装 uid 会变）

## 根因

APatch 的授权名单保存在 `/data/adb/ap/package_config`（CSV，6 列）：

```
pkg,exclude,allow,uid,to_uid,sctx
```

名单里没有 GameGuardian 的记录时，应用内执行 `su` 会被拒绝
（`error=13, Permission denied`）。仅用 `adb shell su` 能拿到 root 并不代表
目标 UID 已被授权。

名单里的 uid 列必须与**当前**安装的 uid 一致：重装一次 uid 就变一次，
旧记录会静默失效。

## 两个包都要授权

GameGuardian 会把自身以随机包名再装一次（`android.ext.b1` 的自安装逻辑），
真正常驻、跑守护进程的是那个随机包，所以两个包都要授权：

- 启动器包：`catch_.me_.if_.you_.can_`
- 随机辅助包：从 logcat 的 `onActivityPaused: <pkg>.<Activity>` 里取包名

## 操作

```bash
tools/grant_root.sh catch_.me_.if_.you_.can_ --verify   # 启动器包
tools/grant_root.sh com.xxxxxxxxxxxx --verify           # 随机辅助包
```

脚本做的事：

1. 备份 `/data/adb/ap/package_config`；
2. 删除该包的旧行，按当前 uid 追加
   `<pkg>,0,1,<uid>,0,u:r:magisk:s0`，保持 `600 root:root`；
3. 安装一个一次性探针包 `com.gg.uidprobe`，触发 APatch 的 uid-listener
   重新同步名单（不改文件是不够的，名单要写进内核模块）；
4. `--verify` 用目标 uid 执行 `su -c id` 验证：APatch 会把 su 对未授权 uid
   隐藏，未生效时报 `ENOENT`/`Permission denied`。

**不要**用 kill apd 的方式强制刷新名单：apd 会被一起带走，随后内核 panic，
设备重启（dmesg：`Process apd (pid: ...)` + `Forcing a warm reset of the system`）。

## 验证

- `su <uid> -c "/system/bin/su -c id"` 返回
  `uid=0(root) ... context=u:r:magisk:s0`
- 内核日志出现 `su_add_allow_uid: uid: <uid>, to_uid: 0, sctx: u:r:magisk:s0, rc: 0`
- 应用启动后日志出现 `Daemon: .../files/GG-XXXX/lib5.so`、`DI: 8 4 <pid>`、
  `InOut: x64: true; QE_ALIGN: 4; <pid>`，
- 进程列表可用（`选择应用进程` 弹窗里能看到 `[pid] 包名 [x64] [MB]`），
  说明守护进程已以 root 运行。

