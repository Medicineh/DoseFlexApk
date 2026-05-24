package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzjl;
import com.google.android.gms.measurement.internal.zzjp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementJobService extends JobService implements zzjp {
    private zzjl<AppMeasurementJobService> zza;

    private final zzjl<AppMeasurementJobService> zza() {
        if (this.zza == null) {
            this.zza = new zzjl<>(this);
        }
        return this.zza;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzjp
    public final void zza(Intent intent) {
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        zza().zza();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        zza().zzb();
        super.onDestroy();
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return zza().zza(jobParameters);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return zza().zzb(intent);
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        zza().zzc(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzjp
    public final boolean zza(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzjp
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }
}
