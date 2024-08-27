package cuber.post.app.sdk;

import cuber.post.app.sdk.i18n.I18nKey;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class CuberException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -1119458488693783506L;

    public CuberException(String message, Throwable cause) {
        super(message, cause);
    }

    private ErrorLevel level;
    private int code;
    private I18nKey descI18nKey;
}
