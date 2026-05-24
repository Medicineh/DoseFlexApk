package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzbw;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzr {
    private zzbw.zzc zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzq zzd;

    private zzr(zzq zzqVar) {
        this.zzd = zzqVar;
    }

    final zzbw.zzc zza(String str, zzbw.zzc zzcVar) {
        String strZzc = zzcVar.zzc();
        List<zzbw.zze> listZza = zzcVar.zza();
        Long l = (Long) this.zzd.zzg().zzb(zzcVar, "_eid");
        boolean z = l != null;
        if (z && strZzc.equals("_ep")) {
            strZzc = (String) this.zzd.zzg().zzb(zzcVar, "_en");
            if (TextUtils.isEmpty(strZzc)) {
                this.zzd.zzr().zzg().zza("Extra parameter without an event name. eventId", l);
                return null;
            }
            if (this.zza == null || this.zzb == null || l.longValue() != this.zzb.longValue()) {
                Pair<zzbw.zzc, Long> pairZza = this.zzd.zzi().zza(str, l);
                if (pairZza == null || pairZza.first == null) {
                    this.zzd.zzr().zzg().zza("Extra parameter without existing main event. eventName, eventId", strZzc, l);
                    return null;
                }
                this.zza = (zzbw.zzc) pairZza.first;
                this.zzc = ((Long) pairZza.second).longValue();
                this.zzb = (Long) this.zzd.zzg().zzb(this.zza, "_eid");
            }
            long j = this.zzc - 1;
            this.zzc = j;
            if (j <= 0) {
                zzab zzabVarZzi = this.zzd.zzi();
                zzabVarZzi.zzd();
                zzabVarZzi.zzr().zzx().zza("Clearing complex main event info. appId", str);
                try {
                    zzabVarZzi.c_().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e) {
                    zzabVarZzi.zzr().zzf().zza("Error clearing complex main event", e);
                }
            } else {
                this.zzd.zzi().zza(str, l, this.zzc, this.zza);
            }
            ArrayList arrayList = new ArrayList();
            for (zzbw.zze zzeVar : this.zza.zza()) {
                this.zzd.zzg();
                if (zzkk.zza(zzcVar, zzeVar.zzb()) == null) {
                    arrayList.add(zzeVar);
                }
            }
            if (arrayList.isEmpty()) {
                this.zzd.zzr().zzg().zza("No unique parameters in main event. eventName", strZzc);
            } else {
                arrayList.addAll(listZza);
                listZza = arrayList;
            }
        } else if (z) {
            this.zzb = l;
            this.zza = zzcVar;
            Object objZzb = this.zzd.zzg().zzb(zzcVar, "_epc");
            long jLongValue = ((Long) (objZzb != null ? objZzb : 0L)).longValue();
            this.zzc = jLongValue;
            if (jLongValue <= 0) {
                this.zzd.zzr().zzg().zza("Complex event with zero extra param count. eventName", strZzc);
            } else {
                this.zzd.zzi().zza(str, l, this.zzc, zzcVar);
            }
        }
        return (zzbw.zzc) ((com.google.android.gms.internal.measurement.zzfi) zzcVar.zzbm().zza(strZzc).zzc().zza(listZza).zzu());
    }

    /* synthetic */ zzr(zzq zzqVar, zzp zzpVar) {
        this(zzqVar);
    }
}
