package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhg implements zzgr {
    private final zzgt zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    zzhg(zzgt zzgtVar, String str, Object[] objArr) {
        this.zza = zzgtVar;
        this.zzb = str;
        this.zzc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.zzd = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    final String zzd() {
        return this.zzb;
    }

    final Object[] zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzgr
    public final zzgt zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzgr
    public final int zza() {
        return (this.zzd & 1) == 1 ? zzfi.zze.zzh : zzfi.zze.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzgr
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }
}
