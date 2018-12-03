package com.cloud.demo.service;

import com.cloud.demo.dao.TUserMapper;
import com.cloud.demo.domain.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-19
 * @Description:
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public TUser selectByPrimaryKey(TUser tUser) {
        return tUserMapper.selectByPrimaryKey(tUser);
    }

    @Override
    public int insert(TUser tUser) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TUser tUser) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(TUser tUser) {
        return 0;
    }
}
