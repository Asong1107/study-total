package com.asong.rocketmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "ORDER_TOPIC",
        consumeMode = ConsumeMode.ORDERLY,
        consumerGroup = "springboot_consumer_group")
@Slf4j
public class MyConsumerTwo implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        // 处理消息的逻辑
        log.info("springboot_consumer_group --》消费者2 顺序消费消息: " + message);
    }
}
