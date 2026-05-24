package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzki implements zzfc {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzkg zzb;

    zzki(zzkg zzkgVar, String str) {
        this.zzb = zzkgVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzfc
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzb.zza(i, th, bArr, this.zza);
    }
}
