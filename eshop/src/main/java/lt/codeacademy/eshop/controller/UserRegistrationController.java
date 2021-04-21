package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.UserRegistration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author Andrius Baltrunas
 */
@Controller
@RequestMapping("/user/registration")
public class UserRegistrationController {

    @GetMapping
    public String openRegistrationForm(Model model) {
        model.addAttribute("userRegistration", new UserRegistration());

        return "userRegistration";
    }

    @PostMapping
    public String createNewUser(@Valid UserRegistration userRegistration, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "userRegistration";
        }

        //TODO save user (call service to save new user)

        return "redirect:/user/registration";
    }
}
