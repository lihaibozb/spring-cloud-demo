package com.cloud.demo.service;

import com.cloud.demo.domain.TAccount;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-13
 * @Description:
 */
public interface IBbService {
    TAccount select(TAccount tAccount);

    int insert(TAccount tAccount);

    int updateByPrimaryKey(TAccount tAccount);

    int deleteByPrimaryKey(TAccount tAccount);
}
