package cuber.post.app.location;

import cuber.post.app.sdk.service.IpService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Service
public class DefaultIpService implements IpService {

    @Resource
    private RequestIpLoader requestIpLoader;

    @Resource
    private IndexedRegionHandlerChain regionHandlerChain;

    @Override
    public String getRequestIp(HttpServletRequest request) {
        return requestIpLoader.load(request);
    }

    @Override
    public String getIpRegion(String ip) {
        return regionHandlerChain.newChain().doNext(ip);
    }
}
