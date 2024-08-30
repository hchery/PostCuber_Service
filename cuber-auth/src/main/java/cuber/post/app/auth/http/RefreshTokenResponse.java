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
public class RefreshTokenResponse implements Response {
    @Serial
    private static final long serialVersionUID = -4361420498243255535L;

    private String text;
}
