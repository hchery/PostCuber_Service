package cuber.post.app.auth.dao;

import cuber.post.app.sdk.data.CacheOnlyRepository;

/**
 * DATE: 2024/8/30
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public interface TokenKeyDao extends CacheOnlyRepository<byte[]> {
    byte[] generateKey(String userId);
    byte[] findKey(String userId);
    void deleteKey(String userId);
}
