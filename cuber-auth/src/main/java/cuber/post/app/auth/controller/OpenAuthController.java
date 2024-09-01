package cuber.post.app.auth.controller;

import cuber.post.app.auth.http.*;
import cuber.post.app.auth.model.LoginToken;
import cuber.post.app.auth.service.IndexedLoginHandlerChain;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DATE: 2024/8/30
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@RequestMapping("/api/auth/open")
@RestController
public class OpenAuthController {

    @Resource
    private IndexedLoginHandlerChain loginHandlerChain;

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request) {
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
