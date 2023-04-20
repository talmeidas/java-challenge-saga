# Rental Company Booking

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

* Swagger UI: [`http://localhost:8030/swagger-ui.html`](http://localhost:8030/swagger-ui.html)
* H2 Console: [`http://localhost:8030/h2-console`](http://localhost:8030/h2-console)

## Schemas

```scheme
HttpResponseStatusDTO {
  timestamp         string($date-time)
  status            integer($int64)
  error             string
  message           string
  path              string
}
```

```scheme
BookingRequestDTO {
  name*             string
                    maxLength: 2147483647
                    minLength: 3
  cpf*              string
  cnh*              string
                    maxLength: 11
                    minLength: 11
  birthDate*        string($date-time)
  email*            string
  phone*            string
                    maxLength: 11
                    minLength: 10
  automobileId*     integer($int32)
  insuranceTypeId*  integer($int32)
  addressId*        integer($int32)
  customerId        integer($int32)
  contractPeriod*   integer($int32)
}
```

```scheme
BookingResponseDTO {
  id                integer($int32)
  name              string
  cpf               string
  cnh               string
  birthDate         string($date-time)
  email             string
  phone             string
  automobileId      integer($int32)
  insuranceTypeId   integer($int32)
  addressId         integer($int32)
  customerId        integer($int32)
  contractPeriod    integer($int32)
  status            string
                    Enum: [ PENDING, ON_GOING, CONCLUDED, CANCELED ]
  created           string($date-time)
  updated           string($date-time)
}
```

## Contracts

### 1. Get all booking
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8030
Path: /v1/booking
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
]
```
<br>

### 2. Get a booking by id
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8030
Path: /v1/booking/{id}
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

### 3. Get a booking by cnh
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8030
Path: /v1/booking/customer/{cnh}
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
]
```
<br>

### 4. Create a booking
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8030
Path: /v1/booking
Method: POST
Headers:
  Accept: application/json
  Authorization: Basic dXNlcjoxMjM=
  Content-Type: application/json
Body: {
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
  "contractPeriod": 0
}
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

### 5. Update a booking
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8030
Path: /v1/booking/{id}
Method: PUT
Headers:
  Accept: application/json
  Authorization: Basic dXNlcjoxMjM=
  Content-Type: application/json
Body: {
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
  "contractPeriod": 0
}
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

### 6. Cancel a booking by id
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8030
Path: /v1/booking/{id}
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