package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.Cart;
import lt.codeacademy.eshop.model.CartItem;
import lt.codeacademy.eshop.model.Product;
import lt.codeacademy.eshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@SessionAttributes("cart")
public class CartController {

    private final ProductService productService;

    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("cart")
    public Cart createCart() {

        return new Cart();
    }

    @GetMapping("/public/cart")
    public String openCart(@ModelAttribute("cart") Cart cart) {

        return "cart";
    }

    @PostMapping("/public/cart/{productId}")
    public String addToCart(@PathVariable UUID productId, @ModelAttribute("cart") Cart cart) {

        cart.getCartItem(productId).ifPresentOrElse(
                CartItem::increment,
                () -> addProductToCart(productId, cart));

        return "redirect:/public/products";
    }

    @PostMapping("/private/cart")
    public String order(SessionStatus status, RedirectAttributes redirectAttributes) {
        // save to DB...

        status.setComplete();

        redirectAttributes.addFlashAttribute("successMessage",
                "order.successful");

        return "redirect:/public/products";
    }

    private void addProductToCart(UUID productId, Cart cart) {

        Product product = productService.getProduct(productId);
        cart.add(product);
    }
}
