# Blog System - Spring Boot Application

This is a Spring Boot application that implements a Blog System with CRUD operations for blog posts, categories, users, and comments. It integrates with a PostgreSQL database using Spring Data JPA.

## Table of Contents
1. [Features](#features)
2. [Technologies Used](#technologies-used)
3. [Setup and Installation](#setup-and-installation)
4. [Running the Application](#running-the-application)
5. [API Documentation](API_Documentation.md)

## Features
- **User Management**: Register users with email, username, and password.
- **Categories**: Create, read, and manage blog categories.
- **Blog Posts**: Create, read, update, and delete blog posts with support for titles, content, and categories.
- **Comments**: Add, edit, delete, and retrieve comments for specific blog posts.
- **Validation**: Ensures valid inputs with error handling for invalid data.

## Technologies Used
- **Spring Boot**: For the main application framework.
- **Spring Data JPA**: For database interaction with PostgreSQL.
- **PostgreSQL**: As the database for storing data.
- **Lombok**: For reducing boilerplate code.

## Setup and Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/FazleRabbeBipul/JAVA-Backend--Blog-System-RESTful-API.git
   ```

2. Navigate into the project directory:
   ```bash
   cd RESTful-Blog-Backend
   ```

3. Set up PostgreSQL and update your database credentials in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/blog_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## Running the Application
Once the application is running, you can access it via:

- **http://localhost:8080** – Main application endpoint.

For further details on the available API endpoints, please refer to the [API Documentation](API_Documentation.md).

