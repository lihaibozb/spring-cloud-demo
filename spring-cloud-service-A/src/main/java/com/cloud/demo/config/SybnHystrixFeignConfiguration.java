package com.cloud.demo.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-12-12
 * @Description: 手动开启feign.hystrix.enabled=true
 */
@Configuration
public class SybnHystrixFeignConfiguration {
    @Bean
    @Scope("prototype")
    public Feign.Builder feignHystrixBuilder() {
        return Feign.builder();
    }

}
