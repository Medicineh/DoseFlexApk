package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzcv extends zzcq<Boolean> {
    zzcv(zzcw zzcwVar, String str, Boolean bool, boolean z) {
        super(zzcwVar, str, bool, z, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcq
    final /* synthetic */ Boolean zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzcb.zzb.matcher(str).matches()) {
                return true;
            }
            if (zzcb.zzc.matcher(str).matches()) {
                return false;
            }
        }
        String strZzb = super.zzb();
        String strValueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(strZzb).length() + 28 + String.valueOf(strValueOf).length());
        sb.append("Invalid boolean value for ");
        sb.append(strZzb);
        sb.append(": ");
        sb.append(strValueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
