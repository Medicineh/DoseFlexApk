package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.zzao;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseMessaging {
    public static final String INSTANCE_ID_SCOPE = "FCM";
    static TransportFactory zza;
    private final Context zzb;
    private final FirebaseInstanceId zzc;
    private final Task<zzab> zzd;

    public static synchronized FirebaseMessaging getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    static synchronized FirebaseMessaging getInstance(FirebaseApp firebaseApp) {
        return (FirebaseMessaging) firebaseApp.get(FirebaseMessaging.class);
    }

    FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi, TransportFactory transportFactory) {
        zza = transportFactory;
        this.zzc = firebaseInstanceId;
        this.zzb = firebaseApp.getApplicationContext();
        Task<zzab> taskZza = zzab.zza(firebaseApp, firebaseInstanceId, new zzao(this.zzb), userAgentPublisher, heartBeatInfo, firebaseInstallationsApi, this.zzb, zzi.zza(), new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Topics-Io")));
        this.zzd = taskZza;
        taskZza.addOnSuccessListener(zzi.zzb(), new OnSuccessListener(this) { // from class: com.google.firebase.messaging.zzk
            private final FirebaseMessaging zza;

            {
                this.zza = this;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                zzab zzabVar = (zzab) obj;
                if (this.zza.isAutoInitEnabled()) {
                    zzabVar.zza();
                }
            }
        });
    }

    public boolean isAutoInitEnabled() {
        return this.zzc.zzh();
    }

    public void setAutoInitEnabled(boolean z) {
        this.zzc.zzb(z);
    }

    public boolean deliveryMetricsExportToBigQueryEnabled() {
        return zzr.zza();
    }

    public void setDeliveryMetricsExportToBigQuery(boolean z) {
        zzr.zza(z);
    }

    public Task<Void> subscribeToTopic(final String str) {
        return this.zzd.onSuccessTask(new SuccessContinuation(str) { // from class: com.google.firebase.messaging.zzm
            private final String zza;

            {
                this.zza = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                zzab zzabVar = (zzab) obj;
                Task<Void> taskZza = zzabVar.zza(zzz.zza(this.zza));
                zzabVar.zza();
                return taskZza;
            }
        });
    }

    public Task<Void> unsubscribeFromTopic(final String str) {
        return this.zzd.onSuccessTask(new SuccessContinuation(str) { // from class: com.google.firebase.messaging.zzl
            private final String zza;

            {
                this.zza = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                zzab zzabVar = (zzab) obj;
                Task<Void> taskZza = zzabVar.zza(zzz.zzb(this.zza));
                zzabVar.zza();
                return taskZza;
            }
        });
    }

    public void send(RemoteMessage remoteMessage) {
        if (TextUtils.isEmpty(remoteMessage.getTo())) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        Intent intent2 = new Intent();
        intent2.setPackage("com.google.example.invalidpackage");
        intent.putExtra("app", PendingIntent.getBroadcast(this.zzb, 0, intent2, 0));
        intent.setPackage("com.google.android.gms");
        intent.putExtras(remoteMessage.zza);
        this.zzb.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }
}
