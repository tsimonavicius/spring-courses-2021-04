package lt.codeacademy.eshop.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
