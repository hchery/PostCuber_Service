package cuber.post.app.sdk;

/**
 * DATE: 2024/8/27
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

public interface CuberAppArgs {
    // RedisKey前缀
    String getRedisKeyPrefix();
    // 开发模式开关
    boolean isDevMode();
}
