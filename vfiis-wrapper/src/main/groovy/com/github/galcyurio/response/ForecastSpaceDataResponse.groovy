package com.github.galcyurio.response

import com.github.galcyurio.commons.Forecast
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.builder.Builder
/**
 * 호출 메시지의 검색 조건에 따라 단기예보 정보를 제공한다.
 *
 * @author galcyurio
 */
@EqualsAndHashCode
@ToString(includeSuper = true)
@Builder
class ForecastSpaceDataResponse extends ForecastResponse {

    /**
     * 강수확률
     * <p>unit : %</p>
     * <p>ex) -1</p>
     */
    Integer POP

    /**
     * 6시간 강수량
     */
    Forecast.Rain RO6

    /**
     * 6시간 신적설
     */
    Forecast.Snow SO6

    /**
     * 3시간 기온
     * <p>unit : ℃</p>
     * <p>ex) -50</p>
     */
    Integer T3H

    /**
     * 아침 최저 기온
     * <p>unit : ℃</p>
     * <p>ex) -50</p>
     */
    Integer TMN

    /**
     * 낮 최고 기온
     * <p>unit : ℃</p>
     * <p>ex) -50</p>
     */
    Integer TMX

    /**
     * 파고
     * <p>unit : M</p>
     * <p>ex) -1</p>
     */
    Integer WAV

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
