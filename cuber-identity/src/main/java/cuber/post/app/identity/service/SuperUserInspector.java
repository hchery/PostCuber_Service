package cuber.post.app.identity.service;

import cuber.post.app.sdk.model.identity.User;
import cuber.post.app.sdk.service.PasswordService;
import cuber.post.app.sdk.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Service
@Slf4j
public class SuperUserInspector implements InitializingBean {

    private static final String SUPER_USER_EMAIL    = "admin@cuber.post";
    private static final String SUPER_USER_NICKNAME = "Administrator";

    @Resource
    private UserService userService;

    @Resource
    private PasswordService passwordService;

    @Override
    public void afterPropertiesSet() throws Exception {
        User superUser = userService.getByEmail(SUPER_USER_EMAIL);
        if (superUser == null) {
            autoGenerateSuperUser();
        } else {
            log.info("Super user account has already configured");
        }
    }

    private void autoGenerateSuperUser() {
        User superUser = new User();
        String superPassword = passwordService.randomPassword();
        superUser.setEmail(SUPER_USER_EMAIL);
        superUser.setPassword(passwordService.encode(superPassword));
        superUser.setNickname(SUPER_USER_NICKNAME);
        userService.save(superUser);
        logSuperUserInfo(superPassword);
    }

    private void logSuperUserInfo(String password) {
        log.info("""
                 Super user account has been configured, here are the details:
                   Email:    {}
                   Password: {}
                   Nickname: {}""",
            SUPER_USER_EMAIL,
            password,
            SUPER_USER_NICKNAME
        );
    }
}
