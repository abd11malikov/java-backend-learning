# 🌉 Persistent User Management API (Spring Boot + PostgreSQL)

Day 14 marks the completion of **Week 2**. I transitioned from in-memory applications to a full-stack persistent backend. This API connects Java code to a real **PostgreSQL** database using Spring Data JPA.

## 💡 What I Built
A professional REST API that handles User lifecycle management. Unlike previous days, data here **persists** on the hard drive. If I restart the server, the users are still there.

## 🛠️ Technical Stack
- **Framework:** Spring Boot 3
- **Database:** PostgreSQL (connected via JDBC Driver)
- **ORM:** Spring Data JPA (Hibernate) to map Java Objects to Tables.
- **Boilerplate:** Lombok (for `@Data`, `@NoArgsConstructor`).

## 🚀 Key Features Implemented

### 1. Database Integration
- configured `application.properties` to connect to local Postgres.
- **Entity Mapping:** Used `@Entity` and `@Table` to auto-generate the `users_db` SQL schema.
- **Constraints:** Enforced `unique=true` on emails to prevent duplicates at the database level.

### 2. Full CRUD with Proper Status Codes
I implemented `ResponseEntity` to control HTTP responses precisely:

| Method | Endpoint | Description | Status Code |
| :--- | :--- | :--- | :--- |
| **GET** | `/api/users` | Get all users | `200 OK` |
| **POST** | `/api/users` | Create new user | `201 CREATED` |
| **GET** | `/api/users/{id}` | Find user by ID | `200 OK` / `404 NOT FOUND` |
| **DELETE** | `/api/users/{id}` | Delete user | `200 OK` |
| **GET** | `/api/users/search?email=...` | Find by Email (JPA) | `200 OK` |
| **GET** | `/api/users/domain?domain=...` | Custom JPQL Query | `200 OK` |

### 3. Advanced Backend Logic (Bonus Levels)
- **Data Seeding:** Implemented `CommandLineRunner` to automatically pre-fill the database with dummy users (Admin, Tester) when the server starts.
- **Custom Queries:** Wrote a specific JPQL query (`@Query`) to filter users by their email domain (e.g., finding all `@gmail.com` users).

## 🧪 Testing Results
- Validated endpoints using **Postman**.
- Verified data persistence using **DBeaver**.
- Confirmed that accessing a non-existent ID returns a proper `404 Not Found` JSON response instead of a null value.
