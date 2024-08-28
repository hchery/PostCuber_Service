package cuber.post.app.sdk.data;

import lombok.RequiredArgsConstructor;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@RequiredArgsConstructor
public abstract class AbstractRepositoryService<T, R extends SearchRepository<T>> implements RepositoryService<T> {

    protected final R repository;

    @Override
    public T getById(String id) {
        return repository.searchById(id);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
