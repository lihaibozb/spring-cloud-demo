package com.cloud.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-14
 * @Description:
 */
@SpringBootApplication
public class DomainApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DomainApplication.class).web(true).run(args);
    }

}
