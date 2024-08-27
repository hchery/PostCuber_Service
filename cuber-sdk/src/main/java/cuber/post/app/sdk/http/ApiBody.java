package cuber.post.app.sdk.http;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.util.Date;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@RequiredArgsConstructor
@Getter
public class ApiBody implements HttpModel {
    @Serial
    private static final long serialVersionUID = -383317914946708317L;

    private final int code;
    private final String desc;
    private final Object data;
    private final Date time = new Date();

    public ApiBody(Object data) {
        this(200, null, data);
    }

    public ApiBody() {
        this(null);
    }

    public ApiBody(int code, String desc) {
        this(code, desc, null);
    }
}
