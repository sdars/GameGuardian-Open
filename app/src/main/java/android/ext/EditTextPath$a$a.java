package android.ext;

/* JADX INFO: loaded from: classes.dex */
class EditTextPath$a$a extends android.widget.Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.EditTextPath$a f120a;

    EditTextPath$a$a(android.ext.EditTextPath$a editTextPath$a) {
        this.f120a = editTextPath$a;
    }

    private java.lang.String a(java.lang.CharSequence charSequence) {
        return (charSequence == null || charSequence.length() == 0) ? "/" : charSequence.toString();
    }

    @Override // android.widget.Filter
    protected android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence charSequence) {
        java.lang.String[] strArrD;
        android.widget.Filter.FilterResults filter$FilterResults = new android.widget.Filter.FilterResults();
        if (charSequence != null) {
            java.lang.String strA = a(charSequence);
            java.io.File file = new java.io.File(strA);
            boolean zEndsWith = strA.endsWith("/");
            java.io.File parentFile = zEndsWith ? file : file.getParentFile();
            java.lang.String lowerCase = (zEndsWith ? "" : file.getName()).toLowerCase(java.util.Locale.US);
            if (parentFile.exists() && (strArrD = android.ext.PathSelector.d(parentFile)) != null && strArrD.length > 0) {
                java.util.ArrayList arrayListE = android.ext.PathSelector.e(this.f120a.f119c.f115a, parentFile, strArrD, lowerCase, true);
                int size = arrayListE.size();
                if (size == 1 && ((android.ext.PathSelector$d) arrayListE.get(0)).f336b.equals(lowerCase)) {
                    size = 0;
                }
                if (size > 0) {
                    java.io.File[] fileArr = new java.io.File[size];
                    for (int i = 0; i < size; i++) {
                        fileArr[i] = ((android.ext.PathSelector$d) arrayListE.get(i)).f335a;
                    }
                    filter$FilterResults.values = fileArr;
                    filter$FilterResults.count = size;
                }
            }
        }
        return filter$FilterResults;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x000e  */
    @Override // android.widget.Filter
    protected void publishResults(java.lang.CharSequence charSequence, android.widget.Filter.FilterResults filter$FilterResults) {
        java.io.File[] fileArr;
        android.ext.EditTextPath$a editTextPath$a = this.f120a;
        if (filter$FilterResults != null) {
            java.lang.Object obj = filter$FilterResults.values;
            if (obj instanceof java.io.File[]) {
                fileArr = (java.io.File[]) obj;
            } else {
                fileArr = null;
            }
        } else {
            fileArr = null;
        }
        editTextPath$a.f118b = fileArr;
        this.f120a.notifyDataSetChanged();
    }
}
