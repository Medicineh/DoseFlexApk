package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfl {
    private final String zza;
    private final String zzb;
    private boolean zzc;
    private String zzd;
    private final /* synthetic */ zzff zze;

    public zzfl(zzff zzffVar, String str, String str2) {
        this.zze = zzffVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = null;
    }

    public final String zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzg().getString(this.zza, null);
        }
        return this.zzd;
    }

    public final void zza(String str) {
        if (this.zze.zzt().zza(zzas.zzbx) || !zzko.zzc(str, this.zzd)) {
            SharedPreferences.Editor editorEdit = this.zze.zzg().edit();
            editorEdit.putString(this.zza, str);
            editorEdit.apply();
            this.zzd = str;
        }
    }
}
