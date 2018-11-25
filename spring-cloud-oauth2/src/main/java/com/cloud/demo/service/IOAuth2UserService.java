package com.cloud.demo.service;

import com.cloud.demo.domain.TUser;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-19
 * @Description:
 */
public interface IOAuth2UserService {

    TUser selectOne(TUser tUser);

}
