package com.octopusthu.dev.samples.spring.cloud.stream.messaging;

public class BarMessagePayload extends DummyMessagePayload<String> {
    private static final String TYPE = "BAR";

    public BarMessagePayload(String payload) {
        super(TYPE, payload);
    }
}
