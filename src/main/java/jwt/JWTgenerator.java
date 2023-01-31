package jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class JWTgenerator {
    public String generateHMAC256JWT(String secret) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        String token = JWT.create()
                .withIssuer("asen")
                .withSubject("subject")
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600_000))
                .sign(algorithm);
        System.out.println(token);
        return token;
    }
}
