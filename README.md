# Spring Boot Webservice Project

WSDL http://localhost:8080/employee/ws/employees.wsdl

## Running

```console
mvn clean package spring-boot:run
```

## Log Level

```console
curl -X "POST" "http://localhost:8080/actuators/loggers/" -H "Content-Type: application/json; charset=utf-8" -d $'{   "configuredLevel": "WARN" }'  
```


## Docker

### Build

```console
docker build -t spring-boot-webservice .
```

### Running

```console
docker run -p 5000:8080 spring-boot-webservice
```

## References

* https://spring.io/guides/gs/producing-web-service/
* actuators: https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html
