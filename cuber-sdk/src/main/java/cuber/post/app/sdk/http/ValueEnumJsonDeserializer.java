package cuber.post.app.sdk.http;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import cuber.post.app.sdk.model.ValueEnum;

import java.io.IOException;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public abstract class ValueEnumJsonDeserializer<V, E extends ValueEnum<V>> extends JsonDeserializer<E> {

    protected abstract Class<E> getEnumClass();
    protected abstract V parseValue(JsonParser parser, DeserializationContext ctx) throws IOException;

    @Override
    public E deserialize(JsonParser parser, DeserializationContext ctx) throws IOException, JacksonException {
        Class<E> enumClass = getEnumClass();
        V value = parseValue(parser, ctx);
        for (E enumConstant : enumClass.getEnumConstants()) {
            if (enumConstant.getValue().equals(value)) {
                return enumConstant;
            }
        }
        String message = "No matched value: '%s' found for enum class: '%s'".formatted(
            value.toString(),
            enumClass.getName()
        );
        throw new JsonParseException(message);
    }
}
