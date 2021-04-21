package lt.codeacademy.eshop.validator;

import lt.codeacademy.eshop.model.UserRegistration;
import lt.codeacademy.eshop.validator.annotation.Password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Andrius Baltrunas
 */
public class PasswordValidator implements ConstraintValidator<Password, UserRegistration> {

    @Override
    public boolean isValid(UserRegistration userRegistration, ConstraintValidatorContext constraintValidatorContext) {
        return userRegistration.getPassword().equals(userRegistration.getRepeatPassword());
    }
}
