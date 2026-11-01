package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class MathLib$pow extends luaj.lib.MathLib$BinaryOp {
    MathLib$pow() {
    }

    @Override // luaj.lib.MathLib$BinaryOp
    protected double X2(double d2, double d3) {
        return java.lang.Math.pow(d2, d3);
    }
}
