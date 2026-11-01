package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class h3 {
    /* JADX WARN: Code duplicated, block: B:14:0x002c A[Catch: all -> 0x001a, IOException -> 0x001f, TRY_LEAVE, TryCatch #20 {IOException -> 0x001f, blocks: (B:7:0x0015, B:14:0x002c, B:30:0x0088, B:72:0x015c, B:74:0x0162, B:77:0x0195, B:79:0x01ba, B:75:0x018d, B:82:0x01e0, B:90:0x021b, B:99:0x025f, B:101:0x0299, B:109:0x02c3, B:115:0x02e7, B:117:0x02f2, B:123:0x031a, B:138:0x0365, B:144:0x0387), top: B:203:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x03be A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:160:0x03ca A[Catch: all -> 0x03cb, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x03cb, blocks: (B:152:0x03b7, B:160:0x03ca), top: B:181:0x03b7 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x03c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:197:0x03d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x0054  */
    /* JADX WARN: Code duplicated, block: B:228:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:230:? A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:14:0x002c, please report this as an issue */
    public static void a(java.io.File file) {
java.lang.Throwable e = null;
java.lang.Throwable th = null;
java.lang.Throwable th2 = null;
        java.io.RandomAccessFile randomAccessFile = null;
        boolean z = false;
        short sE;
        int iD;
        long jD;
        long j;
        java.lang.String str = "ZipAlign close fail";
        try {            android.ext.GgNoop.keep();

            try { if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }
 if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }
 if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }
 if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }
                if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }

                java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(file, "rw");
                try {                    if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }

                    try {
                        long length = randomAccessFile2.length();
                        if (length != 0) {
                            if (length < 22) {
                                android.ext.e1.p("ZipAlign small size: " + length + ' ' + file.getAbsolutePath());
                                randomAccessFile2.close();
                                return;
                            }
                            long j2 = length - 22;
                            randomAccessFile2.seek(length - 12);
                            sE = e(randomAccessFile2);
                            iD = d(randomAccessFile2);
                            jD = d(randomAccessFile2);
                            java.lang.String str2 = ", ";
                            if (sE > 0) {
                            }
                            android.ext.e1.p("bad values in EOCD: " + ((int) sE) + ", " + iD + ", " + jD);
                            randomAccessFile2.close();
                            return;
                        }
                        try {
                            length = file.length();
                            if (length < 22) {
                                android.ext.e1.p("ZipAlign small size: " + length + ' ' + file.getAbsolutePath());
                                try {
                                    randomAccessFile2.close();
                                    return;
                                } catch (java.lang.Throwable th3) {
                                    android.ext.e1.l("ZipAlign close fail", th3);
                                    return;
                                }
                            }
                            long j3 = length - 22;
                            randomAccessFile2.seek(length - 12);
                            sE = e(randomAccessFile2);
                            iD = d(randomAccessFile2);
                            jD = d(randomAccessFile2);
                            java.lang.String str3 = ", ";
                            if (sE > 0 || iD <= 0 || jD <= 0) {
                                android.ext.e1.p("bad values in EOCD: " + ((int) sE) + ", " + iD + ", " + jD);
                                try {
                                    randomAccessFile2.close();
                                    return;
                                } catch (java.lang.Throwable th4) {
                                    android.ext.e1.l("ZipAlign close fail", th4);
                                    return;
                                }
                            }
                            long j4 = ((long) iD) + jD;
                            java.lang.String str4 = " + ";
                            java.lang.String str5 = " = ";
                            if (j3 != j4) {
                                android.ext.e1.p("Bad EOCD offset: " + j3 + " != " + j4 + " = " + jD + " + " + iD);
                                try {
                                    randomAccessFile2.close();
                                    return;
                                } catch (java.lang.Throwable th5) {
                                    android.ext.e1.l("ZipAlign close fail", th5);
                                    return;
                                }
                            }
                            try {
                                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(iD + 22);
                                long j5 = length;
                                long j6 = jD;
                                long j7 = j6;
                                int i = 0;
                                while (i < sE) {
                                    java.lang.String str6 = str3;
                                    if (j6 >= j4) {
                                        try {
                                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                            try {                                                if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }

                                                sb.append("Out from CD: ");
                                                sb.append(i);
                                                sb.append(" from ");
                                                sb.append((int) sE);
                                                sb.append("; ");
                                                sb.append(j6);
                                                sb.append(" > ");
                                                sb.append(j4);
                                                sb.append(str5);
                                                sb.append(jD);
                                                sb.append(str4);
                                                sb.append(iD);
                                                android.ext.e1.p(sb.toString());
                                                try {
                                                    randomAccessFile2.close();
                                                    return;
                                                } catch (java.lang.Throwable th6) {
                                                    android.ext.e1.l("ZipAlign close fail", th6);
                                                    return;
                                                }
                                            } catch (java.io.IOException e2) { if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }
 if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }
 if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }
 if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }
 if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }
                                                if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }

                                                e = e2;
                                                str = "ZipAlign close fail";
                                            } catch (java.lang.Throwable th7) {
                                                th2 = th7;
                                                str = "ZipAlign close fail";
                                                randomAccessFile = randomAccessFile2;
                                                th = th2;
                                                if (randomAccessFile == null) {
                                                    throw th;
                                                }
                                                try {
                                                    randomAccessFile.close();
                                                    throw th;
                                                } catch (java.lang.Throwable th8) {
                                                    android.ext.e1.l(str, th8);
                                                    throw th;
                                                }
                                            }
                                        } catch (java.io.IOException e3) {
                                            e = e3;
                                        } catch (java.lang.Throwable th9) {
                                            th2 = th9;
                                        }
                                    } else {
                                        int i2 = iD;
                                        long j8 = jD;
                                        randomAccessFile2.seek(j6 + 28);
                                        short sE2 = e(randomAccessFile2);
                                        short sE3 = e(randomAccessFile2);
                                        if (sE2 < 0 || sE3 < 0) {
                                            android.ext.e1.p("bad len for " + i + ": " + ((int) sE2) + str6 + ((int) sE3));
                                            try {
                                                randomAccessFile2.close();
                                                return;
                                            } catch (java.lang.Throwable th10) {
                                                android.ext.e1.l("ZipAlign close fail", th10);
                                                return;
                                            }
                                        }
                                        int i3 = sE2 + 46;
                                        byte[] bArr = new byte[i3];
                                        randomAccessFile2.seek(j6);
                                        java.lang.String str7 = str4;
                                        short s = sE;
                                        int i4 = 0;
                                        int i5 = 0;
                                        while (true) {
                                            if (i5 >= 10 || i4 >= i3) {
                                                break;
                                            }
                                            int i6 = randomAccessFile2.read(bArr, i4, i3 - i4);
                                            if (i6 < 0) {
                                                android.ext.e1.p("Failed read buf 1: " + i + "; " + i6 + ' ' + i4 + ' ' + i3);
                                                break;
                                            }
                                            i4 += i6;
                                            i5++;
                                        }
                                        if (i4 < i3) {
                                            android.ext.e1.p("Failed read buf 2: " + i + "; " + i4 + ' ' + i3);
                                        }
                                        bArr[30] = 0;
                                        bArr[31] = 0;
                                        byteArrayOutputStream.write(bArr);
                                        j6 += (long) (sE3 + i3);
                                        j7 += (long) i3;
                                        i++;
                                        str3 = str6;
                                        sE = s;
                                        str4 = str7;
                                        iD = i2;
                                        jD = j8;
                                        str5 = str5;
                                    }
                                }
                                java.lang.String str8 = str5;
                                java.lang.String str9 = str4;
                                int i7 = iD;
                                long j9 = jD;
                                if (j6 != j4) {
                                    android.ext.e1.p("Not all CD reads: " + j6 + " != " + j4 + str8 + j9 + str9 + i7);
                                    try {
                                        randomAccessFile2.close();
                                        return;
                                    } catch (java.lang.Throwable th11) {
                                        android.ext.e1.l("ZipAlign close fail", th11);
                                        return;
                                    }
                                }
                                if (j6 != j7) {
                                    byte[] bArr2 = new byte[22];
                                    randomAccessFile2.seek(j6);
                                    randomAccessFile2.read(bArr2);
                                    int i8 = (int) (j7 - j9);
                                    bArr2[12] = (byte) (i8 & 255);
                                    bArr2[13] = (byte) ((i8 >>> 8) & 255);
                                    bArr2[14] = (byte) ((i8 >>> 16) & 255);
                                    bArr2[15] = (byte) ((i8 >>> 24) & 255);
                                    byteArrayOutputStream.write(bArr2);
                                    long j10 = 22;
                                    j6 += j10;
                                    j = j7 + j10;
                                    if (j6 != j5) {
                                        android.ext.e1.p("Fail check end: " + j6 + " != " + j5);
                                        try {
                                            randomAccessFile2.close();
                                            return;
                                        } catch (java.lang.Throwable th12) {
                                            android.ext.e1.l("ZipAlign close fail", th12);
                                            return;
                                        }
                                    }
                                    if (j > j6) {
                                        android.ext.e1.p("Fail check new length: " + j + " > " + j6);
                                        try {
                                            randomAccessFile2.close();
                                            return;
                                        } catch (java.lang.Throwable th13) {
                                            android.ext.e1.l("ZipAlign close fail", th13);
                                            return;
                                        }
                                    }
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    if (j != ((long) byteArray.length) + j9) {
                                        android.ext.e1.p("Fail check buffer length: " + j + " != " + j9 + byteArray.length);
                                        try {
                                            randomAccessFile2.close();
                                            return;
                                        } catch (java.lang.Throwable th14) {
                                            android.ext.e1.l("ZipAlign close fail", th14);
                                            return;
                                        }
                                    }
                                    randomAccessFile2.seek(j9);
                                    z = true;
                                    try {
                                        randomAccessFile2.write(byteArray);
                                        randomAccessFile2.setLength(j);
                                    } catch (java.io.IOException e4) {
                                        e = e4;
                                        randomAccessFile = randomAccessFile2;
                                    }
                                } else {
                                    j = j7;
                                    z = false;
                                }
                                randomAccessFile2.close();
                                try {                                    if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }

                                    android.ext.e1.d("ZipAlign fix: " + j6 + " => " + j + " (" + (j6 - j) + ')');
                                    return;
                                } catch (java.io.IOException e5) {
                                    e = e5;
                                    randomAccessFile = null;
                                    android.ext.e1.l("ZipAlign fail", e);
                                    if (z) {
                                        throw e;
                                    }
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                            return;
                                        } catch (java.lang.Throwable th15) {
                                            android.ext.e1.l(str, th15);
                                            return;
                                        }
                                    }
                                    return;
                                }
                            } catch (java.lang.Throwable th16) {
                                android.ext.e1.s("ZipAlign failed alloc: " + (iD + 22), th16);
                                try {
                                    randomAccessFile2.close();
                                    return;
                                } catch (java.lang.Throwable th17) {
                                    android.ext.e1.l("ZipAlign close fail", th17);
                                    return;
                                }
                            }
                        } catch (java.io.IOException e6) {
                            e = e6;
                        }
                        randomAccessFile = randomAccessFile2;
                        z = false;
                        try {
                            android.ext.e1.l("ZipAlign fail", e);
                            if (z) {
                                throw e;
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                                return;
                            }
                            return;
                        } catch (java.lang.Throwable th18) {
                            th2 = th18;
                            th = th2;
                            if (randomAccessFile == null) {
                                throw th;
                            }
                            randomAccessFile.close();
                            throw th;
                        }
                    } catch (java.lang.Throwable th19) {
                        th = th19;
                        randomAccessFile = randomAccessFile2;
                    }
                } catch (java.io.IOException e7) {
                    e = e7;
                }
            } catch (java.io.IOException e8) {
                e = e8;
                z = false;
            }
        } catch (java.lang.Throwable th20) {
            th = th20;
            randomAccessFile = null;
        }
        if (randomAccessFile == null) {try {

            throw th;
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        }try {

        randomAccessFile.close();
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}try {

        throw th;
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }

    static boolean b(java.lang.String str) {
        return str != null && str.startsWith("lib/") && str.endsWith(".so") && str.lastIndexOf(47) > 4;
    }

    private static boolean c(long j) {
        return (j & 4095) == 0;
    }

    public static int d(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        int i = randomAccessFile.read();
        int i2 = randomAccessFile.read();
        int i3 = randomAccessFile.read();
        int i4 = randomAccessFile.read();
        if ((i | i2 | i3 | i4) >= 0) {
            return (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
        }
        throw new java.io.EOFException();
    }

    private static short e(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        int i = randomAccessFile.read();
        int i2 = randomAccessFile.read();
        if ((i | i2) >= 0) {
            return (short) ((i2 << 8) + i);
        }
        throw new java.io.EOFException();
    }

    public static void f(java.io.File file) {
java.lang.Throwable th = null;
        java.io.RandomAccessFile randomAccessFile = null;
        try {
            java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(file, "r");
            try {
                long length = randomAccessFile2.length();
                if (length < 22) {
                    throw new java.io.IOException("ZipAlign native-lib check: too small for a zip: " + length);
                }
                randomAccessFile2.seek(length - 12);
                short s = (short) 65535;
                int iE = e(randomAccessFile2) & 65535;
                int iD = d(randomAccessFile2);
                long jD = d(randomAccessFile2);
                if (iE <= 0 || iD <= 0 || jD <= 0) {
                    throw new java.io.IOException("ZipAlign native-lib check: unreadable central directory");
                }
                randomAccessFile2.seek(jD);
                int i = 0;
                int i2 = 0;
                while (i < iE) {
                    if (d(randomAccessFile2) != 33639248) {
                        throw new java.io.IOException("ZipAlign native-lib check: bad central-directory signature");
                    }
                    randomAccessFile2.skipBytes(6);
                    short sE = e(randomAccessFile2);
                    randomAccessFile2.skipBytes(16);
                    int iE2 = e(randomAccessFile2) & s;
                    int iE3 = e(randomAccessFile2) & s;
                    int iE4 = e(randomAccessFile2) & s;
                    randomAccessFile2.skipBytes(8);
                    long jD2 = ((long) d(randomAccessFile2)) & 4294967295L;
                    byte[] bArr = new byte[iE2];
                    randomAccessFile2.readFully(bArr);
                    java.lang.String str = new java.lang.String(bArr, "UTF-8");
                    long filePointer = ((long) iE4) + randomAccessFile2.getFilePointer() + ((long) iE3);
                    if (b(str)) {
                        randomAccessFile2.seek(jD2 + 26);
                        int i3 = i2;
                        long jE = jD2 + 30 + ((long) (e(randomAccessFile2) & 65535)) + ((long) (e(randomAccessFile2) & 65535));
                        if (sE != 0) {
                            android.ext.e1.i("ZipAlign native-lib check: " + str + " is compressed (method " + ((int) sE) + ")");
                            throw new java.io.IOException("ZipAlign native-lib check failed: " + str + " is compressed");
                        }
                        if (!c(jE)) {
                            android.ext.e1.i("ZipAlign native-lib check: " + str + " data offset " + jE + " is not page-aligned");
                            throw new java.io.IOException("ZipAlign native-lib check failed: " + str + " is not page-aligned");
                        }
                        i2 = i3 + 1;
                    }
                    randomAccessFile2.seek(filePointer);
                    i++;
                    s = (short) 65535;
                }
                android.ext.e1.d("ZipAlign native-lib check: " + i2 + " lib entries ok");
                try {
                    randomAccessFile2.close();
                } catch (java.lang.Throwable th_c) {
                    android.ext.e1.l("ZipAlign close fail", th_c);
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                randomAccessFile = randomAccessFile2;
                java.lang.Throwable th3 = th;
                if (randomAccessFile == null) {
                    throw th3;
                }
                try {
                    randomAccessFile.close();
                    throw th3;
                } catch (java.lang.Throwable th4) {
                    android.ext.e1.l("ZipAlign close fail", th4);
                    throw th3;
                }
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
        }
    }
}
