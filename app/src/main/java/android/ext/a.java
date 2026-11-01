package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class a extends android.view.ActionMode implements android.view.View.OnClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private android.widget.LinearLayout f560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private gg_c.a f561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private android.content.Context f562f;
    private android.view.WindowManager.LayoutParams i;
    private android.view.ActionMode.Callback j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.CharSequence f557a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private java.lang.CharSequence f558b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.view.View f559c = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f563g = false;
    private boolean h = false;

    public a(android.view.ActionMode.Callback actionMode$Callback) {
        this.f560d = null;
        this.f561e = null;
        android.content.Context context = android.ext.MainService.context;
        this.f562f = context;
        this.f561e = new gg_c.a(context);
        android.fix.LinearLayout linearLayout = new android.fix.LinearLayout(this.f562f);
        this.f560d = linearLayout;
        linearLayout.setAlpha(1.0f);
        android.graphics.drawable.Drawable background = this.f560d.getBackground();
        this.f560d.setBackgroundColor((background instanceof android.graphics.drawable.ColorDrawable ? ((android.graphics.drawable.ColorDrawable) background).getColor() : 0) | (-16777216));
        android.view.WindowManager.LayoutParams windowManager$LayoutParams = new android.view.WindowManager.LayoutParams();
        this.i = windowManager$LayoutParams;
        windowManager$LayoutParams.type = android.ext.m2.b();
        android.view.WindowManager.LayoutParams windowManager$LayoutParams2 = this.i;
        windowManager$LayoutParams2.width = -1;
        windowManager$LayoutParams2.height = -2;
        windowManager$LayoutParams2.format = -2;
        windowManager$LayoutParams2.flags = android.ext.m2.a();
        android.view.WindowManager.LayoutParams windowManager$LayoutParams3 = this.i;
        windowManager$LayoutParams3.gravity = 55;
        windowManager$LayoutParams3.y = 0;
        windowManager$LayoutParams3.alpha = 1.0f;
        this.j = actionMode$Callback;
    }

    public void a() {
        if (this.f563g) {
            try {
                android.ext.Tools.m1(this.f560d);
            } catch (java.lang.Throwable th) {
                android.ext.e1.l("removeView failed", th);
            }
            this.f563g = false;
        }
    }

    public void b() {
        if (this.f563g) {
            return;
        }
        try {
            android.ext.Tools.f(this.f560d, this.i);
            this.f563g = true;
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("addView failed", th);
        }
    }

    @Override // android.view.ActionMode
    public void finish() {
        if (this.h) {
            return;
        }
        this.h = true;
        a();
        this.j.onDestroyActionMode(this);
    }

    @Override // android.view.ActionMode
    public android.view.View getCustomView() {
        return this.f559c;
    }

    @Override // android.view.ActionMode
    public android.view.Menu getMenu() {
        return this.f561e;
    }

    @Override // android.view.ActionMode
    public android.view.MenuInflater getMenuInflater() {
        return new android.view.MenuInflater(this.f562f);
    }

    @Override // android.view.ActionMode
    public java.lang.CharSequence getSubtitle() {
        return this.f558b;
    }

    @Override // android.view.ActionMode
    public java.lang.CharSequence getTitle() {
        return this.f557a;
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        try {
            this.j.onPrepareActionMode(this, this.f561e);
            this.f560d.removeAllViews();
            int size = this.f561e.size();
            for (int i = 0; i < size; i++) {
                android.view.MenuItem item = this.f561e.getItem(i);
                android.fix.Button button = new android.fix.Button(this.f562f);
                button.setAlpha(1.0f);
                button.setFocusable(false);
                android.graphics.drawable.Drawable icon = item.getIcon();
                android.ext.Tools.c(button, icon, 32);
                if (icon == null) {
                    button.setText(item.getTitle());
                }
                button.setTag(item);
                button.setOnClickListener(this);
                this.f560d.addView(button);
            }
            android.view.View view = this.f559c;
            if (view != null) {
                this.f560d.addView(view);
            }
            this.f560d.invalidate();
            android.ext.e1.d("invalidate");
        } catch (java.lang.Throwable th_c_c_c) {
            this.f560d.removeAllViews();
            int size2 = this.f561e.size();
            for (int i2 = 0; i2 < size2; i2++) {
                android.view.MenuItem item2 = this.f561e.getItem(i2);
                android.fix.Button button2 = new android.fix.Button(this.f562f);
                button2.setAlpha(1.0f);
                button2.setFocusable(false);
                android.graphics.drawable.Drawable icon2 = item2.getIcon();
                android.ext.Tools.c(button2, icon2, 32);
                if (icon2 == null) {
                    button2.setText(item2.getTitle());
                }
                button2.setTag(item2);
                button2.setOnClickListener(this);
                this.f560d.addView(button2);
            }
            android.view.View view2 = this.f559c;
            if (view2 != null) {
                this.f560d.addView(view2);
            }
            this.f560d.invalidate();
            android.ext.e1.d("invalidate");
            throw th_c_c_c;
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        android.view.MenuItem menuItem = (android.view.MenuItem) view.getTag();
        if (menuItem instanceof gg_c.b) {
            ((gg_c.b) menuItem).a();
        }
        this.j.onActionItemClicked(this, menuItem);
    }

    @Override // android.view.ActionMode
    public void setCustomView(android.view.View view) {
        this.f559c = view;
        invalidate();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f558b = android.ext.b2.f(i);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(java.lang.CharSequence charSequence) {
        this.f558b = charSequence;
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f557a = android.ext.b2.f(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(java.lang.CharSequence charSequence) {
        this.f557a = charSequence;
    }
}
