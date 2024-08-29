package cuber.post.app.auth.service;

import cuber.post.app.auth.model.LoginToken;
import cuber.post.app.sdk.utils.IndexedChain;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * DATE: 2024/8/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@RequiredArgsConstructor
public class IndexedLoginHandlerChain extends IndexedChain<IndexedLoginHandlerChain> implements LoginHandlerChain {

    private final List<LoginHandler> handlers;

    @Override
    protected IndexedLoginHandlerChain createChain() {
        return new IndexedLoginHandlerChain(handlers);
    }

    @Override
    public LoginToken doNext(LoginToken loginToken) {
        int index = getIndexAndIncrement();
        return handlers.get(index).handle(loginToken, this);
    }
}
