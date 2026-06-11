# 🔐 Spring Security Showcase

> A production-inspired Spring Security project demonstrating authentication, authorization, JWT-based security, and enterprise security patterns using Spring Boot.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-green)
![Spring Security](https://img.shields.io/badge/Spring_Security-6-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue)
![Docker](https://img.shields.io/badge/Docker-Compose-blue)
![Build](https://img.shields.io/badge/Build-Maven-red)

---

## 📖 Overview

This project is built to explore Spring Security from fundamentals to advanced concepts through practical implementation.

The focus is not only on securing APIs but also on understanding the internal architecture of Spring Security, including authentication, authorization, security filters, JWT processing, password security, and security infrastructure commonly used in modern backend applications.

---

## ✨ Implemented Features

### Authentication

* HTTP Basic Authentication
* Database-backed Authentication
* Custom UserDetailsService
* AuthenticationManager
* DaoAuthenticationProvider
* JWT Authentication
* Stateless Security Architecture

### Authorization

* Role-Based Access Control (RBAC)
* Endpoint-Level Authorization
* Public and Protected Resources

### Password Security

* BCrypt Password Encoding
* Secure Password Storage
* Password Verification

### Persistence

* PostgreSQL
* Spring Data JPA
* Repository Pattern

### Infrastructure

* Docker Compose
* PostgreSQL Container
* pgAdmin

---

## 🏗 Current Security Flow

```text
Client Request
       │
       ▼
SecurityFilterChain
       │
       ▼
JWT Authentication Filter
       │
       ▼
JWT Validation
       │
       ▼
UserDetailsService
       │
       ▼
PostgreSQL Database
       │
       ▼
SecurityContext
       │
       ▼
Authorization
       │
       ▼
Protected Resource
```

---

## 📂 Project Structure

```text
src/main/java
│
├── config
├── controller
├── dto
├── entity
├── repository
├── security
├── service
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

## 🚀 Running the Project

### Start Infrastructure

```bash
docker compose up -d
```

### Run Application

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

## 🗺 Roadmap

### Authentication

* [x] HTTP Basic Authentication
* [x] Database Authentication
* [x] JWT Authentication
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

---

## 📚 Concepts Demonstrated

* SecurityFilterChain
* UserDetails & UserDetailsService
* AuthenticationManager
* AuthenticationProvider
* DaoAuthenticationProvider
* PasswordEncoder & BCrypt
* JWT Authentication
* SecurityContextHolder
* Stateless Security
* Role-Based Authorization

---

## 🎯 Purpose

This project serves as a practical reference for learning and demonstrating Spring Security concepts commonly discussed in backend and full-stack interviews while following patterns used in real-world applications.
