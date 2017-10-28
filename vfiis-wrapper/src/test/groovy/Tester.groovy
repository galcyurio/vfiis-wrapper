import com.github.galcyurio.config.Vfiis
import com.github.galcyurio.core.VfiisService
import com.github.galcyurio.response.ForecastGribResponse
import okhttp3.HttpUrl
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 * @author galcyurio
 */

class Tester {

    @Before
    void setUp() throws Exception {
    }

    @Test
    void request() throws Exception {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(Vfiis.SCHEME).host(Vfiis.HOST)
                .build()

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl(httpUrl)
                .build()
        VfiisService vfiisService = retrofit.create(VfiisService)

        String serviceKey = URLDecoder.decode("Xh0KCUo1p%2FpDbAPCb94AWn34HZebw2wp0g2kU0BaS3a2POCRTPwgufuhyKEhSH7nKr7LpDQyOu1GxeAhX7iH4g%3D%3D", "utf-8")

        def response = vfiisService.getForecastGribResponse(
                serviceKey,
                "20171028",
                "0600",
                60, 127,
                null, null
        ).execute()

        println response.body()
    }
}
