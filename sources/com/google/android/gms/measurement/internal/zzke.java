package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
class zzke extends zzgs implements zzgu {
    protected final zzkg zza;

    zzke(zzkg zzkgVar) {
        super(zzkgVar.zzs());
        Preconditions.checkNotNull(zzkgVar);
        this.zza = zzkgVar;
    }

    public zzfr zzj() {
        return this.zza.zzc();
    }

    public zzab zzi() {
        return this.zza.zze();
    }

    public zzq e_() {
        return this.zza.zzf();
    }

    public zzkk zzg() {
        return this.zza.zzh();
    }
}
