package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.exception.ProductNotFoundException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditor;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public String productNotFound(ProductNotFoundException e, Model model) {
        model.addAttribute("productId", e.getProductId());
        return "productNotFound";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        PropertyEditor stringTrimmer = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmer);
    }
}
