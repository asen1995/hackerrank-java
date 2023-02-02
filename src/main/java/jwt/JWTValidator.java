package jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Map;

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

    public Map<String, Claim> extractHMAC256JWTClaims(String token, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("asen-secret");
            DecodedJWT jwt = JWT.require(algorithm).build().verify(token);

            System.out.println("JWT verification succeeded!");

            return jwt.getClaims();

        } catch (Exception e) {
            System.out.println("JWT verification failed!");
            throw new RuntimeException("JWT verification failed!");
        }


    }

    public DecodedJWT decodeJwt(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("asen-secret");
            DecodedJWT jwt = JWT.require(algorithm).build().verify(token);

            System.out.println("JWT verification succeeded!");

            return jwt;

        } catch (Exception e) {
            System.out.println("JWT verification failed!");
            throw new RuntimeException("JWT verification failed!");
        }


    }
}
