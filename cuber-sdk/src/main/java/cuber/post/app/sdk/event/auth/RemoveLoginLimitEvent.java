package cuber.post.app.sdk.event.auth;

import java.io.Serial;

/**
 * DATE: 2024/9/3
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class RemoveLoginLimitEvent extends LoginEvent {

    @Serial
    private static final long serialVersionUID = 7706169749752291691L;

    public RemoveLoginLimitEvent(Object source) {
        super(source);
    }
}
