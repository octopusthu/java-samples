package com.octopusthu.dev.samples.spring.cloud.stream.binders.sample;

import com.octopusthu.dev.samples.spring.cloud.stream.messaging.FooMessagePayload;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.provisioning.ConsumerDestination;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.messaging.support.GenericMessage;

@Slf4j
public class FooMessageProducer extends MessageProducerSupport {
    private final ConsumerDestination destination;

    public FooMessageProducer(ConsumerDestination destination) {
        if (!destination.getName().startsWith("foo-")) {
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
            var foo = new FooMessagePayload(UUID.randomUUID().toString().substring(0, 5));
            var m = new GenericMessage<>(foo);
            log.info("Message " + m + "received from destination: " + destination);
            try {
                sendMessage(m);
            } catch (Exception e) {
                log.warn("Failed to send message: " + m, e);
            }
        }, 0, 5, TimeUnit.SECONDS);
    }
}
