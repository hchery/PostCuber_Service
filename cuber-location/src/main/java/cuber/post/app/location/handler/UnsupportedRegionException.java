package cuber.post.app.location.handler;

import java.io.Serial;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class UnsupportedRegionException extends Exception {
    @Serial
    private static final long serialVersionUID = 223813325601497445L;

    public UnsupportedRegionException(String message) {
        super(message);
    }
}
