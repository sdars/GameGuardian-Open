package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class MathLib$sin extends luaj.lib.MathLib$UnaryOp {
    MathLib$sin() {
    }

    @Override // luaj.lib.MathLib$UnaryOp
    protected double X2(double d2) {
        return java.lang.Math.sin(d2);
    }
}
