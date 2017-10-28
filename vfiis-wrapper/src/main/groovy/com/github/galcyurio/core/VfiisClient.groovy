package com.github.galcyurio.core

import com.github.galcyurio.commons.Util
import com.github.galcyurio.commons.VfiisCallbackImpl
import com.github.galcyurio.config.Configuration
import com.github.galcyurio.config.Vfiis
import com.github.galcyurio.request.ForecastRequest
import com.github.galcyurio.request.ForecastVersionCheckRequest
import com.github.galcyurio.response.ForecastGribResponse
import com.github.galcyurio.response.ForecastSpaceDataResponse
import com.github.galcyurio.response.ForecastTimeDataResponse
import com.github.galcyurio.response.ForecastVersionCheckResponse
import okhttp3.HttpUrl
import retrofit2.Callback
import retrofit2.Retrofit
/**
 * 동네 예보 조회 서비스의 REST API 를 편리하게 호출하도록 도와주는 wrapper class 이다.
 *
 * @author galcyurio
 */
@SuppressWarnings("GroovyUnusedDeclaration")
class VfiisClient {
    private static VfiisClient instance

    private Configuration mConfiguration
    private VfiisService mVfiisService
    private Retrofit mRetrofit

    /**
     * VfiisClient 객체를 초기화한다.
     */
    static void initialize(Configuration configuration) {
        instance = new VfiisClient(configuration)
    }

    static VfiisClient getInstance() {
        if (instance == null) {
            throw new ExceptionInInitializerError("must initialize first before call getInstance()")
        }
        return instance
    }

    private VfiisClient(Configuration configuration) {
        mConfiguration = configuration

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(Vfiis.SCHEME).host(Vfiis.HOST)
                .build()

        mRetrofit = new Retrofit.Builder()
                .baseUrl(httpUrl)
                .build()
    }

    /**
     * 검색 조건에 따라 초단기 실황 정보를 제공한다.
     */
    void fetchForecastGrib(ForecastRequest request, Callback<ForecastGribResponse> callback) {
        mVfiisService.fetchForecastGrib(
                mConfiguration.serviceKey,
                Util.dateToVfiisBaseDate(request.baseDateTime),
                Util.dateToVfiisBaseTime(request.baseDateTime),
                request.nx, request.ny,
                request.numOfRows, request.pageNo
        ).enqueue(new VfiisCallbackImpl<>(callback))
    }

    /**
     * 검색 조건에 따라 동네 예보 정보를 제공한다.
     */
    void fetchForecastSpaceData(ForecastRequest request, Callback<ForecastSpaceDataResponse> callback) {
        mVfiisService.fetchForecastSpaceData(
                mConfiguration.serviceKey,
                Util.dateToVfiisBaseDate(request.baseDateTime), Util.dateToVfiisBaseTime(request.baseDateTime),
                request.nx, request.ny,
                request.numOfRows, request.pageNo
        ).enqueue(new VfiisCallbackImpl<>(callback))
    }

    /**
     * 검색 조건에 따라 단기 예보 정보를 제공한다.
     */
    void fetchForecastTimeData(ForecastRequest request, Callback<ForecastTimeDataResponse> callback) {
        mVfiisService.fetchForecastTimeData(
                mConfiguration.serviceKey,
                Util.dateToVfiisBaseDate(request.baseDateTime), Util.dateToVfiisBaseTime(request.baseDateTime),
                request.nx, request.ny,
                request.numOfRows, request.pageNo
        ).enqueue(new VfiisCallbackImpl<>(callback))
    }

    /**
     * 검색 조건에 따라 실황 정보를 조회한다.
     */
    void fetchForecastVersionCheck(ForecastVersionCheckRequest request, Callback<ForecastVersionCheckResponse> callback) {
        mVfiisService.fetchForecastVersionCheck(
                mConfiguration.serviceKey,
                request.operation.value,
                Util.dateToVfiisBaseDateTime(request.baseDateTime)
        ).enqueue(new VfiisCallbackImpl<>(callback))
    }


}
