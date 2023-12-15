package com.octopusthu.dev.samples.spring.cloud.stream.binders.sample;

import org.springframework.cloud.stream.binder.Binder;
import org.springframework.cloud.stream.binder.ConsumerProperties;
import org.springframework.cloud.stream.binder.ProducerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;

@Configuration
public class SampleBinderConfiguration {
    @Bean
    public Binder<MessageChannel, ? extends ConsumerProperties, ? extends ProducerProperties> sampleCustomBinder(
        SampleBinderProvisioner provisioner) {
        return new SampleBinder(null, provisioner);
    }

    @Bean
    public SampleBinderProvisioner sampleBinderProvisioner() {
        return new SampleBinderProvisioner();
    }
}
