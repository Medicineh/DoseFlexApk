package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzgr extends zzgs {
    private boolean zza;

    zzgr(zzfx zzfxVar) {
        super(zzfxVar);
        this.zzz.zza(this);
    }

    protected void f_() {
    }

    protected abstract boolean zze();

    final boolean zzz() {
        return this.zza;
    }

    protected final void zzaa() {
        if (!zzz()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzab() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zze()) {
            return;
        }
        this.zzz.zzaf();
        this.zza = true;
    }

    public final void zzac() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        f_();
        this.zzz.zzaf();
        this.zza = true;
    }
}
