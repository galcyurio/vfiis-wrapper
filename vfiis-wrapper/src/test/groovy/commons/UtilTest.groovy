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
}
