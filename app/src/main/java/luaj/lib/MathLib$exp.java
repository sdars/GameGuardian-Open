package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class MathLib$exp extends luaj.lib.MathLib$UnaryOp {
    MathLib$exp() {
    }

    @Override // luaj.lib.MathLib$UnaryOp
    protected double X2(double d2) {
        return java.lang.Math.exp(d2);
    }
}
