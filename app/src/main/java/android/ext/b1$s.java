package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b1$s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    short f637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    short f638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f639c;

    b1$s(java.nio.ByteBuffer byteBuffer) {
        byteBuffer.position(0);
        this.f637a = byteBuffer.getShort();
        this.f638b = byteBuffer.getShort();
        this.f639c = byteBuffer.getInt();
    }
}
