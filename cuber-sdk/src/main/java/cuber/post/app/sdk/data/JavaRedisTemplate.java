package cuber.post.app.sdk.data;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * DATE: 2024/9/2
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public abstract class JavaRedisTemplate<T> extends RedisTemplate<String, T> {

    public JavaRedisTemplate(RedisConnectionFactory connectionFactory, RedisKeySerializer keySerializer) {
        setConnectionFactory(connectionFactory);
        setKeySerializer(keySerializer);
        setValueSerializer(RedisSerializer.java());
        setHashKeySerializer(RedisSerializer.string());
        setHashValueSerializer(RedisSerializer.java());
        afterPropertiesSet();
    }
}
