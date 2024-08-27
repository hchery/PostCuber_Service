package cuber.post.app.sdk.i18n;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public interface I18nContext {
    I18nLang getLang();
    String read(I18nKey key);
}
