package com.cloud.demo;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableSwagger2Doc
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages="com.cloud.demo.dao")
public class ServiceBApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceBApplication.class).web(true).run(args);
	}

}
