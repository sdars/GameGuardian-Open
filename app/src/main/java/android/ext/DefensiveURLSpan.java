package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class DefensiveURLSpan extends android.text.style.URLSpan {
    public DefensiveURLSpan(java.lang.String str) {
        super(str);
    }

    public static void a(android.widget.TextView textView) {
        b(textView.getText());
    }

    public static void b(java.lang.CharSequence charSequence) {
        if (charSequence instanceof android.text.SpannableString) {
            android.text.SpannableString spannableString = (android.text.SpannableString) charSequence;
            for (android.text.style.URLSpan uRLSpan : (android.text.style.URLSpan[]) spannableString.getSpans(0, spannableString.length(), android.text.style.URLSpan.class)) {
                int spanStart = spannableString.getSpanStart(uRLSpan);
                int spanEnd = spannableString.getSpanEnd(uRLSpan);
                spannableString.removeSpan(uRLSpan);
                spannableString.setSpan(new android.ext.DefensiveURLSpan(uRLSpan.getURL()), spanStart, spanEnd, 0);
            }
        }
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(android.view.View view) {
/* gg-shared-throwable */ java.lang.Throwable e = null;
        java.lang.String str;
        try {
            try {
                super.onClick(view);
                e = null;
            } catch (android.content.ActivityNotFoundException e2) {
                e = e2;
                str = "failed call activity";
                android.ext.e1.s(str, e);
                return;
            }
        } catch (android.util.AndroidRuntimeException e3) {
            e = e3;
        } catch (android.view.WindowManager.BadTokenException e4) {
            e = e4;
        } catch (java.lang.SecurityException e5) {
            e = e5;
        }
        if (e != null) {
            try {
                android.ext.e1.s("failed onClick on URLSpan: " + getURL(), e);
                android.net.Uri uri = android.net.Uri.parse(getURL());
                android.content.Context context = view.getContext();
                android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", uri);
                intent.putExtra("com.android.browser.application_id", android.ext.Tools.C0());
                intent.setFlags(268435456);
                try {
                    context.startActivity(intent);
                } catch (java.lang.Throwable unused) {
                    android.ext.e1.s("failed2 onClick on URLSpan: " + getURL(), e);
                }
            } catch (java.lang.SecurityException e6) {
                e = e6;
                str = "failed onClick on URLSpan: " + getURL();
                android.ext.e1.s(str, e);
                return;
            }
        }
        android.ext.f.d();
    }
}
