package com.octopusthu.dev.samples.spring.cloud.stream.messaging;

public class FooMessagePayload extends DummyMessagePayload<Integer> {
    private static final String TYPE = "FOO";

    public FooMessagePayload(int payload) {
        super(TYPE, payload);
    }

}
