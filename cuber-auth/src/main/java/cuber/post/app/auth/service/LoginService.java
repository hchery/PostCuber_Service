package cuber.post.app.auth.service;

import cuber.post.app.auth.http.AccessTokenResponse;
import cuber.post.app.auth.http.LoginRequest;
import cuber.post.app.auth.http.RefreshTokenResponse;
import cuber.post.app.auth.http.TokenResponse;
import cuber.post.app.auth.model.LoginToken;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * DATE: 2024/9/1
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Service
public class LoginService {

    @Resource
    private IndexedLoginHandlerChain loginHandlerChain;

    public TokenResponse doLogin(LoginRequest request) {
        LoginToken loginToken = new LoginToken();
        loginToken.setRequest(request);
        LoginToken completeToken = loginHandlerChain.newChain().doNext(loginToken);
        RefreshTokenResponse refreshTokenResponse = new RefreshTokenResponse();
        refreshTokenResponse.setText(completeToken.getRefreshToken().getText());
        AccessTokenResponse accessTokenResponse = new AccessTokenResponse();
        accessTokenResponse.setText(completeToken.getAccessToken().getText());
        accessTokenResponse.setExpireAfter(completeToken.getAccessToken().getExpireAfter());
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setAccessToken(accessTokenResponse);
        tokenResponse.setRefreshToken(refreshTokenResponse);
        return tokenResponse;
    }
}
