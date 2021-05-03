package lt.codeacademy.eshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Profile("!test")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final String h2ConsolePath;

    public SecurityConfiguration(@Value("${spring.h2.console.path:}") String h2ConsolePath) {
        this.h2ConsolePath = h2ConsolePath;
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

        auth
                .inMemoryAuthentication()
                    .withUser("user")
                        .password("{bcrypt}$2y$12$Br2r4h8aQPYrQALiC6FN8OxIKVQxxLynmavjsbhfTQfx5H33avBF.") // pass
                        .roles("USER")
                        .and()
                    .withUser("admin")
                        .password("{bcrypt}$2y$12$hLSERC4ExpBppkaGQKt7y.7eH7dlNrBaf3EpCwjQYyQuXWD.vj3r2") // admin
                        .roles("ADMIN");
    }
}
