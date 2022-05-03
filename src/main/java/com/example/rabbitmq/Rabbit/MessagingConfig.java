package com.example.rabbitmq.Rabbit;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    public static final String QUEUE = "client_queue";
    public static final String EXCHANGE = "client_queue";
    public static final String ROUTING_KEY = "client_queue";
    public static final String CONNECTION_URL = "amqp://guest@127.0.0.1:5672/";

    public static final String LISTEN_QUEUE = "project_queue";

}
