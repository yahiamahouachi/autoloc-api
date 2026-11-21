# AutoLoc - Monitoring Notes

## 1. Monitoring Architecture

AutoLoc uses Spring Boot Actuator, Micrometer,
Prometheus, Grafana, and Docker Compose.

- Spring Boot Actuator exposes application metrics.
- Micrometer exports metrics in Prometheus format.
- Prometheus collects metrics every 5 seconds.
- Grafana visualizes the collected metrics.
- Docker Compose runs Prometheus and Grafana.

## 2. Monitoring Endpoints

Health endpoint:
http://localhost:8080/actuator/health

Prometheus metrics endpoint:
http://localhost:8080/actuator/prometheus

Prometheus:
http://localhost:9090

Grafana:
http://localhost:3000

## 3. Grafana Dashboard

Dashboard name: AutoLoc Monitoring Dashboard

The dashboard contains four panels:

1. CPU Usage (%)
   Query: process_cpu_usage * 100

2. JVM Memory Usage (MB)
   Query:
   sum(jvm_memory_used_bytes{area="heap"}) / 1024 / 1024

3. HTTP Requests per Second
   Query:
   sum(rate(http_server_requests_seconds_count[1m]))

4. JVM Live Threads
   Query: jvm_threads_live_threads

## 4. Docker Commands

Start monitoring containers:
docker compose up -d

Check container status:
docker compose ps

Stop monitoring containers:
docker compose down

## 5. Verification

- Docker containers started successfully.
- Prometheus target autoloc-api showed UP.
- Grafana connected successfully to Prometheus.
- All four dashboard panels displayed metrics.

## 6. Security

Spring Security allows local monitoring access to
/actuator/health and /actuator/prometheus.

In production, these endpoints should be protected
from unauthorized access.
