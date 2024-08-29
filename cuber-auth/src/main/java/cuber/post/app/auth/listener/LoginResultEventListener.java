package cuber.post.app.auth.listener;

import cuber.post.app.sdk.event.auth.LoginResultEvent;
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
public class LoginResultEventListener implements ApplicationListener<LoginResultEvent> {

    @Override
    public void onApplicationEvent(@NonNull LoginResultEvent event) {
        System.out.println(event);
    }
}
