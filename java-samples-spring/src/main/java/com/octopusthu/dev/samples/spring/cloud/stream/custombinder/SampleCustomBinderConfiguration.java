package com.octopusthu.dev.samples.spring.cloud.stream.custombinder;

import org.springframework.cloud.stream.binder.Binder;
import org.springframework.cloud.stream.binder.ConsumerProperties;
import org.springframework.cloud.stream.binder.ProducerProperties;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinder;
import org.springframework.cloud.stream.binder.test.TestChannelBinderProvisioner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;

@Configuration
public class SampleCustomBinderConfiguration {
    @Bean
    public InputDestination sourceDestination() {
        return new InputDestination();
    }

    @Bean
    public OutputDestination targetDestination() {
        return new OutputDestination();
    }

    @Bean
    public Binder<MessageChannel, ? extends ConsumerProperties, ? extends ProducerProperties> sampleCustomBinder(
        TestChannelBinderProvisioner provisioner) {
        return new TestChannelBinder(provisioner);
    }

    @Bean
    public TestChannelBinderProvisioner testChannelBinderProvisioner() {
        return new TestChannelBinderProvisioner();
    }
}
