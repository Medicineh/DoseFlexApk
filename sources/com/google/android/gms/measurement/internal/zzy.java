package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new zzx();
    public String zza;
    public String zzb;
    public zzkn zzc;
    public long zzd;
    public boolean zze;
    public String zzf;
    public zzaq zzg;
    public long zzh;
    public zzaq zzi;
    public long zzj;
    public zzaq zzk;

    zzy(zzy zzyVar) {
        Preconditions.checkNotNull(zzyVar);
        this.zza = zzyVar.zza;
        this.zzb = zzyVar.zzb;
        this.zzc = zzyVar.zzc;
        this.zzd = zzyVar.zzd;
        this.zze = zzyVar.zze;
        this.zzf = zzyVar.zzf;
        this.zzg = zzyVar.zzg;
        this.zzh = zzyVar.zzh;
        this.zzi = zzyVar.zzi;
        this.zzj = zzyVar.zzj;
        this.zzk = zzyVar.zzk;
    }

    zzy(String str, String str2, zzkn zzknVar, long j, boolean z, String str3, zzaq zzaqVar, long j2, zzaq zzaqVar2, long j3, zzaq zzaqVar3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzknVar;
        this.zzd = j;
        this.zze = z;
        this.zzf = str3;
        this.zzg = zzaqVar;
        this.zzh = j2;
        this.zzi = zzaqVar2;
        this.zzj = j3;
        this.zzk = zzaqVar3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzk, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
