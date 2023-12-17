package com.octopusthu.dev.samples.spring.cloud.stream.messaging;

public class BarMessagePayload extends DummyMessagePayload<Integer> {
    private static final String TYPE = "BAR";

    public BarMessagePayload(int payload) {
        super(TYPE, payload);
    }
}
