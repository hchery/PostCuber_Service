package cuber.post.app.sdk.data;

import org.springframework.data.repository.NoRepositoryBean;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@NoRepositoryBean
public interface SearchRepository<T> extends StringIdRepository<T> {
    T searchById(String id);
}
