#!/usr/bin/env python3
"""Rebuild the "daemon failed to start" report of android.ext.f0$a0.

jadx nested the ABI queries of the dex into each other and emitted the three
"supported ABIs" loops a second time, this time without the array they
iterate over.  The dex (android/ext/f0$a0.smali, method run) is flat:

    try { str3 = Build.CPU_ABI;      sb.append(str3); sb.append("; "); z = "armeabi".equals(str3); }
    catch { log("Failed get ABI"); z = false; }
    try { str4 = Build.CPU_ABI2;     sb.append(str4); sb.append("; "); if ("armeabi".equals(str4)) z = true; }
    catch { log("Failed get ABI"); }
    try { for (str5 : Build.SUPPORTED_ABIS)        ... } catch { log(...); }
    try { for (str6 : Build.SUPPORTED_32_BIT_ABIS)  ... } catch { log(...); }
    try { for (str7 : Build.SUPPORTED_64_BIT_ABIS)  ... } catch { log(...); }
    if (z && b2.d("ydwa", "raw") == 0) { ... }
    string = sb.toString();
    ...

This script replaces the jadx block with exactly that.
"""
import os

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
PATH = os.path.join(ROOT, 'app', 'src', 'main', 'java', 'android', 'ext', 'f0$a0.java')

START = '                java.lang.String str3 = android.os.Build.CPU_ABI;'
END = '        } catch (java.lang.Throwable th6) {'

NEW = """            try {
                java.lang.String str3 = android.os.Build.CPU_ABI;
                sb.append(str3);
                sb.append("; ");
                zEquals = "armeabi".equals(str3);
            } catch (java.lang.Throwable thAbi1) {
                android.ext.e1.s("Failed get ABI", thAbi1);
                zEquals = false;
            }
            try {
                java.lang.String str4 = android.os.Build.CPU_ABI2;
                sb.append(str4);
                sb.append("; ");
                if ("armeabi".equals(str4)) {
                    zEquals = true;
                }
            } catch (java.lang.Throwable thAbi2) {
                android.ext.e1.s("Failed get ABI", thAbi2);
            }
            try {
                for (java.lang.String str5 : android.os.Build.SUPPORTED_ABIS) {
                    sb.append(str5);
                    sb.append("; ");
                    if ("armeabi".equals(str5)) {
                        zEquals = true;
                    }
                }
            } catch (java.lang.Throwable thAbi3) {
                android.ext.e1.s("Failed get ABI", thAbi3);
            }
            try {
                for (java.lang.String str6 : android.os.Build.SUPPORTED_32_BIT_ABIS) {
                    sb.append(str6);
                    sb.append("; ");
                    if ("armeabi".equals(str6)) {
                        zEquals = true;
                    }
                }
            } catch (java.lang.Throwable thAbi4) {
                android.ext.e1.s("Failed get ABI", thAbi4);
            }
            try {
                for (java.lang.String str7 : android.os.Build.SUPPORTED_64_BIT_ABIS) {
                    sb.append(str7);
                    sb.append("; ");
                    if ("armeabi".equals(str7)) {
                        zEquals = true;
                    }
                }
            } catch (java.lang.Throwable thAbi5) {
                android.ext.e1.s("Failed get ABI", thAbi5);
            }
            if (zEquals && android.ext.b2.d("ydwa", "raw") == 0) {
                str2 = str2 + "\\n\\n" + android.ext.Tools.N1(catch_.me_.if_.you_.can_.R$string.try_arm_version) + ": " + android.ext.i.f999a;
            }
            string = sb.toString();
            if (string.contains("mips")) {
                str2 = str2 + "\\n\\n" + android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.mips_arch);
            }
            java.lang.String str8 = str2 + "\\n\\nABIs: " + string + '\\n' + ((java.lang.Object) android.ext.e0.f730g) + '\\n' + android.os.Build.VERSION.SDK_INT + '\\n' + ((java.lang.Object) android.ext.e0.h);
            android.ext.e1.d("Supported ABIs: " + string);
            android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R$string.failed_load_daemon)).setMessage(str8).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.ok), (android.content.DialogInterface.OnClickListener) null));
            inOut.n(false);
            android.ext.MainService.instance.q0();
"""


def main():
    if not os.path.exists(PATH):
        print('MISSING', PATH)
        return
    lines = open(PATH, encoding='utf-8').read().split('\n')
    try:
        s = next(i for i, l in enumerate(lines) if l == START)
    except StopIteration:
        print('already repaired (marker not found)')
        return
    # the "try {" that opens the block
    s -= 1
    while lines[s].strip() != 'try {':
        s -= 1
    try:
        e = next(i for i, l in enumerate(lines) if l == END)
    except StopIteration:
        print('end marker not found')
        return
    # the block ends right before the "} catch (java.lang.Throwable th6) {" line
    e -= 1
    while lines[e].strip() == '':
        e -= 1
    out = lines[:s] + NEW.split('\n')[:-1] + lines[e:]
    open(PATH, 'w', encoding='utf-8').write('\n'.join(out))
    print('abi report rebuilt (%d lines replaced)' % (e - s))


if __name__ == '__main__':
    main()
