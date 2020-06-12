package cn.edu.csu.dyp.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {
    private final static long exp = 1000 * 60 * 60 * 24;
    private final static String secretKey = "yHeE9285Jq5C/Pqe3bs26P7HiF5KgXBL5rga2SvtjiU=";//https://github.com/jwtk/jjwt#secret-keys

    public static String newToken(UserDetails userDetails) {

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + exp))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public static Claims parseToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException e) {
            return null;
        }
    }

    public static String getUsername(String token) {
        try {
            return parseToken(token).getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    public static Boolean isExpired(String token) {
        return parseToken(token).getExpiration().before(new Date());
    }

    public static Boolean isCorrectUsername(String token, UserDetails userDetails) {
        return parseToken(token).getSubject().equals(userDetails.getUsername());
    }

    public static Boolean checkToken(String token, UserDetails userDetails) {
        try {
            return !isExpired(token) && isCorrectUsername(token, userDetails);
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        System.out.println(Encoders.BASE64.encode(key.getEncoded()));

        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
