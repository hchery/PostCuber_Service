package cuber.post.app.sdk.event.auth;

import cuber.post.app.sdk.event.CuberEvent;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Getter
@Setter
public abstract class LoginEvent extends CuberEvent {

    @Serial
    private static final long serialVersionUID = 1124736686740422755L;

    public LoginEvent(Object source) {
        super(source);
    }

    private String userId;
}
