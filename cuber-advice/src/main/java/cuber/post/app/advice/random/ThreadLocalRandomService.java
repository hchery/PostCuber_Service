package cuber.post.app.advice.random;

import cuber.post.app.sdk.service.RandomService;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Service
public class ThreadLocalRandomService implements RandomService {

    @Override
    public int randomInt(int min, int max) {
        return getRandom().nextInt(max - min + 1) + min;
    }

    private Random getRandom() {
        return ThreadLocalRandom.current();
    }
}
