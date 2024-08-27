package cuber.post.app.sdk.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public abstract class Utf8ResourceLoader<T> extends AbstractResourceLoader<T> {

    protected abstract T transWithUtf8(InputStreamReader reader) throws IOException;

    @Override
    protected T trans(InputStream inputStream) throws IOException {
        try (InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            return transWithUtf8(reader);
        }
    }
}
