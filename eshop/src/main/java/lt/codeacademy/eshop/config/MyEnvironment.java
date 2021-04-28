package lt.codeacademy.eshop.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * @author Andrius Baltrunas
 */
@Getter
@Setter
@Configuration
@PropertySource("classpath:myEnvironment.properties")
public class MyEnvironment {

    @Value("${first.value}")
    private String firstValue;

    @Value("#{'${my.values}'}.split(',')")
    private List<String> values;
}

