package cuber.post.app.sdk.resource;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public abstract class AbstractResourceLoader<T> implements ResourceLoader<T> {

    protected abstract T trans(InputStream inputStream) throws IOException;

    @Override
    public T load(String path) {
        ClassPathResource cpr = new ClassPathResource(path);
        try (InputStream in = cpr.getInputStream()) {
            return trans(in);
        } catch (IOException ex) {
            throw new ResourceLoadException(ex.getMessage(), ex);
        }
    }
}
