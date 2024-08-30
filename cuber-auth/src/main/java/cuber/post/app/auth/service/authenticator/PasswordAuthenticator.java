package cuber.post.app.auth.service.authenticator;

import cuber.post.app.auth.http.LoginRequest;
import cuber.post.app.auth.service.Authenticator;
import cuber.post.app.sdk.CuberException;
import cuber.post.app.sdk.ErrorCode;
import cuber.post.app.sdk.event.auth.LoginResultEvent;
import cuber.post.app.sdk.event.auth.PasswordWrongEvent;
import cuber.post.app.sdk.model.auth.LoginResult;
import cuber.post.app.sdk.model.auth.LoginType;
import cuber.post.app.sdk.model.identity.User;
import cuber.post.app.sdk.service.PasswordService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
public class PasswordAuthenticator implements Authenticator {

    @Resource
    private PasswordService passwordService;

    @Resource
    private ApplicationContext context;

    @Override
    public LoginType supportType() {
        return LoginType.PASSWORD;
    }

    @Override
    public void authenticate(User user, LoginRequest request) throws CuberException {
        String raw = request.getCredential();
        String codes = user.getPassword();
        if (StringUtils.isBlank(request.getCredential()) || !passwordService.matches(raw, codes)) {
            onPasswordWrong(user, request);
        }
    }

    private void onPasswordWrong(User user, LoginRequest request) throws CuberException {
        publishPasswordWrongEvent(user);
        publishLoginResultEvent(user);
        String message = "Email account: '%s' login fail with: '%s'".formatted(
            request.getEmail(),
            LoginResult.PASSWORD_WRONG.name()
        );
        throw ErrorCode.LOGIN_PASSWORD_WRONG.errors(message);
    }

    private void publishPasswordWrongEvent(User user) {
        PasswordWrongEvent passwordWrongEvent = new PasswordWrongEvent(this);
        passwordWrongEvent.setUserId(user.getId());
        context.publishEvent(passwordWrongEvent);
    }

    private void publishLoginResultEvent(User user) {
        LoginResultEvent loginResultEvent = new LoginResultEvent(this);
        loginResultEvent.setUserId(user.getId());
        loginResultEvent.setLoginResult(LoginResult.PASSWORD_WRONG);
        context.publishEvent(loginResultEvent);
    }
}
