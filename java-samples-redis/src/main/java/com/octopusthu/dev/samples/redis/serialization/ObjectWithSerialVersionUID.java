package com.octopusthu.dev.samples.redis.serialization;

import java.io.Serializable;

public class ObjectWithSerialVersionUID implements Serializable {

    private final String foo;

    private static final long serialVersionUID = 1L;

    public ObjectWithSerialVersionUID(String foo) {
        this.foo = foo;
    }
}
