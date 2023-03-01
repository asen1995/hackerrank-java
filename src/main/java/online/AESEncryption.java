package online;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESEncryption {
    private static final String ALGORITHM = "AES";
    private static final String key = "AESEncryptionKey";

    public static String encrypt(String value) throws Exception {
        Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedValue = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encryptedValue);
    }

    public static String decrypt(String value) throws Exception {
        Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedValue = Base64.getDecoder().decode(value);
        byte[] decryptedValueBytes = cipher.doFinal(decryptedValue);
        return new String(decryptedValueBytes);
    }

    public static void main(String[] args) throws Exception {
        String encrypted = AESEncryption.encrypt("Hello World");
        System.out.println(encrypted);
        String decrypted = AESEncryption.decrypt(encrypted);
        System.out.println(decrypted);
    }
}
