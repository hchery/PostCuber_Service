package cuber.post.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * DATE: 2024/8/27
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@SpringBootApplication
@EnableCaching
@EnableMongoRepositories
@EnableMongoAuditing
@ConfigurationPropertiesScan
public class CuberApplication {

    public static void main(String[] args) {
        SpringApplication.run(CuberApplication.class, args);
    }
}
