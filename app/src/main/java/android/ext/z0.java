package android.ext;

/* JADX INFO: loaded from: classes.dex */
abstract class z0 {
    private static int d(android.app.AlertDialog alertDialog) {
        int i;
        try {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            if (!alertDialog.getContext().getTheme().resolveAttribute(android.R.attr.colorAccent, typedValue, true) || (i = typedValue.type) < 28 || i > 31) {
                return -7686920;
            }
            return typedValue.data;
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return -7686920;
        }
    }

    static void e() {
        android.ext.r rVar = android.ext.r.n;
        if (rVar != null) {
            rVar.finish();
        }
        android.ext.f1.n();
    }

    static void f() {
        android.app.AlertDialog alertDialogCreate = android.ext.f.c(android.ext.r.p).setTitle(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.install_mode)).setMessage(g()).setPositiveButton(catch_.me_.if_.you_.can_.R.string.ok, new android.ext.z0$g()).create();
        i(alertDialogCreate);
        alertDialogCreate.setOnCancelListener(new android.ext.z0$h());
        android.ext.f.m(alertDialogCreate);
    }

    private static java.lang.CharSequence g() {
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
        spannableStringBuilder.append((java.lang.CharSequence) android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.install_help_intro)).append((java.lang.CharSequence) "\n\n");
        spannableStringBuilder.append((java.lang.CharSequence) android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.install_help_choose)).append((java.lang.CharSequence) "\n\n");
        java.lang.String[] strArr = {android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.default_mark), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.for32), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.for64)};
        int iMax = java.lang.Math.max(1, (int) (android.ext.r.p.getResources().getDisplayMetrics().density * 12.0f));
        int i = 0;
        while (i < 3) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((java.lang.CharSequence) "• ").append((java.lang.CharSequence) strArr[i]);
            spannableStringBuilder.setSpan(new android.text.style.LeadingMarginSpan.Standard(0, iMax), length, spannableStringBuilder.length(), 33);
            i++;
            if (i < 3) {
                spannableStringBuilder.append('\n');
            }
        }
        return spannableStringBuilder;
    }

    static void h() {
        android.app.AlertDialog alertDialogCreate = android.ext.f.c(android.ext.r.p).setTitle(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.install_mode)).setSingleChoiceItems(new java.lang.String[]{android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.default_mark), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.for32), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.for64)}, -1, new android.ext.z0$c()).setNegativeButton(catch_.me_.if_.you_.can_.R.string.cancel, new android.ext.z0$b()).setNeutralButton(catch_.me_.if_.you_.can_.R.string.more, new android.ext.z0$a()).setCancelable(true).create();
        i(alertDialogCreate);
        alertDialogCreate.setOnCancelListener(new android.ext.z0$d());
        android.ext.f.u(alertDialogCreate, new android.ext.z0$e(), new android.ext.z0$f());
    }

    private static void i(android.app.AlertDialog alertDialog) {
        try {
            android.widget.ListView listView = alertDialog.getListView();
            if (listView != null) {
                android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, new android.graphics.drawable.ColorDrawable(872415231));
                stateListDrawable.addState(new int[]{android.R.attr.state_focused}, new android.graphics.drawable.ColorDrawable(587202559));
                listView.setSelector(stateListDrawable);
                listView.setDivider(new android.graphics.drawable.ColorDrawable(587202559));
                listView.setDividerHeight(java.lang.Math.max(1, (int) listView.getResources().getDisplayMetrics().density));
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
        android.ext.f.l(alertDialog, new android.ext.z0$i(alertDialog));
    }

    static void j(android.app.AlertDialog alertDialog) {
        try {
            int iD = d(alertDialog);
            int[] iArr = {-1, -2, -3};
            for (int i = 0; i < 3; i++) {
                android.widget.Button button = alertDialog.getButton(iArr[i]);
                if (button != null) {
                    button.setTextColor(iD);
                    button.setTypeface(button.getTypeface(), 1);
                }
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }
}
