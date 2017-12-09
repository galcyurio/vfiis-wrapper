package mock

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.galcyurio.core.RawVfiisService
import okhttp3.MediaType
import retrofit2.Call
import retrofit2.http.Query
import retrofit2.mock.BehaviorDelegate

import javax.annotation.Nonnull
import javax.annotation.Nullable
/**
 * @author galcyurio
 */
class MockRawVfiisService implements RawVfiisService {

    private final BehaviorDelegate<RawVfiisService> mDelegate
    private ObjectMapper mObjectMapper

    private File mockDirectory
    private MediaType mJsonMediaType = MediaType.parse("application/json")

    MockRawVfiisService(BehaviorDelegate<RawVfiisService> delegate) {
        mDelegate = delegate
        mockDirectory = new File(getClass().getClassLoader().getResource("mockResponse").toURI())

        mObjectMapper = new ObjectMapper()
    }

    @Override
    Call<Map<String, Object>> fetchForecastGrib(
            @Nonnull @Query("serviceKey") String serviceKey,
            @Nonnull @Query("base_date") String baseDate,
            @Nonnull @Query("base_time") String baseTime,
            @Nonnull @Query("nx") Integer nx, @Nonnull @Query("ny") Integer ny,
            @Nullable @Query("numOfRows") Integer numOfRows, @Nullable @Query("pageNo") Integer pageNo) {
        String content = new File(mockDirectory, "forecastGribResponse.json").getText()
        Map<String, Object> response = mObjectMapper.readValue(content, Map)
        return mDelegate.returningResponse(response).fetchForecastGrib(
                serviceKey, baseDate, baseTime, nx, ny, numOfRows, pageNo)
    }

    @Override
    Call<Map<String, Object>> fetchForecastSpaceData(
            @Nonnull @Query("serviceKey") String serviceKey,
            @Nonnull @Query("base_date") String baseDate,
            @Nonnull @Query("base_time") String baseTime,
            @Nonnull @Query("nx") Integer nx, @Nonnull @Query("ny") Integer ny,
            @Nullable @Query("numOfRows") Integer numOfRows, @Nullable @Query("pageNo") Integer pageNo) {
        String content = new File(mockDirectory, "forecastSpaceDataResponse.json").getText()
        Map<String, Object> response = mObjectMapper.readValue(content, Map)
        return mDelegate.returningResponse(response).fetchForecastSpaceData(
                serviceKey, baseDate, baseTime, nx, ny, numOfRows, pageNo)
    }

    @Override
    Call<Map<String, Object>> fetchForecastTimeData(
            @Nonnull @Query("serviceKey") String serviceKey,
            @Nonnull @Query("base_date") String baseDate,
            @Nonnull @Query("base_time") String baseTime,
            @Nonnull @Query("nx") Integer nx, @Nonnull @Query("ny") Integer ny,
            @Nullable @Query("numOfRows") Integer numOfRows, @Nullable @Query("pageNo") Integer pageNo) {
        String content = new File(mockDirectory, "forecastTimeDataResponse.json").getText()
        Map<String, Object> response = mObjectMapper.readValue(content, Map)
        return mDelegate.returningResponse(response).fetchForecastTimeData(
                serviceKey, baseDate, baseTime, nx, ny, numOfRows, pageNo)
    }

    @Override
    Call<Map<String, Object>> fetchForecastVersionCheck(
            @Nonnull @Query("serviceKey") String serviceKey,
            @Nonnull @Query("ftype") String ftype,
            @Nonnull @Query("basedatetime") String baseDateTime) {
        String content = new File(mockDirectory, "forecastVersionCheckResponse.json").getText()
        Map<String, Object> response = mObjectMapper.readValue(content, Map)
        return mDelegate.returningResponse(response).fetchForecastVersionCheck(
                serviceKey, ftype, baseDateTime)
    }
}
