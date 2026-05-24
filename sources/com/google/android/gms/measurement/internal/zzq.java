package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzq extends zzkd {
    private String zzb;
    private Set<Integer> zzc;
    private Map<Integer, zzs> zzd;
    private Long zze;
    private Long zzf;

    zzq(zzkg zzkgVar) {
        super(zzkgVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkd
    protected final boolean zze() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:208:0x05fa, code lost:
    
        r7 = zzr().zzi();
        r9 = com.google.android.gms.measurement.internal.zzet.zza(r46.zzb);
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x060c, code lost:
    
        if (r8.zza() == false) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x060e, code lost:
    
        r8 = java.lang.Integer.valueOf(r8.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0617, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0618, code lost:
    
        r7.zza("Invalid property filter ID. appId, id", r9, java.lang.String.valueOf(r8));
        r8 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final java.util.List<com.google.android.gms.internal.measurement.zzbw.zza> zza(java.lang.String r47, java.util.List<com.google.android.gms.internal.measurement.zzbw.zzc> r48, java.util.List<com.google.android.gms.internal.measurement.zzbw.zzk> r49, java.lang.Long r50, java.lang.Long r51) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1748
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    private final zzs zza(int i) {
        if (this.zzd.containsKey(Integer.valueOf(i))) {
            return this.zzd.get(Integer.valueOf(i));
        }
        zzs zzsVar = new zzs(this, this.zzb, null);
        this.zzd.put(Integer.valueOf(i), zzsVar);
        return zzsVar;
    }

    private final boolean zza(int i, int i2) {
        if (this.zzd.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.zzd.get(Integer.valueOf(i)).zzd.get(i2);
    }
}
