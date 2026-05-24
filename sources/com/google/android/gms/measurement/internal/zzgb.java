package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgb implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgc zzb;

    zzgb(zzgc zzgcVar, zzm zzmVar) {
        this.zzb = zzgcVar;
        this.zza = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzo();
        zzkg zzkgVar = this.zzb.zza;
        zzm zzmVar = this.zza;
        zzkgVar.zzq().zzd();
        zzkgVar.zzk();
        Preconditions.checkNotEmpty(zzmVar.zza);
        zzkgVar.zzc(zzmVar);
    }
}
