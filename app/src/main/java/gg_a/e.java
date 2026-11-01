package gg_a;

/* JADX INFO: loaded from: classes.dex */
public class e extends android.util.SparseArray {
    private void a() {
        try {
            java.lang.reflect.Field declaredField = android.util.SparseArray.class.getDeclaredField("mKeys");
            declaredField.setAccessible(true);
            java.lang.reflect.Field declaredField2 = android.util.SparseArray.class.getDeclaredField("mValues");
            declaredField2.setAccessible(true);
            java.lang.reflect.Field declaredField3 = android.util.SparseArray.class.getDeclaredField("mSize");
            declaredField3.setAccessible(true);
            int i = declaredField3.getInt(this);
            int length = ((int[]) declaredField.get(this)).length;
            int length2 = ((java.lang.Object[]) declaredField2.get(this)).length;
            if (i > length || i > length2) {
                declaredField3.setInt(this, java.lang.Math.min(java.lang.Math.min(i, length), length2));
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed fix", th);
        }
    }

    public synchronized java.lang.Object b(int i) {
        try {
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
        return get(i);
    }

    public synchronized void c(int i, java.lang.Object obj) {
        try {
            put(i, obj);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // android.util.SparseArray
    public void clear() {
        try {
            super.clear();
        } catch (java.lang.ArrayIndexOutOfBoundsException e2) {
            android.ext.e1.a(e2);
            a();
            super.clear();
        }
    }

    @Override // android.util.SparseArray
    public void delete(int i) {
        try {
            super.delete(i);
        } catch (java.lang.ArrayIndexOutOfBoundsException e2) {
            android.ext.e1.a(e2);
            a();
            super.delete(i);
        }
    }

    @Override // android.util.SparseArray
    public java.lang.Object get(int i, java.lang.Object obj) {
        try {
            return super.get(i, obj);
        } catch (java.lang.ArrayIndexOutOfBoundsException e2) {
            android.ext.e1.a(e2);
            a();
            return super.get(i, obj);
        }
    }

    @Override // android.util.SparseArray
    public int indexOfKey(int i) {
        try {
            return super.indexOfKey(i);
        } catch (java.lang.ArrayIndexOutOfBoundsException e2) {
            android.ext.e1.a(e2);
            a();
            return super.indexOfKey(i);
        }
    }

    @Override // android.util.SparseArray
    public void put(int i, java.lang.Object obj) {
        try {
            super.put(i, obj);
        } catch (java.lang.ArrayIndexOutOfBoundsException e2) {
            android.ext.e1.a(e2);
            a();
            super.put(i, obj);
        }
    }

    @Override // android.util.SparseArray
    public void removeAt(int i) {
        super.removeAt(i);
    }

    @Override // android.util.SparseArray
    public int size() {
        try {
            return super.size();
        } catch (java.lang.ArrayIndexOutOfBoundsException e2) {
            android.ext.e1.a(e2);
            a();
            return super.size();
        }
    }
}
