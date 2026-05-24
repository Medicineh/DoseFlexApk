package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzac;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzaf extends zzac.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Context zze;
    private final /* synthetic */ Bundle zzf;
    private final /* synthetic */ zzac zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaf(zzac zzacVar, String str, String str2, Context context, Bundle bundle) {
        super(zzacVar);
        this.zzg = zzacVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    public final void zza() {
        String str;
        String str2;
        String str3;
        boolean z;
        int iMax;
        try {
            this.zzg.zzf = new ArrayList();
            zzac zzacVar = this.zzg;
            if (zzac.zzc(this.zzc, this.zzd)) {
                String str4 = this.zzd;
                str2 = this.zzc;
                str3 = str4;
                str = this.zzg.zzc;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            zzac.zzi(this.zze);
            boolean z2 = zzac.zzi.booleanValue() || str2 != null;
            this.zzg.zzr = this.zzg.zza(this.zze, z2);
            if (this.zzg.zzr == null) {
                Log.w(this.zzg.zzc, "Failed to connect to measurement client.");
                return;
            }
            int iZzh = zzac.zzh(this.zze);
            int iZzg = zzac.zzg(this.zze);
            if (z2) {
                iMax = Math.max(iZzh, iZzg);
                z = iZzg < iZzh;
            } else {
                if (iZzh > 0) {
                    iZzg = iZzh;
                }
                z = iZzh > 0;
                iMax = iZzg;
            }
            this.zzg.zzr.initialize(ObjectWrapper.wrap(this.zze), new zzaa(27000L, iMax, z, str, str2, str3, this.zzf), this.zza);
        } catch (Exception e) {
            this.zzg.zza(e, true, false);
        }
    }
}
