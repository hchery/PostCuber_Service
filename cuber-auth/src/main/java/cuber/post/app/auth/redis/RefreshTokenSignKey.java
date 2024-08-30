package cuber.post.app.auth.redis;

import org.springframework.stereotype.Component;

/**
 * DATE: 2024/8/30
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
public class RefreshTokenSignKey extends RedisTokenKey {

    public RefreshTokenSignKey() {
        super("key:token:refresh-sign");
    }
}
