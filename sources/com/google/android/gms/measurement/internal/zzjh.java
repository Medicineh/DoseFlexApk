package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzjh implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zzjf zzb;

    zzjh(zzjf zzjfVar, ComponentName componentName) {
        this.zzb = zzjfVar;
        this.zza = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zza(this.zza);
    }
}
