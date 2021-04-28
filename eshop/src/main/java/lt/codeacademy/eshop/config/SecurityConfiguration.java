package lt.codeacademy.eshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Profile("!test")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .anyRequest()
                    .authenticated()
                    .and()
                .formLogin()
                    .permitAll()
                    .loginPage("/prisijungimas")
                    .loginProcessingUrl("/prisijungimas")
                    .usernameParameter("loginName")
                    .passwordParameter("loginPassword")
                    .defaultSuccessUrl("/products", true)
                    .failureUrl("/prisijungimas?error");
    }
}
