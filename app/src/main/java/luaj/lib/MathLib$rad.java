package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class MathLib$rad extends luaj.lib.MathLib$UnaryOp {
    MathLib$rad() {
    }

    @Override // luaj.lib.MathLib$UnaryOp
    protected double X2(double d2) {
        return java.lang.Math.toRadians(d2);
    }
}
