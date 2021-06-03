package lt.codeacadamy.shop.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Andrius Baltrunas
 */
@Setter
@Getter
public class WeatherDto {
    private String main;
    private String description;
}
