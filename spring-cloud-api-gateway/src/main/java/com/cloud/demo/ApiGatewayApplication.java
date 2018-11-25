package com.cloud.demo;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author : lihaibo
 * @date : 2018/11/8 8:05 PM
 * @version : V1.0.0
 * @description :
 * @ EnableOAuth2Sso 启用OAuth2单点登录
*/
@EnableSwagger2Doc
@EnableZuulProxy
@SpringCloudApplication
@EnableDiscoveryClient
@EnableOAuth2Sso
public class ApiGatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApiGatewayApplication.class).web(true).run(args);
    }

}
