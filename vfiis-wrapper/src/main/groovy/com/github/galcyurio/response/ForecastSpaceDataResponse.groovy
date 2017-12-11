package com.github.galcyurio.response

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
     * <p>unit : 범주(1 mm)</p>
     * <p>ex) -1</p>
     */
    Integer RO6

    /**
     * 6시간 신적설
     * <p>unit : 범주(1 cm)</p>
     * <p>ex) -1</p>
     */
    Integer SO6

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
     * 강수형태 코드값
     * <p>unit : 코드값</p>
     * <p>ex) -1</p>
     */
    Integer PTY

    /**
     * 습도
     * <p>unit : %</p>
     * <p>ex) -1</p>
     */
    Integer REH

    /**
     * 동서바람성분
     * <p>unit : m/s</p>
     * <p>ex) -100</p>
     */
    Integer UUU

    /**
     * 남북바람성분
     * <p>unit : m/s</p>
     * <p>ex) -100</p>
     */
    Integer VVV

    /**
     * 하늘상태 코드값
     * <p>unit : 코드값</p>
     * <p>ex) -1</p>
     */
    Integer SKY

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
