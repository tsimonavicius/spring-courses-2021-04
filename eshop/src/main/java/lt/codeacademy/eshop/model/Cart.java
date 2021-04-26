package lt.codeacademy.eshop.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart {

    private final List<CartItem> cartItems = new ArrayList<>();

    public void add(Product product) {

        cartItems.add(new CartItem(product));
    }
}
