# Rental Company Contract

## Prerequisites

* JDK 19
* This project uses Lombok, so enable annotation processing in your IDE

## Technology Stack
* Language: [`Java 19`](https://www.java.com/)
* Compilation: [`Maven`](https://maven.apache.org/)
* Framework: [`SpringBoot`](https://spring.io/projects/spring-boot)
* Database: [`H2`](http://h2database.com/)
* Entity Graph: [`JPA Entity Graph`](https://cosium.github.io/making-jpa-great-again/)
* Open API Documentation: [`springdoc-openapi`](https://springdoc.org/)
* Boilerplate code reducer: [`Lombok`](https://projectlombok.org/)
* Logging: [`SLF4J`](https://www.slf4j.org/)
* Tests:
  * Unit Testing: [`JUnit5`](https://junit.org/junit5/docs/current/user-guide/)
  * Mocking: [`Mockito`](https://site.mockito.org/)
  * Mutation: Testing [`PIT Mutation Testing`](https://pitest.org/)
  * Code Coverage: [`Jacoco`](https://www.jacoco.org)
  * Architecture Testing: [`ArchUnit`](https://www.archunit.org/)

## Running the application locally

```shell
mvn clean install -Dmaven.test.skip=true
mvn spring-boot:run -Dspring.profiles.active=default
```

## Running the tests locally

```shell
mvn -e clean install verify
```

## Available Endpoints

* Swagger UI: [`http://localhost:8040/swagger-ui.html`](http://localhost:8040/swagger-ui.html)
* H2 Console: [`http://localhost:8040/h2-console`](http://localhost:8040/h2-console)

## Schemas

```scheme
HttpResponseStatusDTO {
  timestamp     string($date-time)
  status        integer($int64)
  error         string
  message       string
  path          string
}
```

```scheme
ContractRequestDTO {
  bookingId*    integer($int32)
}
```

```scheme
ContractResponseDTO {
  id            integer($int32)
  bookingId     integer($int32)
  status        string
                Enum: [ PENDING, ON_GOING, CONCLUDED, CANCELED ]
  created       string($date-time)
  updated       string($date-time)
}
```

## Contracts

### 1. Get all contract
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8040
Path: /v1/contract
Method: GET
Headers:
  Accept: application/json
  Authorization: Basic dXNlcjoxMjM=
  Content-Type: application/json
```

Response
```yaml
Status Code: 200
Status Description: OK
Body: [
  {
    "id": 0,
    "bookingId": 0,
    "status": "string",
    "created": "2023-01-01T00:00:00.000Z",
    "updated": "2023-01-01T00:00:00.000Z"
  }
]
```
<br>

### 2. Get a contract by id
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8040
Path: /v1/contract/{id}
Method: GET
Headers:
  Accept: application/json
  Authorization: Basic dXNlcjoxMjM=
  Content-Type: application/json
```

Response
```yaml
Status Code: 200
Status Description: OK
Body: {
  "id": 0,
  "bookingId": 0,
  "status": "string",
  "created": "2023-01-01T00:00:00.000Z",
  "updated": "2023-01-01T00:00:00.000Z"
}
```
<br>

### 3. Get a contract by bookingId
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8040
Path: /v1/contract/booking/{bookingId}
Method: GET
Headers:
  Accept: application/json
  Authorization: Basic dXNlcjoxMjM=
  Content-Type: application/json
```

Response
```yaml
Status Code: 200
Status Description: OK
Body: {
  "id": 0,
  "bookingId": 0,
  "status": "string",
  "created": "2023-01-01T00:00:00.000Z",
  "updated": "2023-01-01T00:00:00.000Z"
}
```
<br>

### 4. Create a contract
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8040
Path: /v1/contract
Method: POST
Headers:
  Accept: application/json
  Authorization: Basic dXNlcjoxMjM=
  Content-Type: application/json
Body: {
  "bookingId": 0
}
```

Response
```yaml
Status Code: 200
Status Description: OK
Body: {
  "id": 0,
  "bookingId": 0,
  "status": "string",
  "created": "2023-01-01T00:00:00.000Z",
  "updated": "2023-01-01T00:00:00.000Z"
}
```
<br>

### 5. Cancel a contract by id
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8040
Path: /v1/contract/{id}
Method: DELETE
Headers:
  Accept: application/json
  Authorization: Basic dXNlcjoxMjM=
  Content-Type: application/json
```

Response
```yaml
Status Code: 200
Status Description: OK
Body: {
  "id": 0,
  "name": "string",
  "cpf": "string",
  "cnh": "string",
  "birthDate": "2023-01-01T00:00:00.000Z",
  "email": "string",
  "phone": "string",
  "automobileId": 0,
  "insuranceTypeId": 0,
  "addressId": 0,
  "customerId": 0,
  "contractPeriod": 0,
  "status": "string",
  "created": "2023-01-01T00:00:00.000Z",
  "updated": "2023-01-01T00:00:00.000Z"
}
```
<br>

### Exception Responses
```yaml
Status Code: 400
Status Description: Bad Request
Body: {
  "timestamp": "2023-01-01T00:00:00.000Z",
  "status": 0,
  "error": "string",
  "message": "string",
  "path": "string"
}
```
```yaml
Status Code: 403
Status Description: Forbidden
Body: {
  "timestamp": "2023-01-01T00:00:00.000Z",
  "status": 0,
  "error": "string",
  "message": "string",
  "path": "string"
}
```
```yaml
Status Code: 409
Status Description: Conflict
Body: {
  "timestamp": "2023-01-01T00:00:00.000Z",
  "status": 0,
  "error": "string",
  "message": "string",
  "path": "string"
}
```
```yaml
Status Code: 422
Status Description: Unprocessable Entity
Body: {
  "timestamp": "2023-01-01T00:00:00.000Z",
  "status": 0,
  "error": "string",
  "message": "string",
  "path": "string"
}
```
```yaml
Status Code: 500
Status Description: Internal Server Error
Body: {
  "timestamp": "2023-01-01T00:00:00.000Z",
  "status": 0,
  "error": "string",
  "message": "string",
  "path": "string"
}
```