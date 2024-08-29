package cuber.post.app.auth.service.login;

import cuber.post.app.auth.http.LoginRequest;
import cuber.post.app.auth.model.LoginToken;
import cuber.post.app.auth.service.Authenticator;
import cuber.post.app.auth.service.LoginHandler;
import cuber.post.app.auth.service.LoginHandlerChain;
import cuber.post.app.sdk.model.identity.User;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class TriggerAuthenticatorLoginHandler implements LoginHandler {

    @Override
    public LoginToken handle(LoginToken loginToken, LoginHandlerChain chain) {
        Authenticator authenticator = loginToken.getAuthenticator();
        User user = loginToken.getUser();
        LoginRequest loginRequest = loginToken.getRequest();
        authenticator.authenticate(user, loginRequest);
        return chain.doNext(loginToken);
    }
}
