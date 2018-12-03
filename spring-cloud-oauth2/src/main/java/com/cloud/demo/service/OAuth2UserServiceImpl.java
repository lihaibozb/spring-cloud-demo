package com.cloud.demo.service;

import com.cloud.demo.dao.TUserMapper;
import com.cloud.demo.domain.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-19
 * @Description:
 */
@Service
public class OAuth2UserServiceImpl implements IOAuth2UserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public TUser selectOne(TUser tUser) {
        return tUserMapper.selectOne(tUser);
    }

}
