package com.octopusthu.dev.samples.spring.cloud.stream.messaging;

import lombok.ToString;

@ToString
public class BarMessagePayload extends DummyMessagePayload {
    private final String bar;

    public BarMessagePayload(String dummy, String bar) {
        super(dummy);
        this.bar = bar;
    }

    public String getBar() {
        return bar;
    }
}
