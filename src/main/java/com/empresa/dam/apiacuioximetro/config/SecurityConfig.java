package com.empresa.dam.apiacuioximetro.config;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Configuración de seguridad de la aplicación.
 * Se encarga de definir la autenticación y autorización de los usuarios.
 * Utiliza RSA para la codificación y decodificación de tokens JWT.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final RsaKeyProperties rsaKey;

    public SecurityConfig(RsaKeyProperties rsaKey) {
        this.rsaKey = rsaKey;
    }

    /**
     * Define un usuario en memoria con nombre de usuario "Junior", contraseña vacía y autorización para leer.
     * @return UserDetailsManager con el usuario definido.
     */
    @Bean
    public UserDetailsManager user() {
        UserDetails user = User.builder()
                .username("Junior")
                .password("{noop} ")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    /**
     * Define la cadena de filtros de seguridad para la aplicación.
     * Deshabilita la protección CSRF, requiere autenticación para todas las solicitudes y utiliza JWT como recurso de servidor OAuth2.
     * La sesión se maneja como sin estado y utiliza autenticación básica HTTP.
     * @param http HttpSecurity utilizado para definir la cadena de filtros.
     * @return SecurityFilterChain con la cadena de filtros definida.
     * @throws Exception si hay un error al definir la cadena de filtros.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer((rs) -> rs.jwt((jwt) -> jwt.decoder(jwtDecoder())))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(withDefaults())
                .build();
    }

    /**
     * Define el decodificador de tokens JWT utilizando la clave pública RSA.
     * @return JwtDecoder con el decodificador definido.
     */
    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(this.rsaKey.publicKey()).build();
    }

    /**
     * Define el codificador de tokens JWT utilizando la clave pública y privada RSA.
     * @return JwtEncoder con el codificador definido.
     */
    @Bean
    JwtEncoder jwtEncoder() {
        JWK jwk = new RSAKey.Builder(rsaKey.publicKey()).privateKey(rsaKey.privateKey()).build();
        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwks);
    }
}
