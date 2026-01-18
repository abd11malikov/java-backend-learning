# 🛒 Secure E-Commerce REST API (Spring Boot 3)

This is a comprehensive backend system for an E-Commerce platform handling Users, Inventory, Orders, and Secure Payments simulations. It features Role-Based Access Control (RBAC), JWT Authentication, and relational data integrity using PostgreSQL.

## 🚀 Key Features

### 🔐 Security & Auth
- **JWT Authentication:** Stateless security using JSON Web Tokens.
- **RBAC (Role-Based Access Control):**
    - `ADMIN`: Can manage products, update inventory, and view all orders.
    - `USER`: Can browse products and place orders.
- **BCrypt Hashing:** All passwords are salted and hashed before storage.

### 🛍️ Business Logic
- **Transactional Ordering:** If an order item is out of stock during checkout, the entire transaction rolls back (`@Transactional`).
- **Dynamic Pricing:** Order total is calculated in the backend (BigDecimal) to prevent frontend tampering.
- **Data Validation:** Strict input checks (stock limits, email formats) using Spring Validation.

## 🛠️ Tech Stack
| Component | Technology |
| :--- | :--- |
| **Language** | Java 17 |
| **Framework** | Spring Boot 3.4 (Web, Data JPA, Security) |
| **Database** | PostgreSQL |
| **DevOps** | Docker, Docker Compose |
| **Testing** | Postman, JUnit 5, Mockito |

## 🏗️ Architecture & Database Schema
The system uses a relational PostgreSQL schema:
- **`users`** `1 -> N` **`orders`**
- **`orders`** `1 -> N` **`order_items`**
- **`products`** `1 -> N` **`order_items`**

## 🔌 API Endpoints (Snapshot)

| Method | Endpoint | Role | Description |
| :--- | :--- | :--- | :--- |
| `POST` | `/auth/login` | Public | Returns JWT Token. |
| `POST` | `/api/products` | Admin | Add new inventory item. |
| `GET` | `/api/products` | Public | Browse catalog (with pagination). |
| `POST` | `/api/orders` | User | Place a new order (triggers stock deduction). |

## 🐳 How to Run (Docker)
The application is fully containerized.

1. **Clone the repo:**
   ```bash
   git clone https://github.com/YOUR_USERNAME/e-commerce-backend.git