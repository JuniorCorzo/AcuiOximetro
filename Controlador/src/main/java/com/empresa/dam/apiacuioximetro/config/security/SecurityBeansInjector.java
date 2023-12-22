package com.empresa.dam.apiacuioximetro.config.security;

import com.empresa.dam.apiacuioximetro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@SuppressWarnings("SpringConfigurationProxyMethods")
@Component
public class SecurityBeansInjector {
    private final UsuarioRepository userRepository;

    @Autowired
    public SecurityBeansInjector(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();//ProviderManager implements AuthenticationManager
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            return this.userRepository.findByNombre(username).orElseThrow(() -> new RuntimeException("Usuario no existe"));
        };
    }
}
