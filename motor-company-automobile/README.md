# Motor Company Automobile

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

* Swagger UI: [`http://localhost:8020/swagger-ui.html`](http://localhost:8020/swagger-ui.html)
* H2 Console: [`http://localhost:8020/h2-console`](http://localhost:8020/h2-console)

## Schemas

```scheme
HttpResponseStatusDTO {
  timestamp           string($date-time)
  status              integer($int64)
  error               string
  message             string
  path                string
}
```

```scheme
AutomobileResponseDTO {
  id                  integer($int32)
  brand               string
                      Enum: [ TOYOTA, FERRARI, TESLA ]
  model               string
  created             string($date-time)
  updated             string($date-time)
}
```

```scheme
AutomobileDetailResponseDTO {
  id                  integer($int32)
  licensePlateNumber  string
  vehicleType         string
                      Enum: [ HATCH_BACK, SEDAN, SUV, MPV, TRUCK ]
  engineType          string
                      Enum: [ COMBUSTION, ELECTRIC, HYBRID ]
  fuelType            string
                      Enum: [ ALCOHOL, DIESEL, GAS, GASOLINE, ELECTRICITY ]
  created             string($date-time)
  updated             string($date-time)
}
```

## Contracts

### 1. Get all automobile
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8020
Path: /v1/automobile
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
    "brand": "string",
    "model": "string",
    "created": "2023-01-01T00:00:00.000Z",
    "updated": "2023-01-01T00:00:00.000Z"
  }
]
```
<br>

### 2. Get automobile's details by id
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8020
Path: /v1/automobile/{id}/detail
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
  "licensePlateNumber": "string",
  "brand": "string",
  "model": "string",
  "vehicleType": "string",
  "engineType": "string",
  "fuelType": "string",
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