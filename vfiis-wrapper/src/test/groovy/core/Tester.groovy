package core

import com.github.galcyurio.config.Configuration
import com.github.galcyurio.core.RawVfiisClient
import com.github.galcyurio.request.ForecastRequest
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Response
/**
 * @author galcyurio
 */
class Tester {

    public final static String serviceKey = "Xh0KCUo1p%2FpDbAPCb94AWn34HZebw2wp0g2kU0BaS3a2POCRTPwgufuhyKEhSH7nKr7LpDQyOu1GxeAhX7iH4g%3D%3D"
    public final static String baseDate = "20171029"
    public final static String baseTime = "0600"
    public final static Integer nx = 60
    public final static Integer ny = 127

    @Before
    void setUp() throws Exception {
        RawVfiisClient.initialize(new Configuration(serviceKey))
    }

    @Test
    void test() throws Exception {
        Calendar calendar = Calendar.instance
        calendar.set(2017, 10, 12, 6, 0)
        ForecastRequest forecastRequest = new ForecastRequest(
                calendar.getTime(), nx, ny)

        Call<Map<String,Object>> call = RawVfiisClient.instance.fetchForecastGrib(forecastRequest)
        Response<Map<String,Object>> response = call.execute()
        println response.toString()
        println response.body()
    }
}
