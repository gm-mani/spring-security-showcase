# Spring Security Showcase

A comprehensive Spring Security project built to demonstrate authentication, authorization, and enterprise-grade security patterns commonly used in modern backend applications.

The goal of this project is to explore Spring Security from its fundamentals to advanced concepts through practical implementation rather than isolated examples.

## Features Implemented

### Authentication

* HTTP Basic Authentication
* Database-backed Authentication
* Custom UserDetailsService
* AuthenticationManager
* DaoAuthenticationProvider

### Authorization

* Role-Based Access Control (RBAC)
* Endpoint-level Authorization
* Public and Protected Resources

### Password Security

* BCrypt Password Encoding
* Secure Password Storage
* Password Verification using PasswordEncoder

### User Management

* User Entity
* Spring Data JPA Repository
* H2 Database Integration

### Security Configuration

* Custom SecurityFilterChain
* Custom Authentication Components
* Request Authorization Rules

## Architecture

Request
→ SecurityFilterChain
→ BasicAuthenticationFilter
→ AuthenticationManager
→ DaoAuthenticationProvider
→ UserDetailsService
→ Database
→ Authentication Success
→ Protected Resource

## Tech Stack

* Java 21
* Spring Boot 3
* Spring Security 6
* Spring Data JPA
* H2 Database
* Maven
* Lombok

## Concepts Covered

* Authentication vs Authorization
* Security Filter Chain
* UserDetails & UserDetailsService
* AuthenticationManager
* AuthenticationProvider
* DaoAuthenticationProvider
* Password Encoding
* BCrypt Hashing
* Role-Based Security
* HTTP Basic Authentication
* 401 Unauthorized vs 403 Forbidden

## Planned Enhancements

* JWT Authentication
* JWT Authorization Filter
* Refresh Token Mechanism
* Authorities & Fine-Grained Permissions
* Method-Level Security
* Ownership-Based Authorization
* OAuth2 Login (Google)
* Custom Security Exception Handling
* Security Audit Logging

## Learning Objective

This repository is focused on understanding how Spring Security works internally and how authentication and authorization are implemented in production-grade applications.
