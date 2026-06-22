package com.mani.securebank.service;

import com.mani.securebank.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JwtService {

    /**
     * Custom claim key that encodes the token's intended purpose.
     *
     * FIX: Without a type claim, a refresh token is a structurally valid
     * access token — an attacker who steals a long-lived refresh token
     * can present it as an access token.  Adding a "typ" claim and
     * validating it prevents token substitution attacks.
     */
    private static final String CLAIM_TOKEN_TYPE = "typ";
    private static final String TYPE_ACCESS   = "access";
    private static final String TYPE_REFRESH  = "refresh";

    private final JwtConfig jwtConfig;

    public String generateAccessToken(String username) {
        return generateToken(username, jwtConfig.getAccessExpirationMs(),
                Map.of(CLAIM_TOKEN_TYPE, TYPE_ACCESS));
    }

    public String generateRefreshToken(String username) {
        return generateToken(username, jwtConfig.getRefreshExpiration(),
                Map.of(CLAIM_TOKEN_TYPE, TYPE_REFRESH));
    }

    private String generateToken(String username, long expirationMs, Map<String, Object> extraClaims) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .claims(extraClaims)
                .subject(username)
                .issuedAt(new Date(now))
                .expiration(new Date(now + expirationMs))
                .signWith(jwtConfig.getSigningKey())
                .compact();
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(jwtConfig.getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        Claims claims = extractAllClaims(token);
        String username = claims.getSubject();

        boolean isAccessToken = TYPE_ACCESS.equals(claims.get(CLAIM_TOKEN_TYPE, String.class));

        return username.equals(userDetails.getUsername())
                && !isExpired(claims)
                && isAccessToken;
    }

    public boolean isRefreshTokenValid(String token, UserDetails userDetails) {
        Claims claims = extractAllClaims(token);
        String username = claims.getSubject();
        boolean isRefreshToken = TYPE_REFRESH.equals(claims.get(CLAIM_TOKEN_TYPE, String.class));

        return username.equals(userDetails.getUsername())
                && !isExpired(claims)
                && isRefreshToken;
    }

    private boolean isExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }
}
