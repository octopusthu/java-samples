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
        log.info("producer message handler created with destination: " + destination.getName());
        return new BarMessageHandler(destination);
    }

    @Override
    protected MessageProducer createConsumerEndpoint(
        ConsumerDestination destination, String group, ConsumerProperties properties) {
        log.info("consumer endpoint created with destination: " + destination.getName());
        return new FooMessageProducer(destination);
    }
}
