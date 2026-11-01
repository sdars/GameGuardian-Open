package android.ext;

/* JADX INFO: loaded from: classes.dex */
class SavedListAdapter$b extends android.ext.d3 {
    final android.widget.ImageView r;
    final android.widget.TextView s;

    SavedListAdapter$b(android.view.View view, android.ext.d3$a d3_a) {
        super(view, d3_a);
        android.widget.ImageView imageViewM = android.ext.Config.m((android.widget.ImageView) view.findViewById(catch_.me_.if_.you_.can_.R.id.freeze));
        this.r = imageViewM;
        imageViewM.setOnClickListener(d3_a);
        imageViewM.setOnLongClickListener(d3_a);
        this.s = (android.widget.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.name);
    }
}
