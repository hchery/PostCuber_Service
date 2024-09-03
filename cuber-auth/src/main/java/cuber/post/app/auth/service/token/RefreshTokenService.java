package cuber.post.app.auth.service.token;

import cuber.post.app.auth.model.StringToken;
import cuber.post.app.auth.redis.RefreshTokenKeyRedisTemplate;
import cuber.post.app.auth.utils.TokenHelper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Setter(onMethod = @__(@Autowired))
    private RefreshTokenKeyRedisTemplate redisTemplate;

    public StringToken issue(String userId) {
        String token = TokenHelper.generateToken(
            userId,
            k -> redisTemplate.createAndSaveKey(userId, REFRESH_EXPIRE_TIME_MS)
        );
        StringToken stringToken = new StringToken();
        stringToken.setText(token);
        return stringToken;
    }
}
