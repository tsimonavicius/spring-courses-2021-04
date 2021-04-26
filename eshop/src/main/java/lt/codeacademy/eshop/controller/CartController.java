package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.Cart;
import lt.codeacademy.eshop.model.Product;
import lt.codeacademy.eshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/cart")
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

    @GetMapping
    public String openCart(@ModelAttribute("cart") Cart cart) {

        return "cart";
    }

    @PostMapping("/{productId}")
    public String addToCart(@PathVariable UUID productId, @ModelAttribute("cart") Cart cart) {

        Product product = productService.getProduct(productId);
        cart.add(product);

        return "redirect:/products";
    }
}
