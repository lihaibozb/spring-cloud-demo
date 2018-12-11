package com.cloud.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author : lihaibo
 * @date : 2018/11/8 8:05 PM
 * @version : V1.0.0
 * @description :
 * @ EnableOAuth2Sso 启用OAuth2单点登录
*/
@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApiGatewayApplication.class).web(true).run(args);
    }

}
