package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzjj implements Runnable {
    private final /* synthetic */ zzjf zza;

    zzjj(zzjf zzjfVar) {
        this.zza = zzjfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzin zzinVar = this.zza.zza;
        Context contextZzn = this.zza.zza.zzn();
        this.zza.zza.zzu();
        zzinVar.zza(new ComponentName(contextZzn, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
