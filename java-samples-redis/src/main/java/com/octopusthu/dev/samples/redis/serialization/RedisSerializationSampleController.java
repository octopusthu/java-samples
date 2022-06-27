package com.octopusthu.dev.samples.redis.serialization;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RequestMapping("/samples/redis")
@RestController
public class RedisSerializationSampleController {

    private final RedisTemplate<String, Object> redisTemplateWithJdkSerializer;

    private final static String REDIS_KEY_PREFIX = "REDIS_SERIALIZATION_SAMPLE:";
    private final static Duration REDIS_TIMEOUT = Duration.ofMinutes(5);

    public RedisSerializationSampleController(RedisTemplate<String, Object> redisTemplateWithJdkSerializer) {
        this.redisTemplateWithJdkSerializer = redisTemplateWithJdkSerializer;
    }

    @PutMapping("/object-without-uid")
    void putObjectWithoutSerialVersionUID() {
        ObjectWithoutSerialVersionUID o = new ObjectWithoutSerialVersionUID("fooValue");
        redisTemplateWithJdkSerializer.opsForValue().set(REDIS_KEY_PREFIX + "OBJECT_WITHOUT_UID", o, REDIS_TIMEOUT);
    }

    @GetMapping("/object-without-uid")
    ObjectWithoutSerialVersionUID getObjectWithoutSerialVersionUID() {
        return (ObjectWithoutSerialVersionUID) redisTemplateWithJdkSerializer.opsForValue().get(
            REDIS_KEY_PREFIX + "OBJECT_WITHOUT_UID");
    }
}
