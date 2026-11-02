package android.ext;

/* JADX INFO: loaded from: classes.dex */
abstract class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f1069a = j(2000, 0, 1, 0, 0, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f1070b = j(2099, 11, 31, 23, 59, 59);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f1071c = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    private static void a(java.security.cert.X509Certificate x509Certificate) throws java.security.GeneralSecurityException {
        java.lang.String sigAlgOID = x509Certificate.getSigAlgOID();
        java.lang.String sigAlgName = x509Certificate.getSigAlgName();
        if ("1.2.840.113549.1.1.11".equals(sigAlgOID) || "SHA256WITHRSA".equals(d(sigAlgName))) {
            return;
        }
        throw new java.security.GeneralSecurityException("unexpected signature algorithm: " + sigAlgOID + " / " + sigAlgName);
    }

    private static byte[] b(byte[]... bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        byte[] bArr3 = new byte[length];
        int length2 = 0;
        for (byte[] bArr4 : bArr) {
            java.lang.System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
            length2 += bArr4.length;
        }
        return bArr3;
    }

    private static boolean c(byte[] bArr) {
        for (byte b2 : bArr) {
            if (b2 != 0) {
                return false;
            }
        }
        return true;
    }

    static java.lang.String d(java.lang.String str) {
        if (str == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (java.lang.Character.isLetterOrDigit(cCharAt)) {
                sb.append(java.lang.Character.toUpperCase(cCharAt));
            }
        }
        return sb.toString();
    }

    private static void e(byte[] bArr, java.security.interfaces.RSAPublicKey rSAPublicKey, byte[] bArr2, java.lang.String str) throws java.security.GeneralSecurityException {
        java.security.cert.CertificateFactory certificateFactory = java.security.cert.CertificateFactory.getInstance("X.509");
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        try {
            java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
            if (byteArrayInputStream.available() != 0) {
                throw new java.security.GeneralSecurityException("certificate has trailing bytes: " + byteArrayInputStream.available());
            }
            if (x509Certificate.getVersion() != 3) {
                throw new java.security.GeneralSecurityException("certificate is not v3: " + x509Certificate.getVersion());
            }
            if (!x509Certificate.getIssuerX500Principal().equals(x509Certificate.getSubjectX500Principal()) || !java.util.Arrays.equals(x509Certificate.getIssuerX500Principal().getEncoded(), x509Certificate.getSubjectX500Principal().getEncoded())) {
                throw new java.security.GeneralSecurityException("issuer and subject differ");
            }
            if (!x509Certificate.getSerialNumber().equals(new java.math.BigInteger(1, bArr2))) {
                throw new java.security.GeneralSecurityException("serial mismatch");
            }
            if (!java.util.Arrays.equals(x509Certificate.getPublicKey().getEncoded(), rSAPublicKey.getEncoded())) {
                throw new java.security.GeneralSecurityException("public key mismatch");
            }
            a(x509Certificate);
            if (x509Certificate.getNotBefore().getTime() == f1069a && x509Certificate.getNotAfter().getTime() == f1070b) {
                if (!str.equals(f(bArr))) {
                    throw new java.security.GeneralSecurityException("certificate digest mismatch");
                }
                x509Certificate.verify(rSAPublicKey);
            } else {
                throw new java.security.GeneralSecurityException("validity mismatch: " + x509Certificate.getNotBefore().getTime() + " / " + x509Certificate.getNotAfter().getTime());
            }
        } catch (java.lang.ClassCastException e2) {
            throw new java.security.GeneralSecurityException("generated certificate is not X.509", e2);
        }
    }

    private static java.lang.String f(byte[] bArr) {try {

        return i(java.security.MessageDigest.getInstance("SHA-256").digest(bArr));
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
    }

    static android.ext.m0$b g(byte[] bArr) throws java.security.GeneralSecurityException, java.io.IOException {
        if (bArr == null) {
            throw new java.security.GeneralSecurityException("missing CERT.SF bytes");
        }
        java.security.SecureRandom secureRandom = new java.security.SecureRandom();
        java.security.KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(new java.security.spec.RSAKeyGenParameterSpec(2048, java.security.spec.RSAKeyGenParameterSpec.F4), secureRandom);
        java.security.KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        if (!(keyPairGenerateKeyPair.getPublic() instanceof java.security.interfaces.RSAPublicKey)) {
            throw new java.security.GeneralSecurityException("RSA key generator returned a non-RSA public key");
        }
        java.security.interfaces.RSAPublicKey rSAPublicKey = (java.security.interfaces.RSAPublicKey) keyPairGenerateKeyPair.getPublic();
        if (rSAPublicKey.getModulus().bitLength() != 2048 || rSAPublicKey.getPublicExponent().intValue() != 65537) {
            throw new java.security.GeneralSecurityException("unexpected RSA profile: " + rSAPublicKey.getModulus().bitLength() + " bits, exponent " + rSAPublicKey.getPublicExponent());
        }
        byte[] bArr2 = new byte[16];
        do {
            secureRandom.nextBytes(bArr2);
        } while (c(bArr2));
        byte[] bArr3 = new byte[16];
        secureRandom.nextBytes(bArr3);
        java.lang.String strI = i(bArr3);
        byte[] bArrI = android.ext.m0$a.i(b(android.ext.m0$a.h("1.2.840.113549.1.1.11"), android.ext.m0$a.f()));
        byte[] bArrI2 = android.ext.m0$a.i(b(android.ext.m0$a.h("2.16.840.1.101.3.4.2.1"), android.ext.m0$a.f()));
        byte[] bArrI3 = android.ext.m0$a.i(b(android.ext.m0$a.h("1.2.840.113549.1.1.1"), android.ext.m0$a.f()));
        byte[] bArrE = android.ext.m0$a.e(bArr2);
        byte[] bArrI4 = android.ext.m0$a.i(android.ext.m0$a.j(android.ext.m0$a.i(b(android.ext.m0$a.h("2.5.4.3"), android.ext.m0$a.m(strI)))));
        byte[] bArrI5 = android.ext.m0$a.i(b(android.ext.m0$a.b(0, android.ext.m0$a.e(new byte[]{2})), bArrE, bArrI, bArrI4, android.ext.m0$a.i(b(android.ext.m0$a.l("000101000000Z"), android.ext.m0$a.d("20991231235959Z"))), bArrI4, rSAPublicKey.getEncoded()));
        java.security.Signature signature = java.security.Signature.getInstance("SHA256withRSA");
        signature.initSign(keyPairGenerateKeyPair.getPrivate());
        signature.update(bArrI5);
        byte[] bArrI6 = android.ext.m0$a.i(b(bArrI5, bArrI, android.ext.m0$a.a(signature.sign(), 0)));
        java.security.Signature signature2 = java.security.Signature.getInstance("SHA256withRSA");
        signature2.initSign(keyPairGenerateKeyPair.getPrivate());
        signature2.update(bArr);
        byte[] bArrSign = signature2.sign();
        long length = bArrI6.length;
        if (length >= 65536) {
            throw new java.io.IOException("certificate too large: " + length);
        }
        byte[] bArrI7 = android.ext.m0$a.i(b(android.ext.m0$a.h("1.2.840.113549.1.7.2"), android.ext.m0$a.b(0, android.ext.m0$a.i(b(android.ext.m0$a.e(new byte[]{1}), android.ext.m0$a.j(bArrI2), android.ext.m0$a.i(android.ext.m0$a.h("1.2.840.113549.1.7.1")), android.ext.m0$a.c(0, bArrI6), android.ext.m0$a.j(android.ext.m0$a.i(b(android.ext.m0$a.e(new byte[]{1}), android.ext.m0$a.i(b(bArrI4, bArrE)), bArrI2, bArrI3, android.ext.m0$a.g(bArrSign)))))))));
        if (bArrI7.length < 65536) {
            java.lang.String strF = f(bArrI6);
            e(bArrI6, rSAPublicKey, bArr2, strF);
            return new android.ext.m0$b(bArrI7, strF);
        }
        throw new java.io.IOException("CERT.RSA too large: " + bArrI7.length);
    }

    static java.lang.String h(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(((bArr.length + 2) / 3) * 4);
        int i = 0;
        while (true) {
            int i2 = i + 2;
            if (i2 >= bArr.length) {
                break;
            }
            int i3 = (bArr[i2] & 255) | ((bArr[i] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
            char[] cArr = f1071c;
            sb.append(cArr[(i3 >>> 18) & 63]);
            sb.append(cArr[(i3 >>> 12) & 63]);
            sb.append(cArr[(i3 >>> 6) & 63]);
            sb.append(cArr[i3 & 63]);
            i += 3;
        }
        int length = bArr.length - i;
        if (length == 1) {
            int i4 = (bArr[i] & 255) << 16;
            char[] cArr2 = f1071c;
            sb.append(cArr2[(i4 >>> 18) & 63]);
            sb.append(cArr2[(i4 >>> 12) & 63]);
            sb.append("==");
        } else if (length == 2) {
            int i5 = ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << 16);
            char[] cArr3 = f1071c;
            sb.append(cArr3[(i5 >>> 18) & 63]);
            sb.append(cArr3[(i5 >>> 12) & 63]);
            sb.append(cArr3[(i5 >>> 6) & 63]);
            sb.append('=');
        }
        return sb.toString();
    }

    static java.lang.String i(byte[] bArr) {
        char[] charArray = "0123456789abcdef".toCharArray();
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i2 = i * 2;
            cArr[i2] = charArray[(b2 & 255) >>> 4];
            cArr[i2 + 1] = charArray[b2 & 15];
        }
        return new java.lang.String(cArr);
    }

    private static long j(int i, int i2, int i3, int i4, int i5, int i6) {
        java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar(java.util.TimeZone.getTimeZone("UTC"));
        gregorianCalendar.clear();
        gregorianCalendar.set(i, i2, i3, i4, i5, i6);
        return gregorianCalendar.getTimeInMillis();
    }
}
