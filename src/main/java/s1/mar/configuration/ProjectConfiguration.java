package s1.mar.configuration;

import s1.mar.services.AuthProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@Configuration
public class ProjectConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthProviderService authProvider;

    @Bean
    public BCryptPasswordEncoder passwordEncoder_BCrypt() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SCryptPasswordEncoder passwordEncoder_SCrypt() {
        return new SCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .defaultSuccessUrl("/main", true);
        http.authorizeRequests().anyRequest().authenticated();
    }
}
