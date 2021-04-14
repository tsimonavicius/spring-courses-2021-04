package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.Product;
import lt.codeacademy.eshop.service.MessageService;
import lt.codeacademy.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    private final MessageService messageService;

    public ProductsController(@Qualifier("productServiceImpl") ProductService productService, MessageService messageService) {
        this.productService = productService;
        this.messageService = messageService;
    }

    @GetMapping("/create")
    public String openCreateProductForm(Model model, String message) {
        model.addAttribute("product", new Product());
        if (message != null) {
            model.addAttribute("success", messageService.getMessage(message));
        }

        return "product";
    }

    @PostMapping("/create")
    public String createProduct(Product product) {
        productService.addProduct(product);

        return "redirect:/products/create?message=create.product.success.message";
    }

    @GetMapping
    public String getProducts(
            @PageableDefault(size = 5, sort = {"name"}, direction = Sort.Direction.ASC) Pageable pageable,
            Model model) {
        model.addAttribute("productsPage", productService.getProductsPaginated(pageable));

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

        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam UUID id, Model model) {
        productService.delete(id);
        return "redirect:/products";
    }

}
