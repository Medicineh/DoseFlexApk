package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgo implements Callable<List<zzkp>> {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgc zzb;

    zzgo(zzgc zzgcVar, zzm zzmVar) {
        this.zzb = zzgcVar;
        this.zza = zzmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzkp> call() throws Exception {
        this.zzb.zza.zzo();
        return this.zzb.zza.zze().zza(this.zza.zza);
    }
}
