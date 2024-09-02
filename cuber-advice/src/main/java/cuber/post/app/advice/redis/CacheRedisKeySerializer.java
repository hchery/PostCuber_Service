package cuber.post.app.advice.redis;

import cuber.post.app.sdk.data.RedisKeySerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * DATE: 2024/9/2
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@RequiredArgsConstructor
@Component
public class CacheRedisKeySerializer extends RedisKeySerializer {

    @Override
    protected String getGroup() {
        return "cache";
    }
}
