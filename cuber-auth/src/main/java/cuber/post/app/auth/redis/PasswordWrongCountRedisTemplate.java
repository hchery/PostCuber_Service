package cuber.post.app.auth.redis;

import cuber.post.app.sdk.data.StringRedisTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * DATE: 2024/9/3
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
public class PasswordWrongCountRedisTemplate extends StringRedisTemplate {

    public PasswordWrongCountRedisTemplate(
        RedisConnectionFactory connectionFactory,
        PasswordWrongCountKeySerializer keySerializer
    ) {
        super(connectionFactory, keySerializer);
    }

    public Long getPasswordWrongCount(String userId) {
        String count = opsForValue().get(userId);
        if (StringUtils.isBlank(count)) {
            return 0L;
        }
        return Long.parseLong(count);
    }
}
