package uz.pdp.pcmarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("123")).roles("SUPER_ADMIN")
//                .authorities("READ_ALL_PRODUCT", "ADD_PRODUCT","EDIT_PRODUCT","DELETE_PRODUCT","READ_ONE_PRODUCT")
                .and()
                .withUser("moderator").password(passwordEncoder().encode("456")).roles("MODERATOR")
//                .authorities("READ_ALL_PRODUCT", "ADD_PRODUCT","EDIT_PRODUCT","READ_ONE_PRODUCT")
                .and()
                .withUser("operator").password(passwordEncoder().encode("789")).roles("OPERATOR");
//                .authorities("READ_ALL_PRODUCT","READ_ONE_PRODUCT");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/product/**").hasAnyRole("OPERATOR","MODERATOR", "SUPER_ADMIN")
                .antMatchers(HttpMethod.GET,"/product").hasAnyRole("OPERATOR","MODERATOR", "SUPER_ADMIN")
                .antMatchers(HttpMethod.POST,"/product").hasAnyRole("MODERATOR", "SUPER_ADMIN")
                .antMatchers(HttpMethod.PUT,"/product/*").hasAnyRole("MODERATOR", "SUPER_ADMIN")
                .antMatchers("/**").hasRole("SUPER_ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
