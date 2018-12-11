package com.cloud.demo.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-12-11
 * @Description:
 */
@Configuration
public class FeignConfig {
    /**
     * 日志级别
     *
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 创建Feign请求拦截器，在发送请求前设置认证的token,各个微服务将token设置到环境变量中来达到通用
     *
     * @return
     */
    @Bean
    public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new FeignBasicAuthRequestInterceptor();
    }

}