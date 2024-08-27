package cuber.post.app.i18n;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class LanguagePackageLoadTest {

    @Resource
    private LangPackageProvider langPackageProvider;

    @Test
    public void testLanguagePackageLoad() {
        // 加载测试，不需要测试逻辑
        // 加载逻辑在Bean构建时会自动加载
    }
}
