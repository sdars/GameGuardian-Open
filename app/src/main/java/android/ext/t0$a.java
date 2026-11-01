package android.ext;

/* JADX INFO: loaded from: classes.dex */
class t0$a implements android.widget.SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.TextView f1247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.t0 f1248b;

    t0$a(android.ext.t0 t0Var, android.widget.TextView textView) {
        this.f1248b = t0Var;
        this.f1247a = textView;
    }

    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
        this.f1247a.setText("" + (i + 1));
    }

    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
    }
}
