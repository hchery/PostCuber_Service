package cuber.post.app.auth.http.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import cuber.post.app.sdk.http.ValueEnumJsonDeserializer;
import cuber.post.app.sdk.model.auth.LoginType;

import java.io.IOException;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class LoginTypeJsonDeserializer extends ValueEnumJsonDeserializer<Integer, LoginType> {

    @Override
    protected Class<LoginType> getEnumClass() {
        return LoginType.class;
    }

    @Override
    protected Integer parseValue(JsonParser parser, DeserializationContext ctx) throws IOException {
        return parser.getIntValue();
    }
}
