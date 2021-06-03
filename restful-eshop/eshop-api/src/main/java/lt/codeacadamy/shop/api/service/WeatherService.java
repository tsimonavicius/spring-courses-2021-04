package lt.codeacadamy.shop.api.service;

/**
 * @author Andrius Baltrunas
 */

import lt.codeacadamy.shop.api.dto.FullWeatherDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String API = "http://api.openweathermap.org/data/2.5/weather?q=kaunas,lt&appid=658ffcb3d43159447f37482eb271c507";
    private final RestTemplate restTemplate;

    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public FullWeatherDto getWeather() {
        return restTemplate.getForObject(API, FullWeatherDto.class);
    }
}

