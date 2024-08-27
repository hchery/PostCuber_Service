package cuber.post.app.sdk;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * DATE: 2024/8/27
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@ConfigurationProperties(prefix = "cuber.application.args")
@Data
public class CuberAppArgs {
    // RedisKey前缀
    private String redisKeyPrefix = "post-cuber";
    // 开发模式开关
    private boolean devMode = false;
}
