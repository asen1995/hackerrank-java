package jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTValidator {
    public boolean validateHMAC256JWT(String token, String secret) {


        try {
            Algorithm algorithm = Algorithm.HMAC256("asen-secret");
            DecodedJWT jwt = JWT.require(algorithm).build().verify(token);
            System.out.println("JWT verification succeeded!");
        } catch (Exception e) {
            System.out.println("JWT verification failed!");
            return false;
        }

        return true;
    }
}
