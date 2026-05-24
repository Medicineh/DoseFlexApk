package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzfj implements zzgq {
    private static final zzfj zza = new zzfj();

    private zzfj() {
    }

    public static zzfj zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzgq
    public final boolean zza(Class<?> cls) {
        return zzfi.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.zzgq
    public final zzgr zzb(Class<?> cls) {
        if (!zzfi.class.isAssignableFrom(cls)) {
            String strValueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unsupported message type: ".concat(strValueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzgr) zzfi.zza(cls.asSubclass(zzfi.class)).zza(zzfi.zze.zzc, (Object) null, (Object) null);
        } catch (Exception e) {
            String strValueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(strValueOf2.length() != 0 ? "Unable to get message info for ".concat(strValueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
