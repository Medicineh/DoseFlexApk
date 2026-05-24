package com.google.android.gms.measurement.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzas {
    public static zzem<Double> zzan;
    public static zzem<Integer> zzao;
    public static zzem<Integer> zzap;
    public static zzem<Boolean> zzaq;
    public static zzem<Boolean> zzar;
    public static zzem<Boolean> zzas;
    public static zzem<Boolean> zzat;
    public static zzem<Boolean> zzau;
    public static zzem<Boolean> zzav;
    public static zzem<Boolean> zzaw;
    public static zzem<Boolean> zzax;
    public static zzem<Boolean> zzay;
    public static zzem<Boolean> zzaz;
    public static zzem<Boolean> zzba;
    public static zzem<Boolean> zzbb;
    public static zzem<Boolean> zzbc;
    public static zzem<Boolean> zzbd;
    public static zzem<Boolean> zzbe;
    public static zzem<Boolean> zzbf;
    public static zzem<Boolean> zzbg;
    public static zzem<Boolean> zzbh;
    public static zzem<Boolean> zzbi;
    public static zzem<Boolean> zzbj;
    public static zzem<Boolean> zzbk;
    public static zzem<Boolean> zzbl;
    public static zzem<Boolean> zzbm;
    public static zzem<Boolean> zzbn;
    public static zzem<Boolean> zzbo;
    public static zzem<Boolean> zzbp;
    public static zzem<Boolean> zzbq;
    public static zzem<Boolean> zzbr;
    public static zzem<Boolean> zzbs;
    public static zzem<Boolean> zzbt;
    public static zzem<Boolean> zzbu;
    public static zzem<Boolean> zzbv;
    public static zzem<Boolean> zzbw;
    public static zzem<Boolean> zzbx;
    public static zzem<Boolean> zzby;
    public static zzem<Boolean> zzbz;
    public static zzem<Boolean> zzca;
    public static zzem<Boolean> zzcb;
    public static zzem<Boolean> zzcc;
    public static zzem<Boolean> zzcd;
    public static zzem<Boolean> zzce;
    public static zzem<Boolean> zzcf;
    public static zzem<Boolean> zzcg;
    public static zzem<Boolean> zzch;
    public static zzem<Boolean> zzci;
    public static zzem<Boolean> zzcj;
    public static zzem<Boolean> zzck;
    public static zzem<Boolean> zzcl;
    public static zzem<Boolean> zzcm;
    public static zzem<Boolean> zzcn;
    public static zzem<Boolean> zzco;
    public static zzem<Boolean> zzcp;
    public static zzem<Long> zzcq;
    private static zzem<Boolean> zzct;
    private static zzem<Boolean> zzcu;
    private static zzem<Boolean> zzcv;
    private static List<zzem<?>> zzcr = Collections.synchronizedList(new ArrayList());
    private static Set<zzem<?>> zzcs = Collections.synchronizedSet(new HashSet());
    public static zzem<Long> zza = zza("measurement.ad_id_cache_time", 10000L, 10000L, zzar.zza);
    public static zzem<Long> zzb = zza("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, zzau.zza);
    public static zzem<Long> zzc = zza("measurement.config.cache_time", 86400000L, 3600000L, zzbd.zza);
    public static zzem<String> zzd = zza("measurement.config.url_scheme", "https", "https", zzbq.zza);
    public static zzem<String> zze = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", zzbz.zza);
    public static zzem<Integer> zzf = zza("measurement.upload.max_bundles", 100, 100, zzcm.zza);
    public static zzem<Integer> zzg = zza("measurement.upload.max_batch_size", 65536, 65536, zzcv.zza);
    public static zzem<Integer> zzh = zza("measurement.upload.max_bundle_size", 65536, 65536, zzdi.zza);
    public static zzem<Integer> zzi = zza("measurement.upload.max_events_per_bundle", 1000, 1000, zzdr.zza);
    public static zzem<Integer> zzj = zza("measurement.upload.max_events_per_day", 100000, 100000, zzee.zza);
    public static zzem<Integer> zzk = zza("measurement.upload.max_error_events_per_day", 1000, 1000, zzat.zza);
    public static zzem<Integer> zzl = zza("measurement.upload.max_public_events_per_day", 50000, 50000, zzaw.zza);
    public static zzem<Integer> zzm = zza("measurement.upload.max_conversions_per_day", 10000, 10000, zzav.zza);
    public static zzem<Integer> zzn = zza("measurement.upload.max_realtime_events_per_day", 10, 10, zzay.zza);
    public static zzem<Integer> zzo = zza("measurement.store.max_stored_events_per_app", 100000, 100000, zzax.zza);
    public static zzem<String> zzp = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", zzba.zza);
    public static zzem<Long> zzq = zza("measurement.upload.backoff_period", 43200000L, 43200000L, zzaz.zza);
    public static zzem<Long> zzr = zza("measurement.upload.window_interval", 3600000L, 3600000L, zzbc.zza);
    public static zzem<Long> zzs = zza("measurement.upload.interval", 3600000L, 3600000L, zzbb.zza);
    public static zzem<Long> zzt = zza("measurement.upload.realtime_upload_interval", 10000L, 10000L, zzbe.zza);
    public static zzem<Long> zzu = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, zzbg.zza);
    public static zzem<Long> zzv = zza("measurement.upload.minimum_delay", 500L, 500L, zzbf.zza);
    public static zzem<Long> zzw = zza("measurement.alarm_manager.minimum_interval", 60000L, 60000L, zzbi.zza);
    public static zzem<Long> zzx = zza("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, zzbh.zza);
    public static zzem<Long> zzy = zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, zzbk.zza);
    public static zzem<Long> zzz = zza("measurement.upload.initial_upload_delay_time", 15000L, 15000L, zzbj.zza);
    public static zzem<Long> zzaa = zza("measurement.upload.retry_time", 1800000L, 1800000L, zzbm.zza);
    public static zzem<Integer> zzab = zza("measurement.upload.retry_count", 6, 6, zzbl.zza);
    public static zzem<Long> zzac = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, zzbo.zza);
    public static zzem<Integer> zzad = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, zzbn.zza);
    public static zzem<Integer> zzae = zza("measurement.audience.filter_result_max_count", 200, 200, zzbp.zza);
    public static zzem<Integer> zzaf = zza("measurement.upload.max_public_user_properties", 25, 25, null);
    public static zzem<Integer> zzag = zza("measurement.upload.max_event_name_cardinality", 500, 500, null);
    public static zzem<Integer> zzah = zza("measurement.upload.max_public_event_params", 25, 25, null);
    public static zzem<Long> zzai = zza("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, zzbs.zza);
    public static zzem<Boolean> zzaj = zza("measurement.test.boolean_flag", false, false, zzbr.zza);
    public static zzem<String> zzak = zza("measurement.test.string_flag", "---", "---", zzbu.zza);
    public static zzem<Long> zzal = zza("measurement.test.long_flag", -1L, -1L, zzbt.zza);
    public static zzem<Integer> zzam = zza("measurement.test.int_flag", -2, -2, zzbw.zza);

    public static Map<String, String> zza(Context context) {
        com.google.android.gms.internal.measurement.zzcc zzccVarZza = com.google.android.gms.internal.measurement.zzcc.zza(context.getContentResolver(), com.google.android.gms.internal.measurement.zzcr.zza("com.google.android.gms.measurement"));
        return zzccVarZza == null ? Collections.emptyMap() : zzccVarZza.zza();
    }

    private static <V> zzem<V> zza(String str, V v, V v2, zzek<V> zzekVar) {
        zzem<V> zzemVar = new zzem<>(str, v, v2, zzekVar);
        zzcr.add(zzemVar);
        return zzemVar;
    }

    static final /* synthetic */ Long zzcn() {
        if (zzej.zza != null) {
            zzv zzvVar = zzej.zza;
        }
        return Long.valueOf(com.google.android.gms.internal.measurement.zzji.zzc());
    }

    static {
        Double dValueOf = Double.valueOf(-3.0d);
        zzan = zza("measurement.test.double_flag", dValueOf, dValueOf, zzbv.zza);
        zzao = zza("measurement.experiment.max_ids", 50, 50, zzby.zza);
        zzap = zza("measurement.max_bundles_per_iteration", 2, 2, zzbx.zza);
        zzaq = zza("measurement.validation.internal_limits_internal_event_params", false, false, zzca.zza);
        zzar = zza("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", true, true, zzcc.zza);
        zzas = zza("measurement.collection.firebase_global_collection_flag_enabled", true, true, zzcb.zza);
        zzat = zza("measurement.collection.efficient_engagement_reporting_enabled_2", true, true, zzce.zza);
        zzau = zza("measurement.collection.redundant_engagement_removal_enabled", false, false, zzcd.zza);
        zzav = zza("measurement.client.freeride_engagement_fix", true, true, zzcg.zza);
        zzaw = zza("measurement.experiment.enable_experiment_reporting", true, true, zzcf.zza);
        zzax = zza("measurement.collection.log_event_and_bundle_v2", true, true, zzci.zza);
        zzay = zza("measurement.quality.checksum", false, false, null);
        zzaz = zza("measurement.sdk.dynamite.use_dynamite3", true, true, zzch.zza);
        zzba = zza("measurement.sdk.dynamite.allow_remote_dynamite", false, false, zzck.zza);
        zzbb = zza("measurement.sdk.collection.validate_param_names_alphabetical", true, true, zzcj.zza);
        zzbc = zza("measurement.collection.event_safelist", true, true, zzcl.zza);
        zzct = zza("measurement.service.audience.invalidate_config_cache_after_app_unisntall", true, true, zzco.zza);
        zzbd = zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true, true, zzcn.zza);
        zzbe = zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false, false, zzcq.zza);
        zzbf = zza("measurement.audience.refresh_event_count_filters_timestamp", false, false, zzcp.zza);
        zzbg = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false, false, zzcs.zza);
        zzbh = zza("measurement.sdk.collection.retrieve_deeplink_from_bow_2", true, true, zzcr.zza);
        zzbi = zza("measurement.sdk.collection.last_deep_link_referrer2", true, true, zzcu.zza);
        zzbj = zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false, false, zzct.zza);
        zzbk = zza("measurement.sdk.collection.last_gclid_from_referrer2", false, false, zzcw.zza);
        zzbl = zza("measurement.sdk.collection.enable_extend_user_property_size", true, true, zzcy.zza);
        zzbm = zza("measurement.upload.file_lock_state_check", false, false, zzcx.zza);
        zzbn = zza("measurement.sampling.calculate_bundle_timestamp_before_sampling", true, true, zzda.zza);
        zzbo = zza("measurement.ga.ga_app_id", false, false, zzcz.zza);
        zzbp = zza("measurement.lifecycle.app_backgrounded_tracking", true, true, zzdc.zza);
        zzbq = zza("measurement.lifecycle.app_in_background_parameter", false, false, zzdb.zza);
        zzbr = zza("measurement.integration.disable_firebase_instance_id", false, false, zzde.zza);
        zzbs = zza("measurement.lifecycle.app_backgrounded_engagement", false, false, zzdd.zza);
        zzbt = zza("measurement.collection.service.update_with_analytics_fix", false, false, zzdg.zza);
        zzbu = zza("measurement.service.use_appinfo_modified", false, false, zzdf.zza);
        zzbv = zza("measurement.client.firebase_feature_rollout.v1.enable", true, true, zzdh.zza);
        zzbw = zza("measurement.client.sessions.check_on_reset_and_enable2", true, true, zzdk.zza);
        zzbx = zza("measurement.config.string.always_update_disk_on_set", true, true, zzdj.zza);
        zzby = zza("measurement.scheduler.task_thread.cleanup_on_exit", false, false, zzdm.zza);
        zzbz = zza("measurement.upload.file_truncate_fix", false, false, zzdl.zza);
        zzca = zza("measurement.engagement_time_main_thread", true, true, zzdo.zza);
        zzcb = zza("measurement.sdk.referrer.delayed_install_referrer_api", false, false, zzdn.zza);
        zzcc = zza("measurement.sdk.screen.disabling_automatic_reporting", true, true, zzdq.zza);
        zzcd = zza("measurement.sdk.screen.manual_screen_view_logging", true, true, zzdp.zza);
        zzce = zza("measurement.gold.enhanced_ecommerce.format_logs", false, false, zzds.zza);
        zzcf = zza("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", false, false, zzdu.zza);
        zzcg = zza("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", false, false, zzdt.zza);
        zzch = zza("measurement.gold.enhanced_ecommerce.log_nested_complex_events", false, false, zzdw.zza);
        zzci = zza("measurement.gold.enhanced_ecommerce.updated_schema.client", false, false, zzdv.zza);
        zzcj = zza("measurement.gold.enhanced_ecommerce.updated_schema.service", false, false, zzdy.zza);
        zzcu = zza("measurement.collection.synthetic_data_mitigation", false, false, zzdx.zza);
        zzck = zza("measurement.service.configurable_service_limits", false, false, zzea.zza);
        zzcl = zza("measurement.client.configurable_service_limits", false, false, zzdz.zza);
        zzcm = zza("measurement.androidId.delete_feature", true, true, zzec.zza);
        zzcn = zza("measurement.client.global_params.dev", false, false, zzeb.zza);
        zzcv = zza("measurement.service.global_params", false, false, zzed.zza);
        zzco = zza("measurement.client.string_reader", true, true, zzeg.zza);
        zzcp = zza("measurement.sdk.attribution.cache", true, true, zzef.zza);
        zzcq = zza("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, zzei.zza);
    }
}
