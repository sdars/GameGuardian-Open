package gg_c;

/* JADX INFO: loaded from: classes.dex */
public class b implements android.view.MenuItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f1497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private java.lang.CharSequence f1498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private java.lang.CharSequence f1499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private android.content.Intent f1500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private char f1501g;
    private char h;
    private android.graphics.drawable.Drawable i;
    private android.content.Context j;
    private android.view.MenuItem.OnMenuItemClickListener k;
    private int l = 16;

    public b(android.content.Context context, int i, int i2, int i3, int i4, java.lang.CharSequence charSequence) {
        this.j = context;
        this.f1495a = i2;
        this.f1496b = i;
        this.f1497c = i4;
        this.f1498d = charSequence;
    }

    public boolean a() {
        android.view.MenuItem.OnMenuItemClickListener menuItem$OnMenuItemClickListener = this.k;
        if (menuItem$OnMenuItemClickListener != null && menuItem$OnMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        android.content.Intent intent = this.f1500f;
        if (intent == null) {
            return false;
        }
        this.j.startActivity(intent);
        return true;
    }

    public b b(boolean z) {
        this.l = (z ? 4 : 0) | (this.l & (-5));
        return this;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        return null;
    }

    @Override // android.view.MenuItem
    public android.view.View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1496b;
    }

    @Override // android.view.MenuItem
    public android.graphics.drawable.Drawable getIcon() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public android.content.Intent getIntent() {
        return this.f1500f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1495a;
    }

    @Override // android.view.MenuItem
    public android.view.ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1501g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1497c;
    }

    @Override // android.view.MenuItem
    public android.view.SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public java.lang.CharSequence getTitle() {
        return this.f1498d;
    }

    @Override // android.view.MenuItem
    public java.lang.CharSequence getTitleCondensed() {
        return this.f1499e;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.l & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.l & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.l & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.l & 8) == 0;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setActionView(int i) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setActionView(android.view.View view) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setAlphabeticShortcut(char c2) {
        this.h = c2;
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setCheckable(boolean z) {
        this.l = (z ? 1 : 0) | (this.l & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setChecked(boolean z) {
        this.l = (z ? 2 : 0) | (this.l & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setEnabled(boolean z) {
        this.l = (z ? 16 : 0) | (this.l & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIcon(int i) {
        try {
            this.i = this.j.getDrawable(i);
        } catch (java.lang.Throwable unused) {
        }
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIcon(android.graphics.drawable.Drawable drawable) {
        this.i = drawable;
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIntent(android.content.Intent intent) {
        this.f1500f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setNumericShortcut(char c2) {
        this.f1501g = c2;
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener menuItem$OnActionExpandListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener menuItem$OnMenuItemClickListener) {
        this.k = menuItem$OnMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setShortcut(char c2, char c3) {
        this.f1501g = c2;
        this.h = c3;
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setTitle(int i) {
        this.f1498d = this.j.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setTitle(java.lang.CharSequence charSequence) {
        this.f1498d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setTitleCondensed(java.lang.CharSequence charSequence) {
        this.f1499e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setVisible(boolean z) {
        this.l = (this.l & 8) | (z ? 0 : 8);
        return this;
    }
}
