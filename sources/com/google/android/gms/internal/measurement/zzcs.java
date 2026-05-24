package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzcs extends zzcq<Long> {
    zzcs(zzcw zzcwVar, String str, Long l, boolean z) {
        super(zzcwVar, str, l, z, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzcq
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final Long zza(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String strZzb = super.zzb();
        String strValueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(strZzb).length() + 25 + String.valueOf(strValueOf).length());
        sb.append("Invalid long value for ");
        sb.append(strZzb);
        sb.append(": ");
        sb.append(strValueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
