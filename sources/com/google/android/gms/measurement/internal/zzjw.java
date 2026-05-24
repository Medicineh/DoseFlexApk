package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzjw implements Runnable {
    long zza;
    long zzb;
    final /* synthetic */ zzjt zzc;

    zzjw(zzjt zzjtVar, long j, long j2) {
        this.zzc = zzjtVar;
        this.zza = j;
        this.zzb = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzq().zza(new Runnable(this) { // from class: com.google.android.gms.measurement.internal.zzjv
            private final zzjw zza;

            {
                this.zza = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzjw zzjwVar = this.zza;
                zzjt zzjtVar = zzjwVar.zzc;
                long j = zzjwVar.zza;
                long j2 = zzjwVar.zzb;
                zzjtVar.zza.zzd();
                zzjtVar.zza.zzr().zzw().zza("Application going to the background");
                if (zzjtVar.zza.zzt().zza(zzas.zzcd)) {
                    zzjtVar.zza.zzs().zzs.zza(true);
                }
                if (!zzjtVar.zza.zzt().zzj().booleanValue()) {
                    zzjtVar.zza.zzb.zzb(j2);
                    zzjtVar.zza.zza(false, false, j2);
                }
                zzjtVar.zza.zzf().zza("auto", "_ab", j, new Bundle());
            }
        });
    }
}
