package cuber.post.app.location.handler;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.AbstractNamedRecord;
import cuber.post.app.location.RegionHandler;
import cuber.post.app.location.RegionHandlerChain;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Slf4j
public class GeoLiteRegionHandler implements RegionHandler {

    private static final String MMDB_FILE_PATH = "geolite2-city/GeoLite2-City.mmdb";
    private static final String GEO_LITE_REGION_I18n = "zh-CN";

    private DatabaseReader databaseReader;

    @Override
    public String handle(String ip, RegionHandlerChain chain) {
        if (log.isDebugEnabled()) {
            log.debug("Confirm ip: {} region by GeoLite service", ip);
        }
        try {
            CityResponse response = databaseReader.city(InetAddress.getByName(ip));
            String country = getName(response.getCountry());
            String province = getName(response.getMostSpecificSubdivision());
            return concatRegion(country, province);
        } catch (Exception ex) {
            if (log.isDebugEnabled()) {
                log.debug("GeoLite service confirm ip: '{}' region with error, message: '{}'",
                    ip,
                    ex.getMessage(),
                    ex
                );
            }
            return chain.doNext(ip);
        }
    }

    private static String getName(AbstractNamedRecord record) {
        return record.getNames().get(GEO_LITE_REGION_I18n);
    }

    private static String concatRegion(String country, String province) throws UnsupportedRegionException {
        // 没有国家信息，忽略该数据
        if (StringUtils.isBlank(country)) {
            String message = "GeoLite service not applied when country not exists";
            throw new UnsupportedRegionException(message);
        }
        // 没有省份信息，只保留国家数据
        if (StringUtils.isBlank(province)) {
            return country;
        }
        // 国家信息和省份信息拼接作为位置数据
        return "%s%s".formatted(country, province);
    }

    @PostConstruct
    protected void mountMmdbAndOpenDatabaseReader() throws IOException {
        log.info("Mounting MMDB file: '{}' and open database reader", MMDB_FILE_PATH);
        InputStream inputStream = new ClassPathResource(MMDB_FILE_PATH).getInputStream();
        databaseReader = new DatabaseReader.Builder(inputStream).build();
    }

    @PreDestroy
    protected void unmountMmdbAndCloseDatabaseReader() throws IOException {
        log.info("Unmounting MMDB file: '{}' and close database reader", MMDB_FILE_PATH);
        databaseReader.close();
    }
}
