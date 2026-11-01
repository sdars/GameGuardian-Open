package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class MathLib$sinh extends luaj.lib.MathLib$UnaryOp {
    MathLib$sinh() {
    }

    @Override // luaj.lib.MathLib$UnaryOp
    protected double X2(double d2) {
        return java.lang.Math.sinh(d2);
    }
}
