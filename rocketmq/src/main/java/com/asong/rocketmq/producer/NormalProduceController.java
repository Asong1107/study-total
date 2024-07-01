package com.asong.rocketmq.producer;

import com.asong.rocketmq.producer.service.ProduceSendService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class NormalProduceController {
    @Resource
    private ProduceSendService produceSendService;


    @GetMapping("/test")
    public void test() {



        //Send messages orderly
       // rocketmqTemplate.syncSendOrderly("orderly_topic", msg, "hashkey");

        //rocketMQTemplate.destroy(); // notes:  once rocketMQTemplate be destroyed, you can not send any message again with this rocketMQTemplate

    }



}