package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
abstract class zze extends zzf {
    private boolean zza;

    zze(zzfx zzfxVar) {
        super(zzfxVar);
        this.zzz.zza(this);
    }

    protected void zzaa() {
    }

    protected abstract boolean zzz();

    final boolean zzv() {
        return this.zza;
    }

    protected final void zzw() {
        if (!zzv()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzx() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzz()) {
            return;
        }
        this.zzz.zzaf();
        this.zza = true;
    }

    public final void zzy() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzaa();
        this.zzz.zzaf();
        this.zza = true;
    }
}
