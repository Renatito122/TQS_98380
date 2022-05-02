package tqs.homework.COVIData_project.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tqs.homework.COVIData_project.model.COVIData;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class CacheTest {

    private static final String COUNTRY_ID = "zaf";

    private Cache cache;

    @BeforeEach
    private void init() {
        cache = new Cache(2L);

        assertThat(cache.getNumberOfRequests()).isEqualTo(0);
        assertThat(cache.getNumberOfHits()).isEqualTo(0);
        assertThat(cache.getNumberOfMisses()).isEqualTo(0);
    }

    @Test
    public void whenRequestDoesNotExist_thenIncrementMisses() {
        assertThat(cache.getRequest("non_existent_request")).isNull();

        assertThat(cache.getNumberOfRequests()).isEqualTo(1);
        assertThat(cache.getNumberOfHits()).isEqualTo(0);
        assertThat(cache.getNumberOfMisses()).isEqualTo(1);
    }

    @Test
    public void whenRequestExists_thenReturnsRequestAndIncrementsHits() throws JsonProcessingException {
        COVIData request = loadRequest();
        cache.storeRequest(COUNTRY_ID, request);
        assertThat(cache.getRequest(COUNTRY_ID)).isNotNull();

        assertThat(cache.getNumberOfRequests()).isEqualTo(1);
        assertThat(cache.getNumberOfHits()).isEqualTo(1);
        assertThat(cache.getNumberOfMisses()).isEqualTo(0);
    }

    @Test
    public void whenRequestExpired_thenReturnsRequestAndIncrementsMisses() throws JsonProcessingException, InterruptedException {
        COVIData request = loadRequest();
        cache.storeRequest(COUNTRY_ID, request);

        // expiration time
        TimeUnit.SECONDS.sleep(3);

        assertThat(cache.getRequest(COUNTRY_ID)).isNull();

        assertThat(cache.getNumberOfRequests()).isEqualTo(1);
        assertThat(cache.getNumberOfHits()).isEqualTo(0);
        assertThat(cache.getNumberOfMisses()).isEqualTo(1);
    }

    private COVIData loadRequest() throws JsonProcessingException {
        String sampleJson = "{\"id\":\"zaf\",\"country\":\"South Africa\",\"totalCases\":3603856,\"newCases\":2226,\"totalDeaths\":95022,\"newDeaths\":117,\"totalTests\":0,\"newTests\":0,\"date\":\"2022-01-30\"}";
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(sampleJson, COVIData.class);

        
    }
}
