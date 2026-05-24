package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgz<T> implements zzhi<T> {
    private final zzgt zza;
    private final zzia<?, ?> zzb;
    private final boolean zzc;
    private final zzex<?> zzd;

    private zzgz(zzia<?, ?> zziaVar, zzex<?> zzexVar, zzgt zzgtVar) {
        this.zzb = zziaVar;
        this.zzc = zzexVar.zza(zzgtVar);
        this.zzd = zzexVar;
        this.zza = zzgtVar;
    }

    static <T> zzgz<T> zza(zzia<?, ?> zziaVar, zzex<?> zzexVar, zzgt zzgtVar) {
        return new zzgz<>(zziaVar, zzexVar, zzgtVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    public final T zza() {
        return (T) this.zza.zzbs().zzt();
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    public final boolean zza(T t, T t2) {
        if (!this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(t).equals(this.zzd.zza(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    public final int zza(T t) {
        int iHashCode = this.zzb.zzb(t).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zza(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    public final void zzb(T t, T t2) {
        zzhk.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzhk.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    public final void zza(T t, zzix zzixVar) throws IOException {
        Iterator itZzd = this.zzd.zza(t).zzd();
        while (itZzd.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzd.next();
            zzfd zzfdVar = (zzfd) entry.getKey();
            if (zzfdVar.zzc() != zziu.MESSAGE || zzfdVar.zzd() || zzfdVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzfw) {
                zzixVar.zza(zzfdVar.zza(), (Object) ((zzfw) entry).zza().zzc());
            } else {
                zzixVar.zza(zzfdVar.zza(), entry.getValue());
            }
        }
        zzia<?, ?> zziaVar = this.zzb;
        zziaVar.zzb(zziaVar.zzb(t), zzixVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0099 A[EDGE_INSN: B:57:0x0099->B:34:0x0099 BREAK  A[LOOP:1: B:18:0x0053->B:62:0x0053], SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzhi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.measurement.zzdy r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.measurement.zzfi r0 = (com.google.android.gms.internal.measurement.zzfi) r0
            com.google.android.gms.internal.measurement.zzid r1 = r0.zzb
            com.google.android.gms.internal.measurement.zzid r2 = com.google.android.gms.internal.measurement.zzid.zza()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.measurement.zzid r1 = com.google.android.gms.internal.measurement.zzid.zzb()
            r0.zzb = r1
        L11:
            com.google.android.gms.internal.measurement.zzfi$zzd r10 = (com.google.android.gms.internal.measurement.zzfi.zzd) r10
            r10.zza()
            r10 = 0
            r0 = r10
        L18:
            if (r12 >= r13) goto La4
            int r4 = com.google.android.gms.internal.measurement.zzdv.zza(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L51
            r12 = r2 & 7
            if (r12 != r3) goto L4c
            com.google.android.gms.internal.measurement.zzex<?> r12 = r9.zzd
            com.google.android.gms.internal.measurement.zzev r0 = r14.zzd
            com.google.android.gms.internal.measurement.zzgt r3 = r9.zza
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.measurement.zzfi$zzf r0 = (com.google.android.gms.internal.measurement.zzfi.zzf) r0
            if (r0 != 0) goto L43
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.zzdv.zza(r2, r3, r4, r5, r6, r7)
            goto L18
        L43:
            com.google.android.gms.internal.measurement.zzhe.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L4c:
            int r12 = com.google.android.gms.internal.measurement.zzdv.zza(r2, r11, r4, r13, r14)
            goto L18
        L51:
            r12 = 0
            r2 = r10
        L53:
            if (r4 >= r13) goto L99
            int r4 = com.google.android.gms.internal.measurement.zzdv.zza(r11, r4, r14)
            int r5 = r14.zza
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L7b
            r8 = 3
            if (r6 == r8) goto L65
            goto L90
        L65:
            if (r0 != 0) goto L72
            if (r7 != r3) goto L90
            int r4 = com.google.android.gms.internal.measurement.zzdv.zze(r11, r4, r14)
            java.lang.Object r2 = r14.zzc
            com.google.android.gms.internal.measurement.zzdz r2 = (com.google.android.gms.internal.measurement.zzdz) r2
            goto L53
        L72:
            com.google.android.gms.internal.measurement.zzhe.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L7b:
            if (r7 != 0) goto L90
            int r4 = com.google.android.gms.internal.measurement.zzdv.zza(r11, r4, r14)
            int r12 = r14.zza
            com.google.android.gms.internal.measurement.zzex<?> r0 = r9.zzd
            com.google.android.gms.internal.measurement.zzev r5 = r14.zzd
            com.google.android.gms.internal.measurement.zzgt r6 = r9.zza
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.measurement.zzfi$zzf r0 = (com.google.android.gms.internal.measurement.zzfi.zzf) r0
            goto L53
        L90:
            r6 = 12
            if (r5 == r6) goto L99
            int r4 = com.google.android.gms.internal.measurement.zzdv.zza(r5, r11, r4, r13, r14)
            goto L53
        L99:
            if (r2 == 0) goto La1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zza(r12, r2)
        La1:
            r12 = r4
            goto L18
        La4:
            if (r12 != r13) goto La7
            return
        La7:
            com.google.android.gms.internal.measurement.zzft r10 = com.google.android.gms.internal.measurement.zzft.zzg()
            goto Lad
        Lac:
            throw r10
        Lad:
            goto Lac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgz.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzdy):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[LOOP:0: B:46:0x000c->B:54:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzhi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r11, com.google.android.gms.internal.measurement.zzhj r12, com.google.android.gms.internal.measurement.zzev r13) throws java.io.IOException {
        /*
            r10 = this;
            com.google.android.gms.internal.measurement.zzia<?, ?> r0 = r10.zzb
            com.google.android.gms.internal.measurement.zzex<?> r1 = r10.zzd
            java.lang.Object r2 = r0.zzc(r11)
            com.google.android.gms.internal.measurement.zzfb r3 = r1.zzb(r11)
        Lc:
            int r4 = r12.zza()     // Catch: java.lang.Throwable -> L8e
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 != r5) goto L19
            r0.zzb(r11, r2)
            return
        L19:
            int r4 = r12.zzb()     // Catch: java.lang.Throwable -> L8e
            r6 = 11
            if (r4 == r6) goto L3e
            r5 = r4 & 7
            r6 = 2
            if (r5 != r6) goto L39
            com.google.android.gms.internal.measurement.zzgt r5 = r10.zza     // Catch: java.lang.Throwable -> L8e
            int r4 = r4 >>> 3
            java.lang.Object r4 = r1.zza(r13, r5, r4)     // Catch: java.lang.Throwable -> L8e
            if (r4 == 0) goto L34
            r1.zza(r12, r4, r13, r3)     // Catch: java.lang.Throwable -> L8e
            goto L82
        L34:
            boolean r4 = r0.zza(r2, r12)     // Catch: java.lang.Throwable -> L8e
            goto L83
        L39:
            boolean r4 = r12.zzc()     // Catch: java.lang.Throwable -> L8e
            goto L83
        L3e:
            r4 = 0
            r6 = 0
            r7 = r6
        L41:
            int r8 = r12.zza()     // Catch: java.lang.Throwable -> L8e
            if (r8 == r5) goto L6f
            int r8 = r12.zzb()     // Catch: java.lang.Throwable -> L8e
            r9 = 16
            if (r8 != r9) goto L5a
            int r4 = r12.zzo()     // Catch: java.lang.Throwable -> L8e
            com.google.android.gms.internal.measurement.zzgt r6 = r10.zza     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r6 = r1.zza(r13, r6, r4)     // Catch: java.lang.Throwable -> L8e
            goto L41
        L5a:
            r9 = 26
            if (r8 != r9) goto L69
            if (r6 == 0) goto L64
            r1.zza(r12, r6, r13, r3)     // Catch: java.lang.Throwable -> L8e
            goto L41
        L64:
            com.google.android.gms.internal.measurement.zzdz r7 = r12.zzn()     // Catch: java.lang.Throwable -> L8e
            goto L41
        L69:
            boolean r8 = r12.zzc()     // Catch: java.lang.Throwable -> L8e
            if (r8 != 0) goto L41
        L6f:
            int r5 = r12.zzb()     // Catch: java.lang.Throwable -> L8e
            r8 = 12
            if (r5 != r8) goto L89
            if (r7 == 0) goto L82
            if (r6 == 0) goto L7f
            r1.zza(r7, r6, r13, r3)     // Catch: java.lang.Throwable -> L8e
            goto L82
        L7f:
            r0.zza(r2, r4, r7)     // Catch: java.lang.Throwable -> L8e
        L82:
            r4 = 1
        L83:
            if (r4 != 0) goto Lc
            r0.zzb(r11, r2)
            return
        L89:
            com.google.android.gms.internal.measurement.zzft r12 = com.google.android.gms.internal.measurement.zzft.zze()     // Catch: java.lang.Throwable -> L8e
            throw r12     // Catch: java.lang.Throwable -> L8e
        L8e:
            r12 = move-exception
            r0.zzb(r11, r2)
            goto L94
        L93:
            throw r12
        L94:
            goto L93
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgz.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzhj, com.google.android.gms.internal.measurement.zzev):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    public final boolean zzd(T t) {
        return this.zzd.zza(t).zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    public final int zzb(T t) {
        zzia<?, ?> zziaVar = this.zzb;
        int iZze = zziaVar.zze(zziaVar.zzb(t)) + 0;
        return this.zzc ? iZze + this.zzd.zza(t).zzg() : iZze;
    }
}
