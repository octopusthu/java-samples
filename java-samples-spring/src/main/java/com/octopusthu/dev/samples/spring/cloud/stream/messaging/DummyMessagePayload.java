package com.octopusthu.dev.samples.spring.cloud.stream.messaging;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cloud.function.context.config.JsonMessageConverter;

/**
 * Has to be a POJO to be converted by the default {@link JsonMessageConverter}.
 *
 * @param <T>
 */
@ToString
@Setter
@Getter
public class DummyMessagePayload<T> {
    private String type;
    private T payload;

    public DummyMessagePayload(String type, T payload) {
        this.type = type;
        this.payload = payload;
    }
}
