package lt.codeacadamy.shop.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Andrius Baltrunas
 */
@Setter
@Getter
public class WeatherMainDto {
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private double pressure;
    private int humidity;
}
