package cuber.post.app.auth.service.token;

import cuber.post.app.auth.model.StringToken;
import cuber.post.app.auth.redis.RefreshTokenSignKey;
import cuber.post.app.auth.utils.TokenHelper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * DATE: 2024/8/30
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Service
public class RefreshTokenService {

    private static final long REFRESH_EXPIRE_TIME_MS = 30 * 60 * 1000L;

    @Resource
    private RefreshTokenSignKey refreshTokenSignKey;

    public StringToken issue(String userId) {
        String token = TokenHelper.generateToken(
            userId,
            k -> refreshTokenSignKey.generateKey(userId, REFRESH_EXPIRE_TIME_MS)
        );
        StringToken stringToken = new StringToken();
        stringToken.setText(token);
        return stringToken;
    }
}
