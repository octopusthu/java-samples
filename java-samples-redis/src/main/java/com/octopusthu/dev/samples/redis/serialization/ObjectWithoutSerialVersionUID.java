package com.octopusthu.dev.samples.redis.serialization;

import java.io.Serializable;

public class ObjectWithoutSerialVersionUID implements Serializable {

    private final String foo;

    public ObjectWithoutSerialVersionUID(String foo) {
        this.foo = foo;
    }
}
