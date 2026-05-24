package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
class zzgs implements zzgu {
    protected final zzfx zzz;

    zzgs(zzfx zzfxVar) {
        Preconditions.checkNotNull(zzfxVar);
        this.zzz = zzfxVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public zzv zzu() {
        return this.zzz.zzu();
    }

    public zzaa zzt() {
        return this.zzz.zzb();
    }

    public zzff zzs() {
        return this.zzz.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public zzet zzr() {
        return this.zzz.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public zzfu zzq() {
        return this.zzz.zzq();
    }

    public zzko zzp() {
        return this.zzz.zzi();
    }

    public zzer zzo() {
        return this.zzz.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public Context zzn() {
        return this.zzz.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public Clock zzm() {
        return this.zzz.zzm();
    }

    public zzak zzl() {
        return this.zzz.zzx();
    }

    public void zzd() {
        this.zzz.zzq().zzd();
    }

    public void zzc() {
        this.zzz.zzq().zzc();
    }

    public void zzb() {
        this.zzz.zzad();
    }

    public void zza() {
        this.zzz.zzae();
    }
}
