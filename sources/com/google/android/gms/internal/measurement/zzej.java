package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
class zzej extends zzek {
    protected final byte[] zzb;

    zzej(byte[] bArr) {
        if (bArr == null) {
            throw null;
        }
        this.zzb = bArr;
    }

    protected int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzdz
    public byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzdz
    byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzdz
    public int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzdz
    public final zzdz zza(int i, int i2) {
        int iZzb = zzb(0, i2, zza());
        if (iZzb == 0) {
            return zzdz.zza;
        }
        return new zzeg(this.zzb, zze(), iZzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzdz
    final void zza(zzea zzeaVar) throws IOException {
        zzeaVar.zza(this.zzb, zze(), zza());
    }

    @Override // com.google.android.gms.internal.measurement.zzdz
    protected final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzdz
    public final boolean zzc() {
        int iZze = zze();
        return zzij.zza(this.zzb, iZze, zza() + iZze);
    }

    @Override // com.google.android.gms.internal.measurement.zzdz
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdz) || zza() != ((zzdz) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (obj instanceof zzej) {
            zzej zzejVar = (zzej) obj;
            int iZzd = zzd();
            int iZzd2 = zzejVar.zzd();
            if (iZzd == 0 || iZzd2 == 0 || iZzd == iZzd2) {
                return zza(zzejVar, 0, zza());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzek
    final boolean zza(zzdz zzdzVar, int i, int i2) {
        if (i2 > zzdzVar.zza()) {
            int iZza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(iZza);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 > zzdzVar.zza()) {
            int iZza2 = zzdzVar.zza();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(iZza2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (zzdzVar instanceof zzej) {
            zzej zzejVar = (zzej) zzdzVar;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzejVar.zzb;
            int iZze = zze() + i2;
            int iZze2 = zze();
            int iZze3 = zzejVar.zze();
            while (iZze2 < iZze) {
                if (bArr[iZze2] != bArr2[iZze3]) {
                    return false;
                }
                iZze2++;
                iZze3++;
            }
            return true;
        }
        return zzdzVar.zza(0, i2).equals(zza(0, i2));
    }

    @Override // com.google.android.gms.internal.measurement.zzdz
    protected final int zza(int i, int i2, int i3) {
        return zzfk.zza(i, this.zzb, zze(), i3);
    }
}
