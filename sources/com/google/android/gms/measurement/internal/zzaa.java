package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzlv;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaa extends zzgs {
    private Boolean zza;
    private zzac zzb;
    private Boolean zzc;

    zzaa(zzfx zzfxVar) {
        super(zzfxVar);
        this.zzb = zzz.zza;
    }

    final void zza(zzac zzacVar) {
        this.zzb = zzacVar;
    }

    public final int zze() {
        return (com.google.android.gms.internal.measurement.zzjn.zzb() && zzt().zzd(null, zzas.zzcl) && zzp().zzj() >= 2147483) ? 100 : 25;
    }

    final int zza(String str) {
        if (com.google.android.gms.internal.measurement.zzjn.zzb() && zzd(null, zzas.zzck)) {
            return zza(str, zzas.zzag, 500, 2000);
        }
        return 500;
    }

    public final int zzb(String str) {
        return zzb(str, zzas.zzn);
    }

    final int zzc(String str) {
        if (com.google.android.gms.internal.measurement.zzjn.zzb() && zzd(null, zzas.zzck)) {
            return zza(str, zzas.zzaf, 25, 100);
        }
        return 25;
    }

    public final long zzf() {
        zzu();
        return 27000L;
    }

    public final boolean zzg() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    ApplicationInfo applicationInfo = zzn().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzc = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzc == null) {
                        this.zzc = Boolean.TRUE;
                        zzr().zzf().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }

    public final long zza(String str, zzem<Long> zzemVar) {
        if (str == null) {
            return zzemVar.zza(null).longValue();
        }
        String strZza = this.zzb.zza(str, zzemVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzemVar.zza(null).longValue();
        }
        try {
            return zzemVar.zza(Long.valueOf(Long.parseLong(strZza))).longValue();
        } catch (NumberFormatException unused) {
            return zzemVar.zza(null).longValue();
        }
    }

    public final int zzb(String str, zzem<Integer> zzemVar) {
        if (str == null) {
            return zzemVar.zza(null).intValue();
        }
        String strZza = this.zzb.zza(str, zzemVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzemVar.zza(null).intValue();
        }
        try {
            return zzemVar.zza(Integer.valueOf(Integer.parseInt(strZza))).intValue();
        } catch (NumberFormatException unused) {
            return zzemVar.zza(null).intValue();
        }
    }

    public final int zza(String str, zzem<Integer> zzemVar, int i, int i2) {
        return Math.max(Math.min(zzb(str, zzemVar), i2), i);
    }

    public final double zzc(String str, zzem<Double> zzemVar) {
        if (str == null) {
            return zzemVar.zza(null).doubleValue();
        }
        String strZza = this.zzb.zza(str, zzemVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzemVar.zza(null).doubleValue();
        }
        try {
            return zzemVar.zza(Double.valueOf(Double.parseDouble(strZza))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzemVar.zza(null).doubleValue();
        }
    }

    public final boolean zzd(String str, zzem<Boolean> zzemVar) {
        if (str == null) {
            return zzemVar.zza(null).booleanValue();
        }
        String strZza = this.zzb.zza(str, zzemVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzemVar.zza(null).booleanValue();
        }
        return zzemVar.zza(Boolean.valueOf(Boolean.parseBoolean(strZza))).booleanValue();
    }

    public final boolean zze(String str, zzem<Boolean> zzemVar) {
        return zzd(str, zzemVar);
    }

    public final boolean zza(zzem<Boolean> zzemVar) {
        return zzd(null, zzemVar);
    }

    private final Bundle zzz() {
        try {
            if (zzn().getPackageManager() == null) {
                zzr().zzf().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zzn()).getApplicationInfo(zzn().getPackageName(), 128);
            if (applicationInfo == null) {
                zzr().zzf().zza("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException e) {
            zzr().zzf().zza("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    final Boolean zzd(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle bundleZzz = zzz();
        if (bundleZzz == null) {
            zzr().zzf().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleZzz.containsKey(str)) {
            return Boolean.valueOf(bundleZzz.getBoolean(str));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final java.util.List<java.lang.String> zze(java.lang.String r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzz()
            r1 = 0
            if (r0 != 0) goto L19
            com.google.android.gms.measurement.internal.zzet r4 = r3.zzr()
            com.google.android.gms.measurement.internal.zzev r4 = r4.zzf()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L17:
            r4 = r1
            goto L28
        L19:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L20
            goto L17
        L20:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L28:
            if (r4 != 0) goto L2b
            return r1
        L2b:
            android.content.Context r0 = r3.zzn()     // Catch: android.content.res.Resources.NotFoundException -> L43
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L43
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L43
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            if (r4 != 0) goto L3e
            return r1
        L3e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            return r4
        L43:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzet r0 = r3.zzr()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzf()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zza(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaa.zze(java.lang.String):java.util.List");
    }

    public final boolean zzh() {
        zzu();
        Boolean boolZzd = zzd("firebase_analytics_collection_deactivated");
        return boolZzd != null && boolZzd.booleanValue();
    }

    public final Boolean zzi() {
        zzb();
        Boolean boolZzd = zzd("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(boolZzd == null || boolZzd.booleanValue());
    }

    public final Boolean zzj() {
        zzb();
        boolean z = true;
        if (!zzlv.zzb() || !zza(zzas.zzcc)) {
            return true;
        }
        Boolean boolZzd = zzd("google_analytics_automatic_screen_reporting_enabled");
        if (boolZzd != null && !boolZzd.booleanValue()) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public static long zzk() {
        return zzas.zzac.zza(null).longValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zza(com.google.android.gms.measurement.internal.zzg r6) {
        /*
            r5 = this;
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            java.lang.String r1 = r6.zze()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L33
            boolean r1 = com.google.android.gms.internal.measurement.zzle.zzb()
            if (r1 == 0) goto L2f
            com.google.android.gms.measurement.internal.zzaa r1 = r5.zzt()
            java.lang.String r2 = r6.zzc()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzbo
            boolean r1 = r1.zzd(r2, r3)
            if (r1 == 0) goto L2f
            java.lang.String r1 = r6.zzg()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L33
        L2f:
            java.lang.String r1 = r6.zzf()
        L33:
            com.google.android.gms.measurement.internal.zzem<java.lang.String> r2 = com.google.android.gms.measurement.internal.zzas.zzd
            r3 = 0
            java.lang.Object r2 = r2.zza(r3)
            java.lang.String r2 = (java.lang.String) r2
            android.net.Uri$Builder r2 = r0.scheme(r2)
            com.google.android.gms.measurement.internal.zzem<java.lang.String> r4 = com.google.android.gms.measurement.internal.zzas.zze
            java.lang.Object r3 = r4.zza(r3)
            java.lang.String r3 = (java.lang.String) r3
            android.net.Uri$Builder r2 = r2.encodedAuthority(r3)
            java.lang.String r3 = "config/app/"
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r4 = r1.length()
            if (r4 == 0) goto L5d
            java.lang.String r1 = r3.concat(r1)
            goto L62
        L5d:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L62:
            android.net.Uri$Builder r1 = r2.path(r1)
            java.lang.String r6 = r6.zzd()
            java.lang.String r2 = "app_instance_id"
            android.net.Uri$Builder r6 = r1.appendQueryParameter(r2, r6)
            java.lang.String r1 = "platform"
            java.lang.String r2 = "android"
            android.net.Uri$Builder r6 = r6.appendQueryParameter(r1, r2)
            long r1 = r5.zzf()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "gmp_version"
            r6.appendQueryParameter(r2, r1)
            android.net.Uri r6 = r0.build()
            java.lang.String r6 = r6.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaa.zza(com.google.android.gms.measurement.internal.zzg):java.lang.String");
    }

    public static long zzv() {
        return zzas.zzc.zza(null).longValue();
    }

    public final String zzw() {
        return zza("debug.firebase.analytics.app", "");
    }

    public final String zzx() {
        return zza("debug.deferred.deeplink", "");
    }

    private final String zza(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e) {
            zzr().zzf().zza("Could not find SystemProperties class", e);
            return str2;
        } catch (IllegalAccessException e2) {
            zzr().zzf().zza("Could not access SystemProperties.get()", e2);
            return str2;
        } catch (NoSuchMethodException e3) {
            zzr().zzf().zza("Could not find SystemProperties.get() method", e3);
            return str2;
        } catch (InvocationTargetException e4) {
            zzr().zzf().zza("SystemProperties.get() threw an exception", e4);
            return str2;
        }
    }

    public final boolean zzf(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzg(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    final boolean zzh(String str) {
        return zzd(str, zzas.zzaj);
    }

    final String zzi(String str) {
        zzem<String> zzemVar = zzas.zzak;
        if (str == null) {
            return zzemVar.zza(null);
        }
        return zzemVar.zza(this.zzb.zza(str, zzemVar.zza()));
    }

    final boolean zzy() {
        if (this.zza == null) {
            Boolean boolZzd = zzd("app_measurement_lite");
            this.zza = boolZzd;
            if (boolZzd == null) {
                this.zza = false;
            }
        }
        return this.zza.booleanValue() || !this.zzz.zzt();
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
