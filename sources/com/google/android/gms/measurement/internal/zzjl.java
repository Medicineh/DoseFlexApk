package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzjp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjl<T extends Context & zzjp> {
    private final T zza;

    public zzjl(T t) {
        Preconditions.checkNotNull(t);
        this.zza = t;
    }

    public final void zza() {
        zzfx zzfxVarZza = zzfx.zza(this.zza, null, null);
        zzet zzetVarZzr = zzfxVarZza.zzr();
        zzfxVarZza.zzu();
        zzetVarZzr.zzx().zza("Local AppMeasurementService is starting up");
    }

    public final void zzb() {
        zzfx zzfxVarZza = zzfx.zza(this.zza, null, null);
        zzet zzetVarZzr = zzfxVarZza.zzr();
        zzfxVarZza.zzu();
        zzetVarZzr.zzx().zza("Local AppMeasurementService is shutting down");
    }

    public final int zza(final Intent intent, int i, final int i2) {
        zzfx zzfxVarZza = zzfx.zza(this.zza, null, null);
        final zzet zzetVarZzr = zzfxVarZza.zzr();
        if (intent == null) {
            zzetVarZzr.zzi().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzfxVarZza.zzu();
        zzetVarZzr.zzx().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zza(new Runnable(this, i2, zzetVarZzr, intent) { // from class: com.google.android.gms.measurement.internal.zzjo
                private final zzjl zza;
                private final int zzb;
                private final zzet zzc;
                private final Intent zzd;

                {
                    this.zza = this;
                    this.zzb = i2;
                    this.zzc = zzetVarZzr;
                    this.zzd = intent;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(this.zzb, this.zzc, this.zzd);
                }
            });
        }
        return 2;
    }

    private final void zza(Runnable runnable) {
        zzkg zzkgVarZza = zzkg.zza(this.zza);
        zzkgVarZza.zzq().zza(new zzjq(this, zzkgVarZza, runnable));
    }

    public final IBinder zza(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzgc(zzkg.zza(this.zza));
        }
        zzc().zzi().zza("onBind received unknown action", action);
        return null;
    }

    public final boolean zzb(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onUnbind called with null intent");
            return true;
        }
        zzc().zzx().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final boolean zza(final JobParameters jobParameters) {
        zzfx zzfxVarZza = zzfx.zza(this.zza, null, null);
        final zzet zzetVarZzr = zzfxVarZza.zzr();
        String string = jobParameters.getExtras().getString("action");
        zzfxVarZza.zzu();
        zzetVarZzr.zzx().zza("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zza(new Runnable(this, zzetVarZzr, jobParameters) { // from class: com.google.android.gms.measurement.internal.zzjn
            private final zzjl zza;
            private final zzet zzb;
            private final JobParameters zzc;

            {
                this.zza = this;
                this.zzb = zzetVarZzr;
                this.zzc = jobParameters;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(this.zzb, this.zzc);
            }
        });
        return true;
    }

    public final void zzc(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onRebind called with null intent");
        } else {
            zzc().zzx().zza("onRebind called. action", intent.getAction());
        }
    }

    private final zzet zzc() {
        return zzfx.zza(this.zza, null, null).zzr();
    }

    final /* synthetic */ void zza(zzet zzetVar, JobParameters jobParameters) {
        zzetVar.zzx().zza("AppMeasurementJobService processed last upload request.");
        this.zza.zza(jobParameters, false);
    }

    final /* synthetic */ void zza(int i, zzet zzetVar, Intent intent) {
        if (this.zza.zza(i)) {
            zzetVar.zzx().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzc().zzx().zza("Completed wakeful intent.");
            this.zza.zza(intent);
        }
    }
}
