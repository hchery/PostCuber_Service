package cuber.post.app.advice.redis;

import cuber.post.app.sdk.CuberAppArgs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Configuration(proxyBeanMethods = false)
public class RedisCacheDepsConfiguration {

    @Bean
    public RedisCacheWriter redisCacheWriter(RedisConnectionFactory connectionFactory) {
        return RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
    }

    @Bean
    public RedisCacheConfiguration cacheConfiguration(CuberAppArgs args) {
        return RedisCacheConfiguration.defaultCacheConfig()
            .serializeKeysWith(RedisSerializationContext.string().getKeySerializationPair())
            .serializeValuesWith(RedisSerializationContext.java().getValueSerializationPair())
            .prefixCacheNameWith(args.getRedisKeyPrefix())
            .computePrefixWith(k -> "%s:%s:".formatted(args.getRedisKeyPrefix(), k));
    }
}
