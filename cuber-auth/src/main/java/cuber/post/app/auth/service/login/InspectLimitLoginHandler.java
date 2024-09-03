package cuber.post.app.auth.service.login;

import cuber.post.app.auth.model.LoginToken;
import cuber.post.app.auth.redis.LoginLimitRedisTemplate;
import cuber.post.app.auth.service.LoginHandler;
import cuber.post.app.auth.service.LoginHandlerChain;
import cuber.post.app.sdk.ErrorCode;
import cuber.post.app.sdk.event.auth.LoginResultEvent;
import cuber.post.app.sdk.model.auth.LoginResult;
import jakarta.annotation.Resource;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * DATE: 2024/9/3
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class InspectLimitLoginHandler implements LoginHandler {

    @Setter(onMethod = @__(@Autowired))
    private LoginLimitRedisTemplate redisTemplate;

    @Resource
    private ApplicationContext context;

    @Override
    public LoginToken handle(LoginToken loginToken, LoginHandlerChain chain) {
        String userId = loginToken.getUser().getId();
        String tag = redisTemplate.opsForValue().get(userId);
        if (tag != null) {
            onLoginLimit(userId, loginToken);
        }
        return chain.doNext(loginToken);
    }

    private void onLoginLimit(String userId, LoginToken loginToken) {
        publishLoginLimitResult(userId);
        String message = "Email account: '%s' login fail with: '%s'".formatted(
            loginToken.getUser().getEmail(),
            LoginResult.LIMITED.name()
        );
        throw ErrorCode.LOGIN_LIMITED.errors(message);
    }

    private void publishLoginLimitResult(String userId) {
        LoginResultEvent loginResultEvent = new LoginResultEvent(this);
        loginResultEvent.setUserId(userId);
        loginResultEvent.setLoginResult(LoginResult.LIMITED);
        context.publishEvent(loginResultEvent);
    }
}
