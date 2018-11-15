package com.cloud.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigApplication.class).web(true).run(args);
	}

}
