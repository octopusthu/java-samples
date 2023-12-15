package com.octopusthu.dev.samples.spring.cloud.stream.binders.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.binder.ConsumerProperties;
import org.springframework.cloud.stream.binder.ProducerProperties;
import org.springframework.cloud.stream.provisioning.ConsumerDestination;
import org.springframework.cloud.stream.provisioning.ProducerDestination;
import org.springframework.cloud.stream.provisioning.ProvisioningProvider;

@Slf4j
public class SampleBinderProvisioner
    implements ProvisioningProvider<ConsumerProperties, ProducerProperties> {

    @Override
    public ProducerDestination provisionProducerDestination(
        final String name, final ProducerProperties properties) {
        log.info("producer destination provisioned: " + name);
        return new SampleDestination(name);
    }

    @Override
    public ConsumerDestination provisionConsumerDestination(
        final String name, final String group, final ConsumerProperties properties) {
        log.info("consumer destination provisioned: " + name);
        return new SampleDestination(name);
    }

    private record SampleDestination(String destination) implements ProducerDestination, ConsumerDestination {
        @Override
        public String getName() {
            return destination.trim();
        }

        @Override
        public String getNameForPartition(int partition) {
            throw new UnsupportedOperationException("Partitioning is not implemented.");
        }
    }
}
