package com.asong.rocketmq;

import com.asong.rocketmq.producer.service.ProduceSendService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RocketmqApplication.class)
class RocketmqApplicationTests {

    @Resource
    private ProduceSendService produceSendService;
    @Test
    void contextLoads() {

        for (int i = 0; i < 10; i++) {
            produceSendService.sendOrderlyMessage("顺序消息："+i);
        }


/*        produceSendService.sendReceiveMessage("这个是发送的消费者request消息");

        produceSendService.sendSpringMessage("这个是发送的消费者spring消息");

        produceSendService.asyncSendMessage("这个是发送的消费者异步消息");

        while (true){

        }*/
    }

}
