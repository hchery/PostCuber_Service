package cuber.post.app.auth.utils;

import cuber.post.app.sdk.utils.HmacHelper;
import cuber.post.app.sdk.utils.RandomHelper;
import org.apache.commons.codec.binary.Hex;

import java.util.Arrays;

/**
 * DATE: 2024/8/30
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public abstract class TokenHelper {

    private static final int SALT_LENGTH = 16;

    public static String generateToken(String userId, TokenKeyHelper keyHelper) {
        byte[] userIdBytes = userId.getBytes();
        byte[] saltBytes = RandomHelper.randomBytes(SALT_LENGTH);
        byte[] secretBytes = HmacHelper.useHmacSHA256(mergeSalt(userIdBytes, saltBytes), keyHelper.getKey(userId));
        return "%s.%s.%s".formatted(
            Hex.encodeHexString(userIdBytes),
            Hex.encodeHexString(saltBytes),
            Hex.encodeHexString(secretBytes)
        );
    }

    private static byte[] mergeSalt(byte[] userIdBytes, byte[] saltBytes) {
        byte[] mergedBytes = Arrays.copyOf(userIdBytes, userIdBytes.length + saltBytes.length);
        System.arraycopy(saltBytes, 0, mergedBytes, userIdBytes.length, saltBytes.length);
        return mergedBytes;
    }
}
