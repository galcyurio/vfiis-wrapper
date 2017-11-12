package com.github.galcyurio.core

import com.github.galcyurio.commons.Util
import com.github.galcyurio.config.Configuration
import com.github.galcyurio.config.Vfiis
import com.github.galcyurio.request.ForecastRequest
import com.github.galcyurio.request.ForecastVersionCheckRequest
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
/**
 * 동네 예보 조회 서비스의 REST API 를 편리하게 호출하도록 도와주는 wrapper class 이다.
 *
 * @author galcyurio
 */
@SuppressWarnings("GroovyUnusedDeclaration")
class RawVfiisClient {
    private static RawVfiisClient instance

    private Configuration mConfiguration
    private RawVfiisService mVfiisService
    private Retrofit mRetrofit

    /**
     * RawVfiisClient 객체를 초기화한다.
     */
    static void initialize(Configuration configuration) {
        instance = new RawVfiisClient(configuration)
    }

    static RawVfiisClient getInstance() {
        if (instance == null) {
            throw new ExceptionInInitializerError("must initialize first before call getInstance()")
        }
        return instance
    }

    private RawVfiisClient(Configuration configuration) {
        mConfiguration = configuration

        mRetrofit = new Retrofit.Builder()
                .baseUrl(Vfiis.BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
        mVfiisService = mRetrofit.create(RawVfiisService)
    }

    /**
     * 검색 조건에 따라 초단기 실황 정보를 제공한다.
     */
    Call<Map<String,Object>> fetchForecastGrib(ForecastRequest request) {
        return mVfiisService.fetchForecastGrib(
                mConfiguration.serviceKey,
                Util.dateToVfiisBaseDate(request.baseDateTime),
                Util.dateToVfiisBaseTime(request.baseDateTime),
                request.nx, request.ny,
                request.numOfRows, request.pageNo
        )
    }

    /**
     * 검색 조건에 따라 동네 예보 정보를 제공한다.
     */
    Call<Map<String,Object>> fetchForecastSpaceData(ForecastRequest request) {
        return mVfiisService.fetchForecastSpaceData(
                mConfiguration.serviceKey,
                Util.dateToVfiisBaseDate(request.baseDateTime), Util.dateToVfiisBaseTime(request.baseDateTime),
                request.nx, request.ny,
                request.numOfRows, request.pageNo
        )
    }

    /**
     * 검색 조건에 따라 단기 예보 정보를 제공한다.
     */
    Call<Map<String,Object>> fetchForecastTimeData(ForecastRequest request) {
        return mVfiisService.fetchForecastTimeData(
                mConfiguration.serviceKey,
                Util.dateToVfiisBaseDate(request.baseDateTime), Util.dateToVfiisBaseTime(request.baseDateTime),
                request.nx, request.ny,
                request.numOfRows, request.pageNo
        )
    }

    /**
     * 검색 조건에 따라 실황 정보를 조회한다.
     */
    Call<Map<String,Object>> fetchForecastVersionCheck(ForecastVersionCheckRequest request) {
        return mVfiisService.fetchForecastVersionCheck(
                mConfiguration.serviceKey,
                request.operation.value,
                Util.dateToVfiisBaseDateTime(request.baseDateTime)
        )
    }


}
