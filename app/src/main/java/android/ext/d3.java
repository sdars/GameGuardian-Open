package android.ext;

/* JADX INFO: loaded from: classes.dex */
class d3 extends android.ext.b3 {
    final android.widget.TextView n;
    final android.widget.LinearLayout o;
    final android.widget.TextView p;
    final android.widget.ImageView q;

    d3(android.view.View view, android.ext.d3$a d3_a) {
        super(view, d3_a);
        this.n = (android.widget.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.addr_item_value);
        this.o = (android.widget.LinearLayout) view.findViewById(catch_.me_.if_.you_.can_.R.id.addr_item_info);
        this.p = (android.widget.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.addr_item_type);
        android.widget.ImageView imageViewM = android.ext.Config.m((android.widget.ImageView) view.findViewById(catch_.me_.if_.you_.can_.R.id.addr_item_remove));
        this.q = imageViewM;
        imageViewM.setOnClickListener(d3_a);
        imageViewM.setOnLongClickListener(d3_a);
    }
}
