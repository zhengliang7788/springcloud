# SpringCloud+SpringCloud Alibaba学习
> 开发规范: 约定 >配置  >编码

springcloud官网:https://spring.io/projects/spring-cloud

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

https://martinfowler.com/bliki/CircuitBreaker.html

1.服务降级



2.服务熔断

`服务降级 ———>服务熔断———>恢复链路`

3.服务限流