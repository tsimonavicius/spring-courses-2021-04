package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Andrius Baltrunas
 */
@Controller
public class ForwardController {

    @GetMapping("/forwardExample")
    public String forward(Model model) {
        model.addAttribute("product", new Product());
        return "redirectExample";
    }

    @PostMapping("/forwardExample")
    public String forward(Product product, Model model) {
        return "forward:/secondForwardExample";
    }

    @PostMapping("/secondForwardExample")
    public String secondForwardExample(Product product, Model model) {
        model.addAttribute("prodcut", product);
        return "product";
    }
}
