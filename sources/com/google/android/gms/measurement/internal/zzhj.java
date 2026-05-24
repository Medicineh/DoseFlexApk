package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzks;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhj implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhc zzb;

    zzhj(zzhc zzhcVar, long j) {
        this.zzb = zzhcVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhc zzhcVar = this.zzb;
        long j = this.zza;
        zzhcVar.zzd();
        zzhcVar.zzb();
        zzhcVar.zzw();
        zzhcVar.zzr().zzw().zza("Resetting analytics data (FE)");
        zzjs zzjsVarZzk = zzhcVar.zzk();
        zzjsVarZzk.zzd();
        zzjsVarZzk.zzb.zza();
        boolean zZzab = zzhcVar.zzz.zzab();
        zzff zzffVarZzs = zzhcVar.zzs();
        zzffVarZzs.zzh.zza(j);
        if (!TextUtils.isEmpty(zzffVarZzs.zzs().zzv.zza())) {
            zzffVarZzs.zzv.zza(null);
        }
        if (zzks.zzb() && zzffVarZzs.zzt().zza(zzas.zzbw)) {
            zzffVarZzs.zzq.zza(0L);
        }
        if (!zzffVarZzs.zzt().zzh()) {
            zzffVarZzs.zzc(!zZzab);
        }
        zzffVarZzs.zzw.zza(null);
        zzffVarZzs.zzx.zza(0L);
        zzffVarZzs.zzy.zza(null);
        zzhcVar.zzh().zzad();
        if (zzks.zzb() && zzhcVar.zzt().zza(zzas.zzbw)) {
            zzhcVar.zzk().zza.zza();
        }
        zzhcVar.zzc = !zZzab;
        this.zzb.zzh().zza(new AtomicReference<>());
    }
}
