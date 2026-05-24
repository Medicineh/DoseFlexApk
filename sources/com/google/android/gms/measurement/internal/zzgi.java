package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgi implements Callable<List<zzy>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzgc zzd;

    zzgi(zzgc zzgcVar, String str, String str2, String str3) {
        this.zzd = zzgcVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzy> call() throws Exception {
        this.zzd.zza.zzo();
        return this.zzd.zza.zze().zzb(this.zza, this.zzb, this.zzc);
    }
}
