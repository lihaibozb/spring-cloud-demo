package com.cloud.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@MapperScan(basePackages = "com.cloud.demo.dao")
public class ServiceAApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceAApplication.class).web(true).run(args);
    }

}
