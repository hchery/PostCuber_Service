package cuber.post.app.sdk.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.util.Date;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public abstract class ImmutableModel extends IdModel {

    @Serial
    private static final long serialVersionUID = -5846044527035659262L;

    @Field("create_time")
    @CreatedDate
    private Date createTime;
}
