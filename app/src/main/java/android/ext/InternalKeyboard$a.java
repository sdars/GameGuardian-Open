package android.ext;

/* JADX INFO: loaded from: classes.dex */
class InternalKeyboard$a implements android.inputmethodservice.KeyboardView.OnKeyboardActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.InternalKeyboard f190a;

    InternalKeyboard$a(android.ext.InternalKeyboard internalKeyboard) {
        this.f190a = internalKeyboard;
    }

    @Override // android.inputmethodservice.KeyboardView$OnKeyboardActionListener
    public void onKey(int i, int[] iArr) {
        this.f190a.l(i, iArr);
    }

    @Override // android.inputmethodservice.KeyboardView$OnKeyboardActionListener
    public void onPress(int i) {
    }

    @Override // android.inputmethodservice.KeyboardView$OnKeyboardActionListener
    public void onRelease(int i) {
    }

    @Override // android.inputmethodservice.KeyboardView$OnKeyboardActionListener
    public void onText(java.lang.CharSequence charSequence) {
    }

    @Override // android.inputmethodservice.KeyboardView$OnKeyboardActionListener
    public void swipeDown() {
    }

    @Override // android.inputmethodservice.KeyboardView$OnKeyboardActionListener
    public void swipeLeft() {
    }

    @Override // android.inputmethodservice.KeyboardView$OnKeyboardActionListener
    public void swipeRight() {
    }

    @Override // android.inputmethodservice.KeyboardView$OnKeyboardActionListener
    public void swipeUp() {
    }
}
