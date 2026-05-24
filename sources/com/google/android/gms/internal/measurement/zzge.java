package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzge extends zzgd {
    private zzge() {
        super();
    }

    @Override // com.google.android.gms.internal.measurement.zzgd
    final <L> List<L> zza(Object obj, long j) {
        zzfq zzfqVarZzc = zzc(obj, j);
        if (zzfqVarZzc.zza()) {
            return zzfqVarZzc;
        }
        int size = zzfqVarZzc.size();
        zzfq zzfqVarZza = zzfqVarZzc.zza(size == 0 ? 10 : size << 1);
        zzig.zza(obj, j, zzfqVarZza);
        return zzfqVarZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzgd
    final void zzb(Object obj, long j) {
        zzc(obj, j).h_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.measurement.zzfq] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.google.android.gms.internal.measurement.zzfq, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    @Override // com.google.android.gms.internal.measurement.zzgd
    final <E> void zza(Object obj, Object obj2, long j) {
        zzfq zzfqVarZzc = zzc(obj, j);
        ?? Zzc = zzc(obj2, j);
        int size = zzfqVarZzc.size();
        int size2 = Zzc.size();
        ?? r0 = zzfqVarZzc;
        r0 = zzfqVarZzc;
        if (size > 0 && size2 > 0) {
            boolean zZza = zzfqVarZzc.zza();
            ?? Zza = zzfqVarZzc;
            if (!zZza) {
                Zza = zzfqVarZzc.zza(size2 + size);
            }
            Zza.addAll(Zzc);
            r0 = Zza;
        }
        if (size > 0) {
            Zzc = r0;
        }
        zzig.zza(obj, j, (Object) Zzc);
    }

    private static <E> zzfq<E> zzc(Object obj, long j) {
        return (zzfq) zzig.zzf(obj, j);
    }
}
