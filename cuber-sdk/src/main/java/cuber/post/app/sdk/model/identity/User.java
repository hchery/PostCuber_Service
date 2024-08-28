package cuber.post.app.sdk.model.identity;

import cuber.post.app.sdk.model.MutableModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Document("user_details")
public class User extends MutableModel {

    @Serial
    private static final long serialVersionUID = 6748008718227281503L;

    @Indexed(unique = true)
    private String email;

    @Indexed
    private String password;

    @Indexed
    private String nickname;
}
