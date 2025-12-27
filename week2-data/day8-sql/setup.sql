-- 1. Create Users Table
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) UNIQUE,
                       email VARCHAR(100),
                       age INT,
                       is_active BOOLEAN
);

-- 2. Add Test Data
INSERT INTO users (username, email, age, is_active)
VALUES ('otabek_java', 'otabek@gmail.com', 22, true);

INSERT INTO users (username, email, age, is_active)
VALUES ('john_wick', 'john@gmail.com', 40, true);

-- 3. Queries I ran
-- SELECT * FROM users;
-- SELECT * FROM users WHERE age > 25 AND is_active = true;