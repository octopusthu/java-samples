package com.octopusthu.dev.samples.spring.cloud.stream.messaging;

import org.springframework.messaging.Message;
import org.springframework.messaging.converter.AbstractMessageConverter;

public class BarMessageConverter extends AbstractMessageConverter {
    @Override
    protected boolean supports(Class<?> clazz) {
        return (BarMessagePayload.class.equals(clazz));
    }

    @Override
    protected Object convertFromInternal(Message<?> message, Class<?> targetClass, Object conversionHint) {
        Object payload = message.getPayload();
//        return (payload instanceof BarMessagePayload ? payload : new Bar((byte[]) payload));
        return payload;
    }
}
