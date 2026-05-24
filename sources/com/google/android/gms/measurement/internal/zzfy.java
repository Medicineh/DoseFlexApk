package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzfy extends Thread {
    private final Object zza;
    private final BlockingQueue<zzfv<?>> zzb;
    private boolean zzc = false;
    private final /* synthetic */ zzfu zzd;

    public zzfy(zzfu zzfuVar, String str, BlockingQueue<zzfv<?>> blockingQueue) {
        this.zzd = zzfuVar;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zza = new Object();
        this.zzb = blockingQueue;
        setName(str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z = false;
        while (!z) {
            try {
                this.zzd.zzh.acquire();
                z = true;
            } catch (InterruptedException e) {
                zza(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzfv<?> zzfvVarPoll = this.zzb.poll();
                if (zzfvVarPoll != null) {
                    Process.setThreadPriority(zzfvVarPoll.zza ? threadPriority : 10);
                    zzfvVarPoll.run();
                } else {
                    synchronized (this.zza) {
                        if (this.zzb.peek() == null && !this.zzd.zzi) {
                            try {
                                this.zza.wait(30000L);
                            } catch (InterruptedException e2) {
                                zza(e2);
                            }
                        }
                    }
                    synchronized (this.zzd.zzg) {
                        if (this.zzb.peek() == null) {
                            break;
                        }
                    }
                }
            }
            if (this.zzd.zzt().zza(zzas.zzby)) {
                zzb();
            }
        } finally {
            zzb();
        }
    }

    private final void zzb() {
        synchronized (this.zzd.zzg) {
            if (!this.zzc) {
                this.zzd.zzh.release();
                this.zzd.zzg.notifyAll();
                if (this == this.zzd.zza) {
                    zzfu.zza(this.zzd, null);
                } else if (this == this.zzd.zzb) {
                    zzfu.zzb(this.zzd, null);
                } else {
                    this.zzd.zzr().zzf().zza("Current scheduler thread is neither worker nor network");
                }
                this.zzc = true;
            }
        }
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.notifyAll();
        }
    }

    private final void zza(InterruptedException interruptedException) {
        this.zzd.zzr().zzi().zza(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }
}
