package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class x implements android.content.DialogInterface.OnShowListener, android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile android.app.AlertDialog f1290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final android.widget.TextView f1291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final android.widget.ProgressBar f1292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final android.widget.TextView f1293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final android.view.View f1294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final android.widget.ProgressBar f1295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final android.widget.TextView f1296g;
    final android.widget.TextView h;
    final android.widget.TextView i;
    final android.view.View j;
    long k = -1;
    long l = -1;
    long m = -1;
    final java.lang.Runnable n = new android.ext.x$a(this);

    public x() {
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.service_busy_dialog, null);
        this.j = viewF;
        this.f1291b = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.message);
        this.f1292c = (android.widget.ProgressBar) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.progress_bar);
        this.f1293d = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.progress_bar_text);
        this.f1294e = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.stage_layout);
        this.f1295f = (android.widget.ProgressBar) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.progress_bar_stage);
        this.f1296g = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.progress_bar_stage_text);
        this.h = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.found_count);
        this.i = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.time);
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.help_speed_up).setOnClickListener(this);
    }

    public void a(boolean z) {
        android.app.AlertDialog alertDialog = this.f1290a;
        if (alertDialog == null) {
            return;
        }
        android.ext.n2.d().removeCallbacks(this.n);
        android.ext.Tools.D(alertDialog);
        if (z) {
            this.f1290a = null;
        }
    }

    public boolean b() {
        return this.f1290a != null;
    }

    public void c(java.lang.CharSequence charSequence, long j, long j2, int i, int i2, long j3, java.lang.String str) {
        if (b()) {
            if (android.ext.n2.e()) {
                d(charSequence, j, j2, i, i2, j3, str);
            } else {
                android.ext.n2.i(new android.ext.x$c(this, charSequence, j, j2, i, i2, j3, str));
            }
        }
    }

    void d(java.lang.CharSequence charSequence, long j, long j2, int i, int i2, long j3, java.lang.String str) {
        android.widget.TextView textView;
        java.lang.String str2;
        if (charSequence != null) {
            this.f1291b.setText(charSequence);
        }
        if (j < 0 || j2 == 0) {
            this.f1293d.setText(str);
            this.f1292c.setIndeterminate(true);
        } else {
            this.f1292c.setIndeterminate(false);
            this.f1292c.setMax((int) j2);
            this.f1292c.setProgress((int) j);
            this.f1293d.setText(str);
        }
        if (i >= 0) {
            if (i2 <= 1) {
                this.f1294e.setVisibility(8);
            } else {
                this.f1295f.setMax(i2);
                this.f1295f.setProgress(i);
                this.f1296g.setText(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.from), java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2)));
                this.f1294e.setVisibility(0);
            }
        }
        this.h.setText(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.found_count), java.lang.Long.valueOf(j3)));
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long jRound = -1;
        if (j < 0) {
            this.k = -1L;
            this.l = -1L;
            this.m = -1L;
        } else if (this.m != j2) {
            this.k = jCurrentTimeMillis;
            this.l = j;
            this.m = j2;
        }
        long j4 = this.k;
        if (j4 >= 0 && jCurrentTimeMillis - j4 >= 2000) {
            long j5 = this.l;
            if (j - j5 != 0) {
                jRound = java.lang.Math.round((((jCurrentTimeMillis - j4) * (j2 - j)) / (j - j5)) / 1000.0d);
            }
        }
        if (jRound <= 0) {
            textView = this.i;
            str2 = "";
        } else {
            textView = this.i;
            str2 = android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.time_remaining) + ": " + android.ext.Tools.g1(jRound);
        }
        textView.setText(str2);
    }

    public boolean e(boolean z) {
        android.app.AlertDialog alertDialog = this.f1290a;
        if (alertDialog == null) {
            if (z) {
                android.ext.n2.i(new android.ext.x$b(this));
            }
            return true;
        }
        android.ext.f.m(alertDialog);
        if (z) {
            android.ext.e1.g("Show busy dialog not first time", new java.lang.RuntimeException());
        }
        return true;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        android.ext.ConfigListAdapter.t(catch_.me_.if_.you_.can_.R.string.help_speed_up);
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.s1(dialogInterface, -1, java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.string.hide), android.ext.MainService.instance);
        android.ext.Tools.s1(dialogInterface, -2, java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.id.abort_button), android.ext.MainService.instance);
    }
}
