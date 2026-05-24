package com.google.android.gms.measurement.module;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzfx;
import com.google.android.gms.measurement.internal.zzgv;
import com.google.android.gms.measurement.internal.zzgw;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public class Analytics {
    public static final String CRASH_ORIGIN = "crash";
    public static final String FCM_ORIGIN = "fcm";
    public static final String FIAM_ORIGIN = "fiam";
    private static volatile Analytics zza;
    private final zzfx zzb;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
    public static final class Event extends zzgw {
        public static final String AD_REWARD = "_ar";
        public static final String APP_EXCEPTION = "_ae";

        private Event() {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
    public static final class Param extends zzgv {
        public static final String FATAL = "fatal";
        public static final String TIMESTAMP = "timestamp";
        public static final String TYPE = "type";

        private Param() {
        }
    }

    public static Analytics getInstance(Context context) {
        if (zza == null) {
            synchronized (Analytics.class) {
                if (zza == null) {
                    zza = new Analytics(zzfx.zza(context, null, null));
                }
            }
        }
        return zza;
    }

    private Analytics(zzfx zzfxVar) {
        Preconditions.checkNotNull(zzfxVar);
        this.zzb = zzfxVar;
    }
}
