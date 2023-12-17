package com.octopusthu.dev.samples.spring.cloud.stream.messaging;

public class FooMessagePayload extends DummyMessagePayload<String> {
    private static final String TYPE = "FOO";

    public FooMessagePayload(String payload) {
        super(TYPE, payload);
    }
}
