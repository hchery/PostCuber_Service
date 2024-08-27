package cuber.post.app.location;

import cuber.post.app.sdk.utils.IndexedChain;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@RequiredArgsConstructor
public class IndexedRegionHandlerChain extends IndexedChain<IndexedRegionHandlerChain> implements RegionHandlerChain {

    private final List<RegionHandler> handlers;

    @Override
    protected IndexedRegionHandlerChain createChain() {
        return new IndexedRegionHandlerChain(handlers);
    }

    @Override
    public String doNext(String ip) {
        int index = getIndexAndIncrement();
        return handlers.get(index).handle(ip, this);
    }
}
