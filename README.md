# springcloud
## 简介
springcloud + oauth2 + nginx + 前后端分离，网关API,API-doc,服务令牌颁发、登录鉴权,服务调用鉴权处理等；

## 分支信息
分支信息 | 内容
----|----
feature | access_token鉴权方式
develop | jwt_token鉴权方式 

## 项目结构
    
``` lua
spring-cloud-demo
├── config-repo -- springcloud-config 配置项git仓库
├── prepare -- 运行前准备
|    ├── html -- 前端资源
|    ├── nginx-config -- nginx配置
|    └── sql -- sql脚本
├── spring-cloud-api-gateway -- API网关[端口:5555]
├── spring-cloud-common -- 通用工具模块
├── spring-cloud-config -- 配置中心[端口:20000]
├── spring-cloud-database-generator -- tkmybatis通用mapper自动代码生成工具
├── spring-cloud-domain -- 实体对象模块
├── spring-cloud-eureka -- 服务注册中心
├── spring-cloud-oauth2 -- 令牌颁发、鉴权中心
├── spring-cloud-service-A -- microService[端口:11000] 
|    ├── com.cloud.demo.client -- 跨微服务调用接口
|    ├── com.cloud.demo.config -- 资源服务器、文档配置、feign拦截器
|    ├── com.cloud.demo.controller -- controller层
|    ├── com.cloud.demo.dao -- 通用mapper，dao层
|    ├── com.cloud.demo.hystrix -- 服务熔断配置
|    └── com.cloud.demo.service -- service层
├── spring-cloud-service-B -- microService[端口:12000] 
|    ├── com.cloud.demo.config -- 资源服务器、文档配置
|    ├── com.cloud.demo.controller -- controller层
|    ├── com.cloud.demo.dao -- 通用mapper，dao层
|    └── com.cloud.demo.service -- service层
└── spring-cloud-service-user -- microService[端口:13000] 
     ├── com.cloud.demo.config -- 资源服务器、文档配置
     ├── com.cloud.demo.controller -- 登录、用户controller层
     ├── com.cloud.demo.dao -- 通用mapper，dao层 
     └── com.cloud.demo.service -- service层
```

## 技术选型
### 后端技术
技术 | 名称 | 官网
----|------|----
SpringBoot | 服务端框架  | 
spring-cloud-starter-zuul | MVC框架  | API网关
spring-cloud-starter-oauth2 | 令牌颁发、鉴权 | 
spring-cloud-config-server | 配置中心  |
spring-cloud-starter-eureka-server | 服务注册中心  |
spring-cloud-starter-feign | 服务调用  |
spring-cloud-starter-hystrix | 熔断  |
mysql | 关系型数据库  | 
Redis | 分布式缓存数据库  | 
tkMyBatis | 通用ORM框架  | 
tkMyBatis Generator | 通用Mapper代码生成  | 
PageHelper | 分页插件  | 
Druid | 数据库连接池  | 
Swagger2 | 接口测试框架  | 
Log4J2 | 日志组件  |
Maven | 构建管理  |
nginx | 反向代理服务  | 

### 前端技术:
技术 | 名称 | 官网
----|------|----
bootstrap | UI框架  | 
jquery | js类库  | 

## 环境准备：
- Jdk8+ 
- Mysql5.6+
- Redis
- nginx
- maven

## 准备工作：


