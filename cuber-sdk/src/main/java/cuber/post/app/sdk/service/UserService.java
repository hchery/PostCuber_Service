package cuber.post.app.sdk.service;

import cuber.post.app.sdk.data.RepositoryService;
import cuber.post.app.sdk.model.identity.User;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public interface UserService extends RepositoryService<User> {
    User getByEmail(String email);
}
