package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzip extends zzik {
    zzip() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008b, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.measurement.zzik
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zza(int r16, byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzip.zza(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.measurement.zzik
    final String zzb(byte[] bArr, int i, int i2) throws zzft {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte bZza = zzig.zza(bArr, i);
            if (!zzil.zzd(bZza)) {
                break;
            }
            i++;
            zzil.zzb(bZza, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte bZza2 = zzig.zza(bArr, i);
            if (zzil.zzd(bZza2)) {
                int i7 = i5 + 1;
                zzil.zzb(bZza2, cArr, i5);
                while (i6 < i3) {
                    byte bZza3 = zzig.zza(bArr, i6);
                    if (!zzil.zzd(bZza3)) {
                        break;
                    }
                    i6++;
                    zzil.zzb(bZza3, cArr, i7);
                    i7++;
                }
                i = i6;
                i5 = i7;
            } else if (zzil.zze(bZza2)) {
                if (i6 < i3) {
                    zzil.zzb(bZza2, zzig.zza(bArr, i6), cArr, i5);
                    i = i6 + 1;
                    i5++;
                } else {
                    throw zzft.zzh();
                }
            } else if (zzil.zzf(bZza2)) {
                if (i6 < i3 - 1) {
                    int i8 = i6 + 1;
                    zzil.zzb(bZza2, zzig.zza(bArr, i6), zzig.zza(bArr, i8), cArr, i5);
                    i = i8 + 1;
                    i5++;
                } else {
                    throw zzft.zzh();
                }
            } else {
                if (i6 >= i3 - 2) {
                    throw zzft.zzh();
                }
                int i9 = i6 + 1;
                byte bZza4 = zzig.zza(bArr, i6);
                int i10 = i9 + 1;
                zzil.zzb(bZza2, bZza4, zzig.zza(bArr, i9), zzig.zza(bArr, i10), cArr, i5);
                i = i10 + 1;
                i5 = i5 + 1 + 1;
            }
        }
        return new String(cArr, 0, i5);
    }

    @Override // com.google.android.gms.internal.measurement.zzik
    final int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char c;
        long j;
        long j2;
        long j3;
        int i3;
        char cCharAt;
        long j4 = i;
        long j5 = ((long) i2) + j4;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char cCharAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(cCharAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            c = 128;
            j = 1;
            if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            zzig.zza(bArr, j4, (byte) cCharAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char cCharAt3 = charSequence.charAt(i4);
            if (cCharAt3 >= c || j4 >= j5) {
                if (cCharAt3 < 2048 && j4 <= j5 - 2) {
                    long j6 = j4 + j;
                    zzig.zza(bArr, j4, (byte) ((cCharAt3 >>> 6) | 960));
                    zzig.zza(bArr, j6, (byte) ((cCharAt3 & '?') | 128));
                    j2 = j6 + j;
                    j3 = j;
                } else {
                    if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || j4 > j5 - 3) {
                        if (j4 <= j5 - 4) {
                            int i5 = i4 + 1;
                            if (i5 != length) {
                                char cCharAt4 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                    int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                    long j7 = j4 + 1;
                                    zzig.zza(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                    long j8 = j7 + 1;
                                    zzig.zza(bArr, j7, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j9 = j8 + 1;
                                    zzig.zza(bArr, j8, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j3 = 1;
                                    j2 = j9 + 1;
                                    zzig.zza(bArr, j9, (byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                } else {
                                    i4 = i5;
                                }
                            }
                            throw new zzim(i4 - 1, length);
                        }
                        if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt3, charSequence.charAt(i3)))) {
                            throw new zzim(i4, length);
                        }
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(cCharAt3);
                        sb2.append(" at index ");
                        sb2.append(j4);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    long j10 = j4 + j;
                    zzig.zza(bArr, j4, (byte) ((cCharAt3 >>> '\f') | 480));
                    long j11 = j10 + j;
                    zzig.zza(bArr, j10, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                    zzig.zza(bArr, j11, (byte) ((cCharAt3 & '?') | 128));
                    j2 = j11 + 1;
                    j3 = 1;
                }
                i4++;
                c = 128;
                long j12 = j3;
                j4 = j2;
                j = j12;
            } else {
                long j13 = j4 + j;
                zzig.zza(bArr, j4, (byte) cCharAt3);
                j3 = j;
                j2 = j13;
            }
            i4++;
            c = 128;
            long j122 = j3;
            j4 = j2;
            j = j122;
        }
        return (int) j4;
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zzij.zzb(i);
        }
        if (i2 == 1) {
            return zzij.zzb(i, zzig.zza(bArr, j));
        }
        if (i2 == 2) {
            return zzij.zzb(i, zzig.zza(bArr, j), zzig.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }
}
