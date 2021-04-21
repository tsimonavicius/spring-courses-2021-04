package lt.codeacademy.eshop.validator.annotation;

import lt.codeacademy.eshop.validator.CompareFieldsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Andrius Baltrunas
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CompareFieldsValidator.class)
public @interface CompareFields {
    String message() default "{javax.validation.constraint.NotNull.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String firstField();

    String secondField();
}
