package cuber.post.app.advice.redis;

import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
@Primary
public class CuberRedisCacheManager extends RedisCacheManager {

    public CuberRedisCacheManager(RedisCacheWriter writer, RedisCacheConfiguration config) {
        super(writer, config);
    }

    /**
     * 重新创建RedisCache
     * 用来支持自定义过期时间
     * 格式：{KEY}#{EXPIRE}
     * @param name 缓存名
     * @param cacheConfiguration 缓存配置
     * @return Redis缓存代理对象
     */
    @Override
    @NonNull
    protected RedisCache createRedisCache(@NonNull String name, RedisCacheConfiguration cacheConfiguration) {
        String[] nameParts = name.split("#");
        Duration ttl = switch (nameParts.length) {
            case 1 -> Duration.ofMinutes(5);
            case 2 -> Duration.parse(nameParts[1]);
            default -> throw new IllegalStateException("Unexpected cache name: '%s'".formatted(name));
        };
        return super.createRedisCache(nameParts[0], cacheConfiguration.entryTtl(ttl));
    }
}
