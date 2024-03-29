package com.octopusthu.dev.samples.spring.cloud.stream.binders.sample;

import com.octopusthu.dev.samples.spring.cloud.stream.messaging.BarMessagePayload;
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
        var payload = message.getPayload();
        if (!(payload instanceof BarMessagePayload barMessagePayload)) {
            throw new MessagingException("unsupported payload: " + payload);
        }
        log.info("Message " + barMessagePayload + " sent to destination: " + destination);
    }
}
