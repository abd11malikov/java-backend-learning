# 🕸️ One-to-Many Relationships (User & Posts)

On **Day 17 (Jan 5)**, I expanded the API to be a relational system. Instead of flat data, entities now talk to each other. I implemented a **One-to-Many** relationship where a Single User can author Multiple Posts.

## 💡 Key Features
- **Relational Data:** `User` (Parent) -> `Post` (Child).
- **Deep Nesting:** Fetching a User automatically fetches their "Timeline" of posts in a nested JSON structure.
- **Cascade Delete:** Deleting a User automatically deletes all their posts (Data Integrity).
- **Optimization:** Used `@JsonInclude(JsonInclude.Include.NON_NULL)` to clean up the response by hiding null fields.

## 🛠️ Technical Implementation

### 1. JPA Relationships
I used standard Jakarta Persistence annotations to link the tables:
- **`@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)`**: On the User side.
- **`@ManyToOne`**: On the Post side (Owner of the relationship).

### 2. DTO Strategy (Preventing Recursion)
If I returned the Entities directly, Jackson would loop forever (`User -> Post -> User -> ...`) causing a StackOverflow.
**The Fix:**
- Created `PostRequestDTO` for creating data (using IDs).
- Created `PostResponseDTO` for reading data.
- Manually mapped the lists in `UserService` to control exactly what data is exposed.

## 🚀 API Endpoints

| Method | Endpoint | Description | Payload / Response |
| :--- | :--- | :--- | :--- |
| **POST** | `/api/posts` | Create a new Post | JSON (title, body, userId) |
| **GET** | `/api/users/{id}` | Get User **+ Their Posts** | JSON (User + Array of Posts) |
| **DELETE** | `/api/users/{id}` | Delete User | **Result:** Posts deleted from DB too. |

## 🧪 JSON Result Example
Fetching a user now provides a rich, nested object graph:

```json
{
    "id": 2,
    "username": "tester_otabek",
    "email": "otabek@test.com",
    "posts": [
        {
            "id": 1,
            "title": "Hey",
            "body": "how are you guys"
        },
        {
            "id": 8,
            "title": "java",
            "body": "Hello world"
        }
    ]
}