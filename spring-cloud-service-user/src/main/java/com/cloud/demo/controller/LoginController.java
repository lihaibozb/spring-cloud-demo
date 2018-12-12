package com.cloud.demo.controller;

import com.cloud.demo.domain.OAuth2Token;
import com.cloud.demo.domain.TUser;
import com.cloud.demo.service.IUserService;
import com.cloud.demo.utils.JsonUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-19
 * @Description:
 */
@RestController
@RequestMapping("/v1")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private IUserService iUserService;

    @ApiOperation(value = "登录接口", notes = "登录接口")
    @GetMapping("/login")
    public String query(@RequestParam String userName, @RequestParam String password) {
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            return "用户名密码错误，请重新输入";
        }

        String returnMsg = null;
        try {
            TUser tUser = new TUser();
            tUser.setUsername(userName);
            tUser.setPassword(password);
            tUser = iUserService.selectOne(tUser);
            if (tUser != null) {
                //获取token
                OAuth2Token oAuth2Token = getToken(userName, password);
                returnMsg = JsonUtils.obj2json(oAuth2Token);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return returnMsg;
    }

    private OAuth2Token getToken(String userName, String password) throws Exception {
        /*RestTemplate*/
        RestTemplate restTemplate = new RestTemplate();
        /*Execute*/
        //HttpHeader
        String base64Creds = new String(Base64.encodeBase64(("android" + ":" + "android").getBytes()));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        RequestEntity<MultiValueMap<String, String>> requestEntity = new RequestEntity<>(
                getBody(userName, password),
                headers, HttpMethod.POST,
                URI.create("http://localhost:5555/uaa/oauth/token"));

        ResponseEntity<OAuth2Token> responseEntity = restTemplate.exchange(
                requestEntity, OAuth2Token.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        }
        throw new RuntimeException("error trying to retrieve access token");
    }

    private MultiValueMap<String, String> getBody(String userName, String password) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "password");
        formData.add("scope", "all");
        formData.add("username", userName);
        formData.add("password", password);
        return formData;
    }

}
