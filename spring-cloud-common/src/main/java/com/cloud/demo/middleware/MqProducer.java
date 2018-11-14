package com.cloud.demo.middleware;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2018-11-14
 * @Description: 单例MQ生产者
 */
public class MqProducer {
    private DefaultMQProducer currentMQProducer;
    private static Map<String, MqProducer> producerMap = new ConcurrentHashMap<>(3);
    private static final Object lock = new Object();

    private MqProducer(String group) throws Exception {
        if (StringUtils.isEmpty(group)) {
            throw new NullPointerException("Group名称不能为空!");
        }

        currentMQProducer = new DefaultMQProducer(group);
        currentMQProducer.setNamesrvAddr("1.1.1.1");
        currentMQProducer.start();
    }

    public static MqProducer instance(String group) throws Exception {
        if (StringUtils.isEmpty(group)) {
            throw new NullPointerException("Group名称不能为空!");
        }

        if (producerMap.get(group) == null) {
            synchronized (lock) {
                if (producerMap.get(group) == null) {
                    producerMap.put(group, new MqProducer(group));
                }
            }
        }
        return producerMap.get(group);
    }

    public SendResult send(String topic, String tag, String body) throws Exception {
        if (StringUtils.isEmpty(topic) || StringUtils.isEmpty(tag) || StringUtils.isEmpty(body)) {
            throw new NullPointerException("请检查参数是否为空，topic，tag，body");
        }
        Message message = new Message(topic, tag, body.getBytes("UTF-8"));
        return currentMQProducer.send(message);
    }

    public static void shutdownAll() {
        producerMap.forEach((key, value) -> {
            value.shutdown();
        });
    }

    public void shutdown() {
        currentMQProducer.shutdown();
    }

}
