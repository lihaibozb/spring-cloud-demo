# spring-cloud-demo
# 1.多实例启动：server-a
cd /Users/lihaibo/IdeaProjects/study_project/spring-cloud-demo/spring-cloud-service-A/target
java -jar spring-cloud-service-A-1.0.0-SNAPSHOT.jar --server.port=10011
java -jar spring-cloud-service-A-1.0.0-SNAPSHOT.jar --server.port=10012

# REST API设计参考
Get /v1/users #获取所有用户
Get /v1/users/1 #获取id为1的用户信息(记得返回值去掉敏感信息)
Get /v1/users?departmentId=1 #获取部门id为1的用户
Get /v1/users?offset=0&limit=20 #分页获取20个用户
GET /v1/users/1/orders #获取id为1的用户拥有的订单
POST /v1/users #新建一个用户
PUT /v1/users/1 #修改id为1的用户信息
DELETE /v1/users/1 #删除id为1的用户

# 消息总线TODO
消息总成，动态刷新配置，有空再看，目前Spring Cloud Bus 支持 RabbitMQ 和 Kafka，spring-cloud-starter-bus-amqp 、spring-cloud-starter-bus-kafka
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>