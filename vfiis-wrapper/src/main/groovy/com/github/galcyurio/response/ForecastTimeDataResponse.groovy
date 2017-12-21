package com.github.galcyurio.response

import com.github.galcyurio.commons.Forecast
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.builder.Builder
/**
 * 호출 메시지의 검색 조건에 따라 초단기예보 정보를 제공한다.
 *
 * @author galcyurio
 */
@EqualsAndHashCode
@ToString(includeSuper = true)
@Builder
class ForecastTimeDataResponse extends ForecastResponse {

    /**
     * <h1>기온</h1>
     * <p>unit : ℃</p>
     * <p>ex) -50</p>
     */
    Integer T1H

    /**
     * 1 시간 강수량
     */
    Forecast.Rain RN1

    /**
     * 낙뢰
     */
    Forecast.LGT LGT

    /**
     * 강수 형태
     */
    Forecast.PTY PTY

    /**
     * 습도
     * <p>unit : %</p>
     * <p>ex) -1</p>
     */
    Integer REH

    /**
     * 동서 바람 성분
     */
    Forecast.UUU UUU

    /**
     * 남북 바람 성분
     * <p>unit : m/s</p>
     * <p>ex) -100</p>
     */
    Forecast.VVV VVV

    /**
     * 하늘 상태
     */
    Forecast.SKY SKY

    /**
     * 풍향
     * <p>unit : 0</p>
     * <p>ex) -1</p>
     */
    Integer VEC

    /**
     * 풍속
     * <p>unit : 1</p>
     * <p>ex) -1</p>
     */
    Integer WSD
}
