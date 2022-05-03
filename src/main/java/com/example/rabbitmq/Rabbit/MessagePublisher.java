package com.example.rabbitmq.Rabbit;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.utils.SerializationUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MessagePublisher {
    private final byte[] data;

    public MessagePublisher (Object message){
        this.data = SerializationUtils.serialize(message);
    }
    public void startConnection() throws Exception{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection(MessagingConfig.CONNECTION_URL);
        Channel channel = connection.createChannel();
        channel.queueDeclare(MessagingConfig.QUEUE, true, false, false, null);
        channel.basicPublish(MessagingConfig.EXCHANGE, MessagingConfig.QUEUE, null, data);
        System.out.println("Message sent! " + SerializationUtils.deserialize(this.data));
        channel.close();
        connection.close();
    }


}
