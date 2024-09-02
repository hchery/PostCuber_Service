package cuber.post.app.auth.redis;

import cuber.post.app.sdk.data.RedisKeySerializer;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * DATE: 2024/9/2
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
public class AccessTokenKeyRedisTemplate extends SignKeyRedisTemplate {

    public AccessTokenKeyRedisTemplate(
        RedisConnectionFactory connectionFactory,
        AccessTokenKeySerializer keySerializer
    ) {
        super(connectionFactory, keySerializer);
    }
}
