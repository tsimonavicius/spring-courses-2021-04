package lt.codeacademy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringContextConfig {

    @Bean
    public MarksDao marksDao() {
        return new InternalMarksDao();
    }
}
