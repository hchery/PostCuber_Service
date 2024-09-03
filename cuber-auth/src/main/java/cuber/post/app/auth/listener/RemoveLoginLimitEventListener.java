package cuber.post.app.auth.listener;

import cuber.post.app.auth.redis.LoginLimitRedisTemplate;
import cuber.post.app.sdk.event.auth.RemoveLoginLimitEvent;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * DATE: 2024/9/3
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
public class RemoveLoginLimitEventListener implements ApplicationListener<RemoveLoginLimitEvent> {

    @Setter(onMethod = @__(@Autowired))
    private LoginLimitRedisTemplate redisTemplate;

    @Override
    public void onApplicationEvent(@NonNull RemoveLoginLimitEvent event) {
        String userId = event.getUserId();
        redisTemplate.delete(userId);
    }
}
