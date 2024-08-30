package cuber.post.app.auth.redis;

import cuber.post.app.sdk.data.CacheOnlyRepository;
import cuber.post.app.sdk.utils.HmacHelper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * DATE: 2024/8/30
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@RequiredArgsConstructor
public abstract class RedisTokenKey implements CacheOnlyRepository<byte[]> {

    @Resource
    private TokenKeyRedisTemplate tokenKeyRedisTemplate;

    private final String keyPrefix;

    public byte[] generateKey(String userId, long expireMs) {
        String key = "%s:%s".formatted(keyPrefix, userId);
        byte[] keyBytes = HmacHelper.randomKey();
        tokenKeyRedisTemplate.opsForValue().set(key, keyBytes, expireMs, TimeUnit.MILLISECONDS);
        return keyBytes;
    }

    public byte[] findKey(String userId) {
        String key = "%s:%s".formatted(keyPrefix, userId);
        return tokenKeyRedisTemplate.opsForValue().get(key);
    }

    public void deleteKey(String userId) {
        String key = "%s:%s".formatted(keyPrefix, userId);
        tokenKeyRedisTemplate.delete(key);
    }
}
