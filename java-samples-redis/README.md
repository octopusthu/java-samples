# Java Redis Samples

## Serialization Sample

### Object without serialVersionUID declared

1. Start `RedisSerializationSampleApplication`
1. HTTP PUT `http://127.0.0.1:8080/samples/redis/object?uid=false`
1. Stop `RedisSerializationSampleApplication`
1. Modify `ObjectWithoutSerialVersionUID`
1. HTTP GET `http://127.0.0.1:8080/samples/redis/object?uid=false`
1. Deserialization failed

### Objects with serialVersionUID declared (compatible Class modification)

1. Start `RedisSerializationSampleApplication`
1. HTTP PUT `http://127.0.0.1:8080/samples/redis/object?uid=true`
1. Stop `RedisSerializationSampleApplication`
1. Modify `ObjectWithSerialVersionUID` (add a new field)
1. HTTP GET `http://127.0.0.1:8080/samples/redis/object?uid=true`
1. Deserialization successful

### Objects with serialVersionUID declared (incompatible Class modification)

1. Start `RedisSerializationSampleApplication`
1. HTTP PUT `http://127.0.0.1:8080/samples/redis/object?uid=true`
1. Stop `RedisSerializationSampleApplication`
1. Modify `ObjectWithSerialVersionUID` (Modify the type of an existing field)
1. HTTP GET `http://127.0.0.1:8080/samples/redis/object?uid=true`
1. Deserialization failed
