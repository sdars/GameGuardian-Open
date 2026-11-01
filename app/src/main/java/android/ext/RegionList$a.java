package android.ext;

/* JADX INFO: loaded from: classes.dex */
class RegionList$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.EditText f348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ java.util.List f350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ android.util.SparseIntArray f351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ android.ext.RegionList f352e;

    RegionList$a(android.ext.RegionList regionList, android.ext.EditText editText, boolean z, java.util.List list, android.util.SparseIntArray sparseIntArray) {
        this.f352e = regionList;
        this.f348a = editText;
        this.f349b = z;
        this.f350c = list;
        this.f351d = sparseIntArray;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        try {
            this.f348a.setText(android.ext.c.G(this.f349b ? ((android.ext.RegionList$b) this.f350c.get(this.f351d.get(i))).f357c - 1 : ((android.ext.RegionList$b) this.f350c.get(this.f351d.get(i))).f356b, 4));
            this.f348a.requestFocus();
        } catch (java.lang.Throwable th) {
            android.ext.e1.g("RegionList failed with " + i, th);
        }
        android.ext.Tools.D(dialogInterface);
    }
}
