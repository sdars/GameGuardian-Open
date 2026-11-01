package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ItemContextMenu$b implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.util.List f204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.util.ArrayList f205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.c f206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ android.ext.ItemContextMenu f207d;

    ItemContextMenu$b(android.ext.ItemContextMenu itemContextMenu, java.util.List list, java.util.ArrayList arrayList, android.ext.c cVar) {
        this.f207d = itemContextMenu;
        this.f204a = list;
        this.f205b = arrayList;
        this.f206c = cVar;
    }

    private java.lang.Long a() {
        android.ext.c cVar;
        if (this.f207d.f197a != 3 || (cVar = this.f206c) == null) {
            return null;
        }
        return java.lang.Long.valueOf(cVar.f672a);
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i < 0 || i >= this.f204a.size()) {
            android.ext.e1.i("Unknown index in menu: " + i + " for " + this.f204a.size());
            return;
        }
        switch (((java.lang.Integer) this.f204a.get(i)).intValue()) {
            case catch_.me_.if_.you_.can_.R.drawable.ic_calculator_white_24dp /* 2130968592 */:
                new android.ext.OffsetCalculator(a()).j((java.lang.String) this.f205b.get(i));
                break;
            case catch_.me_.if_.you_.can_.R.drawable.ic_code_braces_white_24dp /* 2130968597 */:
                android.ext.h.h((java.lang.String) this.f205b.get(i));
                break;
            case catch_.me_.if_.you_.can_.R.drawable.ic_content_copy_white_24dp /* 2130968598 */:
                android.ext.Tools.z((java.lang.String) this.f205b.get(i));
                break;
            case catch_.me_.if_.you_.can_.R.drawable.ic_cursor_mover_white_24dp /* 2130968601 */:
                android.ext.b.h((java.lang.String) this.f205b.get(i));
                break;
            case catch_.me_.if_.you_.can_.R.drawable.ic_forward_white_24dp /* 2130968618 */:
                android.ext.MainService.instance.L(a(), (java.lang.String) this.f205b.get(i), android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.from_context) + ": (" + this.f206c + ')');
                break;
            case catch_.me_.if_.you_.can_.R.drawable.ic_pointer_white_24dp /* 2130968640 */:
                new android.ext.w1().l((java.lang.String) this.f205b.get(i));
                break;
            case catch_.me_.if_.you_.can_.R.drawable.ic_search_nearby_white_24dp /* 2130968646 */:
                android.ext.MainService.instance.W.y((java.lang.String) this.f205b.get(i));
                break;
            default:
                android.ext.e1.i("Unknown icon in menu: " + java.lang.Integer.toHexString(((java.lang.Integer) this.f204a.get(i)).intValue()));
                break;
        }
        if (dialogInterface != null) {
            android.ext.Tools.D(dialogInterface);
        }
    }
}
