package com.octopusthu.dev.samples.spring.cloud.stream.messaging;

public class FooMessagePayload extends DummyMessagePayload {
    private final String foo;

    public FooMessagePayload(String dummy, String foo) {
        super(dummy);
        this.foo = foo;
    }

    public String getFoo() {
        return foo;
    }
}
