package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzet extends zzgr {
    private char zza;
    private long zzb;
    private String zzc;
    private final zzev zzd;
    private final zzev zze;
    private final zzev zzf;
    private final zzev zzg;
    private final zzev zzh;
    private final zzev zzi;
    private final zzev zzj;
    private final zzev zzk;
    private final zzev zzl;

    zzet(zzfx zzfxVar) {
        super(zzfxVar);
        this.zza = (char) 0;
        this.zzb = -1L;
        this.zzd = new zzev(this, 6, false, false);
        this.zze = new zzev(this, 6, true, false);
        this.zzf = new zzev(this, 6, false, true);
        this.zzg = new zzev(this, 5, false, false);
        this.zzh = new zzev(this, 5, true, false);
        this.zzi = new zzev(this, 5, false, true);
        this.zzj = new zzev(this, 4, false, false);
        this.zzk = new zzev(this, 3, false, false);
        this.zzl = new zzev(this, 2, false, false);
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    protected final boolean zze() {
        return false;
    }

    public final zzev zzf() {
        return this.zzd;
    }

    public final zzev zzg() {
        return this.zze;
    }

    public final zzev zzh() {
        return this.zzf;
    }

    public final zzev zzi() {
        return this.zzg;
    }

    public final zzev zzj() {
        return this.zzh;
    }

    public final zzev zzk() {
        return this.zzi;
    }

    public final zzev zzv() {
        return this.zzj;
    }

    public final zzev zzw() {
        return this.zzk;
    }

    public final zzev zzx() {
        return this.zzl;
    }

    protected static Object zza(String str) {
        if (str == null) {
            return null;
        }
        return new zzey(str);
    }

    protected final void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && zza(i)) {
            zza(i, zza(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        Preconditions.checkNotNull(str);
        zzfu zzfuVarZzg = this.zzz.zzg();
        if (zzfuVarZzg == null) {
            zza(6, "Scheduler not set. Not logging error/warn");
        } else {
            if (!zzfuVarZzg.zzz()) {
                zza(6, "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i < 0) {
                i = 0;
            }
            zzfuVarZzg.zza(new zzew(this, i >= 9 ? 8 : i, str, obj, obj2, obj3));
        }
    }

    protected final boolean zza(int i) {
        return Log.isLoggable(zzad(), i);
    }

    protected final void zza(int i, String str) {
        Log.println(i, zzad(), str);
    }

    private final String zzad() {
        String str;
        String strZzs;
        synchronized (this) {
            if (this.zzc == null) {
                if (this.zzz.zzs() != null) {
                    strZzs = this.zzz.zzs();
                } else {
                    zzt().zzu();
                    strZzs = "FA";
                }
                this.zzc = strZzs;
            }
            str = this.zzc;
        }
        return str;
    }

    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strZza = zza(z, obj);
        String strZza2 = zza(z, obj2);
        String strZza3 = zza(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strZza)) {
            sb.append(str2);
            sb.append(strZza);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strZza2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strZza2);
        }
        if (!TextUtils.isEmpty(strZza3)) {
            sb.append(str3);
            sb.append(strZza3);
        }
        return sb.toString();
    }

    private static String zza(boolean z, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
            String strValueOf = String.valueOf(Math.abs(l.longValue()));
            long jRound = Math.round(Math.pow(10.0d, strValueOf.length() - 1));
            long jRound2 = Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(str.length() + 43 + str.length());
            sb.append(str);
            sb.append(jRound);
            sb.append("...");
            sb.append(str);
            sb.append(jRound2);
            return sb.toString();
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
            String strZzb = zzb(zzfx.class.getCanonicalName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzb(className).equals(strZzb)) {
                    sb2.append(": ");
                    sb2.append(stackTraceElement);
                    break;
                }
                i++;
            }
            return sb2.toString();
        }
        if (obj instanceof zzey) {
            return ((zzey) obj).zza;
        }
        return z ? "-" : String.valueOf(obj);
    }

    private static String zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? str : str.substring(0, iLastIndexOf);
    }

    public final String zzy() {
        Pair<String, Long> pairZza = zzs().zzb.zza();
        if (pairZza == null || pairZza == zzff.zza) {
            return null;
        }
        String strValueOf = String.valueOf(pairZza.second);
        String str = (String) pairZza.first;
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(str).length());
        sb.append(strValueOf);
        sb.append(":");
        sb.append(str);
        return sb.toString();
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
