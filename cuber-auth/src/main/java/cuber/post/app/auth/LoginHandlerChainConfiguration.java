package cuber.post.app.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Configuration(proxyBeanMethods = false)
@ImportResource("classpath:login-handler-chain.xml")
public class LoginHandlerChainConfiguration {
}
