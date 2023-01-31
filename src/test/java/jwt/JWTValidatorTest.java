package jwt;

import org.junit.Test;

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

}
