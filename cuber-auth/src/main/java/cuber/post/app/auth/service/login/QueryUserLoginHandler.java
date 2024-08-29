package cuber.post.app.auth.service.login;

import cuber.post.app.auth.model.LoginToken;
import cuber.post.app.auth.service.LoginHandler;
import cuber.post.app.auth.service.LoginHandlerChain;
import cuber.post.app.sdk.ErrorCode;
import cuber.post.app.sdk.model.identity.User;
import cuber.post.app.sdk.service.UserService;
import jakarta.annotation.Resource;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class QueryUserLoginHandler implements LoginHandler {

    @Resource
    private UserService userService;

    @Override
    public LoginToken handle(LoginToken loginToken, LoginHandlerChain chain) {
        String email = loginToken.getRequest().getEmail();
        User user = userService.getByEmail(email);
        loginToken.setUser(inspectUser(user, email));
        return chain.doNext(loginToken);
    }

    private User inspectUser(User user, String email) {
        if (user != null) {
            return user;
        }
        String message = "No such user by email: '%s'".formatted(email);
        throw ErrorCode.LOGIN_NO_SUCH_USER.errors(message);
    }
}
