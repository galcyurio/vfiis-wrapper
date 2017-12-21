package com.github.galcyurio.response
/**
 * @author galcyurio
 */
abstract class ForecastResponse {
    /**
     * 결과 코드
     */
    String resultCode

    /**
     * 결과 메세지
     */
    String resultMsg

    /**
     * 한 페이지 결과 수
     */
    Integer numOfRows

    /**
     * 페이지 번호
     */
    Integer pageNo

    /**
     * 전체 결과 수
     */
    Integer totalCount

    /**
     * 발표 일자, 발표 시각
     */
    Date baseDateTime

    /**
     * x 좌표
     */
    Integer nx

    /**
     * y 좌표
     */
    Integer ny
}
