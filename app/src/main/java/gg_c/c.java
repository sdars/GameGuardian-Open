package gg_c;

/* JADX INFO: loaded from: classes.dex */
public class c extends a implements android.view.SubMenu {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private java.lang.CharSequence f1502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    android.graphics.drawable.Drawable f1503f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    android.graphics.drawable.Drawable f1504g;
    android.view.View h;
    android.view.MenuItem i;
    a j;

    public c(android.content.Context context, a aVar, android.view.MenuItem menuItem) {
        super(context);
        this.f1502e = "";
        this.f1503f = null;
        this.f1504g = null;
        this.h = null;
        this.i = menuItem;
        this.j = aVar;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.h = null;
        this.f1502e = "";
        this.f1503f = null;
    }

    @Override // android.view.SubMenu
    public android.view.MenuItem getItem() {
        return this.i;
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setHeaderIcon(int i) {
        return setHeaderIcon(this.f1492b.getDrawable(i));
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setHeaderIcon(android.graphics.drawable.Drawable drawable) {
        this.f1503f = drawable;
        return this;
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setHeaderTitle(int i) {
        return setHeaderTitle(this.f1492b.getString(i));
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setHeaderTitle(java.lang.CharSequence charSequence) {
        this.f1502e = charSequence;
        return this;
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setHeaderView(android.view.View view) {
        this.h = view;
        return this;
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setIcon(int i) {
        return setIcon(this.f1492b.getDrawable(i));
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setIcon(android.graphics.drawable.Drawable drawable) {
        this.f1504g = drawable;
        return this;
    }
}
