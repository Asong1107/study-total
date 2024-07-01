package com.asong.rocketmq.producer.service.impl;

import com.alibaba.fastjson.JSON;
import com.asong.rocketmq.bean.OrderPaidEvent;
import com.asong.rocketmq.producer.service.ProduceSendService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQLocalRequestCallback;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class ProduceSendServiceImpl implements ProduceSendService {
    @Setter(onMethod_ = @Autowired)
    private RocketMQTemplate rocketmqTemplate;

    static final String TOPIC = "TestTopic";

    /**
     * 同步发送消息
     */
    @Override
    public void sendSyncMessage(String message) {
        Message<String> msg = MessageBuilder.withPayload(message).build();
        //send message synchronously
        SendResult sendResult = rocketmqTemplate.syncSend(TOPIC+":orderNo", msg);

        log.info("发送同步消息返回结果：{}", JSON.toJSONString(sendResult));

    }


    @Override
    public void sendSpringMessage(String message) {
        Message<String> msg = MessageBuilder.withPayload(message).build();
        rocketmqTemplate.send(TOPIC,msg);
    }


    @Override
    public void asyncSendMessage(String message) {
        rocketmqTemplate.asyncSend(TOPIC, new OrderPaidEvent("T_001", new BigDecimal("88.00")), new SendCallback() {
            @Override
            public void onSuccess(SendResult var1) {
                log.info("发送异步消息返回{}",JSON.toJSONString(var1));

            }

            @Override
            public void onException(Throwable var1) {
                log.info("发送异步消息错误{}",var1.getMessage());
            }

        });
    }
   // Send request in async mode and receive a reply of String type.
    @Override
    public void sendReceiveMessage(String message) {
        Message<String> msg = MessageBuilder.withPayload(message).build();
        rocketmqTemplate.sendAndReceive(TOPIC, msg, new RocketMQLocalRequestCallback<String>() {
            @Override
            public void onSuccess(String message) {
                log.info("发送成功，消费者消费成功:{}",message);
            }

            @Override
            public void onException(Throwable e) {
                log.info("消费者消费失败:{}",e.getMessage());
            }
        });
    }


    @Override
    public void sendTransactionMessage(String message) {
        Message<String> msg = MessageBuilder.withPayload(message).build();
        // In sendMessageInTransaction(), the first parameter transaction name ("test")
        // must be same with the @RocketMQTransactionListener's member field 'transName'
        rocketmqTemplate.sendMessageInTransaction(TOPIC, msg, null);
    }

    @Override
    public void sendOrderlyMessage(String message) {
        SendResult sendResult = rocketmqTemplate.syncSendOrderly("ORDER_TOPIC", message, "orderNo");
        log.info("发送顺序消息返回结果：{}", JSON.toJSONString(sendResult));
    }

    /**
     * 单向消息发送 这种方式主要用在不关心发送结果的场景 例如 日志发送
     * @param message
     */
    @Override
    public void sendOneWayMessage(String message) {
        rocketmqTemplate.sendOneWay("LOG_TOPIC", message);

    }

    @Override
    public void sendDelayMessage(String message) {
        Message<String> stringMessage = MessageBuilder.withPayload(message).build();
        rocketmqTemplate.syncSend("DELAY_TOPIC", stringMessage, 1000, 3);
    }
}
