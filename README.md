# SpringCloud+SpringCloud Alibaba学习
> 开发规范: 约定 >配置  >编码

springcloud官网:https://spring.io/projects/spring-cloud

<img src="C:\Users\zheng\AppData\Roaming\Typora\typora-user-images\image-20210119104613777.png" alt="image-20210119104613777" style="zoom:50%;" />

## Eureka：



## consul:

下载地址:https://www.consul.io/downloads

启动命令：

```
consul agent -dev
```

页面查看：

```
http://localhost:8500/
```

## Rabbion:

1. rabbion + RestTemplate实现负载均衡
2. rabbion负载均衡原则：轮询(默认·)，随机，权重 。。。
3. 自定义负载均衡规则

## OpenFeign: 

https://spring.io/projects/spring-cloud-openfeign

```
//启用feign客户端
@EnableFeignClients

//定义feign客户端
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
```

1.消费者端集成Fegin实现负载均衡

2.配置服务超时时间,默认时间：1s

3.配置日志级别 

```
NONE:不记录任何信息
BASIC: 仅记录请求方法，url以及响应状态码和执行时间1
HEADERS:出记录basic级别的信息外，还会记录请求和响应的头信息
FULL:记录所有请求与响应的明细，包括头信息，请求头，元数据等
```

## Hystrix：

https://github.com/Netflix/Hystrix/wiki

### 1.服务降级

### 2.服务熔断

https://martinfowler.com/bliki/CircuitBreaker.html

`服务降级 ———>服务熔断———>恢复链路`

### 3.服务限流

hystrix dashboard:  实时监控Hystrix的各项指标信息

## Getway:

https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/#gateway-starter

<img src="C:\Users\zheng\AppData\Roaming\Typora\typora-user-images\image-20210119094518977.png" alt="image-20210119094518977" style="zoom: 50%;" />

### 1.route(路由)

静态路由配置：

```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: after_route
        uri: https://example.org
        predicates:
        - Cookie=mycookie,mycookievalue
```

动态路由配置：

```java
spring:
  application:
    name: cloud-getway-service
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true #开启注册中心路由功能，利用微服务进行路由转发
      routes:
        - id: provider
          uri: lb://cloud-provider-service
          predicates:
            - Path=/provider/payment/get/**
```

编码形式配置网关：

```
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("path_route", r -> r.path("/get")
				.uri("http://httpbin.org"))
			.route("host_route", r -> r.host("*.myhost.org")
				.uri("http://httpbin.org"))
			.route("rewrite_route", r -> r.host("*.rewrite.org")
				.filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/${segment}"))
				.uri("http://httpbin.org"))
			.route("hystrix_route", r -> r.host("*.hystrix.org")
				.filters(f -> f.hystrix(c -> c.setName("slowcmd")))
				.uri("http://httpbin.org"))
			.route("hystrix_fallback_route", r -> r.host("*.hystrixfallback.org")
				.filters(f -> f.hystrix(c ->               c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback")))
				.uri("http://httpbin.org"))
			.route("limit_route", r -> r
				.host("*.limited.org").and().path("/anything/**")
				.filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
				.uri("http://httpbin.org"))
			.build();
	}
```

### 2.predicate(断言)

 after: 匹配指定日期之后的请求（java ZoneDateTime）

before: 匹配指定日期之前的请求

between:匹配指定日期之间的请求

cookie: cookie具有给定名称且其值与正则表达式匹配

header:匹配具有给定名称的标头，该标头的值与正则表达式匹配

host：匹配主机名称

method:匹配http请求方法

path:匹配请求路径

query:匹配请求参数

remoteaddr:匹配IP地址

weight: 请求权重分配

```java
  - After=2017-01-20T17:42:47.789-07:00[America/Denver]  
  - Before=2017-01-20T17:42:47.789-07:00[America/Denver]
  - Between=2017-01-20T17:42:47.789-07:00[America/Denver], 2017-01-21T17:42:47.789-07:00[America/Denver]
  - Cookie=chocolate, ch.p
  - Header=X-Request-Id, \d+
  - Host=**.somehost.org,**.anotherhost.org
  - Method=GET,POST 
  - Path=/red/{segment},/blue/{segment}
  - Query=green
  - RemoteAddr=192.168.1.1/24
  - Weight=group1, 2
```

### 3.Filter（过滤器）

自定义全局过滤器

```java
@Component
@Slf4j
public class CustomFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入过滤器");
       return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        //过滤器权重
        return 0;
    }
}
```

## config+bus

手动刷新获取配置信息

```
curl -X POST "http://localhost:3366/actuator/refresh"
```

消息总线（rabbitMQ）刷新各节点配置信息：

```
curl -X POST  http://localhost:3344/actuator/bus-refresh
```

<img src="C:\Users\zheng\AppData\Roaming\Typora\typora-user-images\image-20210121102015303.png" alt="image-20210121102015303" style="zoom:50%;" />