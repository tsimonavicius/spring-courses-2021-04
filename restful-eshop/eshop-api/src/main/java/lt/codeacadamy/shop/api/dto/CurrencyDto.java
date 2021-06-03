package lt.codeacadamy.shop.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Map;

/**
 * @author Andrius Baltrunas
 */
@Setter
@Getter
public class CurrencyDto {
    private Timestamp timestamp;
    private String base;
    private String date;
    private Map<String, Double> rates;
}
