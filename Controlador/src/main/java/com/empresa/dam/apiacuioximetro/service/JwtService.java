package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.entity.Usuarios;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {
    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;
    public String generateToken(Usuarios usuario, Map<String, Object> extraClaims){
        Instant now = Instant.now();
        System.out.println(now);


        return Jwts.builder()
                .claims(extraClaims)
                .subject(usuario.getNombre())
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(90, ChronoUnit.DAYS)))
                .header()
                .add("typ", "JWT")
                .and()
                .signWith(generateKey())
                .compact();
    }

    private Key generateKey(){
        byte[] secretAsByte = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(secretAsByte);
    }
}
