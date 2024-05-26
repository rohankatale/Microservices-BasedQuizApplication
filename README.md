# Microservices-Based Quiz Application

This project is a microservices-based application built using Spring Boot. It includes the following components:

- **API Gateway**: Manages and redirects all incoming user requests to the appropriate services.
- **Service Registry**: Allows services to find and communicate with each other.
- **Question Service**: Provides basic CRUD operations for questions.
- **Quiz Service**: Manages quizzes, including fetching questions from the Question Service and calculating the total score.

## Components

### API Gateway

The API Gateway serves as the entry point for all client requests, routing them to the appropriate microservices.

### Service Registry

The Service Registry (Eureka Server) allows microservices to register themselves and discover other registered services.

### Question Service

The Question Service handles CRUD operations for questions. It includes endpoints for creating, reading, updating, and deleting questions.

### Quiz Service

The Quiz Service manages quizzes and interacts with the Question Service to fetch questions based on quiz ID and to calculate the total score of a quiz.

## Project Structure
```sh
.
├── api-gateway
│   ├── src
│   │   └── main
│   │       └── java
│   │           └── com.example.apigateway
│   │               └── ApiGatewayApplication.java
│   └── ...
├── service-registry
│   ├── src
│   │   └── main
│   │       └── java
│   │           └── com.example.serviceregistry
│   │               └── ServiceRegistryApplication.java
│   └── ...
├── question-service
│   ├── src
│   │   └── main
│   │       └── java
│   │           └── com.example.questionservice
│   │               └── QuestionServiceApplication.java
│   └── ...
├── quiz-service
│   ├── src
│   │   └── main
│   │       └── java
│   │           └── com.example.quizservice
│   │               └── QuizServiceApplication.java
│   └── ...
└── README.md
```

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- Spring Boot 2.5.x or higher

## Start the services in the following order

- Service Registry
- Question Service
- Quiz Service
- API Gateway



