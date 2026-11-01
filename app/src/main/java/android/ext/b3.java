package android.ext;

/* JADX INFO: loaded from: classes.dex */
abstract class b3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final android.widget.CheckBox f661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final android.widget.TextView f662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final android.widget.TextView f663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final android.widget.TextView f664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final android.widget.TextView f665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final android.widget.TextView f666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final android.widget.TextView f667g;
    final android.widget.TextView h;
    final android.widget.TextView i;
    final android.widget.TextView j;
    final android.view.View k;
    final int l;
    int m;

    b3(android.view.View view, android.ext.b3$a b3_a) {
        android.widget.CheckBox checkBox = (android.widget.CheckBox) view.findViewById(catch_.me_.if_.you_.can_.R.id.ch);
        this.f661a = checkBox;
        this.f662b = (android.widget.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.address);
        this.f663c = (android.widget.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.value_hex);
        this.f664d = (android.widget.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.value_rhex);
        this.f665e = (android.widget.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.value_string);
        this.f666f = (android.widget.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.value_java);
        this.f667g = (android.widget.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.value_arm);
        this.h = (android.widget.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.value_thumb);
        this.i = (android.widget.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.value_arm8);
        this.j = (android.widget.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.addr_item_region);
        this.k = view;
        this.l = android.ext.MainService.context.getResources().getConfiguration().orientation;
        view.setTag(this);
        checkBox.setOnCheckedChangeListener(b3_a);
        checkBox.setOnLongClickListener(b3_a);
        checkBox.setTag(this);
    }

    void a(boolean z, int i) {
        int i2;
        android.view.View view = this.k;
        if (z) {
            i2 = -2139864428;
        } else {
            i2 = this.m == i ? -2137746366 : 0;
        }
        view.setBackgroundColor(i2);
    }

    boolean b() {
        return this.l != android.ext.MainService.context.getResources().getConfiguration().orientation;
    }
}
