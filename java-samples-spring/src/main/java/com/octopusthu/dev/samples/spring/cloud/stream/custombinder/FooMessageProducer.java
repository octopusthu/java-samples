package com.octopusthu.dev.samples.spring.cloud.stream.custombinder;

import com.octopusthu.dev.samples.spring.cloud.stream.messaging.FooMessagePayload;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.springframework.cloud.stream.provisioning.ConsumerDestination;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.messaging.support.GenericMessage;

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
        try (ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1)) {
            executorService.scheduleWithFixedDelay(() -> {
                var foo = new FooMessagePayload(
                    String.valueOf(Utils.rand.nextInt(100)), String.valueOf(Utils.rand.nextInt(100)));
                var m = new GenericMessage<>(foo);
                sendMessage(m);
            }, 0, 5, TimeUnit.SECONDS);
        }
    }
}
