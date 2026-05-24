package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhl implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzhc zzb;

    zzhl(zzhc zzhcVar, Bundle bundle) {
        this.zzb = zzhcVar;
        this.zza = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
