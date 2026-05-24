package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzgd {
    private static final zzgd zza;
    private static final zzgd zzb;

    private zzgd() {
    }

    abstract <L> List<L> zza(Object obj, long j);

    abstract <L> void zza(Object obj, Object obj2, long j);

    abstract void zzb(Object obj, long j);

    static zzgd zza() {
        return zza;
    }

    static zzgd zzb() {
        return zzb;
    }

    static {
        zzgc zzgcVar = null;
        zza = new zzgf();
        zzb = new zzge();
    }
}
