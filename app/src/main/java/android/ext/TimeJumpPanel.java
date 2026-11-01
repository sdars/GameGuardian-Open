package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class TimeJumpPanel extends android.ext.FloatPanel implements android.view.View.OnClickListener {
    android.widget.Button p;
    android.widget.Button q;

    public TimeJumpPanel(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static long getLast() {
        return (long) ((((double) android.ext.Config.v) / 1000.0d) * 1.0E9d);
    }

    private void q() {
        android.ext.n2.i(new android.ext.TimeJumpPanel$a(this));
    }

    public static void s(boolean z) {
        android.ext.TimeJumpPanel timeJumpPanel = android.ext.MainService.instance.k;
        boolean z2 = (android.ext.Config.B & 128) != 0;
        if (z && z2) {
            if (timeJumpPanel == null) {
                timeJumpPanel = (android.ext.TimeJumpPanel) gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.time_jump_panel, null);
                timeJumpPanel.q();
                android.ext.MainService.instance.k = timeJumpPanel;
            }
            timeJumpPanel.m();
            return;
        }
        if (timeJumpPanel != null) {
            timeJumpPanel.e();
            if (z2) {
                return;
            }
            android.ext.MainService.instance.k = null;
        }
    }

    @Override // android.ext.FloatPanel
    protected java.lang.String getPrefName() {
        return "time-jump";
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        if (view == null) {
        }
        switch (view.getId()) {
            case catch_.me_.if_.you_.can_.R.id.time_jump /* 2131034426 */:
                android.ext.o2 o2Var = android.ext.o2.f1159g;
                if (o2Var != null) {
                    o2Var.onClick(null);
                }
                break;
            case catch_.me_.if_.you_.can_.R.id.time_jump_last /* 2131034427 */:
                long last = getLast();
                android.ext.o2.h(last);
                double d2 = last / 1.0E9d;
                android.ext.Tools.K1(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.time_jump) + ": " + android.ext.Tools.F(d2) + " (" + java.lang.Double.toString(d2).replaceFirst("\\D?0+$", "") + ')', 0);
                break;
            default:
                android.ext.e1.g("Unknown id: " + java.lang.Integer.toHexString(view.getId()), new java.lang.RuntimeException());
                break;
        }
    }

    public void r() {
        long last = getLast();
        this.p.setVisibility(last == 0 ? 8 : 0);
        this.p.setText(android.ext.Tools.F(last / 1.0E9d));
    }

    public void setMinSize(int i) {
        android.widget.Button button = this.p;
        if (button == null) {
            return;
        }
        button.setMinWidth(i);
        this.p.setMinHeight(i);
        this.q.setMinWidth(i);
        this.q.setMinHeight(i);
    }
}
