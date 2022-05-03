package com.example.rabbitmq.Rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MessageConsumer {


    public MessageConsumer() throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection(MessagingConfig.CONNECTION_URL);
        Channel channel = connection.createChannel();
        DeliverCallback deliverCallback = (string, delivery) -> {
            System.out.println("Message Received");
        };
        CancelCallback cancelCallback = string -> {
            System.out.println("Message Not Received");
        };
        channel.basicConsume(MessagingConfig.LISTEN_QUEUE, true, deliverCallback, cancelCallback);
    }
}
