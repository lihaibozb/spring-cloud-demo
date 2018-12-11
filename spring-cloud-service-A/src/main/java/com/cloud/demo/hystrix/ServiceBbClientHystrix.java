package com.cloud.demo.hystrix;

import com.cloud.demo.client.ServiceBbClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-13
 * @Description:
 */
@Component
public class ServiceBbClientHystrix implements ServiceBbClient {
    @Override
    public Integer business1(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }
}
