package cuber.post.app.sdk.service;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public interface PasswordService extends PasswordEncoder {
    String randomPassword();
}
