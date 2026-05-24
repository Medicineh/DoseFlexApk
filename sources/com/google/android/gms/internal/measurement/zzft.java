package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public class zzft extends IOException {
    private zzgt zza;

    public zzft(String str) {
        super(str);
        this.zza = null;
    }

    static zzft zza() {
        return new zzft("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzft zzb() {
        return new zzft("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzft zzc() {
        return new zzft("CodedInputStream encountered a malformed varint.");
    }

    static zzft zzd() {
        return new zzft("Protocol message contained an invalid tag (zero).");
    }

    static zzft zze() {
        return new zzft("Protocol message end-group tag did not match expected tag.");
    }

    static zzfs zzf() {
        return new zzfs("Protocol message tag had invalid wire type.");
    }

    static zzft zzg() {
        return new zzft("Failed to parse the message.");
    }

    static zzft zzh() {
        return new zzft("Protocol message had invalid UTF-8.");
    }
}
