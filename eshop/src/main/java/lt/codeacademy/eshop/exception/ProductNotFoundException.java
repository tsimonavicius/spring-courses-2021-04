package lt.codeacademy.eshop.exception;

import lombok.Getter;

//@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class ProductNotFoundException extends RuntimeException {

    private final String productId;

    public ProductNotFoundException(String productId) {
        this.productId = productId;
    }
}
