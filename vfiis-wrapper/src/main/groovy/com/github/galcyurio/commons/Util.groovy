package com.github.galcyurio.commons

import java.text.SimpleDateFormat

/**
 * @author galcyurio
 */
class Util {
    static SimpleDateFormat sBaseDateFormat
    static SimpleDateFormat sBaseTimeFormat
    static SimpleDateFormat sBaseDateTimeFormat

    static {
        sBaseDateFormat = new SimpleDateFormat("yyyyMMdd")
        sBaseTimeFormat = new SimpleDateFormat("HHmm")
        sBaseDateTimeFormat = new SimpleDateFormat("yyyyMMddHHmm")
    }

    static String dateToVfiisBaseDate(Date date) {
        return sBaseDateFormat.format(date)
    }

    static String dateToVfiisBaseTime(Date date) {
        return sBaseTimeFormat.format(date)
    }

    static String dateToVfiisBaseDateTime(Date date) {
        return sBaseDateTimeFormat.format(date)
    }

    static Integer latitudeToNx(double latitude) {
        // TODO: 위도를 x 좌표로 변환
        return null
    }

    static Integer longitudeToNy(double longitude) {
        // TODO: 경도를 y 좌표로 변환
        return null
    }
}
