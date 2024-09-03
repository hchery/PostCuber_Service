package cuber.post.app.auth.redis;

import cuber.post.app.sdk.data.StringRedisTemplate;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * DATE: 2024/9/3
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
public class LoginLimitRedisTemplate extends StringRedisTemplate {

    public LoginLimitRedisTemplate(
        RedisConnectionFactory connectionFactory,
        LoginLimitKeySerializer keySerializer
    ) {
        super(connectionFactory, keySerializer);
    }
}
