package nz.co.automation.regression.cryptocipher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import static java.lang.String.format;

@Component
public class ApacheValueCryptoCipher implements ValueCryptoCipher {

    private final SecretKeySpec aesKey;
    private final Cipher cipher;

    /**
     * Private key for password decryption
     * Key must have 16, 24, 32 characters in length
     * @param privateKey
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     */
    @Autowired
    public ApacheValueCryptoCipher(@Value("${crypto.cipher.private-key:sparkventures123}") String privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException {
        aesKey = new SecretKeySpec(privateKey.getBytes(), "AES");
        cipher = Cipher.getInstance("AES");
    }

    @Override
    public String decrypt(String encryptedValue) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] decrypted = Base64.getDecoder().decode(encryptedValue);
            return new String(cipher.doFinal(decrypted));
        } catch (Exception e) {
            throw new IllegalStateException(format("Failed to decrypt encryptedValue '%s'", encryptedValue), e);
        }
    }

    @Override
    public String encrypt(String value) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(value.getBytes());
            return new String(Base64.getEncoder().encode(encrypted));
        } catch (Exception e) {
            throw new IllegalStateException(format("Failed to encrypt value '%s'", value), e);
        }
    }
}
