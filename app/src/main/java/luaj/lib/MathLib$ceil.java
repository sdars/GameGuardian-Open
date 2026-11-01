package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class MathLib$ceil extends luaj.lib.MathLib$UnaryOp {
    MathLib$ceil() {
    }

    @Override // luaj.lib.MathLib$UnaryOp
    protected double X2(double d2) {
        return java.lang.Math.ceil(d2);
    }
}
