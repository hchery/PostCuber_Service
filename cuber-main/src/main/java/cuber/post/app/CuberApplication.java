package cuber.post.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * DATE: 2024/8/27
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@SpringBootApplication
@EnableAsync
@EnableCaching
@EnableMongoRepositories
@EnableMongoAuditing
public class CuberApplication {

    public static void main(String[] args) {
        SpringApplication.run(CuberApplication.class, args);
    }
}
