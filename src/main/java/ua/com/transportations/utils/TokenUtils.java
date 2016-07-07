package ua.com.transportations.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by d.fedorov on 07.07.16.
 */
public class TokenUtils {

    private final static String secret = "salt";

    //    1 day
    private final static long expiration = 12 * 60 * 60 * 100L;

    public static String getUsernameFromToken(String token) {
        try {
            final Claims claims = getClaimsFromToken(token);
            return claims.getIssuer();
        } catch (Exception e) {
            return null;
        }
    }

    private static String getPassFromToken(String token) {
        try {
            final Claims claims = getClaimsFromToken(token);
            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    private static Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    private static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private static Date generateCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    private static Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration);
    }

    private static Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(generateCurrentDate());
    }

    public static String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap();
        claims.put(Claims.ISSUER, userDetails.getUsername());
        claims.put(Claims.SUBJECT, userDetails.getPassword());
        return generateToken(claims);
    }

    private static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public static Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        final String password = getPassFromToken(token);
        return (username.equals(userDetails.getUsername())
                && password.equals(userDetails.getPassword())
                && !isTokenExpired(token));
    }

}
