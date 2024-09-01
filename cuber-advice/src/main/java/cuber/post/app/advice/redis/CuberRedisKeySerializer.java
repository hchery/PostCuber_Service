package cuber.post.app.advice.redis;

import cuber.post.app.sdk.CuberAppArgs;
import cuber.post.app.sdk.data.RedisKeySerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * DATE: 2024/9/2
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@RequiredArgsConstructor
@Component
public class CuberRedisKeySerializer implements RedisKeySerializer {

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    private final CuberAppArgs args;

    @Override
    public byte[] serialize(String value) throws SerializationException {
        String key = "%s:%s".formatted(args.getRedisKeyPrefix(), value);
        return key.getBytes(CHARSET);
    }

    @Override
    public String deserialize(byte[] bytes) throws SerializationException {
        String key = new String(bytes, CHARSET);
        if (!key.startsWith(args.getRedisKeyPrefix())) {
            key = "%s:%s".formatted(args.getRedisKeyPrefix(), key);
        }
        return key;
    }
}
