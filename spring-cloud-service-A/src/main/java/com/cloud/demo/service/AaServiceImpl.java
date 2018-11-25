package com.cloud.demo.service;

import com.cloud.demo.dao.TAccountMapper;
import com.cloud.demo.domain.TAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-13
 * @Description:
 */
@Service
public class AaServiceImpl implements IAaService {
    private static final Logger logger = LoggerFactory.getLogger(AaServiceImpl.class);

    @Autowired
    private TAccountMapper tAccountMapper;

    @Override
    public TAccount selectByPrimaryKey(TAccount tAccount){
        return tAccountMapper.selectByPrimaryKey(tAccount);
    }

    @Override
    public int insert(TAccount tAccount){
        return tAccountMapper.insert(tAccount);
    }

    @Override
    public int updateByPrimaryKey(TAccount tAccount){
        return tAccountMapper.updateByPrimaryKey(tAccount);
    }

    @Override
    public int deleteByPrimaryKey(TAccount tAccount){
        return tAccountMapper.deleteByPrimaryKey(tAccount);
    }
}
