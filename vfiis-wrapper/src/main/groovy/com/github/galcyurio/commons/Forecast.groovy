package com.github.galcyurio.commons
/**
 * 각종 Enum 타입을 모아놓은 객체이다.
 * @author galcyurio
 */
class Forecast {

    /**
     * 데이터의 카테고리를 모아놓은 enum 이다.
     */
    enum Category {
        /**
         * 강수확률 (%)
         */
        POP,

        /**
         * 강수형태 (코드값)
         */
        PTY,

        /**
         * 6 시간 강수량 (범주, mm)
         */
        R06,

        /**
         * 습도 (%)
         */
        REH,

        /**
         * 6 시간 신적설 (범주, cm)
         */
        S06,

        /**
         * 하늘상태 (코드값)
         */
        SKY,

        /**
         * 3 시간 기온 (℃)
         */
        T3H,

        /**
         * 아침 최저기온 (℃)
         */
        TMN,

        /**
         * 낮 최고기온 (℃)
         */
        TMX,

        /**
         * 동서 바람 성분 (m/s)
         */
        UUU,

        /**
         * 남북 바람 성분 (m/s)
         */
        VVV,

        /**
         * 파고 (M)
         */
        WAV,

        /**
         * 풍향 (m/s)
         */
        VEC,

        /**
         * 풍속 (1)
         */
        WSD,

        /**
         * 기온 (℃)
         */
        T1H,

        /**
         * 1 시간 강수량 (mm)
         */
        RN1, //  -1 mm 8

        /**
         * 낙뢰 (코드값)
         */
        LGT
    }

    enum Operation {
        /**
         * 동네 예보 실황
         */
        GRIB("ODAM"),

        /**
         * 동네 예보 초단기
         */
        TIME_DATA("VSRT"),

        /**
         * 동네 예보 단기
         */
        SPACE_DATA("SHRT")

        String value

        Operation(String value) { this.value = value }

        String value() { return value }
    }

    // ~ 기상 코드값 ===================================================================

    /**
     * 하늘 상태
     */
    enum SKY {
        CLEAR(1), PARTLY_CLOUDY(2), MOSTLY_CLOUDY(3), CLOUDY(4)

        int code

        int code() { return code }

        SKY(int code) { this.code = code }
    }

    /**
     * 강수 형태
     */
    enum PTY {
        CLEAR(0), RAIN(1), RAIN_SNOW(2), SNOW(3)

        int code

        int code() { return code }

        PTY(int code) { this.code = code }
    }

    /**
     * 초단기 예보 낙뢰 코드
     */
    enum LGT {
        CLEAR(0), LOW(1), MIDDLE(2), HIGH(3)

        int code

        int code() { return code }

        LGT(int code) { this.code = code }
    }

    /**
     * 강수량(RN1, R06)
     */
    enum Rain {
        LESS_THAN_0_MM(0),
        BETWEEN_1_MM(1),
        BETWEEN_1_4_MM(5),
        BETWEEN_5_9_MM(10),
        BETWEEN_10_19_MM(20),
        BETWEEN_20_39_MM(40),
        BETWEEN_40_69_MM(70),
        GREATER_THAN_70_MM(100)

        int code

        int code() { return code }

        Rain(int code) { this.code = code }
    }

    /**
     * 적설량 (S06)
     */
    enum Snow {

    }

    /**
     * 동서 바람 성분
     */
    enum UUU {
        EAST("+"), WEST("-")

        String value

        String value() { return value }

        UUU(String value) { this.value = value }
    }

    /**
     * 남북 바람 성분
     */
    enum VVV {
        NORTH("+"), SOUTH("-")

        String value

        String value() { return value }

        VVV(String value) { this.value = value }
    }

}
