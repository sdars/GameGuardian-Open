    public void onClick(android.view.View view) {
        /* dex: the identity comparisons come first, the sparse switch on the
           view id is only reached for views that are not part of the
           overlay chrome. */
        if (view == this.p || view == this.q || view == this.s) {
            this.r(true);
            return;
        }
        if (view == this.P) {
            this.E0();
            return;
        }
        if (view == this.o) {
            this.t();
            return;
        }
        if (view == this.Q) {
            this.C0(true);
            return;
        }
        if (view == this.g0) {
            android.ext.Config.b(catch_.me_.if_.you_.can_.R$id.config_ranges).b();
            return;
        }
        if (view == null) {
            return;
        }
        java.lang.Object tag = view.getTag();
        int id;
        if (tag instanceof java.lang.Integer) {
            id = ((java.lang.Integer) tag).intValue();
        } else {
            id = view.getId();
        }
        switch (id) {
            case catch_.me_.if_.you_.can_.R$drawable.ic_ui_button_24dp:
                /* dex :sswitch_6 */
                this.f215e = true;
                return;
            case catch_.me_.if_.you_.can_.R$id.abort_button:
                /* dex :sswitch_5 */
                this.i.h();
                this.s();
                return;
            case catch_.me_.if_.you_.can_.R$id.hot_frame:
                /* dex :sswitch_4 */
                this.c0();
                return;
            case catch_.me_.if_.you_.can_.R$id.more_btn:
                /* dex :sswitch_3 */
                android.ext.Tools.s(this.J);
                return;
            case catch_.me_.if_.you_.can_.R$string.hide:
                /* dex :sswitch_0 */
                this.t();
                return;
            case catch_.me_.if_.you_.can_.R$string.interrupt:
                /* dex :sswitch_2 - the running script */
                java.lang.String string = "?";
                android.ext.Script script = this.f212b;
                if (script != null) {
                    java.lang.Object obj = script.U;
                    if (obj != null) {
                        string = obj.toString();
                        if (string.length() > 250) {
                            string = string.substring(0, 250) + "...";
                        }
                    }
                } else {
                    string = "??";
                }
                android.app.AlertDialog.Builder message = android.ext.f.b().setCustomTitle(android.ext.Tools.h0(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R$string.script))).setMessage(string);
                android.ext.f.o(message.setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.interrupt), new android.ext.MainService$q(this)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.no), null));
                return;
            case catch_.me_.if_.you_.can_.R$string.record:
                /* dex :sswitch_1 - the running recording */
                java.lang.String string2 = "?";
                android.ext.c2 c2Var = this.f216f;
                if (c2Var != null) {
                    string2 = c2Var.c();
                }
                android.app.AlertDialog.Builder message2 = android.ext.f.b().setCustomTitle(android.ext.Tools.h0(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R$string.record_script))).setMessage(string2);
                android.ext.f.o(message2.setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.stop), new android.ext.MainService$r(this)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.no), null));
                return;
            default:
                return;
        }
    }
