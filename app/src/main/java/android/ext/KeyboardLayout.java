package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class KeyboardLayout extends android.fix.LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.widget.ScrollView f208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.fix.FrameLayout f209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.ext.InternalKeyboard f210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f211d;

    public KeyboardLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a() {
        if (this.f208a != null) {
            return;
        }
        this.f211d = 0;
        this.f208a = (android.widget.ScrollView) findViewById(catch_.me_.if_.you_.can_.R.id.kbd_scroll);
        this.f209b = (android.fix.FrameLayout) findViewById(catch_.me_.if_.you_.can_.R.id.kbd_frame);
        this.f210c = (android.ext.InternalKeyboard) findViewById(catch_.me_.if_.you_.can_.R.id.keyboard);
    }

    private void b(android.view.View view, int i, int i2) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    public void c() {
        android.content.res.Configuration configuration = android.ext.Tools.f0().getResources().getConfiguration();
        int i = configuration.orientation;
        if (i == this.f211d) {
            return;
        }
        this.f211d = i;
        android.ext.e1.d("Screen: " + configuration.screenWidthDp + "dp x " + configuration.screenHeightDp + "dp");
        a();
        int[] iArr = i == 1 ? new int[]{1, -1, 0} : new int[]{0, -1, -2};
        setOrientation(iArr[0]);
        b(this.f208a.getVisibility() == 0 ? this.f208a : this.f209b, iArr[1], iArr[2]);
        this.f210c.t();
    }

    @Override // android.fix.LinearLayout, android.view.View
    protected void onConfigurationChanged(android.content.res.Configuration configuration) {
        android.ext.e1.d("KeyboardLayout onConfigurationChanged: " + configuration);
        android.content.res.Configuration configurationF = gg_a.b.f(configuration);
        super.onConfigurationChanged(configurationF);
        c();
        android.ext.MainService.Y(configurationF);
    }
}
