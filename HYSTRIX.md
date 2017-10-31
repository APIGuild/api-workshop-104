#### Hystrix Practice

- Add Hystrix dependencies
```
compile('org.springframework.cloud:spring-cloud-starter-hystrix')
```

- Enable the Circuit Breaker
```
@EnableCircuitBreaker
@SpringBootApplication
...
```

- Add @HystrixCommand and handle the HystrixRuntimeException
```
@HystrixCommand(fallbackMethod = "reliable")
public UserModel getUser(String userId) {
  ...
}

public UserModel reliable(String userId) {
    String info = format("User service is unavailable for now. Couldn't find the user: %s", userId);
    return new UserModel(userId, info);
}
```

- Config the HystrixProperty, e.g. groupName, threadPool, coreSize and timeout
```
@HystrixCommand(groupKey = "UserService", commandKey = "retrieveUser", threadPoolKey = "retrieveUser", fallbackMethod = "reliable")

# Option 1. Default Properties
hystrix.command.default.execution.isolation.strategy=THREAD
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=3000
hystrix.threadpool.default.coreSize=20

# Option 2. Specific Service Properties 
hystrix.command.retrieveUser.execution.isolation.thread.timeoutInMilliseconds=3000
hystrix.threadpool.retrieveUser.coreSize=20

# Option 3. Use Annotations
@HystrixCommand(commandProperties = { 
    @HystrixProperty( name="execution.isolation.thread.timeoutInMilliseconds", value="${xxx.xxx.timeout}")
})
```

For more details: https://github.com/Netflix/Hystrix/wiki/Configuration

#### Hystrix Dashboard

- Add the dependencies
```
compile('org.springframework.cloud:spring-cloud-starter-hystrix-dashboard')
```

It also needs to be enabled via annotating a `@Configuration` with `@EnableHystrixDashboard`

Restarting the application and hit [http://localhost:8080/order-service/hystrix](http://localhost:8080/order-service/hystrix).

Put the url `http://localhost:8080/order-service/hystrix.stream` into the Dashboard monitor and view the dashboard.

#### Hystrix and HTTP Connections
- Hystrix CoreSize, Connection MaxTotal and MaxPerRoute ?

- Hystrix Timeout, SocketTimeOut and ConnectionTimeout ?

- Best Practices

Checkout the code `com.guild.api.demo.util.rest.PooledRestTemplateBuilder.java` for more details.