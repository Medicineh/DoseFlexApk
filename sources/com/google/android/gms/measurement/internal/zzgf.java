package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgf implements Callable<List<zzy>> {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzgc zzd;

    zzgf(zzgc zzgcVar, zzm zzmVar, String str, String str2) {
        this.zzd = zzgcVar;
        this.zza = zzmVar;
        this.zzb = str;
        this.zzc = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzy> call() throws Exception {
        this.zzd.zza.zzo();
        return this.zzd.zza.zze().zzb(this.zza.zza, this.zzb, this.zzc);
    }
}
