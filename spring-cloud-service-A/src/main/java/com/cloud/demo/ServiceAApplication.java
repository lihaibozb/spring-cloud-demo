package com.cloud.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.cloud.demo.dao")
public class ServiceAApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceAApplication.class).web(true).run(args);
    }

    //TODO 目前调用和oauth2一起使用时存在问题
    //@LoadBalanced
    //@Bean
    //public OAuth2RestTemplate restTemplate(UserInfoRestTemplateFactory factory) {
    //    return factory.getUserInfoRestTemplate();
    //}
}
