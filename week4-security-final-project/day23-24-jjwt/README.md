# 🛡️ Stateless Authentication (Login System)

On **Day 23 (Jan 11)**, I implemented the "Login" flow. I transitioned from creating users manually to authenticating them and issuing JWTs.

## 🔑 The Login Flow
1.  **User sends** `POST /auth/login` (username, password).
2.  **`AuthenticationManager`** checks credentials against the Database.
    *   *Self-Correction:* I updated `DataSeeder` to use `UserService` instead of direct Repository access, ensuring seeded passwords are properly Hashed.
3.  **Success:** `JwtUtil` generates a signed token.
4.  **Response:** The user receives the Token string.

## 🛠️ Components Built
- **`JwtUtil`**: Handles cryptographic signing (HMAC-SHA256).
- **`AuthController`**: Exposure endpoint for login.
- **`UserDetailsServiceImpl`**: Integrated my custom `User` entity with Spring Security's interface.

## 🚀 Status
- Login works! I can trade a password for a token.
- Next Step: Use this token to access protected resources.