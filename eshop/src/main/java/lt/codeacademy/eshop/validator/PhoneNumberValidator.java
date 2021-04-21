package lt.codeacademy.eshop.validator;

import lt.codeacademy.eshop.validator.annotation.PhoneNumber;
import lt.codeacademy.eshop.validator.data.PhoneNumberType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Andrius Baltrunas
 */
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private PhoneNumberType type;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        type = constraintAnnotation.type();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return type.equals(PhoneNumberType.FULL) ? isValidFullPhoneNumber(s) : isValidPartPhoneNumber(s);
    }

    private boolean isValidFullPhoneNumber(String phoneNumber) {
        return phoneNumber.length() == 12 && phoneNumber.startsWith("+370");
    }

    private boolean isValidPartPhoneNumber(String phoneNumber) {
        return phoneNumber.length() == 9 && phoneNumber.startsWith("86");
    }
}
