package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class MathLib$cosh extends luaj.lib.MathLib$UnaryOp {
    MathLib$cosh() {
    }

    @Override // luaj.lib.MathLib$UnaryOp
    protected double X2(double d2) {
        return java.lang.Math.cosh(d2);
    }
}
