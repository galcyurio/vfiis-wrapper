package com.github.galcyurio.request

import com.github.galcyurio.commons.Forecast
import groovy.transform.Canonical
import groovy.transform.TupleConstructor

import javax.annotation.Nonnull
import javax.annotation.Nullable
/**
 * 예보 버전 정보
 *
 * @author galcyurio
 */
@Canonical
@TupleConstructor
class ForecastVersionCheckRequest {
    /**
     * 발표일자 및 발표시각
     */
    @Nonnull Date baseDateTime

    /**
     * 파일 구분
     */
    @Nonnull Forecast.Operation operation

    /**
     * 한 페이지 결과 수
     */
    @Nullable Integer numOfRows

    /**
     * 페이지 번호
     */
    @Nullable Integer pageNo

    ForecastVersionCheckRequest(@Nonnull Date baseDateTime, @Nonnull Forecast.Operation operation) {
        this.baseDateTime = baseDateTime
        this.operation = operation
    }
}
