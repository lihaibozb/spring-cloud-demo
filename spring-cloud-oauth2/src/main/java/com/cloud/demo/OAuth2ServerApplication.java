package com.cloud.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages="com.cloud.demo.dao")
public class OAuth2ServerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(OAuth2ServerApplication.class).web(true).run(args);
	}

}
