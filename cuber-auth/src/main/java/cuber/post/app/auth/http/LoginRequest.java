package cuber.post.app.auth.http;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import cuber.post.app.auth.http.json.LoginTypeJsonDeserializer;
import cuber.post.app.sdk.http.Request;
import cuber.post.app.sdk.model.auth.LoginType;
import lombok.Data;

import java.io.Serial;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Data
public class LoginRequest implements Request {

    @Serial
    private static final long serialVersionUID = 5269503991385536176L;

    @JsonDeserialize(using = LoginTypeJsonDeserializer.class)
    private LoginType loginType;

    private String email;
    private String credential;
}
