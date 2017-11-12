package com.github.galcyurio.request

import groovy.transform.Canonical
import groovy.transform.TupleConstructor

import javax.annotation.Nonnull
import javax.annotation.Nullable
/**
 * 초단기 실황 정보, 초단기 예보, 동네 예보 REST API 호출에 필요한 정보
 *
 * @author galcyurio
 */
@Canonical
@TupleConstructor
class ForecastRequest {
    /**
     * 발표일자 및 발표시각
     */
    @Nonnull Date baseDateTime

    /**
     * 예보지점 X 좌표
     */
    @Nonnull Integer nx

    /**
     * 예보지점 Y 좌표
     */
    @Nonnull Integer ny

    /**
     * 한 페이지 결과 수
     */
    @Nullable Integer numOfRows

    /**
     * 페이지 번호
     */
    @Nullable Integer pageNo

    /**
     * @param baseDateTime must not be null
     * @param nx must not be null
     * @param ny must not be null
     */
    ForecastRequest(@Nonnull Date baseDateTime, @Nonnull Integer nx, @Nonnull Integer ny) {
        this(baseDateTime, nx, ny, null, null)
    }

    /**
     * @param baseDateTime must not be null
     * @param nx must not be null
     * @param ny must not be null
     * @param numOfRows can be null
     * @param pageNo can be null
     */
    ForecastRequest(@Nonnull Date baseDateTime, @Nonnull Integer nx, @Nonnull Integer ny, @Nullable Integer numOfRows, @Nullable Integer pageNo) {
        this.baseDateTime = baseDateTime
        this.nx = nx
        this.ny = ny
        this.numOfRows = numOfRows
        this.pageNo = pageNo
    }
}
