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

This project is built to deeply understand Spring Security through practical implementation rather than theory.

The application incrementally implements authentication and authorization mechanisms commonly used in modern backend systems, including database-backed authentication, JWT security, role-based access control, authority-based permissions, method-level security, and ownership-based authorization.

The goal is to understand not only how to secure APIs, but also the internal architecture and request flow of Spring Security.

---

## ✨ Implemented Features

### Authentication

* HTTP Basic Authentication
* Database-backed Authentication
* Custom UserDetailsService
* AuthenticationManager
* AuthenticationProvider
* DaoAuthenticationProvider
* JWT Authentication
* JWT Generation & Validation
* Custom JWT Authentication Filter
* Stateless Security Architecture

### Authorization

* Role-Based Access Control (RBAC)
* Authority-Based Authorization
* Endpoint-Level Authorization
* Method-Level Security
* Ownership-Based Authorization
* Spring Expression Language (SpEL)
* Public and Protected Resources

### Password Security

* BCrypt Password Encoding
* Secure Password Storage
* Password Verification

### Persistence

* PostgreSQL
* Spring Data JPA
* Repository Pattern
* Entity Relationships

### Infrastructure

* Docker Compose
* PostgreSQL Container
* pgAdmin

---

## 🏗 Security Architecture

### Authentication Flow

```text
Client Login Request
       │
       ▼
AuthenticationManager
       │
       ▼
AuthenticationProvider
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
PasswordEncoder (BCrypt)
       │
       ▼
JWT Generation
       │
       ▼
JWT Response
```

---

### Authorization Flow

```text
Client Request + JWT
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
SecurityContextHolder
       │
       ▼
Role & Authority Evaluation
       │
       ▼
Ownership Verification
       │
       ▼
Protected Resource
```

---

## 🔒 Authorization Model

### Roles

```text
USER
ADMIN
```

### Permissions

```text
ACCOUNT_READ
ACCOUNT_CREATE
ACCOUNT_UPDATE
ACCOUNT_DELETE
```

### Role → Permission Mapping

```text
USER
 └── ACCOUNT_READ

ADMIN
 ├── ACCOUNT_READ
 ├── ACCOUNT_CREATE
 ├── ACCOUNT_UPDATE
 └── ACCOUNT_DELETE
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
│   ├── JwtAuthenticationFilter
│   ├── JwtService
│   ├── SecurityConfig
│   └── CustomUserDetailsService
│
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

## 📚 Concepts Demonstrated

### Authentication

* SecurityFilterChain
* UserDetails
* UserDetailsService
* AuthenticationManager
* AuthenticationProvider
* DaoAuthenticationProvider
* PasswordEncoder
* BCrypt Password Hashing
* JWT Authentication
* JWT Validation
* Stateless Authentication
* SecurityContextHolder

### Authorization

* Role-Based Authorization
* Authority-Based Authorization
* Method-Level Security
* @PreAuthorize
* Spring Expression Language (SpEL)
* Ownership-Based Authorization
* Object-Level Authorization

### Spring Security Internals

* Authentication Flow
* Authorization Flow
* Security Filter Chain
* JWT Processing Pipeline
* GrantedAuthority Model
* Roles vs Authorities
* Security Context Lifecycle

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
* [x] Authority-Based Access Control
* [x] Method-Level Security
* [x] Ownership-Based Authorization
* [x] Spring Expression Language (SpEL)

### Security Enhancements

* [ ] Custom Security Exception Handling
* [ ] Security Audit Logging
* [ ] Account Locking
* [ ] Password Reset Flow
* [ ] Email Verification

---

## 🎯 Purpose

This project serves as a practical reference for learning and demonstrating Spring Security concepts commonly discussed in backend and full-stack interviews.

The implementation focuses on understanding how Spring Security works internally, including authentication, authorization, JWT processing, security filters, role and permission evaluation, and ownership-based access control patterns commonly used in enterprise applications.
