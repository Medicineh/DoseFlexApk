package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzia<T, B> {
    zzia() {
    }

    abstract B zza();

    abstract T zza(B b);

    abstract void zza(B b, int i, int i2);

    abstract void zza(B b, int i, long j);

    abstract void zza(B b, int i, zzdz zzdzVar);

    abstract void zza(B b, int i, T t);

    abstract void zza(T t, zzix zzixVar) throws IOException;

    abstract void zza(Object obj, T t);

    abstract boolean zza(zzhj zzhjVar);

    abstract T zzb(Object obj);

    abstract void zzb(B b, int i, long j);

    abstract void zzb(T t, zzix zzixVar) throws IOException;

    abstract void zzb(Object obj, B b);

    abstract B zzc(Object obj);

    abstract T zzc(T t, T t2);

    abstract void zzd(Object obj);

    abstract int zze(T t);

    abstract int zzf(T t);

    final boolean zza(B b, zzhj zzhjVar) throws IOException {
        int iZzb = zzhjVar.zzb();
        int i = iZzb >>> 3;
        int i2 = iZzb & 7;
        if (i2 == 0) {
            zza(b, i, zzhjVar.zzg());
            return true;
        }
        if (i2 == 1) {
            zzb(b, i, zzhjVar.zzi());
            return true;
        }
        if (i2 == 2) {
            zza((Object) b, i, zzhjVar.zzn());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzft.zzf();
            }
            zza((Object) b, i, zzhjVar.zzj());
            return true;
        }
        B bZza = zza();
        int i3 = 4 | (i << 3);
        while (zzhjVar.zza() != Integer.MAX_VALUE && zza((Object) bZza, zzhjVar)) {
        }
        if (i3 != zzhjVar.zzb()) {
            throw zzft.zze();
        }
        zza(b, i, zza(bZza));
        return true;
    }
}
