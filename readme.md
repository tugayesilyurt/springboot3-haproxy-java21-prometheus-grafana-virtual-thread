# Project Name

Spring Boot 3 -HAProxy-Prometheus-Grafana-Java 21 ( Virtual Thread and Platform Thread and String Template )

## Tech Stack

- Java 21
- Spring Boot 3
- HAProxy
- Prometheus
- Grafana
- Docker Compose

## Installation

```shell
docker-compose up -d
```

- `haproxy.cfg`

```
global
    maxconn     4000

defaults
    mode http
    timeout connect 5000
    timeout client 50000
    timeout server 50000

frontend stats
    bind *:4444
    mode http
    stats uri /
    stats show-legends
    stats enable
    stats auth tugay:tugay

frontend backend_service_listen
    bind *:1905
    default_backend backend_service

backend backend_service
    mode http
    option httpclose
    balance roundrobin
    server virtual-thread host.docker.internal:8091 check port 8091
    server platform-thread host.docker.internal:8090 check port 8090
```

- `Java 21 String Templates`

```java
	var threadName = Thread.currentThread().toString();

        var response = STR."""
                {
                   "thradName" :\{threadName}
                   "port" : "8091"
                   "applicationName" : "virtual-thread"
                }
                """;
```

- `Enable Virtual thread in Spring Boot Configuration`

```java
	@Bean
	TomcatProtocolHandlerCustomizer<?> protocolHandlerVirtualThreadExecutorCustomizer() {
		return protocolHandler -> {
			protocolHandler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
		};
	}
```

Apache Benchmark provides various options to control the benchmarking process.

Examples

Perform 100 requests to a website with a concurrency of 100:

```shell
# Platform Thread
ab -n 100 -c 100 http://localhost:1905/v1/api
```

