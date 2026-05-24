package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlr implements zzlo {
    private static final zzcq<Boolean> zza;
    private static final zzcq<Boolean> zzb;
    private static final zzcq<Boolean> zzc;
    private static final zzcq<Boolean> zzd;
    private static final zzcq<Long> zze;

    @Override // com.google.android.gms.internal.measurement.zzlo
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlo
    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlo
    public final boolean zzc() {
        return zzc.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlo
    public final boolean zzd() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzcw zzcwVar = new zzcw(zzcr.zza("com.google.android.gms.measurement"));
        zza = zzcwVar.zza("measurement.sdk.collection.enable_extend_user_property_size", true);
        zzb = zzcwVar.zza("measurement.sdk.collection.last_deep_link_referrer2", true);
        zzc = zzcwVar.zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzd = zzcwVar.zza("measurement.sdk.collection.last_gclid_from_referrer2", false);
        zze = zzcwVar.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }
}
