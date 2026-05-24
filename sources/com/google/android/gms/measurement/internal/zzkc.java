package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkc extends zzkd {
    private final AlarmManager zzb;
    private final zzai zzc;
    private Integer zzd;

    protected zzkc(zzkg zzkgVar) {
        super(zzkgVar);
        this.zzb = (AlarmManager) zzn().getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.zzc = new zzkb(this, zzkgVar.zzs(), zzkgVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkd
    protected final boolean zze() {
        this.zzb.cancel(zzw());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        zzk();
        return false;
    }

    private final void zzk() {
        ((JobScheduler) zzn().getSystemService("jobscheduler")).cancel(zzv());
    }

    public final void zza(long j) {
        zzak();
        zzu();
        Context contextZzn = zzn();
        if (!zzfp.zza(contextZzn)) {
            zzr().zzw().zza("Receiver not registered/enabled");
        }
        if (!zzko.zza(contextZzn, false)) {
            zzr().zzw().zza("Service not registered/enabled");
        }
        zzf();
        zzr().zzx().zza("Scheduling upload, millis", Long.valueOf(j));
        long jElapsedRealtime = zzm().elapsedRealtime() + j;
        if (j < Math.max(0L, zzas.zzw.zza(null).longValue()) && !this.zzc.zzb()) {
            this.zzc.zza(j);
        }
        zzu();
        if (Build.VERSION.SDK_INT >= 24) {
            Context contextZzn2 = zzn();
            ComponentName componentName = new ComponentName(contextZzn2, "com.google.android.gms.measurement.AppMeasurementJobService");
            int iZzv = zzv();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            com.google.android.gms.internal.measurement.zzh.zza(contextZzn2, new JobInfo.Builder(iZzv, componentName).setMinimumLatency(j).setOverrideDeadline(j << 1).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
            return;
        }
        this.zzb.setInexactRepeating(2, jElapsedRealtime, Math.max(zzas.zzr.zza(null).longValue(), j), zzw());
    }

    private final int zzv() {
        if (this.zzd == null) {
            String strValueOf = String.valueOf(zzn().getPackageName());
            this.zzd = Integer.valueOf((strValueOf.length() != 0 ? "measurement".concat(strValueOf) : new String("measurement")).hashCode());
        }
        return this.zzd.intValue();
    }

    public final void zzf() {
        zzak();
        zzr().zzx().zza("Unscheduling upload");
        this.zzb.cancel(zzw());
        this.zzc.zzc();
        if (Build.VERSION.SDK_INT >= 24) {
            zzk();
        }
    }

    private final PendingIntent zzw() {
        Context contextZzn = zzn();
        return PendingIntent.getBroadcast(contextZzn, 0, new Intent().setClassName(contextZzn, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
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
