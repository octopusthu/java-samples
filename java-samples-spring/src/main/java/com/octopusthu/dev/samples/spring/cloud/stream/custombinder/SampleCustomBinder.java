package com.octopusthu.dev.samples.spring.cloud.stream.custombinder;

import org.springframework.cloud.stream.binder.AbstractMessageChannelBinder;
import org.springframework.cloud.stream.binder.ConsumerProperties;
import org.springframework.cloud.stream.binder.ProducerProperties;
import org.springframework.cloud.stream.provisioning.ConsumerDestination;
import org.springframework.cloud.stream.provisioning.ProducerDestination;
import org.springframework.integration.core.MessageProducer;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

public class SampleCustomBinder extends
    AbstractMessageChannelBinder<ConsumerProperties, ProducerProperties, SampleCustomBinderProvisioner> {

    public SampleCustomBinder(String[] headersToEmbed, SampleCustomBinderProvisioner provisioningProvider) {
        super(headersToEmbed, provisioningProvider);
    }

    @Override
    protected MessageHandler createProducerMessageHandler(
        ProducerDestination destination, ProducerProperties producerProperties, MessageChannel errorChannel) {
        return null;
    }

    @Override
    protected MessageProducer createConsumerEndpoint(
        ConsumerDestination destination, String group, ConsumerProperties properties) {
        return null;
    }
}
