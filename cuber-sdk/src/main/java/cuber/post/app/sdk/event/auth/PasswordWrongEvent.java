package cuber.post.app.sdk.event.auth;

import java.io.Serial;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class PasswordWrongEvent extends LoginEvent {

    @Serial
    private static final long serialVersionUID = 5314037139378686091L;

    public PasswordWrongEvent(Object source) {
        super(source);
    }
}
