# 💰 Expense Tracker (REST API)

A simple yet efficient **Expense Tracker API** built using **Spring Boot** with database connectivity via **Docker container**. This project helps users manage their daily expenses efficiently with basic authentication.

## 🚀 Features

- **User Authentication** (Basic Authentication)
- **CRUD Operations** for Expenses
- **Category-based Expense Tracking**
- **Database Connectivity** (SQL Database in a Docker container)
- **RESTful APIs** following best practices

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security** (Basic Authentication)
- **Docker**
- **MySQL / PostgreSQL (in Docker container)**

## 📌 API Endpoints

| Method  | Endpoint                 | Description                |
|---------|--------------------------|----------------------------|
| `POST`  | `/api/auth/register`      | Register a new user        |
| `POST`  | `/api/auth/login`         | Login user                 |
| `GET`   | `/api/expenses`           | Get all expenses           |
| `GET`   | `/api/expenses/{id}`      | Get expense by ID          |
| `POST`  | `/api/expenses`           | Add a new expense          |
| `PUT`   | `/api/expenses/{id}`      | Update an existing expense |
| `DELETE`| `/api/expenses/{id}`      | Delete an expense          |

## 🔧 Setup and Installation

### 1️⃣ Clone the repository
```sh
git clone https://github.com/ShrunalNimje/Expence_Tracker.git
cd Expence_Tracker
