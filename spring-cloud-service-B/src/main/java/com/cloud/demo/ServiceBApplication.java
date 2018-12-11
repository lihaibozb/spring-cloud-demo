package com.cloud.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages="com.cloud.demo.dao")
public class ServiceBApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceBApplication.class).web(true).run(args);
	}

}
