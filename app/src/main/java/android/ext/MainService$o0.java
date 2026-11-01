package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$o0 extends android.ext.MainService$l0 {
    final /* synthetic */ android.ext.MainService h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainService$o0(android.ext.MainService mainService) {
        super(mainService, catch_.me_.if_.you_.can_.R.string.selected_as_search_result, catch_.me_.if_.you_.can_.R.drawable.ic_search_selected_white_24dp);
        this.h = mainService;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainService$o0(android.ext.MainService mainService, int i, int i2) {
        super(mainService, i, i2);
        this.h = mainService;
    }

    @Override // android.ext.MainService$l0
    void h(java.util.List list, java.lang.Object obj) {
        android.ext.c2 c2Var;
        if (list.size() == 0) {
            this.h.n((byte) 0);
            return;
        }
        if (!this.h.a1()) {
            throw new java.lang.NumberFormatException(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.busy_dialog_fail));
        }
        if (this.h.p0 != 0) {
            this.h.n((byte) 0);
        }
        android.ext.MainService mainService = this.h;
        mainService.q0 = false;
        mainService.i.x0((byte) 0);
        this.h.R((byte) 0);
        android.ext.MainService mainService2 = this.h;
        mainService2.r0 = false;
        mainService2.i.f0((byte) 0, list);
        this.h.m.setCurrentTab(1);
        boolean z = obj instanceof gg_d.a;
        if ((z || (obj instanceof gg_d.e)) && (c2Var = this.h.f216f) != null && z) {
            android.ext.b0.n(c2Var, true);
        }
    }

    @Override // android.ext.MainService$l0, android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        if (this.h.p0 == 0) {
            j();
        } else {
            android.ext.f.o(android.ext.f.b().setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.clear_results_prompt)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.yes), new android.ext.MainService$o0$a(this)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no), (android.content.DialogInterface.OnClickListener) null));
        }
    }
}
