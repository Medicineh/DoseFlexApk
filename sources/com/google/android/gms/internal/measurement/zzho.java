package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzho extends zzhu {
    private final /* synthetic */ zzhn zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzho(zzhn zzhnVar) {
        super(zzhnVar, null);
        this.zza = zzhnVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzhu, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzhp(this.zza, null);
    }

    /* synthetic */ zzho(zzhn zzhnVar, zzhm zzhmVar) {
        this(zzhnVar);
    }
}
