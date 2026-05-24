package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgo {
    private static final zzgm zza = zzc();
    private static final zzgm zzb = new zzgp();

    static zzgm zza() {
        return zza;
    }

    static zzgm zzb() {
        return zzb;
    }

    private static zzgm zzc() {
        try {
            return (zzgm) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
