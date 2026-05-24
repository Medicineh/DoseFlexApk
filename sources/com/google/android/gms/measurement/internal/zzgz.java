package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzgz {
    final Context zza;
    String zzb;
    String zzc;
    String zzd;
    Boolean zze;
    long zzf;
    com.google.android.gms.internal.measurement.zzaa zzg;
    boolean zzh;
    Long zzi;

    public zzgz(Context context, com.google.android.gms.internal.measurement.zzaa zzaaVar, Long l) {
        this.zzh = true;
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l;
        if (zzaaVar != null) {
            this.zzg = zzaaVar;
            this.zzb = zzaaVar.zzf;
            this.zzc = zzaaVar.zze;
            this.zzd = zzaaVar.zzd;
            this.zzh = zzaaVar.zzc;
            this.zzf = zzaaVar.zzb;
            if (zzaaVar.zzg != null) {
                this.zze = Boolean.valueOf(zzaaVar.zzg.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
