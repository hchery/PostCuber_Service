package cuber.post.app.sdk.resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class BytesResourceLoader extends AbstractResourceLoader<byte[]> {

    @Override
    protected byte[] trans(InputStream inputStream) throws IOException {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            inputStream.transferTo(out);
            return out.toByteArray();
        }
    }
}
