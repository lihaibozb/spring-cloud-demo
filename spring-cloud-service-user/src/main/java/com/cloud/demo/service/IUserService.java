package com.cloud.demo.service;

import com.cloud.demo.domain.TUser;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-19
 * @Description:
 */
public interface IUserService {

    TUser selectOne(TUser tUser);

    TUser selectByPrimaryKey(TUser tUser);

    int insert(TUser tUser);

    int updateByPrimaryKey(TUser tUser);

    int deleteByPrimaryKey(TUser tUser);
}
