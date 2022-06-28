package com.octopusthu.dev.samples.redis.serialization;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RequestMapping("/samples/redis")
@RestController
public class RedisSerializationSampleController {

    private final RedisTemplate<String, Object> redisTemplateWithJdkSerializer;

    private final static String REDIS_KEY_PREFIX = "REDIS_SERIALIZATION_SAMPLE:";
    private final static Duration REDIS_TIMEOUT = Duration.ofMinutes(30);

    public RedisSerializationSampleController(RedisTemplate<String, Object> redisTemplateWithJdkSerializer) {
        this.redisTemplateWithJdkSerializer = redisTemplateWithJdkSerializer;
    }

    @PutMapping("/object")
    void put(@RequestParam boolean uid, @RequestParam(required = false) String foo) {
        foo = StringUtils.isNotBlank(foo) ? foo : "fooValue";
        Object o = uid ? new ObjectWithSerialVersionUID(foo) : new ObjectWithoutSerialVersionUID(foo);
        redisTemplateWithJdkSerializer.opsForValue().set(REDIS_KEY_PREFIX + o.getClass().getSimpleName(), o, REDIS_TIMEOUT);
    }

    @GetMapping("/object")
    Object get(@RequestParam boolean uid) {
        String classSimpleName = uid ? ObjectWithSerialVersionUID.class.getSimpleName()
            : ObjectWithoutSerialVersionUID.class.getSimpleName();
        Object o = redisTemplateWithJdkSerializer.opsForValue().get(REDIS_KEY_PREFIX + classSimpleName);
        return o;
    }

}
