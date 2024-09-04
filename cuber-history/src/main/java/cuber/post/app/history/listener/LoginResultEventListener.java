package cuber.post.app.history.listener;

import cuber.post.app.sdk.event.auth.LoginResultEvent;
import cuber.post.app.sdk.http.Client;
import cuber.post.app.sdk.model.history.LoginHistory;
import cuber.post.app.sdk.service.IpService;
import cuber.post.app.sdk.service.LoginHistoryService;
import jakarta.annotation.Resource;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * DATE: 2024/9/4
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
public class LoginResultEventListener implements ApplicationListener<LoginResultEvent> {

    @Resource
    private Client client;

    @Resource
    private IpService ipService;

    @Resource
    private LoginHistoryService loginHistoryService;

    @Override
    public void onApplicationEvent(@NonNull LoginResultEvent event) {
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setUserId(event.getUserId());
        loginHistory.setLoginType(event.getLoginType());
        loginHistory.setLoginResult(event.getLoginResult());
        loginHistory.setLoginTime(event.getLoginTime());
        loginHistory.setRemoteIp(client.getRemoteIp());
        loginHistory.setRemoteRegion(ipService.getIpRegion(client.getRemoteIp()));
        loginHistory.setUserAgent(client.getUserAgent());
        Thread.startVirtualThread(() -> loginHistoryService.save(loginHistory));
    }
}
