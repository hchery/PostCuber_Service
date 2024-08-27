package cuber.post.app.sdk.resource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class Utf8PropertiesResourceLoader extends Utf8ResourceLoader<Properties> {

    @Override
    protected Properties transWithUtf8(InputStreamReader reader) throws IOException {
        Properties properties = new Properties();
        properties.load(reader);
        return properties;
    }
}
