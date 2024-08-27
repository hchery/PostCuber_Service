package cuber.post.app.i18n;

import cuber.post.app.sdk.i18n.I18nLang;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.util.HashMap;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@RequiredArgsConstructor
@Getter
public class LangPackage extends HashMap<String, String> {
    @Serial
    private static final long serialVersionUID = -4992859571637305611L;

    private final I18nLang lang;
    private final String name;
}
