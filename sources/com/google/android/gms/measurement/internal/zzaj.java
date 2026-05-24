package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaj {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final zzal zze;
    private final String zzf;

    private zzaj(zzfx zzfxVar, String str, String str2, String str3, long j, long j2, zzal zzalVar) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzalVar);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzfxVar.zzr().zzi().zza("Event created with reverse previous/current timestamps. appId, name", zzet.zza(str2), zzet.zza(str3));
        }
        this.zze = zzalVar;
    }

    zzaj(zzfx zzfxVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzal zzalVar;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzfxVar.zzr().zzi().zza("Event created with reverse previous/current timestamps. appId", zzet.zza(str2));
        }
        if (bundle != null && !bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzfxVar.zzr().zzf().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object objZza = zzfxVar.zzi().zza(next, bundle2.get(next));
                    if (objZza == null) {
                        zzfxVar.zzr().zzi().zza("Param value can't be null", zzfxVar.zzj().zzb(next));
                        it.remove();
                    } else {
                        zzfxVar.zzi().zza(bundle2, next, objZza);
                    }
                }
            }
            zzalVar = new zzal(bundle2);
        } else {
            zzalVar = new zzal(new Bundle());
        }
        this.zze = zzalVar;
    }

    final zzaj zza(zzfx zzfxVar, long j) {
        return new zzaj(zzfxVar, this.zzf, this.zza, this.zzb, this.zzc, j, this.zze);
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String strValueOf = String.valueOf(this.zze);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(strValueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(strValueOf);
        sb.append('}');
        return sb.toString();
    }
}
