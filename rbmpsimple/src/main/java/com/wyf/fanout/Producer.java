package com.wyf.fanout;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2018-12-17 10:45
 **/
public class Producer {
    private static String exchange1 = "SIMPLE_EXCHANGE_NAME_1";
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel();) {
            channel.exchangeDeclare(exchange1, BuiltinExchangeType.FANOUT);
            String message = "Hello" + new Date(System.currentTimeMillis());
            // 发送消息到队列中
            channel.basicPublish(exchange1, "", null, message.getBytes("UTF-8"));
            Thread.sleep(1000);
            channel.basicPublish(exchange1, "", null, message.getBytes("UTF-8"));
            System.out.println("消息发送完成+" + message + "");
        } catch (TimeoutException | InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
