package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfu extends zzgr {
    private static final AtomicLong zzj = new AtomicLong(Long.MIN_VALUE);
    private zzfy zza;
    private zzfy zzb;
    private final PriorityBlockingQueue<zzfv<?>> zzc;
    private final BlockingQueue<zzfv<?>> zzd;
    private final Thread.UncaughtExceptionHandler zze;
    private final Thread.UncaughtExceptionHandler zzf;
    private final Object zzg;
    private final Semaphore zzh;
    private volatile boolean zzi;

    zzfu(zzfx zzfxVar) {
        super(zzfxVar);
        this.zzg = new Object();
        this.zzh = new Semaphore(2);
        this.zzc = new PriorityBlockingQueue<>();
        this.zzd = new LinkedBlockingQueue();
        this.zze = new zzfw(this, "Thread death: Uncaught exception on worker thread");
        this.zzf = new zzfw(this, "Thread death: Uncaught exception on network thread");
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    protected final boolean zze() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final void zzd() {
        if (Thread.currentThread() != this.zza) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final void zzc() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final boolean zzg() {
        return Thread.currentThread() == this.zza;
    }

    public final <V> Future<V> zza(Callable<V> callable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(callable);
        zzfv<?> zzfvVar = new zzfv<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            if (!this.zzc.isEmpty()) {
                zzr().zzi().zza("Callable skipped the worker queue.");
            }
            zzfvVar.run();
        } else {
            zza(zzfvVar);
        }
        return zzfvVar;
    }

    public final <V> Future<V> zzb(Callable<V> callable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(callable);
        zzfv<?> zzfvVar = new zzfv<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            zzfvVar.run();
        } else {
            zza(zzfvVar);
        }
        return zzfvVar;
    }

    public final void zza(Runnable runnable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(runnable);
        zza(new zzfv<>(this, runnable, false, "Task exception on worker thread"));
    }

    final <T> T zza(AtomicReference<T> atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            zzq().zza(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                zzev zzevVarZzi = zzr().zzi();
                String strValueOf = String.valueOf(str);
                zzevVarZzi.zza(strValueOf.length() != 0 ? "Interrupted waiting for ".concat(strValueOf) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            zzev zzevVarZzi2 = zzr().zzi();
            String strValueOf2 = String.valueOf(str);
            zzevVarZzi2.zza(strValueOf2.length() != 0 ? "Timed out waiting for ".concat(strValueOf2) : new String("Timed out waiting for "));
        }
        return t;
    }

    private final void zza(zzfv<?> zzfvVar) {
        synchronized (this.zzg) {
            this.zzc.add(zzfvVar);
            if (this.zza == null) {
                zzfy zzfyVar = new zzfy(this, "Measurement Worker", this.zzc);
                this.zza = zzfyVar;
                zzfyVar.setUncaughtExceptionHandler(this.zze);
                this.zza.start();
            } else {
                this.zza.zza();
            }
        }
    }

    public final void zzb(Runnable runnable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(runnable);
        zzfv<?> zzfvVar = new zzfv<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzg) {
            this.zzd.add(zzfvVar);
            if (this.zzb == null) {
                zzfy zzfyVar = new zzfy(this, "Measurement Network", this.zzd);
                this.zzb = zzfyVar;
                zzfyVar.setUncaughtExceptionHandler(this.zzf);
                this.zzb.start();
            } else {
                this.zzb.zza();
            }
        }
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

    static /* synthetic */ zzfy zza(zzfu zzfuVar, zzfy zzfyVar) {
        zzfuVar.zza = null;
        return null;
    }

    static /* synthetic */ zzfy zzb(zzfu zzfuVar, zzfy zzfyVar) {
        zzfuVar.zzb = null;
        return null;
    }
}
