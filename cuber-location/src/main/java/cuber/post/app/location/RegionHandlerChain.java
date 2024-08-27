package cuber.post.app.location;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public interface RegionHandlerChain {
    String doNext(String ip);
}
