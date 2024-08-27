package cuber.post.app.location;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@FunctionalInterface
public interface RegionHandler {
    String handle(String ip, RegionHandlerChain chain);
}
