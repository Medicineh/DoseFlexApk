package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzic extends zzia<zzid, zzid> {
    zzic() {
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final boolean zza(zzhj zzhjVar) {
        return false;
    }

    /* JADX INFO: renamed from: zza, reason: avoid collision after fix types in other method */
    private static void zza2(Object obj, zzid zzidVar) {
        ((zzfi) obj).zzb = zzidVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final void zzd(Object obj) {
        ((zzfi) obj).zzb.zzc();
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final /* synthetic */ int zzf(zzid zzidVar) {
        return zzidVar.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final /* synthetic */ int zze(zzid zzidVar) {
        return zzidVar.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final /* synthetic */ zzid zzc(zzid zzidVar, zzid zzidVar2) {
        zzid zzidVar3 = zzidVar;
        zzid zzidVar4 = zzidVar2;
        return zzidVar4.equals(zzid.zza()) ? zzidVar3 : zzid.zza(zzidVar3, zzidVar4);
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final /* synthetic */ void zzb(zzid zzidVar, zzix zzixVar) throws IOException {
        zzidVar.zza(zzixVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final /* synthetic */ void zza(zzid zzidVar, zzix zzixVar) throws IOException {
        zzidVar.zzb(zzixVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final /* synthetic */ void zzb(Object obj, zzid zzidVar) {
        zza2(obj, zzidVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final /* synthetic */ zzid zzc(Object obj) {
        zzid zzidVar = ((zzfi) obj).zzb;
        if (zzidVar != zzid.zza()) {
            return zzidVar;
        }
        zzid zzidVarZzb = zzid.zzb();
        zza2(obj, zzidVarZzb);
        return zzidVarZzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final /* synthetic */ zzid zzb(Object obj) {
        return ((zzfi) obj).zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final /* bridge */ /* synthetic */ void zza(Object obj, zzid zzidVar) {
        zza2(obj, zzidVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final /* synthetic */ zzid zza(zzid zzidVar) {
        zzid zzidVar2 = zzidVar;
        zzidVar2.zzc();
        return zzidVar2;
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final /* synthetic */ zzid zza() {
        return zzid.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final /* synthetic */ void zza(zzid zzidVar, int i, zzid zzidVar2) {
        zzidVar.zza((i << 3) | 3, zzidVar2);
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final /* synthetic */ void zza(zzid zzidVar, int i, zzdz zzdzVar) {
        zzidVar.zza((i << 3) | 2, zzdzVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final /* synthetic */ void zzb(zzid zzidVar, int i, long j) {
        zzidVar.zza((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final /* synthetic */ void zza(zzid zzidVar, int i, int i2) {
        zzidVar.zza((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    final /* synthetic */ void zza(zzid zzidVar, int i, long j) {
        zzidVar.zza(i << 3, Long.valueOf(j));
    }
}
