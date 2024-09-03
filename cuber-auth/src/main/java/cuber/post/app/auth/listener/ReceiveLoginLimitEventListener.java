package cuber.post.app.auth.listener;

import cuber.post.app.auth.redis.LoginLimitRedisTemplate;
import cuber.post.app.sdk.event.auth.ReceiveLoginLimitEvent;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * DATE: 2024/9/3
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
public class ReceiveLoginLimitEventListener implements ApplicationListener<ReceiveLoginLimitEvent> {

    private static final String LIMIT_TAG = "1";
    private static final Duration LIMIT_DURATION = Duration.ofDays(1);

    @Setter(onMethod = @__(@Autowired))
    private LoginLimitRedisTemplate redisTemplate;

    @Override
    public void onApplicationEvent(@NonNull ReceiveLoginLimitEvent event) {
        String userId = event.getUserId();
        redisTemplate.opsForValue().set(userId, LIMIT_TAG, LIMIT_DURATION);
    }
}
