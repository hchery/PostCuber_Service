package cuber.post.app.location.handler;

import cuber.post.app.location.RegionHandler;
import cuber.post.app.location.RegionHandlerChain;
import cuber.post.app.sdk.service.IpService;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public class LanIpRegionHandler implements RegionHandler {

    @Override
    public String handle(String ip, RegionHandlerChain chain) {
        if (isLanIP(ip)) {
            return IpService.IP_REGION_LAN_IP;
        }
        return chain.doNext(ip);
    }

    private static boolean isLanIP(String ip) {
        int[] ipTheFirstTwo = splitIpTheFirstTwo(ip);
        int first = ipTheFirstTwo[0];
        int second = ipTheFirstTwo[1];
        return switch (first) {
            case 0x7F, 0x0A -> // 127, 10
                true;
            case 0xAC -> // 172
                second >= 0x10 /*16*/ && second <= 0x1F; /*31*/
            case 0xC0 -> // 192
                second == 0xA8; /*168*/
            default -> false;
        };
    }

    private static int[] splitIpTheFirstTwo(String ip) {
        String[] parts = ip.split("\\.");
        return new int[] { Integer.parseInt(parts[0]), Integer.parseInt(parts[1]) };
    }
}
