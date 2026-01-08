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