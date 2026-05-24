package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzah extends zzac.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzp zze;
    private final /* synthetic */ zzac zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzah(zzac zzacVar, String str, String str2, zzp zzpVar) {
        super(zzacVar);
        this.zzf = zzacVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzpVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    final void zza() throws RemoteException {
        this.zzf.zzr.getConditionalUserProperties(this.zzc, this.zzd, this.zze);
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    protected final void zzb() {
        this.zze.zza((Bundle) null);
    }
}
