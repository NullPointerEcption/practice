package com.wyf.simple1;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2018-12-17 10:13
 **/
public class Consumer {

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
            //创建一个默认的消费者用来处理消息
            DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("CONSUMER get message from queue : " + message);
                }
            };
            //第二个参数表示自动确认
            channel.basicConsume(QUEUE_NAME, false, defaultConsumer);
            //保证代码执行不退出 不然会提前关闭channel导致收不到消息
            while (true) {
                TimeUnit.SECONDS.sleep(3L);
            }
        }
    }
}
