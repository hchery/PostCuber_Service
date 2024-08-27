package cuber.post.app.sdk.http;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public interface Client {
    String getMethod();
    String getPath();
    String getRemoteIp();
    String getUserAgent();
}
