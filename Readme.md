# User Test Application

This is a Spring Boot 3 application that aggregates users from two PostgreSQL databases and exposes them via a REST API. The project also uses OpenAPI (Swagger) for API documentation.

---

## Features

- Connects to two PostgreSQL databases (`db1` and `db2`) using separate `DataSource`s.
- Aggregates user data from both databases.
- Exposes a single REST endpoint: `/users`.
- Uses Spring Boot JDBC (`JdbcTemplate`) for database access.
- Provides OpenAPI documentation via Swagger UI.

---

## Technologies

- Java 17
- Spring Boot 3.5.4
- Spring Web
- Spring JDBC
- PostgreSQL
- SpringDoc OpenAPI

---

## Project Structure
src
└─ main
├─ java/com/example/usertest
│ ├─ config
│ │ └─ DataSourceConfig.java
│ ├─ controller
│ │ └─ UserController.java
│ ├─ dto
│ │ └─ UserDto.java
│ ├─ repository
│ │ └─ impl
│ │ ├─ UserRepositoryDb1Impl.java
│ │ └─ UserRepositoryDb2Impl.java
│ └─ service
│ └─ UserService.java
└─ resources
├─ application.yml
---
- Use docker-compose up --build to start the application with both databases.
- if you want to use simple Dockerfile:
docker build -t user-test-app .

docker run -p 8080:8080 user-test-app

---
## OpenAPI / Swagger

- JSON spec: http://localhost:8080/v3/api-docs

- Swagger UI: http://localhost:8080/swagger-ui/index.html