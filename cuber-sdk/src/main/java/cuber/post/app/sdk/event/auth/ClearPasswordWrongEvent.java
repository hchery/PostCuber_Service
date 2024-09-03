package cuber.post.app.sdk.event.auth;

import java.io.Serial;

/**
 * DATE: 2024/9/3
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class ClearPasswordWrongEvent extends LoginEvent {

    @Serial
    private static final long serialVersionUID = 2498806731614191870L;

    public ClearPasswordWrongEvent(Object source) {
        super(source);
    }
}
