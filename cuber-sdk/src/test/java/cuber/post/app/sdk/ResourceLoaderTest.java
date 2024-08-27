package cuber.post.app.sdk;

import cuber.post.app.sdk.resource.Utf8PropertiesResourceLoader;
import org.junit.jupiter.api.Test;

import java.util.Properties;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class ResourceLoaderTest {

    @Test
    public void testUtf8PropertiesResourceLoader() {
        Utf8PropertiesResourceLoader loader = new Utf8PropertiesResourceLoader();
        Properties properties = loader.load("utf8-properties-test.txt");
        assert "测试Key1@".equals(properties.get("key.test"));
    }
}
