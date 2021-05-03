package lt.codeacademy.eshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@Profile("!test")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final String h2ConsolePath;
    private final DataSource dataSource;

    public SecurityConfiguration(@Value("${spring.h2.console.path:}") String h2ConsolePath,
                                 DataSource dataSource) {
        this.h2ConsolePath = h2ConsolePath;
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // buzinio logika ir app apsauga
        http
                .authorizeRequests()
                    .antMatchers("/prisijungimas", "/public/**", "/").permitAll()
                    .antMatchers("/private/**").authenticated()
                    .anyRequest()
                    .authenticated()
                    .and()
                .formLogin()
                    .permitAll()
                    .loginPage("/prisijungimas")
                    .loginProcessingUrl("/prisijungimas")
                    .usernameParameter("loginName")
                    .passwordParameter("loginPassword")
                    .defaultSuccessUrl("/public/products", true)
                    .failureUrl("/prisijungimas?error");
    }

    @Override
    public void configure(WebSecurity web) {

        // visa kita, ko mes nenorim apsaugoti
        web.ignoring().requestMatchers(
                PathRequest.toStaticResources().atCommonLocations()) // statiniai failai (css, images, js)
                .antMatchers(h2ConsolePath + "/**"); // h2 console
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth
                .jdbcAuthentication()
                    .dataSource(dataSource)
                    .usersByUsernameQuery("SELECT name as username, password, TRUE as enabled FROM Users u WHERE u.name = ?")
                    .authoritiesByUsernameQuery("SELECT name as username, 'USER' as authority FROM Users u WHERE u.name = ?")
                    .passwordEncoder(passwordEncoder);
    }
}
