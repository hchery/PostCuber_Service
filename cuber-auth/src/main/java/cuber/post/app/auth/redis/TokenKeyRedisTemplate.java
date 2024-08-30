package cuber.post.app.auth.redis;

import cuber.post.app.sdk.data.JavaRedisTemplate;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * DATE: 2024/8/30
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
public class TokenKeyRedisTemplate extends JavaRedisTemplate<byte[]> {

    public TokenKeyRedisTemplate(RedisConnectionFactory connectionFactory) {
        super(connectionFactory);
    }
}
