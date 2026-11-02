package gg_d;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends android.content.ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.String[] f1518a = {"_display_name", "_size"};

    private static java.lang.Object[] a(java.lang.Object[] objArr, int i) {
        java.lang.Object[] objArr2 = new java.lang.Object[i];
        java.lang.System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }

    private static java.lang.String[] b(java.lang.String[] strArr, int i) {
        java.lang.String[] strArr2 = new java.lang.String[i];
        java.lang.System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    private static java.io.File c(android.net.Uri uri) {
        java.lang.String path = uri.getPath();
        if (path == null || !path.endsWith(".apk")) {
            return new java.io.File("/wrong_path/" + path);
        }
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return new java.io.File(path);
    }

    public static android.net.Uri d(android.content.Context context, java.lang.String str, java.io.File file) {
        return new android.net.Uri.Builder().scheme("content").authority(str).encodedPath(file.getAbsolutePath()).build();
    }

    @Override // android.content.ContentProvider
    public void attachInfo(android.content.Context context, android.content.pm.ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new java.lang.SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new java.lang.SecurityException("Provider must grant uri permissions");
        }
    }

    @Override // android.content.ContentProvider
    public int delete(android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public java.lang.String getType(android.net.Uri uri) {
        return "application/vnd.android.package-archive";
    }

    @Override // android.content.ContentProvider
    public android.net.Uri insert(android.net.Uri uri, android.content.ContentValues contentValues) {
        throw new java.lang.UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public android.os.ParcelFileDescriptor openFile(android.net.Uri uri, java.lang.String str) {try {

        return android.os.ParcelFileDescriptor.open(c(uri), 268435456);
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
    }

    @Override // android.content.ContentProvider
    public android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) {
        int i = 0;
        java.io.File fileC = c(uri);
        if (strArr == null) {
            strArr = f1518a;
        }
        java.lang.String[] strArr3 = new java.lang.String[strArr.length];
        java.lang.Object[] objArr = new java.lang.Object[strArr.length];
        int i2 = 0;
        for (java.lang.String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = fileC.getName();
            } else {
                if ("_size".equals(str3)) {
                    strArr3[i2] = "_size";
                    i = i2 + 1;
                    objArr[i2] = java.lang.Long.valueOf(fileC.length());
                }
            }
            i2 = i;
        }
        java.lang.String[] strArrB = b(strArr3, i2);
        java.lang.Object[] objArrA = a(objArr, i2);
        android.database.MatrixCursor matrixCursor = new android.database.MatrixCursor(strArrB, 1);
        matrixCursor.addRow(objArrA);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr) {
        throw new java.lang.UnsupportedOperationException("No external updates");
    }
}
