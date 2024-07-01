package com.asong.rocketmq.producer.service;

public interface ProduceSendService {

    void sendSyncMessage(String message);

    void sendSpringMessage(String message);

    void asyncSendMessage(String message);

    void sendReceiveMessage(String message);

    void sendTransactionMessage(String message);

    void sendOrderlyMessage(String message);

    void sendOneWayMessage(String message);
    void sendDelayMessage(String message);
}
