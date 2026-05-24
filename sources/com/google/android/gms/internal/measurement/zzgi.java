package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgi implements zzgq {
    private zzgq[] zza;

    zzgi(zzgq... zzgqVarArr) {
        this.zza = zzgqVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzgq
    public final boolean zza(Class<?> cls) {
        for (zzgq zzgqVar : this.zza) {
            if (zzgqVar.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzgq
    public final zzgr zzb(Class<?> cls) {
        for (zzgq zzgqVar : this.zza) {
            if (zzgqVar.zza(cls)) {
                return zzgqVar.zzb(cls);
            }
        }
        String strValueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(strValueOf.length() != 0 ? "No factory is available for message type: ".concat(strValueOf) : new String("No factory is available for message type: "));
    }
}
