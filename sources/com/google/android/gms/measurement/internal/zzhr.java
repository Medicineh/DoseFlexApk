package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhr implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzhc zzb;

    zzhr(zzhc zzhcVar, AtomicReference atomicReference) {
        this.zzb = zzhcVar;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Integer.valueOf(this.zzb.zzt().zzb(this.zzb.zzg().zzab(), zzas.zzam)));
            } finally {
                this.zza.notify();
            }
        }
    }
}
