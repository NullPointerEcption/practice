package com.wyf.simple1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2018-12-17 10:05
 **/
public class Producer {
    /**
     * 队列的名称
     */
    public static final String QUEUE_NAME = "SIMPLE_QUEUE_NAME_1";

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        try (Connection connection = connectionFactory.newConnection();
             Channel channel = connection.createChannel();) {
            //确保创建队列
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            //发送消息到队列中
            while (true) {
                channel.basicPublish("", QUEUE_NAME, null, ("HELLO TEST " + LocalDateTime.now()).getBytes("UTF-8"));
                System.out.println("PRODUCER send message ok,send message again after three seconds later !");
                TimeUnit.SECONDS.sleep(5L);
            }
        }
    }
}
