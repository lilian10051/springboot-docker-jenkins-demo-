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
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── springbasic/
│   │   │           │   └── SpringbasicApplication.java
│   │   │           ├── controller/
│   │   │           │   └── DemoController.java
│   │   │           ├── entity/
│   │   │           │   ├── Person.java
│   │   │           │   └── Student.java
│   │   │           └── repos/
│   │   │               ├── PersonRepo.java
│   │   │               └── StudentRepo.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── springbasic/
│                       └── SpringbasicApplicationTests.java
├── Dockerfile
├── .dockerignore
├── Jenkinsfile
├── .gitignore
├── pom.xml
└── README.md
```

*Note: This is the intended project structure. Adjust filenames and package names to match your actual source code.*

## ⚙️ Application Components

### 1. Spring Boot Application

`SpringbasicApplication.java` is the main entry point. It starts the Spring application and embedded web server.

### 2. Controller Layer

`DemoController.java` handles incoming HTTP requests and returns responses to clients.

### 3. Entity Layer

The `entity` package contains Java classes mapped to database tables, such as `Person.java` and `Student.java`.

### 4. Repository Layer

The `repos` package contains interfaces such as `PersonRepo.java` and `StudentRepo.java`, which extend `JpaRepository` to provide CRUD operations.

### 5. Configuration

`application.properties` stores database connection details, server configuration, and JPA settings.

**Security:** Never commit actual passwords, API keys, or other secrets to GitHub.

## 🗄️ Database Configuration

The application uses MySQL as its relational database.

Example `application.properties`:

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

Install the following:

* Java Development Kit (JDK) compatible with your Spring Boot version.
* Maven.
* MySQL Server.
* Git.
* Docker and Jenkins for the DevOps stages.

### Step 1: Clone the Repository

```bash
git clone https://github.com/lilian10051/springboot-docker-jenkins-demo.git
```

Navigate into the project directory:

```bash
cd springboot-docker-jenkins-demo
```

### Step 2: Configure MySQL

Create the database:

```sql
CREATE DATABASE springbasic_db;
```

In Windows PowerShell, configure your database credentials:

```powershell
$env:DB_USERNAME="root"
$env:DB_PASSWORD="your_mysql_password"
$env:DB_URL="jdbc:mysql://localhost:3306/springbasic_db"
```

Replace `your_mysql_password` with your actual MySQL password.

### Step 3: Build the Application

```bash
mvn clean package
```

This command cleans previous build artifacts, compiles the source code, runs tests, and packages the application if the build succeeds.

### Step 4: Run the Application

```bash
mvn spring-boot:run
```

The application should be available at:

`http://localhost:8080`

## 🌐 REST API

The application may expose endpoints such as these, depending on your `DemoController.java` implementation.

| HTTP Method | Endpoint          | Purpose                            |
| ----------- | ----------------- | ---------------------------------- |
| GET         | `/api/demo/hello` | Returns a greeting                 |
| GET         | `/api/demo/json`  | Demonstrates a JSON response       |
| GET         | `/api/demo/xml`   | Demonstrates an XML response       |
| GET         | `/api/demo/users` | Demonstrates a collection response |

Test an endpoint with:

```bash
curl http://localhost:8080/api/demo/hello
```

## 🐳 Docker

Docker will package the Spring Boot application and its runtime into a container image.

Build the image after creating the `Dockerfile`:

```bash
docker build -t springboot-docker-jenkins-demo .
```

Run the container:

```bash
docker run -p 8080:8080 springboot-docker-jenkins-demo
```

Configure database connectivity and credentials before running the container. The command above assumes those settings are already handled.

## 🔄 Jenkins CI/CD

Jenkins will automate the application's build and testing process.

Planned pipeline stages:

1. **Checkout** — Retrieve source code from GitHub.
2. **Build** — Compile the application using Maven.
3. **Test** — Run automated tests.
4. **Package** — Generate the executable JAR file.
5. **Docker Build** — Build the container image.
6. **Deployment** — Optionally deploy the application to a server or cloud environment.

The pipeline will be defined in a `Jenkinsfile` at the project root.

## 🧪 Testing

Run automated tests:

```bash
mvn test
```

Run the complete Maven verification lifecycle:

```bash
mvn clean verify
```

## 🔐 Security Considerations

* Never store database passwords or secrets in source code.
* Avoid exposing MySQL directly to the public internet.
* Restrict SSH access to trusted sources.
* Use Jenkins credentials for sensitive pipeline settings.
* Keep Java, Spring Boot, MySQL, Docker, and Jenkins updated.

## 📈 Future Improvements

* Implement complete CRUD operations for Person and Student.
* Add request validation and exception handling.
* Write unit and integration tests.
* Add Docker Compose for the application and MySQL.
* Configure Jenkins to build Docker images automatically.
* Push images to a container registry.
* Deploy the application to an AWS EC2 instance.
* Add monitoring and health checks.

## 👨‍💻 Author

**Lilian**

* GitHub: [lilian10051 on GitHub](https://github.com/lilian10051?utm_source=chatgpt.com)
* Repository: [springboot-docker-jenkins-demo](https://github.com/lilian10051/springboot-docker-jenkins-demo?utm_source=chatgpt.com)

## 📄 License

This project is intended for educational and demonstration purposes. Add a `LICENSE` file if you intend to distribute it under a specific open-source license.
