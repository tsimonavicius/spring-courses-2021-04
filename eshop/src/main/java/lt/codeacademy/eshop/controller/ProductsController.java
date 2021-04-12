package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.Product;
import lt.codeacademy.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(@Qualifier("productServiceImpl") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create")
    public String openCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("/create")
    public String createProduct(Product product, Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("success", "Product save successfully");

        productService.addProduct(product);

        return "product";
    }

    @GetMapping
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getProducts());

        return "products";
    }

    @GetMapping("/findByName")
    public String getProductByName(@RequestParam String name, Model model) {

        model.addAttribute("product", productService.getByName(name));

        return "product";
    }

    @GetMapping("/update")
    public String updateProduct(@RequestParam UUID id, Model model) {
        Product product = productService.getProduct(id);

        model.addAttribute("product", product);

        return "product";
    }

    @PostMapping("/update")
    public String updateProject(Product product, Model model) {
        productService.update(product);
        model.addAttribute("products", productService.getProducts());

        return "products";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam UUID id, Model model) {
        productService.delete(id);

        model.addAttribute("products", productService.getProducts());

        return "products";
    }

}
