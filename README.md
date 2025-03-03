# 💰 Expense Tracker (REST API)

A simple yet efficient **Expense Tracker API** built using **Spring Boot** with database connectivity via **Docker container**. This project helps users manage their daily expenses efficiently with basic authentication.

## 🚀 Features

- **User Authentication** (Basic Authentication)
- **CRUD Operations** for Expenses
- **Category-based Expense Tracking**
- **Database Connectivity** (SQL Database in a Docker container)

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security** (Basic Authentication)
- **Docker**
- **MySQL (in Docker container)**

## 📌 API Endpoints

| Method  | Endpoint                  | Description                |
|---------|---------------------------|----------------------------|
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
```
### 2️⃣ Start Docker Container
Ensure Docker is installed and running.
```sh
docker-compose up -d
```

### 3️⃣ Run the Application

```sh
./mvnw spring-boot:run
```

### 4️⃣ Access the API
- Visit http://localhost:8080/expences to start using the API.

## 🔐 Authentication
- Uses Basic Authentication with username & password.

## 🏗️ Future Enhancements
- ✅ JWT Authentication
- ✅ User Roles & Authorization
  
## ⭐ Contribute
- Feel free to fork this repository, make changes, and create a pull request!
