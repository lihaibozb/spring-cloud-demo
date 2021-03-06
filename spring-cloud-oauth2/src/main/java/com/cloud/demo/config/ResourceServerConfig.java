package com.cloud.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-19
 * @Description: 资源服务配置
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 访问下面路径无需Token认证
                .antMatchers("/**/v2/api-docs")
                .permitAll()
                // 除了上面配置的路径都需要Token认证
                .anyRequest()
                .authenticated()
                .and()
                // 暂时禁用CSRF，否则无法提交表单
                .csrf().disable();
    }

}
