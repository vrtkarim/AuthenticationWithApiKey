package org.vrtkarim.authenticationwithapikey.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.vrtkarim.authenticationwithapikey.configuration.filters.CustomAuthenticationFilter;

import static javax.management.Query.and;

@Configuration
public class SecurityConfig {
    private final CustomAuthenticationFilter customAuthenticationFilter;

    public SecurityConfig(CustomAuthenticationFilter customAuthenticationFilter) {
        this.customAuthenticationFilter = customAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return  http
               .addFilterAt( customAuthenticationFilter,UsernamePasswordAuthenticationFilter.class)
               .authorizeHttpRequests().anyRequest().authenticated()

               .and().build();

    }
}
