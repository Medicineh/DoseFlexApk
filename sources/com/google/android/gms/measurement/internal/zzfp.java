package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfp {
    private final zzfs zza;

    public zzfp(zzfs zzfsVar) {
        Preconditions.checkNotNull(zzfsVar);
        this.zza = zzfsVar;
    }

    public static boolean zza(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public final void zza(Context context, Intent intent) {
        zzfx zzfxVarZza = zzfx.zza(context, null, null);
        zzet zzetVarZzr = zzfxVarZza.zzr();
        if (intent == null) {
            zzetVarZzr.zzi().zza("Receiver called with null intent");
            return;
        }
        zzfxVarZza.zzu();
        String action = intent.getAction();
        zzetVarZzr.zzx().zza("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzetVarZzr.zzx().zza("Starting wakeful intent.");
            this.zza.doStartService(context, className);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            zzetVarZzr.zzi().zza("Install Referrer Broadcasts are deprecated");
        }
    }
}
