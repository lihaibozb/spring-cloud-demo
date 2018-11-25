package com.cloud.demo.security;

import com.cloud.demo.domain.TUser;
import com.cloud.demo.service.IOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-20
 * @Description:
 */
public class DomainUserDetailsService implements UserDetailsService {

    @Autowired
    private IOAuth2UserService ioAuth2UserService;    // 账户数据操作接口

    /**
     * 根据用户名查找账户信息并返回用户信息实体
     *
     * @param username 用户名
     * @return 用于身份认证的 UserDetails 用户信息实体
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TUser paramUser = new TUser();
        paramUser.setUsername(username);
        TUser tUser = ioAuth2UserService.selectOne(paramUser);
        if (tUser != null) {
            return new User(tUser.getUsername(), tUser.getPassword(), AuthorityUtils.createAuthorityList(new String[0]));
        } else {
            throw new UsernameNotFoundException("用户[" + username + "]不存在");
        }
    }

}
