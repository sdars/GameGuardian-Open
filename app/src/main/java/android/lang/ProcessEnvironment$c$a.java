package android.lang;

/* JADX INFO: loaded from: classes.dex */
class ProcessEnvironment$c$a implements java.util.Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    java.util.Iterator f1464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.lang.ProcessEnvironment$c f1465b;

    ProcessEnvironment$c$a(android.lang.ProcessEnvironment$c processEnvironment$c) {
        this.f1465b = processEnvironment$c;
        this.f1464a = processEnvironment$c.f1463a.iterator();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.util.Map.Entry next() {
        return new android.lang.ProcessEnvironment$b((java.util.Map.Entry) this.f1464a.next());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f1464a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f1464a.remove();
    }
}
