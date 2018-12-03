package com.cloud.demo.controller;

import com.cloud.demo.domain.TUser;
import com.cloud.demo.service.IUserService;
import com.cloud.demo.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-19
 * @Description:
 */
@RestController
@RequestMapping("/v1/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService iUserService;

    @GetMapping
    public String query(@RequestParam Long id) {
        TUser tUser = new TUser();
        tUser.setId(id);
        String returnMsg = null;
        try {
            returnMsg = JsonUtils.obj2json(iUserService.selectByPrimaryKey(tUser));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return returnMsg;
    }

    @PostMapping(consumes = "application/json")
    public String save(@RequestParam TUser tUser) {
        String returnMsg = null;
        try {
            returnMsg = JsonUtils.obj2json(iUserService.insert(tUser));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return returnMsg;
    }

    @PutMapping(consumes = "application/json")
    public String update(@RequestParam TUser tUser) {
        String returnMsg = null;
        try {
            returnMsg = JsonUtils.obj2json(iUserService.updateByPrimaryKey(tUser));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return returnMsg;
    }

    @DeleteMapping
    public String delete(@RequestParam Long id) {
        TUser tUser = new TUser();
        tUser.setId(id);
        String returnMsg = null;
        try {
            returnMsg = JsonUtils.obj2json(iUserService.deleteByPrimaryKey(tUser));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return returnMsg;
    }

}
