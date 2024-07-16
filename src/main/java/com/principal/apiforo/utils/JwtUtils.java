package com.principal.apiforo.utils;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class JwtUtils {

    private final String clave;
    private final String creador;
    private final long tokenExpirationMs;

    public JwtUtils(@Value("${spring.security.token.password}") String clave,
                    @Value("${spring.security.token.user}") String creador,
                    @Value("${spring.security.token.expiration}") long tokenExpirationMs) {
        this.clave = clave;
        this.creador = creador;
        this.tokenExpirationMs = tokenExpirationMs;
    }

    public String crearToken(Authentication authentication) {
        String usuario = authentication.getName();
        String rol = authentication.getAuthorities().stream()
                .map(a -> a.getAuthority())
                .collect(Collectors.joining(","));

        Algorithm algorithm = Algorithm.HMAC256(clave);
        return JWT.create()
                .withIssuer(creador)
                .withSubject(usuario)
                .withJWTId(UUID.randomUUID().toString())
                .withExpiresAt(new Date(System.currentTimeMillis() + tokenExpirationMs))
                .withIssuedAt(new Date())
                .withClaim("rol", rol)
                .sign(algorithm);
    }

    public DecodedJWT validarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(clave);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(creador)
                    .build();
            return verifier.verify(token);
        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException("Token invalido");
        }
    }

    public String extractUsuario(DecodedJWT decodedJWT) {
        return decodedJWT.getSubject();
    }

    public Claim claimEspecifico(String claim, DecodedJWT decodedJWT) {
        return decodedJWT.getClaim(claim);
    }
}
