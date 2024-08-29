package cuber.post.app.auth.service;

import cuber.post.app.auth.model.LoginToken;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public interface LoginHandler {
    LoginToken handle(LoginToken loginToken, LoginHandlerChain chain);
}
