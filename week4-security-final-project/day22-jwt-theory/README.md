# JWT (JSON Web Token) Theory

Today I explored how stateless authentication works.

## Key Discovery
- I can decode a JWT using online tools (base64).
- If I change the payload (e.g., set `role: admin`), the **Signature** at the bottom changes.
- Since the Hacker doesn't know the Server's Secret Key, they cannot generate a valid Signature for their fake data.
- **Result:** The server rejects the modified token.

## The Plan for Tomorrow
Implement a Java class `JwtUtil` that generates these strings using a secret key only my PC knows.