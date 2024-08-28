package cuber.post.app.identity.service;

import cuber.post.app.identity.dao.UserDao;
import cuber.post.app.sdk.data.AbstractRepositoryService;
import cuber.post.app.sdk.model.IdModel;
import cuber.post.app.sdk.model.identity.User;
import cuber.post.app.sdk.service.UserService;
import org.springframework.stereotype.Service;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Service
public class DefaultUserService extends AbstractRepositoryService<User, UserDao> implements UserService {

    public DefaultUserService(UserDao repository) {
        super(repository);
    }

    @Override
    public User getByEmail(String email) {
        IdModel idModel = repository.searchIdByEmail(email);
        if (idModel == null) {
            return null;
        }
        return getById(idModel.getId());
    }
}
