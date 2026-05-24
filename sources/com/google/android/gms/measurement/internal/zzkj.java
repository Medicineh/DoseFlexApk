package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzkj implements Callable<String> {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzkg zzb;

    zzkj(zzkg zzkgVar, zzm zzmVar) {
        this.zzb = zzkgVar;
        this.zza = zzmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        zzg zzgVarZzc = this.zzb.zzc(this.zza);
        if (zzgVarZzc == null) {
            this.zzb.zzr().zzi().zza("App info was null when attempting to get app instance id");
            return null;
        }
        return zzgVarZzc.zzd();
    }
}
