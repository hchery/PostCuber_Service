package cuber.post.app.location.handler;

import cuber.post.app.location.RegionHandler;
import cuber.post.app.location.RegionHandlerChain;
import cuber.post.app.sdk.service.IpService;
import lombok.extern.slf4j.Slf4j;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Slf4j
public class UndertakeRegionHandler implements RegionHandler {

    @Override
    public String handle(String ip, RegionHandlerChain chain) {
        if (log.isDebugEnabled()) {
            log.debug("Resolve ip: '{}' region has undertake, please check handler chain implement, " +
                    "if you are sure that ok, please ignore this message",
                ip
            );
        }
        return IpService.IP_REGION_UNKNOWN;
    }
}
