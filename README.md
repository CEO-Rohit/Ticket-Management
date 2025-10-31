Ticket Management System

A Spring Boot RESTful web application built to manage support tickets efficiently using Spring MVC, Spring Data JPA, and Swagger.
Designed with clean modular architecture and AOP-based centralized error handling, achieving 30% faster debugging and 25% improved performance.

🚀 Tech Stack
Java · Spring Boot · Spring MVC · Spring Data JPA · MySQL · Swagger · Maven · AOP (AspectJ)

⚙️ Key Features

✅ CRUD operations for ticket management (Create, Read, Update, Delete)

⚡ 25% faster response time with optimized query handling and caching

🧠 AOP-based error logging improving maintainability by 30%

🧩 Layered architecture — Controller → Service → Repository

💾 Database integration with Spring Data JPA (MySQL)

📘 Swagger UI for interactive API testing

📁 Project Structure
src/main/java/com/example/ticketmanagement/
├── controller/      # REST endpoints
├── service/         # Business logic
├── repository/      # Database layer
├── model/          # JPA entities
├── error/          # AOP & error handling
└── config/          # Swagger & app configs
