package com.octopusthu.dev.samples.spring.cloud.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;

@SpringBootTest(classes = SpringCloudStreamSampleApplication.class)
public class SpringCloudStreamSampleApplicationTests {
    @Autowired
    private InputDestination input;

    @Autowired
    private OutputDestination output;
}
