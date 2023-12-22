package com.empresa.dam.apiacuioximetro.config.security;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Component
@EnableWebSecurity
@NoArgsConstructor
public class HttpSecurityConfig {
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionMangConfig -> sessionMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .authorizeHttpRequests(authConfig ->{
                    authConfig.requestMatchers(antMatcher(HttpMethod.POST, "/auth/authenticate")).permitAll();
                    authConfig.requestMatchers(antMatcher("/error")).permitAll();

                    authConfig.anyRequest().authenticated();
                });
        return http.build();
    }
}
