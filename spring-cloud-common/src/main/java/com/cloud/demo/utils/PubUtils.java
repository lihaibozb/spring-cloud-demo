package com.cloud.demo.utils;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-20
 * @Description: 共用类
 */
public class PubUtils {

    public interface OAuth{
        String TOKEN_TYPE_ACCESS="access_token";
        String TOKEN_TYPE_JWT="jwt_token";
        String TOKEN_JWT_KEY="test-secret";
    }

}
