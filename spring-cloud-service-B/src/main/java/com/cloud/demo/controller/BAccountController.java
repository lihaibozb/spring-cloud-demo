package com.cloud.demo.controller;

import com.cloud.demo.domain.TAccount;
import com.cloud.demo.service.IBbService;
import com.cloud.demo.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-13
 * @Description:
 */
@RestController
@RequestMapping("/v1/accounts")
public class BAccountController {
    private static final Logger logger = LoggerFactory.getLogger(BAccountController.class);

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    private IBbService iBbService;

    @GetMapping
    public String query(@RequestParam Long id) {
        TAccount tAccount = new TAccount();
        tAccount.setId(id);
        String returnMsg = null;
        try {
            returnMsg = JsonUtils.obj2json(iBbService.select(tAccount));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return returnMsg;
    }

    @PostMapping(consumes = "application/json")
    public String save(@RequestParam TAccount tAccount) {
        String returnMsg = null;
        try {
            returnMsg = JsonUtils.obj2json(iBbService.insert(tAccount));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return returnMsg;
    }

    @PutMapping(consumes = "application/json")
    public String update(@RequestParam TAccount tAccount) {
        String returnMsg = null;
        try {
            returnMsg = JsonUtils.obj2json(iBbService.updateByPrimaryKey(tAccount));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return returnMsg;
    }

    @DeleteMapping
    public String delete(@RequestParam Long id) {
        TAccount tAccount = new TAccount();
        tAccount.setId(id);
        String returnMsg = null;
        try {
            returnMsg = JsonUtils.obj2json(iBbService.deleteByPrimaryKey(tAccount));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return returnMsg;
    }

    @GetMapping("/business1")
    public Integer business1(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost()
                + ", port:" + instance.getPort()
                + ", service_id:" + instance.getServiceId()
                + ", result:" + r);
        return r;
    }
}
