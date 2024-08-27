package cuber.post.app.sdk.resource;

import java.io.Serial;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class ResourceLoadException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 4238491675642607470L;

    public ResourceLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
