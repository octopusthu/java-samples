package com.octopusthu.dev.samples.spring.cloud.stream;

import com.octopusthu.dev.samples.spring.cloud.stream.messaging.BarMessagePayload;
import com.octopusthu.dev.samples.spring.cloud.stream.messaging.FooMessagePayload;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class SpringCloudStreamSampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamSampleApplication.class, args);
    }

    @Bean
    Function<FooMessagePayload, BarMessagePayload> fooToBar() {
        return m -> {
            var converted = new BarMessagePayload(m.getPayload());
            log.info("Message payload " + m + " converted to " + converted);
            return converted;
        };
    }

    @Bean
    Function<Integer, Integer> negate() {
        return n -> {
            var converted = -n;
            log.info("Integer payload " + n + " converted to " + converted);
            return converted;
        };
    }
}
