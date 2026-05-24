package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzcl implements zzcg {
    private static zzcl zza;

    @Nullable
    private final Context zzb;

    @Nullable
    private final ContentObserver zzc;

    static zzcl zza(Context context) {
        zzcl zzclVar;
        synchronized (zzcl.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzcl(context) : new zzcl();
            }
            zzclVar = zza;
        }
        return zzclVar;
    }

    private zzcl(Context context) {
        this.zzb = context;
        this.zzc = new zzcn(this, null);
        context.getContentResolver().registerContentObserver(zzcb.zza, true, this.zzc);
    }

    private zzcl() {
        this.zzb = null;
        this.zzc = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzcg
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final String zza(final String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzcj.zza(new zzci(this, str) { // from class: com.google.android.gms.internal.measurement.zzck
                private final zzcl zza;
                private final String zzb;

                {
                    this.zza = this;
                    this.zzb = str;
                }

                @Override // com.google.android.gms.internal.measurement.zzci
                public final Object zza() {
                    return this.zza.zzb(this.zzb);
                }
            });
        } catch (IllegalStateException | SecurityException e) {
            String strValueOf = String.valueOf(str);
            Log.e("GservicesLoader", strValueOf.length() != 0 ? "Unable to read GServices for: ".concat(strValueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    static synchronized void zza() {
        if (zza != null && zza.zzb != null && zza.zzc != null) {
            zza.zzb.getContentResolver().unregisterContentObserver(zza.zzc);
        }
        zza = null;
    }

    final /* synthetic */ String zzb(String str) {
        return zzcb.zza(this.zzb.getContentResolver(), str, (String) null);
    }
}
