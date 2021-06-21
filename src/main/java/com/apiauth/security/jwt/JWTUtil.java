package com.apiauth.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.UUID;

import static com.apiauth.utils.SystemConstants.Prefix.BEARER_PREFIX;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class JWTUtil {
    // Chave com algoritmo HS512
    // http://www.allkeysgenerator.com
    private static final String JWT_SECRET = "t6w9z$C&F)J@NcRfUjXn2r5u8x!A%D*G-KaPdSgVkYp3s6v9y$B?E(H+MbQeThWm";

    @NonNull
    private static byte[] signinKey() {
        return JWT_SECRET.getBytes();
    }

    @Nullable
    private static Claims getClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(signinKey())
                    .parseClaimsJws(token.replace(BEARER_PREFIX, "")).getBody();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isTokenValid(String token) {
        Claims claims = getClaims(token);
        if (nonNull(claims)) {
            String login = claims.getSubject();
            Date expiration = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());
            return login != null && expiration != null && now.before(expiration);
        }
        return false;
    }

    @Nullable
    public static String getLogin(String token) {
        Claims claims = getClaims(token);
        if (!isNull(claims)) {
            return claims.getSubject();
        }
        return null;
    }

    @NonNull
    public static String accessToken(@NonNull UUID uuid) {
        int millisecond = 1000;
        int seconds = 60;
        int minutes = 60;
        int hours = 24;
        long time = hours * minutes * seconds * millisecond;
        Date expiration = new Date(System.currentTimeMillis() + time);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, signinKey())
                .setSubject(uuid.toString())
                .setExpiration(expiration)
                .compact();
    }

    @NonNull
    public static String refreshToken(@NonNull UUID uuid) {
        int millisecond = 1000;
        int seconds = 60;
        int minutes = 60;
        int hours = 24;
        int days = 7;
        long time = days * hours * minutes * seconds * millisecond;
        Date expiration = new Date(System.currentTimeMillis() + time);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, signinKey())
                .setSubject(uuid.toString())
                .setExpiration(expiration)
                .compact();
    }
}
