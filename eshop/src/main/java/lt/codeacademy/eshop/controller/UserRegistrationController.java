package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.UserRegistration;
import lt.codeacademy.eshop.validator.RegistrationValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/public/user/registration")
public class UserRegistrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationController.class);

    private final RegistrationValidator registrationValidator;

    public UserRegistrationController(RegistrationValidator registrationValidator) {
        this.registrationValidator = registrationValidator;
    }

    @GetMapping
    public String openRegistrationForm(Model model) {
        model.addAttribute("userRegistration", new UserRegistration());

        return "userRegistration";
    }

    @PostMapping
    public String createNewUser(@Valid UserRegistration userRegistration, BindingResult bindingResult) {
        registrationValidator.validate(userRegistration, bindingResult);
        if (bindingResult.hasErrors()) {
            LOGGER.debug("Cannot create user because of validation errors " + bindingResult.getAllErrors().size());
            return "userRegistration";
        }

        //TODO save user (call service to save new user)

        return "redirect:/user/registration";
    }
}
