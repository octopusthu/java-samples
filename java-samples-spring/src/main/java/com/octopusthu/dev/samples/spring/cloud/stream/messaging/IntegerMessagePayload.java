package com.octopusthu.dev.samples.spring.cloud.stream.messaging;

public class IntegerMessagePayload extends DummyMessagePayload<Integer> {
    private static final String TYPE = "FOO";

    public IntegerMessagePayload(int payload) {
        super(TYPE, payload);
    }
}
