package cuber.post.app.sdk.utils;

import lombok.SneakyThrows;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * DATE: 2024/8/30
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public abstract class HmacHelper {

    private static final String ALGORITHM = "HmacSHA256";

    @SneakyThrows
    public static byte[] randomKey() {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        return keyGenerator.generateKey().getEncoded();
    }

    @SneakyThrows
    public static byte[] useHmacSHA256(byte[] bytes, byte[] key) {
        Mac hmacSha256 = Mac.getInstance(ALGORITHM);
        SecretKeySpec keySpec = new SecretKeySpec(key, ALGORITHM);
        hmacSha256.init(keySpec);
        return hmacSha256.doFinal(bytes);
    }
}
