package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzks;
import com.google.android.gms.internal.measurement.zzkx;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzjy {
    private long zza;
    private long zzb;
    private final zzai zzc;
    private final /* synthetic */ zzjs zzd;

    public zzjy(zzjs zzjsVar) {
        this.zzd = zzjsVar;
        this.zzc = new zzjx(this, this.zzd.zzz);
        long jElapsedRealtime = zzjsVar.zzm().elapsedRealtime();
        this.zza = jElapsedRealtime;
        this.zzb = jElapsedRealtime;
    }

    final void zza(long j) {
        this.zzd.zzd();
        this.zzc.zzc();
        this.zza = j;
        this.zzb = j;
    }

    final void zzb(long j) {
        this.zzc.zzc();
    }

    final void zza() {
        this.zzc.zzc();
        this.zza = 0L;
        this.zzb = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc() {
        this.zzd.zzd();
        zza(false, false, this.zzd.zzm().elapsedRealtime());
        this.zzd.zze().zza(this.zzd.zzm().elapsedRealtime());
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        this.zzd.zzd();
        this.zzd.zzw();
        if (!com.google.android.gms.internal.measurement.zzkm.zzb() || !this.zzd.zzt().zza(zzas.zzca)) {
            j = this.zzd.zzm().elapsedRealtime();
        }
        if (!zzks.zzb() || !this.zzd.zzt().zza(zzas.zzbw) || this.zzd.zzz.zzab()) {
            this.zzd.zzs().zzq.zza(this.zzd.zzm().currentTimeMillis());
        }
        long jZzc = j - this.zza;
        if (!z && jZzc < 1000) {
            this.zzd.zzr().zzx().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(jZzc));
            return false;
        }
        if (this.zzd.zzt().zza(zzas.zzat) && !z2) {
            jZzc = (zzkx.zzb() && this.zzd.zzt().zza(zzas.zzav) && com.google.android.gms.internal.measurement.zzkm.zzb() && this.zzd.zzt().zza(zzas.zzca)) ? zzc(j) : zzb();
        }
        this.zzd.zzr().zzx().zza("Recording user engagement, ms", Long.valueOf(jZzc));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", jZzc);
        zzih.zza(this.zzd.zzi().zza(!this.zzd.zzt().zzj().booleanValue()), bundle, true);
        if (this.zzd.zzt().zza(zzas.zzat) && !this.zzd.zzt().zza(zzas.zzau) && z2) {
            bundle.putLong("_fr", 1L);
        }
        if (!this.zzd.zzt().zza(zzas.zzau) || !z2) {
            this.zzd.zzf().zza("auto", "_e", bundle);
        }
        this.zza = j;
        this.zzc.zzc();
        this.zzc.zza(3600000L);
        return true;
    }

    final long zzb() {
        long jElapsedRealtime = this.zzd.zzm().elapsedRealtime();
        long j = jElapsedRealtime - this.zzb;
        this.zzb = jElapsedRealtime;
        return j;
    }

    final long zzc(long j) {
        long j2 = j - this.zzb;
        this.zzb = j;
        return j2;
    }
}
