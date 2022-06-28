package com.octopusthu.dev.samples.redis.serialization;

import java.io.Serializable;

public class ObjectWithoutSerialVersionUID implements Serializable {

    private final String foo;
//    private String bar;

    public ObjectWithoutSerialVersionUID(String foo) {
        this.foo = foo;
    }
}
