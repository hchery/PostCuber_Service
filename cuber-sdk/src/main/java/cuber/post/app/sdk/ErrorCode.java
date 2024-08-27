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
    SERVER_ERROR(500, ErrorLevel.ERROR, I18nKey.SERVER_ERROR),
    METHOD_NOT_ALLOWED(405, ErrorLevel.INFO, I18nKey.METHOD_NOT_ALLOWED),
    BAD_REQUEST(400, ErrorLevel.INFO, I18nKey.BAD_REQUEST),

    LOGIN_NO_HANDLER(10405, ErrorLevel.INFO, I18nKey.LOGIN_NO_HANDLER),
    LOGIN_NO_SUCH_USER(10404, ErrorLevel.INFO, I18nKey.LOGIN_NO_SUCH_USER),
    LOGIN_PASSWORD_WRONG(10401, ErrorLevel.INFO, I18nKey.LOGIN_PASSWORD_WRONG),
    ;
    private final int code;
    private final ErrorLevel level;
    private final I18nKey i18nKey;
}
