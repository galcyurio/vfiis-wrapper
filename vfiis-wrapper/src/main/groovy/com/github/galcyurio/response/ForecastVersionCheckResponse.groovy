package com.github.galcyurio.response

import com.github.galcyurio.commons.Forecast

/**
 * 호출 메시지의 검색 조건에 따라 예보 버전 정보를 제공한다.
 *
 * @author galcyurio
 */
class ForecastVersionCheckResponse extends ForecastResponse {
    /**
     * 파일 버전 생성 일자 및 시간
     */
    Date versionDateTime

    /**
     * 파일 구분
     */
    Forecast.Operation operation
}
