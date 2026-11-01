package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class EditTextMulti extends android.ext.EditText {
    public EditTextMulti(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        setInputType(getInputType() | 262144);
        setHorizontallyScrolling(false);
        setMaxLines(Integer.MAX_VALUE);
    }

    @Override // android.widget.TextView
    public void setHorizontallyScrolling(boolean z) {
        super.setHorizontallyScrolling(false);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(Integer.MAX_VALUE);
    }
}
