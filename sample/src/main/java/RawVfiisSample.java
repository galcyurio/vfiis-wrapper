import com.github.galcyurio.config.Configuration;
import com.github.galcyurio.core.RawVfiisClient;
import com.github.galcyurio.request.ForecastRequest;

import java.util.Calendar;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author galcyurio
 */
public class RawVfiisSample {
    public static void main(String[] args) {
        RawVfiisClient.initialize(new Configuration("SERVICE_KEY"));

        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.NOVEMBER, 12, 2, 0, 0);
        RawVfiisClient.getInstance().fetchForecastGrib(new ForecastRequest(calendar.getTime(), 60, 127)).enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if(response.isSuccessful()) {
                    System.out.println(response.body());
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
