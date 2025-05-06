# Capstone
# Course and Feedback Service

## Overview
This repository contains a Spring Boot application that provides RESTful APIs for managing courses and feedback. The application is structured into two main services: Course Service and Feedback Service.

## Table of Contents
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
    - [Course Service](#course-service)
    - [Feedback Service](#feedback-service)
- [Sample Data for Postman](#sample-data-for-postman)
- [Running the Application](#running-the-application)

## Technologies Used
- Java 21
- Spring Boot 3.4.5
- Spring Data JPA
- H2 Database (in-memory)
- Lombok
- Maven

## Project Structure

```

backend/
│
├── course_service/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── lms/
│   │   │   │           └── course_service/
│   │   │   │               ├── CourseServiceApplication.java       // Main application class
│   │   │   │               ├── controller/                         // REST controllers
│   │   │   │               │   └── CourseController.java           // Course controller
│   │   │   │               ├── dto/                                // Data Transfer Objects
│   │   │   │               │   ├── CourseDto.java                  // Course DTO
│   │   │   │               │   └── CourseResponseDto.java          // Course response DTO
│   │   │   │               ├── exception/                          // Custom exceptions
│   │   │   │               │   ├── CourseNotFoundException.java    // Course not found exception
│   │   │   │               │   └── GlobalExceptionHandler.java     // Global exception handler
│   │   │   │               ├── model/                              // Entity classes
│   │   │   │               │   └── Course.java                     // Course entity
│   │   │   │               ├── repository/                         // Repository interfaces
│   │   │   │               │   └── CourseRepo.java                 // Course repository
│   │   │   │               └── service/                            // Service layer
│   │   │   │                   ├── CourseService.java              // Course service interface
│   │   │   │                   └── CourseServiceImp.java           // Course service implementation
│   │   │   └── resources/
│   │   │       ├── application.properties                          // Application properties
│   │   │       └── static/                                         // Static resources (CSS, JS, images)
│   │   └── test/
│   │       └── java/
│   │           └── com/
│   │               └── lms/
│   │                   └── course_service/
│   │                       ├── controller/                         // Test classes for controllers
│   │                       ├── service/                            // Test classes for services
│   │                       └── repository/                         // Test classes for repositories
│   └── pom.xml                                                     // Maven build file
│
├── feedback_service/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── lms/
│   │   │   │           └── feedback_service/
│   │   │   │               ├── FeedbackServiceApplication.java      // Main application class
│   │   │   │               ├── controller/                          // REST controllers
│   │   │   │               │   └── FeedbackController.java          // Feedback controller
│   │   │   │               ├── dto/                                 // Data Transfer Objects
│   │   │   │               │   ├── FeedbackDto.java                 // Feedback DTO
│   │   │   │               │   └── FeedbackResponseDto.java         // Feedback response DTO
│   │   │   │               ├── exception/                           // Custom exceptions
│   │   │   │               │   └── GlobalExceptionHandler.java      // Global exception handler
│   │   │   │               ├── model/                               // Entity classes
│   │   │   │               │   └── Feedback.java                    // Feedback entity
│   │   │   │               ├── repository/                          // Repository interfaces
│   │   │   │               │   └── FeedbackRepo.java                // Feedback repository
│   │   │   │               └── service/                             // Service layer
│   │   │   │                   ├── FeedbackService.java             // Feedback service interface
│   │   │   │                   └── FeedbackServiceImp.java          // Feedback service implementation
│   │   │   └── resources/
│   │   │       ├── application.properties                           // Application properties
│   │   │       └── static/                                          // Static resources (CSS, JS, images)
│   │   └── test/
│   │       └── java/
│   │           └── com/
│   │               └── lms/
│   │                   └── feedback_service/
│   │                       ├── controller/                          // Test classes for controllers
│   │                       ├── service/                             // Test classes for services
│   │                       └── repository/                          // Test classes for repositories
│   └── pom.xml                                                      // Maven build file
└── README.md                                                        // Project documentation

```

## API Endpoints

### Course Service
- **Get All Courses**
    - **Endpoint:** `GET /api/courses`
    - **Response:**
      ```json
      [
        {
          "id": 1,
          "courseName": "Introduction to Programming",
          "courseCode": "CS101",
          "description": "Learn the basics of programming.",
          "startingDate": "2023-01-01",
          "endingDate": "2023-05-01"
        }
      ]
      ```

- **Get Course by ID**
    - **Endpoint:** `GET /api/courses/{id}`
    - **Response:**
      ```json
      {
        "id": 1,
        "courseName": "Introduction to Programming",
        "courseCode": "CS101",
        "description": "Learn the basics of programming.",
        "startingDate": "2023-01-01",
        "endingDate": "2023-05-01"
      }
      ```

- **Create Course**
    - **Endpoint:** `POST /api/courses`
    - **Request Body:**
      ```json
      {
        "courseName": "Advanced Java",
        "courseCode": "CS201",
        "description": "Deep dive into Java programming.",
        "startingDate": "2023-06-01",
        "endingDate": "2023-12-01"
      }
      ```
    - **Response:**
      ```json
      {
        "id": 2,
        "courseName": "Advanced Java",
        "courseCode": "CS201",
        "description": "Deep dive into Java programming.",
        "startingDate": "2023-06-01",
        "endingDate": "2023-12-01"
      }
      ```

- **Update Course**
    - **Endpoint:** `PUT /api/courses/{id}`
    - **Request Body:**
      ```json
      {
        "courseName": "Advanced Java Programming",
        "courseCode": "CS201",
        "description": "Deep dive into Java programming.",
        "startingDate": "2023-06-01",
        "endingDate": "2023-12-01"
      }
      ```
    - **Response:**
      ```json
      {
        "id": 2,
        "courseName": "Advanced Java Programming",
        "courseCode": "CS201",
        "description": "Deep dive into Java programming.",
        "startingDate": "2023-06-01",
        "endingDate": "2023-12-01"
      }
      ```

- **Delete Course**
    - **Endpoint:** `DELETE /api/courses/{id}`
    - **Response:** `204 No Content`

### Feedback Service
- **Create Feedback**
    - **Endpoint:** `POST /feedback`
    - **Request Body:**
      ```json
      {
        "userId": "user123",
        "message": "Great course!"
      }
      ```
    - **Response:**
      ```json
      {
        "id": 1,
        "userId": "user123",
        "message": "Great course!"
      }
      ```

- **Get All Feedback**
    - **Endpoint:** `GET /feedback`
    - **Response:**
      ```json
      [
        {
          "id": 1,
          "userId": "user123",
          "message": "Great course!"
        }
      ]
      ```

## Sample Data for Postman
You can use the following sample data to test the APIs in Postman.

### Course Service
1. **Create Course**
    - Method: POST
    - URL: `http://localhost:8080/api/courses`
    - Body:
      ```json
      {
        "courseName": "Introduction to Spring Boot",
        "courseCode": "CS301",
        "description": "Learn how to build applications with Spring Boot.",
        "startingDate": "2023-09-01",
        "endingDate": "2023-12-01"
      }
      ```

2. **Get All Courses**
    - Method: GET
    - URL: `http://localhost:8080/api/courses`

### Feedback Service
1. **Create Feedback**
    - Method: POST
    - URL: `http://localhost:8080/feedback`
    - Body:
      ```json
      {
        "userId": "user456",
        "message": "This course was very helpful!"
      }
      ```

2. **Get All Feedback**
    - Method: GET
    - URL: `http://localhost:8080/feedback`

## Running the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/Senthamizharasu-MS/Capstone.git
   cd Capstone
   ```
2. Build the project using Maven:
    ```
    mvn clean install
   ```
3. Run the application:
    ```
   mvn spring-boot:run
   ```
4. Access the application at `http://localhost:8080`
   