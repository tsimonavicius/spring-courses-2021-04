package lt.codeacademy.eshop.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CartItem {

    private Product product;
    private Integer quantity;

    public CartItem(Product product) {
        this.quantity = 1;
        this.product = product;
    }

    public BigDecimal price() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public void increment() {
        quantity++;
    }
}
