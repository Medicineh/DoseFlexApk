package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhd {
    private static final zzhb zza = zzc();
    private static final zzhb zzb = new zzha();

    static zzhb zza() {
        return zza;
    }

    static zzhb zzb() {
        return zzb;
    }

    private static zzhb zzc() {
        try {
            return (zzhb) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
