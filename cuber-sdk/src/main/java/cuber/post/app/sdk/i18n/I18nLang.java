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
public enum I18nLang {
    ZH_CN("zh-CN"),
    EN_US("en-US"),
    ;
    private final String value;
}
