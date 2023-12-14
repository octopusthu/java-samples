package com.octopusthu.dev.samples.spring.cloud.stream.custombinder;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

public class DummyMessageHandler implements MessageHandler {
    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        System.out.println("Message handled: " + message);
    }
}
