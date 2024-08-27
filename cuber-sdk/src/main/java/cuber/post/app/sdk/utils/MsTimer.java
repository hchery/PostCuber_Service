package cuber.post.app.sdk.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MsTimer {

    private final long startTime = System.currentTimeMillis();

    public long point() {
        return System.currentTimeMillis() - startTime;
    }

    public static MsTimer now() {
        return new MsTimer();
    }
}
