package core;

import com.github.galcyurio.config.Vfiis;
import com.github.galcyurio.core.RawVfiisService;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import mock.MockRawVfiisService;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;

/**
 * @author galcyurio
 */
public class RawVfiisClientMockUnitTest {

    private static MockRawVfiisService sMockRawVfiisService;

    @BeforeClass
    public static void beforeClass() throws Exception {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Vfiis.BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        BehaviorDelegate<RawVfiisService> delegate = new MockRetrofit.Builder(retrofit)
                .build()
                .create(RawVfiisService.class);

        sMockRawVfiisService = new MockRawVfiisService(delegate);
    }

    @Test
    public void fetchForecastGribTest() throws Exception {
        Map<String, Object> body = sMockRawVfiisService.fetchForecastGrib(
                "",
                "", "",
                0, 0,
                0, 0)
                .execute().body();
        System.out.println(body);
    }

    @Test
    public void fetchForecastSpaceData() throws Exception {
        Map<String, Object> body = sMockRawVfiisService.fetchForecastSpaceData(
                "",
                "", "",
                0, 0,
                0, 0)
                .execute().body();
        System.out.println(body);
    }

    @Test
    public void fetchForecastTimeData() throws Exception {
        Map<String, Object> body = sMockRawVfiisService.fetchForecastTimeData(
                "",
                "", "",
                0, 0,
                0, 0)
                .execute().body();
        System.out.println(body);
    }

    @Test
    public void fetchForecastVersionCheck() throws Exception {
        Map<String, Object> body = sMockRawVfiisService.fetchForecastVersionCheck(
                "", "", "")
                .execute().body();
        System.out.println(body);
    }

}
