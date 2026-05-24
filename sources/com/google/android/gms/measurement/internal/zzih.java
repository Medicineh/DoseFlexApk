package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzkx;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzih extends zze {
    protected zzii zza;
    private volatile zzii zzb;
    private zzii zzc;
    private final Map<Activity, zzii> zzd;
    private Activity zze;
    private volatile zzii zzf;
    private zzii zzg;
    private boolean zzh;
    private final Object zzi;
    private zzii zzj;
    private String zzk;

    public zzih(zzfx zzfxVar) {
        super(zzfxVar);
        this.zzi = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    protected final boolean zzz() {
        return false;
    }

    public final zzii zza(boolean z) {
        zzw();
        zzd();
        if (!zzt().zza(zzas.zzcd) || !z) {
            return this.zza;
        }
        zzii zziiVar = this.zza;
        return zziiVar != null ? zziiVar : this.zzg;
    }

    public final void zza(Activity activity, String str, String str2) {
        if (!zzt().zzj().booleanValue()) {
            zzr().zzk().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        if (this.zzb == null) {
            zzr().zzk().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.zzd.get(activity) == null) {
            zzr().zzk().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zza(activity.getClass().getCanonicalName());
        }
        boolean zZzc = zzko.zzc(this.zzb.zzb, str2);
        boolean zZzc2 = zzko.zzc(this.zzb.zza, str);
        if (zZzc && zZzc2) {
            zzr().zzk().zza("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > 100)) {
            zzr().zzk().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > 100)) {
            zzr().zzk().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzr().zzx().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
        zzii zziiVar = new zzii(str, str2, zzp().zzg());
        this.zzd.put(activity, zziiVar);
        zza(activity, zziiVar, true);
    }

    public final zzii zzab() {
        zzb();
        return this.zzb;
    }

    private final void zza(Activity activity, zzii zziiVar, boolean z) {
        zzii zziiVar2;
        zzii zziiVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zziiVar.zzb == null) {
            zziiVar2 = new zzii(zziiVar.zza, activity != null ? zza(activity.getClass().getCanonicalName()) : null, zziiVar.zzc, zziiVar.zze);
        } else {
            zziiVar2 = zziiVar;
        }
        this.zzc = this.zzb;
        this.zzb = zziiVar2;
        zzq().zza(new zzik(this, zziiVar2, zziiVar3, zzm().elapsedRealtime(), z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzii zziiVar, zzii zziiVar2, long j, boolean z, Bundle bundle) {
        boolean z2;
        zzii zziiVar3;
        long jZzb;
        zzd();
        if (zzt().zza(zzas.zzat)) {
            z2 = z && this.zza != null;
            if (z2) {
                zza(this.zza, true, j);
            }
        } else {
            if (z && (zziiVar3 = this.zza) != null) {
                zza(zziiVar3, true, j);
            }
            z2 = false;
        }
        if ((zziiVar2 != null && zziiVar2.zzc == zziiVar.zzc && zzko.zzc(zziiVar2.zzb, zziiVar.zzb) && zzko.zzc(zziiVar2.zza, zziiVar.zza)) ? false : true) {
            Bundle bundle2 = new Bundle();
            if (zzt().zza(zzas.zzcd)) {
                bundle2 = new Bundle();
            }
            zza(zziiVar, bundle2, true);
            if (zziiVar2 != null) {
                if (zziiVar2.zza != null) {
                    bundle2.putString("_pn", zziiVar2.zza);
                }
                if (zziiVar2.zzb != null) {
                    bundle2.putString("_pc", zziiVar2.zzb);
                }
                bundle2.putLong("_pi", zziiVar2.zzc);
            }
            if (zzt().zza(zzas.zzat) && z2) {
                if (zzkx.zzb() && zzt().zza(zzas.zzav) && com.google.android.gms.internal.measurement.zzkm.zzb() && zzt().zza(zzas.zzca)) {
                    jZzb = zzk().zzb.zzc(j);
                } else {
                    jZzb = zzk().zzb.zzb();
                }
                if (jZzb > 0) {
                    zzp().zza(bundle2, jZzb);
                }
            }
            String str = "auto";
            if (zzt().zza(zzas.zzcd)) {
                if (!zzt().zzj().booleanValue()) {
                    bundle2.putLong("_mt", 1L);
                }
                if (zziiVar.zze) {
                    str = "app";
                }
            }
            zzf().zzb(str, "_vs", bundle2);
        }
        this.zza = zziiVar;
        if (zzt().zza(zzas.zzcd) && zziiVar.zze) {
            this.zzg = zziiVar;
        }
        zzh().zza(zziiVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzii zziiVar, boolean z, long j) {
        zze().zza(zzm().elapsedRealtime());
        if (!zzk().zza(zziiVar != null && zziiVar.zzd, z, j) || zziiVar == null) {
            return;
        }
        zziiVar.zzd = false;
    }

    public static void zza(zzii zziiVar, Bundle bundle, boolean z) {
        if (bundle == null || zziiVar == null || (bundle.containsKey("_sc") && !z)) {
            if (bundle != null && zziiVar == null && z) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        if (zziiVar.zza != null) {
            bundle.putString("_sn", zziiVar.zza);
        } else {
            bundle.remove("_sn");
        }
        if (zziiVar.zzb != null) {
            bundle.putString("_sc", zziiVar.zzb);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", zziiVar.zzc);
    }

    public final void zza(String str, zzii zziiVar) {
        zzd();
        synchronized (this) {
            if (this.zzk == null || this.zzk.equals(str) || zziiVar != null) {
                this.zzk = str;
                this.zzj = zziiVar;
            }
        }
    }

    private static String zza(String str) {
        String[] strArrSplit = str.split("\\.");
        String str2 = strArrSplit.length > 0 ? strArrSplit[strArrSplit.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    private final zzii zzd(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzii zziiVar = this.zzd.get(activity);
        if (zziiVar == null) {
            zzii zziiVar2 = new zzii(null, zza(activity.getClass().getCanonicalName()), zzp().zzg());
            this.zzd.put(activity, zziiVar2);
            zziiVar = zziiVar2;
        }
        if (!zzt().zza(zzas.zzcd)) {
        }
        return zziiVar;
    }

    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!zzt().zzj().booleanValue() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(activity, new zzii(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void zza(Activity activity) {
        if (zzt().zza(zzas.zzcd)) {
            synchronized (this.zzi) {
                this.zzh = true;
                if (activity != this.zze) {
                    synchronized (this.zzi) {
                        this.zze = activity;
                    }
                    if (zzt().zza(zzas.zzcc) && zzt().zzj().booleanValue()) {
                        this.zzf = null;
                        zzq().zza(new zzio(this));
                    }
                }
            }
        }
        if (zzt().zza(zzas.zzcc) && !zzt().zzj().booleanValue()) {
            this.zzb = this.zzf;
            zzq().zza(new zzij(this));
        } else {
            zza(activity, zzd(activity), false);
            zzb zzbVarZze = zze();
            zzbVarZze.zzq().zza(new zzc(zzbVarZze, zzbVarZze.zzm().elapsedRealtime()));
        }
    }

    public final void zzb(Activity activity) {
        if (zzt().zza(zzas.zzcd)) {
            synchronized (this.zzi) {
                this.zzh = false;
            }
        }
        if (zzt().zza(zzas.zzcc) && !zzt().zzj().booleanValue()) {
            this.zzb = null;
            zzq().zza(new zzim(this));
            return;
        }
        zzii zziiVarZzd = zzd(activity);
        this.zzc = this.zzb;
        this.zzb = null;
        zzq().zza(new zzil(this, zziiVarZzd, zzm().elapsedRealtime()));
    }

    public final void zzb(Activity activity, Bundle bundle) {
        zzii zziiVar;
        if (!zzt().zzj().booleanValue() || bundle == null || (zziiVar = this.zzd.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zziiVar.zzc);
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, zziiVar.zza);
        bundle2.putString("referrer_name", zziiVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    public final void zzc(Activity activity) {
        synchronized (this.zzi) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (zzt().zzj().booleanValue()) {
            this.zzd.remove(activity);
        }
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

    static /* synthetic */ zzii zza(zzih zzihVar, zzii zziiVar) {
        zzihVar.zzg = null;
        return null;
    }
}
