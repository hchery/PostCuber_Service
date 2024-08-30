package cuber.post.app.auth.service.login;

import cuber.post.app.auth.model.LoginToken;
import cuber.post.app.auth.service.LoginHandler;
import cuber.post.app.auth.service.LoginHandlerChain;
import cuber.post.app.sdk.event.auth.LoginResultEvent;
import cuber.post.app.sdk.model.auth.LoginResult;
import jakarta.annotation.Resource;
import org.springframework.context.ApplicationContext;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class UndertakeLoginHandler implements LoginHandler {

    @Resource
    private ApplicationContext context;

    @Override
    public LoginToken handle(LoginToken loginToken, LoginHandlerChain chain) {
        publishCompletedEvent(loginToken);
        return loginToken;
    }

    private void publishCompletedEvent(LoginToken loginToken) {
        LoginResultEvent loginResultEvent = new LoginResultEvent(this);
        loginResultEvent.setUserId(loginToken.getUser().getId());
        loginResultEvent.setLoginResult(LoginResult.COMPLETED);
        context.publishEvent(loginResultEvent);
    }
}
