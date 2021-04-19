package lt.codeacademy.eshop.util;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomErrorViewResolver implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status,
                                         Map<String, Object> model) {

        Map<String, Object> customAttributes = new HashMap<>(model);
        customAttributes.put("customAttribute", "Custom Attribute!");

        return new ModelAndView("customErrorPage", customAttributes);
    }
}
