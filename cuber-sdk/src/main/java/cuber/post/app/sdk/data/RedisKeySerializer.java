package cuber.post.app.sdk.data;

import cuber.post.app.sdk.CuberAppArgs;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * DATE: 2024/9/2
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public abstract class RedisKeySerializer implements RedisSerializer<String> {

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    @Resource
    private CuberAppArgs args;

    protected abstract String getGroup();

    @Override
    public byte[] serialize(String value) throws SerializationException {
        String key = mergeKey(value);
        return key.getBytes(CHARSET);
    }

    @Override
    public String deserialize(byte[] bytes) throws SerializationException {
        return new String(bytes, CHARSET);
    }

    private String mergeKey(String key) {
        String group = getGroup();
        if (StringUtils.isBlank(group)) {
            throw new IllegalArgumentException("Redis group cannot be blank");
        }
        return "%s:%s:%s".formatted(args.getRedisKeyPrefix(), group, key);
    }
}
