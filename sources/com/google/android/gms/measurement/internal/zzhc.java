package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzks;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzhc extends zze {
    protected zzhx zza;
    final zzn zzb;
    protected boolean zzc;
    private zzgx zzd;
    private final Set<zzha> zze;
    private boolean zzf;
    private final AtomicReference<String> zzg;

    protected zzhc(zzfx zzfxVar) {
        super(zzfxVar);
        this.zze = new CopyOnWriteArraySet();
        this.zzc = true;
        this.zzg = new AtomicReference<>();
        this.zzb = new zzn(zzfxVar);
    }

    @Override // com.google.android.gms.measurement.internal.zze
    protected final boolean zzz() {
        return false;
    }

    public final void zzab() {
        if (zzn().getApplicationContext() instanceof Application) {
            ((Application) zzn().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzq().zza(atomicReference, 15000L, "boolean test flag value", new zzhd(this, atomicReference));
    }

    public final String zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzq().zza(atomicReference, 15000L, "String test flag value", new zzhn(this, atomicReference));
    }

    public final Long zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzq().zza(atomicReference, 15000L, "long test flag value", new zzhs(this, atomicReference));
    }

    public final Integer zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzq().zza(atomicReference, 15000L, "int test flag value", new zzhr(this, atomicReference));
    }

    public final Double zzag() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzq().zza(atomicReference, 15000L, "double test flag value", new zzhu(this, atomicReference));
    }

    public final void zza(boolean z) {
        zzw();
        zzb();
        zzq().zza(new zzht(this, z));
    }

    public final void zzb(boolean z) {
        zzw();
        zzb();
        zzq().zza(new zzhw(this, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(boolean z) {
        zzd();
        zzb();
        zzw();
        zzr().zzw().zza("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzs().zzb(z);
        zzam();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzam() {
        zzd();
        String strZza = zzs().zzn.zza();
        if (strZza != null) {
            if ("unset".equals(strZza)) {
                zza("app", "_npa", (Object) null, zzm().currentTimeMillis());
            } else {
                zza("app", "_npa", Long.valueOf("true".equals(strZza) ? 1L : 0L), zzm().currentTimeMillis());
            }
        }
        if (this.zzz.zzab() && this.zzc) {
            zzr().zzw().zza("Recording app launch after enabling measurement for the first time (FE)");
            zzai();
            if (zzks.zzb() && zzt().zza(zzas.zzbw)) {
                zzk().zza.zza();
            }
            if (com.google.android.gms.internal.measurement.zzkl.zzb() && zzt().zza(zzas.zzcb)) {
                if (!(this.zzz.zzf().zza.zzc().zzi.zza() > 0)) {
                    zzfo zzfoVarZzf = this.zzz.zzf();
                    zzfoVarZzf.zza.zzad();
                    zzfoVarZzf.zza(zzfoVarZzf.zza.zzn().getPackageName());
                }
            }
            if (zzt().zza(zzas.zzcp)) {
                zzq().zza(new zzhv(this));
                return;
            }
            return;
        }
        zzr().zzw().zza("Updating Scion state (FE)");
        zzh().zzac();
    }

    public final void zza(long j) {
        zzb();
        zzq().zza(new zzhy(this, j));
    }

    public final void zzb(long j) {
        zzb();
        zzq().zza(new zzhg(this, j));
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        zza(str, str2, bundle, false, true, zzm().currentTimeMillis());
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzm().currentTimeMillis());
    }

    final void zzb(String str, String str2, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, zzm().currentTimeMillis(), bundle);
    }

    final void zza(String str, String str2, long j, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, j, bundle, true, this.zzd == null || zzko.zze(str2), false, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0529  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void zza(java.lang.String r28, java.lang.String r29, long r30, android.os.Bundle r32, boolean r33, boolean r34, boolean r35, java.lang.String r36) {
        /*
            Method dump skipped, instruction units count: 1471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhc.zza(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        zzb();
        zzb(str == null ? "app" : str, str2, j, bundle == null ? new Bundle() : bundle, z2, !z2 || this.zzd == null || zzko.zze(str2), !z, null);
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzq().zza(new zzhf(this, str, str2, j, zzko.zzb(bundle), z, z2, z3, str3));
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:130)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzm().currentTimeMillis());
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:130)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        int iZzc = 6;
        if (z) {
            iZzc = zzp().zzc(str2);
        } else {
            zzko zzkoVarZzp = zzp();
            if (zzkoVarZzp.zza("user property", str2)) {
                if (!zzkoVarZzp.zza("user property", zzgy.zza, str2)) {
                    iZzc = 15;
                } else if (zzkoVarZzp.zza("user property", 24, str2)) {
                    iZzc = 0;
                }
            }
        }
        if (iZzc != 0) {
            zzp();
            this.zzz.zzi().zza(iZzc, "_ev", zzko.zza(str2, 24, true), str2 != null ? str2.length() : 0);
            return;
        }
        if (obj != null) {
            int iZzb = zzp().zzb(str2, obj);
            if (iZzb != 0) {
                zzp();
                this.zzz.zzi().zza(iZzb, "_ev", zzko.zza(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0);
                return;
            } else {
                Object objZzc = zzp().zzc(str2, obj);
                if (objZzc != null) {
                    zza(str3, str2, j, objZzc);
                    return;
                }
                return;
            }
        }
        zza(str3, str2, j, (Object) null);
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzq().zza(new zzhi(this, str, str2, obj, j));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void zza(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzd()
            r8.zzb()
            r8.zzw()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L66
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L56
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L56
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L38
            r4 = r2
            goto L3a
        L38:
            r4 = 0
        L3a:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzff r0 = r8.zzs()
            com.google.android.gms.measurement.internal.zzfl r0 = r0.zzn
            r4 = r10
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L51
            java.lang.String r11 = "true"
        L51:
            r0.zza(r11)
            r6 = r10
            goto L64
        L56:
            if (r11 != 0) goto L66
            com.google.android.gms.measurement.internal.zzff r10 = r8.zzs()
            com.google.android.gms.measurement.internal.zzfl r10 = r10.zzn
            java.lang.String r0 = "unset"
            r10.zza(r0)
            r6 = r11
        L64:
            r3 = r1
            goto L68
        L66:
            r3 = r10
            r6 = r11
        L68:
            com.google.android.gms.measurement.internal.zzfx r10 = r8.zzz
            boolean r10 = r10.zzab()
            if (r10 != 0) goto L7e
            com.google.android.gms.measurement.internal.zzet r9 = r8.zzr()
            com.google.android.gms.measurement.internal.zzev r9 = r9.zzx()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L7e:
            com.google.android.gms.measurement.internal.zzfx r10 = r8.zzz
            boolean r10 = r10.zzag()
            if (r10 != 0) goto L87
            return
        L87:
            com.google.android.gms.measurement.internal.zzkn r10 = new com.google.android.gms.measurement.internal.zzkn
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzin r9 = r8.zzh()
            r9.zza(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhc.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final List<zzkn> zzc(boolean z) {
        zzb();
        zzw();
        zzr().zzx().zza("Getting user properties (FE)");
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        if (zzv.zza()) {
            zzr().zzf().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzz.zzq().zza(atomicReference, 5000L, "get user properties", new zzhh(this, atomicReference, z));
        List<zzkn> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzr().zzf().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
        return Collections.emptyList();
    }

    public final String zzah() {
        zzb();
        return this.zzg.get();
    }

    public final String zzc(long j) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot retrieve app instance id from analytics worker thread");
            return null;
        }
        if (zzv.zza()) {
            zzr().zzf().zza("Cannot retrieve app instance id from main thread");
            return null;
        }
        long jElapsedRealtime = zzm().elapsedRealtime();
        String strZze = zze(120000L);
        long jElapsedRealtime2 = zzm().elapsedRealtime() - jElapsedRealtime;
        return (strZze != null || jElapsedRealtime2 >= 120000) ? strZze : zze(120000 - jElapsedRealtime2);
    }

    final void zza(String str) {
        this.zzg.set(str);
    }

    private final String zze(long j) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            zzq().zza(new zzhk(this, atomicReference));
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                zzr().zzi().zza("Interrupted waiting for app instance id");
                return null;
            }
        }
        return (String) atomicReference.get();
    }

    public final void zzd(long j) {
        zza((String) null);
        zzq().zza(new zzhj(this, j));
    }

    public final void zzai() {
        zzd();
        zzb();
        zzw();
        if (this.zzz.zzag()) {
            if (zzt().zza(zzas.zzbh)) {
                zzaa zzaaVarZzt = zzt();
                zzaaVarZzt.zzu();
                Boolean boolZzd = zzaaVarZzt.zzd("google_analytics_deferred_deep_link_enabled");
                if (boolZzd != null && boolZzd.booleanValue()) {
                    zzr().zzw().zza("Deferred Deep Link feature enabled.");
                    zzq().zza(new Runnable(this) { // from class: com.google.android.gms.measurement.internal.zzhe
                        private final zzhc zza;

                        {
                            this.zza = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            zzhc zzhcVar = this.zza;
                            zzhcVar.zzd();
                            if (zzhcVar.zzs().zzt.zza()) {
                                zzhcVar.zzr().zzw().zza("Deferred Deep Link already retrieved. Not fetching again.");
                                return;
                            }
                            long jZza = zzhcVar.zzs().zzu.zza();
                            zzhcVar.zzs().zzu.zza(1 + jZza);
                            if (jZza < 5) {
                                zzhcVar.zzz.zzah();
                            } else {
                                zzhcVar.zzr().zzi().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                zzhcVar.zzs().zzt.zza(true);
                            }
                        }
                    });
                }
            }
            zzh().zzae();
            this.zzc = false;
            String strZzw = zzs().zzw();
            if (TextUtils.isEmpty(strZzw)) {
                return;
            }
            zzl().zzaa();
            if (strZzw.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", strZzw);
            zza("auto", "_ou", bundle);
        }
    }

    public final void zza(zzgx zzgxVar) {
        zzgx zzgxVar2;
        zzd();
        zzb();
        zzw();
        if (zzgxVar != null && zzgxVar != (zzgxVar2 = this.zzd)) {
            Preconditions.checkState(zzgxVar2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzgxVar;
    }

    public final void zza(zzha zzhaVar) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzhaVar);
        if (this.zze.add(zzhaVar)) {
            return;
        }
        zzr().zzi().zza("OnEventListener already registered");
    }

    public final void zzb(zzha zzhaVar) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzhaVar);
        if (this.zze.remove(zzhaVar)) {
            return;
        }
        zzr().zzi().zza("OnEventListener had not been registered");
    }

    public final void zza(Bundle bundle) {
        zza(bundle, zzm().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzb();
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzr().zzi().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        zzb(bundle2, j);
    }

    public final void zzb(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("app_id"));
        zza();
        zzb(new Bundle(bundle), zzm().currentTimeMillis());
    }

    private final void zzb(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzgt.zza(bundle, "app_id", String.class, null);
        zzgt.zza(bundle, "origin", String.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.NAME, String.class, null);
        zzgt.zza(bundle, "value", Object.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        Object obj = bundle.get("value");
        if (zzp().zzc(string) != 0) {
            zzr().zzf().zza("Invalid conditional user property name", zzo().zzc(string));
            return;
        }
        if (zzp().zzb(string, obj) != 0) {
            zzr().zzf().zza("Invalid conditional user property value", zzo().zzc(string), obj);
            return;
        }
        Object objZzc = zzp().zzc(string, obj);
        if (objZzc == null) {
            zzr().zzf().zza("Unable to normalize conditional user property value", zzo().zzc(string), obj);
            return;
        }
        zzgt.zza(bundle, objZzc);
        long j2 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
        if (!TextUtils.isEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) && (j2 > 15552000000L || j2 < 1)) {
            zzr().zzf().zza("Invalid conditional user property timeout", zzo().zzc(string), Long.valueOf(j2));
            return;
        }
        long j3 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
        if (j3 > 15552000000L || j3 < 1) {
            zzr().zzf().zza("Invalid conditional user property time to live", zzo().zzc(string), Long.valueOf(j3));
        } else {
            zzq().zza(new zzhl(this, bundle));
        }
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        zzb();
        zzb((String) null, str, str2, bundle);
    }

    public final void zza(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zza();
        zzb(str, str2, str3, bundle);
    }

    private final void zzb(String str, String str2, String str3, Bundle bundle) {
        long jCurrentTimeMillis = zzm().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, jCurrentTimeMillis);
        if (str3 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str3);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzq().zza(new zzho(this, bundle2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(Bundle bundle) {
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        if (!this.zzz.zzab()) {
            zzr().zzx().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkn zzknVar = new zzkn(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle.get("value"), bundle.getString("origin"));
        try {
            zzaq zzaqVarZza = zzp().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle.getString("origin"), 0L, true, false);
            zzh().zza(new zzy(bundle.getString("app_id"), bundle.getString("origin"), zzknVar, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzp().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle.getString("origin"), 0L, true, false), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zzaqVarZza, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzp().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle.getString("origin"), 0L, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(Bundle bundle) {
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        if (!this.zzz.zzab()) {
            zzr().zzx().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            zzh().zza(new zzy(bundle.getString("app_id"), bundle.getString("origin"), new zzkn(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), 0L, null, null), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzp().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle.getString("origin"), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        zzb();
        return zzb((String) null, str, str2);
    }

    public final ArrayList<Bundle> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3);
    }

    private final ArrayList<Bundle> zzb(String str, String str2, String str3) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (zzv.zza()) {
            zzr().zzf().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzz.zzq().zza(atomicReference, 5000L, "get conditional user properties", new zzhq(this, atomicReference, str, str2, str3));
        List list = (List) atomicReference.get();
        if (list == null) {
            zzr().zzf().zza("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
        return zzko.zzb((List<zzy>) list);
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzb();
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> zza(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3, z);
    }

    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (zzv.zza()) {
            zzr().zzf().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzz.zzq().zza(atomicReference, 5000L, "get user properties", new zzhp(this, atomicReference, str, str2, str3, z));
        List<zzkn> list = (List) atomicReference.get();
        if (list == null) {
            zzr().zzf().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzkn zzknVar : list) {
            arrayMap.put(zzknVar.zza, zzknVar.zza());
        }
        return arrayMap;
    }

    public final String zzaj() {
        zzii zziiVarZzab = this.zzz.zzv().zzab();
        if (zziiVarZzab != null) {
            return zziiVarZzab.zza;
        }
        return null;
    }

    public final String zzak() {
        zzii zziiVarZzab = this.zzz.zzv().zzab();
        if (zziiVarZzab != null) {
            return zziiVarZzab.zzb;
        }
        return null;
    }

    public final String zzal() {
        if (this.zzz.zzo() != null) {
            return this.zzz.zzo();
        }
        try {
            return new StringResourceValueReader(zzn()).getString("google_app_id");
        } catch (IllegalStateException e) {
            this.zzz.zzr().zzf().zza("getGoogleAppId failed with exception", e);
            return null;
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
}
