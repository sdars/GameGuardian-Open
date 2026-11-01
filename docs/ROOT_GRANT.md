# GameGuardian root 授权记录（APatch）

日期：2026-11-01
设备：`123.57.254.92:51213`（MI 8 / Android 10 / arm64-v8a）
Root 方案：APatch（`/system/bin/su` 为 APatch 提供的 su，版本 11224）
应用：`catch_.me_.if_.you_.can_`，UID `10132`

## 根因

APatch 的授权名单保存在 `/data/adb/ap/package_config`（CSV，6 列）：

```
pkg,exclude,allow,uid,to_uid,sctx
```

原文件只包含 `bin.mt.plus.canary`，没有 GameGuardian 的记录，因此应用内
执行 `su` 时被拒绝（`error=13, Permission denied`）。仅用 `adb shell su`
能拿到 root 并不代表目标 UID 已被授权。

## 操作

1. 备份原配置到 `/data/adb/ap/package_config.bak-20261101`。
2. 追加一行（保持末尾换行）：

```
catch_.me_.if_.you_.can_,0,1,10132,0,u:r:magisk:s0
```

3. 保持 `600 root:root` 权限，触发 APatch 重新加载名单。
4. 冷启动应用，让应用重新探测 root。

脚本见 `analysis/2026-11-01/device/grant_root.sh`。

## 验证

- `su 10132 -c "/system/bin/su -c id"` 返回
  `uid=0(root) ... context=u:r:magisk:s0`
- 内核日志出现 `su_add_allow_uid: uid: 10132, to_uid: 0, sctx: u:r:magisk:s0, rc: 0`
- 应用冷启动后进程列表可用，显示 `[2826] Trebuchet [x64] [176 MB]`，
  说明守护进程已以 root 运行。
- 截图：`analysis/2026-11-01/device/gg_verify.png`

## 经验

- `adb shell su` 成功只证明 shell UID（2000）被授权，不证明应用 UID 被授权。
- 手工编辑 `package_config` 时必须保留行尾换行，否则最后一行会与下一条记录粘连。
- 修改后需要让应用重新走一次 root 探测，单纯热重启进程可能仍沿用旧结果。
