package com.github.galcyurio.core

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

import javax.annotation.Nonnull
import javax.annotation.Nullable
/**
 * @author galcyurio
 */
interface VfiisService {

    /**
     * 초단기 실황 정보를 조회한다.
     */
    @GET("service/SecndSrtpdFrcstInfoService2/ForecastGrib?_type=json")
    Call<Object> fetchForecastGrib(
            @Nonnull @Query("serviceKey") String serviceKey,
            @Nonnull @Query("base_date") String baseDate,
            @Nonnull @Query("base_time") String baseTime,
            @Nonnull @Query("nx") Integer nx,
            @Nonnull @Query("ny") Integer ny,
            @Nullable @Query("numOfRows") Integer numOfRows,
            @Nullable @Query("pageNo") Integer pageNo
    )

    /**
     * 동네 예보를 조회한다.
     */
    @GET("service/SecndSrtpdFrcstInfoService2/ForecastTimeData?_type=json")
    Call<Object> fetchForecastSpaceData(
            @Nonnull @Query("serviceKey") String serviceKey,
            @Nonnull @Query("base_date") String baseDate,
            @Nonnull @Query("base_time") String baseTime,
            @Nonnull @Query("nx") Integer nx,
            @Nonnull @Query("ny") Integer ny,
            @Nullable @Query("numOfRows") Integer numOfRows,
            @Nullable @Query("pageNo") Integer pageNo
    )

    /**
     * 초단기 예보를 조회한다.
     */
    @GET("service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?_type=json")
    Call<Object> fetchForecastTimeData(
            @Nonnull @Query("serviceKey") String serviceKey,
            @Nonnull @Query("base_date") String baseDate,
            @Nonnull @Query("base_time") String baseTime,
            @Nonnull @Query("nx") Integer nx,
            @Nonnull @Query("ny") Integer ny,
            @Nullable @Query("numOfRows") Integer numOfRows,
            @Nullable @Query("pageNo") Integer pageNo
    )

    /**
     * 예보 버전 정보를 조회한다.
     */
    @GET("service/SecndSrtpdFrcstInfoService2/ForecastVersionCheck?_type=json")
    Call<Object> fetchForecastVersionCheck(
            @Nonnull @Query("serviceKey") String serviceKey,
            @Nonnull @Query("ftype") String ftype,
            @Nonnull @Query("basedatetime") String baseDateTime
    )
}
