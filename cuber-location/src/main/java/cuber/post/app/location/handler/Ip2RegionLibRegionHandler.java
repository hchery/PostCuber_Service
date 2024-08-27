package cuber.post.app.location.handler;

import cuber.post.app.location.RegionHandler;
import cuber.post.app.location.RegionHandlerChain;
import cuber.post.app.sdk.resource.BytesResourceLoader;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.lionsoul.ip2region.xdb.Searcher;

import java.io.IOException;
import java.util.Set;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Slf4j
public class Ip2RegionLibRegionHandler implements RegionHandler {

    // 特别行政区域
    // 目前台湾地区IP不做精确定位
    // 只定位到省级
    // 台湾省由于库中数据格式问题先按照特别行政区逻辑处理
    // 台湾省数据问题代码中有todo解释
    private static final Set<String> SPECIAL_REGION = Set.of(
        "香港",
        "澳门",
        "台湾省"
    );

    private static final String XDB_FILE_PATH = "ip2region/ip2region.xdb";

    private Searcher searcher;

    @Override
    public String handle(String ip, RegionHandlerChain chain) {
        if (log.isDebugEnabled()) {
            log.debug("Confirm ip: '{}' region by Ip2Region service", ip);
        }
        try {
            String[] regionParts = searcher.search(ip).split("\\|");
            String country = regionParts[0];
            String province = regionParts[2];
            String city = regionParts[3];
            return concatRegion(country, province, city);
        } catch (Exception ex) {
            if (log.isDebugEnabled()) {
                log.debug("Ip2Region service confirm ip: '{}' region with error, message: '{}'",
                    ip,
                    ex.getMessage(),
                    ex
                );
            }
            return chain.doNext(ip);
        }
    }

    private static String concatRegion(String country, String province, String city) throws UnsupportedRegionException {
        // 非国内地区不使用此定位方式
        if (!"中国".equals(country)) {
            String message = "Ip2Region service not applied when region in Chain'";
            throw new UnsupportedRegionException(message);
        }
        // 没有省份信息，只保留国家信息
        if (StringUtils.isBlank(province)) {
            return country;
        }
        // 特殊行政区域使用国家级字样开头
        if (SPECIAL_REGION.contains(province)) {
            return "%s%s".formatted(
                country,
                optimizeSpecialRegion(province)
            );
        }
        // 其他中国大陆地区信息，只保留地级市信息，省份无需展示
        return city;
    }

    // todo 由于目前数据库里台湾省数据格式不统一，因此先将台湾省数据按照特殊行政区域逻辑处理，后续变更为省市处理逻辑
    // 处理特殊行政区域
    // 由于库中台湾尾部带有省份字样
    // 为了保持数据库数据格式统一，将省字去掉
    // 后续拼接结果应为中国台湾
    private static String optimizeSpecialRegion(String province) {
        if ("台湾省".equals(province)) {
            return "台湾";
        }
        return province;
    }

    @PostConstruct
    protected void mountXdbAndOpenSearcher() throws IOException {
        log.info("Mounting XDB file: '{}' and open searcher", XDB_FILE_PATH);
        byte[] xdbBinary = new BytesResourceLoader().load(XDB_FILE_PATH);
        searcher = Searcher.newWithBuffer(xdbBinary);
    }

    @PreDestroy
    protected void unmountXdbAndCloseSearcher() throws IOException {
        log.info("Unmounting XDB file: '{}' and close searcher", XDB_FILE_PATH);
        searcher.close();
    }
}
