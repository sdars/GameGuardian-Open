package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class MathLib$floor extends luaj.lib.MathLib$UnaryOp {
    MathLib$floor() {
    }

    @Override // luaj.lib.MathLib$UnaryOp
    protected double X2(double d2) {
        return java.lang.Math.floor(d2);
    }
}
