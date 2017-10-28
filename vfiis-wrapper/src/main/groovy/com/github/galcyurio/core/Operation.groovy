package com.github.galcyurio.core

/**
 * 동네 예보 정보 조회 서비스 오퍼레이션(최근 24시간 자료)
 *
 * @author galcyurio
 */
enum Operation {

    /**
     * 실황정보를 조회하기 위해 발표일자, 발표시각, 예보지점 X 좌표,
     * 예보지점 Y 좌표의 조회 조건으로 자료구분코드, 실황값, 발표일자, 발표시각,
     * 예보지점 X 좌표, 예보지점 Y 좌표의 정보를 조회하는 기능
     */
    FORECAST_GRIB,

    /**
     * 동네예보 정보를 조회하기 위해 발표일자, 발표시각, 예보지점 X 좌표,
     * 예보지점 Y 좌표의 조회 조건으로 발표일자, 발표시각, 자료구분문자, 예보
     * 값, 예보일자, 예보시각, 예보지점 X 좌표, 예보지점 Y 좌표의 정보를
     * 조회하는 기능
     */
    FORECAST_SPACE_DATA,

    /**
     * 초단기예보정보를 조회하기 위해 발표일자, 발표시각, 예보지점 X 좌표,
     * 예보지점 Y 좌표의 조회 조건으로 자료구분코드, 예보값, 발표일자,
     * 발표시각, 예보지점 X 좌표, 예보지점 Y 좌표의 정보를 조회하는 기능
     */
    FORECAST_TIME_DATA,

    /**
     * 동네예보 정보를 조회하기 위해 발표일자, 발표시각, 예보지점 X 좌표,
     * 예보지점 Y 좌표의 조회 조건으로 발표일자, 발표시각, 자료구분문자, 예보
     * 값, 예보일자, 예보시각, 예보지점 X 좌표, 예보지점 Y 좌표의 정보를
     * 조회하는 기능
     */
    FORECAST_VERSION_CHECK
}