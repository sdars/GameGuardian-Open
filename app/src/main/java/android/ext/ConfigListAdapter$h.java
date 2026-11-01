package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$h implements android.content.DialogInterface.OnClickListener {
    ConfigListAdapter$h() {
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i == 0) {
            new android.ext.r$n("kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2fdwhjru|250ylghr0wxwruldov2").onClick(dialogInterface, i);
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int[] iArr = android.ext.ConfigListAdapter.h;
        int i2 = (i - 1) * 3;
        sb.append(android.ext.b2.f(iArr[i2]));
        sb.append(":\n");
        sb.append(android.ext.b2.f(iArr[i2 + 1]));
        java.lang.String string = sb.toString();
        int i3 = iArr[i2 + 2];
        if (i3 >= 0) {
            java.lang.String str = string.trim() + "\n\n";
            if (str.charAt(str.length() - 3) != ':') {
                str = str + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.video) + ":\n";
            }
            string = str + android.ext.Tools.removeNewLinesChars(android.ext.ConfigListAdapter.i[i3]);
        }
        if (iArr[i2] == 2131296613) {
            string = string.replace(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.s), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.app_name)) + "\nhttps://productforums.google.com/forum/#!topic/translate/1Pywh5vI1kE\n\n" + android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.without_float) + ":\n" + android.ext.Tools.removeNewLinesChars("kwwsv=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh25730krz0wr0xvh0jdphjxdugldq0zlwkrxw0iordw0zlqgrz0jdphjxdugldq2");
        }
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.main_new_version, null);
        android.widget.TextView textView = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.changelog);
        android.ext.Tools.v1(textView, string);
        android.ext.Tools.u(textView.getText());
        android.app.AlertDialog.Builder negativeButton = android.ext.f.b().setView(viewF).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), android.ext.ConfigListAdapter.h());
        if (iArr[i2] == 2131297106) {
            negativeButton.setPositiveButton(catch_.me_.if_.you_.can_.R.string.more, new android.ext.r$n("kwws=22jdphjxdugldq1qhw2iruxp2wrslf24<7540yluwxdo0vsdfhv0wr0uxq0jdphjxdugldq0zlwkrxw0urrw2"));
        }
        android.ext.f.o(negativeButton);
        if (android.ext.Config.C && iArr[i2] == 2131296621) {
            byte b2 = 2;
            try {
                if ((android.ext.Tools.Y(android.ext.Config.E).flags & 2) == 0) {
                    android.ext.f.o(android.ext.f.b().setMessage(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.not_optimized2), android.ext.Config.F, android.ext.Config.F)).setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.fix_it), new android.ext.r$n("kwws=22jdphjxdugldq1qhw2iruxp2wrslf24<7540yluwxdo0vsdfhv0wr0uxq0jdphjxdugldq0zlwkrxw0urrw2")).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
                }
            } catch (java.lang.Throwable th) {
                android.ext.e1.s("Failed check vSpace: " + android.ext.Config.E, th);
            }
            byte b3 = android.ext.Config.G;
            if (b3 == 0) {
                if (android.ext.ConfigListAdapter.k() && android.ext.Config.E.contains("64")) {
                    b2 = 1;
                }
                android.ext.Config.G = b2;
                b3 = b2;
            }
            if (b3 == 1) {
                try {
                    android.ext.f.o(android.ext.f.b().setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.vspace64)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
                } catch (java.lang.Throwable th2) {
                    android.ext.e1.s("Failed check vSpace: " + android.ext.Config.E, th2);
                }
            }
        }
    }
}
