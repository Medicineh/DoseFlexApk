package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* JADX INFO: loaded from: classes.dex */
final class zzy {
    private static WeakReference<zzy> zza;
    private final SharedPreferences zzb;
    private zzx zzc;
    private final Executor zzd;

    private zzy(SharedPreferences sharedPreferences, Executor executor) {
        this.zzd = executor;
        this.zzb = sharedPreferences;
    }

    private final synchronized void zzb() {
        this.zzc = zzx.zza(this.zzb, "topic_operation_queue", ",", this.zzd);
    }

    public static synchronized zzy zza(Context context, Executor executor) {
        zzy zzyVar;
        zzyVar = zza != null ? zza.get() : null;
        if (zzyVar == null) {
            zzyVar = new zzy(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
            zzyVar.zzb();
            zza = new WeakReference<>(zzyVar);
        }
        return zzyVar;
    }

    final synchronized zzz zza() {
        return zzz.zzc(this.zzc.zza());
    }

    final synchronized boolean zza(zzz zzzVar) {
        return this.zzc.zza(zzzVar.zzc());
    }

    final synchronized boolean zzb(zzz zzzVar) {
        return this.zzc.zza((Object) zzzVar.zzc());
    }
}
