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

    /**
     * @param latitude 위도
     * @param longitude 경도
     * @return 위도 (lat) , 경도(lng)와 변환된 X(x), Y(y) 좌표가 포함된 map 객체를 반환한다.
     */
    static Map<String, Object> latLngToXY(double latitude, double longitude) {
        double RE = 6371.00877 // 지구 반경(km)
        double GRID = 5.0 // 격자 간격(km)
        double SLAT1 = 30.0 // 투영 위도1(degree)
        double SLAT2 = 60.0 // 투영 위도2(degree)
        double OLON = 126.0 // 기준점 경도(degree)
        double OLAT = 38.0 // 기준점 위도(degree)
        double XO = 43 // 기준점 X좌표(GRID)
        double YO = 136 // 기준점 Y좌표(GRID)

        double degrad = Math.PI / 180.0

        double re = RE / GRID
        double slat1 = SLAT1 * degrad
        double slat2 = SLAT2 * degrad
        double olon = OLON * degrad
        double olat = OLAT * degrad

        double sn = Math.tan(Math.PI * 0.25 + slat2 * 0.5) / Math.tan(Math.PI * 0.25 + slat1 * 0.5)
        sn = Math.log(Math.cos(slat1) / Math.cos(slat2)) / Math.log(sn)

        double sf = Math.tan(Math.PI * 0.25 + slat1 * 0.5)
        sf = Math.pow(sf, sn) * Math.cos(slat1) / sn

        double ro = Math.tan(Math.PI * 0.25 + olat * 0.5)
        ro = re * sf / Math.pow(ro, sn)

        double ra = Math.tan(Math.PI * 0.25 + latitude * degrad * 0.5)
        ra = re * sf / Math.pow(ra, sn)

        double theta = longitude * degrad - olon
        if (theta > Math.PI) {
            theta -= 2.0 * Math.PI
        }
        if (theta < -Math.PI) {
            theta += 2.0 * Math.PI
        }
        theta *= sn

        int x = Math.floor(ra * Math.sin(theta) + XO + 0.5)
        int y = Math.floor(ro - ra * Math.cos(theta) + YO + 0.5)

        return [
                lat: latitude,
                lng: longitude,
                x  : x,
                y  : y
        ]
    }
}
