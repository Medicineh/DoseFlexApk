package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzeb implements Comparator<zzdz> {
    zzeb() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzdz zzdzVar, zzdz zzdzVar2) {
        zzdz zzdzVar3 = zzdzVar;
        zzdz zzdzVar4 = zzdzVar2;
        zzei zzeiVar = (zzei) zzdzVar3.iterator();
        zzei zzeiVar2 = (zzei) zzdzVar4.iterator();
        while (zzeiVar.hasNext() && zzeiVar2.hasNext()) {
            int iCompare = Integer.compare(zzdz.zzb(zzeiVar.zza()), zzdz.zzb(zzeiVar2.zza()));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(zzdzVar3.zza(), zzdzVar4.zza());
    }
}
