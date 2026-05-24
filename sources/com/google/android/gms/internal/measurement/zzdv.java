package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzdv {
    static int zza(byte[] bArr, int i, zzdy zzdyVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza(b, bArr, i2, zzdyVar);
        }
        zzdyVar.zza = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzdy zzdyVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzdyVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzdyVar.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzdyVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzdyVar.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzdyVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zzdy zzdyVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzdyVar.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & 127)) << i4;
            b = b2;
            i3 = i5;
        }
        zzdyVar.zzb = j2;
        return i3;
    }

    static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static long zzb(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    static int zzc(byte[] bArr, int i, zzdy zzdyVar) throws zzft {
        int iZza = zza(bArr, i, zzdyVar);
        int i2 = zzdyVar.zza;
        if (i2 < 0) {
            throw zzft.zzb();
        }
        if (i2 == 0) {
            zzdyVar.zzc = "";
            return iZza;
        }
        zzdyVar.zzc = new String(bArr, iZza, i2, zzfk.zza);
        return iZza + i2;
    }

    static int zzd(byte[] bArr, int i, zzdy zzdyVar) throws zzft {
        int iZza = zza(bArr, i, zzdyVar);
        int i2 = zzdyVar.zza;
        if (i2 < 0) {
            throw zzft.zzb();
        }
        if (i2 == 0) {
            zzdyVar.zzc = "";
            return iZza;
        }
        zzdyVar.zzc = zzij.zzb(bArr, iZza, i2);
        return iZza + i2;
    }

    static int zze(byte[] bArr, int i, zzdy zzdyVar) throws zzft {
        int iZza = zza(bArr, i, zzdyVar);
        int i2 = zzdyVar.zza;
        if (i2 < 0) {
            throw zzft.zzb();
        }
        if (i2 > bArr.length - iZza) {
            throw zzft.zza();
        }
        if (i2 == 0) {
            zzdyVar.zzc = zzdz.zza;
            return iZza;
        }
        zzdyVar.zzc = zzdz.zza(bArr, iZza, i2);
        return iZza + i2;
    }

    static int zza(zzhi zzhiVar, byte[] bArr, int i, int i2, zzdy zzdyVar) throws IOException {
        int iZza = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZza = zza(i3, bArr, iZza, zzdyVar);
            i3 = zzdyVar.zza;
        }
        int i4 = iZza;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzft.zza();
        }
        Object objZza = zzhiVar.zza();
        int i5 = i3 + i4;
        zzhiVar.zza(objZza, bArr, i4, i5, zzdyVar);
        zzhiVar.zzc(objZza);
        zzdyVar.zzc = objZza;
        return i5;
    }

    static int zza(zzhi zzhiVar, byte[] bArr, int i, int i2, int i3, zzdy zzdyVar) throws IOException {
        zzgx zzgxVar = (zzgx) zzhiVar;
        Object objZza = zzgxVar.zza();
        int iZza = zzgxVar.zza(objZza, bArr, i, i2, i3, zzdyVar);
        zzgxVar.zzc(objZza);
        zzdyVar.zzc = objZza;
        return iZza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzfq<?> zzfqVar, zzdy zzdyVar) {
        zzfl zzflVar = (zzfl) zzfqVar;
        int iZza = zza(bArr, i2, zzdyVar);
        zzflVar.zzd(zzdyVar.zza);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzdyVar);
            if (i != zzdyVar.zza) {
                break;
            }
            iZza = zza(bArr, iZza2, zzdyVar);
            zzflVar.zzd(zzdyVar.zza);
        }
        return iZza;
    }

    static int zza(byte[] bArr, int i, zzfq<?> zzfqVar, zzdy zzdyVar) throws IOException {
        zzfl zzflVar = (zzfl) zzfqVar;
        int iZza = zza(bArr, i, zzdyVar);
        int i2 = zzdyVar.zza + iZza;
        while (iZza < i2) {
            iZza = zza(bArr, iZza, zzdyVar);
            zzflVar.zzd(zzdyVar.zza);
        }
        if (iZza == i2) {
            return iZza;
        }
        throw zzft.zza();
    }

    static int zza(zzhi<?> zzhiVar, int i, byte[] bArr, int i2, int i3, zzfq<?> zzfqVar, zzdy zzdyVar) throws IOException {
        int iZza = zza(zzhiVar, bArr, i2, i3, zzdyVar);
        zzfqVar.add(zzdyVar.zzc);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzdyVar);
            if (i != zzdyVar.zza) {
                break;
            }
            iZza = zza(zzhiVar, bArr, iZza2, i3, zzdyVar);
            zzfqVar.add(zzdyVar.zzc);
        }
        return iZza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzid zzidVar, zzdy zzdyVar) throws zzft {
        if ((i >>> 3) == 0) {
            throw zzft.zzd();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzb = zzb(bArr, i2, zzdyVar);
            zzidVar.zza(i, Long.valueOf(zzdyVar.zzb));
            return iZzb;
        }
        if (i4 == 1) {
            zzidVar.zza(i, Long.valueOf(zzb(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZza = zza(bArr, i2, zzdyVar);
            int i5 = zzdyVar.zza;
            if (i5 < 0) {
                throw zzft.zzb();
            }
            if (i5 > bArr.length - iZza) {
                throw zzft.zza();
            }
            if (i5 == 0) {
                zzidVar.zza(i, zzdz.zza);
            } else {
                zzidVar.zza(i, zzdz.zza(bArr, iZza, i5));
            }
            return iZza + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzidVar.zza(i, Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            }
            throw zzft.zzd();
        }
        zzid zzidVarZzb = zzid.zzb();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZza2 = zza(bArr, i2, zzdyVar);
            int i8 = zzdyVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = iZza2;
                break;
            }
            int iZza3 = zza(i7, bArr, iZza2, i3, zzidVarZzb, zzdyVar);
            i7 = i8;
            i2 = iZza3;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzft.zzg();
        }
        zzidVar.zza(i, zzidVarZzb);
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzdy zzdyVar) throws zzft {
        if ((i >>> 3) == 0) {
            throw zzft.zzd();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzb(bArr, i2, zzdyVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zza(bArr, i2, zzdyVar) + zzdyVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzft.zzd();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zza(bArr, i2, zzdyVar);
            i6 = zzdyVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zza(i6, bArr, i2, i3, zzdyVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzft.zzg();
        }
        return i2;
    }
}
