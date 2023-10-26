package com.empresa.dam.apiacuioximetro.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * Clase que representa las propiedades de la clave RSA, incluyendo la clave pública y privada.
 * Esta clase se utiliza para la configuración de propiedades con el prefijo "rsa".
 */
@ConfigurationProperties(prefix = "rsa")
public record RsaKeyProperties(RSAPublicKey publicKey, RSAPrivateKey privateKey) {
}
