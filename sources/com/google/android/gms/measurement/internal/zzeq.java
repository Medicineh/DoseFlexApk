package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzle;
import com.google.android.gms.internal.measurement.zzmz;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzeq extends zze {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private List<String> zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;

    zzeq(zzfx zzfxVar, long j) {
        super(zzfxVar);
        this.zzg = j;
    }

    @Override // com.google.android.gms.measurement.internal.zze
    protected final boolean zzz() {
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:0|2|(1:4)(28:124|6|(1:10)(2:11|(1:13))|122|14|(4:16|(1:18)(1:20)|128|21)|26|(1:31)(1:30)|32|(1:37)(1:36)|38|(1:(1:41)(1:42))|(3:44|SW:45|(1:56)(1:57))(0)|58|(1:60)|126|61|(1:66)(1:65)|67|(1:69)(1:70)|71|72|(2:85|(1:87))(4:76|(1:78)(1:79)|80|(1:84))|(3:89|(1:91)(1:92)|93)|97|(3:99|(3:101|(1:103)(3:105|(3:108|(1:131)(1:132)|106)|130)|104)|(1:112))|113|(1:(2:116|117)(2:118|119))(2:120|121))|5|26|(2:28|31)(0)|32|(2:34|37)(0)|38|(0)|(0)(0)|58|(0)|126|61|(7:63|66|67|(0)(0)|71|72|(4:74|85|(0)|(0))(0))(0)|97|(0)|113|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x024f, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0250, code lost:
    
        zzr().zzf().zza("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzet.zza(r0), r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01cc A[Catch: IllegalStateException -> 0x024f, TryCatch #2 {IllegalStateException -> 0x024f, blocks: (B:61:0x01aa, B:63:0x01b0, B:65:0x01bc, B:67:0x01d0, B:71:0x01d9, B:74:0x01e3, B:76:0x01ef, B:80:0x0206, B:82:0x020e, B:89:0x0232, B:91:0x0246, B:93:0x024b, B:92:0x0249, B:84:0x0214, B:85:0x021b, B:87:0x0221, B:66:0x01cc), top: B:126:0x01aa }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x021b A[Catch: IllegalStateException -> 0x024f, TryCatch #2 {IllegalStateException -> 0x024f, blocks: (B:61:0x01aa, B:63:0x01b0, B:65:0x01bc, B:67:0x01d0, B:71:0x01d9, B:74:0x01e3, B:76:0x01ef, B:80:0x0206, B:82:0x020e, B:89:0x0232, B:91:0x0246, B:93:0x024b, B:92:0x0249, B:84:0x0214, B:85:0x021b, B:87:0x0221, B:66:0x01cc), top: B:126:0x01aa }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0221 A[Catch: IllegalStateException -> 0x024f, TryCatch #2 {IllegalStateException -> 0x024f, blocks: (B:61:0x01aa, B:63:0x01b0, B:65:0x01bc, B:67:0x01d0, B:71:0x01d9, B:74:0x01e3, B:76:0x01ef, B:80:0x0206, B:82:0x020e, B:89:0x0232, B:91:0x0246, B:93:0x024b, B:92:0x0249, B:84:0x0214, B:85:0x021b, B:87:0x0221, B:66:0x01cc), top: B:126:0x01aa }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0232 A[Catch: IllegalStateException -> 0x024f, TryCatch #2 {IllegalStateException -> 0x024f, blocks: (B:61:0x01aa, B:63:0x01b0, B:65:0x01bc, B:67:0x01d0, B:71:0x01d9, B:74:0x01e3, B:76:0x01ef, B:80:0x0206, B:82:0x020e, B:89:0x0232, B:91:0x0246, B:93:0x024b, B:92:0x0249, B:84:0x0214, B:85:0x021b, B:87:0x0221, B:66:0x01cc), top: B:126:0x01aa }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0270  */
    @Override // com.google.android.gms.measurement.internal.zze
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void zzaa() {
        /*
            Method dump skipped, instruction units count: 738
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeq.zzaa():void");
    }

    final zzm zza(String str) {
        boolean z;
        long jMin;
        zzd();
        zzb();
        String strZzab = zzab();
        String strZzac = zzac();
        zzw();
        String str2 = this.zzb;
        long jZzaf = zzaf();
        zzw();
        String str3 = this.zzd;
        long jZzf = zzt().zzf();
        zzw();
        zzd();
        if (this.zzf == 0) {
            this.zzf = this.zzz.zzi().zza(zzn(), zzn().getPackageName());
        }
        long j = this.zzf;
        boolean zZzab = this.zzz.zzab();
        boolean z2 = !zzs().zzr;
        zzd();
        zzb();
        String strZzai = !this.zzz.zzab() ? null : zzai();
        zzfx zzfxVar = this.zzz;
        Long lValueOf = Long.valueOf(zzfxVar.zzc().zzh.zza());
        if (lValueOf.longValue() == 0) {
            jMin = zzfxVar.zza;
            z = zZzab;
        } else {
            z = zZzab;
            jMin = Math.min(zzfxVar.zza, lValueOf.longValue());
        }
        int iZzag = zzag();
        boolean zBooleanValue = zzt().zzi().booleanValue();
        zzaa zzaaVarZzt = zzt();
        zzaaVarZzt.zzb();
        Boolean boolZzd = zzaaVarZzt.zzd("google_analytics_ssaid_collection_enabled");
        boolean zBooleanValue2 = Boolean.valueOf(boolZzd == null || boolZzd.booleanValue()).booleanValue();
        zzff zzffVarZzs = zzs();
        zzffVarZzs.zzd();
        return new zzm(strZzab, strZzac, str2, jZzaf, str3, jZzf, j, str, z, z2, strZzai, 0L, jMin, iZzag, zBooleanValue, zBooleanValue2, zzffVarZzs.zzg().getBoolean("deferred_analytics_collection", false), zzad(), zzt().zzd("google_analytics_default_allow_ad_personalization_signals") == null ? null : Boolean.valueOf(!r1.booleanValue()), this.zzg, zzt().zza(zzas.zzbc) ? this.zzh : null, (zzle.zzb() && zzt().zza(zzas.zzbo)) ? zzae() : null);
    }

    private final String zzai() {
        if (zzmz.zzb() && zzt().zza(zzas.zzbr)) {
            zzr().zzx().zza("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> clsLoadClass = zzn().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (clsLoadClass == null) {
                return null;
            }
            try {
                Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, zzn());
                if (objInvoke == null) {
                    return null;
                }
                try {
                    return (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                } catch (Exception unused) {
                    zzr().zzk().zza("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                zzr().zzj().zza("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    final String zzab() {
        zzw();
        return this.zza;
    }

    final String zzac() {
        zzw();
        return this.zzj;
    }

    final String zzad() {
        zzw();
        return this.zzk;
    }

    final String zzae() {
        zzw();
        return this.zzl;
    }

    final int zzaf() {
        zzw();
        return this.zzc;
    }

    final int zzag() {
        zzw();
        return this.zzi;
    }

    final List<String> zzah() {
        return this.zzh;
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzhc zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzeq zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzin zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzih zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzep zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzjs zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzak zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzer zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzko zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ zzfu zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ zzet zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzff zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzaa zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ zzv zzu() {
        return super.zzu();
    }
}
