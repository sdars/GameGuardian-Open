package gg_a;

/* JADX INFO: loaded from: classes.dex */
public class d extends android.view.LayoutInflater {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f16c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f17a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.view.LayoutInflater f18b;

    static {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(java.lang.Integer.valueOf(android.R.style.Theme_DeviceDefault));
        arrayList.add(java.lang.Integer.valueOf(android.R.style.Theme_Material));
        arrayList.add(java.lang.Integer.valueOf(android.R.style.Theme_Holo));
        arrayList.add(java.lang.Integer.valueOf(android.R.style.Theme));
        arrayList.add(java.lang.Integer.valueOf(android.R.style.Theme_Black));
        for (java.lang.reflect.Field field : android.R.class.getFields()) {
            int modifiers = field.getModifiers();
            if (java.lang.reflect.Modifier.isStatic(modifiers) && java.lang.reflect.Modifier.isFinal(modifiers) && field.getName().startsWith("Theme") && field.getType().equals(java.lang.Integer.TYPE)) {
                try {
                    arrayList.add(java.lang.Integer.valueOf(field.getInt(null)));
                } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException unused) {
                }
            }
        }
        f16c = new int[arrayList.size()];
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            f16c[i] = ((java.lang.Integer) arrayList.get(i)).intValue();
        }
    }

    public d(android.view.LayoutInflater layoutInflater) {
        super(layoutInflater, layoutInflater.getContext());
        this.f18b = layoutInflater;
        this.f17a = layoutInflater.getContext();
    }

    private void a(int i) {
        if (i == 0 || d(this.f18b.getContext()) == i) {
            return;
        }
        this.f18b = this.f18b.cloneInContext(b(i));
    }

    private android.content.Context b(int i) {
        return i == 1 ? this.f17a : new android.view.ContextThemeWrapper(this.f17a, i);
    }

    public static d c() {
        return (d) f.a(android.view.LayoutInflater.from(android.ext.Tools.f0()));
    }

    private int d(android.content.Context context) {
        if (context == this.f17a) {
            return 1;
        }
        if (context instanceof android.view.ContextThemeWrapper) {
            try {
                java.lang.Object objInvoke = android.view.ContextThemeWrapper.class.getDeclaredMethod("getThemeResId", new java.lang.Class[0]).invoke(context, new java.lang.Object[0]);
                if (objInvoke instanceof java.lang.Integer) {
                    return ((java.lang.Integer) objInvoke).intValue();
                }
            } catch (java.lang.Throwable th) {
                android.ext.e1.l("getThemeResId failed call", th);
            }
        }
        return 0;
    }

    private android.view.View e(int i, org.xmlpull.v1.XmlPullParser xmlPullParser, android.view.ViewGroup viewGroup, boolean z) {
        if (this.f18b == null) {
            return xmlPullParser == null ? super.inflate(i, viewGroup, z) : super.inflate(xmlPullParser, viewGroup, z);
        }
        try {
            return h(i, xmlPullParser, viewGroup, z);
        } catch (android.view.InflateException e2_c_c_c) {
            if (!i(e2_c_c_c, "tab_indicator_holo") && !i(e2_c_c_c, "tab_selected_holo")) {
                throw e2_c_c_c;
            }
            android.ext.e1.l("Try fix", e2_c_c_c);
            return h(catch_.me_.if_.you_.can_.R.layout.tab_indicator_holo, null, viewGroup, z);
        }
    }

    public static android.view.View f(int i, android.view.ViewGroup viewGroup) {
        return c().inflate(i, viewGroup);
    }

    public static android.view.View g(int i, android.view.ViewGroup viewGroup, boolean z) {
        return c().inflate(i, viewGroup, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v5, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r10v9 */
    private android.view.View h(int i, org.xmlpull.v1.XmlPullParser xmlPullParser, android.view.ViewGroup viewGroup, boolean z) {
        int[] iArr = f16c;
        int length = iArr.length;
        java.lang.RuntimeException runtimeException = null;
        int i2 = 0;
        int Inflate = i;
        while (i2 < length) {
            int i3 = iArr[i2];
            android.view.LayoutInflater layoutInflater = this.f18b;
            try {
                a(i3);
                return xmlPullParser == null ? this.f18b.inflate((int) Inflate, viewGroup, z) : this.f18b.inflate(xmlPullParser, viewGroup, z);
            } catch (java.lang.Exception e2) {
                if (runtimeException == null) {
                    runtimeException = e2 instanceof java.lang.RuntimeException ? (java.lang.RuntimeException) e2 : new java.lang.RuntimeException(e2);
                }
                if (!(e2 instanceof android.view.InflateException) && !(e2 instanceof java.lang.reflect.InvocationTargetException)) {
                    throw runtimeException;
                }
                android.ext.e1.l("Exception on inflate with theme: " + i3, e2);
                if (android.ext.Config.vSpaceReal) {
                    if (getContext().getPackageName().equals(android.ext.Config.E)) {
                        continue;
                    } else {
                        android.view.LayoutInflater layoutInflater2 = this.f18b;
                        android.view.LayoutInflater layoutInflaterCloneInContext = layoutInflater2.cloneInContext(android.ext.Config.a(layoutInflater2.getContext()));
                        this.f18b = layoutInflaterCloneInContext;
                        try {
                            return xmlPullParser == null ? layoutInflaterCloneInContext.inflate(Inflate, viewGroup, z) : layoutInflaterCloneInContext.inflate(xmlPullParser, viewGroup, z);
                        } catch (android.view.InflateException e3) {
                            android.ext.e1.l("Exception on inflate with theme: " + i3, e3);
                            this.f18b = layoutInflater;
                            i2++;
                            Inflate = Inflate;
                        }
                    }
                }
                this.f18b = layoutInflater;
                i2++;
                Inflate = Inflate;
            }
        }
        throw runtimeException;
    }

    private boolean i(java.lang.Throwable th, java.lang.String str) {
        if (str == null || th == null) {
            return false;
        }
        java.lang.String message = th.getMessage();
        if (message == null || !message.contains(str)) {
            return i(th.getCause(), str);
        }
        return true;
    }

    @Override // android.view.LayoutInflater
    public android.view.LayoutInflater cloneInContext(android.content.Context context) {
        return new d(this.f18b.cloneInContext(context));
    }

    public boolean equals(java.lang.Object obj) {
        android.view.LayoutInflater layoutInflater = this.f18b;
        return layoutInflater == null ? super.equals(obj) : layoutInflater.equals(obj);
    }

    @Override // android.view.LayoutInflater
    public android.content.Context getContext() {
        android.view.LayoutInflater layoutInflater = this.f18b;
        return layoutInflater == null ? super.getContext() : layoutInflater.getContext();
    }

    @Override // android.view.LayoutInflater
    public android.view.LayoutInflater.Filter getFilter() {
        android.view.LayoutInflater layoutInflater = this.f18b;
        return layoutInflater == null ? super.getFilter() : layoutInflater.getFilter();
    }

    public int hashCode() {
        android.view.LayoutInflater layoutInflater = this.f18b;
        return layoutInflater == null ? super.hashCode() : layoutInflater.hashCode();
    }

    @Override // android.view.LayoutInflater
    public android.view.View inflate(int i, android.view.ViewGroup viewGroup) {
        return inflate(i, viewGroup, viewGroup != null);
    }

    @Override // android.view.LayoutInflater
    public android.view.View inflate(int i, android.view.ViewGroup viewGroup, boolean z) {
        return e(i, null, viewGroup, z);
    }

    @Override // android.view.LayoutInflater
    public android.view.View inflate(org.xmlpull.v1.XmlPullParser xmlPullParser, android.view.ViewGroup viewGroup) {
        return inflate(xmlPullParser, viewGroup, viewGroup != null);
    }

    @Override // android.view.LayoutInflater
    public android.view.View inflate(org.xmlpull.v1.XmlPullParser xmlPullParser, android.view.ViewGroup viewGroup, boolean z) {
        return e(0, xmlPullParser, viewGroup, z);
    }

    @Override // android.view.LayoutInflater
    public void setFactory(android.view.LayoutInflater.Factory layoutInflater$Factory) {
        android.view.LayoutInflater layoutInflater = this.f18b;
        if (layoutInflater == null) {
            super.setFactory(layoutInflater$Factory);
        } else {
            layoutInflater.setFactory(layoutInflater$Factory);
        }
    }

    @Override // android.view.LayoutInflater
    public void setFactory2(android.view.LayoutInflater.Factory2 layoutInflater$Factory2) {
        android.view.LayoutInflater layoutInflater = this.f18b;
        if (layoutInflater == null) {
            super.setFactory2(layoutInflater$Factory2);
        } else {
            layoutInflater.setFactory2(layoutInflater$Factory2);
        }
    }

    @Override // android.view.LayoutInflater
    public void setFilter(android.view.LayoutInflater.Filter layoutInflater$Filter) {
        android.view.LayoutInflater layoutInflater = this.f18b;
        if (layoutInflater == null) {
            super.setFilter(layoutInflater$Filter);
        } else {
            layoutInflater.setFilter(layoutInflater$Filter);
        }
    }

    public java.lang.String toString() {
        android.view.LayoutInflater layoutInflater = this.f18b;
        return layoutInflater == null ? super.toString() : layoutInflater.toString();
    }
}
