package cuber.post.app.sdk.event.auth;

import cuber.post.app.sdk.model.auth.LoginResult;
import cuber.post.app.sdk.model.auth.LoginType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.Date;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Getter
@Setter
public class LoginResultEvent extends LoginEvent {

    @Serial
    private static final long serialVersionUID = -3621351797169737055L;

    public LoginResultEvent(Object source) {
        super(source);
    }

    private LoginType loginType;
    private LoginResult loginResult;

    private Date loginTime = new Date();
}
