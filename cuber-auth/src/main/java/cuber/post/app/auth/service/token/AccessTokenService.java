package cuber.post.app.auth.service.token;

import cuber.post.app.auth.model.ExpireStringToken;
import cuber.post.app.auth.redis.AccessTokenKeyRedisTemplate;
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
@Setter(onMethod = @__(@Autowired))
@Service
public class AccessTokenService {

    private static final long ACCESS_EXPIRE_TIME_MS = 5 * 60 * 1000L;
    private static final long CLIENT_EXPIRE_AFTER = ACCESS_EXPIRE_TIME_MS - (30 * 1000L);

    private AccessTokenKeyRedisTemplate redisTemplate;

    public ExpireStringToken issue(String userId) {
        String token = TokenHelper.generateToken(
            userId,
            k -> redisTemplate.createAndSaveKey(k, ACCESS_EXPIRE_TIME_MS)
        );
        ExpireStringToken stringToken = new ExpireStringToken();
        stringToken.setText(token);
        stringToken.setExpireAfter(CLIENT_EXPIRE_AFTER);
        return stringToken;
    }
}
