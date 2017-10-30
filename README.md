# API Capability Building Workshop - Latency and Fault Tolerance & Reactive Programming 

#### How to run the services

```
./gradlew :user-service:bootRun
./gradlew :logistics-service:bootRun
./gradlew :product-service:bootRun
./gradlew :order-service:bootRun
```

Install plugin in IntelliJ: `lombok`

Debug mode: `--debug-jvm`

#### How to start a continuous build

```
./gradlew build --continuous
```

## Workshop Steps

Please refer to the `com.guild.api.demo.service.OrderServiceImpl.java` and `com.guild.api.demo.XxxDao.java` in `order-service` module.

- [RxJava](RXJAVA.md)
- [Hystrix](HYSTRIX.md)


 


