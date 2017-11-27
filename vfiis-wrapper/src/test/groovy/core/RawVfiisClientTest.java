package core;

import com.github.galcyurio.commons.Forecast;
import com.github.galcyurio.config.Configuration;
import com.github.galcyurio.core.RawVfiisClient;
import com.github.galcyurio.request.ForecastRequest;
import com.github.galcyurio.request.ForecastVersionCheckRequest;

import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import retrofit2.Call;

/**
 * @author galcyurio
 */
public class RawVfiisClientTest {
    LocalDateTime baseDateTime;
    Integer nx = 60, ny = 127;

    @BeforeClass
    public static void setUpStatic() throws Exception {
        RawVfiisClient.initialize(new Configuration("SERVICE_KEY"));
    }

    @Before
    public void setUp() throws Exception {
        baseDateTime = new LocalDateTime();
    }

    @Test
    public void fetchForecastGrib() throws Exception {
        ForecastRequest request = new ForecastRequest(baseDateTime.toDate(), nx, ny);
        Map<String, Object> body = RawVfiisClient.getInstance().fetchForecastGrib(request).execute().body();
        System.out.println(body);
    }

    @Test
    public void fetchForecastSpaceData() throws Exception {
        ForecastRequest request = new ForecastRequest(baseDateTime.toDate(), nx, ny);
        Map<String, Object> body = RawVfiisClient.getInstance().fetchForecastSpaceData(request).execute().body();
        System.out.println(body);
    }

    @Test
    public void fetchForecastTimeData() throws Exception {
        ForecastRequest request = new ForecastRequest(baseDateTime.toDate(), nx, ny);
        Map<String, Object> body = RawVfiisClient.getInstance().fetchForecastTimeData(request).execute().body();
        System.out.println(body);
    }

    @Test
    public void fetchForecastVersionCheckt() throws Exception {
        ForecastVersionCheckRequest request = new ForecastVersionCheckRequest(
                baseDateTime.minusHours(5).toDate(), Forecast.Operation.GRIB);
        Call<Map<String, Object>> call = RawVfiisClient.getInstance().fetchForecastVersionCheck(request);
        System.out.println(call.request().toString());

        Map<String, Object> body = call.execute().body();
        System.out.println(body);
    }
}
