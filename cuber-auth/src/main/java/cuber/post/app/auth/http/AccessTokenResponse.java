package cuber.post.app.auth.http;

import cuber.post.app.sdk.http.Response;
import lombok.Data;

import java.io.Serial;

/**
 * DATE: 2024/8/30
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Data
public class AccessTokenResponse implements Response {
    @Serial
    private static final long serialVersionUID = 3305829422093433704L;

    private String text;
    private long expireAfter;
}
