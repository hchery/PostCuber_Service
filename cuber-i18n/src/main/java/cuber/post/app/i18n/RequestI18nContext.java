package cuber.post.app.i18n;

import cuber.post.app.sdk.i18n.I18nContext;
import cuber.post.app.sdk.i18n.I18nKey;
import cuber.post.app.sdk.i18n.I18nLang;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@RequestScope
@Component
@Slf4j
public class RequestI18nContext implements I18nContext {

    private final I18nLang lang;
    private final LangPackage langPackage;

    public RequestI18nContext(LangPackageProvider provider, HttpServletRequest request) {
        this.lang = readLang(request);
        this.langPackage = provider.get(lang);
        if (log.isDebugEnabled()) {
            log.debug("Generated language: '{}', language package: '{}'",
                lang.getValue(),
                langPackage.getName()
            );
        }
    }

    @Override
    public I18nLang getLang() {
        return lang;
    }

    @Override
    public String read(I18nKey key) {
        return langPackage.get(key.getValue());
    }

    private static I18nLang readLang(HttpServletRequest request) {
        String langPlain = request.getHeader("Accept-Language");
        for (I18nLang lang : I18nLang.values()) {
            if (lang.getValue().equals(langPlain)) {
                return lang;
            }
        }
        I18nLang defaultLang = I18nLang.ZH_CN;
        if (log.isDebugEnabled()) {
            log.debug("No language header for request, use default as: '{}'",
                defaultLang.getValue()
            );
        }
        return defaultLang;
    }
}
