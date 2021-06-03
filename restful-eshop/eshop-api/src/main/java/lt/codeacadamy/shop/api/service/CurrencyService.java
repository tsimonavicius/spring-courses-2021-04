package lt.codeacadamy.shop.api.service;

import lt.codeacadamy.shop.api.dto.CurrencyDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Andrius Baltrunas
 */
@Service
public class CurrencyService {

    private static final String API = "http://api.exchangeratesapi.io/v1/latest?access_key=51ff4403e7d160e67e273658508ef1e6";
    private final RestTemplate restTemplate;

    public CurrencyService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public CurrencyDto getCurrencies() {
        return restTemplate.getForObject(API, CurrencyDto.class);
    }
}
