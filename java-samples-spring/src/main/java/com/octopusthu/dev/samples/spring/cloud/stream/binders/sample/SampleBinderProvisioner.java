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
        var d = new SampleDestination(name, null);
        log.info("producer destination provisioned: " + d);
        return d;
    }

    @Override
    public ConsumerDestination provisionConsumerDestination(
        final String name, final String group, final ConsumerProperties properties) {
        var d = new SampleDestination(name, group);
        log.info("consumer destination provisioned: " + d);
        return d;
    }

    private record SampleDestination(String destination, String group) implements ProducerDestination,
        ConsumerDestination {
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
