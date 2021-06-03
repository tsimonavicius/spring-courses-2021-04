package lt.codeacadamy.shop.api.controller;

import lt.codeacadamy.shop.api.Endpoint;
import lt.codeacadamy.shop.api.dto.FullWeatherDto;
import lt.codeacadamy.shop.api.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrius Baltrunas
 */
@RestController
@RequestMapping(Endpoint.WEATHER_PATH)
public class WeatherController {
    private final WeatherService weatherService;
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    @GetMapping
    public FullWeatherDto getWeather(){
        return  weatherService.getWeather();
    }
}
