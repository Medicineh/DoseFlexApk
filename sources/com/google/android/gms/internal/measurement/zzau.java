package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzau extends zzac.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zzp zzf;
    private final /* synthetic */ zzac zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzau(zzac zzacVar, String str, String str2, boolean z, zzp zzpVar) {
        super(zzacVar);
        this.zzg = zzacVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = z;
        this.zzf = zzpVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    final void zza() throws RemoteException {
        this.zzg.zzr.getUserProperties(this.zzc, this.zzd, this.zze, this.zzf);
    }

    @Override // com.google.android.gms.internal.measurement.zzac.zza
    protected final void zzb() {
        this.zzf.zza((Bundle) null);
    }
}
