package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzex<T extends zzfd<T>> {
    zzex() {
    }

    abstract int zza(Map.Entry<?, ?> entry);

    abstract zzfb<T> zza(Object obj);

    abstract Object zza(zzev zzevVar, zzgt zzgtVar, int i);

    abstract <UT, UB> UB zza(zzhj zzhjVar, Object obj, zzev zzevVar, zzfb<T> zzfbVar, UB ub, zzia<UT, UB> zziaVar) throws IOException;

    abstract void zza(zzdz zzdzVar, Object obj, zzev zzevVar, zzfb<T> zzfbVar) throws IOException;

    abstract void zza(zzhj zzhjVar, Object obj, zzev zzevVar, zzfb<T> zzfbVar) throws IOException;

    abstract void zza(zzix zzixVar, Map.Entry<?, ?> entry) throws IOException;

    abstract boolean zza(zzgt zzgtVar);

    abstract zzfb<T> zzb(Object obj);

    abstract void zzc(Object obj);
}
