package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$prompt$1$1 implements android.widget.SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.TextView f428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$prompt$1 f430c;

    Script$prompt$1$1(android.ext.Script$prompt$1 script$prompt$1, android.widget.TextView textView, int i) {
        this.f430c = script$prompt$1;
        this.f428a = textView;
        this.f429b = i;
    }

    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
        this.f428a.setText(java.lang.Integer.toString(i + this.f429b));
    }

    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
    }
}
