package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {

    @GetMapping
    public String openCart(@ModelAttribute("cart") List<Product> cart, HttpServletRequest request) {

        return "cart";
    }

    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("cart", new ArrayList<Product>());

        return "redirect:/cart";
    }
}
