package cuber.post.app.sdk.i18n;

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
public enum I18nKey {
    SERVER_ERROR("cuber.throws.SERVER-ERROR"),
    METHOD_NOT_ALLOWED("cuber.throws.METHOD-NOT-ALLOWED"),
    BAD_REQUEST("cuber.throws.BAD-REQUEST"),

    LOGIN_NO_HANDLER("cuber.throws.LOGIN-NO-HANDLER"),
    LOGIN_NO_SUCH_USER("cuber.throws.LOGIN-NO-SUCH-USER"),
    LOGIN_PASSWORD_WRONG("cuber.throws.LOGIN-PASSWORD-WRONG"),

    ENUM_LOGIN_TYPE_PASSWORD("cuber.enum.LOGIN-TYPE-PASSWORD"),

    ENUM_LOGIN_RESULT_COMPLETED("cuber.enum.LOGIN-RESULT-COMPLETED"),
    ENUM_LOGIN_RESULT_PASSWORD_WRONG("cuber.enum.LOGIN-RESULT-PASSWORD-WRONG"),
    ;
    private final String value;
}
