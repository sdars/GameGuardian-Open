package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class b1$c0 implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<android.ext.b1$c0> CREATOR = new android.ext.b1$c0$a();
    static volatile boolean p = false;
    static volatile boolean q = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    java.lang.String f612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    java.lang.String f613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    java.lang.String f614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    java.lang.String f615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f616g;
    boolean h;
    volatile boolean i;
    volatile int j;
    java.lang.String k;
    volatile int l;
    volatile boolean m;
    java.lang.String n;
    java.lang.String o;

    b1$c0() {
        this.f610a = false;
        this.f611b = 0;
        this.f612c = null;
        this.f613d = null;
        this.f614e = null;
        this.f615f = null;
        this.f616g = 0;
        this.h = false;
        this.i = false;
        this.j = 0;
        this.k = "";
        this.l = 0;
        this.m = false;
        this.n = null;
        this.o = null;
    }

    protected b1$c0(android.os.Parcel parcel) {
        this.f610a = false;
        this.f611b = 0;
        this.f612c = null;
        this.f613d = null;
        this.f614e = null;
        this.f615f = null;
        this.f616g = 0;
        this.h = false;
        this.i = false;
        this.j = 0;
        this.k = "";
        this.l = 0;
        this.m = false;
        this.n = null;
        this.o = null;
        this.f610a = parcel.readByte() != 0;
        this.f611b = parcel.readInt();
        this.f612c = parcel.readString();
        this.f613d = parcel.readString();
        this.f614e = parcel.readString();
        this.f615f = parcel.readString();
        this.f616g = parcel.readInt();
        this.h = parcel.readByte() != 0;
        this.i = parcel.readByte() != 0;
        this.j = parcel.readInt();
        this.k = parcel.readString();
        this.l = parcel.readInt();
        this.m = parcel.readByte() != 0;
        this.n = parcel.readString();
        this.o = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeByte(this.f610a ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f611b);
        parcel.writeString(this.f612c);
        parcel.writeString(this.f613d);
        parcel.writeString(this.f614e);
        parcel.writeString(this.f615f);
        parcel.writeInt(this.f616g);
        parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeInt(this.l);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
    }
}
