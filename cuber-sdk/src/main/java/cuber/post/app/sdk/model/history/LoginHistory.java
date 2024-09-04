package cuber.post.app.sdk.model.history;

import cuber.post.app.sdk.model.ImmutableModel;
import cuber.post.app.sdk.model.auth.LoginResult;
import cuber.post.app.sdk.model.auth.LoginType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.util.Date;

/**
 * DATE: 2024/9/4
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Document("login_histories")
public class LoginHistory extends ImmutableModel {

    @Serial
    private static final long serialVersionUID = -378260279370200090L;

    @Field("user_id")
    @Indexed
    private String userId;

    @Field("login_type")
    @Indexed
    private LoginType loginType;

    @Field("login_result")
    @Indexed
    private LoginResult loginResult;

    @Field("login_time")
    @Indexed
    private Date loginTime;

    @Field("remote_ip")
    private String remoteIp;

    @Field("remote_region")
    private String remoteRegion;

    @Field("user_agent")
    private String userAgent;
}
