package cuber.post.app.history.service;

import cuber.post.app.history.dao.LoginHistoryDao;
import cuber.post.app.sdk.data.AbstractRepositoryService;
import cuber.post.app.sdk.model.history.LoginHistory;
import cuber.post.app.sdk.service.LoginHistoryService;
import org.springframework.stereotype.Service;

/**
 * DATE: 2024/9/4
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Service
public class DefaultLoginHistoryService extends AbstractRepositoryService<LoginHistory, LoginHistoryDao>
    implements LoginHistoryService {

    public DefaultLoginHistoryService(LoginHistoryDao repository) {
        super(repository);
    }
}
