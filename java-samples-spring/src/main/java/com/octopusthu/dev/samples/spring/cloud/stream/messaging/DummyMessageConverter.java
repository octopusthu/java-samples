package com.octopusthu.dev.samples.spring.cloud.stream.messaging;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.AbstractMessageConverter;

public class DummyMessageConverter extends AbstractMessageConverter {
    @Override
    protected boolean supports(Class<?> clazz) {
        return (DummyMessagePayload.class.isAssignableFrom(clazz));
    }

    @Override
    protected Object convertFromInternal(Message<?> message, Class<?> targetClass, Object conversionHint) {
        return message.getPayload();
    }

    @Override
    protected Object convertToInternal(Object payload, MessageHeaders headers, Object conversionHint) {
        return payload;
    }
}
