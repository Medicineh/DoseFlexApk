package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzff extends zzgr {
    static final Pair<String, Long> zza = new Pair<>("", 0L);
    private SharedPreferences zzaa;
    private String zzab;
    private boolean zzac;
    private long zzad;
    public zzfm zzb;
    public final zzfj zzc;
    public final zzfj zzd;
    public final zzfj zze;
    public final zzfj zzf;
    public final zzfj zzg;
    public final zzfj zzh;
    public final zzfj zzi;
    public final zzfl zzj;
    public final zzfj zzk;
    public final zzfj zzl;
    public final zzfh zzm;
    public final zzfl zzn;
    public final zzfh zzo;
    public final zzfh zzp;
    public final zzfj zzq;
    public boolean zzr;
    public zzfh zzs;
    public zzfh zzt;
    public zzfj zzu;
    public final zzfl zzv;
    public final zzfl zzw;
    public final zzfj zzx;
    public final zzfk zzy;

    final Pair<String, Boolean> zza(String str) {
        zzd();
        long jElapsedRealtime = zzm().elapsedRealtime();
        if (this.zzab != null && jElapsedRealtime < this.zzad) {
            return new Pair<>(this.zzab, Boolean.valueOf(this.zzac));
        }
        this.zzad = jElapsedRealtime + zzt().zza(str, zzas.zza);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzn());
            if (advertisingIdInfo != null) {
                this.zzab = advertisingIdInfo.getId();
                this.zzac = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzab == null) {
                this.zzab = "";
            }
        } catch (Exception e) {
            zzr().zzw().zza("Unable to get advertising id", e);
            this.zzab = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzab, Boolean.valueOf(this.zzac));
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    protected final boolean zze() {
        return true;
    }

    final String zzb(String str) {
        zzd();
        String str2 = (String) zza(str).first;
        MessageDigest messageDigestZzi = zzko.zzi();
        if (messageDigestZzi == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestZzi.digest(str2.getBytes())));
    }

    zzff(zzfx zzfxVar) {
        super(zzfxVar);
        this.zzc = new zzfj(this, "last_upload", 0L);
        this.zzd = new zzfj(this, "last_upload_attempt", 0L);
        this.zze = new zzfj(this, "backoff", 0L);
        this.zzf = new zzfj(this, "last_delete_stale", 0L);
        this.zzk = new zzfj(this, "time_before_start", 10000L);
        this.zzl = new zzfj(this, "session_timeout", 1800000L);
        this.zzm = new zzfh(this, "start_new_session", true);
        this.zzq = new zzfj(this, "last_pause_time", 0L);
        this.zzn = new zzfl(this, "non_personalized_ads", null);
        this.zzo = new zzfh(this, "use_dynamite_api", false);
        this.zzp = new zzfh(this, "allow_remote_dynamite", false);
        this.zzg = new zzfj(this, "midnight_offset", 0L);
        this.zzh = new zzfj(this, "first_open_time", 0L);
        this.zzi = new zzfj(this, "app_install_time", 0L);
        this.zzj = new zzfl(this, "app_instance_id", null);
        this.zzs = new zzfh(this, "app_backgrounded", false);
        this.zzt = new zzfh(this, "deep_link_retrieval_complete", false);
        this.zzu = new zzfj(this, "deep_link_retrieval_attempts", 0L);
        this.zzv = new zzfl(this, "firebase_feature_rollouts", null);
        this.zzw = new zzfl(this, "deferred_attribution_cache", null);
        this.zzx = new zzfj(this, "deferred_attribution_cache_timestamp", 0L);
        this.zzy = new zzfk(this, "default_event_parameters", null);
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    protected final void f_() {
        SharedPreferences sharedPreferences = zzn().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzaa = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzr = z;
        if (!z) {
            SharedPreferences.Editor editorEdit = this.zzaa.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        this.zzb = new zzfm(this, "health_monitor", Math.max(0L, zzas.zzb.zza(null).longValue()));
    }

    protected final SharedPreferences zzg() {
        zzd();
        zzaa();
        return this.zzaa;
    }

    final void zzc(String str) {
        zzd();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putString("gmp_app_id", str);
        editorEdit.apply();
    }

    final String zzh() {
        zzd();
        return zzg().getString("gmp_app_id", null);
    }

    final void zzd(String str) {
        zzd();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putString("admob_app_id", str);
        editorEdit.apply();
    }

    final String zzi() {
        zzd();
        return zzg().getString("admob_app_id", null);
    }

    final Boolean zzj() {
        zzd();
        if (zzg().contains("use_service")) {
            return Boolean.valueOf(zzg().getBoolean("use_service", false));
        }
        return null;
    }

    final void zza(boolean z) {
        zzd();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putBoolean("use_service", z);
        editorEdit.apply();
    }

    final void zzk() {
        zzd();
        Boolean boolZzv = zzv();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.clear();
        editorEdit.apply();
        if (boolZzv != null) {
            zzb(boolZzv.booleanValue());
        }
    }

    final void zzb(boolean z) {
        zzd();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putBoolean("measurement_enabled", z);
        editorEdit.apply();
    }

    final Boolean zzv() {
        zzd();
        if (zzg().contains("measurement_enabled")) {
            return Boolean.valueOf(zzg().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    protected final String zzw() {
        zzd();
        String string = zzg().getString("previous_os_version", null);
        zzl().zzaa();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor editorEdit = zzg().edit();
            editorEdit.putString("previous_os_version", str);
            editorEdit.apply();
        }
        return string;
    }

    final void zzc(boolean z) {
        zzd();
        zzr().zzx().zza("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z);
        editorEdit.apply();
    }

    final boolean zzx() {
        return this.zzaa.contains("deferred_analytics_collection");
    }

    final boolean zza(long j) {
        return j - this.zzl.zza() > this.zzq.zza();
    }
}
