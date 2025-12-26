# 🚀 TaskFlow (CLI Task Management System)

**TaskFlow** is the capstone project for **Week 1** of my Java Backend journey.
It is a simplified console-based "Issue Tracker" (similar to Jira) that demonstrates how professional software teams manage development tasks.

Unlike a simple "To-Do List", TaskFlow handles different types of work (Bugs vs Features), assigns priorities, and enforces strict business logic.

---

## 🏗️ Technical Architecture
I structured this project using a **Layered Architecture** to mimic real-world backend standards:

- **`model` Package:** Contains the data shapes. I used **Inheritance** (`extends`) to share common logic between `Bug` and `Feature` while keeping their specific differences (e.g., Severity vs Deadline).
- **`service` Package:** Contains the "Business Logic". It handles sorting, finding tasks, and updating status.
- **`exceptions` Package:** Custom error handling for missing resources.

## 🛠️ Key Concepts Applied

| Concept | Usage in Project |
| :--- | :--- |
| **Polymorphism** | Treated `Bug` and `Feature` objects as a generic `Task` to store them in a single List. |
| **Enums** | Used `Priority` and `Status` to restrict inputs (e.g., Type safety instead of random Strings). |
| **Collections** | Used `ArrayList` as an in-memory database to store the task history. |
| **Java Streams** | Used `.filter()`, `.findFirst()`, and `.count()` to generate analytics reports. |
| **Exception Handling** | Implemented a custom `TaskNotFoundException` (Runtime) to handle invalid IDs gracefully. |
| **Comparable** | Implemented `Comparable<Task>` to automatically sort all tasks by **Critical Priority** first. |

---

## 📂 Project Structure

```text
day7-mini-project/
└── src/
    └── taskflow/
        ├── Main.java                 # Entry point (Simulates UI)
        ├── model/                    
        │   ├── Task.java             # Abstract Parent Class
        │   ├── Bug.java              # Child Class (adds Severity)
        │   ├── Feature.java          # Child Class (adds Deadline)
        │   ├── Priority.java         # Enum (LOW, HIGH, CRITICAL)
        │   └── Status.java           # Enum (PENDING, DONE)
        ├── service/
        │   └── TaskService.java      # The Brain (Add, Sort, Statistics)
        └── exceptions/
            └── TaskNotFoundException.java