package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Andrius Baltrunas
 */
@Controller
public class RedirectController {

    @GetMapping("/redirectExample")
    public String redirectExample(Model model) {
        model.addAttribute("product", new Product());
        return "redirectExample";
    }

    @PostMapping("/redirectExample")
    public String redirect(Product product, Model model) {
        return "redirect:/secondRedirectExample";
    }

    @GetMapping("/secondRedirectExample")
    public String secondRedirectExample(Product product, Model model) {
        model.addAttribute("product", product);

        return "product";
    }
}
