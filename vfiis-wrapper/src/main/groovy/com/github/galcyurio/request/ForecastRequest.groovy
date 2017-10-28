package com.github.galcyurio.request

import groovy.transform.Canonical
import groovy.transform.builder.Builder

import javax.annotation.Nonnull
import javax.annotation.Nullable

/**
 * 초단기 실황 정보, 초단기 예보, 동네 예보 REST API 호출에 필요한 정보
 *
 * @author galcyurio
 */
@Canonical
@Builder
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
}
