package cuber.post.app.advice;

import cuber.post.app.sdk.service.IpService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Configuration(proxyBeanMethods = false)
public class ContextClientConfiguration {

    @RequestScope
    @Bean
    public ContextClient client(HttpServletRequest request, IpService ipService) {
        ContextClient client = new ContextClient();
        client.setMethod(request.getMethod().toUpperCase());
        client.setPath(request.getServletPath());
        client.setRemoteIp(ipService.getRequestIp(request));
        client.setUserAgent(request.getHeader("User-Agent"));
        return client;
    }
}
