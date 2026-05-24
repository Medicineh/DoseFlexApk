package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public class zzfy {
    private static final zzev zza = zzev.zza();
    private zzdz zzb;
    private volatile zzgt zzc;
    private volatile zzdz zzd;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfy)) {
            return false;
        }
        zzfy zzfyVar = (zzfy) obj;
        zzgt zzgtVar = this.zzc;
        zzgt zzgtVar2 = zzfyVar.zzc;
        if (zzgtVar == null && zzgtVar2 == null) {
            return zzc().equals(zzfyVar.zzc());
        }
        if (zzgtVar != null && zzgtVar2 != null) {
            return zzgtVar.equals(zzgtVar2);
        }
        if (zzgtVar != null) {
            return zzgtVar.equals(zzfyVar.zzb(zzgtVar.zzbt()));
        }
        return zzb(zzgtVar2.zzbt()).equals(zzgtVar2);
    }

    private final zzgt zzb(zzgt zzgtVar) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzgtVar;
                        this.zzd = zzdz.zza;
                    } catch (zzft unused) {
                        this.zzc = zzgtVar;
                        this.zzd = zzdz.zza;
                    }
                }
            }
        }
        return this.zzc;
    }

    public final zzgt zza(zzgt zzgtVar) {
        zzgt zzgtVar2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzgtVar;
        return zzgtVar2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzbn();
        }
        return 0;
    }

    public final zzdz zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            if (this.zzc == null) {
                this.zzd = zzdz.zza;
            } else {
                this.zzd = this.zzc.zzbh();
            }
            return this.zzd;
        }
    }
}
