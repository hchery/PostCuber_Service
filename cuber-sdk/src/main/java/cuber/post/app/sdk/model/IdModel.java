package cuber.post.app.sdk.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serial;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Data
public class IdModel implements RedisModel {
    @Serial
    private static final long serialVersionUID = -8759679300300017207L;

    @MongoId(FieldType.OBJECT_ID)
    private String id;
}
