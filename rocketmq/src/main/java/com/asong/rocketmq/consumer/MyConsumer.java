package com.asong.rocketmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 只消费指定tag消息
 */
@Component
@RocketMQMessageListener(topic = "TestTopic",
        selectorType = SelectorType.TAG,
        selectorExpression = "orderNo",
        consumerGroup = "springboot_consumer_group")
@Slf4j
public class MyConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        // 处理消息的逻辑
        log.info("springboot_consumer_group --》消费者1 消费消息: " + message);
    }
}