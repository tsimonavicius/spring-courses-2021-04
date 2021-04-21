package lt.codeacademy.eshop.validator;

import lt.codeacademy.eshop.model.UserRegistration;
import lt.codeacademy.eshop.validator.annotation.CompareFields;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

/**
 * @author Andrius Baltrunas
 */
public class CompareFieldsValidator implements ConstraintValidator<CompareFields, Object> {

    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(CompareFields constraintAnnotation) {
        firstFieldName = constraintAnnotation.firstField();
        secondFieldName = constraintAnnotation.secondField();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Object first = getValue(object, firstFieldName);
            Object second = getValue(object, secondFieldName);

            return first != null && first.equals(second);
        } catch (Exception e) {
            //TODO log exception
        }
        return false;
    }

    private Object getValue(Object obj, String fieldName) throws NoSuchFieldException, IllegalAccessException {

        Class<?> aClass = obj.getClass();
        Field declaredField = aClass.getDeclaredField(fieldName);
        declaredField.setAccessible(true);

        return declaredField.get(obj);
    }
}
