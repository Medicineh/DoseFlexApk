package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzew implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ Object zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzet zzf;

    zzew(zzet zzetVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzetVar;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzff zzffVarZzc = this.zzf.zzz.zzc();
        if (!zzffVarZzc.zzz()) {
            this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.zzf.zza == 0) {
            if (this.zzf.zzt().zzg()) {
                zzet zzetVar = this.zzf;
                zzetVar.zzu();
                zzetVar.zza = 'C';
            } else {
                zzet zzetVar2 = this.zzf;
                zzetVar2.zzu();
                zzetVar2.zza = 'c';
            }
        }
        if (this.zzf.zzb < 0) {
            zzet zzetVar3 = this.zzf;
            zzetVar3.zzb = zzetVar3.zzt().zzf();
        }
        char cCharAt = "01VDIWEA?".charAt(this.zza);
        char c = this.zzf.zza;
        long j = this.zzf.zzb;
        String strZza = zzet.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
        StringBuilder sb = new StringBuilder(String.valueOf(strZza).length() + 24);
        sb.append("2");
        sb.append(cCharAt);
        sb.append(c);
        sb.append(j);
        sb.append(":");
        sb.append(strZza);
        String string = sb.toString();
        if (string.length() > 1024) {
            string = this.zzb.substring(0, 1024);
        }
        zzffVarZzc.zzb.zza(string, 1L);
    }
}
