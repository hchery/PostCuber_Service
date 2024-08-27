package cuber.post.app.sdk.service;

import jakarta.servlet.http.HttpServletRequest;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public interface IpService {

    String IP_REGION_UNKNOWN = "";
    String IP_REGION_IPV6 = "IPv6";
    String IP_REGION_LAN_IP = "LanIP";

    String getRequestIp(HttpServletRequest request);
    String getIpRegion(String ip);
}
