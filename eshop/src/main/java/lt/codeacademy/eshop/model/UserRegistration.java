package lt.codeacademy.eshop.model;

import lombok.Data;
import lt.codeacademy.eshop.validator.annotation.CompareFields;
import lt.codeacademy.eshop.validator.annotation.Password;
import lt.codeacademy.eshop.validator.annotation.PhoneNumber;

/**
 * @author Andrius Baltrunas
 */
@Data
@Password
//@CompareFields(firstField = "password", secondField = "repeatPassword")
public class UserRegistration {
    private String name;
    private String surname;
    private String email;
    @PhoneNumber
    private String phone;
    private String password;
    private String repeatPassword;
}
