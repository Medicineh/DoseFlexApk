package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzin extends zze {
    private final zzjf zza;
    private zzel zzb;
    private volatile Boolean zzc;
    private final zzai zzd;
    private final zzjz zze;
    private final List<Runnable> zzf;
    private final zzai zzg;

    protected zzin(zzfx zzfxVar) {
        super(zzfxVar);
        this.zzf = new ArrayList();
        this.zze = new zzjz(zzfxVar.zzm());
        this.zza = new zzjf(this);
        this.zzd = new zziq(this, zzfxVar);
        this.zzg = new zzix(this, zzfxVar);
    }

    @Override // com.google.android.gms.measurement.internal.zze
    protected final boolean zzz() {
        return false;
    }

    public final boolean zzab() {
        zzd();
        zzw();
        return this.zzb != null;
    }

    protected final void zzac() {
        zzd();
        zzw();
        zza(new zzja(this, zza(true)));
    }

    final void zza(zzel zzelVar, AbstractSafeParcelable abstractSafeParcelable, zzm zzmVar) {
        int size;
        List<AbstractSafeParcelable> listZza;
        zzd();
        zzb();
        zzw();
        boolean zZzaj = zzaj();
        int i = 0;
        int i2 = 100;
        while (i < 1001 && i2 == 100) {
            ArrayList arrayList = new ArrayList();
            if (!zZzaj || (listZza = zzj().zza(100)) == null) {
                size = 0;
            } else {
                arrayList.addAll(listZza);
                size = listZza.size();
            }
            if (abstractSafeParcelable != null && size < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = arrayList;
            int size2 = arrayList2.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj = arrayList2.get(i3);
                i3++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzaq) {
                    try {
                        zzelVar.zza((zzaq) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e) {
                        zzr().zzf().zza("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkn) {
                    try {
                        zzelVar.zza((zzkn) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e2) {
                        zzr().zzf().zza("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzy) {
                    try {
                        zzelVar.zza((zzy) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e3) {
                        zzr().zzf().zza("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    zzr().zzf().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i++;
            i2 = size;
        }
    }

    protected final void zza(zzaq zzaqVar, String str) {
        Preconditions.checkNotNull(zzaqVar);
        zzd();
        zzw();
        boolean zZzaj = zzaj();
        zza(new zziz(this, zZzaj, zZzaj && zzj().zza(zzaqVar), zzaqVar, zza(true), str));
    }

    protected final void zza(zzy zzyVar) {
        Preconditions.checkNotNull(zzyVar);
        zzd();
        zzw();
        zzu();
        zza(new zzjc(this, true, zzj().zza(zzyVar), new zzy(zzyVar), zza(true), zzyVar));
    }

    protected final void zza(AtomicReference<List<zzy>> atomicReference, String str, String str2, String str3) {
        zzd();
        zzw();
        zza(new zzjb(this, atomicReference, str, str2, str3, zza(false)));
    }

    protected final void zza(com.google.android.gms.internal.measurement.zzs zzsVar, String str, String str2) {
        zzd();
        zzw();
        zza(new zzje(this, str, str2, zza(false), zzsVar));
    }

    protected final void zza(AtomicReference<List<zzkn>> atomicReference, String str, String str2, String str3, boolean z) {
        zzd();
        zzw();
        zza(new zzjd(this, atomicReference, str, str2, str3, z, zza(false)));
    }

    protected final void zza(com.google.android.gms.internal.measurement.zzs zzsVar, String str, String str2, boolean z) {
        zzd();
        zzw();
        zza(new zzjg(this, str, str2, z, zza(false), zzsVar));
    }

    protected final void zza(zzkn zzknVar) {
        zzd();
        zzw();
        zza(new zzip(this, zzaj() && zzj().zza(zzknVar), zzknVar, zza(true)));
    }

    protected final void zza(AtomicReference<List<zzkn>> atomicReference, boolean z) {
        zzd();
        zzw();
        zza(new zzis(this, atomicReference, zza(false), z));
    }

    protected final void zzad() {
        zzd();
        zzb();
        zzw();
        zzm zzmVarZza = zza(false);
        if (zzaj()) {
            zzj().zzab();
        }
        zza(new zzir(this, zzmVarZza));
    }

    private final boolean zzaj() {
        zzu();
        return true;
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzd();
        zzw();
        zza(new zziu(this, atomicReference, zza(false)));
    }

    public final void zza(com.google.android.gms.internal.measurement.zzs zzsVar) {
        zzd();
        zzw();
        zza(new zzit(this, zza(false), zzsVar));
    }

    protected final void zzae() {
        zzd();
        zzw();
        zzm zzmVarZza = zza(true);
        zzj().zzac();
        zza(new zziw(this, zzmVarZza));
    }

    protected final void zza(zzii zziiVar) {
        zzd();
        zzw();
        zza(new zziv(this, zziiVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzak() {
        zzd();
        this.zze.zza();
        this.zzd.zza(zzas.zzai.zza(null).longValue());
    }

    final void zzaf() {
        zzd();
        zzw();
        if (zzab()) {
            return;
        }
        if (zzal()) {
            this.zza.zzb();
            return;
        }
        if (zzt().zzy()) {
            return;
        }
        zzu();
        List<ResolveInfo> listQueryIntentServices = zzn().getPackageManager().queryIntentServices(new Intent().setClassName(zzn(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            Context contextZzn = zzn();
            zzu();
            intent.setComponent(new ComponentName(contextZzn, "com.google.android.gms.measurement.AppMeasurementService"));
            this.zza.zza(intent);
            return;
        }
        zzr().zzf().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
    }

    final Boolean zzag() {
        return this.zzc;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzal() {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzin.zzal():boolean");
    }

    protected final void zza(zzel zzelVar) {
        zzd();
        Preconditions.checkNotNull(zzelVar);
        this.zzb = zzelVar;
        zzak();
        zzan();
    }

    public final void zzah() {
        zzd();
        zzw();
        this.zza.zza();
        try {
            ConnectionTracker.getInstance().unbindService(zzn(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(ComponentName componentName) {
        zzd();
        if (this.zzb != null) {
            this.zzb = null;
            zzr().zzx().zza("Disconnected from device MeasurementService", componentName);
            zzd();
            zzaf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzam() {
        zzd();
        if (zzab()) {
            zzr().zzx().zza("Inactivity, disconnecting from the service");
            zzah();
        }
    }

    private final void zza(Runnable runnable) throws IllegalStateException {
        zzd();
        if (zzab()) {
            runnable.run();
        } else {
            if (this.zzf.size() >= 1000) {
                zzr().zzf().zza("Discarding data. Max runnable queue size reached");
                return;
            }
            this.zzf.add(runnable);
            this.zzg.zza(60000L);
            zzaf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzan() {
        zzd();
        zzr().zzx().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        Iterator<Runnable> it = this.zzf.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (Exception e) {
                zzr().zzf().zza("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zzc();
    }

    private final zzm zza(boolean z) {
        zzu();
        return zzg().zza(z ? zzr().zzy() : null);
    }

    public final void zza(com.google.android.gms.internal.measurement.zzs zzsVar, zzaq zzaqVar, String str) {
        zzd();
        zzw();
        if (zzp().zza(12451000) != 0) {
            zzr().zzi().zza("Not bundling data. Service unavailable or out of date");
            zzp().zza(zzsVar, new byte[0]);
        } else {
            zza(new zziy(this, zzaqVar, str, zzsVar));
        }
    }

    final boolean zzai() {
        zzd();
        zzw();
        return !zzal() || zzp().zzj() >= 200900;
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

    static /* synthetic */ zzel zza(zzin zzinVar, zzel zzelVar) {
        zzinVar.zzb = null;
        return null;
    }
}
