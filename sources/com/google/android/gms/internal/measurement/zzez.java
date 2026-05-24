package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfi;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzez extends zzex<zzfi.zzc> {
    zzez() {
    }

    @Override // com.google.android.gms.internal.measurement.zzex
    final boolean zza(zzgt zzgtVar) {
        return zzgtVar instanceof zzfi.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzex
    final zzfb<zzfi.zzc> zza(Object obj) {
        return ((zzfi.zzd) obj).zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzex
    final zzfb<zzfi.zzc> zzb(Object obj) {
        return ((zzfi.zzd) obj).zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzex
    final void zzc(Object obj) {
        zza(obj).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzex
    final <UT, UB> UB zza(zzhj zzhjVar, Object obj, zzev zzevVar, zzfb<zzfi.zzc> zzfbVar, UB ub, zzia<UT, UB> zziaVar) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzex
    final int zza(Map.Entry<?, ?> entry) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzex
    final void zza(zzix zzixVar, Map.Entry<?, ?> entry) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzex
    final Object zza(zzev zzevVar, zzgt zzgtVar, int i) {
        return zzevVar.zza(zzgtVar, i);
    }

    @Override // com.google.android.gms.internal.measurement.zzex
    final void zza(zzhj zzhjVar, Object obj, zzev zzevVar, zzfb<zzfi.zzc> zzfbVar) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzex
    final void zza(zzdz zzdzVar, Object obj, zzev zzevVar, zzfb<zzfi.zzc> zzfbVar) throws IOException {
        throw new NoSuchMethodError();
    }
}
