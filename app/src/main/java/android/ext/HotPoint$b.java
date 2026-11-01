package android.ext;

/* JADX INFO: loaded from: classes.dex */
class HotPoint$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.HotPoint f159a;

    HotPoint$b(android.ext.HotPoint hotPoint) {
        this.f159a = hotPoint;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.HotPoint hotPoint = this.f159a;
        hotPoint.t = hotPoint.findViewById(catch_.me_.if_.you_.can_.R.id.hot_frame);
        this.f159a.t.setOnClickListener(android.ext.MainService.instance);
        android.ext.HotPoint hotPoint2 = this.f159a;
        hotPoint2.s = (android.widget.ImageView) hotPoint2.findViewById(catch_.me_.if_.you_.can_.R.id.hot_point_icon);
        android.ext.HotPoint hotPoint3 = this.f159a;
        hotPoint3.u = hotPoint3.findViewById(catch_.me_.if_.you_.can_.R.id.progress_layout);
        android.ext.HotPoint hotPoint4 = this.f159a;
        hotPoint4.v = (android.widget.TextView) hotPoint4.findViewById(catch_.me_.if_.you_.can_.R.id.progress_bar_text);
        android.ext.HotPoint hotPoint5 = this.f159a;
        hotPoint5.w = (android.widget.ProgressBar) hotPoint5.findViewById(catch_.me_.if_.you_.can_.R.id.progress_bar);
        android.ext.HotPoint hotPoint6 = this.f159a;
        hotPoint6.x = (android.widget.ProgressBar) hotPoint6.findViewById(catch_.me_.if_.you_.can_.R.id.progress_bar_stage);
        android.ext.HotPoint hotPoint7 = this.f159a;
        hotPoint7.y = (android.widget.TextView) android.ext.Tools.O0(hotPoint7.findViewById(catch_.me_.if_.you_.can_.R.id.speed_text));
        android.ext.HotPoint hotPoint8 = this.f159a;
        hotPoint8.B = (android.widget.ImageView) hotPoint8.findViewById(catch_.me_.if_.you_.can_.R.id.speed_inc);
        android.ext.HotPoint hotPoint9 = this.f159a;
        hotPoint9.C = (android.widget.ImageView) hotPoint9.findViewById(catch_.me_.if_.you_.can_.R.id.speed_dec);
        android.ext.HotPoint hotPoint10 = this.f159a;
        hotPoint10.B.setOnClickListener(hotPoint10);
        android.ext.HotPoint hotPoint11 = this.f159a;
        hotPoint11.C.setOnClickListener(hotPoint11);
        android.ext.HotPoint hotPoint12 = this.f159a;
        hotPoint12.y.setOnLongClickListener(hotPoint12);
        this.f159a.y.addOnLayoutChangeListener(new android.ext.HotPoint$b$a(this));
        this.f159a.t((byte) 2, -1L, 1L, 0, 1, "");
        this.f159a.s();
        this.f159a.q();
    }
}
