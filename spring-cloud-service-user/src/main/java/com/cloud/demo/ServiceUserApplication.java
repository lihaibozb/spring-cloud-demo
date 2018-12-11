package com.cloud.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages="com.cloud.demo.dao")
public class ServiceUserApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceUserApplication.class).web(true).run(args);
	}

}
