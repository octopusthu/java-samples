package com.octopusthu.dev.samples.spring.cloud.stream.binders.sample;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.provisioning.ConsumerDestination;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.messaging.support.GenericMessage;

@Slf4j
public class IntegerMessageProducer extends MessageProducerSupport {
    private final ConsumerDestination destination;

    public IntegerMessageProducer(ConsumerDestination destination) {
        if (!destination.getName().startsWith("integer-")) {
            throw new IllegalArgumentException("illegal destination");
        }
        this.destination = destination;
    }

    @Override
    public void doStart() {
        testingReceive();
    }

    void testingReceive() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleWithFixedDelay(() -> {
            var m = new GenericMessage<>(Utils.rand.nextInt(1000));
            log.info("Message " + m + "received from destination: " + destination);
            try {
                sendMessage(m);
            } catch (Exception e) {
                log.warn("Failed to send message: " + m, e);
            }
        }, 0, 5, TimeUnit.SECONDS);
    }
}
