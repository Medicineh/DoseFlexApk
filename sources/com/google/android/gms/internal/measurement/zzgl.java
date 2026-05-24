package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzgl<K, V> {
    static <K, V> void zza(zzes zzesVar, zzgk<K, V> zzgkVar, K k, V v) throws IOException {
        zzfb.zza(zzesVar, zzgkVar.zza, 1, k);
        zzfb.zza(zzesVar, zzgkVar.zzc, 2, v);
    }

    static <K, V> int zza(zzgk<K, V> zzgkVar, K k, V v) {
        return zzfb.zza(zzgkVar.zza, 1, k) + zzfb.zza(zzgkVar.zzc, 2, v);
    }
}
