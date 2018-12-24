package com.cloud.demo.config;

import com.cloud.demo.security.DomainUserDetailsService;
import com.cloud.demo.utils.PubUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.util.StringUtils;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-19
 * @Description: 授权服务器配置
 */
@Configuration
@RefreshScope
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * 认证管理器
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * redis连接工厂
     */
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Value("${tokenType}")
    private String tokenType;

    /**
     * 令牌存储
     *
     * @return redis令牌存储对象
     */
    @Bean
    public TokenStore tokenStore() {
        if (StringUtils.isEmpty(tokenType) || PubUtils.OAuth.TOKEN_TYPE_ACCESS.equals(tokenType)) {
            return new RedisTokenStore(redisConnectionFactory);
        } else {
            return new JwtTokenStore(accessTokenConverter());
        }
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(this.authenticationManager)
                .userDetailsService(new DomainUserDetailsService())
                .tokenStore(tokenStore());

        //如果为设置JWT token转换器
        if (PubUtils.OAuth.TOKEN_TYPE_JWT.equals(tokenType)) {
            endpoints.accessTokenConverter(accessTokenConverter());
        }
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("android")
                .scopes("all")
                .secret("android")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
                .and()
                .withClient("webapp")
                .scopes("all")
                .authorizedGrantTypes("implicit");
    }

    /**
     * Jwt资源令牌转换器
     *
     * @return accessTokenConverter
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(PubUtils.OAuth.TOKEN_JWT_KEY);
        return converter;
    }

}
