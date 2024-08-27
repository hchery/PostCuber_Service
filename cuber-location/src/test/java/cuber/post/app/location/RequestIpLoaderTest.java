package cuber.post.app.location;

import cuber.post.app.sdk.service.IpService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RequestIpLoaderTest {

    @Resource
    private IpService ipService;

    @Test
    public void testRequestIpLoader() {
        String xRealIp = "X-Real-IP";
        String xFowIp = "X-Forwarded-For";
        String proxyClientIp = "Proxy-Client-IP";
        String wlIp = "WL-Proxy-Client-IP";
        assert "127.0.0.1".equals(ipService.getRequestIp(simulationRequest("127.0.0.1", xRealIp)));
        assert "127.0.0.2".equals(ipService.getRequestIp(simulationRequest("127.0.0.2,127.0.0.1", xRealIp)));
        assert "127.0.0.2".equals(ipService.getRequestIp(simulationRequest("127.0.0.2,127.0.0.1", xFowIp)));
        assert "127.0.0.2".equals(ipService.getRequestIp(simulationRequest("127.0.0.2,127.0.0.1", proxyClientIp)));
        assert "127.0.0.2".equals(ipService.getRequestIp(simulationRequest("127.0.0.2,127.0.0.1", wlIp)));
        assert "127.0.0.3".equals(ipService.getRequestIp(simulationRequest(null, xRealIp)));
    }

    private HttpServletRequest simulationRequest(String ipStr, String header) {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRemoteAddr("127.0.0.3");
        if (StringUtils.isNotBlank(ipStr)) {
            request.addHeader(header, ipStr);
        }
        return request;
    }
}
