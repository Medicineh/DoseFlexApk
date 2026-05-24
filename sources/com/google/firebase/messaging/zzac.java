package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* JADX INFO: loaded from: classes.dex */
final class zzac extends BroadcastReceiver {
    final /* synthetic */ zzad zza;
    private zzad zzb;

    public zzac(zzad zzadVar, zzad zzadVar2) {
        this.zza = zzadVar;
        this.zzb = zzadVar2;
    }

    @Override // android.content.BroadcastReceiver
    public final synchronized void onReceive(Context context, Intent intent) {
        if (this.zzb == null) {
            return;
        }
        if (this.zzb.zzb()) {
            if (zzad.zzc()) {
                Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
            }
            this.zzb.zzd.zza(this.zzb, 0L);
            context.unregisterReceiver(this);
            this.zzb = null;
        }
    }
}
