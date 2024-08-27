package cuber.post.app.location;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Configuration(proxyBeanMethods = false)
@ImportResource("classpath:region-handler-chain.xml")
public class RegionHandlerChainConfiguration {
}
