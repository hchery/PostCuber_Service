package cuber.post.app.auth.model;

import cuber.post.app.auth.http.LoginRequest;
import cuber.post.app.auth.service.Authenticator;
import cuber.post.app.sdk.model.identity.User;
import lombok.Data;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Data
public class LoginToken {

    private LoginRequest request;
    private User user;
    private Authenticator authenticator;
    private StringToken refreshToken;
    private ExpireStringToken accessToken;
}
