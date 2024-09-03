package cuber.post.app.sdk.event.auth;

import java.io.Serial;

/**
 * DATE: 2024/9/3
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class ReceiveLoginLimitEvent extends LoginEvent {

    @Serial
    private static final long serialVersionUID = -8082224993359107031L;

    public ReceiveLoginLimitEvent(Object source) {
        super(source);
    }
}
