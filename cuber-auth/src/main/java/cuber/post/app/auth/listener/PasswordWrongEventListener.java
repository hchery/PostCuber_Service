package cuber.post.app.auth.listener;

import cuber.post.app.sdk.event.auth.PasswordWrongEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
public class PasswordWrongEventListener implements ApplicationListener<PasswordWrongEvent> {

    @Override
    public void onApplicationEvent(@NonNull PasswordWrongEvent event) {
        System.out.println(event);
    }
}
