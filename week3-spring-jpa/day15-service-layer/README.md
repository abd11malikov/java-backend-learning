# 🍰 Enterprise Layered Architecture (Refactored)

On Day 15 (Jan 3), I refactored the project to follow the standard **3-Layer Architecture** used in professional enterprise applications. I moved logic out of the Controller and introduced robust error handling.

## 🏛️ The Architecture

| Layer | Component | Responsibility |
| :--- | :--- | :--- |
| **Presentation** | `UserController` | Handles HTTP, talks to Service. Uses **Constructor Injection**. |
| **Business** | `UserService` | Contains validation rules (e.g., Anti-Scammer logic). Talk to Repo. |
| **Data** | `UserRepository` | Pure interface to communicate with PostgreSQL. |

## 🛠️ Key Improvements

### 1. Constructor Injection (The Pro Way)
Replaced `@Autowired` field injection with Lombok's `@RequiredArgsConstructor`. This makes the classes immutable and easier to unit test.

### 2. Service Layer Logic
Moved logic like searching and deleting out of the Controller. Added validation rules:
- **Rule:** Blocks registration if email contains `@scam.com`.

### 3. Global Exception Handling (`@RestControllerAdvice`)
Instead of `try-catch` blocks in every controller method, I created a global "Safety Net".
- `RuntimeException` in the Service layer -> Auto-converts to `400 Bad Request` JSON response.
- Keeps code clean and readable.

## 🚀 How to Test
1.  **Anti-Scam Check:** Send a POST request with email `test@scam.com`.
    -   *Result:* `400 Bad Request` with message: "Scammer not allowed".
2.  **Valid User:** Send a normal POST.
    -   *Result:* `201 Created`.