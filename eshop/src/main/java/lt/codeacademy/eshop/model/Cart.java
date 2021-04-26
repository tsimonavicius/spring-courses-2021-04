package lt.codeacademy.eshop.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
public class Cart {

    private final List<CartItem> cartItems = new ArrayList<>();

    public void add(Product product) {

        cartItems.add(new CartItem(product));
    }

    public BigDecimal totalPrice() {

        return cartItems.stream()
//                [CartItem1, CartItem2]
                .map(CartItem::price) // cartItem -> cartItem.price()
                // [1, 2, 58, 55.99] --> 8952
                .reduce(BigDecimal.ZERO, BigDecimal::add); // 0 + 1 = 1 + 2 = 3 + 58 = 61 + 55.99 = ... <--
    }

    public Optional<CartItem> getCartItem(UUID productId) {
        return cartItems.stream()
                .filter(ci -> ci.getProduct().getId().equals(productId))
                .findAny();
    }
}
