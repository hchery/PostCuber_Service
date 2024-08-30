package cuber.post.app.sdk.data;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.io.Serializable;

/**
 * DATE: 2024/8/30
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public abstract class JavaRedisTemplate<T extends Serializable> extends RedisTemplate<String, T> {

    public JavaRedisTemplate(RedisConnectionFactory connectionFactory) {
        setKeySerializer(RedisSerializer.string());
        setHashKeySerializer(RedisSerializer.string());
        setValueSerializer(RedisSerializer.java());
        setHashValueSerializer(RedisSerializer.java());
        setConnectionFactory(connectionFactory);
        afterPropertiesSet();
    }
}
