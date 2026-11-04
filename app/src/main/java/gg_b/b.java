package gg_b;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final java.util.HashMap a(java.io.InputStream inputStream) throws org.xmlpull.v1.XmlPullParserException {
        org.xmlpull.v1.XmlPullParser xmlPullParserNewPullParser = android.util.Xml.newPullParser();
        xmlPullParserNewPullParser.setInput(inputStream, "UTF-8");try {

        return (java.util.HashMap) l(xmlPullParserNewPullParser, new java.lang.String[1]);
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
    }

    private static final boolean[] b(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        try {
            int i = java.lang.Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            boolean[] zArr = new boolean[i];
            int eventType = xmlPullParser.getEventType();
            int i2 = 0;
            do {
                if (eventType == 2) {
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                    try {
                        zArr[i2] = java.lang.Boolean.valueOf(xmlPullParser.getAttributeValue(null, "value")).booleanValue();
                    } catch (java.lang.NullPointerException unused) {
                        throw new org.xmlpull.v1.XmlPullParserException("Need value attribute in item");
                    } catch (java.lang.NumberFormatException unused2) {
                        throw new org.xmlpull.v1.XmlPullParserException("Not a number in value attribute in item");
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return zArr;
                    }
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                    i2++;
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new org.xmlpull.v1.XmlPullParserException("Document ended before " + str + " end tag");
        } catch (java.lang.NullPointerException unused3) {
            throw new org.xmlpull.v1.XmlPullParserException("Need num attribute in string-array");
        } catch (java.lang.NumberFormatException unused4) {
            throw new org.xmlpull.v1.XmlPullParserException("Not a number in num attribute in string-array");
        }
    }

    private static final double[] c(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        try {
            int i = java.lang.Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            double[] dArr = new double[i];
            int eventType = xmlPullParser.getEventType();
            int i2 = 0;
            do {
                if (eventType == 2) {
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                    try {
                        dArr[i2] = java.lang.Double.parseDouble(xmlPullParser.getAttributeValue(null, "value"));
                    } catch (java.lang.NullPointerException unused) {
                        throw new org.xmlpull.v1.XmlPullParserException("Need value attribute in item");
                    } catch (java.lang.NumberFormatException unused2) {
                        throw new org.xmlpull.v1.XmlPullParserException("Not a number in value attribute in item");
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return dArr;
                    }
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                    i2++;
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new org.xmlpull.v1.XmlPullParserException("Document ended before " + str + " end tag");
        } catch (java.lang.NullPointerException unused3) {
            throw new org.xmlpull.v1.XmlPullParserException("Need num attribute in double-array");
        } catch (java.lang.NumberFormatException unused4) {
            throw new org.xmlpull.v1.XmlPullParserException("Not a number in num attribute in double-array");
        }
    }

    private static final int[] d(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        try {
            int i = java.lang.Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            int[] iArr = new int[i];
            int eventType = xmlPullParser.getEventType();
            int i2 = 0;
            do {
                if (eventType == 2) {
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                    try {
                        iArr[i2] = java.lang.Integer.parseInt(xmlPullParser.getAttributeValue(null, "value"));
                    } catch (java.lang.NullPointerException unused) {
                        throw new org.xmlpull.v1.XmlPullParserException("Need value attribute in item");
                    } catch (java.lang.NumberFormatException unused2) {
                        throw new org.xmlpull.v1.XmlPullParserException("Not a number in value attribute in item");
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return iArr;
                    }
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                    i2++;
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new org.xmlpull.v1.XmlPullParserException("Document ended before " + str + " end tag");
        } catch (java.lang.NullPointerException unused3) {
            throw new org.xmlpull.v1.XmlPullParserException("Need num attribute in byte-array");
        } catch (java.lang.NumberFormatException unused4) {
            throw new org.xmlpull.v1.XmlPullParserException("Not a number in num attribute in byte-array");
        }
    }

    private static final java.util.ArrayList e(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr, b$a b_a) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                arrayList.add(k(xmlPullParser, strArr, b_a));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return arrayList;
                }
                throw new org.xmlpull.v1.XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new org.xmlpull.v1.XmlPullParserException("Document ended before " + str + " end tag");
    }

    private static final long[] f(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        try {
            int i = java.lang.Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            long[] jArr = new long[i];
            int eventType = xmlPullParser.getEventType();
            int i2 = 0;
            do {
                if (eventType == 2) {
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                    try {
                        jArr[i2] = java.lang.Long.parseLong(xmlPullParser.getAttributeValue(null, "value"));
                    } catch (java.lang.NullPointerException unused) {
                        throw new org.xmlpull.v1.XmlPullParserException("Need value attribute in item");
                    } catch (java.lang.NumberFormatException unused2) {
                        throw new org.xmlpull.v1.XmlPullParserException("Not a number in value attribute in item");
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return jArr;
                    }
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                    i2++;
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new org.xmlpull.v1.XmlPullParserException("Document ended before " + str + " end tag");
        } catch (java.lang.NullPointerException unused3) {
            throw new org.xmlpull.v1.XmlPullParserException("Need num attribute in long-array");
        } catch (java.lang.NumberFormatException unused4) {
            throw new org.xmlpull.v1.XmlPullParserException("Not a number in num attribute in long-array");
        }
    }

    private static final java.util.HashMap g(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr, b$a b_a) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.util.HashMap map = new java.util.HashMap();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                /* the original dex reads the name out of strArr *after* the
                   value has been parsed: k() fills strArr[0] with the name of
                   the element that was just read.  When the read of
                   strArr[0] is written in front of the call, java evaluates
                   the argument first and the map gets the name of the
                   *previous* element - every entry of a copied preferences
                   file would then carry the value of its predecessor (the
                   memory editor format for example would end up as a
                   string). */
                java.lang.Object obj = k(xmlPullParser, strArr, b_a);
                map.put(strArr[0], obj);
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return map;
                }
                throw new org.xmlpull.v1.XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new org.xmlpull.v1.XmlPullParserException("Document ended before " + str + " end tag");
    }

    private static final java.lang.Object h(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws org.xmlpull.v1.XmlPullParserException {
        try {
            if (str.equals("int")) {
                return java.lang.Integer.valueOf(java.lang.Integer.parseInt(xmlPullParser.getAttributeValue(null, "value")));
            }
            if (str.equals("long")) {
                return java.lang.Long.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (str.equals("float")) {
                return java.lang.Float.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (str.equals("double")) {
                return java.lang.Double.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (str.equals("boolean")) {
                return java.lang.Boolean.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
            return null;
        } catch (java.lang.NullPointerException unused) {
            throw new org.xmlpull.v1.XmlPullParserException("Need value attribute in <" + str + '>');
        } catch (java.lang.NumberFormatException unused2) {
            throw new org.xmlpull.v1.XmlPullParserException("Not a number in value attribute in <" + str + '>');
        }
    }

    private static final java.util.HashSet i(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr, b$a b_a) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.util.HashSet hashSet = new java.util.HashSet();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                hashSet.add(k(xmlPullParser, strArr, b_a));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return hashSet;
                }
                throw new org.xmlpull.v1.XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new org.xmlpull.v1.XmlPullParserException("Document ended before " + str + " end tag");
    }

    private static final java.lang.String[] j(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String[] strArr) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        try {
            int i = java.lang.Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            java.lang.String[] strArr2 = new java.lang.String[i];
            int eventType = xmlPullParser.getEventType();
            int i2 = 0;
            do {
                if (eventType == 2) {
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                    try {
                        strArr2[i2] = xmlPullParser.getAttributeValue(null, "value");
                    } catch (java.lang.NullPointerException unused) {
                        throw new org.xmlpull.v1.XmlPullParserException("Need value attribute in item");
                    } catch (java.lang.NumberFormatException unused2) {
                        throw new org.xmlpull.v1.XmlPullParserException("Not a number in value attribute in item");
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return strArr2;
                    }
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new org.xmlpull.v1.XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                    i2++;
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new org.xmlpull.v1.XmlPullParserException("Document ended before " + str + " end tag");
        } catch (java.lang.NullPointerException unused3) {
            throw new org.xmlpull.v1.XmlPullParserException("Need num attribute in string-array");
        } catch (java.lang.NumberFormatException unused4) {
            throw new org.xmlpull.v1.XmlPullParserException("Not a number in num attribute in string-array");
        }
    }

    private static final java.lang.Object k(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String[] strArr, b$a b_a) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int next;
        java.lang.Object objH = null;
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        java.lang.String name = xmlPullParser.getName();
        if (!name.equals("null")) {
            if (name.equals("string")) {
                java.lang.String str = "";
                while (true) {
                    int next2 = xmlPullParser.next();
                    if (next2 == 1) {
                        throw new org.xmlpull.v1.XmlPullParserException("Unexpected end of document in <string>");
                    }
                    if (next2 == 3) {
                        if (xmlPullParser.getName().equals("string")) {
                            strArr[0] = attributeValue;
                            return str;
                        }
                        throw new org.xmlpull.v1.XmlPullParserException("Unexpected end tag in <string>: " + xmlPullParser.getName());
                    }
                    if (next2 == 4) {
                        str = str + xmlPullParser.getText();
                    } else if (next2 == 2) {
                        throw new org.xmlpull.v1.XmlPullParserException("Unexpected start tag in <string>: " + xmlPullParser.getName());
                    }
                }
            } else {
                objH = h(xmlPullParser, name);
                if (objH == null) {
                    if (name.equals("int-array")) {
                        int[] iArrD = d(xmlPullParser, "int-array", strArr);
                        strArr[0] = attributeValue;
                        return iArrD;
                    }
                    if (name.equals("long-array")) {
                        long[] jArrF = f(xmlPullParser, "long-array", strArr);
                        strArr[0] = attributeValue;
                        return jArrF;
                    }
                    if (name.equals("double-array")) {
                        double[] dArrC = c(xmlPullParser, "double-array", strArr);
                        strArr[0] = attributeValue;
                        return dArrC;
                    }
                    if (name.equals("string-array")) {
                        java.lang.String[] strArrJ = j(xmlPullParser, "string-array", strArr);
                        strArr[0] = attributeValue;
                        return strArrJ;
                    }
                    if (name.equals("boolean-array")) {
                        boolean[] zArrB = b(xmlPullParser, "boolean-array", strArr);
                        strArr[0] = attributeValue;
                        return zArrB;
                    }
                    if (name.equals("map")) {
                        xmlPullParser.next();
                        java.util.HashMap mapG = g(xmlPullParser, "map", strArr, b_a);
                        strArr[0] = attributeValue;
                        return mapG;
                    }
                    if (name.equals("list")) {
                        xmlPullParser.next();
                        java.util.ArrayList arrayListE = e(xmlPullParser, "list", strArr, b_a);
                        strArr[0] = attributeValue;
                        return arrayListE;
                    }
                    if (name.equals("set")) {
                        xmlPullParser.next();
                        java.util.HashSet hashSetI = i(xmlPullParser, "set", strArr, b_a);
                        strArr[0] = attributeValue;
                        return hashSetI;
                    }
                    if (b_a != null) {
                        java.lang.Object objA = b_a.a(xmlPullParser, name);
                        strArr[0] = attributeValue;
                        return objA;
                    }
                    throw new org.xmlpull.v1.XmlPullParserException("Unknown tag: " + name);
                }
            }
        }
        do {
            next = xmlPullParser.next();
            if (next == 1) {
                throw new org.xmlpull.v1.XmlPullParserException("Unexpected end of document in <" + name + '>');
            }
            if (next == 3) {
                if (xmlPullParser.getName().equals(name)) {
                    strArr[0] = attributeValue;
                    return objH;
                }
                throw new org.xmlpull.v1.XmlPullParserException("Unexpected end tag in <" + name + ">: " + xmlPullParser.getName());
            }
            if (next == 4) {
                throw new org.xmlpull.v1.XmlPullParserException("Unexpected text in <" + name + ">: " + xmlPullParser.getName());
            }
        } while (next != 2);
        throw new org.xmlpull.v1.XmlPullParserException("Unexpected start tag in <" + name + ">: " + xmlPullParser.getName());
    }

    private static final java.lang.Object l(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String[] strArr) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 2) {
            if (eventType == 3) {
                throw new org.xmlpull.v1.XmlPullParserException("Unexpected end tag at: " + xmlPullParser.getName());
            }
            if (eventType == 4) {
                throw new org.xmlpull.v1.XmlPullParserException("Unexpected text: " + xmlPullParser.getText());
            }
            eventType = xmlPullParser.next();
            if (eventType == 1) {
                throw new org.xmlpull.v1.XmlPullParserException("Unexpected end of document");
            }
        }
        return k(xmlPullParser, strArr, null);
    }
}
