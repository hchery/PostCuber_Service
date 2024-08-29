package cuber.post.app.auth.service.login;

import cuber.post.app.auth.model.LoginToken;
import cuber.post.app.auth.service.LoginHandler;
import cuber.post.app.auth.service.LoginHandlerChain;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class UndertakeLoginHandler implements LoginHandler {

    @Override
    public LoginToken handle(LoginToken loginToken, LoginHandlerChain chain) {
        return loginToken;
    }
}
