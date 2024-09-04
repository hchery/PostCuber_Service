package cuber.post.app.sdk.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;
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
public class MutableModel extends ImmutableModel {

    @Serial
    private static final long serialVersionUID = -4737003234692004843L;

    @Field("update_time")
    @LastModifiedDate
    private Date updateTime;
}
