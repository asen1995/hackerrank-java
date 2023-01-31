package jwt;

import com.auth0.jwt.interfaces.Claim;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JWTValidatorTest {

    @Test
    public void validateHMAC256JWT() {

        String secret = "asen-secret";

        JWTValidator jwtValidator = new JWTValidator();

        JWTgenerator jwtGenerator = new JWTgenerator();

        String token = jwtGenerator.generateHMAC256JWT(secret);

        assertTrue(jwtValidator.validateHMAC256JWT(token, secret));


    }

    @Test
    public void extractHMAC256JWTClaimsTest() {
        String secret = "asen-secret";

        JWTValidator jwtValidator = new JWTValidator();

        JWTgenerator jwtGenerator = new JWTgenerator();

        String token = jwtGenerator.generateHMAC256JWT(secret);

        Map<String, Claim> jwtClaims = jwtValidator.extractHMAC256JWTClaims(token, secret);
        assertEquals("asen", jwtClaims.get("iss").asString());
        assertEquals("subject", jwtClaims.get("sub").asString());

    }
}
