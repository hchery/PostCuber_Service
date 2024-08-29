package cuber.post.app.auth.service.login;

import cuber.post.app.auth.model.LoginToken;
import cuber.post.app.auth.service.Authenticator;
import cuber.post.app.auth.service.LoginHandler;
import cuber.post.app.auth.service.LoginHandlerChain;
import cuber.post.app.sdk.ErrorCode;
import cuber.post.app.sdk.model.auth.LoginType;
import jakarta.annotation.Resource;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class SelectAuthenticatorLoginHandler implements LoginHandler {

    private Map<LoginType, Authenticator> authenticatorMap;

    @Override
    public LoginToken handle(LoginToken loginToken, LoginHandlerChain chain) {
        LoginType loginType = loginToken.getRequest().getLoginType();
        Authenticator authenticator = authenticatorMap.get(loginType);
        loginToken.setAuthenticator(inspectAuthenticator(authenticator, loginType));
        return chain.doNext(loginToken);
    }

    private Authenticator inspectAuthenticator(Authenticator authenticator, LoginType loginType) {
        if (authenticator != null) {
            return authenticator;
        }
        String message = "Authenticator implementation does not found for login type: '%s'".formatted(
            loginType.name()
        );
        throw ErrorCode.LOGIN_NO_HANDLER.errors(message);
    }

    @Resource
    public void setAuthenticatorMap(List<Authenticator> authenticatorList) {
        Collector<Authenticator, ?, Map<LoginType, Authenticator>> collector = Collectors.toMap(
            Authenticator::supportType,
            Function.identity()
        );
        authenticatorMap = authenticatorList.stream().collect(collector);
        inspectAuthenticatorImplements();
    }

    private void inspectAuthenticatorImplements() {
        for (LoginType loginType : LoginType.values()) {
            if (!authenticatorMap.containsKey(loginType)) {
                String message = "Authenticator implementation for: '%s' not found".formatted(
                    loginType.name()
                );
                throw new IllegalStateException(message);
            }
        }
    }
}
