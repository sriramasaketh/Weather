import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weatherstack.api.key}")
    private String apiKey;

    @Value("${weatherstack.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getWeather(String city) {
        String url = apiUrl + "?access_key=" + apiKey + "&query=" + city;
        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}
