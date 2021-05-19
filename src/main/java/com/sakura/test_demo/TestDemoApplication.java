package com.sakura.test_demo;

import com.sakura.test_demo.utils.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TestDemoApplication {

    /**
     * 日志类
     */
    protected static final Logger logger = LoggerFactory.getLogger(TestDemoApplication.class);

    /**
     * Spring Boot 服务跨域处理
     *
     * @return WebMvcConfigurer
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            // 默认方法：POST, GET, OPTIONS, DELETE, PUT；但系统只允许支持POST,GET
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST").allowedHeaders("*")
                        .exposedHeaders("access-control-allow-headers", "access-control-allow-methods",
                                "access-control-allow-origin", "access-control-max-age", "X-Frame-Options")
                        .allowCredentials(false).maxAge(3600);
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(TestDemoApplication.class, args);
        SpringContextUtil.setApplicationContext(applicationContext);
        logger.info("test_demo start success ...");
    }

}
