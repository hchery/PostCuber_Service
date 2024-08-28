package cuber.post.app.sdk.data;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public interface RepositoryService<T> {
    T getById(String id);
    T save(T entity);
    void delete(String id);
}
