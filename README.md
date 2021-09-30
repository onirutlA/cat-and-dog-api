# Cat And Dog API

Just a simple API that store cat and dog data

## How to Run Development

1. Minimum `Java 11` installed, check in your cmd/terminal.

```
java --version
```

2. Get Gradle installed, check in your cmd/terminal.

```
gradle --version
```

3. Install latest version of PostgreSQL.
4. Clone this repo

```
If you're using SSH then use this command to clone this application
git clone git@github.com:/onirutlA/cat-and-dog-api.git

Otherwise then use this command to clone this application
git clone https://github.com/onirutlA/cat-and-dog-api.git
```

5. Go to root project, and make sure your `application.properties` looks like this

```
spring.datasource.url=jdbc:postgresql://localhost:5432/cat_and_dog
spring.datasource.username=postgres
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL81Dialect
```

* This is default minimal configuration in order to run the app.

6. You can run directly the app from Intellij IDEA or Vscode. If you prefer to run using cmd, run this on terminal/cmd

```
gradle bootRun
```

## API Spec

### Add Cat

Request:

- Method : POST
- Endpoint : `/cat`
- Header :
    - Content-Type : application/json
    - Accept : application/json
- Body :

```json
{
  "name": "String",
  "type": "String",
  "color": "String",
  "height": "Double"
}
```

Response:

```json
{
  "id": "Integer",
  "name": "String",
  "type": "String",
  "color": "String",
  "height": "Double",
  "createdAt": "Timestamp",
  "updatedAt": "Timestamp",
  "isDeleted": "Boolean"
}
```

### Add Dog

Request:

- Method : POST
- Endpoint : `/dog`
- Header :
    - Content-Type : application/json
    - Accept : application/json
- Body :

```json
{
  "name": "String",
  "type": "String",
  "color": "String",
  "height": "Double"
}
```

Response:

```json
{
  "id": "Integer",
  "name": "String",
  "type": "String",
  "color": "String",
  "height": "Double",
  "createdAt": "Timestamp",
  "updatedAt": "Timestamp",
  "isDeleted": "Boolean"
}
```

### Get All Cat

Request:

- Method : GET
- Endpoint : `/cat`
- Header :
    - Content-Type : application/json

Response:

```json
[
  {
    "id": "Integer",
    "name": "String",
    "type": "String",
    "color": "String",
    "height": "Double",
    "createdAt": "Timestamp",
    "updatedAt": "Timestamp",
    "isDeleted": "Boolean"
  }
]
```

### Get All Dog

Request:

- Method : GET
- Endpoint : `/dog`
- Header :
    - Content-Type : application/json

Response:

```json
[
  {
    "id": "Integer",
    "name": "String",
    "type": "String",
    "color": "String",
    "height": "Double",
    "createdAt": "Timestamp",
    "updatedAt": "Timestamp",
    "isDeleted": "Boolean"
  }
]
```

### Get Detail Cat

Request:

- Method : GET
- Endpoint : `/cat/{id}`
- Header :
    - Content-Type : application/json

Response:

```json
{
  "id": "Integer",
  "name": "String",
  "type": "String",
  "color": "String",
  "height": "Double",
  "createdAt": "Timestamp",
  "updatedAt": "Timestamp",
  "isDeleted": "Boolean"
}
```

### Get Detail Dog

Request:

- Method : GET
- Endpoint : `/dog/{id}`
- Header :
    - Content-Type : application/json

Response:

```json
{
  "id": "Integer",
  "name": "String",
  "type": "String",
  "color": "String",
  "height": "Double",
  "createdAt": "Timestamp",
  "updatedAt": "Timestamp",
  "isDeleted": "Boolean"
}
```

### Update Cat

Request:

- Method : PUT
- Endpoint : `/cat/{id}`
- Header :
    - Content-Type : application/json
    - Accept : application/json
- Body :

```json
{
  "name": "String",
  "type": "String",
  "color": "String",
  "height": "Double"
}
```

Response:

```json
{
  "id": "Integer",
  "name": "String",
  "type": "String",
  "color": "String",
  "height": "Double",
  "createdAt": "Timestamp",
  "updatedAt": "Timestamp",
  "isDeleted": "Boolean"
}
```

### Update Dog

Request:

- Method : PUT
- Endpoint : `/dog/{id}`
- Header :
    - Content-Type : application/json
    - Accept : application/json
- Body :

```json
{
  "name": "String",
  "type": "String",
  "color": "String",
  "height": "Double"
}
```

Response:

```json
{
  "id": "Integer",
  "name": "String",
  "type": "String",
  "color": "String",
  "height": "Double",
  "createdAt": "Timestamp",
  "updatedAt": "Timestamp",
  "isDeleted": "Boolean"
}
```

### Delete Cat

Request:

- Method : DELETE
- Endpoint : `/cat/{id}`
- Header :
    - Content-Type : application/json

Response:

```json
{
  "id": "Integer",
  "name": "String",
  "type": "String",
  "color": "String",
  "height": "Double",
  "createdAt": "Timestamp",
  "updatedAt": "Timestamp",
  "isDeleted": "Boolean"
}
```

### Delete Dog

Request:

- Method : DELETE
- Endpoint : `/dog/{id}`
- Header :
    - Content-Type : application/json

Response:

```json
{
  "id": "Integer",
  "name": "String",
  "type": "String",
  "color": "String",
  "height": "Double",
  "createdAt": "Timestamp",
  "updatedAt": "Timestamp",
  "isDeleted": "Boolean"
}
```