package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$g0 implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f243b;

    MainService$g0(android.ext.MainService mainService, java.lang.String str) {
        this.f243b = mainService;
        this.f242a = str;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.f.o(android.ext.f.b().setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.try_reinstall_x86)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.yes), new android.ext.MainService$g0$a(this)).setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.site), new android.ext.r$n("kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh278:0krz0wr0uhsodfh0dup0oleudulhv0zlwk0{;90oleudulhv0{0soruh2")).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no), (android.content.DialogInterface.OnClickListener) null));
    }
}
