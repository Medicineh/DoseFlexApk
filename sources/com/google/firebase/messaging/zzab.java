package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.iid.zzao;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* JADX INFO: loaded from: classes.dex */
final class zzab {
    private static final long zza = TimeUnit.HOURS.toSeconds(8);
    private final FirebaseInstanceId zzb;
    private final Context zzc;
    private final zzao zzd;
    private final com.google.firebase.iid.zzt zze;
    private final ScheduledExecutorService zzg;
    private final zzy zzi;
    private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> zzf = new ArrayMap();
    private boolean zzh = false;

    static Task<zzab> zza(FirebaseApp firebaseApp, final FirebaseInstanceId firebaseInstanceId, final zzao zzaoVar, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi, final Context context, Executor executor, final ScheduledExecutorService scheduledExecutorService) {
        final com.google.firebase.iid.zzt zztVar = new com.google.firebase.iid.zzt(firebaseApp, zzaoVar, executor, userAgentPublisher, heartBeatInfo, firebaseInstallationsApi);
        return Tasks.call(scheduledExecutorService, new Callable(context, scheduledExecutorService, firebaseInstanceId, zzaoVar, zztVar) { // from class: com.google.firebase.messaging.zzaa
            private final Context zza;
            private final ScheduledExecutorService zzb;
            private final FirebaseInstanceId zzc;
            private final zzao zzd;
            private final com.google.firebase.iid.zzt zze;

            {
                this.zza = context;
                this.zzb = scheduledExecutorService;
                this.zzc = firebaseInstanceId;
                this.zzd = zzaoVar;
                this.zze = zztVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzab.zza(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
            }
        });
    }

    private zzab(FirebaseInstanceId firebaseInstanceId, zzao zzaoVar, zzy zzyVar, com.google.firebase.iid.zzt zztVar, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzb = firebaseInstanceId;
        this.zzd = zzaoVar;
        this.zzi = zzyVar;
        this.zze = zztVar;
        this.zzc = context;
        this.zzg = scheduledExecutorService;
    }

    final Task<Void> zza(zzz zzzVar) {
        ArrayDeque<TaskCompletionSource<Void>> arrayDeque;
        this.zzi.zza(zzzVar);
        TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        synchronized (this.zzf) {
            String strZzc = zzzVar.zzc();
            if (this.zzf.containsKey(strZzc)) {
                arrayDeque = this.zzf.get(strZzc);
            } else {
                ArrayDeque<TaskCompletionSource<Void>> arrayDeque2 = new ArrayDeque<>();
                this.zzf.put(strZzc, arrayDeque2);
                arrayDeque = arrayDeque2;
            }
            arrayDeque.add(taskCompletionSource);
        }
        return taskCompletionSource.getTask();
    }

    final void zza() {
        if (!(this.zzi.zza() != null) || zzc()) {
            return;
        }
        zza(0L);
    }

    final void zza(long j) {
        zza(new zzad(this, this.zzc, this.zzd, Math.min(Math.max(30L, j << 1), zza)), j);
        zza(true);
    }

    final void zza(Runnable runnable, long j) {
        this.zzg.schedule(runnable, j, TimeUnit.SECONDS);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
    
        if (zzd() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        android.util.Log.d("FirebaseMessaging", "topic sync succeeded");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final boolean zzb() throws java.io.IOException {
        /*
            r5 = this;
        L0:
            monitor-enter(r5)
            com.google.firebase.messaging.zzy r0 = r5.zzi     // Catch: java.lang.Throwable -> L5c
            com.google.firebase.messaging.zzz r0 = r0.zza()     // Catch: java.lang.Throwable -> L5c
            if (r0 != 0) goto L19
            boolean r0 = zzd()     // Catch: java.lang.Throwable -> L5c
            if (r0 == 0) goto L16
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)     // Catch: java.lang.Throwable -> L5c
        L16:
            r0 = 1
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L5c
            return r0
        L19:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L5c
            boolean r1 = r5.zzb(r0)
            if (r1 != 0) goto L22
            r0 = 0
            return r0
        L22:
            com.google.firebase.messaging.zzy r1 = r5.zzi
            r1.zzb(r0)
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r5.zzf
            monitor-enter(r1)
            java.lang.String r0 = r0.zzc()     // Catch: java.lang.Throwable -> L59
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r2 = r5.zzf     // Catch: java.lang.Throwable -> L59
            boolean r2 = r2.containsKey(r0)     // Catch: java.lang.Throwable -> L59
            if (r2 != 0) goto L38
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L59
            goto L0
        L38:
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r2 = r5.zzf     // Catch: java.lang.Throwable -> L59
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Throwable -> L59
            java.util.ArrayDeque r2 = (java.util.ArrayDeque) r2     // Catch: java.lang.Throwable -> L59
            java.lang.Object r3 = r2.poll()     // Catch: java.lang.Throwable -> L59
            com.google.android.gms.tasks.TaskCompletionSource r3 = (com.google.android.gms.tasks.TaskCompletionSource) r3     // Catch: java.lang.Throwable -> L59
            if (r3 == 0) goto L4c
            r4 = 0
            r3.setResult(r4)     // Catch: java.lang.Throwable -> L59
        L4c:
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L59
            if (r2 == 0) goto L57
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r2 = r5.zzf     // Catch: java.lang.Throwable -> L59
            r2.remove(r0)     // Catch: java.lang.Throwable -> L59
        L57:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L59
            goto L0
        L59:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L59
            throw r0
        L5c:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L5c
            goto L60
        L5f:
            throw r0
        L60:
            goto L5f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzab.zzb():boolean");
    }

    private final boolean zzb(zzz zzzVar) throws IOException {
        try {
            String strZzb = zzzVar.zzb();
            byte b = -1;
            int iHashCode = strZzb.hashCode();
            if (iHashCode != 83) {
                if (iHashCode == 85 && strZzb.equals("U")) {
                    b = 1;
                }
            } else if (strZzb.equals("S")) {
                b = 0;
            }
            if (b == 0) {
                String strZza = zzzVar.zza();
                InstanceIdResult instanceIdResult = (InstanceIdResult) zza(this.zzb.getInstanceId());
                zza(this.zze.zzc(instanceIdResult.getId(), instanceIdResult.getToken(), strZza));
                if (zzd()) {
                    String strZza2 = zzzVar.zza();
                    StringBuilder sb = new StringBuilder(String.valueOf(strZza2).length() + 31);
                    sb.append("Subscribe to topic: ");
                    sb.append(strZza2);
                    sb.append(" succeeded.");
                    Log.d("FirebaseMessaging", sb.toString());
                }
            } else if (b == 1) {
                String strZza3 = zzzVar.zza();
                InstanceIdResult instanceIdResult2 = (InstanceIdResult) zza(this.zzb.getInstanceId());
                zza(this.zze.zzd(instanceIdResult2.getId(), instanceIdResult2.getToken(), strZza3));
                if (zzd()) {
                    String strZza4 = zzzVar.zza();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(strZza4).length() + 35);
                    sb2.append("Unsubscribe from topic: ");
                    sb2.append(strZza4);
                    sb2.append(" succeeded.");
                    Log.d("FirebaseMessaging", sb2.toString());
                }
            } else if (zzd()) {
                String strValueOf = String.valueOf(zzzVar);
                StringBuilder sb3 = new StringBuilder(String.valueOf(strValueOf).length() + 24);
                sb3.append("Unknown topic operation");
                sb3.append(strValueOf);
                sb3.append(".");
                Log.d("FirebaseMessaging", sb3.toString());
            }
            return true;
        } catch (IOException e) {
            if ("SERVICE_NOT_AVAILABLE".equals(e.getMessage()) || "INTERNAL_SERVER_ERROR".equals(e.getMessage())) {
                String message = e.getMessage();
                StringBuilder sb4 = new StringBuilder(String.valueOf(message).length() + 53);
                sb4.append("Topic operation failed: ");
                sb4.append(message);
                sb4.append(". Will retry Topic operation.");
                Log.e("FirebaseMessaging", sb4.toString());
                return false;
            }
            if (e.getMessage() == null) {
                Log.e("FirebaseMessaging", "Topic operation failed without exception message. Will retry Topic operation.");
                return false;
            }
            throw e;
        }
    }

    private static <T> T zza(Task<T> task) throws IOException {
        try {
            return (T) Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e = e;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IOException(e2);
        } catch (TimeoutException e3) {
            e = e3;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    private final synchronized boolean zzc() {
        return this.zzh;
    }

    final synchronized void zza(boolean z) {
        this.zzh = z;
    }

    private static boolean zzd() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
    }

    static final /* synthetic */ zzab zza(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseInstanceId firebaseInstanceId, zzao zzaoVar, com.google.firebase.iid.zzt zztVar) throws Exception {
        return new zzab(firebaseInstanceId, zzaoVar, zzy.zza(context, scheduledExecutorService), zztVar, context, scheduledExecutorService);
    }
}
