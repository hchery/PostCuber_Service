package cuber.post.app.sdk;

import cuber.post.app.sdk.i18n.I18nKey;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    SERVER_ERROR(500, ErrorLevel.ERROR, I18nKey.THROWS_SERVER_ERROR),
    METHOD_NOT_ALLOWED(405, ErrorLevel.DEBUG, I18nKey.THROWS_METHOD_NOT_ALLOWED),
    BAD_REQUEST(400, ErrorLevel.INFO, I18nKey.THROWS_BAD_REQUEST),
    NOT_FOUND(404, ErrorLevel.INFO, I18nKey.THROWS_NOT_FOUND),

    LOGIN_NO_HANDLER(10405, ErrorLevel.INFO, I18nKey.THROWS_LOGIN_NO_HANDLER),
    LOGIN_NO_SUCH_USER(10404, ErrorLevel.INFO, I18nKey.THROWS_LOGIN_NO_SUCH_USER),
    LOGIN_PASSWORD_WRONG(10401, ErrorLevel.INFO, I18nKey.THROWS_LOGIN_PASSWORD_WRONG),
    LOGIN_LIMITED(10403, ErrorLevel.INFO, I18nKey.THROWS_LOGIN_LIMITED),
    ;
    private final int code;
    private final ErrorLevel level;
    private final I18nKey i18nKey;

    public CuberException errors(String message, Throwable cause) {
        CuberException exception = new CuberException(message, cause);
        exception.setCode(code);
        exception.setLevel(level);
        exception.setDescI18nKey(i18nKey);
        return exception;
    }

    public CuberException errors(String message) {
        return errors(message, null);
    }
}
