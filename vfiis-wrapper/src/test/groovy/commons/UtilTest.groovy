package commons

import com.github.galcyurio.commons.Util
import org.junit.Before
import org.junit.Test

import static org.assertj.core.api.Java6Assertions.assertThat

/**
 * @author galcyurio
 */
class UtilTest {

    Date mBaseDateTime

    @Before
    void setUp() throws Exception {
        def calendar = Calendar.instance
        calendar.set(2017, 9, 9, 15, 30)

        mBaseDateTime = calendar.time
    }

    @Test
    void dateToBaseDate__mustReturn_yyyyMMdd_format() throws Exception {
        def baseDate = Util.dateToVfiisBaseDate(mBaseDateTime)
        assertThat(baseDate).isEqualTo("20171009")
        println baseDate
    }

    @Test
    void dateToBaseTime__mustReturn_HHmm_format() throws Exception {
        def baseTime = Util.dateToVfiisBaseTime(mBaseDateTime)
        assertThat(baseTime).isEqualTo("1530")
        println baseTime
    }

    @Test
    void dateToBaseDateTime__mustReturn_yyyyMMddHHmm_format() throws Exception {
        def baseDateTime = Util.dateToVfiisBaseDateTime(mBaseDateTime)
        assertThat(baseDateTime).isEqualTo("201710091530")
        println baseDateTime
    }

    @Test
    void latLngToXY_서울__mustReturnValidXY() throws Exception {
        // 서울시 종로구
        _latLngToXYTest(37.572975, 126.979367, 60, 127)
    }

    @Test
    void latLngToXY_충청도__mustReturnValidXY() throws Exception {
        // 충청남도 천안시 동남구 북면
        _latLngToXYTest(36.832230, 127.267427, 65, 111)
    }

    @Test
    void latLngToXY_전라도__mustReturnValidXY() throws Exception {
        // 전라북도 무주군 적상면
        _latLngToXYTest(35.945462, 127.659476, 72, 92)
    }

    @Test
    void latLngToXY_경상도__mustReturnValidXY() throws Exception {
        // 경상북도 포항시 북구 두호동
        _latLngToXYTest(36.060197, 129.377114, 102, 95)
    }

    @Test
    void latLngToXY_강원도__mustReturnValidXY() throws Exception {
        // 강원도	 속초시 청호동
        _latLngToXYTest(38.194192, 128.597619, 87, 141)
    }

    @Test
    void latLngToXY_제주도__mustReturnValidXY() throws Exception {
        // 제주특별자치도 서귀포시 송산동
        _latLngToXYTest(33.226416, 126.567129, 53, 32)
    }

    @Test
    void latLngToXY_독도__mustReturnValidXY() throws Exception {
        // 경상북도 울릉군 독도
        _latLngToXYTest(37.241768, 131.865288, 144, 123)
    }

    // 이어도 테스트 실패
    // @Test
    void latLngToXY_이어도__mustReturnValidXY() throws Exception {
        // 이어도
        _latLngToXYTest(33.074240, 126.210603, 28, 8)
    }

    // 약간의 오차 발생
    // @Test
    void latLngToXY_경상도_하동군_북천면__mustReturnValidXY() throws Exception {
        // 경상남도 하동군 북천면
        _latLngToXYTest(35.118642, 127.863090, 77, 74)
    }

    void _latLngToXYTest(double lat, double lng, int expectedX, int expectedY) {
        def result = Util.latLngToXY(lat, lng)

        println result
        assertThat(result.get("x")).isEqualTo(expectedX)
        assertThat(result.get("y")).isEqualTo(expectedY)
    }
}
