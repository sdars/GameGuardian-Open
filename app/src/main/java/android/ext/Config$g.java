package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Config$g extends android.ext.Config$OptionSeek {
    private java.lang.ref.WeakReference m;

    Config$g(int i, int i2, int i3, int i4, java.lang.String str, boolean z, int i5) {
        super(i, i2, i3, i4, str, z, i5);
        this.m = new java.lang.ref.WeakReference(null);
    }

    @Override // android.ext.Config$OptionSeek
    protected void h() {
        super.h();
        android.widget.SeekBar seekBar = (android.widget.SeekBar) this.l.get();
        if (seekBar == null) {
            return;
        }
        android.widget.ImageView imageView = new android.widget.ImageView(seekBar.getContext());
        imageView.setImageResource(catch_.me_.if_.you_.can_.R.drawable.ic_tooltip_edit_white_24dp);
        this.m = new java.lang.ref.WeakReference(imageView);
        android.ext.Config.n(imageView, android.ext.Config.e(seekBar.getProgress()));
        android.view.ViewParent parent = seekBar.getParent();
        if (parent instanceof android.view.ViewGroup) {
            ((android.view.ViewGroup) parent).addView(imageView);
        }
    }

    @Override // android.ext.Config$OptionSeek, android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
        android.widget.ImageView imageView = (android.widget.ImageView) this.m.get();
        if (imageView == null) {
            return;
        }
        android.ext.Config.n(imageView, android.ext.Config.e(i));
    }
}
