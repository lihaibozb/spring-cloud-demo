package com.cloud.demo.service;

import com.cloud.demo.domain.TAccount;
import com.github.pagehelper.PageInfo;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-13
 * @Description:
 */
public interface IAaService {

    PageInfo<TAccount> selectAll(int pageNum, int pageSize);

    TAccount selectByPrimaryKey(TAccount tAccount);

    int insert(TAccount tAccount);

    int updateByPrimaryKey(TAccount tAccount);

    int deleteByPrimaryKey(TAccount tAccount);
}
