package cuber.post.app.auth.listener;

import cuber.post.app.auth.redis.PasswordWrongCountRedisTemplate;
import cuber.post.app.sdk.event.auth.PasswordWrongEvent;
import cuber.post.app.sdk.event.auth.ReceiveLoginLimitEvent;
import jakarta.annotation.Resource;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
public class PasswordWrongEventListener implements ApplicationListener<PasswordWrongEvent> {

    private static final int MAX_COUNT = 5;
    private static final Duration EXPIRES_IN = Duration.ofMinutes(30);

    @Setter(onMethod = @__(@Autowired))
    private PasswordWrongCountRedisTemplate redisTemplate;

    @Resource
    private ApplicationContext context;

    @Override
    public void onApplicationEvent(@NonNull PasswordWrongEvent event) {
        String userId = event.getUserId();
        Long count = redisTemplate.opsForValue().increment(userId);
        if (count == null || count < MAX_COUNT) {
            checkExpiresIn(userId);
            return;
        }
        setLoginLimitRedis(userId);
        redisTemplate.delete(userId);
    }

    private void setLoginLimitRedis(String userId) {
        ReceiveLoginLimitEvent receiveLoginLimitEvent = new ReceiveLoginLimitEvent(this);
        receiveLoginLimitEvent.setUserId(userId);
        context.publishEvent(receiveLoginLimitEvent);
    }

    private void checkExpiresIn(String userId) {
        Long expire = redisTemplate.getExpire(userId);
        if (expire == null) {
            return;
        }
        if (expire < 0) {
            redisTemplate.expire(userId, EXPIRES_IN);
        }
    }
}
