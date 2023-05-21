# events-gateway

### launch params

* KAFKA_BOOTSTRAP_SERVER=localhost:9092
* spring.profiles.active=prod
* may be GC props, for example: -XX:+UseParallelGC
* memory size: -Xms1g -Xmx1g
* spring.config.location or spring.config.additional-location if needed, dont forget classpath:/ if overridden

### health endpoint

/actuator/health