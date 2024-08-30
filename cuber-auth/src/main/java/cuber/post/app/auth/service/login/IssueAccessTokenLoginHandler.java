package cuber.post.app.auth.service.login;

import cuber.post.app.auth.model.ExpireStringToken;
import cuber.post.app.auth.model.LoginToken;
import cuber.post.app.auth.service.LoginHandler;
import cuber.post.app.auth.service.LoginHandlerChain;
import cuber.post.app.auth.service.token.AccessTokenService;
import jakarta.annotation.Resource;

/**
 * DATE: 2024/8/30
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class IssueAccessTokenLoginHandler implements LoginHandler {

    @Resource
    private AccessTokenService accessTokenService;

    @Override
    public LoginToken handle(LoginToken loginToken, LoginHandlerChain chain) {
        String userId = loginToken.getUser().getId();
        ExpireStringToken accessToken = accessTokenService.issue(userId);
        loginToken.setAccessToken(accessToken);
        return chain.doNext(loginToken);
    }
}
