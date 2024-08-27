package cuber.post.app.sdk;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * DATE: 2024/8/27
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(CuberAppArgs.class)
public class CuberAppArgsConfiguration {
}
