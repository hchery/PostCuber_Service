package cuber.post.app.location.handler;

import cuber.post.app.location.RegionHandler;
import cuber.post.app.location.RegionHandlerChain;
import cuber.post.app.sdk.service.IpService;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Slf4j
public class InspectRegionHandler implements RegionHandler {

    @Override
    public String handle(String ip, RegionHandlerChain chain) {
        try {
            if (InetAddress.getByName(ip) == null) {
                if (log.isDebugEnabled()) {
                    log.debug("Cannot get inet address for ip: '{}'", ip);
                }
                return IpService.IP_REGION_UNKNOWN;
            }
            return chain.doNext(ip);
        } catch (UnknownHostException ex) {
            if (log.isDebugEnabled()) {
                log.debug("Unknown host: '{}', message: '{}'",
                    ip,
                    ex.getMessage(),
                    ex
                );
            }
            return IpService.IP_REGION_UNKNOWN;
        }
    }
}
