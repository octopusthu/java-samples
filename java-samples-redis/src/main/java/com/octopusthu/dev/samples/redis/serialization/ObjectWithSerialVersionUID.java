package com.octopusthu.dev.samples.redis.serialization;

import java.io.Serial;
import java.io.Serializable;

public class ObjectWithSerialVersionUID implements Serializable {

    private String foo;
    //    private String bar="barValue";
//    private Integer bar = 1;

    @Serial
    private static final long serialVersionUID = 1L;

    public ObjectWithSerialVersionUID(String foo) {
        this.foo = foo;
    }

//    public ObjectWithSerialVersionUID(String bar) {
//        this.bar = bar;
//    }

//    public ObjectWithSerialVersionUID(String foo, String bar) {
//        this.foo = foo;
//        this.bar = bar;
//    }

}
