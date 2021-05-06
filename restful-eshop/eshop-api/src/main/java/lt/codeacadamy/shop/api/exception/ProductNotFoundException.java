package lt.codeacadamy.shop.api.exception;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends RuntimeException {

    private final String productId;

    public ProductNotFoundException(String productId) {
        this.productId = productId;
    }
}
