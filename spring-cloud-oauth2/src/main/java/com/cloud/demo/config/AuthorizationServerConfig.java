package com.cloud.demo.config;

import com.cloud.demo.security.DomainUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-19
 * @Description: 授权服务器配置
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;    // 认证管理器

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;  // redis连接工厂

    //@Value("${resource.id:spring-boot-application}")
    //private String resourceId;  // 资源id
    //
    //@Value("${access_token.validity_period:3600}")
    //private int accessTokenValiditySeconds = 3600;  //资源令牌验证过期时间

    /**
     * 令牌存储
     * @return redis令牌存储对象
     */
    @Bean
    public RedisTokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }
    //public TokenStore tokenStore() {
    //    return new JwtTokenStore(accessTokenConverter());
    //}

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(this.authenticationManager)
                .userDetailsService(new DomainUserDetailsService())
                .tokenStore(tokenStore());
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
                .scopes("xx")
                .secret("android")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
                .and()
                .withClient("webapp")
                .scopes("xx")
                .authorizedGrantTypes("implicit");
    }

    /**
     * Jwt资源令牌转换器
     * @return accessTokenConverter
     */
    //@Bean
    //public JwtAccessTokenConverter accessTokenConverter(){
    //    return new JwtAccessTokenConverter(){
    //
    //        /**
    //         * 重写增强token的方法
    //         * @param accessToken 资源令牌
    //         * @param authentication 认证
    //         * @return 增强的OAuth2AccessToken对象
    //         */
    //        @Override
    //        public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
    //
    //            String userName = authentication.getUserAuthentication().getName();
    //            User user = (User) authentication.getUserAuthentication().getPrincipal();
    //            Map<String,Object> infoMap = new HashMap<>();
    //            infoMap.put("userName",userName);
    //            infoMap.put("roles",user.getAuthorities());
    //            ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(infoMap);
    //            return super.enhance(accessToken, authentication);
    //        }
    //    };
    //}

}
