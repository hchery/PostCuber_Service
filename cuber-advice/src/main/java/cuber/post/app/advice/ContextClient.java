package cuber.post.app.advice;

import cuber.post.app.sdk.CuberException;
import cuber.post.app.sdk.http.Client;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@RequiredArgsConstructor
@Data
public class ContextClient implements Client {

    private String method;
    private String path;
    private String remoteIp;
    private String userAgent;

    private CuberException thrown;
}
