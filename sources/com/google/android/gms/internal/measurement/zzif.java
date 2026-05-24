package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzif extends AbstractList<String> implements zzga, RandomAccess {
    private final zzga zza;

    public zzif(zzga zzgaVar) {
        this.zza = zzgaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    public final zzga g_() {
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    public final Object zzb(int i) {
        return this.zza.zzb(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    public final void zza(zzdz zzdzVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzie(this, i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzih(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    public final List<?> zzb() {
        return this.zza.zzb();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }
}
