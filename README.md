# 🔐 Spring Security Showcase

> A production-inspired Spring Security project built to explore authentication, authorization, and enterprise security concepts through practical implementation.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-green)
![Spring Security](https://img.shields.io/badge/Spring_Security-6-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue)
![Docker](https://img.shields.io/badge/Docker-Compose-blue)
![Build](https://img.shields.io/badge/Build-Maven-red)

---

## 📖 Overview

This project is designed as a hands-on journey through Spring Security, starting from authentication fundamentals and gradually evolving into a production-ready security architecture.

The goal is not just to implement security features, but to understand how Spring Security works internally, including request processing, authentication mechanisms, authorization strategies, password security, and security infrastructure.

---

## 🚀 Features Implemented

### Authentication

* [x] HTTP Basic Authentication
* [x] Database-backed Authentication
* [x] Custom UserDetailsService
* [x] AuthenticationManager
* [x] DaoAuthenticationProvider

### Authorization

* [x] Role-Based Access Control (RBAC)
* [x] Endpoint-Level Authorization
* [x] Public and Protected Resources

### Password Security

* [x] BCrypt Password Encoding
* [x] Secure Password Storage
* [x] Password Verification

### Persistence

* [x] PostgreSQL Integration
* [x] Spring Data JPA
* [x] User Repository

### Infrastructure

* [x] Docker Compose
* [x] PostgreSQL Container
* [x] pgAdmin Container

---

## 🏗 Authentication Architecture

```text
Client Request
       │
       ▼
SecurityFilterChain
       │
       ▼
BasicAuthenticationFilter
       │
       ▼
AuthenticationManager
       │
       ▼
DaoAuthenticationProvider
       │
       ▼
UserDetailsService
       │
       ▼
PostgreSQL Database
       │
       ▼
Authentication Success
       │
       ▼
Protected Resource
```

---

## 🔍 Authentication Flow

```text
1. Client sends request

2. SecurityFilterChain intercepts request

3. BasicAuthenticationFilter extracts credentials

4. AuthenticationManager receives authentication request

5. DaoAuthenticationProvider validates credentials

6. UserDetailsService loads user from database

7. PasswordEncoder verifies password

8. SecurityContext is populated

9. Request reaches protected endpoint
```

---

## 📂 Project Structure

```text
src/main/java
│
├── config
│   └── SecurityConfig
│
├── controller
│   └── DemoController
│
├── entity
│   └── AppUser
│
├── repository
│   └── UserRepository
│
├── service
│   └── CustomUserDetailsService
│
├── config
│   └── DataInitializer
│
└── SecureBankApplication
```

---

## 🛠 Tech Stack

| Category         | Technology        |
| ---------------- | ----------------- |
| Language         | Java 21           |
| Framework        | Spring Boot 3     |
| Security         | Spring Security 6 |
| Database         | PostgreSQL        |
| ORM              | Spring Data JPA   |
| Containerization | Docker Compose    |
| Build Tool       | Maven             |
| Utilities        | Lombok            |

---

## 📚 Security Concepts Covered

### Core Security

* Authentication
* Authorization
* SecurityFilterChain
* Security Filters
* Basic Authentication

### Spring Security Components

* UserDetails
* UserDetailsService
* AuthenticationManager
* AuthenticationProvider
* DaoAuthenticationProvider
* SecurityContext

### Password Security

* PasswordEncoder
* BCryptPasswordEncoder
* Password Hashing
* Password Verification

### Persistence Layer

* Spring Data JPA
* PostgreSQL
* Repository Pattern

---

## 🐳 Running the Project

### Start Infrastructure

```bash
docker compose up -d
```

### Start Application

```bash
mvn spring-boot:run
```

### PostgreSQL

```text
Host: localhost
Port: 5432
Database: securebank
Username: postgres
Password: postgres
```

### pgAdmin

```text
URL: http://localhost:5050

Email: admin@securebank.com
Password: admin
```

---

## 🎯 Roadmap

### Authentication

* [x] HTTP Basic Authentication
* [x] Database Authentication
* [ ] JWT Authentication
* [ ] Refresh Token Mechanism
* [ ] OAuth2 Login

### Authorization

* [x] Role-Based Access Control
* [ ] Authority-Based Access Control
* [ ] Method-Level Security
* [ ] Ownership-Based Authorization

### Security Enhancements

* [ ] Custom Security Exception Handling
* [ ] Security Audit Logging
* [ ] Account Locking
* [ ] Password Reset Flow
* [ ] Email Verification

### Advanced Topics

* [ ] JWT Authorization Filter
* [ ] Refresh Token Rotation
* [ ] OAuth2 Authorization Code Flow
* [ ] Custom Authentication Providers

---

## 💡 Learning Objective

This project focuses on understanding:

* How Spring Security processes requests internally
* Authentication and authorization mechanisms
* Secure password storage and validation
* Security architecture used in real-world backend applications
* Production-oriented security design patterns

---

## 👨‍💻 Author

Built as a practical Spring Security learning and showcase project to demonstrate backend security concepts using Spring Boot and PostgreSQL.
