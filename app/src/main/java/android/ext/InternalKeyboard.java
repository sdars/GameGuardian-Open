package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class InternalKeyboard extends gg_a.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private java.lang.ref.WeakReference f189g;
    private boolean h;
    private int i;

    public InternalKeyboard(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f186d = true;
        this.f187e = false;
        this.f188f = 0;
        this.f189g = new java.lang.ref.WeakReference(null);
        this.h = false;
        this.i = -1;
        f(context);
    }

    public static boolean a() {
        try {
            return gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.keyboard, null) != null;
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Check internal keyboard fail", th);
            return false;
        }
    }

    private void b(android.view.Window window, boolean z) {
        int iH = 0;
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        android.view.View decorView = window.getDecorView();
        int width = decorView.getWidth();
        try {
            decorView.measure(-2, -2);
            width = java.lang.Math.max(width, decorView.getMeasuredWidth());
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
        if (z) {
            int width2 = getWidth();
            try {
                measure(-2, -2);
                iH = java.lang.Math.max(width2, getMeasuredWidth());
            } catch (java.lang.Throwable th2) {
                android.ext.e1.a(th2);
            }
        } else {
            iH = android.ext.Tools.H();
        }
        width += iH;
        attributes.width = width;
        if (width >= android.ext.MainService.context.getResources().getDisplayMetrics().widthPixels) {
            attributes.width = -1;
        }
        window.setAttributes(attributes);
    }

    private int c(boolean z, boolean z2, boolean z3, boolean z4) {
        if (!z) {
            return catch_.me_.if_.you_.can_.R.id.k_ext;
        }
        if (z2) {
            return catch_.me_.if_.you_.can_.R.id.k_hex;
        }
        if (z3) {
            return catch_.me_.if_.you_.can_.R.id.k_fn;
        }
        return z4 ? catch_.me_.if_.you_.can_.R.id.k_small : catch_.me_.if_.you_.can_.R.id.k_num;
    }

    public static android.view.View d(android.view.View view) {
        return e(view, true);
    }

    public static android.view.View e(android.view.View view, boolean z) {
        if (!a()) {
            return view;
        }
        android.ext.KeyboardLayout keyboardLayout = (android.ext.KeyboardLayout) gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.keyboard, null);
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) keyboardLayout.findViewById(view instanceof android.widget.ScrollView ? catch_.me_.if_.you_.can_.R.id.kbd_frame : catch_.me_.if_.you_.can_.R.id.kbd_scroll);
        viewGroup.addView(view);
        viewGroup.setVisibility(0);
        android.ext.InternalKeyboard internalKeyboard = (android.ext.InternalKeyboard) keyboardLayout.findViewById(catch_.me_.if_.you_.can_.R.id.keyboard);
        internalKeyboard.setAllowUseInternal(z);
        java.lang.Object tag = view.getTag();
        if (tag instanceof android.ext.InternalKeyboard$d) {
            internalKeyboard.setFlags(((android.ext.InternalKeyboard$d) tag).f195a);
        }
        keyboardLayout.c();
        return keyboardLayout;
    }

    private void f(android.content.Context context) {
        this.f184b = false;
        this.f185c = false;
        if (isInEditMode()) {
            return;
        }
        try {
            setPreviewEnabled(false);
            setOnKeyboardActionListener(new android.ext.InternalKeyboard$a(this));
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed init internal keyboard", th);
        }
    }

    private android.view.Window getWindow() {
        return (android.view.Window) this.f189g.get();
    }

    public static void i(android.view.View view, boolean z) {
        android.ext.InternalKeyboard internalKeyboard = (android.ext.InternalKeyboard) view.getRootView().findViewById(catch_.me_.if_.you_.can_.R.id.keyboard);
        if (internalKeyboard != null) {
            internalKeyboard.h(view, z);
            if (z) {
                return;
            }
            android.ext.Tools.S0(view);
        }
    }

    private void m(android.inputmethodservice.Keyboard.Key keyboard$Key) {
        if ((this.f188f & 1) != 0 && ":".equals(keyboard$Key.label)) {
            n(keyboard$Key, "?");
        }
        if ((this.f188f & 2) != 0 && ";".equals(keyboard$Key.label)) {
            n(keyboard$Key, "*");
        }
        if ((this.f188f & 4) != 0 && "~".equals(keyboard$Key.label)) {
            n(keyboard$Key, "^");
        }
        if ((this.f188f & 8) == 0 || !"r".equals(keyboard$Key.label)) {
            return;
        }
        n(keyboard$Key, "$");
    }

    private void n(android.inputmethodservice.Keyboard.Key keyboard$Key, java.lang.String str) {
        keyboard$Key.label = str;
        if (keyboard$Key.codes == null) {
            keyboard$Key.codes = new int[1];
        }
        keyboard$Key.codes[0] = str.charAt(0);
    }

    public static void o(android.view.View view, int i) {
        android.ext.Tools.z1(view, new android.ext.InternalKeyboard$c(i));
    }

    private void p() {
        this.f185c = !this.f185c;
        r();
    }

    private void q() {
        this.f184b = !this.f184b;
        r();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000b  */
    private void r() {
        boolean z = false;
        if (this.f186d) {
            z = (android.ext.Config.B & 1) != 0;
        }
        setKeyboard(z);
    }

    private void s() {
        android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_kbd_small).f42d = (android.ext.Config.B & 64) == 0 ? 1 : 0;
        android.ext.Config.k();
        r();
    }

    private void setKeyboard(boolean z) {
        boolean z2 = this.f184b;
        boolean z3 = this.f185c;
        boolean z4 = (android.ext.Config.B & 64) != 0;
        int i = this.f187e ? catch_.me_.if_.you_.can_.R.xml.empty : catch_.me_.if_.you_.can_.R.xml.keyboard;
        android.inputmethodservice.Keyboard keyboard = new android.inputmethodservice.Keyboard(android.ext.MainService.context, i, c(z, z2, z3, z4));
        if (!this.f187e) {
            if (z2 && keyboard.getKeys().size() == 0) {
                keyboard = new android.inputmethodservice.Keyboard(android.ext.MainService.context, i, c(z, false, z3, z4));
                z2 = false;
            }
            if (z3 && keyboard.getKeys().size() == 0) {
                keyboard = new android.inputmethodservice.Keyboard(android.ext.MainService.context, i, c(z, z2, false, z4));
                z3 = false;
            }
            if (z4 && keyboard.getKeys().size() == 0) {
                keyboard = new android.inputmethodservice.Keyboard(android.ext.MainService.context, i, c(z, z2, z3, false));
            }
        }
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        for (android.inputmethodservice.Keyboard.Key keyboard$Key : keyboard.getKeys()) {
            if (keyboard$Key != null) {
                int i2 = keyboard$Key.y;
                sparseIntArray.put(i2, sparseIntArray.get(i2, 0) + 1);
                if (!z3) {
                    m(keyboard$Key);
                }
                int[] iArr = keyboard$Key.codes;
                if (iArr != null && iArr.length != 0) {
                    int i3 = iArr[0];
                    if (i3 == 5002) {
                        keyboard$Key.label = android.ext.t1.f1251a;
                    }
                    if (i3 == 5003) {
                        keyboard$Key.label = java.lang.String.valueOf(android.ext.t1.f1252b);
                    }
                }
            }
        }
        android.content.res.Resources resources = getContext().getResources();
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && sparseIntArray.size() > 0) {
            layoutParams.width = java.lang.Math.round(resources.getDimension(catch_.me_.if_.you_.can_.R.dimen.key_width) * sparseIntArray.valueAt(0));
            layoutParams.height = java.lang.Math.round(resources.getDimension(catch_.me_.if_.you_.can_.R.dimen.key_height) * sparseIntArray.size());
            setLayoutParams(layoutParams);
            android.ext.e1.d("Kbd: " + sparseIntArray.valueAt(0) + " x " + sparseIntArray.size() + "; " + layoutParams.width + 'x' + layoutParams.height + "; " + keyboard.getMinWidth() + 'x' + keyboard.getHeight());
        }
        if (this.h) {
            post(new android.ext.InternalKeyboard$b(this, keyboard));
        } else {
            setKeyboard(keyboard);
        }
    }

    public void g(android.view.Window window) {
        this.f189g = new java.lang.ref.WeakReference(window);
        if (!this.f186d || (android.ext.Config.B & 1) == 0) {
            window.clearFlags(131072);
        } else {
            window.addFlags(131072);
        }
        r();
        android.view.View decorView = window.getDecorView();
        android.view.Window.Callback callback = window.getCallback();
        if ((callback instanceof android.ext.g3) && decorView.getWidth() == 0) {
            ((android.ext.g3) callback).a(this);
        } else {
            j();
        }
    }

    public int getFlags() {
        return this.f188f;
    }

    public void h(android.view.View view, boolean z) {
        if (view != null) {
            try {
                android.view.Window window = getWindow();
                if (window != null) {
                    android.ext.Tools.L(window, view, z);
                }
                if (z) {
                    setKeyboard(false);
                } else {
                    r();
                }
            } catch (java.lang.Throwable th) {
                android.ext.e1.l("Failed show/hide kbd: " + z, th);
            }
        }
    }

    public void j() {
        int i;
        android.view.Window window = getWindow();
        if (window == null || this.i == (i = android.ext.MainService.context.getResources().getConfiguration().orientation)) {
            return;
        }
        this.i = i;
        b(window, i != 1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:40:0x0077  */
    /* JADX WARN: Code duplicated, block: B:47:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0030. Please report as an issue. */
    void k(int i) {
        java.lang.String str = null;
        int i2 = 0;
        java.lang.String strValueOf;
        char c2;
        android.view.Window window = getWindow();
        if (window == null) {
            return;
        }
        android.view.View currentFocus = window.getCurrentFocus();
        if (currentFocus instanceof android.widget.EditText) {
            android.widget.EditText editText = (android.widget.EditText) currentFocus;
            int iMax = java.lang.Math.max(editText.getSelectionStart(), 0);
            int iMax2 = java.lang.Math.max(editText.getSelectionEnd(), 0);
            if (i >= 5000) {
                switch (i) {
                    case 5000:
                        i2 = 67;
                        break;
                    case 5001:
                        i2 = 112;
                        break;
                    case 5002:
                        str = android.ext.t1.f1251a;
                        break;
                    case 5003:
                        str = java.lang.String.valueOf(android.ext.t1.f1252b);
                        break;
                    case 5004:
                    case 5005:
                        boolean sendKey;
                        if (iMax != iMax2) {
                            sendKey = true;
                        } else if (iMax == 0) {
                            sendKey = i == 5005 && editText.getText().length() != 0;
                        } else {
                            sendKey = iMax != editText.getText().length() || i != 5005;
                        }
                        if (sendKey) {
                            i2 = i == 5004 ? 21 : 22;
                        }
                        break;
                    case 5006:
                        q();
                        break;
                    case 5007:
                        android.ext.y0.i(editText);
                        break;
                    case 5008:
                        android.ext.Tools.o1(editText);
                        break;
                    case 5009:
                        s();
                        break;
                    case 5010:
                        p();
                        break;
                    default:
                        break;
                }
            }
            else {
                str = java.lang.String.valueOf((char) i);
            }
            if (str != null) {
                editText.getText().replace(java.lang.Math.min(iMax, iMax2), java.lang.Math.max(iMax, iMax2), str, 0, str.length());
                editText.setSelection(java.lang.Math.max(editText.getSelectionStart(), editText.getSelectionEnd()));
            }
            if (i2 != 0) {
                try {
                    editText.dispatchKeyEvent(new android.view.KeyEvent(0, i2));
                    editText.dispatchKeyEvent(new android.view.KeyEvent(1, i2));
                } catch (java.lang.Throwable th) {
                    android.ext.e1.l("Failed send key to app", th);
                    return;
                }
            }
        }
    }

    void l(int i, int[] iArr) {
        this.h = true;
        try {
            k(i);
            this.h = false;
        } catch (java.lang.Throwable th_c_c_c) {
            this.h = false;
            throw th_c_c_c;
        }
    }

    @Override // android.view.View
    public void playSoundEffect(int i) {
        try {
            super.playSoundEffect(i);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i) {
        try {
            super.sendAccessibilityEvent(i);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    public void setAllowUseInternal(boolean z) {
        this.f186d = z;
    }

    public void setFlags(int i) {
        this.f188f = i;
    }

    public void setHideKeyboard(boolean z) {
        boolean z2 = this.f187e;
        this.f187e = z;
        if (z2 != z) {
            r();
        }
    }

    public void t() {
        r();
        j();
    }
}
