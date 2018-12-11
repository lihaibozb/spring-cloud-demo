package com.cloud.demo.client;

import com.cloud.demo.config.FeignBasicAuthRequestInterceptor;
import com.cloud.demo.hystrix.ServiceBbClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-12-11
 * @Description:
 */
@FeignClient(value = "service-b", fallback = ServiceBbClientHystrix.class,
        configuration = FeignBasicAuthRequestInterceptor.class)
public interface ServiceBbClient {

    @RequestMapping(method = RequestMethod.GET, value = "/v1/accounts/business1")
    Integer business1(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}
