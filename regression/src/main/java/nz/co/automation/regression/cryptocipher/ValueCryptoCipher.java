package nz.co.automation.regression.cryptocipher;

public interface ValueCryptoCipher {
    String decrypt(String encryptedKey);

    String encrypt(String key);
}
