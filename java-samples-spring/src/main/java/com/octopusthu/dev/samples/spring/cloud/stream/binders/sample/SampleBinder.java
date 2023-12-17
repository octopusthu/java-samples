package com.octopusthu.dev.samples.spring.cloud.stream.binders.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.binder.AbstractMessageChannelBinder;
import org.springframework.cloud.stream.binder.ConsumerProperties;
import org.springframework.cloud.stream.binder.ProducerProperties;
import org.springframework.cloud.stream.provisioning.ConsumerDestination;
import org.springframework.cloud.stream.provisioning.ProducerDestination;
import org.springframework.integration.core.MessageProducer;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Slf4j
public class SampleBinder extends
    AbstractMessageChannelBinder<ConsumerProperties, ProducerProperties, SampleBinderProvisioner> {

    public SampleBinder(String[] headersToEmbed, SampleBinderProvisioner provisioningProvider) {
        super(headersToEmbed, provisioningProvider);
    }

    @Override
    protected MessageHandler createProducerMessageHandler(
        ProducerDestination destination, ProducerProperties producerProperties, MessageChannel errorChannel) {
        MessageHandler messageHandler = null;
        if (destination.getName().startsWith("bar-")) {
            messageHandler = new BarMessageHandler(destination);
        } else if (destination.getName().startsWith("integer-")) {
            messageHandler = new IntegerMessageHandler(destination);
        }
        if (messageHandler == null) {
            throw new RuntimeException("Cannot create message handler with destination: " + destination);
        }
        log.info("producer message handler created with destination: " + destination.getName());
        return messageHandler;
    }

    @Override
    protected MessageProducer createConsumerEndpoint(
        ConsumerDestination destination, String group, ConsumerProperties properties) {
        MessageProducer messageProducer = null;
        if (destination.getName().startsWith("foo-")) {
            messageProducer = new FooMessageProducer(destination);
        } else if (destination.getName().startsWith("integer-")) {
            messageProducer = new IntegerMessageProducer(destination);
        }
        if (messageProducer == null) {
            throw new RuntimeException("Cannot create message producer with destination: " + destination);
        }
        log.info("consumer endpoint created with destination: " + destination);
        return messageProducer;
    }
}
