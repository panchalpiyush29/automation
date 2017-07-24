package nz.co.automation.regression.cryptocipher;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApacheValueCryptoCipherTest {

    private ApacheValueCryptoCipher apacheValueCryptoCipher;

    @Before
    public void setUp() throws Exception {
        final String privateKey = "sparkventures123";
        apacheValueCryptoCipher = new ApacheValueCryptoCipher(privateKey);
    }

    @Test
    public void decrypt() throws Exception {
        final String value = "Secret Key";

        // given
        final String encryptedValue = apacheValueCryptoCipher.encrypt(value);

        // when
        String decryptedKey = apacheValueCryptoCipher.decrypt(encryptedValue);

        // then
        assertThat(decryptedKey).isEqualTo(value);
    }

    @Test
    @Ignore("This method should only be used to encrypt value!")
    public void encryptKey() {
        final String value = "Secret Key";

        // when
        String encryptedValue = apacheValueCryptoCipher.encrypt(value);
        System.out.println(encryptedValue);

        // then
        assertThat(encryptedValue).isNotEqualTo(value);
    }

}