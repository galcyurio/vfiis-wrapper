package core;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.galcyurio.commons.Forecast;
import com.github.galcyurio.config.Configuration;
import com.github.galcyurio.core.RawVfiisClient;
import com.github.galcyurio.request.ForecastRequest;
import com.github.galcyurio.request.ForecastVersionCheckRequest;

import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import retrofit2.Call;

/**
 * @author galcyurio
 */
public class RawVfiisClientIntegrationTest {
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
        JsonNode body = RawVfiisClient.getInstance().fetchForecastGrib(request).execute().body();
        System.out.println(body);
    }

    @Test
    public void fetchForecastSpaceData() throws Exception {
        ForecastRequest request = new ForecastRequest(baseDateTime.toDate(), nx, ny);
        JsonNode body = RawVfiisClient.getInstance().fetchForecastSpaceData(request).execute().body();
        System.out.println(body);
    }

    @Test
    public void fetchForecastTimeData() throws Exception {
        ForecastRequest request = new ForecastRequest(baseDateTime.toDate(), nx, ny);
        JsonNode body = RawVfiisClient.getInstance().fetchForecastTimeData(request).execute().body();
        System.out.println(body);
    }

    @Test
    public void fetchForecastVersionCheck() throws Exception {
        ForecastVersionCheckRequest request = new ForecastVersionCheckRequest(
                baseDateTime.minusHours(5).toDate(), Forecast.Operation.GRIB);
        Call<JsonNode> call = RawVfiisClient.getInstance().fetchForecastVersionCheck(request);
        System.out.println(call.request().toString());

        JsonNode body = call.execute().body();
        System.out.println(body);
    }
}
