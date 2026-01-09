# 📝 Spring Boot Blog Backend (Full-Stack Architecture)

This project serves as the **Capstone** for Week 3. It combines all previous concepts (Entities, Relationships, Security, JPA) into a complete Blogging Platform.

**Timeline:**
- **Day 20:** Architecture, Entities, Database Setup, Data Seeding.
- **Day 21:** REST API implementation (DTOs, Controllers, Services).

## 🏛️ Database Schema (ERD)
The application handles complex relationships using Hibernate/JPA:

1.  **User Entity**
    - One-to-Many → **Posts** (`CascadeType.ALL`)
    - *Features:* Password storage (Ready for hashing).

2.  **Post Entity**
    - Many-to-One → **User** (The Author)
    - One-to-Many → **Comments** (`CascadeType.ALL`)
    - *Features:* Supports Long Text content.

3.  **Comment Entity**
    - Many-to-One → **Post**
    - Many-to-One → **User** (The Commenter)

## 🛠️ Tech Stack
- **Framework:** Spring Boot 3.4
- **Database:** PostgreSQL (db: `blog_db`)
- **Tools:** Spring Security (Configuration), Validation, Lombok.

## 🚀 "Proof of Life"
Includes a `DataSeeder` (`CommandLineRunner`) that creates an initial Admin User, creates Posts for them, and adds Comments, proving the Foreign Key web is functioning correctly on startup.

## 🎮 API Documentation (Day 21 Update)

I successfully implemented the REST layer with a dedicated Service architecture.

### Key Endpoints
| Feature | Method | URL | Description |
| :--- | :--- | :--- | :--- |
| **Blog Feed** | `GET` | `/api/posts` | Lists posts (simulates feed). |
| **Single Post** | `GET` | `/api/posts/{id}` | Returns post + nested comments. |
| **Comments** | `POST` | `/api/comments` | Adds a comment (via `CommentService`). |
| **Admin** | `DELETE` | `/api/posts/{id}` | Cascades deletes (Removes post & its comments). |

### Design Choice
I separated `CommentService` from `PostService`.
- **Reason:** To follow Single Responsibility Principle. Managing comments (CRUD) is distinct from managing Blog Posts.