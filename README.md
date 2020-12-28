# SpringCloud+SpringCloud Alibaba学习
> 开发规范: 约定 >配置  >编码

springcloud官网:https://spring.io/projects/spring-cloud

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
2. rabbion负载均衡原则：轮询，随机，权重 。。。

## OpenFeign: https://spring.io/projects/spring-cloud-openfeign

1.消费者端集成Fegin实现负载均衡

2.配置服务超时时间,默认时间：1s

3.配置日志级别 

```
NONE,BASIC,HEADERS,FULL;
```