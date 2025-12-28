# Day 9: Database Relationships (SQL)

## 🎯 Concepts Learned
- **Normalization:** Breaking data into `students` and `grades` to avoid duplication.
- **Foreign Keys:** Linking tables using `REFERENCES students(id)`.
- **Joins:**
    - `INNER JOIN`: Gets overlapping data.
    - `LEFT JOIN`: Gets all parent data + matching child data (or NULL).
- **Cascading Delete:** Automating data cleanup (deleting a Student deletes their Grades).

## 📊 Logic
Calculated average student grades using `GROUP BY` and filtered results using `HAVING`.