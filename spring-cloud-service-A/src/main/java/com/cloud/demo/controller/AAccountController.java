package com.cloud.demo.controller;

import com.cloud.demo.client.ServiceBbClient;
import com.cloud.demo.domain.TAccount;
import com.cloud.demo.service.IAaService;
import com.cloud.demo.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-13
 * @Description:
 */
@RestController
@RequestMapping("/v1/accounts")
public class AAccountController {
    private static final Logger logger = LoggerFactory.getLogger(AAccountController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ServiceBbClient serviceBbClient;

    @Autowired
    private IAaService iAaService;

    @GetMapping
    public String query(@RequestParam Long id){
        TAccount tAccount = new TAccount();
        tAccount.setId(id);
        String returnMsg = null;
        try {
            returnMsg = JsonUtils.obj2json(iAaService.selectByPrimaryKey(tAccount));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return returnMsg;
    }

    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody TAccount tAccount){
        String returnMsg = null;
        try {
            returnMsg = JsonUtils.obj2json(iAaService.insert(tAccount));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return returnMsg;
    }

    @PutMapping(consumes = "application/json")
    public String update(@RequestParam TAccount tAccount){
        String returnMsg = null;
        try {
            returnMsg = JsonUtils.obj2json(iAaService.updateByPrimaryKey(tAccount));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return returnMsg;
    }

    @DeleteMapping
    public String delete(@RequestParam Long id){
        TAccount tAccount = new TAccount();
        tAccount.setId(id);
        String returnMsg = null;
        try {
            returnMsg = JsonUtils.obj2json(iAaService.deleteByPrimaryKey(tAccount));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return returnMsg;
    }

    @GetMapping("/business1")
    public Integer business1(HttpServletRequest request, @RequestParam Integer a, @RequestParam Integer b) {
        String requestHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println(requestHeader);
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        logger.info("/business1, host:" + instance.getHost()
                + ", port:" + instance.getPort()
                + ", service_id:" + instance.getServiceId());
        Integer result = serviceBbClient.business1(a,b);
        return result;
    }
}
