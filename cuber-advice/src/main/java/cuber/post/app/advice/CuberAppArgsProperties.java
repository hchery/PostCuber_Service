package cuber.post.app.advice;

import cuber.post.app.sdk.CuberAppArgs;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * DATE: 2024/9/3
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@ConfigurationProperties(prefix = "cuber.application.args")
@Data
public class CuberAppArgsProperties implements CuberAppArgs {
    // RedisKey前缀
    private String redisKeyPrefix = "post-cuber";
    // 开发模式开关
    private boolean devMode = false;
}
