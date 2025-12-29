# Day 10: HTTP, JSON & REST

## 1. JSON (JavaScript Object Notation)
- The universal format for exchanging data on the web.
- Unlike Java Objects, it is text-based and language-independent.
- **Rules:**
    - `{}` for Objects.
    - `[]` for Lists (Arrays).
    - Key names must be in "quotes".

## 2. HTTP Methods (Verbs)
| Method | Action | SQL Equivalent |
| :--- | :--- | :--- |
| **GET** | Read data | `SELECT` |
| **POST** | Create data | `INSERT` |
| **PUT** | Update (Replace) | `UPDATE` |
| **PATCH** | Update (Partial) | `UPDATE` |
| **DELETE** | Remove data | `DELETE` |

## 3. Status Codes (The Response)
| Code | Meaning | When to use |
| :--- | :--- | :--- |
| **200** | OK | Request succeeded (GET, PUT). |
| **201** | Created | A new resource was created (POST). |
| **400** | Bad Request | User sent invalid JSON or data. |
| **401** | Unauthorized | User is not logged in. |
| **403** | Forbidden | User is logged in but doesn't have permission. |
| **404** | Not Found | The ID doesn't exist in DB. |
| **500** | Internal Server Error | My backend code crashed (Exception). |

## 4. Tools Used
- **Postman:** To send manual HTTP requests and inspect Responses/Headers.