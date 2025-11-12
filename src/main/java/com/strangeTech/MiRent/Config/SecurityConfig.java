package com.strangeTech.MiRent.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // ← ALL URLs OPEN
                )
                .csrf(csrf -> csrf.disable()) // ← Optional: disable CSRF for simplicity
                .formLogin(form -> form.disable())
                .logout(logout -> logout.disable());
        return http.build();
    }

}
