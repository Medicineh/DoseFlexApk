package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzkd extends zzke {
    private boolean zzb;

    zzkd(zzkg zzkgVar) {
        super(zzkgVar);
        this.zza.zza(this);
    }

    protected abstract boolean zze();

    final boolean zzaj() {
        return this.zzb;
    }

    protected final void zzak() {
        if (!zzaj()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzal() {
        if (this.zzb) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zze();
        this.zza.zzp();
        this.zzb = true;
    }
}
