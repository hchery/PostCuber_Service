package cuber.post.app.identity.dao;

import cuber.post.app.sdk.data.SearchRepository;
import cuber.post.app.sdk.model.IdModel;
import cuber.post.app.sdk.model.identity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.Query;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public interface UserDao extends SearchRepository<User> {

    @Query(value = "{email: ?0}", fields = "{id: 1}")
    @Cacheable(cacheNames = CacheKey.K_USER_ID, key = "#email")
    IdModel searchIdByEmail(String email);

    @Override
    @Cacheable(cacheNames = CacheKey.K_USER, key = "#id")
    User searchById(String id);
}
