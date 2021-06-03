package lt.codeacadamy.shop.api.controller;

import lt.codeacadamy.shop.api.Endpoint;
import lt.codeacadamy.shop.api.dto.CurrencyDto;
import lt.codeacadamy.shop.api.service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrius Baltrunas
 */
@RestController
@RequestMapping(Endpoint.CURRENCY_PATH)
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    public CurrencyDto getCurrencies() {
        return currencyService.getCurrencies();
    }
}
