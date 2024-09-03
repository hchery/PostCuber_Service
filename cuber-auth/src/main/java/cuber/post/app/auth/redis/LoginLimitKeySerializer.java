package cuber.post.app.auth.redis;

import cuber.post.app.sdk.data.RedisKeySerializer;
import org.springframework.stereotype.Component;

/**
 * DATE: 2024/9/3
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
public class LoginLimitKeySerializer extends RedisKeySerializer {

    @Override
    protected String getGroup() {
        return "auth:login-limit";
    }
}
