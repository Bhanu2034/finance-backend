# Finance Data Processing and Access Control Backend

## Overview

This project implements a **Finance Data Processing and Access Control Backend** using **Spring Boot**.
The system allows users to manage financial records and provides role-based access control to ensure that only authorized users can perform certain operations.

The backend exposes REST APIs for **user management, financial record management, and dashboard analytics**.

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* MySQL
* Maven

---

## Project Architecture

The project follows a **layered architecture**.

```
controller
 ├── DashboardController
 ├── FinanceController
 └── UserController

service
 ├── CustomUserDetailsService
 ├── FinanceService
 └── UserService

repository
 ├── FinanceRepository
 └── UserRepository

model
 ├── FinancialRecord
 ├── User
 └── Role

config
 └── SecurityConfig

exception
 └── GlobalExceptionHandler
```

---

## Features

### 1. User and Role Management

Users are stored in the database and authenticated using **Spring Security**.

Roles supported:

* ADMIN
* ANALYST
* VIEWER

Passwords are stored using **BCrypt encryption**.

---

### 2. Financial Records Management

The system allows users to manage financial records such as income and expenses.

Supported operations:

* Create financial record
* View financial records
* Update financial record
* Delete financial record

---

### 3. Dashboard Summary API

Provides a summary of financial data including:

* Total income
* Total expenses
* Current balance

---

### 4. Role-Based Access Control

Access to APIs is restricted based on user roles.

| Endpoint        | Access Role            |
| --------------- | ---------------------- |
| `/users/**`     | ADMIN                  |
| `/records/**`   | ADMIN, ANALYST         |
| `/dashboard/**` | ADMIN, ANALYST, VIEWER |

---

## API Endpoints

### User APIs

Create User

```
POST /users
```

Example request:

```
{
"name": "Admin",
"email": "admin@test.com",
"password": "123",
"role": "ADMIN"
}
```

---

### Financial Record APIs

Create Record

```
POST /records
```

Get Records

```
GET /records
```

Update Record

```
PUT /records/{id}
```

Delete Record

```
DELETE /records/{id}
```

---

### Dashboard API

Get financial summary

```
GET /dashboard/summary
```

Example response:

```
{
"totalIncome": 5000,
"totalExpense": 2000,
"balance": 3000
}
```

---

## Security

The application uses **Spring Security with Basic Authentication**.

Authentication flow:

```
Client → Spring Security → CustomUserDetailsService → UserRepository → Database
```

Passwords are encrypted using **BCryptPasswordEncoder**.

---

## Database

The application uses **MySQL** as the database.

Example configuration in `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
```

---

## Running the Project

Clone the repository:

```
git clone https://github.com/YOUR_USERNAME/finance-backend.git
```

Navigate to the project folder:

```
cd finance-backend
```

Run the application:

```
mvn spring-boot:run
```

The server will start at:

```
http://localhost:8080
```

---

## Testing APIs

APIs can be tested using:

* Postman
* Insomnia
* cURL

Use **Basic Authentication** with the registered user credentials.

---

## Author

Bhanu Prakash
BTech Computer Science
