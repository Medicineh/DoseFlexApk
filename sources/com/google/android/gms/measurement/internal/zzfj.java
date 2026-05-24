package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfj {
    private final String zza;
    private final long zzb;
    private boolean zzc;
    private long zzd;
    private final /* synthetic */ zzff zze;

    public zzfj(zzff zzffVar, String str, long j) {
        this.zze = zzffVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = j;
    }

    public final long zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzg().getLong(this.zza, this.zzb);
        }
        return this.zzd;
    }

    public final void zza(long j) {
        SharedPreferences.Editor editorEdit = this.zze.zzg().edit();
        editorEdit.putLong(this.zza, j);
        editorEdit.apply();
        this.zzd = j;
    }
}
