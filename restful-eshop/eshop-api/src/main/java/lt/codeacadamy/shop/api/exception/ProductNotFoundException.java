package lt.codeacadamy.shop.api.exception;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends RuntimeException {

    private final String productId;
    private final String message;

    public ProductNotFoundException(String productId) {
        this.productId = productId;
        message = String.format("Tokio produkto %s nera", productId);
    }
}
