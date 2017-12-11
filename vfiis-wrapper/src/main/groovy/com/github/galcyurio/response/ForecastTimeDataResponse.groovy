package com.github.galcyurio.response

import groovy.transform.Canonical
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
     * <p>unit : mm</p>
     * <p>ex) -1</p>
     */
    Integer RN1

    /**
     * 낙뢰 코드값
     * <p>unit : 코드값</p>
     * <p>ex) -1</p>
     */
    Integer LGT

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
