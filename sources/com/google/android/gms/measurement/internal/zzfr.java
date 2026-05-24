package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzbt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfr extends zzkd implements zzac {
    private static int zzb = 65535;
    private static int zzc = 2;
    private final Map<String, Map<String, String>> zzd;
    private final Map<String, Map<String, Boolean>> zze;
    private final Map<String, Map<String, Boolean>> zzf;
    private final Map<String, zzbt.zzb> zzg;
    private final Map<String, Map<String, Integer>> zzh;
    private final Map<String, String> zzi;

    zzfr(zzkg zzkgVar) {
        super(zzkgVar);
        this.zzd = new ArrayMap();
        this.zze = new ArrayMap();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
        this.zzi = new ArrayMap();
        this.zzh = new ArrayMap();
    }

    @Override // com.google.android.gms.measurement.internal.zzkd
    protected final boolean zze() {
        return false;
    }

    private final void zzi(String str) throws Throwable {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        if (this.zzg.get(str) == null) {
            byte[] bArrZzd = zzi().zzd(str);
            if (bArrZzd == null) {
                this.zzd.put(str, null);
                this.zze.put(str, null);
                this.zzf.put(str, null);
                this.zzg.put(str, null);
                this.zzi.put(str, null);
                this.zzh.put(str, null);
                return;
            }
            zzbt.zzb.zza zzaVarZzbm = zza(str, bArrZzd).zzbm();
            zza(str, zzaVarZzbm);
            this.zzd.put(str, zza((zzbt.zzb) ((com.google.android.gms.internal.measurement.zzfi) zzaVarZzbm.zzu())));
            this.zzg.put(str, (zzbt.zzb) ((com.google.android.gms.internal.measurement.zzfi) zzaVarZzbm.zzu()));
            this.zzi.put(str, null);
        }
    }

    protected final zzbt.zzb zza(String str) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        zzi(str);
        return this.zzg.get(str);
    }

    protected final String zzb(String str) {
        zzd();
        return this.zzi.get(str);
    }

    protected final void zzc(String str) {
        zzd();
        this.zzi.put(str, null);
    }

    final void zzd(String str) {
        zzd();
        this.zzg.remove(str);
    }

    final boolean zze(String str) {
        zzd();
        zzbt.zzb zzbVarZza = zza(str);
        if (zzbVarZza == null) {
            return false;
        }
        return zzbVarZza.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzac
    public final String zza(String str, String str2) throws Throwable {
        zzd();
        zzi(str);
        Map<String, String> map = this.zzd.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    private static Map<String, String> zza(zzbt.zzb zzbVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzbVar != null) {
            for (zzbt.zzc zzcVar : zzbVar.zze()) {
                arrayMap.put(zzcVar.zza(), zzcVar.zzb());
            }
        }
        return arrayMap;
    }

    private final void zza(String str, zzbt.zzb.zza zzaVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzaVar != null) {
            for (int i = 0; i < zzaVar.zza(); i++) {
                zzbt.zza.C0006zza c0006zzaZzbm = zzaVar.zza(i).zzbm();
                if (TextUtils.isEmpty(c0006zzaZzbm.zza())) {
                    zzr().zzi().zza("EventConfig contained null event name");
                } else {
                    String strZzb = zzgw.zzb(c0006zzaZzbm.zza());
                    if (!TextUtils.isEmpty(strZzb)) {
                        c0006zzaZzbm = c0006zzaZzbm.zza(strZzb);
                        zzaVar.zza(i, c0006zzaZzbm);
                    }
                    arrayMap.put(c0006zzaZzbm.zza(), Boolean.valueOf(c0006zzaZzbm.zzb()));
                    arrayMap2.put(c0006zzaZzbm.zza(), Boolean.valueOf(c0006zzaZzbm.zzc()));
                    if (c0006zzaZzbm.zzd()) {
                        if (c0006zzaZzbm.zze() < zzc || c0006zzaZzbm.zze() > zzb) {
                            zzr().zzi().zza("Invalid sampling rate. Event name, sample rate", c0006zzaZzbm.zza(), Integer.valueOf(c0006zzaZzbm.zze()));
                        } else {
                            arrayMap3.put(c0006zzaZzbm.zza(), Integer.valueOf(c0006zzaZzbm.zze()));
                        }
                    }
                }
            }
        }
        this.zze.put(str, arrayMap);
        this.zzf.put(str, arrayMap2);
        this.zzh.put(str, arrayMap3);
    }

    protected final boolean zza(String str, byte[] bArr, String str2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        zzbt.zzb.zza zzaVarZzbm = zza(str, bArr).zzbm();
        if (zzaVarZzbm == null) {
            return false;
        }
        zza(str, zzaVarZzbm);
        this.zzg.put(str, (zzbt.zzb) ((com.google.android.gms.internal.measurement.zzfi) zzaVarZzbm.zzu()));
        this.zzi.put(str, str2);
        this.zzd.put(str, zza((zzbt.zzb) ((com.google.android.gms.internal.measurement.zzfi) zzaVarZzbm.zzu())));
        zzi().zza(str, new ArrayList(zzaVarZzbm.zzb()));
        try {
            zzaVarZzbm.zzc();
            bArr = ((zzbt.zzb) ((com.google.android.gms.internal.measurement.zzfi) zzaVarZzbm.zzu())).zzbi();
        } catch (RuntimeException e) {
            zzr().zzi().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzet.zza(str), e);
        }
        zzab zzabVarZzi = zzi();
        Preconditions.checkNotEmpty(str);
        zzabVarZzi.zzd();
        zzabVarZzi.zzak();
        new ContentValues().put("remote_config", bArr);
        try {
            if (zzabVarZzi.c_().update("apps", r2, "app_id = ?", new String[]{str}) == 0) {
                zzabVarZzi.zzr().zzf().zza("Failed to update remote config (got 0). appId", zzet.zza(str));
            }
        } catch (SQLiteException e2) {
            zzabVarZzi.zzr().zzf().zza("Error storing remote config. appId", zzet.zza(str), e2);
        }
        this.zzg.put(str, (zzbt.zzb) ((com.google.android.gms.internal.measurement.zzfi) zzaVarZzbm.zzu()));
        return true;
    }

    final boolean zzb(String str, String str2) throws Throwable {
        Boolean bool;
        zzd();
        zzi(str);
        if (zzg(str) && zzko.zze(str2)) {
            return true;
        }
        if (zzh(str) && zzko.zza(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zze.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final boolean zzc(String str, String str2) throws Throwable {
        Boolean bool;
        zzd();
        zzi(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2)) {
            return true;
        }
        if (com.google.android.gms.internal.measurement.zzjt.zzb() && zzt().zza(zzas.zzcj) && (FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2))) {
            return true;
        }
        Map<String, Boolean> map = this.zzf.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final int zzd(String str, String str2) throws Throwable {
        Integer num;
        zzd();
        zzi(str);
        Map<String, Integer> map = this.zzh.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    final long zzf(String str) throws Throwable {
        String strZza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(strZza)) {
            return 0L;
        }
        try {
            return Long.parseLong(strZza);
        } catch (NumberFormatException e) {
            zzr().zzi().zza("Unable to parse timezone offset. appId", zzet.zza(str), e);
            return 0L;
        }
    }

    private final zzbt.zzb zza(String str, byte[] bArr) {
        if (bArr == null) {
            return zzbt.zzb.zzj();
        }
        try {
            zzbt.zzb zzbVar = (zzbt.zzb) ((com.google.android.gms.internal.measurement.zzfi) ((zzbt.zzb.zza) zzkk.zza(zzbt.zzb.zzi(), bArr)).zzu());
            zzr().zzx().zza("Parsed config. version, gmp_app_id", zzbVar.zza() ? Long.valueOf(zzbVar.zzb()) : null, zzbVar.zzc() ? zzbVar.zzd() : null);
            return zzbVar;
        } catch (com.google.android.gms.internal.measurement.zzft e) {
            zzr().zzi().zza("Unable to merge remote config. appId", zzet.zza(str), e);
            return zzbt.zzb.zzj();
        } catch (RuntimeException e2) {
            zzr().zzi().zza("Unable to merge remote config. appId", zzet.zza(str), e2);
            return zzbt.zzb.zzj();
        }
    }

    final boolean zzg(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    final boolean zzh(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    @Override // com.google.android.gms.measurement.internal.zzke
    public final /* bridge */ /* synthetic */ zzkk zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzke
    public final /* bridge */ /* synthetic */ zzq e_() {
        return super.e_();
    }

    @Override // com.google.android.gms.measurement.internal.zzke
    public final /* bridge */ /* synthetic */ zzab zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzke
    public final /* bridge */ /* synthetic */ zzfr zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
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
