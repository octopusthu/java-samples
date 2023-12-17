package com.octopusthu.dev.samples.spring.cloud.stream.messaging;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class DummyMessagePayload<T> {
    private final String type;
    private final T payload;

    public DummyMessagePayload(String type, T payload) {
        this.type = type;
        this.payload = payload;
    }
}
