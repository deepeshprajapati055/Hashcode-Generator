# Hash Generator Web Application

A modern, user-friendly web application for generating hash codes using various algorithms. Built with Spring Boot, Thymeleaf, and Hibernate.

## Features

- Clean and intuitive user interface
- Support for multiple hashing algorithms (MD5, SHA-1, SHA-256, SHA-512)
- Real-time hash generation using AJAX
- Dark mode support
- Copy to clipboard functionality
- Input validation and error handling
- Responsive design using Bootstrap

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Getting Started

1. Clone the repository
2. Navigate to the project directory
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
4. Open your browser and visit: `http://localhost:8080`

## Technology Stack

- Backend: Spring Boot 3.2.2
- Frontend: Thymeleaf, Bootstrap 5
- Database: H2 Database (embedded)
- Build Tool: Maven

## Security Features

- Input validation
- XSS protection
- CSRF protection
- Secure password hashing (for user authentication)

## Development

To run the application in development mode:

```bash
mvn clean install
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`.
# Hashcode-Generator
