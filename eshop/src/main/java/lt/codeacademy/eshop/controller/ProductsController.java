package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {

    @GetMapping("/")
    public String openCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }
}
