package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // Allows restricting access based upon the HttpServletRequest using
                .antMatchers("/", "index", "/css/*", "/js/*") // pattern for allow
                .permitAll()
                .anyRequest() // любой запрос
                .authenticated() // прошедший проверку
                .and()
                .httpBasic(); // Configures HTTP Basic authentication
    }
}
