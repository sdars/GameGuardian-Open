package android.ext;

/* JADX INFO: loaded from: classes.dex */
class PathSelector$c implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener, android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.widget.ImageView f325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.fix.TextView f326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    android.fix.ListView f327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private android.fix.TextView f328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private java.io.File f329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private android.ext.ArrayAdapter f330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private android.app.AlertDialog f331g;
    private int h;
    private android.widget.EditText i;
    private android.widget.EditText j;
    private int k;
    private int l;
    private int m;
    final /* synthetic */ android.ext.PathSelector n;

    private PathSelector$c(android.ext.PathSelector pathSelector) {
        this.n = pathSelector;
        this.k = android.ext.Tools.e0(catch_.me_.if_.you_.can_.R.color.file_lua, -16755456);
        this.l = android.ext.Tools.e0(catch_.me_.if_.you_.can_.R.color.file_txt, -16777131);
        this.m = android.ext.Tools.e0(catch_.me_.if_.you_.can_.R.color.file_lasm, -16755371);
    }

    /* synthetic */ PathSelector$c(android.ext.PathSelector pathSelector, android.ext.PathSelector$a pathSelector$a) {
        this(pathSelector);
    }

    private void a(java.lang.String str) {
        android.ext.EditText editText = new android.ext.EditText(android.ext.Tools.f0());
        this.j = editText;
        editText.setText(str);
        android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.i0(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.folder_new), this.f329e.getAbsolutePath() + "/...")).setView(android.ext.InternalKeyboard.e(editText, false)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), this));
    }

    private void c(java.lang.String str) {
        this.f329e = new java.io.File(this.f329e, str);
    }

    private void d(int i) {
        this.f327c.setSelection(i);
        this.f327c.post(new android.ext.PathSelector$c$a(this, i));
    }

    private void e(java.io.File file, boolean z) {
        android.ext.ArrayAdapter arrayAdapter = this.f330f;
        int count = arrayAdapter.getCount();
        java.lang.String lowerCase = file.getAbsolutePath().toLowerCase(java.util.Locale.US);
        int i = 0;
        int i2 = 0;
        while (i < count) {
            java.io.File file2 = (java.io.File) arrayAdapter.getItem(i);
            if (file.equals(file2)) {
                d(i);
            }
            if (z == android.ext.PathSelector.c(file2) && lowerCase.compareTo(file2.getAbsolutePath().toLowerCase(java.util.Locale.US)) > 0) {
                i2 = i;
            }
            i++;
        }
        i = i2;
        d(i);
    }

    private void f(boolean z) {
        this.f328d.setVisibility(z ? 0 : 8);
        this.f327c.setVisibility(z ? 8 : 0);
    }

    private void g(boolean z) {
        android.widget.ImageView imageView = this.f325a;
        imageView.setTag(z ? null : imageView);
        this.f325a.setImageDrawable(android.ext.Tools.o0(z ? catch_.me_.if_.you_.can_.R.drawable.ic_sort_name_white_24dp : catch_.me_.if_.you_.can_.R.drawable.ic_sort_date_white_24dp));
    }

    private void h() {
        java.io.File parentFile = this.f329e.getParentFile();
        this.f329e = parentFile;
        if (parentFile == null) {
            this.f329e = new java.io.File("/");
        }
    }

    private void i() {
        this.f326b.setText(this.f329e.getAbsolutePath());
        java.lang.String[] strArrD = android.ext.PathSelector.d(this.f329e);
        f(strArrD == null);
        if (strArrD == null) {
            strArrD = gg_d.b.f1511a;
        }
        java.util.ArrayList arrayListE = android.ext.PathSelector.e(this.h, this.f329e, strArrD, null, this.f325a.getTag() == null);
        this.f330f.clear();
        this.f330f.setNotifyOnChange(false);
        java.util.Iterator it = arrayListE.iterator();
        while (it.hasNext()) {
            this.f330f.add(((android.ext.PathSelector$d) it.next()).f335a);
        }
        this.f330f.notifyDataSetChanged();
        this.f330f.setNotifyOnChange(true);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:26:0x00b7 A[Catch: all -> 0x00c3, TryCatch #0 {all -> 0x00c3, blocks: (B:23:0x00af, B:27:0x00bb, B:26:0x00b7), top: B:44:0x00af }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:37:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:38:0x0101  */
    /* JADX WARN: Code duplicated, block: B:41:0x010b  */
    public android.view.View b(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        int i2 = 0;
        long j;
        long j2;
        boolean z;
        int i3;
        java.lang.String strU;
        boolean zC;
        long length;
        java.io.File file = null;
        if (view == null) {
            view = android.view.LayoutInflater.from(this.n.getContext()).inflate(catch_.me_.if_.you_.can_.R.layout.path_item, (android.view.ViewGroup) null);
            android.ext.PathSelector$e pathSelector$e = new android.ext.PathSelector$e();
            pathSelector$e.f338a = (android.fix.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.name);
            pathSelector$e.f339b = (android.fix.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.date);
            pathSelector$e.f340c = (android.fix.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.size);
            pathSelector$e.f341d = android.ext.Config.m((android.widget.ImageView) view.findViewById(catch_.me_.if_.you_.can_.R.id.icon));
            view.setTag(pathSelector$e);
        }
        try {
            file = (java.io.File) this.f330f.getItem(i);
        } catch (java.lang.IndexOutOfBoundsException e2) {
            android.ext.e1.s("Failed get item: " + i, e2);
        }
        if (file == null) {
            file = new java.io.File(this.f329e, "???");
        }
        android.ext.PathSelector$e pathSelector$e2 = (android.ext.PathSelector$e) view.getTag();
        java.lang.String name = file.getName();
        try {
            if (name.endsWith(".lua")) {
                i2 = this.k;
            } else {
                if (!name.endsWith(".txt")) {
                    if (name.endsWith(".lasm")) {
                        i2 = this.m;
                    } else {
                        view.setBackgroundColor(0);
                    }
                    pathSelector$e2.f338a.setText(name);
                    j = -1;
                    zC = android.ext.PathSelector.c(file);
                    if (zC) {
                        length = -1;
                    } else {
                        length = file.length();
                    }
                    long jLastModified = file.lastModified();
                    z = zC;
                    j2 = jLastModified;
                    j = length;
                    android.widget.ImageView imageView = pathSelector$e2.f341d;
                    if (z) {
                        i3 = catch_.me_.if_.you_.can_.R.drawable.ic_folder_outline_white_24dp;
                    } else {
                        i3 = catch_.me_.if_.you_.can_.R.drawable.ic_file_white_24dp;
                    }
                    imageView.setImageResource(i3);
                    android.fix.TextView textView = pathSelector$e2.f340c;
                    if (j >= 0) {
                        strU = android.ext.Tools.U(this.n.getContext(), j);
                    } else {
                        strU = "";
                    }
                    textView.setText(strU);
                    pathSelector$e2.f339b.setText(j2 > 0 ? android.text.format.DateFormat.format("yyyy-MM-dd kk:mm:ss", j2) : "");
                    return view;
                }
                i2 = this.l;
            }
            zC = android.ext.PathSelector.c(file);
            if (zC) {
                length = -1;
            } else {
                length = file.length();
            }
            long jLastModified2 = file.lastModified();
            z = zC;
            j2 = jLastModified2;
            j = length;
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed get info: " + file.getAbsolutePath(), th);
            j2 = -1L;
            z = false;
        }
        view.setBackgroundColor(i2);
        pathSelector$e2.f338a.setText(name);
        j = -1;
        android.widget.ImageView imageView2 = pathSelector$e2.f341d;
        if (z) {
            i3 = catch_.me_.if_.you_.can_.R.drawable.ic_folder_outline_white_24dp;
        } else {
            i3 = catch_.me_.if_.you_.can_.R.drawable.ic_file_white_24dp;
        }
        imageView2.setImageResource(i3);
        android.fix.TextView textView2 = pathSelector$e2.f340c;
        if (j >= 0) {
            strU = android.ext.Tools.U(this.n.getContext(), j);
        } else {
            strU = "";
        }
        textView2.setText(strU);
        pathSelector$e2.f339b.setText(j2 > 0 ? android.text.format.DateFormat.format("yyyy-MM-dd kk:mm:ss", j2) : "");
        return view;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.f331g) {
            java.lang.String absolutePath = this.f329e.getAbsolutePath();
            if (this.h == 2) {
                java.lang.String name = new java.io.File(this.i.getText().toString()).getName();
                if (name == null || name.length() == 0) {
                    name = "file.txt";
                }
                absolutePath = absolutePath + "/" + name;
            }
            this.i.setText(absolutePath);
            return;
        }
        android.widget.EditText editText = this.j;
        if (editText != null) {
            java.lang.String strTrim = editText.getText().toString().trim();
            if (strTrim.length() > 0) {
                java.io.File file = new java.io.File(this.f329e, strTrim);
                if (file.exists()) {
                    android.ext.Tools.H1(android.ext.PathSelector.c(file) ? catch_.me_.if_.you_.can_.R.string.folder_exists : catch_.me_.if_.you_.can_.R.string.folder_file);
                } else {
                    if (file.mkdirs()) {
                        android.ext.y0.b(strTrim, 4);
                        i();
                        return;
                    }
                    android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.folder_failed);
                }
            } else {
                android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.folder_failed);
            }
            a(strTrim);
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == 2131034114) {
            a("");
            return;
        }
        if (id == 2131034409) {
            boolean z = this.f325a.getTag() != null;
            android.ext.PathSelector.f322a = z;
            g(z);
            i();
            d(0);
            return;
        }
        if (id == 2131034436) {
            java.io.File file = this.f329e;
            h();
            i();
            e(file, true);
            return;
        }
        java.lang.Object tag = this.n.getTag();
        if (tag instanceof android.ext.EditTextPath) {
            android.ext.EditTextPath editTextPath = (android.ext.EditTextPath) tag;
            this.i = editTextPath;
            android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.path_selector, null);
            this.f326b = (android.fix.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.path);
            android.ext.Config.m((android.widget.ImageView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.add)).setOnClickListener(this);
            android.widget.ImageView imageView = (android.widget.ImageView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.sort);
            this.f325a = imageView;
            android.ext.Config.m(imageView).setOnClickListener(this);
            g(android.ext.PathSelector.f322a);
            android.ext.Config.m((android.widget.ImageView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.up)).setOnClickListener(this);
            this.f328d = (android.fix.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.failed);
            android.fix.ListView listView = (android.fix.ListView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.files);
            this.f327c = listView;
            android.ext.PathSelector$c$b pathSelector$c$b = new android.ext.PathSelector$c$b(this, this.n.getContext(), new java.util.ArrayList());
            this.f330f = pathSelector$c$b;
            listView.setAdapter((android.widget.ListAdapter) pathSelector$c$b);
            listView.setOnItemClickListener(this);
            this.h = editTextPath.getPathType();
            java.io.File file2 = new java.io.File(editTextPath.getText().toString());
            this.f329e = file2;
            while (!android.ext.PathSelector.c(this.f329e)) {
                h();
            }
            i();
            e(file2, this.h == 0);
            android.app.AlertDialog.Builder negativeButton = android.ext.f.b().setView(viewF).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null);
            if (this.h != 1) {
                negativeButton.setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), this);
            }
            android.app.AlertDialog alertDialogCreate = negativeButton.create();
            this.f331g = alertDialogCreate;
            android.ext.f.m(alertDialogCreate);
        }
    }

    @Override // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(android.widget.AdapterView adapterView, android.view.View view, int i, long j) {
        if (i < 0 || i >= this.f330f.getCount()) {
            return;
        }
        try {
            java.io.File file = (java.io.File) this.f330f.getItem(i);
            if (file == null) {
                return;
            }
            if (android.ext.PathSelector.c(file)) {
                c(file.getName());
                i();
                d(0);
            } else if (this.h != 0) {
                this.i.setText(file.getAbsolutePath());
                android.ext.Tools.D(this.f331g);
            }
        } catch (java.lang.Exception e2) {
            android.ext.e1.s("Failed get Item: " + i, e2);
        }
    }
}
