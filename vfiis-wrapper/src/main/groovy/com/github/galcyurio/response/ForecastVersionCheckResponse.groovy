package com.github.galcyurio.response

import com.github.galcyurio.commons.Forecast
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.builder.Builder

/**
 * 호출 메시지의 검색 조건에 따라 예보 버전 정보를 제공한다.
 *
 * @author galcyurio
 */
@EqualsAndHashCode
@ToString(includeSuper = true)
@Builder
class ForecastVersionCheckResponse {
    /**
     * 파일 버전 생성 일자 및 시간
     */
    Date versionDateTime

    /**
     * 파일 구분
     */
    Forecast.Operation operation

    /**
     * 결과 코드
     */
    String resultCode

    /**
     * 결과 메세지
     */
    String resultMsg
}
