package cuber.post.app.auth.service;

import cuber.post.app.auth.http.LoginRequest;
import cuber.post.app.sdk.CuberException;
import cuber.post.app.sdk.model.auth.LoginType;
import cuber.post.app.sdk.model.identity.User;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public interface Authenticator {
    LoginType supportType();
    void authenticate(User user, LoginRequest request) throws CuberException;
}
