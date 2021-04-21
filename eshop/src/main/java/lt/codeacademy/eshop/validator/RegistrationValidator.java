package lt.codeacademy.eshop.validator;

import lt.codeacademy.eshop.model.UserRegistration;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Andrius Baltrunas
 */
@Component
public class RegistrationValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegistration.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "userRegistration.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "userRegistration.surname");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "userRegistration.email");
    }
}
