package cuber.post.app.i18n;

import cuber.post.app.sdk.i18n.I18nLang;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.util.HashMap;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
public class LangPackageProvider extends HashMap<I18nLang, LangPackage> {

    @Serial
    private static final long serialVersionUID = 5930091795477831677L;

    @Resource
    private LangPackageLoader langPackageLoader;

    @PostConstruct
    protected void loadAllLanguagePackage() {
        for (I18nLang lang : I18nLang.values()) {
            put(lang, langPackageLoader.loadPackage(lang));
        }
    }
}
