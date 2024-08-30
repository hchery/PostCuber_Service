package cuber.post.app.auth.utils;

/**
 * DATE: 2024/8/30
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@FunctionalInterface
public interface TokenKeyHelper {
    byte[] getKey(String userId);
}
