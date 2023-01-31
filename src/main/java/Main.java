import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jwt.JWTgenerator;

public class Main {

	public static void main(String[] args) {

		JWTgenerator jwtGenerator = new JWTgenerator();
		String token = jwtGenerator.generateHMAC256JWT("asen-secret");

		try {
			Algorithm algorithm = Algorithm.HMAC256("asen-secret");
			DecodedJWT jwt = JWT.require(algorithm).build().verify(token);
			System.out.println("JWT verification succeeded!");
		} catch (Exception e) {
			System.out.println("JWT verification failed!");
		}

	}

}
