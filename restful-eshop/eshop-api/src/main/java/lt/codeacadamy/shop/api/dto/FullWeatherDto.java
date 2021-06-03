package lt.codeacadamy.shop.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Andrius Baltrunas
 */
@Setter
@Getter
public class FullWeatherDto {
    private List<WeatherDto> weather;
    private WeatherMainDto main;
    private int visibility;
    private WeatherWindDto wind;
    private WeatherSysDto sys;
    private int timezone;
    private String name;
}
