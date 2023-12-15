package com.octopusthu.dev.samples.spring.cloud.stream.binders.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.provisioning.ProducerDestination;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@Slf4j
public class BarMessageHandler implements MessageHandler {
    private final ProducerDestination destination;

    public BarMessageHandler(ProducerDestination destination) {
        this.destination = destination;
    }

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        log.info("Message " + message.getPayload() + "sent to destination: " + destination);
    }
}
