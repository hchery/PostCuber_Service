package cuber.post.app.sdk.resource;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public interface ResourceLoader<T> {
    T load(String path);
}
