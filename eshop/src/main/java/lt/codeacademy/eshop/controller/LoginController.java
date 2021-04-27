package lt.codeacademy.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/prisijungimas")
    public String login() {
        return "login";
    }
}
