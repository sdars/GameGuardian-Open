package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class Config$OptionSeek extends android.ext.Config$p implements android.widget.SeekBar.OnSeekBarChangeListener {
    int k;
    protected java.lang.ref.WeakReference l;

    public Config$OptionSeek(int i, int i2, int i3, int i4, java.lang.String str, boolean z) {
        super(i, i2, i4, str, z);
        this.l = new java.lang.ref.WeakReference(null);
        this.k = i3;
    }

    public Config$OptionSeek(int i, int i2, int i3, int i4, java.lang.String str, boolean z, int i5) {
        this(i, i2, i3, i4, str, z);
        this.h = i5;
    }

    @Override // android.ext.Config$p
    public void b() {
        h();
    }

    @Override // android.ext.Config$p
    public boolean e(android.content.DialogInterface dialogInterface, int i) {
        android.widget.SeekBar seekBar = (android.widget.SeekBar) this.l.get();
        if (seekBar == null) {
            return false;
        }
        this.f42d = seekBar.getProgress();
        android.ext.Config.k();
        return true;
    }

    protected void h() {
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.option_seek, null);
        android.widget.SeekBar seekBar = (android.widget.SeekBar) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.seek);
        seekBar.setMax(this.k);
        seekBar.setProgress(this.f42d);
        seekBar.setOnSeekBarChangeListener(this);
        this.l = new java.lang.ref.WeakReference(seekBar);
        android.ext.f.m(android.ext.f.b().setCustomTitle(android.ext.Config.c(this.f39a, this.h, this.f45g)).setView(viewF).setPositiveButton(catch_.me_.if_.you_.can_.R.string.ok, this).setNegativeButton(catch_.me_.if_.you_.can_.R.string.cancel, (android.content.DialogInterface.OnClickListener) null).create());
    }

    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
    }

    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
    }

    @Override // android.ext.Config$p
    public java.lang.String toString() {
        return android.ext.Tools.N1(this.f39a);
    }
}
