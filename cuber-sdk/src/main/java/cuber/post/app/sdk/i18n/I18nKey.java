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
    THROWS_SERVER_ERROR("cuber.throws.SERVER-ERROR"),
    THROWS_METHOD_NOT_ALLOWED("cuber.throws.METHOD-NOT-ALLOWED"),
    THROWS_BAD_REQUEST("cuber.throws.BAD-REQUEST"),
    THROWS_NOT_FOUND("cuber.throws.NOT-FOUND"),

    THROWS_LOGIN_NO_HANDLER("cuber.throws.LOGIN-NO-HANDLER"),
    THROWS_LOGIN_NO_SUCH_USER("cuber.throws.LOGIN-NO-SUCH-USER"),
    THROWS_LOGIN_PASSWORD_WRONG("cuber.throws.LOGIN-PASSWORD-WRONG"),
    THROWS_LOGIN_LIMITED("cuber.throws.LOGIN-LIMITED"),

    ENUM_LOGIN_TYPE_PASSWORD("cuber.enum.LOGIN-TYPE-PASSWORD"),

    ENUM_LOGIN_RESULT_COMPLETED("cuber.enum.LOGIN-RESULT-COMPLETED"),
    ENUM_LOGIN_RESULT_PASSWORD_WRONG("cuber.enum.LOGIN-RESULT-PASSWORD-WRONG"),
    ENUM_LOGIN_RESULT_LIMITED("cuber.enum.LOGIN-RESULT-LIMITED"),
    ;
    private final String value;
}
