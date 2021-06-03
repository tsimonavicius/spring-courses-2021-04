package lt.codeacadamy.shop.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Andrius Baltrunas
 */
@Setter
@Getter
public class WeatherWindDto {
    private double seed;
    private int deg;
    private double gust;
}
