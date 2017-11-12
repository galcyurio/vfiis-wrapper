package com.github.galcyurio.commons
/**
 * @author galcyurio
 */
class Forecast {

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

    // TODO: 기상 코드값 정리

    /**
     * 하늘 상태
     */
    enum SKY {

    }

    /**
     * 강수 형태
     */
    enum PTY {

    }

    /**
     * 낙뢰
     */
    enum LGT {

    }
}
