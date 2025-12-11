# Student App

A Spring Boot REST API application for managing student records. This project demonstrates core Spring Boot concepts including JPA/Hibernate ORM, MySQL database integration, and RESTful API design.

## Overview

Student App is a simple yet functional REST API that allows you to perform CRUD (Create, Read, Update, Delete) operations on student records. The application uses Spring Boot with MySQL as the database backend.

## Tech Stack

- **Framework**: Spring Boot 3.5.5
- **Language**: Java 17
- **Database**: MySQL 8.0
- **ORM**: Spring Data JPA / Hibernate
- **Build Tool**: Maven
- **API**: RESTful Web Services

## Project Structure

```
student-app/
├── src/
│   ├── main/
│   │   ├── java/com/example/student_app/
│   │   │   ├── StudentAppApplication.java      # Spring Boot application entry point
│   │   │   ├── controller/
│   │   │   │   └── StudentController.java       # REST controller with API endpoints
│   │   │   ├── entity/
│   │   │   │   └── Student.java                 # Student JPA entity
│   │   │   ├── service/
│   │   │   │   └── StudentService.java          # Business logic layer
│   │   │   └── repository/
│   │   │       └── StudentRepository.java       # Data access layer
│   │   └── resources/
│   │       └── application.properties            # Application configuration
│   └── test/
│       └── java/com/example/student_app/
│           └── StudentAppApplicationTests.java  # Unit tests
├── pom.xml                                       # Maven configuration
└── README.md                                     # This file
```

## Prerequisites

Before running this application, ensure you have the following installed:

- Java Development Kit (JDK) 17 or higher
- Maven 3.6 or higher
- MySQL Server 8.0 or higher
- Git (optional, for cloning)

## Installation & Setup

### 1. Clone the Repository

```bash
git clone https://github.com/Sanjilsharma7074/student-app.git
cd student-app
```

### 2. Database Configuration

Create a MySQL database and update the connection settings in `src/main/resources/application.properties`:

```properties
# Update with your database credentials
spring.datasource.url=jdbc:mysql://localhost:3306/jdbc_1
spring.datasource.username=root
spring.datasource.password=your_password_here
```

**Default Configuration** (in `application.properties`):

- **Database URL**: `jdbc:mysql://localhost:3306/jdbc_1`
- **Username**: `root`
- **Password**: `Sanjil@456` (change this in production)
- **Server Port**: `8081`

### 3. Create the Database

```sql
CREATE DATABASE jdbc_1;
```

### 4. Build the Project

```bash
mvn clean build
```

Or using the Maven wrapper:

```bash
./mvnw clean build
```

## Running the Application

### Using Maven

```bash
mvn spring-boot:run
```

### Using the Maven Wrapper

```bash
./mvnw spring-boot:run
```

### Or build and run the JAR

```bash
mvn clean package
java -jar target/student-app-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8081`

## API Endpoints

The application provides the following RESTful endpoints for student management:

### Base URL

```
http://localhost:8081/students
```

### Endpoints

| Method | Endpoint         | Description                       |
| ------ | ---------------- | --------------------------------- |
| GET    | `/students`      | Retrieve all students             |
| GET    | `/students/{id}` | Retrieve a specific student by ID |
| POST   | `/students`      | Create a new student              |
| PUT    | `/students/{id}` | Update an existing student        |
| DELETE | `/students/{id}` | Delete a student                  |

### Request/Response Examples

#### Get All Students

```bash
curl -X GET http://localhost:8081/students
```

**Response:**

```json
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com"
  },
  {
    "id": 2,
    "name": "Jane Smith",
    "email": "jane@example.com"
  }
]
```

#### Get Student by ID

```bash
curl -X GET http://localhost:8081/students/1
```

**Response:**

```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com"
}
```

#### Create a New Student

```bash
curl -X POST http://localhost:8081/students \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Alice Johnson",
    "email": "alice@example.com"
  }'
```

**Response:**

```json
{
  "id": 3,
  "name": "Alice Johnson",
  "email": "alice@example.com"
}
```

#### Update a Student

```bash
curl -X PUT http://localhost:8081/students/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Updated",
    "email": "john.updated@example.com"
  }'
```

#### Delete a Student

```bash
curl -X DELETE http://localhost:8081/students/1
```

## Entity Model

### Student Entity

The `Student` entity represents a student record with the following attributes:

```java
@Entity
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;           // Primary key (auto-generated)
  private String name;       // Student's name
  private String email;      // Student's email address
}
```

## Application Properties

Key configuration settings in `application.properties`:

```properties
# Server Configuration
server.port=8081

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/jdbc_1
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=Sanjil@456

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## Dependencies

Key dependencies included in the project:

- **spring-boot-starter-data-jpa**: Spring Data JPA for database operations
- **spring-boot-starter-web**: Spring Web for building REST APIs
- **mysql-connector-java**: MySQL JDBC driver
- **spring-boot-devtools**: Development tools for hot reload
- **spring-boot-starter-test**: Testing framework

## Running Tests

Execute the unit tests using Maven:

```bash
mvn test
```

Or with the Maven wrapper:

```bash
./mvnw test
```

## Project Features

✅ **RESTful API Design**: Standard HTTP methods for CRUD operations  
✅ **Spring Data JPA**: Simplified database operations with automatic query generation  
✅ **Hibernate ORM**: Object-relational mapping for database interaction  
✅ **MySQL Integration**: Robust relational database support  
✅ **Spring Boot**: Quick project setup and configuration  
✅ **Exception Handling**: Proper error handling for missing resources  
✅ **Modular Architecture**: Separation of concerns with controller, service, and repository layers

## Troubleshooting

### Port Already in Use

If port 8081 is already in use, change it in `application.properties`:

```properties
server.port=8082
```

### Database Connection Error

- Ensure MySQL server is running
- Verify database credentials in `application.properties`
- Confirm the database `jdbc_1` exists

### Student Not Found Error

If you get a "Student of ID X not found" error, ensure the student ID exists in the database.

## Future Enhancements

- Input validation with `@Valid` and custom validators
- Global exception handling with `@ControllerAdvice`
- Pagination and sorting for large datasets
- Search and filter functionality
- Authentication and authorization
- API documentation with Swagger/OpenAPI
- Caching mechanisms
- Unit and integration tests

## License

This project is open source and available under the MIT License.

## Author

**Sanjil Sharma**  
GitHub: [@Sanjilsharma7074](https://github.com/Sanjilsharma7074)

## Support

For issues, questions, or contributions, please visit the [GitHub repository](https://github.com/Sanjilsharma7074/student-app).

---

**Last Updated**: December 11, 2025
