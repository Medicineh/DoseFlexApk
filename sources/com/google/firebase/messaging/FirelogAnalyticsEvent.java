package com.google.firebase.messaging;

import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* JADX INFO: loaded from: classes.dex */
final class FirelogAnalyticsEvent {
    private final String zza;
    private final Intent zzb;

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
    static class zzb implements ObjectEncoder<FirelogAnalyticsEvent> {
        zzb() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public final /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws EncodingException, IOException {
            FirelogAnalyticsEvent firelogAnalyticsEvent = (FirelogAnalyticsEvent) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            Intent intentZza = firelogAnalyticsEvent.zza();
            objectEncoderContext2.add("ttl", zzr.zzf(intentZza));
            objectEncoderContext2.add(NotificationCompat.CATEGORY_EVENT, firelogAnalyticsEvent.zzb());
            objectEncoderContext2.add("instanceId", zzr.zzc());
            objectEncoderContext2.add("priority", zzr.zzm(intentZza));
            objectEncoderContext2.add("packageName", zzr.zzb());
            objectEncoderContext2.add("sdkPlatform", "ANDROID");
            objectEncoderContext2.add("messageType", zzr.zzk(intentZza));
            String strZzj = zzr.zzj(intentZza);
            if (strZzj != null) {
                objectEncoderContext2.add("messageId", strZzj);
            }
            String strZzl = zzr.zzl(intentZza);
            if (strZzl != null) {
                objectEncoderContext2.add("topic", strZzl);
            }
            String strZzg = zzr.zzg(intentZza);
            if (strZzg != null) {
                objectEncoderContext2.add("collapseKey", strZzg);
            }
            if (zzr.zzi(intentZza) != null) {
                objectEncoderContext2.add("analyticsLabel", zzr.zzi(intentZza));
            }
            if (zzr.zzh(intentZza) != null) {
                objectEncoderContext2.add("composerLabel", zzr.zzh(intentZza));
            }
            String strZzd = zzr.zzd();
            if (strZzd != null) {
                objectEncoderContext2.add("projectNumber", strZzd);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
    static final class zzc implements ObjectEncoder<zza> {
        zzc() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public final /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws EncodingException, IOException {
            objectEncoderContext.add("messaging_client_event", ((zza) obj).zza());
        }
    }

    FirelogAnalyticsEvent(String str, Intent intent) {
        this.zza = Preconditions.checkNotEmpty(str, "evenType must be non-null");
        this.zzb = (Intent) Preconditions.checkNotNull(intent, "intent must be non-null");
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
    static final class zza {
        private final FirelogAnalyticsEvent zza;

        zza(FirelogAnalyticsEvent firelogAnalyticsEvent) {
            this.zza = (FirelogAnalyticsEvent) Preconditions.checkNotNull(firelogAnalyticsEvent);
        }

        final FirelogAnalyticsEvent zza() {
            return this.zza;
        }
    }

    final Intent zza() {
        return this.zzb;
    }

    final String zzb() {
        return this.zza;
    }
}
