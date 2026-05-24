package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzka {
    final /* synthetic */ zzjs zza;

    zzka(zzjs zzjsVar) {
        this.zza = zzjsVar;
    }

    final void zza() {
        this.zza.zzd();
        if (this.zza.zzs().zza(this.zza.zzm().currentTimeMillis())) {
            this.zza.zzs().zzm.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzr().zzx().zza("Detected application was in foreground");
                zzb(this.zza.zzm().currentTimeMillis(), false);
            }
        }
    }

    final void zza(long j, boolean z) {
        this.zza.zzd();
        this.zza.zzab();
        if (this.zza.zzs().zza(j)) {
            this.zza.zzs().zzm.zza(true);
        }
        this.zza.zzs().zzq.zza(j);
        if (this.zza.zzs().zzm.zza()) {
            zzb(j, z);
        }
    }

    private final void zzb(long j, boolean z) {
        this.zza.zzd();
        if (this.zza.zzz.zzab()) {
            this.zza.zzs().zzq.zza(j);
            this.zza.zzr().zzx().zza("Session started, time", Long.valueOf(this.zza.zzm().elapsedRealtime()));
            Long lValueOf = Long.valueOf(j / 1000);
            this.zza.zzf().zza("auto", "_sid", lValueOf, j);
            this.zza.zzs().zzm.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", lValueOf.longValue());
            if (this.zza.zzt().zza(zzas.zzbq) && z) {
                bundle.putLong("_aib", 1L);
            }
            this.zza.zzf().zza("auto", "_s", j, bundle);
            if (com.google.android.gms.internal.measurement.zzka.zzb() && this.zza.zzt().zza(zzas.zzbv)) {
                String strZza = this.zza.zzs().zzv.zza();
                if (TextUtils.isEmpty(strZza)) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", strZza);
                this.zza.zzf().zza("auto", "_ssr", j, bundle2);
            }
        }
    }
}
