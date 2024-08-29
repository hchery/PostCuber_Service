package cuber.post.app.sdk.model.auth;

import cuber.post.app.sdk.i18n.I18nKey;
import cuber.post.app.sdk.model.ValueEnum;
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
public enum LoginType implements ValueEnum<Integer> {
    PASSWORD(1, I18nKey.ENUM_LOGIN_TYPE_PASSWORD),
    ;
    private final Integer value;
    private final I18nKey i18nKey;
}
