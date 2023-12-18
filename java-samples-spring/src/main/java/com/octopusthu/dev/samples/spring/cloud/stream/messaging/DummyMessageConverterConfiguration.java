package com.octopusthu.dev.samples.spring.cloud.stream.messaging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DummyMessageConverterConfiguration {
    @Bean
    DummyMessagePayloadConverter dummyMessagePayloadConverter() {
        return new DummyMessagePayloadConverter();
    }
}
