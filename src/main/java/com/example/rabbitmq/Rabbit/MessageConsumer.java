package com.example.rabbitmq.Rabbit;

import com.example.project.entity.Course;
import com.example.project.entity.MessageFilter;
import com.example.project.entity.Student;
import com.example.rabbitmq.Controller.Controller;
import com.rabbitmq.client.*;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.serializer.Serializer;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;
@Component
public class MessageConsumer {

    private transient Object object;

    public MessageConsumer() throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection(MessagingConfig.CONNECTION_URL);
        Channel channel = connection.createChannel();
        DeliverCallback deliverCallback = (string, delivery) -> {
            try {
                byte[] body = delivery.getBody();
                this.object = SerializationUtils.deserialize(body);
                MessageFilter msg = (MessageFilter)this.object;
                System.out.println("Message Received! " +msg.getAction());
                actionCenter(msg);

            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        CancelCallback cancelCallback = string -> {
            System.out.println("Message Not Received");
        };
        channel.basicConsume(MessagingConfig.LISTEN_QUEUE, true, deliverCallback, cancelCallback);
    }

    public void actionCenter(MessageFilter msg) throws Exception {
        switch (msg.getAction()){
            case "Returned Student":
                System.out.println("Student from database: " + msg.getObject());
                break;
            case "Returned Course":
                System.out.println("Course from database: " + msg.getObject());
                break;
            case "Returned Courses":
                System.out.println("Courses from database: " + msg.getObject());
                break;
            case "Returned Students":
                System.out.println("Students from database: " + msg.getObject());
                break;
            case "Returned Course By Title":
                System.out.println("Course from database: " + msg.getObject());
                break;
        }
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
