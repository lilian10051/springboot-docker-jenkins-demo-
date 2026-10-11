# Spring Boot Docker Jenkins Demo

A Spring Boot REST API demo using Spring Data JPA, MySQL, Lombok, Docker, and Jenkins CI/CD to demonstrate automated testing, building, database integration, and containerization.

## 📌 Project Overview

This project demonstrates how to build a RESTful web application using Spring Boot and Java. It integrates MySQL for database management and Spring Data JPA for data persistence.

The project is also designed to demonstrate DevOps practices by using Docker to package the application into a container and Jenkins to automate the build and testing process.

## 🎯 Project Objectives

* Build RESTful APIs using Spring Boot.
* Implement database operations using Spring Data JPA.
* Connect the application to a MySQL database.
* Use Lombok to reduce boilerplate Java code.
* Test REST endpoints that return JSON and XML.
* Containerize the application using Docker.
* Automate application builds and tests using Jenkins.
* Manage source code using Git and GitHub.

## 🛠️ Technologies Used

| Technology      | Purpose                                    |
| --------------- | ------------------------------------------ |
| Java            | Application programming language           |
| Spring Boot     | Application framework                      |
| Spring Web MVC  | REST API development                       |
| Spring Data JPA | Database access and persistence            |
| Hibernate       | ORM and database table management          |
| MySQL           | Relational database                        |
| Lombok          | Reduces boilerplate code                   |
| Maven           | Dependency management and build automation |
| Git             | Version control                            |
| GitHub          | Source code hosting                        |
| Docker          | Application containerization               |
| Jenkins         | CI/CD pipeline automation                  |

## 📂 Project Structure

```text
springboot-docker-jenkins-demo/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── springbasic/
│   │   │           │   └── SpringbasicApplication.java
│   │   │           │
│   │   │           ├── controller/
│   │   │           │   └── DemoController.java
│   │   │           │
│   │   │           ├── entity/
│   │   │           │   ├── Person.java
│   │   │           │   └── Student.java
│   │   │           │
│   │   │           └── repos/
│   │   │               ├── PersonRepo.java
│   │   │               └── StudentRepo.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── springbasic/
│                       └── SpringbasicApplicationTests.java
│
├── Dockerfile
├── .dockerignore
├── Jenkinsfile
├── .gitignore
├── pom.xml
└── README.md
```

> **Note:** This is the intended project layout. Adjust the package names and file names to match your actual source code. The `Dockerfile`, `.dockerignore`, and `Jenkinsfile` should be added as you implement the Docker and Jenkins stages.

## ⚙️ Application Components

### 1. Spring Boot Application

`SpringbasicApplication.java`

The main entry point of the application. It starts the embedded web server and initializes the Spring application context.

### 2. Controller Layer

`DemoController.java`

Handles incoming HTTP requests and returns responses to clients. This layer exposes REST endpoints for testing API functionality.

### 3. Entity Layer

The `entity` package contains the Java classes mapped to database tables.

Examples:

* `Person.java`
* `Student.java`

These classes use JPA annotations such as `@Entity`, `@Id`, and `@GeneratedValue` to define database entities.

### 4. Repository Layer

The `repos` package contains interfaces for database access.

Examples:

* `PersonRepo.java`
* `StudentRepo.java`

These interfaces extend `JpaRepository`, providing CRUD operations without requiring you to implement the basic database queries manually.

### 5. Configuration

`application.properties`

Stores application configuration, including the server port, MySQL connection details, and JPA settings.

**Important:** Do not commit real database passwords, API keys, or other secrets to GitHub. Use environment variables or another secure configuration method for sensitive values.

## 🗄️ Database Configuration

The application uses MySQL as its relational database.

Example configuration for `src/main/resources/application.properties`:

```properties
spring.application.name=springbasic

spring.datasource.url=${DB_URL:jdbc:mysql://localhost:3306/springbasic_db}
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Create the database before starting the application:

```sql
CREATE DATABASE springbasic_db;
```

Hibernate can create or update tables for correctly configured and discovered JPA entities when `spring.jpa.hibernate.ddl-auto=update` is enabled.

## 🚀 Getting Started

### Prerequisites

Install the following tools:

* Java Development Kit (JDK) 17 or a compatible version supported by your Spring Boot release.
* Maven.
* MySQL Server.
* Git.

Docker and Jenkins are required for the containerization and CI/CD stages.

### Step 1: Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/springboot-docker-jenkins-demo.git
```

