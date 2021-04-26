package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.Product;
import lt.codeacademy.eshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
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
    public List<Product> createCart() {

        return new ArrayList<>();
    }

    @GetMapping
    public String openCart(@ModelAttribute("cart") List<Product> cart, HttpServletRequest request) {

        return "cart";
    }

    @PostMapping("/{productId}")
    public String addToCart(@PathVariable UUID productId, @ModelAttribute("cart") List<Product> cart) {

        Product product = productService.getProduct(productId);
        cart.add(product);

        return "redirect:/products";
    }
}
