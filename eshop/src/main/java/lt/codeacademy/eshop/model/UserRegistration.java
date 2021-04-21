package lt.codeacademy.eshop.model;

import lombok.Data;
import lt.codeacademy.eshop.validator.annotation.PhoneNumber;

/**
 * @author Andrius Baltrunas
 */
@Data
public class UserRegistration {
    private String name;
    private String surname;
    private String email;
    @PhoneNumber
    private String phone;
}
