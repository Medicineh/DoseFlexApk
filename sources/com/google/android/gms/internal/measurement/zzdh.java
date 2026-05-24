package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzdh {
    public static <T> zzde<T> zza(zzde<T> zzdeVar) {
        return ((zzdeVar instanceof zzdj) || (zzdeVar instanceof zzdg)) ? zzdeVar : zzdeVar instanceof Serializable ? new zzdg(zzdeVar) : new zzdj(zzdeVar);
    }

    public static <T> zzde<T> zza(@NullableDecl T t) {
        return new zzdi(t);
    }
}
