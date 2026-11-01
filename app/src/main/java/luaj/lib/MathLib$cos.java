package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class MathLib$cos extends luaj.lib.MathLib$UnaryOp {
    MathLib$cos() {
    }

    @Override // luaj.lib.MathLib$UnaryOp
    protected double X2(double d2) {
        return java.lang.Math.cos(d2);
    }
}