Navigate into the project directory:

```bash
cd springboot-docker-jenkins-demo
```

Replace `YOUR_USERNAME` with your GitHub username.

### Step 2: Configure MySQL

Create the database:

```sql
CREATE DATABASE springbasic_db;
```

Configure your MySQL username and password using environment variables.

For example, in Windows PowerShell:

```powershell
$env:DB_USERNAME="root"
$env:DB_PASSWORD="your_mysql_password"
```

Set `DB_URL` if your database uses a different connection URL:

```powershell
$env:DB_URL="jdbc:mysql://localhost:3306/springbasic_db"
```

### Step 3: Build the Application

Run the following Maven command:

```bash
mvn clean package
```

This command cleans previous build artifacts, compiles the source code, runs tests, and packages the application if the build succeeds.

### Step 4: Run the Application

```bash
mvn spring-boot:run
```

By default, the application is available at:

```text
http://localhost:8080
```

Use the API endpoints implemented in `DemoController.java` to test the application.

## 🌐 REST API

The application can expose endpoints such as the following, depending on the methods implemented in `DemoController.java`.

| HTTP Method | Endpoint          | Purpose                            |
| ----------- | ----------------- | ---------------------------------- |
| GET         | `/api/demo/hello` | Returns a greeting                 |
| GET         | `/api/demo/json`  | Demonstrates a JSON response       |
| GET         | `/api/demo/xml`   | Demonstrates an XML response       |
| GET         | `/api/demo/users` | Demonstrates a collection response |

Example request:

```bash
curl http://localhost:8080/api/demo/hello
```

The actual endpoints and response formats depend on your controller implementation.

## 🐳 Docker

Docker will be used to package the Spring Boot application and its runtime into a container image.

Planned Docker workflow:

1. Build the Spring Boot application.
2. Create a Docker image.
3. Run the application inside a container.
4. Configure the application to connect to MySQL.
5. Verify the API from outside the container.

Example commands after creating the `Dockerfile`:

```bash
docker build -t springboot-docker-jenkins-demo .
```

Run the container:

```bash
docker run -p 8080:8080 springboot-docker-jenkins-demo
```

**Note:** The container also needs valid database configuration and network access to MySQL. The example run command assumes these have been configured.

## 🔄 Jenkins CI/CD

Jenkins will automate the application's build and testing process.

The planned pipeline stages are:

1. **Checkout** — Retrieve source code from GitHub.
2. **Build** — Compile the Spring Boot application using Maven.
3. **Test** — Execute automated tests.
4. **Package** — Generate the executable JAR file.
5. **Docker Build** — Build the container image.
6. **Deployment** — Optionally deploy the application to a server or cloud environment.

The pipeline will be defined in a `Jenkinsfile` at the project root.

## 🧪 Testing

Run the automated tests using:

```bash
mvn test
```

Run the complete build:

```bash
mvn clean verify
```

Tests can be added to verify controller responses, repository operations, and database integration.

## 🔐 Security Considerations

* Do not store passwords or secrets in source code.
* Avoid exposing MySQL directly to the public internet.
* Restrict SSH and application access to trusted networks where possible.
* Use secure Jenkins credentials for GitHub and deployment secrets.
* Use environment variables or a secrets manager for sensitive configuration.
* Keep Java, Spring Boot, MySQL, Docker, and Jenkins updated.

## 📈 Future Improvements

* Add complete CRUD operations for Person and Student.
* Add request validation and exception handling.
* Write unit and integration tests.
* Add Docker Compose for the application and MySQL.
* Configure Jenkins to build Docker images automatically.
* Push images to a container registry.
* Deploy the application to an AWS EC2 instance.
* Add monitoring and application health checks.

## 👨‍💻 Author

**Your Name**

GitHub: `https://github.com/YOUR_USERNAME`

## 📄 License

This project is intended for educational and demonstration purposes. Add a `LICENSE` file if you intend to distribute the project under a specific open-source license.
