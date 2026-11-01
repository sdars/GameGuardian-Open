    public void k0(int i) {
        s();
        boolean z = i <= 100;
        /* dex: v10 is the id of the action/title line, v13 the id of the
           error description and v0 the optional extra text. */
        int titleId = catch_.me_.if_.you_.can_.R$string.reset_search;
        int bodyId = catch_.me_.if_.you_.can_.R$string.unknown_error;
        java.lang.String extra = null;
        if (i == 1) {
            bodyId = catch_.me_.if_.you_.can_.R$string.out_of_memory;
        } else if (i == 2) {
            bodyId = catch_.me_.if_.you_.can_.R$string.bug_detected;
        } else if (i == 3) {
            titleId = catch_.me_.if_.you_.can_.R$string.fix_path;
            bodyId = catch_.me_.if_.you_.can_.R$string.disk_full;
        } else if (i == 4) {
            titleId = catch_.me_.if_.you_.can_.R$string.fix_path;
            bodyId = catch_.me_.if_.you_.can_.R$string.io_error;
        } else if (i == 9) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.maps_failed));
            sb.append("\n\n");
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.game_protected));
            java.lang.String str = sb.toString();
            if (android.ext.Config.C) {
                sb = new java.lang.StringBuilder();
                sb.append(str);
                sb.append("\n\n");
                sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.need_root));
                str = sb.toString();
            }
            extra = i(str);
            bodyId = catch_.me_.if_.you_.can_.R$string.io_error;
        } else if (i == 10) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.maps_failed));
            sb.append("\n\n");
            sb.append(android.ext.b2.f(android.ext.Config.C ? catch_.me_.if_.you_.can_.R$string.vspace_error : catch_.me_.if_.you_.can_.R$string.root_error));
            extra = sb.toString();
            bodyId = catch_.me_.if_.you_.can_.R$string.io_error;
        } else if (i == 105) {
            /* dex :pswitch_3 - check whether the target process is optimised */
            int t105 = catch_.me_.if_.you_.can_.R$string.reset_search;
            java.lang.String e105 = null;
            if (android.ext.Config.C) {
                int flags = 0;
                boolean flagsKnown = false;
                try {
                    flags = android.ext.Tools.Y(android.ext.Config.E).flags;
                    flagsKnown = true;
                } catch (java.lang.Throwable th) {
                    android.ext.e1.s("Failed check vSpace: " + android.ext.Config.E, th);
                    e105 = null;
                    t105 = catch_.me_.if_.you_.can_.R$string.reset_search;
                }
                if (flagsKnown) {
                    if ((flags & 2) == 0) {
                        try {
                            e105 = android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.not_optimized2), android.ext.Config.F, android.ext.Config.F);
                            t105 = catch_.me_.if_.you_.can_.R$string.not_optimized2;
                        } catch (java.lang.Throwable th) {
                            android.ext.e1.s("Failed check vSpace: " + android.ext.Config.E, th);
                            e105 = null;
                            t105 = catch_.me_.if_.you_.can_.R$string.not_optimized2;
                        }
                    } else {
                        e105 = null;
                        t105 = catch_.me_.if_.you_.can_.R$string.reset_search;
                    }
                }
            } else {
                e105 = null;
                t105 = catch_.me_.if_.you_.can_.R$string.reset_search;
            }
            /* dex :goto_3 - the eperm description is only built when the
               optimised check did not produce a message */
            if (t105 == catch_.me_.if_.you_.can_.R$string.reset_search) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.eperm_error_descr_0));
                sb.append('\n');
                sb.append(1);
                sb.append(": ");
                sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.eperm_error_descr_3));
                sb.append('\n');
                sb.append(2);
                sb.append(": ");
                sb.append(android.ext.b2.f(android.ext.Config.C ? catch_.me_.if_.you_.can_.R$string.eperm_error_descr_5 : catch_.me_.if_.you_.can_.R$string.eperm_error_descr_4));
                e105 = sb.toString();
            }
            titleId = t105;
            bodyId = catch_.me_.if_.you_.can_.R$string.eperm_error;
            extra = e105;
        } else if (i == 106) {
            /* dex :pswitch_2 */
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.eperm_error_descr_0));
            sb.append('\n');
            sb.append(1);
            sb.append(": ");
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.eperm_error_descr_1));
            sb.append('\n');
            sb.append(64);
            sb.append(": ");
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.eperm_error_descr_2));
            extra = i(sb.toString());
            bodyId = catch_.me_.if_.you_.can_.R$string.eperm_error_defend;
        } else if (i == 107) {
            /* dex :pswitch_1 */
            titleId = catch_.me_.if_.you_.can_.R$string.speedhack_fail;
            bodyId = catch_.me_.if_.you_.can_.R$string.speedhack_fail;
            extra = null;
        } else if (i == 108) {
            /* dex :pswitch_0 */
            extra = android.ext.Tools.N1(catch_.me_.if_.you_.can_.R$string.too_many_union_numbers) + ": 64";
            bodyId = catch_.me_.if_.you_.can_.R$string.error;
        }
        if (extra == null) {
            extra = android.ext.b2.f(titleId);
        }
        java.lang.String strF2 = android.ext.b2.f(bodyId);
        java.lang.String str = "{" + i + '}';
        if (this.w0.get(i)) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (T0 < jCurrentTimeMillis) {
                T0 = jCurrentTimeMillis + 2000;
                android.ext.Tools.K1(str + android.ext.b2.f(bodyId), 0);
            }
            if (z) {
                q(true);
            }
            return;
        }
        this.w0.put(i, true);
        android.app.AlertDialog.Builder message = android.ext.f.b().setCustomTitle(android.ext.Tools.h0(str)).setMessage(strF2 + "\n\n" + extra);
        java.lang.String strF4 = android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.ok);
        android.content.DialogInterface.OnClickListener mainService$y = z ? new android.ext.MainService$y(this) : null;
        android.app.AlertDialog.Builder cancelable = message.setPositiveButton(strF4, mainService$y).setCancelable(false);
        java.lang.String strF3 = null;
        android.content.DialogInterface.OnClickListener r_n = null;
        if (titleId == catch_.me_.if_.you_.can_.R$string.fix_path) {
            strF3 = android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.fix_it);
            r_n = new android.ext.MainService$z(this);
        } else if (bodyId == catch_.me_.if_.you_.can_.R$string.eperm_error_defend) {
            strF3 = android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.help);
            r_n = new android.ext.MainService$a0(this);
        } else if (titleId == catch_.me_.if_.you_.can_.R$string.not_optimized2) {
            strF3 = android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.fix_it);
            r_n = new android.ext.r$n("kwws=22jdphjxdugldq1qhw2iruxp2wrslf24<7540yluwxdo0vsdfhv0wr0uxq0jdphjxdugldq0zlwkrxw0urrw2");
        }
        if (r_n != null) {
            cancelable.setNeutralButton(strF3, r_n);
        }
        android.ext.f.o(cancelable);
    }
