package com.octopusthu.dev.samples.spring.cloud.stream.messaging;

public class DummyMessagePayload {
    private final String dummy;

    public DummyMessagePayload(String dummy) {
        this.dummy = dummy;
    }

    public String getDummy() {
        return dummy;
    }
}
