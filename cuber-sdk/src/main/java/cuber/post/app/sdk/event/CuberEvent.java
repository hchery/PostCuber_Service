package cuber.post.app.sdk.event;

import org.springframework.context.ApplicationEvent;

import java.io.Serial;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public abstract class CuberEvent extends ApplicationEvent {

    @Serial
    private static final long serialVersionUID = -2659226789636239289L;

    public CuberEvent(Object source) {
        super(source);
    }
}
