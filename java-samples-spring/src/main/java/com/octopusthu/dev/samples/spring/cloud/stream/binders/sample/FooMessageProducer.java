package com.octopusthu.dev.samples.spring.cloud.stream.binders.sample;

import com.octopusthu.dev.samples.spring.cloud.stream.messaging.FooMessagePayload;
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
        this.destination = destination;
    }

    @Override
    public void doStart() {
        testingReceive();
    }

    void testingReceive() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleWithFixedDelay(() -> {
            var foo = new FooMessagePayload(destination.getName(), String.valueOf(Utils.rand.nextInt(100)));
            var m = new GenericMessage<>(foo);
            sendMessage(m);
            log.info("Message " + m.getPayload() + "received from destination: " + destination);
        }, 0, 5, TimeUnit.SECONDS);
    }
}
