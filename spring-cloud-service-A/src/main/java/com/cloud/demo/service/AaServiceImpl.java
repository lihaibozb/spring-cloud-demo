package com.cloud.demo.service;

import com.cloud.demo.dao.TAccountMapper;
import com.cloud.demo.domain.TAccount;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
    public PageInfo<TAccount> selectAll(int pageNum, int pageSize) {
        Example example = new Example(TAccount.class);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<TAccount> pageInfo = new PageInfo<>(tAccountMapper.selectByExample(example));
        return pageInfo;
    }

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
