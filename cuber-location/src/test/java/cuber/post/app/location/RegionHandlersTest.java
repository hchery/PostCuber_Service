package cuber.post.app.location;

import cuber.post.app.sdk.service.IpService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RegionHandlersTest {

    @Resource
    private IpService ipService;

    @Test
    public void testRegionHandlerChain() {
        assert IpService.IP_REGION_UNKNOWN.equals(ipService.getIpRegion("a.b.c.d"));
        assert IpService.IP_REGION_LAN_IP.equals(ipService.getIpRegion("127.0.0.1"));
        assert IpService.IP_REGION_LAN_IP.equals(ipService.getIpRegion("172.16.33.12"));
        assert IpService.IP_REGION_LAN_IP.equals(ipService.getIpRegion("192.168.2.2"));
        assert IpService.IP_REGION_IPV6.equals(ipService.getIpRegion("::1"));
        assert "四平市".equals(ipService.getIpRegion("119.54.22.12"));
        assert "上海市".equals(ipService.getIpRegion("117.143.44.168"));
        assert "中国香港".equals(ipService.getIpRegion("101.32.37.183"));
        assert "中国澳门".equals(ipService.getIpRegion("192.203.232.2"));
        assert "中国台湾".equals(ipService.getIpRegion("101.9.108.19"));
        assert "美国".equals(ipService.getIpRegion("67.220.91.30"));
    }
}
