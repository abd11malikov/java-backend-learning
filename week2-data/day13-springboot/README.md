# Day 13: Introduction to Spring Boot 🍃

## 🎯 Concepts Learned
- **Spring Initializr:** Setting up a production-ready project with dependencies.
- **`@RestController`:** Marking a class to handle web requests.
- **JSON Automation:** How Jackson automatically converts Java Objects (`new User`) into JSON responses.
- **Input Methods:**
    - `@PathVariable`: `GET /hello/{name}` (Clean URLs).
    - `@RequestParam`: `GET /sum?a=50&b=50` (Filtering/Search params).

## 🛠️ Endpoints Built
- `GET /hello` -> Returns string greeting.
- `GET /user` -> Returns a JSON Object.
- `GET /sum` -> specific calculator using query parameters.