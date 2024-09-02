package cuber.post.app.auth.redis;

import cuber.post.app.sdk.data.JavaRedisTemplate;
import cuber.post.app.sdk.data.RedisKeySerializer;
import cuber.post.app.sdk.utils.HmacHelper;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.util.concurrent.TimeUnit;

/**
 * DATE: 2024/9/2
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public abstract class SignKeyRedisTemplate extends JavaRedisTemplate<byte[]> {

    public SignKeyRedisTemplate(RedisConnectionFactory connectionFactory, RedisKeySerializer keySerializer) {
        super(connectionFactory, keySerializer);
    }

    public byte[] createAndSaveKey(String userId, long expireMs) {
        byte[] keyBytes = HmacHelper.randomKey();
        opsForValue().set(userId, keyBytes, expireMs, TimeUnit.MILLISECONDS);
        return keyBytes;
    }

    public byte[] queryKey(String userId) {
        return opsForValue().get(userId);
    }
}
