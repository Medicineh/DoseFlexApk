package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzey {
    private static final zzex<?> zza = new zzez();
    private static final zzex<?> zzb = zzc();

    private static zzex<?> zzc() {
        try {
            return (zzex) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzex<?> zza() {
        return zza;
    }

    static zzex<?> zzb() {
        zzex<?> zzexVar = zzb;
        if (zzexVar != null) {
            return zzexVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
