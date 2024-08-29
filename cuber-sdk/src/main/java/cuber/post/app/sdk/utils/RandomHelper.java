package cuber.post.app.sdk.utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * DATE: 2024/8/30
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public abstract class RandomHelper {

    public static int randomInt(int min, int max) {
        return getRandom().nextInt(max - min + 1) + min;
    }

    public static byte[] randomBytes(int size) {
        byte[] bytes = new byte[size];
        getRandom().nextBytes(bytes);
        return bytes;
    }

    private static Random getRandom() {
        return ThreadLocalRandom.current();
    }
}
