package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class MathLib$deg extends luaj.lib.MathLib$UnaryOp {
    MathLib$deg() {
    }

    @Override // luaj.lib.MathLib$UnaryOp
    protected double X2(double d2) {
        return java.lang.Math.toDegrees(d2);
    }
}
