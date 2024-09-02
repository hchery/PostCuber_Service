package cuber.post.app.auth.redis;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * DATE: 2024/9/2
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
public class RefreshTokenKeyRedisTemplate extends SignKeyRedisTemplate {

    public RefreshTokenKeyRedisTemplate(
        RedisConnectionFactory connectionFactory,
        RefreshTokenKeySerializer keySerializer
    ) {
        super(connectionFactory, keySerializer);
    }
}
