package cuber.post.app.advice;

import cuber.post.app.sdk.CuberAppArgs;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
public class ServletLogFilterConfiguration extends FilterRegistrationBean<ServletLogFilter> {

    public ServletLogFilterConfiguration(CuberAppArgs args, ContextClient client) {
        super(new ServletLogFilter(args, client));
    }

    @PostConstruct
    protected void postConfigurationLogic() {
        setOrder(Ordered.HIGHEST_PRECEDENCE);
        addUrlPatterns("/*");
    }
}
