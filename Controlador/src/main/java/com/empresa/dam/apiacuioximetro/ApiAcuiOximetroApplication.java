package com.empresa.dam.apiacuioximetro;

import com.empresa.dam.apiacuioximetro.config.RsaKeyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Método principal que inicia la aplicación de la API AcuiOximetro.
 * 
 * @param args Argumentos de línea de comandos.
 */
@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class ApiAcuiOximetroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiAcuiOximetroApplication.class, args);
    }

}
