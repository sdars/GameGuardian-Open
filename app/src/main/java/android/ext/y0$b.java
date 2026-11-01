package android.ext;

/* JADX INFO: loaded from: classes.dex */
class y0$b extends android.widget.BaseAdapter implements android.view.View.OnClickListener, android.view.View.OnLongClickListener, android.view.View.OnFocusChangeListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static boolean f1335e = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final java.util.ArrayList f1337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final android.content.Context f1338c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    android.app.AlertDialog f1336a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1339d = false;

    public y0$b(android.content.Context context, int i) {
        this.f1338c = context;
        android.ext.y0.d();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.f1337b = arrayList;
        int i2 = android.ext.y0.f1332b;
        int i3 = 0;
        for (android.ext.y0$c y0_c : (java.util.Collection<android.ext.y0$c>) android.ext.y0.f1331a) {
            if (y0_c != null && (y0_c.f1357b & i) != 0) {
                arrayList.add(new android.ext.y0$b$d(y0_c, i3 < i2));
            }
            i3++;
        }
    }

    private void a(android.ext.y0$c y0_c, android.content.Context context) {
        android.ext.EditText editText = new android.ext.EditText(context);
        editText.setText(b(y0_c.f1359d));
        android.app.AlertDialog alertDialogCreate = android.ext.f.c(context).setCustomTitle(android.ext.Tools.h0(y0_c.f1356a)).setView(editText).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), new android.ext.y0$b$b(this, y0_c, editText)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).create();
        android.ext.f.l(alertDialogCreate, new android.ext.y0$b$c(this, editText));
        android.ext.f.n(alertDialogCreate, editText);
    }

    private java.lang.String b(java.lang.String str) {
        java.lang.String strTrim = str.trim();
        return "...".equals(strTrim) ? "" : strTrim;
    }

    private void d(android.view.View view, boolean z) {
        android.app.AlertDialog alertDialog;
        android.view.Window window;
        if (this.f1339d == z || (alertDialog = this.f1336a) == null || (window = alertDialog.getWindow()) == null) {
            return;
        }
        android.ext.Tools.L(window, view, z);
        this.f1339d = z;
    }

    private void e(android.ext.y0$b$e y0_b_e) {
        int i;
        int i2;
        if (y0_b_e.h.f1348b) {
            i = catch_.me_.if_.you_.can_.R.drawable.ic_pin_off_white_24dp;
            i2 = -2139864428;
        } else {
            i = catch_.me_.if_.you_.can_.R.drawable.ic_pin_white_24dp;
            i2 = 0;
        }
        f(y0_b_e, i, i2);
    }

    private void f(android.ext.y0$b$e y0_b_e, int i, int i2) {
        y0_b_e.f1352d.setImageResource(i);
        y0_b_e.f1354f.setBackgroundColor(i2);
    }

    void c(android.ext.y0$c y0_c, java.lang.String str, boolean z) {
        android.ext.y0$c y0_c2;
        java.util.Iterator it = android.ext.y0.f1331a.iterator();
        do {
            if (!it.hasNext()) {
                y0_c2 = y0_c;
                break;
            }
            y0_c2 = (android.ext.y0$c) it.next();
        } while (!y0_c.equals(y0_c2));
        java.lang.String strTrim = str.trim();
        if (strTrim.length() == 0) {
            strTrim = "...";
        }
        if (strTrim.equals(y0_c2.f1359d)) {
            return;
        }
        y0_c2.f1359d = strTrim;
        if (y0_c != y0_c2) {
            y0_c.f1359d = strTrim;
        }
        if (z) {
            notifyDataSetChanged();
        }
        android.ext.y0.h();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1337b.size();
    }

    @Override // android.widget.Adapter
    public java.lang.Object getItem(int i) {
        return this.f1337b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        if (view == null || !(view.getTag() instanceof android.ext.y0$b$e)) {
            view = android.view.LayoutInflater.from(this.f1338c).inflate(catch_.me_.if_.you_.can_.R.layout.history_item, viewGroup, false);
            android.ext.y0$b$e y0_b_e = new android.ext.y0$b$e();
            y0_b_e.f1349a = (android.widget.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.value);
            y0_b_e.f1350b = (android.widget.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.note);
            android.ext.EditText editText = (android.ext.EditText) view.findViewById(catch_.me_.if_.you_.can_.R.id.note_edit);
            y0_b_e.f1351c = editText;
            editText.addTextChangedListener(new android.ext.y0$b$a(this, y0_b_e));
            android.ext.Tools.z1(y0_b_e.f1351c, this);
            android.widget.ImageView imageViewM = android.ext.Config.m((android.widget.ImageView) view.findViewById(catch_.me_.if_.you_.can_.R.id.pin));
            y0_b_e.f1352d = imageViewM;
            imageViewM.setOnClickListener(this);
            y0_b_e.f1352d.setOnLongClickListener(this);
            y0_b_e.f1352d.setTag(y0_b_e);
            android.widget.ImageView imageViewM2 = android.ext.Config.m((android.widget.ImageView) view.findViewById(catch_.me_.if_.you_.can_.R.id.delete));
            y0_b_e.f1353e = imageViewM2;
            imageViewM2.setOnClickListener(this);
            y0_b_e.f1353e.setOnLongClickListener(this);
            y0_b_e.f1353e.setTag(y0_b_e);
            y0_b_e.f1354f = view;
            view.setTag(y0_b_e);
            view.setOnLongClickListener(this);
            view.setOnClickListener(this);
        }
        android.ext.y0$b$e y0_b_e2 = (android.ext.y0$b$e) view.getTag();
        android.ext.y0$b$d y0_b_d = (android.ext.y0$b$d) this.f1337b.get(i);
        y0_b_e2.h = y0_b_d;
        y0_b_e2.f1349a.setText(y0_b_d.f1347a.f1356a);
        java.lang.String str = y0_b_d.f1347a.f1359d;
        y0_b_e2.f1350b.setText(str);
        y0_b_e2.f1351c.setText(b(str));
        y0_b_e2.f1355g = i;
        y0_b_e2.f1350b.setVisibility(!f1335e ? 0 : 8);
        int i2 = f1335e ? 0 : 8;
        y0_b_e2.f1351c.setVisibility(i2);
        y0_b_e2.f1353e.setVisibility(i2);
        ((android.view.ViewGroup) view).setDescendantFocusability(f1335e ? 131072 : 393216);
        e(y0_b_e2);
        return view;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        android.widget.AdapterView.OnItemClickListener onItemClickListener;
        if (view == null) {
            return;
        }
        int id = view.getId();
        int i = 0;
        if (id == 2131034221) {
            boolean z = !f1335e;
            f1335e = z;
            if (!z) {
                d(view, false);
            }
            notifyDataSetChanged();
            return;
        }
        android.ext.y0$b$e y0_b_e = (android.ext.y0$b$e) view.getTag();
        if (y0_b_e == null) {
            return;
        }
        int i2 = y0_b_e.f1355g;
        if (id != 2131034225) {
            if (id != 2131034355) {
                android.widget.AdapterView<?> adapterViewW0 = android.ext.Tools.w0(view);
                if (adapterViewW0 == null || (onItemClickListener = adapterViewW0.getOnItemClickListener()) == null) {
                    return;
                }
                onItemClickListener.onItemClick(adapterViewW0, view, i2, getItemId(i2));
                return;
            }
            android.ext.y0$b$d y0_b_d = y0_b_e.h;
            boolean z2 = !y0_b_d.f1348b;
            y0_b_d.f1348b = z2;
            e(y0_b_e);
            android.ext.y0$c y0_c = y0_b_e.h.f1347a;
            android.ext.y0.a(y0_c.f1356a, z2 ? (byte) 1 : (byte) 2, y0_c.f1357b);
            return;
        }
        android.ext.y0$c y0_c2 = y0_b_e.h.f1347a;
        java.util.ListIterator listIterator = android.ext.y0.f1331a.listIterator();
        while (listIterator.hasNext()) {
            if (((android.ext.y0$c) listIterator.next()).equals(y0_c2)) {
                listIterator.remove();
                int i3 = android.ext.y0.f1332b;
                if (i < i3) {
                    android.ext.y0.f1332b = i3 - 1;
                }
                this.f1337b.remove(y0_b_e.h);
                notifyDataSetChanged();
                android.ext.y0.h();
                return;
            }
            i++;
        }
    }

    @Override // android.view.View$OnFocusChangeListener
    public void onFocusChange(android.view.View view, boolean z) {
        boolean z2 = f1335e;
        if ((!z) && z2) {
            return;
        }
        d(view, z & z2);
    }

    @Override // android.view.View$OnLongClickListener
    public boolean onLongClick(android.view.View view) {
        android.ext.y0$b$e y0_b_e;
        if (f1335e || view == null) {
            return false;
        }
        while (true) {
            if (view != null) {
                java.lang.Object tag = view.getTag();
                if (tag instanceof android.ext.y0$b$e) {
                    y0_b_e = (android.ext.y0$b$e) tag;
                    break;
                }
                java.lang.Object parent = view.getParent();
                if (parent instanceof android.view.View) {
                    view = (android.view.View) parent;
                }
            }
            y0_b_e = null;
            break;
        }
        if (y0_b_e == null) {
            return false;
        }
        a(y0_b_e.h.f1347a, view.getContext());
        return true;
    }
}
