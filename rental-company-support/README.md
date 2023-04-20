# Rental Company Support

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

* Swagger UI: [`http://localhost:8050/swagger-ui.html`](http://localhost:8050/swagger-ui.html)
* H2 Console: [`http://localhost:8050/h2-console`](http://localhost:8050/h2-console)

## Schemas

```scheme
HttpResponseStatusDTO {
  timestamp       string($date-time)
  status          integer($int64)
  error           string
  message         string
  path            string
}
```

```scheme
CustomerSupportRequestDTO {
  name*           string
                  maxLength: 2147483647
                  minLength: 3
  cpf*            string
  cnh*            string
                  maxLength: 11
                  minLength: 11
  birthDate*      string($date-time)
  email*          string
  phone*          string
                  maxLength: 11
                  minLength: 10
  bookingId*      integer($int32)
  messageReason*  string
                  Enum: [ PRAISE, INFORMATION, COMPLAINT, REQUEST ]
  message*        string
                  maxLength: 2147483647
                  minLength: 50
}
```

```scheme
CustomerSupportResponseDTO {
  id              integer($int32)
  name            string
                  maxLength: 2147483647
                  minLength: 3
  cpf             string
  cnh             string
                  maxLength: 11
                  minLength: 11
  birthDate       string($date-time)
  email           string
  phone           string
                  maxLength: 11
                  minLength: 10
  bookingId       integer($int32)
  attendantName   string
  messageReason   string
                  Enum: [ PRAISE, INFORMATION, COMPLAINT, REQUEST ]
  message         string
  status          string
                  Enum: [ PENDING, ON_GOING, CONCLUDED, CANCELED ]
  created         string($date-time)
  updated         string($date-time)
}
```

```scheme
AddressResponseDTO {
  id	          integer($int32)
  address         string
  number          integer($int32)
  city	          string
  state	          string
                  Enum: [ AM, AL, AC, AP, BA, PA, MT, MG, MS, GO, MA, RS, TO, PI, SP, RO, RR, PR, CE, PE, SC, PB, RN, ES, RJ, SE, DF ]
  country         string
                  Enum: [ BRASIL ]
  zipCode         integer($int32)
  created         string($date-time)
  updated         string($date-time)
}
```

## Contracts

### 1. Get all customer support
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8050
Path: /v1/customer-support
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
    "bookingId": 0,
    "attendantName": "string",
    "messageReason": "string",
    "message": "string",
    "status": "string",
    "created": "2023-01-01T00:00:00.000Z",
    "updated": "2023-01-01T00:00:00.000Z"
  }
]
```
<br>

### 2. Get a customer support by support id
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8050
Path: /v1/customer-support/{id}
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
  "bookingId": 0,
  "attendantName": "string",
  "messageReason": "string",
  "message": "string",
  "status": "string",
  "created": "2023-01-01T00:00:00.000Z",
  "updated": "2023-01-01T00:00:00.000Z"
}
```
<br>

### 3. Get a customer support by cnh
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8050
Path: /v1/customer-support/customer/{cnh}
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
    "bookingId": 0,
    "attendantName": "string",
    "messageReason": "string",
    "message": "string",
    "status": "string",
    "created": "2023-01-01T00:00:00.000Z",
    "updated": "2023-01-01T00:00:00.000Z"
  }
]
```
<br>

### 4. Create a customer support
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8050
Path: /v1/customer-support
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
  "bookingId": 0,
  "messageReason": "string",
  "message": "string"
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
  "bookingId": 0,
  "attendantName": "string",
  "messageReason": "string",
  "message": "string",
  "status": "string",
  "created": "2023-01-01T00:00:00.000Z",
  "updated": "2023-01-01T00:00:00.000Z"
}
```
<br>

### 5. Cancel a customer support by support id
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8050
Path: /v1/customer-support/{id}
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
  "bookingId": 0,
  "attendantName": "string",
  "messageReason": "string",
  "message": "string",
  "status": "string",
  "created": "2023-01-01T00:00:00.000Z",
  "updated": "2023-01-01T00:00:00.000Z"
}
```
<br>

### 6. Get all address
Request
```yaml
Protocol: HTTP/1.1
Host: localhost:8050
Path: /v1/address
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
    "address": "string",
    "number": 0,
    "city": "string",
    "state": "string",
    "country": "string",
    "zipCode": 0,
    "created": "2023-01-01T00:00:00.000Z",
    "updated": "2023-01-01T00:00:00.000Z"
  }
]
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