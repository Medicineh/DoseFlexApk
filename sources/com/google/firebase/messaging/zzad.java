package com.google.firebase.messaging;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.iid.zzao;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* JADX INFO: loaded from: classes.dex */
final class zzad implements Runnable {
    private static final Object zzf = new Object();
    private static Boolean zzg = null;
    private static Boolean zzh = null;
    private final Context zza;
    private final zzao zzb;
    private final PowerManager.WakeLock zzc;
    private final zzab zzd;
    private final long zze;

    zzad(zzab zzabVar, Context context, zzao zzaoVar, long j) {
        this.zzd = zzabVar;
        this.zza = context;
        this.zze = j;
        this.zzb = zzaoVar;
        this.zzc = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zza(this.zza)) {
            this.zzc.acquire(zzd.zza);
        }
        try {
            try {
                boolean z = true;
                this.zzd.zza(true);
                if (!this.zzb.zza()) {
                    this.zzd.zza(false);
                    if (zza(this.zza)) {
                        try {
                            this.zzc.release();
                            return;
                        } catch (RuntimeException unused) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                            return;
                        }
                    }
                    return;
                }
                if (zzb(this.zza) && !zzb()) {
                    zzac zzacVar = new zzac(this, this);
                    if (!Log.isLoggable("FirebaseMessaging", 3) && (Build.VERSION.SDK_INT != 23 || !Log.isLoggable("FirebaseMessaging", 3))) {
                        z = false;
                    }
                    if (z) {
                        Log.d("FirebaseMessaging", "Connectivity change received registered");
                    }
                    zzacVar.zza.zza.registerReceiver(zzacVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    if (zza(this.zza)) {
                        try {
                            this.zzc.release();
                            return;
                        } catch (RuntimeException unused2) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                            return;
                        }
                    }
                    return;
                }
                if (this.zzd.zzb()) {
                    this.zzd.zza(false);
                } else {
                    this.zzd.zza(this.zze);
                }
                if (zza(this.zza)) {
                    try {
                        this.zzc.release();
                    } catch (RuntimeException unused3) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            } catch (IOException e) {
                String strValueOf = String.valueOf(e.getMessage());
                Log.e("FirebaseMessaging", strValueOf.length() != 0 ? "Failed to sync topics. Won't retry sync. ".concat(strValueOf) : new String("Failed to sync topics. Won't retry sync. "));
                this.zzd.zza(false);
                if (zza(this.zza)) {
                    try {
                        this.zzc.release();
                    } catch (RuntimeException unused4) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            }
        } catch (Throwable th) {
            if (zza(this.zza)) {
                try {
                    this.zzc.release();
                } catch (RuntimeException unused5) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean zzb() {
        /*
            r2 = this;
            monitor-enter(r2)
            android.content.Context r0 = r2.zza     // Catch: java.lang.Throwable -> L20
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L20
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L12
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L20
            goto L13
        L12:
            r0 = 0
        L13:
            if (r0 == 0) goto L1e
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L1e
            r0 = 1
        L1c:
            monitor-exit(r2)
            return r0
        L1e:
            r0 = 0
            goto L1c
        L20:
            r0 = move-exception
            monitor-exit(r2)
            goto L24
        L23:
            throw r0
        L24:
            goto L23
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzad.zzb():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzc() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
    }

    private static boolean zza(Context context) {
        boolean zBooleanValue;
        boolean zBooleanValue2;
        synchronized (zzf) {
            if (zzg == null) {
                zBooleanValue = zza(context, "android.permission.WAKE_LOCK", zzg);
            } else {
                zBooleanValue = zzg.booleanValue();
            }
            Boolean boolValueOf = Boolean.valueOf(zBooleanValue);
            zzg = boolValueOf;
            zBooleanValue2 = boolValueOf.booleanValue();
        }
        return zBooleanValue2;
    }

    private static boolean zzb(Context context) {
        boolean zBooleanValue;
        boolean zBooleanValue2;
        synchronized (zzf) {
            if (zzh == null) {
                zBooleanValue = zza(context, "android.permission.ACCESS_NETWORK_STATE", zzh);
            } else {
                zBooleanValue = zzh.booleanValue();
            }
            Boolean boolValueOf = Boolean.valueOf(zBooleanValue);
            zzh = boolValueOf;
            zBooleanValue2 = boolValueOf.booleanValue();
        }
        return zBooleanValue2;
    }

    private static boolean zza(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = context.checkCallingOrSelfPermission(str) == 0;
        if (!z && Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 142);
            sb.append("Missing Permission: ");
            sb.append(str);
            sb.append(". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
            Log.d("FirebaseMessaging", sb.toString());
        }
        return z;
    }
}
