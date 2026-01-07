# 🔐 Security Foundations: Password Hashing

On **Day 19 (Jan 7)**, I integrated **Spring Security** into the application.
I transitioned from storing passwords as plain text (security vulnerability) to storing them as irreversible cryptographic hashes using **BCrypt**.

## 🛠️ Technology Stack
- **Spring Security 6:** Core security framework.
- **BCrypt:** Standard hashing algorithm used for password storage.

## ⚙️ Configuration
### 1. Security Config (`SecurityFilterChain`)
By default, adding Spring Security locks the whole app (`401 Unauthorized`).
I configured it to:
- Disable CSRF (to allow Postman POST requests).
- **Allow All** requests (temporarily) so I can verify the hashing logic without implementing a full Login system yet.

### 2. Password Encoder Bean
Configured `BCryptPasswordEncoder` as a Spring Bean so it can be injected into the `UserService`.

## 🧠 Business Logic Changes
Refactored `UserService.java`:
```java
// Before saving to DB:
String rawPassword = dto.getPassword();
String encodedPassword = passwordEncoder.encode(rawPassword);
user.setPassword(encodedPassword);