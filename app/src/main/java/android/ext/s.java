package android.ext;

/* JADX INFO: loaded from: classes.dex */
abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.nio.charset.Charset f1236a = java.nio.charset.Charset.forName("UTF-16LE");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final java.nio.charset.Charset f1237b = java.nio.charset.Charset.forName("UTF-8");

    private static java.lang.String a(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (!z) {
            int i4 = (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
            if ((32768 & i4) != 0) {
                i4 = ((i4 & 32767) << 16) | (bArr[i + 2] & 255) | ((bArr[i + 3] & 255) << 8);
                i3 = 4;
            } else {
                i3 = 2;
            }
            return new java.lang.String(bArr, i + i3, i4 * 2, h());
        }
        int i5 = i + 1;
        if ((bArr[i] & 128) != 0) {
            byte b2 = bArr[i5];
            i5 = i + 2;
        }
        int i6 = i5 + 1;
        byte b3 = bArr[i5];
        int i7 = b3 & 255;
        if ((b3 & 128) != 0) {
            i7 = ((b3 & 127) << 8) | (bArr[i6] & 255);
            i6 = i5 + 2;
        }
        return new java.lang.String(bArr, i6, i7, i());
    }

    private static byte[] b(java.lang.String str, boolean z) throws java.io.IOException {
        if (!z) {
            if (str.length() > 32767) {
                throw new java.io.IOException("replacement string too long");
            }
            byte[] bytes = str.getBytes(h());
            int length = str.length();
            byte[] bArr = new byte[bytes.length + 4];
            bArr[0] = (byte) length;
            bArr[1] = (byte) (length >> 8);
            java.lang.System.arraycopy(bytes, 0, bArr, 2, bytes.length);
            return bArr;
        }
        byte[] bytes2 = str.getBytes(i());
        int length2 = str.length();
        if (length2 >= 128 || bytes2.length >= 128) {
            throw new java.io.IOException("replacement string too long");
        }
        int length3 = bytes2.length;
        byte[] bArr2 = new byte[length3 + 3];
        bArr2[0] = (byte) length2;
        bArr2[1] = (byte) bytes2.length;
        java.lang.System.arraycopy(bytes2, 0, bArr2, 2, bytes2.length);
        bArr2[length3 + 2] = 0;
        return bArr2;
    }

    private static int c(byte[] bArr, byte[] bArr2, int i) {
        for (int iMax = java.lang.Math.max(0, i); iMax <= bArr.length - bArr2.length; iMax++) {
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                if (bArr[iMax + i2] != bArr2[i2]) {
                }
            }
            return iMax;
        }
        return -1;
    }

    static byte[] d(byte[] bArr, byte[] bArr2, byte[] bArr3, java.lang.String str) throws java.io.IOException {
        if (bArr == null || bArr2 == null || bArr3 == null) {
            throw new java.io.IOException(str + ": null input");
        }
        if (bArr2.length == 0 || bArr2.length != bArr3.length) {
            throw new java.io.IOException(str + ": replacement length must equal the pattern length");
        }
        int iC = c(bArr, bArr2, 0);
        if (iC < 0) {
            throw new java.io.IOException(str + ": expected byte pattern not found");
        }
        if (c(bArr, bArr2, iC + 1) < 0) {
            byte[] bArr4 = (byte[]) bArr.clone();
            java.lang.System.arraycopy(bArr3, 0, bArr4, iC, bArr3.length);
            return bArr4;
        }
        throw new java.io.IOException(str + ": expected byte pattern appears more than once");
    }

    static byte[] e(byte[] bArr, java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.io.IOException {
        int i;
        int i2;
        byte[] bArrCopyOfRange;
        if (bArr == null) {
            throw new java.io.IOException(str3 + ": binary XML is null");
        }
        if (str == null || str2 == null) {
            throw new java.io.IOException(str3 + ": expected/replacement strings are null");
        }
        if (str.isEmpty()) {
            throw new java.io.IOException(str3 + ": expected string is empty");
        }
        if (bArr.length < 36) {
            throw new java.io.IOException(str3 + ": binary XML too small for a root + string pool header");
        }
        if (bArr.length > 1048576) {
            throw new java.io.IOException(str3 + ": binary XML unreasonably large");
        }
        java.nio.ByteBuffer byteBufferOrder = java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.LITTLE_ENDIAN);
        int i3 = byteBufferOrder.getShort(0) & 65535;
        int i4 = byteBufferOrder.getShort(2) & 65535;
        int i5 = byteBufferOrder.getInt(4);
        if (i3 != 3) {
            throw new java.io.IOException(str3 + ": root chunk type is not RES_XML_TYPE");
        }
        if (i4 != 8) {
            throw new java.io.IOException(str3 + ": root chunk header size is not 8");
        }
        if (i5 < 8 || i5 != bArr.length || i5 % 4 != 0) {
            throw new java.io.IOException(str3 + ": root chunk size does not match the document");
        }
        int i6 = byteBufferOrder.getShort(8) & 65535;
        int i7 = byteBufferOrder.getShort(10) & 65535;
        int i8 = byteBufferOrder.getInt(12);
        if (i6 != 1) {
            throw new java.io.IOException(str3 + ": chunk after the root header is not a string pool");
        }
        if (i7 < 28) {
            throw new java.io.IOException(str3 + ": string pool header size is too small");
        }
        if (i8 >= i7 && i8 % 4 == 0) {
            long j = i8;
            long j2 = j + 8;
            if (j2 <= bArr.length) {
                int i9 = byteBufferOrder.getInt(16);
                int i10 = byteBufferOrder.getInt(20);
                int i11 = byteBufferOrder.getInt(24);
                int i12 = byteBufferOrder.getInt(28);
                int i13 = byteBufferOrder.getInt(32);
                boolean z = (i11 & 256) != 0;
                if (i9 < 1 || i9 > 65536) {
                    throw new java.io.IOException(str3 + ": string count is out of bounds");
                }
                if (i10 < 0 || i10 > 4096) {
                    throw new java.io.IOException(str3 + ": style count is out of bounds");
                }
                if (i12 % 4 == 0 && i12 >= i7) {
                    long j3 = i12;
                    if (j3 + 8 <= j2) {
                        if (i10 > 0 && (i13 % 4 != 0 || i13 <= i12 || ((long) i13) + 8 > j2)) {
                            throw new java.io.IOException(str3 + ": stylesStart is not a 4-aligned offset after the strings");
                        }
                        if (((long) i7) + (((long) (i9 + i10)) * 4) > j3) {
                            throw new java.io.IOException(str3 + ": string offsets overlap the string data");
                        }
                        int[] iArr = new int[i9];
                        int i14 = 0;
                        while (i14 < i9) {
                            int i15 = byteBufferOrder.getInt(i7 + 8 + (i14 * 4));
                            iArr[i14] = i15;
                            if (i15 >= 0) {
                                int i16 = i12;
                                int i17 = i9;
                                if (((long) i15) + j3 < j) {
                                    if (i14 > 0 && i15 < iArr[i14 - 1]) {
                                        throw new java.io.IOException(str3 + ": string offsets are not non-decreasing");
                                    }
                                    i14++;
                                    i9 = i17;
                                    i12 = i16;
                                }
                            }
                            throw new java.io.IOException(str3 + ": string offset " + i14 + " is outside the string data");
                        }
                        int i18 = i12;
                        int i19 = i9;
                        if (iArr[0] != 0) {
                            throw new java.io.IOException(str3 + ": first string offset is not zero");
                        }
                        if (i10 > 0) {
                            int i20 = i8 - i13;
                            int i21 = 0;
                            while (i21 < i10) {
                                int i22 = i7 + 8;
                                int i23 = i19 + i21;
                                int i24 = byteBufferOrder.getInt((i23 * 4) + i22);
                                if (i24 >= 0) {
                                    int i25 = i19;
                                    if (((long) i24) + 8 <= i20) {
                                        if (i21 > 0 && i24 < byteBufferOrder.getInt(i22 + ((i23 - 1) * 4))) {
                                            throw new java.io.IOException(str3 + ": style offsets are not non-decreasing");
                                        }
                                        i21++;
                                        i19 = i25;
                                    }
                                }
                                throw new java.io.IOException(str3 + ": style offset " + i21 + " is outside the style data");
                            }
                        }
                        int i26 = i19;
                        int i27 = i8 + 8;
                        int i28 = i27;
                        while (i28 < bArr.length) {
                            if (i28 + 8 > bArr.length) {
                                throw new java.io.IOException(str3 + ": trailing chunk header truncated at " + i28);
                            }
                            int i29 = byteBufferOrder.getShort(i28 + 2) & 65535;
                            int i30 = byteBufferOrder.getInt(i28 + 4);
                            if (i29 < 8 || i30 < i29 || ((long) i28) + ((long) i30) > bArr.length) {
                                throw new java.io.IOException(str3 + ": trailing chunk at " + i28 + " is invalid");
                            }
                            i28 += i30;
                        }
                        int i31 = i18 + 8;
                        int i32 = (i10 > 0 ? i13 + 8 : i27) - i31;
                        int i33 = i26;
                        int[] iArr2 = new int[i33];
                        int i34 = 0;
                        while (i34 < i33) {
                            int i35 = iArr[i34];
                            int i36 = i34 + 1;
                            int i37 = i36 < i33 ? iArr[i36] : i32;
                            if (i37 <= i35) {
                                throw new java.io.IOException(str3 + ": string " + i34 + " has an empty region");
                            }
                            int i38 = i32;
                            int iG = z ? g(bArr, i31 + i35, i37 - i35) : f(bArr, i31 + i35, i37 - i35);
                            iArr2[i34] = iG;
                            if (iG <= 0) {
                                throw new java.io.IOException(str3 + ": string " + i34 + " is malformed or truncated");
                            }
                            int i39 = i37 - i35;
                            if (i36 < i33) {
                                if (iG != i39) {
                                    throw new java.io.IOException(str3 + ": string " + i34 + " does not tile up to the next offset");
                                }
                            } else if (iG > i39 || i39 - iG >= 4) {
                                throw new java.io.IOException(str3 + ": trailing padding after the last string is invalid");
                            }
                            i34 = i36;
                            i32 = i38;
                            i27 = i27;
                        }
                        int i40 = i27;
                        int i41 = 0;
                        int i42 = 0;
                        while (i41 < i33) {
                            boolean z2 = z;
                            if (str.equals(a(bArr, iArr[i41] + i31, iArr2[i41], z2))) {
                                i42++;
                            }
                            i41++;
                            z = z2;
                        }
                        boolean z3 = z;
                        if (i42 == 0) {
                            throw new java.io.IOException(str3 + ": expected string not found in the string pool");
                        }
                        if (i42 > 1) {
                            throw new java.io.IOException(str3 + ": expected string appears more than once in the string pool");
                        }
                        byte[] bArrB = b(str2, z3);
                        int i43 = 0;
                        while (true) {
                            if (i43 >= i33) {
                                i43 = -1;
                                break;
                            }
                            if (str.equals(a(bArr, iArr[i43] + i31, iArr2[i43], z3))) {
                                break;
                            }
                            i43++;
                        }
                        int length = bArrB.length - iArr2[i43];
                        int i44 = i33 - 1;
                        int i45 = i18 + iArr[i44] + iArr2[i44] + length;
                        int i46 = (4 - (i45 % 4)) % 4;
                        if (i10 > 0) {
                            i2 = i45 + i46;
                            i = (i8 - i13) + i2;
                        } else {
                            i = i45 + i46;
                            i2 = 0;
                        }
                        int i47 = i - i8;
                        byte[] bArr2 = new byte[bArr.length + i47];
                        java.lang.System.arraycopy(bArr, 0, bArr2, 0, i31);
                        java.nio.ByteBuffer byteBufferOrder2 = java.nio.ByteBuffer.wrap(bArr2).order(java.nio.ByteOrder.LITTLE_ENDIAN);
                        int i48 = i;
                        int length2 = 0;
                        int i49 = 0;
                        while (i49 < i33) {
                            if (i49 == i43) {
                                bArrCopyOfRange = bArrB;
                            } else {
                                int i50 = iArr[i49];
                                bArrCopyOfRange = java.util.Arrays.copyOfRange(bArr, i31 + i50, i31 + i50 + iArr2[i49]);
                            }
                            if (i49 > i43) {
                                iArr[i49] = iArr[i49] + length;
                            }
                            byteBufferOrder2.putInt(i7 + 8 + (i49 * 4), length2);
                            java.lang.System.arraycopy(bArrCopyOfRange, 0, bArr2, i31 + length2, bArrCopyOfRange.length);
                            length2 += bArrCopyOfRange.length;
                            i49++;
                            i43 = i43;
                            length = length;
                            iArr2 = iArr2;
                            i33 = i33;
                        }
                        for (int i51 = 0; i51 < i46; i51++) {
                            bArr2[i31 + length2 + i51] = 0;
                        }
                        int i52 = length2 + i46;
                        if (i10 > 0) {
                            java.lang.System.arraycopy(bArr, i13 + 8, bArr2, i31 + i52, i8 - i13);
                            byteBufferOrder2.putInt(32, i2);
                        }
                        byteBufferOrder2.putInt(12, i48);
                        byteBufferOrder2.putInt(24, i11 & (-2));
                        byteBufferOrder2.putInt(4, i5 + i47);
                        java.lang.System.arraycopy(bArr, i40, bArr2, i48 + 8, bArr.length - i40);
                        return bArr2;
                    }
                }
                throw new java.io.IOException(str3 + ": stringsStart is not a 4-aligned offset inside the pool");
            }
        }
        throw new java.io.IOException(str3 + ": string pool size is not a valid chunk");
    }

    private static int f(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = 4;
        if (i2 < 4) {
            return 0;
        }
        java.nio.ByteBuffer byteBufferOrder = java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.LITTLE_ENDIAN);
        int i5 = byteBufferOrder.getChar(i);
        if ((32768 & i5) == 0) {
            i4 = 2;
        } else {
            if (i2 < 6) {
                return 0;
            }
            i5 = ((i5 & 32767) << 16) | byteBufferOrder.getChar(i + 2);
        }
        if (i5 <= 32767 && (i3 = i4 + (i5 * 2) + 2) <= i2) {
            int i6 = i + i3;
            if (bArr[i6 - 2] == 0 && bArr[i6 - 1] == 0) {
                return i3;
            }
        }
        return 0;
    }

    private static int g(byte[] bArr, int i, int i2) {
        int i3 = i + i2;
        if (i3 - i < 3) {
            return 0;
        }
        int i4 = i + 1;
        byte b2 = bArr[i];
        int i5 = b2 & 255;
        if ((b2 & 128) != 0) {
            if (i4 >= i3) {
                return 0;
            }
            i5 = (bArr[i4] & 255) | ((b2 & 127) << 8);
            i4 = i + 2;
        }
        if (i5 > 32767) {
            return 0;
        }
        int i6 = i4 + 1;
        int i7 = bArr[i4];
        int i8 = i7 & 255;
        if ((i7 & 128) != 0) {
            if (i6 >= i3) {
                return 0;
            }
            i8 = ((i7 & 127) << 8) | (bArr[i6] & 255);
            i6 = i4 + 2;
        }
        int i9 = (i6 - i) + i8 + 1;
        if (i9 <= i2 && bArr[(i + i9) - 1] == 0) {
            return i9;
        }
        return 0;
    }

    private static java.nio.charset.Charset h() {
        return f1236a;
    }

    private static java.nio.charset.Charset i() {
        return f1237b;
    }
}
