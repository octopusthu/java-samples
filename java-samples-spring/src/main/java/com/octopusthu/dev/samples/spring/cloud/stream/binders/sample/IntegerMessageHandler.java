package com.octopusthu.dev.samples.spring.cloud.stream.binders.sample;

import com.octopusthu.dev.samples.spring.cloud.stream.messaging.IntegerMessagePayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.provisioning.ProducerDestination;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@Slf4j
public class IntegerMessageHandler implements MessageHandler {
    private final ProducerDestination destination;

    public IntegerMessageHandler(ProducerDestination destination) {
        this.destination = destination;
    }

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        var payload = message.getPayload();
        if (!(payload instanceof IntegerMessagePayload integerMessagePayload)) {
            throw new MessagingException("unsupported payload: " + payload);
        }
        log.info("Message " + integerMessagePayload + " sent to destination: " + destination);
    }
}
