package cuber.post.app.i18n;

import cuber.post.app.sdk.i18n.I18nKey;
import cuber.post.app.sdk.i18n.I18nLang;
import cuber.post.app.sdk.resource.ResourceLoader;
import cuber.post.app.sdk.resource.Utf8PropertiesResourceLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
@Slf4j
public class LangPackageLoader {

    private final ResourceLoader<Properties> loader = new Utf8PropertiesResourceLoader();

    public LangPackage loadPackage(I18nLang lang) {
        LangPackage pkg = new LangPackage(lang, "i18n.%s.lpkg".formatted(lang.getValue()));
        log.info("Loading language package: '{}', provide language: '{}'",
            pkg.getName(),
            pkg.getLang().getValue()
        );
        Properties properties = loader.load(pkg.getName());
        properties.forEach((k, v) -> pkg.put(k.toString(), v.toString()));
        return inspectPackage(pkg);
    }

    private LangPackage inspectPackage(LangPackage pkg) {
        log.info("Inspecting language package: '{}', provide language: '{}'",
            pkg.getName(),
            pkg.getLang().getValue()
        );
        for (I18nKey key : I18nKey.values()) {
            if (!pkg.containsKey(key.getValue())) {
                String message = "I18nKey: '%s' not found in language package: '%s'".formatted(
                    key.getValue(),
                    pkg.getName()
                );
                throw new IllegalStateException(message);
            }
        }
        return pkg;
    }
}
