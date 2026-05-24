package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public class zzfx implements zzgu {
    private static volatile zzfx zzb;
    final long zza;
    private Boolean zzaa;
    private long zzab;
    private volatile Boolean zzac;
    private Boolean zzad;
    private Boolean zzae;
    private int zzaf;
    private final Context zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final boolean zzg;
    private final zzv zzh;
    private final zzaa zzi;
    private final zzff zzj;
    private final zzet zzk;
    private final zzfu zzl;
    private final zzjs zzm;
    private final zzko zzn;
    private final zzer zzo;
    private final Clock zzp;
    private final zzih zzq;
    private final zzhc zzr;
    private final zzb zzs;
    private final zzic zzt;
    private zzep zzu;
    private zzin zzv;
    private zzak zzw;
    private zzeq zzx;
    private zzfo zzy;
    private boolean zzz = false;
    private AtomicInteger zzag = new AtomicInteger(0);

    private zzfx(zzgz zzgzVar) {
        boolean z = false;
        Preconditions.checkNotNull(zzgzVar);
        zzv zzvVar = new zzv(zzgzVar.zza);
        this.zzh = zzvVar;
        zzej.zza = zzvVar;
        this.zzc = zzgzVar.zza;
        this.zzd = zzgzVar.zzb;
        this.zze = zzgzVar.zzc;
        this.zzf = zzgzVar.zzd;
        this.zzg = zzgzVar.zzh;
        this.zzac = zzgzVar.zze;
        com.google.android.gms.internal.measurement.zzaa zzaaVar = zzgzVar.zzg;
        if (zzaaVar != null && zzaaVar.zzg != null) {
            Object obj = zzaaVar.zzg.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzad = (Boolean) obj;
            }
            Object obj2 = zzaaVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzae = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.zzcq.zza(this.zzc);
        this.zzp = DefaultClock.getInstance();
        this.zza = zzgzVar.zzi != null ? zzgzVar.zzi.longValue() : this.zzp.currentTimeMillis();
        this.zzi = new zzaa(this);
        zzff zzffVar = new zzff(this);
        zzffVar.zzab();
        this.zzj = zzffVar;
        zzet zzetVar = new zzet(this);
        zzetVar.zzab();
        this.zzk = zzetVar;
        zzko zzkoVar = new zzko(this);
        zzkoVar.zzab();
        this.zzn = zzkoVar;
        zzer zzerVar = new zzer(this);
        zzerVar.zzab();
        this.zzo = zzerVar;
        this.zzs = new zzb(this);
        zzih zzihVar = new zzih(this);
        zzihVar.zzx();
        this.zzq = zzihVar;
        zzhc zzhcVar = new zzhc(this);
        zzhcVar.zzx();
        this.zzr = zzhcVar;
        zzjs zzjsVar = new zzjs(this);
        zzjsVar.zzx();
        this.zzm = zzjsVar;
        zzic zzicVar = new zzic(this);
        zzicVar.zzab();
        this.zzt = zzicVar;
        zzfu zzfuVar = new zzfu(this);
        zzfuVar.zzab();
        this.zzl = zzfuVar;
        if (zzgzVar.zzg != null && zzgzVar.zzg.zzb != 0) {
            z = true;
        }
        boolean z2 = !z;
        if (this.zzc.getApplicationContext() instanceof Application) {
            zzhc zzhcVarZzh = zzh();
            if (zzhcVarZzh.zzn().getApplicationContext() instanceof Application) {
                Application application = (Application) zzhcVarZzh.zzn().getApplicationContext();
                if (zzhcVarZzh.zza == null) {
                    zzhcVarZzh.zza = new zzhx(zzhcVarZzh, null);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(zzhcVarZzh.zza);
                    application.registerActivityLifecycleCallbacks(zzhcVarZzh.zza);
                    zzhcVarZzh.zzr().zzx().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzr().zzi().zza("Application context is not an Application");
        }
        this.zzl.zza(new zzfz(this, zzgzVar));
    }

    final void zzad() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzgz zzgzVar) {
        String strConcat;
        zzev zzevVarZzv;
        zzq().zzd();
        zzak zzakVar = new zzak(this);
        zzakVar.zzab();
        this.zzw = zzakVar;
        zzeq zzeqVar = new zzeq(this, zzgzVar.zzf);
        zzeqVar.zzx();
        this.zzx = zzeqVar;
        zzep zzepVar = new zzep(this);
        zzepVar.zzx();
        this.zzu = zzepVar;
        zzin zzinVar = new zzin(this);
        zzinVar.zzx();
        this.zzv = zzinVar;
        this.zzn.zzac();
        this.zzj.zzac();
        this.zzy = new zzfo(this);
        this.zzx.zzy();
        zzr().zzv().zza("App measurement initialized, version", Long.valueOf(this.zzi.zzf()));
        zzr().zzv().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strZzab = zzeqVar.zzab();
        if (TextUtils.isEmpty(this.zzd)) {
            if (zzi().zzf(strZzab)) {
                zzevVarZzv = zzr().zzv();
                strConcat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzev zzevVarZzv2 = zzr().zzv();
                String strValueOf = String.valueOf(strZzab);
                strConcat = strValueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(strValueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
                zzevVarZzv = zzevVarZzv2;
            }
            zzevVarZzv.zza(strConcat);
        }
        zzr().zzw().zza("Debug-level message logging enabled");
        if (this.zzaf != this.zzag.get()) {
            zzr().zzf().zza("Not all components initialized", Integer.valueOf(this.zzaf), Integer.valueOf(this.zzag.get()));
        }
        this.zzz = true;
    }

    protected final void zza() {
        zzq().zzd();
        if (zzc().zzc.zza() == 0) {
            zzc().zzc.zza(this.zzp.currentTimeMillis());
        }
        if (Long.valueOf(zzc().zzh.zza()).longValue() == 0) {
            zzr().zzx().zza("Persisting first open", Long.valueOf(this.zza));
            zzc().zzh.zza(this.zza);
        }
        if (this.zzi.zza(zzas.zzcp)) {
            zzh().zzb.zzb();
        }
        if (!zzag()) {
            if (zzab()) {
                if (!zzi().zzd("android.permission.INTERNET")) {
                    zzr().zzf().zza("App is missing INTERNET permission");
                }
                if (!zzi().zzd("android.permission.ACCESS_NETWORK_STATE")) {
                    zzr().zzf().zza("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!Wrappers.packageManager(this.zzc).isCallerInstantApp() && !this.zzi.zzy()) {
                    if (!zzfp.zza(this.zzc)) {
                        zzr().zzf().zza("AppMeasurementReceiver not registered/enabled");
                    }
                    if (!zzko.zza(this.zzc, false)) {
                        zzr().zzf().zza("AppMeasurementService not registered/enabled");
                    }
                }
                zzr().zzf().zza("Uploading is not possible. App measurement disabled");
            }
        } else {
            if (!TextUtils.isEmpty(zzy().zzac()) || !TextUtils.isEmpty(zzy().zzad())) {
                zzi();
                if (zzko.zza(zzy().zzac(), zzc().zzh(), zzy().zzad(), zzc().zzi())) {
                    zzr().zzv().zza("Rechecking which service to use due to a GMP App Id change");
                    zzc().zzk();
                    zzk().zzab();
                    this.zzv.zzah();
                    this.zzv.zzaf();
                    zzc().zzh.zza(this.zza);
                    zzc().zzj.zza(null);
                }
                zzc().zzc(zzy().zzac());
                zzc().zzd(zzy().zzad());
            }
            zzh().zza(zzc().zzj.zza());
            if (com.google.android.gms.internal.measurement.zzka.zzb() && this.zzi.zza(zzas.zzbv) && !zzi().zzv() && !TextUtils.isEmpty(zzc().zzv.zza())) {
                zzr().zzi().zza("Remote config removed with active feature rollouts");
                zzc().zzv.zza(null);
            }
            if (!TextUtils.isEmpty(zzy().zzac()) || !TextUtils.isEmpty(zzy().zzad())) {
                boolean zZzab = zzab();
                if (!zzc().zzx() && !this.zzi.zzh()) {
                    zzc().zzc(!zZzab);
                }
                if (zZzab) {
                    zzh().zzai();
                }
                zze().zza.zza();
                zzw().zza(new AtomicReference<>());
            }
        }
        zzc().zzo.zza(this.zzi.zza(zzas.zzaz));
        zzc().zzp.zza(this.zzi.zza(zzas.zzba));
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final zzv zzu() {
        return this.zzh;
    }

    public final zzaa zzb() {
        return this.zzi;
    }

    public final zzff zzc() {
        zza((zzgs) this.zzj);
        return this.zzj;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final zzet zzr() {
        zzb(this.zzk);
        return this.zzk;
    }

    public final zzet zzd() {
        zzet zzetVar = this.zzk;
        if (zzetVar == null || !zzetVar.zzz()) {
            return null;
        }
        return this.zzk;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final zzfu zzq() {
        zzb(this.zzl);
        return this.zzl;
    }

    public final zzjs zze() {
        zzb(this.zzm);
        return this.zzm;
    }

    public final zzfo zzf() {
        return this.zzy;
    }

    final zzfu zzg() {
        return this.zzl;
    }

    public final zzhc zzh() {
        zzb(this.zzr);
        return this.zzr;
    }

    public final zzko zzi() {
        zza((zzgs) this.zzn);
        return this.zzn;
    }

    public final zzer zzj() {
        zza((zzgs) this.zzo);
        return this.zzo;
    }

    public final zzep zzk() {
        zzb(this.zzu);
        return this.zzu;
    }

    private final zzic zzai() {
        zzb(this.zzt);
        return this.zzt;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final Context zzn() {
        return this.zzc;
    }

    public final boolean zzl() {
        return TextUtils.isEmpty(this.zzd);
    }

    public final String zzo() {
        return this.zzd;
    }

    public final String zzp() {
        return this.zze;
    }

    public final String zzs() {
        return this.zzf;
    }

    public final boolean zzt() {
        return this.zzg;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final Clock zzm() {
        return this.zzp;
    }

    public final zzih zzv() {
        zzb(this.zzq);
        return this.zzq;
    }

    public final zzin zzw() {
        zzb(this.zzv);
        return this.zzv;
    }

    public final zzak zzx() {
        zzb(this.zzw);
        return this.zzw;
    }

    public final zzeq zzy() {
        zzb(this.zzx);
        return this.zzx;
    }

    public final zzb zzz() {
        zzb zzbVar = this.zzs;
        if (zzbVar != null) {
            return zzbVar;
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzfx zza(Context context, String str, String str2, Bundle bundle) {
        return zza(context, new com.google.android.gms.internal.measurement.zzaa(0L, 0L, true, null, null, null, bundle), null);
    }

    public static zzfx zza(Context context, com.google.android.gms.internal.measurement.zzaa zzaaVar, Long l) {
        if (zzaaVar != null && (zzaaVar.zze == null || zzaaVar.zzf == null)) {
            zzaaVar = new com.google.android.gms.internal.measurement.zzaa(zzaaVar.zza, zzaaVar.zzb, zzaaVar.zzc, zzaaVar.zzd, null, null, zzaaVar.zzg);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzfx.class) {
                if (zzb == null) {
                    zzb = new zzfx(new zzgz(context, zzaaVar, l));
                }
            }
        } else if (zzaaVar != null && zzaaVar.zzg != null && zzaaVar.zzg.containsKey("dataCollectionDefaultEnabled")) {
            zzb.zza(zzaaVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        return zzb;
    }

    private static void zzb(zzgr zzgrVar) {
        if (zzgrVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzgrVar.zzz()) {
            return;
        }
        String strValueOf = String.valueOf(zzgrVar.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(strValueOf);
        throw new IllegalStateException(sb.toString());
    }

    private static void zzb(zze zzeVar) {
        if (zzeVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzeVar.zzv()) {
            return;
        }
        String strValueOf = String.valueOf(zzeVar.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(strValueOf);
        throw new IllegalStateException(sb.toString());
    }

    private static void zza(zzgs zzgsVar) {
        if (zzgsVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    final void zza(boolean z) {
        this.zzac = Boolean.valueOf(z);
    }

    public final boolean zzaa() {
        return this.zzac != null && this.zzac.booleanValue();
    }

    public final boolean zzab() {
        return zzac() == 0;
    }

    public final int zzac() {
        zzq().zzd();
        if (this.zzi.zzh()) {
            return 1;
        }
        Boolean bool = this.zzae;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        Boolean boolZzv = zzc().zzv();
        if (boolZzv != null) {
            return boolZzv.booleanValue() ? 0 : 3;
        }
        zzaa zzaaVar = this.zzi;
        zzaaVar.zzu();
        Boolean boolZzd = zzaaVar.zzd("firebase_analytics_collection_enabled");
        if (boolZzd != null) {
            return boolZzd.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.zzad;
        if (bool2 != null) {
            return bool2.booleanValue() ? 0 : 5;
        }
        if (GoogleServices.isMeasurementExplicitlyDisabled()) {
            return 6;
        }
        return (!this.zzi.zza(zzas.zzas) || this.zzac == null || this.zzac.booleanValue()) ? 0 : 7;
    }

    final void zzae() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    final void zza(zzgr zzgrVar) {
        this.zzaf++;
    }

    final void zza(zze zzeVar) {
        this.zzaf++;
    }

    final void zzaf() {
        this.zzag.incrementAndGet();
    }

    protected final boolean zzag() {
        if (!this.zzz) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        zzq().zzd();
        Boolean bool = this.zzaa;
        if (bool == null || this.zzab == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzp.elapsedRealtime() - this.zzab) > 1000)) {
            this.zzab = this.zzp.elapsedRealtime();
            boolean z = true;
            Boolean boolValueOf = Boolean.valueOf(zzi().zzd("android.permission.INTERNET") && zzi().zzd("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzc).isCallerInstantApp() || this.zzi.zzy() || (zzfp.zza(this.zzc) && zzko.zza(this.zzc, false))));
            this.zzaa = boolValueOf;
            if (boolValueOf.booleanValue()) {
                if (!zzi().zza(zzy().zzac(), zzy().zzad(), zzy().zzae()) && TextUtils.isEmpty(zzy().zzad())) {
                    z = false;
                }
                this.zzaa = Boolean.valueOf(z);
            }
        }
        return this.zzaa.booleanValue();
    }

    public final void zzah() {
        zzq().zzd();
        zzb(zzai());
        String strZzab = zzy().zzab();
        Pair<String, Boolean> pairZza = zzc().zza(strZzab);
        if (!this.zzi.zzi().booleanValue() || ((Boolean) pairZza.second).booleanValue() || TextUtils.isEmpty((CharSequence) pairZza.first)) {
            zzr().zzw().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        if (!zzai().zzg()) {
            zzr().zzi().zza("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        URL urlZza = zzi().zza(zzy().zzt().zzf(), strZzab, (String) pairZza.first, zzc().zzu.zza() - 1);
        zzic zzicVarZzai = zzai();
        zzib zzibVar = new zzib(this) { // from class: com.google.android.gms.measurement.internal.zzga
            private final zzfx zza;

            {
                this.zza = this;
            }

            @Override // com.google.android.gms.measurement.internal.zzib
            public final void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
                this.zza.zza(str, i, th, bArr, map);
            }
        };
        zzicVarZzai.zzd();
        zzicVarZzai.zzaa();
        Preconditions.checkNotNull(urlZza);
        Preconditions.checkNotNull(zzibVar);
        zzicVarZzai.zzq().zzb(new zzie(zzicVarZzai, strZzab, urlZza, null, null, zzibVar));
    }

    final /* synthetic */ void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> listQueryIntentActivities;
        boolean z = true;
        if (!((i == 200 || i == 204 || i == 304) && th == null)) {
            zzr().zzi().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        zzc().zzt.zza(true);
        if (bArr.length == 0) {
            zzr().zzw().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String strOptString = jSONObject.optString("deeplink", "");
            String strOptString2 = jSONObject.optString("gclid", "");
            double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(strOptString)) {
                zzr().zzw().zza("Deferred Deep Link is empty.");
                return;
            }
            zzko zzkoVarZzi = zzi();
            zzkoVarZzi.zzb();
            if (TextUtils.isEmpty(strOptString) || (listQueryIntentActivities = zzkoVarZzi.zzn().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(strOptString)), 0)) == null || listQueryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                zzr().zzi().zza("Deferred Deep Link validation failed. gclid, deep link", strOptString2, strOptString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", strOptString2);
            bundle.putString("_cis", "ddp");
            this.zzr.zza("auto", "_cmp", bundle);
            zzko zzkoVarZzi2 = zzi();
            if (TextUtils.isEmpty(strOptString) || !zzkoVarZzi2.zza(strOptString, dOptDouble)) {
                return;
            }
            zzkoVarZzi2.zzn().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
        } catch (JSONException e) {
            zzr().zzf().zza("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }
}
