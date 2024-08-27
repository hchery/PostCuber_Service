package cuber.post.app.location;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Component
public class RequestIpLoader {

    private static final List<String> IP_HEADERS = List.of(
        "X-Real-IP",
        "x-Forwarded-For",
        "Proxy-Client-IP",
        "WL-Proxy-Client-IP"
    );

    public String load(HttpServletRequest request) {
        for (String header : IP_HEADERS) {
            String ip = request.getHeader(header);
            if (isInspectIp(ip)) {
                return splitFirstAddress(ip);
            }
        }
        return request.getRemoteAddr();
    }

    private static String splitFirstAddress(String ip) {
        int commaIndex = ip.indexOf(',');
        if (commaIndex < 0) {
            return ip;
        }
        return ip.substring(0, commaIndex);
    }

    private static boolean isInspectIp(String ip) {
        return StringUtils.isNotBlank(ip)
            && !StringUtils.equalsIgnoreCase(ip, "unknown");
    }
}
