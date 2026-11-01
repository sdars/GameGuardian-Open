package android.ext;

/* JADX INFO: loaded from: classes.dex */
class u0$b$a implements android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.RegionList f1271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.u0$b f1272b;

    u0$b$a(android.ext.u0$b u0_b, android.ext.RegionList regionList) {
        this.f1272b = u0_b;
        this.f1271a = regionList;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        int i;
        int id = view.getId();
        if (id == 2131034144) {
            i = 16;
        } else if (id != 2131034363) {
            i = id != 2131034456 ? 8 : 16384;
        } else {
            i = 262144;
        }
        android.ext.RegionList regionList = this.f1271a;
        regionList.j(regionList, i);
    }
}
