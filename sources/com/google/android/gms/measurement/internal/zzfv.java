package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzfv<V> extends FutureTask<V> implements Comparable<zzfv<V>> {
    final boolean zza;
    private final long zzb;
    private final String zzc;
    private final /* synthetic */ zzfu zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfv(zzfu zzfuVar, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.zzd = zzfuVar;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfu.zzj.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzfuVar.zzr().zzf().zza("Tasks index overflow");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfv(zzfu zzfuVar, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.zzd = zzfuVar;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfu.zzj.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = false;
        if (andIncrement == Long.MAX_VALUE) {
            zzfuVar.zzr().zzf().zza("Tasks index overflow");
        }
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        this.zzd.zzr().zzf().zza(this.zzc, th);
        if (th instanceof zzft) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        zzfv zzfvVar = (zzfv) obj;
        boolean z = this.zza;
        if (z != zzfvVar.zza) {
            return z ? -1 : 1;
        }
        long j = this.zzb;
        long j2 = zzfvVar.zzb;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.zzd.zzr().zzg().zza("Two tasks share the same index. index", Long.valueOf(this.zzb));
        return 0;
    }
}
