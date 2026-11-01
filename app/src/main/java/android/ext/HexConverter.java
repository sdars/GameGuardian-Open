package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class HexConverter extends android.fix.ImageButtonView implements android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f146a;

    public HexConverter(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f146a = true;
        a();
    }

    private void a() {
        setOnClickListener(this);
        if (isInEditMode()) {
            return;
        }
        setImageResource(catch_.me_.if_.you_.can_.R.drawable.ic_arrow_down_drop_circle_white_24dp);
        android.ext.Config.m(this);
    }

    private java.lang.String b(java.lang.String str, char c2, boolean z) {
        int length = str.length();
        int i = 0;
        if (z) {
            int i2 = 0;
            while (i < length - 2 && str.charAt(i) == c2) {
                i++;
                i2 = i & (-2);
            }
            i = i2;
        } else {
            for (int i3 = length - 1; i3 >= 2 && str.charAt(i3) == c2; i3--) {
                length = (i3 + 1) & (-2);
            }
        }
        return str.substring(i, length);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0314  */
    /* JADX WARN: Code duplicated, block: B:104:0x0318  */
    /* JADX WARN: Code duplicated, block: B:119:0x0335 A[Catch: all -> 0x019c, TryCatch #4 {all -> 0x019c, blocks: (B:64:0x018e, B:66:0x0196, B:69:0x01a0, B:70:0x01a6, B:72:0x01ae, B:74:0x021d, B:77:0x0259, B:89:0x02e3, B:82:0x0297, B:90:0x02f5, B:92:0x02fe, B:105:0x031a, B:146:0x03ed, B:110:0x0326, B:115:0x032e, B:119:0x0335, B:123:0x0345, B:126:0x034c, B:130:0x036c, B:132:0x0379, B:134:0x0384, B:137:0x038c, B:140:0x03a5, B:143:0x03bb, B:144:0x03ce, B:147:0x03f1, B:95:0x0304, B:98:0x030e, B:86:0x02af, B:79:0x0263), top: B:159:0x018e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x033e  */
    /* JADX WARN: Code duplicated, block: B:123:0x0345 A[Catch: all -> 0x019c, TryCatch #4 {all -> 0x019c, blocks: (B:64:0x018e, B:66:0x0196, B:69:0x01a0, B:70:0x01a6, B:72:0x01ae, B:74:0x021d, B:77:0x0259, B:89:0x02e3, B:82:0x0297, B:90:0x02f5, B:92:0x02fe, B:105:0x031a, B:146:0x03ed, B:110:0x0326, B:115:0x032e, B:119:0x0335, B:123:0x0345, B:126:0x034c, B:130:0x036c, B:132:0x0379, B:134:0x0384, B:137:0x038c, B:140:0x03a5, B:143:0x03bb, B:144:0x03ce, B:147:0x03f1, B:95:0x0304, B:98:0x030e, B:86:0x02af, B:79:0x0263), top: B:159:0x018e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x034c A[Catch: all -> 0x019c, TryCatch #4 {all -> 0x019c, blocks: (B:64:0x018e, B:66:0x0196, B:69:0x01a0, B:70:0x01a6, B:72:0x01ae, B:74:0x021d, B:77:0x0259, B:89:0x02e3, B:82:0x0297, B:90:0x02f5, B:92:0x02fe, B:105:0x031a, B:146:0x03ed, B:110:0x0326, B:115:0x032e, B:119:0x0335, B:123:0x0345, B:126:0x034c, B:130:0x036c, B:132:0x0379, B:134:0x0384, B:137:0x038c, B:140:0x03a5, B:143:0x03bb, B:144:0x03ce, B:147:0x03f1, B:95:0x0304, B:98:0x030e, B:86:0x02af, B:79:0x0263), top: B:159:0x018e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x0363  */
    /* JADX WARN: Code duplicated, block: B:129:0x0369  */
    /* JADX WARN: Code duplicated, block: B:130:0x036c A[Catch: all -> 0x019c, TryCatch #4 {all -> 0x019c, blocks: (B:64:0x018e, B:66:0x0196, B:69:0x01a0, B:70:0x01a6, B:72:0x01ae, B:74:0x021d, B:77:0x0259, B:89:0x02e3, B:82:0x0297, B:90:0x02f5, B:92:0x02fe, B:105:0x031a, B:146:0x03ed, B:110:0x0326, B:115:0x032e, B:119:0x0335, B:123:0x0345, B:126:0x034c, B:130:0x036c, B:132:0x0379, B:134:0x0384, B:137:0x038c, B:140:0x03a5, B:143:0x03bb, B:144:0x03ce, B:147:0x03f1, B:95:0x0304, B:98:0x030e, B:86:0x02af, B:79:0x0263), top: B:159:0x018e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x0379 A[Catch: all -> 0x019c, TryCatch #4 {all -> 0x019c, blocks: (B:64:0x018e, B:66:0x0196, B:69:0x01a0, B:70:0x01a6, B:72:0x01ae, B:74:0x021d, B:77:0x0259, B:89:0x02e3, B:82:0x0297, B:90:0x02f5, B:92:0x02fe, B:105:0x031a, B:146:0x03ed, B:110:0x0326, B:115:0x032e, B:119:0x0335, B:123:0x0345, B:126:0x034c, B:130:0x036c, B:132:0x0379, B:134:0x0384, B:137:0x038c, B:140:0x03a5, B:143:0x03bb, B:144:0x03ce, B:147:0x03f1, B:95:0x0304, B:98:0x030e, B:86:0x02af, B:79:0x0263), top: B:159:0x018e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0383  */
    /* JADX WARN: Code duplicated, block: B:136:0x038a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:137:0x038c A[Catch: all -> 0x019c, TryCatch #4 {all -> 0x019c, blocks: (B:64:0x018e, B:66:0x0196, B:69:0x01a0, B:70:0x01a6, B:72:0x01ae, B:74:0x021d, B:77:0x0259, B:89:0x02e3, B:82:0x0297, B:90:0x02f5, B:92:0x02fe, B:105:0x031a, B:146:0x03ed, B:110:0x0326, B:115:0x032e, B:119:0x0335, B:123:0x0345, B:126:0x034c, B:130:0x036c, B:132:0x0379, B:134:0x0384, B:137:0x038c, B:140:0x03a5, B:143:0x03bb, B:144:0x03ce, B:147:0x03f1, B:95:0x0304, B:98:0x030e, B:86:0x02af, B:79:0x0263), top: B:159:0x018e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:140:0x03a5 A[Catch: all -> 0x019c, TryCatch #4 {all -> 0x019c, blocks: (B:64:0x018e, B:66:0x0196, B:69:0x01a0, B:70:0x01a6, B:72:0x01ae, B:74:0x021d, B:77:0x0259, B:89:0x02e3, B:82:0x0297, B:90:0x02f5, B:92:0x02fe, B:105:0x031a, B:146:0x03ed, B:110:0x0326, B:115:0x032e, B:119:0x0335, B:123:0x0345, B:126:0x034c, B:130:0x036c, B:132:0x0379, B:134:0x0384, B:137:0x038c, B:140:0x03a5, B:143:0x03bb, B:144:0x03ce, B:147:0x03f1, B:95:0x0304, B:98:0x030e, B:86:0x02af, B:79:0x0263), top: B:159:0x018e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x03bb A[Catch: all -> 0x019c, TryCatch #4 {all -> 0x019c, blocks: (B:64:0x018e, B:66:0x0196, B:69:0x01a0, B:70:0x01a6, B:72:0x01ae, B:74:0x021d, B:77:0x0259, B:89:0x02e3, B:82:0x0297, B:90:0x02f5, B:92:0x02fe, B:105:0x031a, B:146:0x03ed, B:110:0x0326, B:115:0x032e, B:119:0x0335, B:123:0x0345, B:126:0x034c, B:130:0x036c, B:132:0x0379, B:134:0x0384, B:137:0x038c, B:140:0x03a5, B:143:0x03bb, B:144:0x03ce, B:147:0x03f1, B:95:0x0304, B:98:0x030e, B:86:0x02af, B:79:0x0263), top: B:159:0x018e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:157:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x018e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x01a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x0043  */
    /* JADX WARN: Code duplicated, block: B:22:0x0047  */
    /* JADX WARN: Code duplicated, block: B:23:0x004c  */
    /* JADX WARN: Code duplicated, block: B:25:0x004f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    /* JADX WARN: Code duplicated, block: B:34:0x006b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d7 A[Catch: all -> 0x0108, TryCatch #3 {all -> 0x0108, blocks: (B:44:0x00cc, B:46:0x00d7, B:48:0x00df, B:49:0x0102, B:55:0x010f, B:57:0x0117, B:58:0x013b, B:61:0x0165), top: B:157:0x00cc }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00df A[Catch: all -> 0x0108, TryCatch #3 {all -> 0x0108, blocks: (B:44:0x00cc, B:46:0x00d7, B:48:0x00df, B:49:0x0102, B:55:0x010f, B:57:0x0117, B:58:0x013b, B:61:0x0165), top: B:157:0x00cc }] */
    /* JADX WARN: Code duplicated, block: B:53:0x010b  */
    /* JADX WARN: Code duplicated, block: B:55:0x010f A[Catch: all -> 0x0108, TryCatch #3 {all -> 0x0108, blocks: (B:44:0x00cc, B:46:0x00d7, B:48:0x00df, B:49:0x0102, B:55:0x010f, B:57:0x0117, B:58:0x013b, B:61:0x0165), top: B:157:0x00cc }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0117 A[Catch: all -> 0x0108, TryCatch #3 {all -> 0x0108, blocks: (B:44:0x00cc, B:46:0x00d7, B:48:0x00df, B:49:0x0102, B:55:0x010f, B:57:0x0117, B:58:0x013b, B:61:0x0165), top: B:157:0x00cc }] */
    /* JADX WARN: Code duplicated, block: B:58:0x013b A[Catch: all -> 0x0108, TryCatch #3 {all -> 0x0108, blocks: (B:44:0x00cc, B:46:0x00d7, B:48:0x00df, B:49:0x0102, B:55:0x010f, B:57:0x0117, B:58:0x013b, B:61:0x0165), top: B:157:0x00cc }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0165 A[Catch: all -> 0x0108, TRY_LEAVE, TryCatch #3 {all -> 0x0108, blocks: (B:44:0x00cc, B:46:0x00d7, B:48:0x00df, B:49:0x0102, B:55:0x010f, B:57:0x0117, B:58:0x013b, B:61:0x0165), top: B:157:0x00cc }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0196 A[Catch: all -> 0x019c, TryCatch #4 {all -> 0x019c, blocks: (B:64:0x018e, B:66:0x0196, B:69:0x01a0, B:70:0x01a6, B:72:0x01ae, B:74:0x021d, B:77:0x0259, B:89:0x02e3, B:82:0x0297, B:90:0x02f5, B:92:0x02fe, B:105:0x031a, B:146:0x03ed, B:110:0x0326, B:115:0x032e, B:119:0x0335, B:123:0x0345, B:126:0x034c, B:130:0x036c, B:132:0x0379, B:134:0x0384, B:137:0x038c, B:140:0x03a5, B:143:0x03bb, B:144:0x03ce, B:147:0x03f1, B:95:0x0304, B:98:0x030e, B:86:0x02af, B:79:0x0263), top: B:159:0x018e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:74:0x021d A[Catch: all -> 0x019c, TryCatch #4 {all -> 0x019c, blocks: (B:64:0x018e, B:66:0x0196, B:69:0x01a0, B:70:0x01a6, B:72:0x01ae, B:74:0x021d, B:77:0x0259, B:89:0x02e3, B:82:0x0297, B:90:0x02f5, B:92:0x02fe, B:105:0x031a, B:146:0x03ed, B:110:0x0326, B:115:0x032e, B:119:0x0335, B:123:0x0345, B:126:0x034c, B:130:0x036c, B:132:0x0379, B:134:0x0384, B:137:0x038c, B:140:0x03a5, B:143:0x03bb, B:144:0x03ce, B:147:0x03f1, B:95:0x0304, B:98:0x030e, B:86:0x02af, B:79:0x0263), top: B:159:0x018e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:92:0x02fe A[Catch: all -> 0x019c, TryCatch #4 {all -> 0x019c, blocks: (B:64:0x018e, B:66:0x0196, B:69:0x01a0, B:70:0x01a6, B:72:0x01ae, B:74:0x021d, B:77:0x0259, B:89:0x02e3, B:82:0x0297, B:90:0x02f5, B:92:0x02fe, B:105:0x031a, B:146:0x03ed, B:110:0x0326, B:115:0x032e, B:119:0x0335, B:123:0x0345, B:126:0x034c, B:130:0x036c, B:132:0x0379, B:134:0x0384, B:137:0x038c, B:140:0x03a5, B:143:0x03bb, B:144:0x03ce, B:147:0x03f1, B:95:0x0304, B:98:0x030e, B:86:0x02af, B:79:0x0263), top: B:159:0x018e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0301  */
    /* JADX WARN: Code duplicated, block: B:95:0x0304 A[Catch: all -> 0x019c, TryCatch #4 {all -> 0x019c, blocks: (B:64:0x018e, B:66:0x0196, B:69:0x01a0, B:70:0x01a6, B:72:0x01ae, B:74:0x021d, B:77:0x0259, B:89:0x02e3, B:82:0x0297, B:90:0x02f5, B:92:0x02fe, B:105:0x031a, B:146:0x03ed, B:110:0x0326, B:115:0x032e, B:119:0x0335, B:123:0x0345, B:126:0x034c, B:130:0x036c, B:132:0x0379, B:134:0x0384, B:137:0x038c, B:140:0x03a5, B:143:0x03bb, B:144:0x03ce, B:147:0x03f1, B:95:0x0304, B:98:0x030e, B:86:0x02af, B:79:0x0263), top: B:159:0x018e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x030b  */
    /* JADX WARN: Code duplicated, block: B:98:0x030e A[Catch: all -> 0x019c, TryCatch #4 {all -> 0x019c, blocks: (B:64:0x018e, B:66:0x0196, B:69:0x01a0, B:70:0x01a6, B:72:0x01ae, B:74:0x021d, B:77:0x0259, B:89:0x02e3, B:82:0x0297, B:90:0x02f5, B:92:0x02fe, B:105:0x031a, B:146:0x03ed, B:110:0x0326, B:115:0x032e, B:119:0x0335, B:123:0x0345, B:126:0x034c, B:130:0x036c, B:132:0x0379, B:134:0x0384, B:137:0x038c, B:140:0x03a5, B:143:0x03bb, B:144:0x03ce, B:147:0x03f1, B:95:0x0304, B:98:0x030e, B:86:0x02af, B:79:0x0263), top: B:159:0x018e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0311  */
    /* JADX WARN: Instruction removed from duplicated block: B:137:0x038c, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:140:0x03a5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:143:0x03bb, please report this as an issue */
    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
/* gg-shared-throwable */ java.lang.Throwable th = null;
        android.ext.EditText editText;
        int selected = 0;
        int i;
        android.text.Editable text;
        int selectionStart;
        int selectionEnd;
        boolean z;
        int length;
        int i2;
        java.lang.String string;
        boolean z2;
        int i3;
        java.lang.String strSubstring;
        int length2;
        long j;
        java.util.ArrayList arrayList;
        java.util.ArrayList arrayList2;
        int iH;
        int i4;
        int i5 = 0;
        android.ext.n nVar;
        long j2;
        java.lang.String string2;
        java.lang.String strTrim;
        int iIndexOf;
        int i6;
        java.lang.String str;
        byte[] bArrG = null;
        int i7 = 0;
        int i8 = 0;
        char[] cArr;
        int i9;
        int iIndexOf2;
        char cCharAt;
        java.lang.StringBuilder sb = null;
        java.lang.Object tag = getTag();
        if (tag instanceof android.ext.EditText) {
            editText = (android.ext.EditText) tag;
        } else {
            if (tag instanceof java.lang.Object[]) {
                java.lang.Object[] objArr = (java.lang.Object[]) tag;
                if (objArr.length == 2) {
                    java.lang.Object obj = objArr[0];
                    if (obj instanceof android.ext.EditText) {
                        android.ext.EditText editText2 = (android.ext.EditText) obj;
                        java.lang.Object obj2 = objArr[1];
                        if (obj2 instanceof java.lang.Integer) {
                            selected = ((java.lang.Integer) obj2).intValue();
                        } else if (obj2 instanceof android.ext.SystemSpinnerType) {
                            selected = ((android.ext.SystemSpinnerType) obj2).getSelected();
                        } else {
                            editText = editText2;
                        }
                        editText = editText2;
                    } else {
                        editText = null;
                    }
                } else {
                    editText = null;
                }
            } else {
                editText = null;
            }
            if (selected == 0) {
                i = 32;
            } else {
                i = selected;
            }
            if (editText == null) {
                return;
            }
            editText.requestFocus();
            text = editText.getText();
            selectionStart = editText.getSelectionStart();
            selectionEnd = editText.getSelectionEnd();
            if (selectionStart >= 0 || selectionEnd < 0 || selectionStart == selectionEnd) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                length = text.length();
                i2 = 0;
            } else {
                length = selectionEnd;
                i2 = selectionStart;
            }
            try {
                int i10 = i2;
                string = text.subSequence(i2, length).toString().trim();
                z2 = z;
                i3 = i10;
            } catch (java.lang.StringIndexOutOfBoundsException e2) {
                android.ext.e1.s("subSequence fail for " + i2 + ", " + length + "; " + text.length(), e2);
                length = text.length();
                string = text.toString();
                z2 = true;
                i3 = 0;
            }
            if (string.length() == 0) {
                android.ext.Tools.J1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.empty_field));
                return;
            }
            try {
                android.ext.EditText editText3 = editText;
                if (android.ext.t1.C(string) != 0) {
                    cCharAt = string.charAt(1);
                    if (cCharAt == 'T') {
                        java.lang.String strTrim2 = string.substring(2).trim();
                        sb = new java.lang.StringBuilder();
                        sb.append(java.lang.Integer.toHexString(android.ext.n.p(null, 0L, strTrim2)).toUpperCase(java.util.Locale.US));
                        sb.append('h');
                    } else {
                        if (cCharAt == 'A') {
                            if (string.charAt(2) == '8') {
                                java.lang.String strTrim3 = string.substring(3).trim();
                                sb = new java.lang.StringBuilder();
                                sb.append(java.lang.Integer.toHexString(android.ext.m.k(null, null, 0L, strTrim3)).toUpperCase(java.util.Locale.US));
                                sb.append('h');
                            } else {
                                java.lang.String strTrim4 = string.substring(2).trim();
                                sb = new java.lang.StringBuilder();
                                sb.append(java.lang.Integer.toHexString(android.ext.n.n(null, 0L, strTrim4)).toUpperCase(java.util.Locale.US));
                                sb.append('h');
                            }
                        }
                        z2 = false;
                    }
                    string = sb.toString();
                    z2 = false;
                }
                if (z2) {
                    cArr = new char[]{android.ext.t1.f1252b, ':', ';', '~', 'X', 'W', 'Q'};
                    strSubstring = string;
                    i9 = 0;
                    for (i8 = 7; i9 < i8; i8 = 7) {
                        try {
                            iIndexOf2 = strSubstring.indexOf(cArr[i9]);
                            if (iIndexOf2 > 0) {
                                strSubstring = strSubstring.substring(0, iIndexOf2);
                            }
                            i9++;
                        } catch (java.lang.Throwable th_c) {
                            th = th_c;
                            string = strSubstring;
                            android.ext.Tools.J1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.need_integer) + "\n\n" + th_c.getMessage());
                            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                            sb2.append("HexConverter: ");
                            sb2.append(string);
                            android.ext.e1.g(sb2.toString(), th_c);
                            return;
                        }
                    }
                    length2 = strSubstring.length();
                } else {
                    strSubstring = string;
                    length2 = length;
                }
                j = android.ext.t1.x(strSubstring).f1261a;
                arrayList = new java.util.ArrayList();
                arrayList2 = new java.util.ArrayList();
                java.lang.String strL1 = android.ext.Tools.L1("%,d", java.lang.Long.valueOf(j));
                arrayList.add(strL1);
                arrayList2.add(strL1);
                java.lang.String str2 = b(android.ext.c.M(0L, j, i), '0', true) + 'h';
                arrayList.add(str2);
                arrayList2.add(str2);
                java.lang.String str3 = b(android.ext.c.P(0L, j, i), '0', false) + 'r';
                arrayList.add(str3);
                arrayList2.add(str3);
                if (this.f146a) {
                    java.lang.String strL2 = android.ext.Tools.L1("%,d", java.lang.Long.valueOf(android.ext.Config.s ^ j));
                    arrayList.add(android.ext.Tools.L1("XOR %,d = %s", java.lang.Long.valueOf(android.ext.Config.s), strL2));
                    arrayList2.add(strL2);
                    arrayList.add("XOR ... = ???");
                    arrayList2.add(null);
                }
                if (j != 0 && (i7 = (bArrG = android.ext.t1.g(j))[8]) != -1) {
                    try {
                        java.lang.String str4 = ':' + new java.lang.String(bArrG, 0, i7 + 1, "UTF-8");
                        arrayList.add("UTF-8: " + str4);
                        arrayList2.add(str4);
                    } catch (java.lang.Throwable th2) {
                        android.ext.e1.g("HexConverter: " + strSubstring, th2);
                    }
                    if ((i7 & 1) == 0) {
                        i7++;
                    }
                    try {
                        java.lang.String str5 = ';' + new java.lang.String(bArrG, 0, i7 + 1, "UTF-16LE");
                        arrayList.add("UTF-16LE: " + str5);
                        arrayList2.add(str5);
                    } catch (java.lang.Throwable th3) {
                        android.ext.e1.g("HexConverter: " + strSubstring, th3);
                    }
                }
                iH = android.ext.MainService.instance.H();
                if (iH == 1) {
                    i4 = android.ext.AddressArrayAdapter.f23d;
                } else if (iH == 3) {
                    i4 = android.ext.MainService.instance.N.j;
                } else if (iH == 2) {
                    i4 = android.ext.SavedListAdapter.f360c;
                } else {
                    i4 = 0;
                }
                if (i4 != 0) {
                    for (i5 = 0; i5 < 3; i5++) {
                        if ((i5 == 0 || (i4 & 16) != 0) && ((i5 != 1 || (i4 & 32) != 0) && (i5 != 2 || (i4 & 64) != 0))) {
                            if (i5 == 0) {
                                nVar = null;
                                j2 = 0;
                                string2 = android.ext.n.o(null, 0L, j);
                            } else {
                                nVar = null;
                                j2 = 0;
                                string2 = null;
                            }
                            if (i5 == 1) {
                                string2 = android.ext.n.q(nVar, j2, j);
                            }
                            if (i5 == 2) {
                                string2 = android.ext.m.g(android.ext.m.d(), 0L, (int) j, new java.lang.StringBuilder()).toString();
                            }
                            if (string2 == null) {
                                arrayList = arrayList;
                            } else {
                                strTrim = string2.trim();
                                iIndexOf = strTrim.indexOf(59);
                                if (iIndexOf != -1) {
                                    strTrim = strTrim.substring(0, iIndexOf).trim();
                                }
                                if (strTrim.length() > 0) {
                                    if (i5 == 0) {
                                        str = "ARM (x32)";
                                        strTrim = "~A " + strTrim;
                                        i6 = 1;
                                    } else {
                                        i6 = 1;
                                        str = null;
                                    }
                                    if (i5 == i6) {
                                        str = "Thumb";
                                        strTrim = "~T " + strTrim;
                                    }
                                    if (i5 == 2) {
                                        str = "ARM (x64)";
                                        strTrim = "~A8 " + strTrim;
                                    }
                                    arrayList = arrayList;
                                    arrayList.add(str + ": " + strTrim);
                                    arrayList2.add(strTrim);
                                } else {
                                    arrayList = arrayList;
                                }
                            }
                        }
                    }
                }
                java.util.ArrayList arrayList3 = arrayList;
                android.ext.HexConverter$a hexConverter$a = new android.ext.HexConverter$a(this, arrayList2, j, editText3, i3, length2, text);
                android.ext.f.m(android.ext.f.b().setCustomTitle(android.ext.Tools.h0(strSubstring + " →")).setItems((java.lang.CharSequence[]) arrayList3.toArray(new java.lang.String[arrayList3.size()]), hexConverter$a).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), hexConverter$a).create());
            } catch (java.lang.Throwable th4) {
                th = th4;
            }
        }
        selected = 0;
        if (selected == 0) {
            i = 32;
        } else {
            i = selected;
        }
        if (editText == null) {
            return;
        }
        editText.requestFocus();
        text = editText.getText();
        selectionStart = editText.getSelectionStart();
        selectionEnd = editText.getSelectionEnd();
        if (selectionStart >= 0) {
            z = true;
        } else {
            z = true;
        }
        if (z) {
            length = text.length();
            i2 = 0;
        } else {
            length = selectionEnd;
            i2 = selectionStart;
        }
        int i11 = i2;
        string = text.subSequence(i2, length).toString().trim();
        z2 = z;
        i3 = i11;
        if (string.length() == 0) {
            android.ext.Tools.J1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.empty_field));
            return;
        }
        android.ext.EditText editText4 = editText;
        if (android.ext.t1.C(string) != 0) {
            cCharAt = string.charAt(1);
            if (cCharAt == 'T') {
                java.lang.String strTrim5 = string.substring(2).trim();
                sb = new java.lang.StringBuilder();
                sb.append(java.lang.Integer.toHexString(android.ext.n.p(null, 0L, strTrim5)).toUpperCase(java.util.Locale.US));
                sb.append('h');
            } else {
                if (cCharAt == 'A') {
                    if (string.charAt(2) == '8') {
                        java.lang.String strTrim6 = string.substring(3).trim();
                        sb = new java.lang.StringBuilder();
                        sb.append(java.lang.Integer.toHexString(android.ext.m.k(null, null, 0L, strTrim6)).toUpperCase(java.util.Locale.US));
                        sb.append('h');
                    } else {
                        java.lang.String strTrim7 = string.substring(2).trim();
                        sb = new java.lang.StringBuilder();
                        sb.append(java.lang.Integer.toHexString(android.ext.n.n(null, 0L, strTrim7)).toUpperCase(java.util.Locale.US));
                        sb.append('h');
                    }
                }
                z2 = false;
            }
            string = sb.toString();
            z2 = false;
        }
        if (z2) {
            cArr = new char[]{android.ext.t1.f1252b, ':', ';', '~', 'X', 'W', 'Q'};
            strSubstring = string;
            i9 = 0;
            while (i9 < i8) {
                iIndexOf2 = strSubstring.indexOf(cArr[i9]);
                if (iIndexOf2 > 0) {
                    strSubstring = strSubstring.substring(0, iIndexOf2);
                }
                i9++;
            }
            length2 = strSubstring.length();
        } else {
            strSubstring = string;
            length2 = length;
        }
        j = android.ext.t1.x(strSubstring).f1261a;
        arrayList = new java.util.ArrayList();
        arrayList2 = new java.util.ArrayList();
        java.lang.String strL3 = android.ext.Tools.L1("%,d", java.lang.Long.valueOf(j));
        arrayList.add(strL3);
        arrayList2.add(strL3);
        java.lang.String str6 = b(android.ext.c.M(0L, j, i), '0', true) + 'h';
        arrayList.add(str6);
        arrayList2.add(str6);
        java.lang.String str7 = b(android.ext.c.P(0L, j, i), '0', false) + 'r';
        arrayList.add(str7);
        arrayList2.add(str7);
        if (this.f146a) {
            java.lang.String strL4 = android.ext.Tools.L1("%,d", java.lang.Long.valueOf(android.ext.Config.s ^ j));
            arrayList.add(android.ext.Tools.L1("XOR %,d = %s", java.lang.Long.valueOf(android.ext.Config.s), strL4));
            arrayList2.add(strL4);
            arrayList.add("XOR ... = ???");
            arrayList2.add(null);
        }
        if (j != 0) {
            java.lang.String str8;
            try {
                str8 = ':' + new java.lang.String(bArrG, 0, i7 + 1, "UTF-8");
            } catch (java.lang.RuntimeException ggEx) {
                throw ggEx;
            } catch (java.lang.Throwable ggEx2) {
                throw new java.lang.RuntimeException(ggEx2);
            }
            arrayList.add("UTF-8: " + str8);
            arrayList2.add(str8);
            if ((i7 & 1) == 0) {
                i7++;
            }java.lang.String str9;
            try {
            str9 = ';' + new java.lang.String(bArrG, 0, i7 + 1, "UTF-16LE");;
            } catch (java.lang.RuntimeException ggEx) {
                throw ggEx;
            } catch (java.lang.Throwable ggEx2) {
                throw new java.lang.RuntimeException(ggEx2);
            }
            arrayList.add("UTF-16LE: " + str9);
            arrayList2.add(str9);
        }
        iH = android.ext.MainService.instance.H();
        if (iH == 1) {
            i4 = android.ext.AddressArrayAdapter.f23d;
        } else if (iH == 3) {
            i4 = android.ext.MainService.instance.N.j;
        } else if (iH == 2) {
            i4 = android.ext.SavedListAdapter.f360c;
        } else {
            i4 = 0;
        }
        if (i4 != 0) {
            while (i5 < 3) {
                if (i5 == 0) {
                    if (i5 == 0) {
                        nVar = null;
                        j2 = 0;
                        string2 = android.ext.n.o(null, 0L, j);
                    } else {
                        nVar = null;
                        j2 = 0;
                        string2 = null;
                    }
                    if (i5 == 1) {
                        string2 = android.ext.n.q(nVar, j2, j);
                    }
                    if (i5 == 2) {
                        string2 = android.ext.m.g(android.ext.m.d(), 0L, (int) j, new java.lang.StringBuilder()).toString();
                    }
                    if (string2 == null) {
                        arrayList = arrayList;
                    } else {
                        strTrim = string2.trim();
                        iIndexOf = strTrim.indexOf(59);
                        if (iIndexOf != -1) {
                            strTrim = strTrim.substring(0, iIndexOf).trim();
                        }
                        if (strTrim.length() > 0) {
                            if (i5 == 0) {
                                str = "ARM (x32)";
                                strTrim = "~A " + strTrim;
                                i6 = 1;
                            } else {
                                i6 = 1;
                                str = null;
                            }
                            if (i5 == i6) {
                                str = "Thumb";
                                strTrim = "~T " + strTrim;
                            }
                            if (i5 == 2) {
                                str = "ARM (x64)";
                                strTrim = "~A8 " + strTrim;
                            }
                            arrayList = arrayList;
                            arrayList.add(str + ": " + strTrim);
                            arrayList2.add(strTrim);
                        } else {
                            arrayList = arrayList;
                        }
                    }
                } else {
                    if (i5 == 0) {
                        nVar = null;
                        j2 = 0;
                        string2 = android.ext.n.o(null, 0L, j);
                    } else {
                        nVar = null;
                        j2 = 0;
                        string2 = null;
                    }
                    if (i5 == 1) {
                        string2 = android.ext.n.q(nVar, j2, j);
                    }
                    if (i5 == 2) {
                        string2 = android.ext.m.g(android.ext.m.d(), 0L, (int) j, new java.lang.StringBuilder()).toString();
                    }
                    if (string2 == null) {
                        arrayList = arrayList;
                    } else {
                        strTrim = string2.trim();
                        iIndexOf = strTrim.indexOf(59);
                        if (iIndexOf != -1) {
                            strTrim = strTrim.substring(0, iIndexOf).trim();
                        }
                        if (strTrim.length() > 0) {
                            if (i5 == 0) {
                                str = "ARM (x32)";
                                strTrim = "~A " + strTrim;
                                i6 = 1;
                            } else {
                                i6 = 1;
                                str = null;
                            }
                            if (i5 == i6) {
                                str = "Thumb";
                                strTrim = "~T " + strTrim;
                            }
                            if (i5 == 2) {
                                str = "ARM (x64)";
                                strTrim = "~A8 " + strTrim;
                            }
                            arrayList = arrayList;
                            arrayList.add(str + ": " + strTrim);
                            arrayList2.add(strTrim);
                        } else {
                            arrayList = arrayList;
                        }
                    }
                }
            }
        }
        java.util.ArrayList arrayList4 = arrayList;
        android.ext.HexConverter$a hexConverter$a2 = new android.ext.HexConverter$a(this, arrayList2, j, editText4, i3, length2, text);
        android.ext.f.m(android.ext.f.b().setCustomTitle(android.ext.Tools.h0(strSubstring + " →")).setItems((java.lang.CharSequence[]) arrayList4.toArray(new java.lang.String[arrayList4.size()]), hexConverter$a2).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), hexConverter$a2).create());
    }

    public void setUseXor(boolean z) {
        this.f146a = z;
    }
}
