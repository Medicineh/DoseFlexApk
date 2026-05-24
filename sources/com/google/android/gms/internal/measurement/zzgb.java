package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzgb extends zzdt<String> implements zzga, RandomAccess {
    private static final zzgb zza;
    private static final zzga zzb;
    private final List<Object> zzc;

    public zzgb() {
        this(10);
    }

    public zzgb(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzgb(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzdt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.measurement.zzdt, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzc();
        if (collection instanceof zzga) {
            collection = ((zzga) collection).zzb();
        }
        boolean zAddAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.measurement.zzdt, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzc();
        this.zzc.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    public final void zza(zzdz zzdzVar) {
        zzc();
        this.zzc.add(zzdzVar);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    public final Object zzb(int i) {
        return this.zzc.get(i);
    }

    private static String zza(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdz) {
            return ((zzdz) obj).zzb();
        }
        return zzfk.zzb((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    public final List<?> zzb() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    public final zzga g_() {
        return zza() ? new zzif(this) : this;
    }

    @Override // com.google.android.gms.internal.measurement.zzdt, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zzc();
        return zza(this.zzc.set(i, (String) obj));
    }

    @Override // com.google.android.gms.internal.measurement.zzdt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.measurement.zzdt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.measurement.zzdt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzdt, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzc();
        Object objRemove = this.zzc.remove(i);
        this.modCount++;
        return zza(objRemove);
    }

    @Override // com.google.android.gms.internal.measurement.zzdt, com.google.android.gms.internal.measurement.zzfq
    public final /* bridge */ /* synthetic */ boolean zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzdt, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzc();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzdt, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzdt, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.zzdt, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzfq
    public final /* synthetic */ zzfq zza(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzgb((ArrayList<Object>) arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdz) {
            zzdz zzdzVar = (zzdz) obj;
            String strZzb = zzdzVar.zzb();
            if (zzdzVar.zzc()) {
                this.zzc.set(i, strZzb);
            }
            return strZzb;
        }
        byte[] bArr = (byte[]) obj;
        String strZzb2 = zzfk.zzb(bArr);
        if (zzfk.zza(bArr)) {
            this.zzc.set(i, strZzb2);
        }
        return strZzb2;
    }

    static {
        zzgb zzgbVar = new zzgb();
        zza = zzgbVar;
        zzgbVar.h_();
        zzb = zza;
    }
}
